package com.ddbuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.entity.TbContent;
import com.ddbuy.entity.TbContentExample;
import com.ddbuy.mapper.TbContentMapper;
import com.ddbuy.service.TbConentService;
import com.ddbuy.service.TbContetnCategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 王建兵
 * @Classname TbConentServiceImpl
 * @Description TODO
 * @Date 2019/7/22 16:07
 * @Created by Administrator
 */
@Service(interfaceClass = TbConentService.class)
@Component
public class TbConentServiceImpl implements TbConentService {

     @Autowired
     private RedisTemplate redisTemplate;

     @Autowired(required = false)
     private TbContentMapper tbContentMapper;

    @Override
    public int addContent(TbContent content) {
        try {
            //添加数据到数据库中.
            int temp=tbContentMapper.insertSelective(content);

            //清空缓存-->重新设置缓存
            if(this.redisTemplate.hasKey("contentkey")){  //存在
                //清空缓存
                this.redisTemplate.delete("contentkey");
                //保存缓存
                List<TbContent> list=this.getTbContent();
                this.redisTemplate.opsForValue().set("contentkey",this.redisTemplate.getValueSerializer().serialize(list),1,TimeUnit.DAYS);  //1天
            }
            return temp;
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public List<TbContent> getAllTbContent() {
        //添加缓存支持
        //1.判断缓存是否存在广告的键
         //   如果没有:则查询数据、将查询结果保存到缓存Redis中
        //    如果有:则只接提取缓存
        //2.springboot整合Redis
        //List<TbContent> list=null;
        ValueOperations<String,byte[]>  option=this.redisTemplate.opsForValue();
        if(this.redisTemplate.hasKey("contentkey")){ //存在
            System.out.println("从缓中取.....");
            List<TbContent> list=(List<TbContent>)this.redisTemplate.getDefaultSerializer().deserialize(option.get("contentkey"));
           return list;  //通过键取值
        }else{ //不存在
            System.out.println("查询数据库");
            //2.将集合保存到Redis中
            List<TbContent> list=this.getTbContent();
            option.set("contentkey",this.redisTemplate.getValueSerializer().serialize(list),1,TimeUnit.DAYS);  //1天
            return list;
        }
    }


    //从数据库中查询所有广告
    public List<TbContent> getTbContent(){
        //1.查询数据获取广告
        TbContentExample example=new TbContentExample();
        TbContentExample.Criteria criteria=example.createCriteria();
        //设置广告的状态
        criteria.andStatusEqualTo("1");
        List<TbContent> list =tbContentMapper.selectByExample(example);
        return list;
    }
}
