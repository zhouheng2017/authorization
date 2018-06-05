package com.authorization.controller;

import org.apache.shiro.session.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 22:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:SpringMVC-servlet.xml"})
public class CommonControllerTest {

    @Autowired
    private CommonController commonController;

    @Test
    public void loginJudge() {
        HttpSession session= null;
        commonController.loginJudge("zhouheng2", "1234567", session);
    }
}