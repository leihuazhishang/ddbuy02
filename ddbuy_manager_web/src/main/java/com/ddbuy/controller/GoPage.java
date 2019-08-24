package com.ddbuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 王建兵
 * @Classname GoPage
 * @Description TODO
 * @Date 2019/7/19 10:58
 * @Created by Administrator
 */
@Controller
public class GoPage {

    @RequestMapping("/goAdmin")
    public String goAdmin(){
        System.out.println("ttttttttttt");
        return "district.jsp";
    }

}
