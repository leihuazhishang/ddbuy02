package com.ddbuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.entity.TbItem;
import com.ddbuy.entity.TbItemExample;
import com.ddbuy.mapper.TbItemMapper;
import com.ddbuy.service.TbItemSolrService;
import com.ddbuy.util.Page;
import com.ddbuy.util.ProductSolr;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname TbItemSolrServiceImpl
 * @Description TODO
 * @Date 2019/7/27 15:58
 * @Created by Administrator
 */
@Service(interfaceClass = TbItemSolrService.class,timeout = 3000)
@Component
public class TbItemSolrServiceImpl implements TbItemSolrService{

    @Value("${solr.pageize}")
    private Integer pageSize;

    @Autowired(required = false)
    private TbItemMapper tbItemMapper;

    @Autowired
    private Configuration configuration;


    @Override
    public boolean importIndex() {
        try {
            //导入索引库
            //调用dao层获取所有记录
            List<ProductSolr> list=tbItemMapper.getProductSolrs();

            //将记录导入索引库
           String solrUrl="http://localhost:8181/solr/";
            //1.创建solr的服务器对象
            HttpSolrClient solr = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
            //3.添加到索引库
           solr.addBeans(list);
            //4.提交
            solr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //搜索服务
    @Override
    public Map<String, Object> search(String condition, Integer page) {
        try {
            //操作solr
            //将记录导入索引库
            String solrUrl="http://localhost:8181/solr/";
            //1.创建solr的服务器对象
            HttpSolrClient solr = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();

            //创建查询条件
            SolrQuery solrQuery=new SolrQuery();
            //设置搜索条件
            solrQuery.set("q","title:"+condition);
            //设置分页
            solrQuery.setStart((page-1)*this.pageSize);
            solrQuery.setRows(this.pageSize); //页大小

            QueryResponse queryResponse=solr.query(solrQuery);
            //获取查询的结果集
            List<ProductSolr> list=queryResponse.getBeans(ProductSolr.class);
            //获取查询的总行数
            long totalRecord=queryResponse.getResults().getNumFound();
            //求总页数
            double totalPage=Math.floor(totalRecord*1.0/pageSize);

            //将结果封装map集合中进行返回
            HashMap<String,Object> map=new HashMap<>();
            map.put("totalPage",totalPage);
            map.put("totalRecord",totalRecord);
            map.put("list",list);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean outProductHtml() {
        try {
            //1.获取所有商品
            List<TbItem> list=tbItemMapper.selectByExample(new TbItemExample());
            //2.利用freemarker生成所有商品的静态页面
            for (TbItem item: list) {
                //商品编号即为文件的名称
                HashMap<String,Object> map=new HashMap<>();
                //设置对象
                map.put("p",item);  //设置某个商品的对象信息

                Template temp= configuration.getTemplate("product.ftl");
                //以classpath下面的static目录作为静态页面的存储目录，同时命名生成的静态html文件名称
                //String path=this.getClass().getResource("/").toURI().getPath()+"static/test.html";
                Writer file = new FileWriter(new File("E:\\IdeaProjects\\ddbuy_parent\\ddbuy_item_web\\src\\main\\webapp\\"+item.getId()+".html"));
                temp.process(map, file);
                file.flush();
                file.close();
            }

            return true;
        }catch (Exception ex){
          ex.printStackTrace();
        }
        return false;
    }


}
