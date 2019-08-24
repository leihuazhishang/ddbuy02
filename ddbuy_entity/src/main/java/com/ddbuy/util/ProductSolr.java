package com.ddbuy.util;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author 王建兵
 * @Classname ProductSolr
 * @Description TODO
 * @Date 2019/7/27 15:40
 * @Created by Administrator
 */
public class ProductSolr implements java.io.Serializable {

    @Field(value = "pid")
    private Long pid;
    @Field
    private String image;
    @Field
    private String title;
    @Field
    private Double price;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
