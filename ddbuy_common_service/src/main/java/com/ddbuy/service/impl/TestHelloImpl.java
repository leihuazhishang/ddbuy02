package com.ddbuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.service.TestHello;
import org.springframework.stereotype.Component;

/**
 * @author 王建兵
 * @Classname TestHelloImpl
 * @Description TODO
 * @Date 2019/7/17 11:55
 * @Created by Administrator
 */
@Component
@Service(interfaceClass = TestHello.class)
public class TestHelloImpl implements TestHello {

    @Override
    public String getHw() {
        return "helloword";
    }
}
