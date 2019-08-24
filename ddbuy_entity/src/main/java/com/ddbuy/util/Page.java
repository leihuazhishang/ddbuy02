package com.ddbuy.util;

/**
 * @author 王建兵
 * @Classname Page
 * @Description TODO
 * @Date 2019/7/20 9:12
 * @Created by Administrator
 */
public class Page implements  java.io.Serializable {

    //添加属性
    private Integer page=1;  //页码
    private Integer rows=3;  //页大小

    public Page(){}
    public Page(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
