package com.redis;

import com.solr.entity.Student;
import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @author 王建兵
 * @Classname TestRedis
 * @Description TODO
 * @Date 2019/7/24 13:49
 * @Created by Administrator
 */
public class TestRedis3 {

    //操作字符串
    public static void main(String[] args) throws InterruptedException {
        //1.创建Jedis对象
        Jedis jedis=new Jedis("localhost",6379);
        //2.通过jedis对象操作redis键值对系统
        //设置键值
       //jedis.set("name","张三");
        //设置有效期
        //jedis.expire("name",60);

        //Thread.sleep(10000);  //暂停10秒
        //获取余下时间
        //System.out.println(jedis.ttl("name"));
        //获取值
        //String value=jedis.get("name");
        /*for (int i=1;i<=20;i++) {
            String token = UUID.randomUUID().toString();
            jedis.set("session_key:" + token, new Student(i, "ss", "sex", 21).toString());
            jedis.expire("session_key:" + token, 1200);
        }*/
        System.out.println("获取值是:"+jedis.get("session_key:02accdd7-883f-410e-9710-89d1436048e4"));
        //3.关闭
        jedis.close();
        System.out.println("成功");
    }
}
