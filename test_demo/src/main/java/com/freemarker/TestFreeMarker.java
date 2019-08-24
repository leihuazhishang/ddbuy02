package com.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname TestFreeMarker
 * @Description TODO
 * @Date 2019/7/30 14:50
 * @Created by Administrator
 */
public class TestFreeMarker {
    public static void main(String[] args) throws IOException, TemplateException {
        //生成静页面的步骤:
        //1.创建Configuration对象
        Configuration configuration=new Configuration(Configuration.getVersion());
        //2.设置相关的参数
        //设置字符集
        configuration.setDefaultEncoding("utf-8");
        //设置模板文件的位置
        File file=new File("E:\\IdeaProjects\\ddbuy_parent\\test_demo\\src\\main\\resources");
        configuration.setDirectoryForTemplateLoading(file);
        //3.创建模板对象
        Template template=configuration.getTemplate("first.ftl");

        //4.创建模板中的模型数据
        Map<String,Object> hashMap=new HashMap<>();
        //hashMap.put("title","我的第一个静态网页");
        //hashMap.put("content","我会实现页面静态化啦，只是数据量小了");
        hashMap.put("info",new Info("ddddd","tttttttttttttttttttt"));
        hashMap.put("names",Arrays.asList("张三","李四","麻子","哈儿"));

        //5.定义目标网页的路径
        Writer w=new FileWriter("E:\\IdeaProjects\\ddbuy_parent\\test_demo\\src\\main\\resources\\first.html");

        //6.调用模板对象的process方法输出网页
        template.process(hashMap,w);  //生成

        w.close(); //关闭流
        System.out.println("生成成功");
    }
}
