package com.ddbuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.entity.TbUser;
import com.ddbuy.entity.TbUserExample;
import com.ddbuy.mapper.TbUserMapper;
import com.ddbuy.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 王建兵
 * @Classname TbUserServiceImpl
 * @Description TODO
 * @Date 2019/7/31 15:43
 * @Created by Administrator
 */
@Service(interfaceClass = TbUserService.class)
@Component
public class TbUserServiceImpl implements TbUserService {

    @Autowired(required = false)
    private TbUserMapper tbUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String login(String username, String password) {
        String token=null;
        //1.判断用户是否存在
        TbUserExample tbUserExample=new TbUserExample();
        TbUserExample.Criteria criteria=tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(username); //设置用户名
        criteria.andPasswordEqualTo(password); //设置密码
        List<TbUser> list=tbUserMapper.selectByExample(tbUserExample);
        if(list.size()!=0){ //存在用户
            // 2.创建token==使用UUID
            token=UUID.randomUUID().toString();
            //3.将用户者的信息保存到Redis
           ValueOperations<String,TbUser> option=redisTemplate.opsForValue();
           //option.set("名称",值，时间，时间类型);
            option.set("sessionkey:"+token,list.get(0),20,TimeUnit.MINUTES);
        }
        return token;
    }

    @Override
    public String getUserName(String token) {
        if(redisTemplate.hasKey("sessionkey:"+token)){
            //存在
            ValueOperations<String,TbUser> option=redisTemplate.opsForValue();
            TbUser tbUser=(TbUser) option.get("sessionkey:"+token);
            return tbUser.getUsername();
        }else{
            return null;
        }
    }
}
