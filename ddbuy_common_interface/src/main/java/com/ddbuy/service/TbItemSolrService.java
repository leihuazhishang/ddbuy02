package com.ddbuy.service;

import com.ddbuy.util.Page;

import java.util.Map;

/**
 * @author 王建兵
 * @Classname TbItemSolrService
 * @Description TODO
 * @Date 2019/7/27 15:57
 * @Created by Administrator
 */
public interface TbItemSolrService {
    //导入索引
    public boolean importIndex();

    //搜索服务

    /**
     *
     * @param condition  查询条件
     * @param page  页码
     * @return map  包含:总页数、当前页的记录
     */
    public Map<String,Object> search(String condition,Integer page);




    //生成所有商品的静态页面
    public boolean outProductHtml();


}

