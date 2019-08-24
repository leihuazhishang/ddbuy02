package com.ddbuy;

import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.service.TbUserService;
import com.ddbuy.service.impl.TbContentCategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DdbuyCommonServiceApplicationTests {

    @Autowired
    private TbUserService tbUserService;


    @Test
    public void testLogin(){
         String token=this.tbUserService.login("wjb","123");
         System.out.println(token);
         System.out.println("=====================");
        String token1=this.tbUserService.login("zhangsan1","1239");
        System.out.println(token1);
        System.out.println("=====================");
        String token2=this.tbUserService.login("zhangsan2","123");
        System.out.println(token2);
        System.out.println("=====================");
        String token3=this.tbUserService.login("zhangsan3","123");
        System.out.println(token3);
        System.out.println("=====================");
    }

}
