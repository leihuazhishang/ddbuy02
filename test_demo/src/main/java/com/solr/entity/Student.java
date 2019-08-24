package com.solr.entity;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author 王建兵
 * @Classname Student
 * @Description TODO
 * @Date 2019/7/27 14:32
 * @Created by Administrator
 */
public class Student {
    @Field
    private Integer xh;
    @Field
    private String name;
    @Field
    private String sex;
    @Field
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "xh=" + xh +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }

    public Student(Integer xh, String name, String sex, Integer age) {
        this.xh = xh;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
