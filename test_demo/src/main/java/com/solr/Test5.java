package com.solr;

import com.solr.entity.Student;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王建兵
 * @Classname Test1
 * @Description TODO
 * @Date 2019/7/27 13:46
 * @Created by Administrator
 */
public class Test5 {
    //添加索引
    //以JavaBean的方式实现批量添加
    public static void main(String[] args) {
        try {
            String solrUrl="http://localhost:8181/solr/";
            //1.创建solr的服务器对象
            HttpSolrClient solr = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
            //2.创建JavaBean对象  相当于一行
            List<Student> list=new ArrayList<>();
            list.add(new Student(207,"是小王","女",18));
            list.add(new Student(206,"小王吧","女",18));
            list.add(new Student(203,"大王","女",18));
            list.add(new Student(204,"王炸","女",18));

            //3.添加到索引库
            solr.addBeans(list);
            //4.提交
            solr.commit();
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
