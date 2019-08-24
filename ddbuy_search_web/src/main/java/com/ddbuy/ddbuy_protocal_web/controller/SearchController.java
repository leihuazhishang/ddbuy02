package com.ddbuy.ddbuy_protocal_web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.ddbuy_protocal_web.util.PageUitl;
import com.ddbuy.service.TbItemSolrService;
import com.ddbuy.util.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author 王建兵
 * @Classname SearchController
 * @Description TODO
 * @Date 2019/7/27 16:12
 * @Created by Administrator
 */
@Controller
public class SearchController {



    //由于导入的数据太多,会引发超时TimeOUTException
    @Reference(interfaceClass = TbItemSolrService.class,timeout = 3000)
    private TbItemSolrService tbItemSolrService;

    @RequestMapping("/import")
    public String importSolr(){
         if(tbItemSolrService.importIndex())
             return "ok";
         else
             return "fail";
    }


    @RequestMapping("/search")
    public String search(String condtition, Integer page, Model model){
        System.out.println("condtion:"+condtition);
        System.out.println("page:"+page);
        //调用业务
        if(condtition==null)
            condtition="*";
        if(page==null) page=1;

        Map<String,Object> map=tbItemSolrService.search(condtition,page);
        System.out.println("condtion:"+condtition);
         System.out.println("page:"+page);
        //填充到页面
        model.addAttribute("info",map);
        model.addAttribute("page",page); //页码
        model.addAttribute("condition",condtition);  //条件
        //生成导航
        //  //int pageIndex 从几开始, int pageCount 总页数, int showPageCount 显示奇数个数的页码
        int toalpage=(int)((Double)map.get("totalPage")).doubleValue();
        String navigationBar=PageUitl.build(page,toalpage,11);
        model.addAttribute("navigationBar",navigationBar);
        return "searchList";
    }


    @RequestMapping("/searchTh")
    public String search2(String condtition, Integer page, Model model){
        //调用业务
        Map<String,Object> map=tbItemSolrService.search(condtition,page==null?1:page);
        //填充到页面
        model.addAttribute("info",map);
        model.addAttribute("page",page); //页码
        model.addAttribute("condition",condtition);  //条件
        //生成导航
        //  //int pageIndex 从几开始, int pageCount 总页数, int showPageCount 显示奇数个数的页码
        int toalpage=(int)((Double)map.get("totalPage")).doubleValue();
        String navigationBar=PageUitl.build(page,toalpage,11);
        model.addAttribute("navigationBar",navigationBar);
        return "list"; //模板文件名称
    }
}
