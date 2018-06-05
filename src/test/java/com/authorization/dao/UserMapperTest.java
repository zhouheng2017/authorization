package com.authorization.dao;

import com.authorization.model.Role;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.Test;
import org.junit.runner.RunWith;
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
 * @Time: 17:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:SpringMVC-servlet.xml"})
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getRoleByUserId() {
        List<Role> roleByUserId = userMapper.getRoleByUserId(1);
        System.out.println(roleByUserId);
    }
}