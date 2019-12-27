package com.gdou.test;

import com.gdou.controller.BasicController;
import com.gdou.domain.User;
import com.gdou.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserTest(){
        User user = userService.getUserByUserNameAndPassword("admin","e10adc3949ba59abbe56e057f20f883e");
        System.out.println(user);
    }

}
