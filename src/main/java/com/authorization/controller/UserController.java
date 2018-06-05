package com.authorization.controller;

import com.authorization.model.Role;
import com.authorization.model.User;
import com.authorization.service.RoleService;
import com.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-04
 * @Time: 9:05
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/listUsers")
    public String listUsers(Model model) {

        List<Role> roles = roleService.listRole();

        List<User> users = userService.listUser();
        model.addAttribute("users", users);
        model.addAttribute("roles", roles);

        return "listUsers";
    }
}
