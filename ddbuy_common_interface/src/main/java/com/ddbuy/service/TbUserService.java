package com.ddbuy.service;

/**
 * @author 王建兵
 * @Classname TbUserService
 * @Description TODO
 * @Date 2019/7/31 15:36
 * @Created by Administrator
 */
public interface TbUserService {

    /**
     * //登入功能
     * @param username 用户名
     * @param password 密码
     * @return  返回token   随机生成的标识
     */
    public  String login(String username,String password);

    /**
     * 获取用户名
     * @param token
     * @return  用户名
     */
    public String getUserName(String token);
}
