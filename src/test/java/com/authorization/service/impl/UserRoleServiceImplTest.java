package com.authorization.service.impl;

import com.authorization.model.Page;
import com.authorization.model.UserRole;
import com.authorization.service.UserRoleService;
import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
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
 * @Time: 20:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:SpringMVC-servlet.xml"})
public class UserRoleServiceImplTest {

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void getUserRoleById() {
        UserRole userRoleById = userRoleService.getUserRoleById(3);
        System.out.println(userRoleById);

    }

    @Test
    public void saveUserRole() {
        UserRole userRole = new UserRole(1, 2);
        userRoleService.saveUserRole(userRole);

    }

    @Test
    public void deleteUserRole() {
        userRoleService.deleteUserRole(4);

    }

    @Test
    public void updateUserRole() {
        UserRole userRole = new UserRole(2, 2);
        userRoleService.updateUserRole(userRole);
        getUserRoleById();

    }

    @Test
    public void listUserRole() {
        List<UserRole> userRoles = userRoleService.listUserRole();
        for (UserRole userRole :
                userRoles) {
            System.out.println(userRole);

        }
    }

    @Test
    public void listUserRole1() {
        Page page = new Page();
        List<UserRole> userRoles = userRoleService.listUserRole(page);
        for (UserRole userRole :
                userRoles) {
            System.out.println(userRole);

        }

    }

    @Test
    public void total() {
        int total = userRoleService.total();
        System.out.println(total);

    }
}