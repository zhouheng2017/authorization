package com.authorization.service;

import com.authorization.model.Page;
import com.authorization.model.Role;
import com.authorization.model.User;
import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 15:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:SpringMVC-servlet.xml"})
public class UserServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void getUserById() {
        User user = userService.getUserById(1);
        System.out.println(user + "--------------------------------------");
    }

    @Test
    public void saveUser() {
        User user = new User(2, "zhouheng", "123456", "15893883880@163.com", "15893883880");

        userService.saveUser(user);
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(2);
        User userById = userService.getUserById(2);
        System.out.println(userById + "+++++++++++++++++++++++++++++++++++");

    }

    @Test
    public void updateUser() {
        User user = new User(1, "zhouheng2", "1234567", "15893883880@163.com", "15893883880");
        userService.updateUser(user);
        User userById = userService.getUserById(1);

        System.out.println(userById + "+++++++++++++++++++++++++++++++++++");
    }

    @Test
    public void listUser() {
        List<User> users = userService.listUser();
        for (User user :
                users) {
            System.out.println(user);
//            logger.error("={}", user);
        }
    }

    @Test
    public void listUser1() {
        Page page = new Page();
        List<User> users = userService.listUser(page);
        for (User user :
                users) {
            System.out.println(user);
        }
    }

    @Test
    public void total() {
    }

    @Test
    public void getRoleByUserId() {
        List<Role> roleByUserId = userService.getRoleByUserId(1);

        for (Role role :
                roleByUserId) {
            System.out.println(role);

        }
    }

    @Test
    public void testGetUserByName() {
        User zhouheng = userService.getUserByName("zhouheng");
        System.out.println(zhouheng);

    }
}