package com.ddbuy.service;

import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.util.EasyDataGridResult;
import com.ddbuy.util.Page;

import java.util.List;

/**
 * @author 王建兵
 * @Classname TbContetnCategroyService
 * @Description TODO
 * @Date 2019/7/19 10:06
 * @Created by Administrator
 */
public interface TbContetnCategroyService {
    //public PageInfo<TbContentCategory> getAllTbContentCategory(Page page);
    public EasyDataGridResult<TbContentCategory> getAllTbContentCategory(Page page);
    public EasyDataGridResult<TbContentCategory> getAllTbContentCategory();


}
