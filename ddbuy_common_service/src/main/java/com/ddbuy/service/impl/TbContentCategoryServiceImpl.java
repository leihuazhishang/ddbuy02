package com.ddbuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.entity.TbContentCategoryExample;
import com.ddbuy.mapper.TbContentCategoryMapper;
import com.ddbuy.mapper.TbContentMapper;

import com.ddbuy.service.TbContetnCategroyService;

import com.ddbuy.util.EasyDataGridResult;
import com.ddbuy.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 王建兵
 * @Classname TbContentCategoryServiceImpl
 * @Description TODO
 * @Date 2019/7/19 9:59
 * @Created by Administrator
 */
@Service(interfaceClass = TbContetnCategroyService.class)
@Component
public class TbContentCategoryServiceImpl implements TbContetnCategroyService {



    @Autowired(required = false)
    private TbContentCategoryMapper  tbContentCategoryMapper;

    /*@Override
    public PageInfo<TbContentCategory> getAllTbContentCategory(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        List<TbContentCategory> list=tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
        return new PageInfo<>(list);
    }*/

    @Override
    public EasyDataGridResult<TbContentCategory> getAllTbContentCategory(Page page) {
        //开启分页
        PageHelper.startPage(page.getPage(),page.getRows());
        //查询所有
        List<TbContentCategory> list=tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
        //获取分页信息
        PageInfo<TbContentCategory> pageInfo=new PageInfo<>(list);
        //返回结果
        return new EasyDataGridResult<TbContentCategory>(new Integer(pageInfo.getTotal()+""),pageInfo.getList());
    }

    @Override
    public EasyDataGridResult<TbContentCategory> getAllTbContentCategory() {
        List<TbContentCategory> list=tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
        return new EasyDataGridResult<>(list);
    }


}