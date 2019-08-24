package com.ddbuy.ddbuy_protocal_web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContent;
import com.ddbuy.service.TbConentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 王建兵
 * @Classname TbContentController
 * @Description TODO
 * @Date 2019/7/24 15:45
 * @Created by Administrator
 */
@Controller
public class TbContentController {

    @Reference(interfaceClass =TbConentService.class)
    private TbConentService tbConentService;

    @RequestMapping("/goIndex")
    public String goIndex(Model model){
        //查询分类  == >调用服务
        //查询广告  == >调用服务
        List<TbContent> list=tbConentService.getAllTbContent();
        //查询商品  == >调用服务
        //..
        model.addAttribute("list",list);
        return "Index";
    }

}
