package com.ddbuy.ddbuy_sso_web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname TbSsoController
 * @Description TODO
 * @Date 2019/7/31 16:10
 * @Created by Administrator
 */
@Controller
public class TbSsoController {

    @Reference(interfaceClass = TbUserService.class)
    private TbUserService tbUserService;


    @RequestMapping("/login")
    public String login(String username, String password, HttpServletResponse response){
        //调用业务
        String token=tbUserService.login(username,password);
        if(token==null){
             //跳转到注册页  或 登入页
            return "Login";  //登入页
        }else{
            //将token写入客户端保存===>cookie
            Cookie cookie=new Cookie("token",token);
            cookie.setMaxAge(1200); //秒 20分钟
            cookie.setPath("/");  //解决cookie跨域
            response.addCookie(cookie);
            System.out.println("写入cooke到客户端成功");
            return "redirect:main.jsp";
        }
    }


    @RequestMapping("/getUsername")
    @ResponseBody
    @CrossOrigin   //添加此注解，支持跨域获取数据
    public Map<String,String> login(String token){
         Map<String,String> map=new HashMap<>();
        //调用业务
         String str=tbUserService.getUserName(token);
         if(str==null){
             map.put("result","");
         }else
             map.put("result",str);
         return map;
    }

}
