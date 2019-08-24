package com.ddbuy.util;

import java.util.List;

/**
 * @author 王建兵
 * @Classname EasyDataGridResult
 * @Description TODO
 * @Date 2019/7/20 9:30
 * @Created by Administrator
 */
public class EasyDataGridResult<T> implements java.io.Serializable {

    private Integer total;  //总行数

    private List<T> rows;  //显示的集合数据

    public EasyDataGridResult(){}
    public EasyDataGridResult( List<T> rows) {
        this.rows = rows;
    }
    public EasyDataGridResult(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getList() {
        return rows;
    }

    public void setList(List<T> rows) {
        this.rows = rows;
    }
}
