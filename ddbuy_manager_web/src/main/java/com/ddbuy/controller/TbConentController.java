package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContent;
import com.ddbuy.service.TbConentService;
import com.ddbuy.service.TbContetnCategroyService;
import com.ddbuy.util.FastDfsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 王建兵
 * @Classname TbConentController
 * @Description TODO
 * @Date 2019/7/22 16:11
 * @Created by Administrator
 */
@RestController
public class TbConentController {
    //接收配置文件中的值   使用${}引用属性文件中的键
    @Value("${nginx.fastdfs.address}")
    private String nginx_FastDfs_address;

    //发起远程调用， 调用服务
    @Reference(interfaceClass = TbConentService.class)
    private TbConentService tbConentService;


    //添加广告的接口  //json
    @RequestMapping(value="/addContent",produces = "application/json")
    public String addContent(TbContent content, @RequestParam("file")MultipartFile file){
        try {
               //第一件事件实现文件上传:spring实现文件上传,放到fastdfs
              String fileName=file.getOriginalFilename();  //上传文件名称
              String extname=fileName.substring(fileName.lastIndexOf(".")+1); //扩展名
              //上传文件
              String args[]=FastDfsUtil.uploadFile(file.getBytes(),extname);

             //第二件事件将信息添加到数据库
             if(args!=null){
                 //将信息追加到数所库
                 //设置图片的路径
                String path=nginx_FastDfs_address+"/"+args[0]+"/"+args[1];
                content.setPic(path);
                //保存数据库
                 tbConentService.addContent(content);
             }
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"result\":0}";
        }
        return "{\"result\":1}";
    }
}
