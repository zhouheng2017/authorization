package com.authorization.controller;

import com.authorization.model.Role;
import com.authorization.service.RoleService;
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
 * @Time: 9:24
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/listRoles")
    public String listRoles(Model model) {
        List<Role> roles = roleService.listRole();

        model.addAttribute("roles", roles);
        return "listRoles";
    }
}
