package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @author 王建兵
 * @Classname TestRedis
 * @Description TODO
 * @Date 2019/7/24 13:49
 * @Created by Administrator
 */
public class TestRedis2 {

    //操作list类型
    public static void main(String[] args) throws InterruptedException {
        //1.创建Jedis对象
        Jedis jedis=new Jedis("localhost",6379);
        //2.通过jedis对象操作redis键值对系统
        if(jedis.exists("names"))
            jedis.del("names");

        jedis.lpush("names","杨过","小龙女","郭靖");
        //获取长度
        long len=jedis.llen("names");
        System.out.println("获取长度:"+len);
        System.out.println("取值:"+jedis.lindex("names",0));
        for (int i=0;i<len;i++){
            System.out.println(jedis.lindex("names",i));
        }
        //3.关闭
        jedis.close();
    }
}
