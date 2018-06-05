package com.authorization.controller;

import com.authorization.model.Role;
import com.authorization.model.User;
import com.authorization.service.RoleService;
import com.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 21:00
 */
@Controller
@RequestMapping("/user")
public class CommonController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/judge", method = RequestMethod.POST)
    public ModelAndView loginJudge(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        User user = userService.getUserByName(username);

        session.setAttribute("user", user);
        ModelAndView modelAndView = new ModelAndView();
        if (user!=null && user.getPassword().equals(password)) {
            List<Role> roles = roleService.getRoleByUserId(user.getUserId());

            modelAndView.addObject("username", username);
            modelAndView.addObject("roles", roles);
            session.setAttribute("roles", roles);
            modelAndView.setViewName("index");

            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/user/login");
            return modelAndView;
        }

    }


}
