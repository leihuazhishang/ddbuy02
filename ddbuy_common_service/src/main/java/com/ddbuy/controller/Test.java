package com.ddbuy.controller;

import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.entity.TbContentCategoryExample;
import com.ddbuy.service.TbContetnCategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 王建兵
 * @Classname Test
 * @Description TODO
 * @Date 2019/7/19 10:33
 * @Created by Administrator
 */
@Controller
public class Test {
    @Autowired
    private TbContetnCategroyService tbContetnCategroyService;


}
