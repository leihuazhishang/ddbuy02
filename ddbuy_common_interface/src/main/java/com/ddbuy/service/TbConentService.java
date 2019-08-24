package com.ddbuy.service;

import com.ddbuy.entity.TbContent;

import java.util.List;

/**
 * @author 王建兵
 * @Classname TbConentService
        * @Description TODO
        * @Date 2019/7/22 16:05
        * @Created by Administrator
        */
public interface TbConentService {
    //添加广告
    public int addContent(TbContent content);

    //查询门户广告别的业务
    /**
     * 什么页面下的广告  1  2  3
     * @return
     */
    public List<TbContent> getAllTbContent();
}
