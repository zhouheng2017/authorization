package com.authorization.service;

import com.authorization.model.Page;
import com.authorization.model.Role;
import com.authorization.model.User;
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
 * @Time: 15:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:SpringMVC-servlet.xml"})
public class RoleServiceTest {

    @Autowired
    RoleService roleService;

    @Test
    public void getRoleById() {
        Role roleById = roleService.getRoleById(1);
        System.out.println(roleById+"------------------------------");

    }

    @Test
    public void saveRole() {
        Role role = new Role(2, "管理员", "admin");
        roleService.saveRole(role);
    }

    @Test
    public void deleteRole() {
        roleService.deleteRole(2);
        Role userById = roleService.getRoleById(2);
        System.out.println(userById + "+++++++++++++++++++++++++++++++++++");
    }

    @Test
    public void updateRole() {
        Role role = new Role(1, "管理员222", "admin2");
        roleService.updateRole(role);
        Role userById = roleService.getRoleById(1);
        System.out.println(userById);
    }

    @Test
    public void listRole() {
        List<Role> roles = roleService.listRole();
        for (Role ro :
                roles) {
            System.out.println(ro);
        }
    }

    @Test
    public void listRole1() {

        Page page = new Page();
        List<Role> roles = roleService.listRole(page);

        for (Role role :
                roles) {
            System.out.println(role);
        }
    }

    @Test
    public void total() {
    }

    @Test
    public void getRoleByUserId() {
        List<Role> roleByUserId = roleService.getRoleByUserId(1);
        for (Role r :
                roleByUserId) {
            System.out.println(r);
            
        }
    }
}