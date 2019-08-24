package com.ddbuy.ddbuy_protocal_web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.service.TbItemSolrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 王建兵
 * @Classname TbItemController
 * @Description TODO
 * @Date 2019/7/30 16:11
 * @Created by Administrator
 */
@Controller
public class TbItemController {

    @Reference(interfaceClass = TbItemSolrService.class,timeout = 10000)
    private TbItemSolrService tbItemSolrService;


    @RequestMapping("/outProductHtml")
    @ResponseBody
    public  String outProductHtml(){
       if(tbItemSolrService.outProductHtml())
           return "ok";
       else
            return "fail";
    }

}
