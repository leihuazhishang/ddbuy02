package com.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

/**
 * @author 王建兵
 * @Classname Test1
 * @Description TODO
 * @Date 2019/7/27 13:46
 * @Created by Administrator
 */
public class Test2 {
    //删除索引
    //以document方式添加
    public static void main(String[] args) {
        try {
            String solrUrl="http://localhost:8181/solr/";
            //1.创建solr的服务器对象
            HttpSolrClient solr = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
            //2.执行删除
             solr.deleteByQuery("xh:201");
            //3.提交
            solr.commit();
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
