package com.gdou.test;

import com.gdou.domain.User;
import com.gdou.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        List<User> users = userService.getUserByUserNameAndPassword("admin","e10adc3949ba59abbe56e057f20f883e");
        User user = null;
        if (users != null){
            user = users.get(0);
        }
        System.out.println(user.getIdcardname()+user.getIdcardnumber());
    }

}
