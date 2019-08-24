package com.solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

/**
 * @author 王建兵
 * @Classname Test1
 * @Description TODO
 * @Date 2019/7/27 13:46
 * @Created by Administrator
 */
public class Test1 {
    //添加索引
    //以document方式添加
    public static void main(String[] args) {
        try {
            String solrUrl="http://localhost:8181/solr/";
            //1.创建solr的服务器对象
            HttpSolrClient solr = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
            //2.创建solrinputdocment对象  相当于一行
            SolrInputDocument document=new SolrInputDocument();
            document.addField("xh",201);
            document.addField("name","小刘");
            document.addField("sex","女");
            document.addField("age",21);
            //3.添加到索引库
            solr.add(document);
            //4.提交
            solr.commit();
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
