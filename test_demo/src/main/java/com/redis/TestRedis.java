package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @author 王建兵
 * @Classname TestRedis
 * @Description TODO
 * @Date 2019/7/24 13:49
 * @Created by Administrator
 */
public class TestRedis {

    //操作字符串
    public static void main(String[] args) throws InterruptedException {
        //1.创建Jedis对象
        Jedis jedis=new Jedis("localhost",6379);
        //2.通过jedis对象操作redis键值对系统
        //设置键值
        jedis.set("name","张三");
        //设置有效期
        jedis.expire("name",60);

        Thread.sleep(10000);  //暂停10秒
        //获取余下时间
        System.out.println(jedis.ttl("name"));
        //获取值
        String value=jedis.get("name");
        System.out.println("获取值是:"+value);
        //3.关闭
        jedis.close();
    }
}
