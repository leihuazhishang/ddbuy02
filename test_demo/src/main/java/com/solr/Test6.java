package com.solr;

import com.solr.entity.Student;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.SolrParams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 王建兵
 * @Classname Test1
 * @Description TODO
 * @Date 2019/7/27 13:46
 * @Created by Administrator
 */
public class Test6 {
    //执行查询
    public static void main(String[] args) {
        try {
            String solrUrl="http://localhost:8181/solr/";
            //1.创建solr的服务器对象
            HttpSolrClient solr = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
            //2.执行查询
            //创建SolrQuery对象
            SolrQuery query=new SolrQuery();
            //设置查询条件
            query.set("q","*:*");  //指定搜索条件

            //参数sort,设置返回结果的排序规则
            query.setSort("age",SolrQuery.ORDER.desc);

            //设置分页参数
            //query.setStart(3);  //开始位置   (页码-1)*页大小
            //query.setRows(3);  //页大小

            //执行查询
            QueryResponse queryResponse=solr.query(query);
             //获取查询的结果
            //List<Student> list=queryResponse.getBeans(Student.class);

            //显示
            //for (Student s:list ) {
              //  System.out.println(s.toString());
            //}
           // System.out.println(list.size());
            System.out.println(queryResponse.getResults().getNumFound());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
