package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.service.TestHello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname TestC
 * @Description TODO
 * @Date 2019/7/17 12:01
 * @Created by Administrator
 */
@Controller
public class TestC {

    @Reference(interfaceClass = TestHello.class)
    private TestHello testHello;

   @RequestMapping("/getHw")
    @ResponseBody
    public String getHw(){
       return testHello.getHw();
   }

}
