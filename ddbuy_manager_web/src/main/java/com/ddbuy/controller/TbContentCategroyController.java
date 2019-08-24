package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.service.TbContetnCategroyService;
import com.ddbuy.util.EasyDataGridResult;
import com.ddbuy.util.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname TbContentCategroyController
 * @Description TODO
 * @Date 2019/7/19 10:44
 * @Created by Administrator
 */
@RestController   //后台控制 返回异步数据
public class TbContentCategroyController {
    //发起远程调用， 调用服务
    @Reference(interfaceClass = TbContetnCategroyService.class)
    private TbContetnCategroyService tbContetnCategroyService;


    @RequestMapping("/getContentCategory")
    //page接收页码和页大小
    public Map<String,Object> getContentCategory(Page page){
        EasyDataGridResult<TbContentCategory> pageInfo=tbContetnCategroyService.getAllTbContentCategory(page);
        //方式一:传统做法:将数据填 充作用域，采用el+jstl展示
        //方式二;结合前端框架绑定数据
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    @RequestMapping("/getAllContentCategory")
    //page接收页码和页大小
    public List<TbContentCategory> getAllContentCategory(){
        EasyDataGridResult<TbContentCategory> pageInfo=tbContetnCategroyService.getAllTbContentCategory();
        return pageInfo.getList();
    }
}
