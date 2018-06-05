package com.authorization.controller;

import com.authorization.dto.AttributeValueDTO;
import com.authorization.model.Role;
import com.authorization.model.UserRole;
import com.authorization.service.RoleService;
import com.authorization.service.UserRoleService;
import com.authorization.xacml.pdp.SimplePDP;
import com.authorization.xacml.request.AccessPolicyEnforcementPoint;
import com.authorization.xacml.response.Response;
import com.sun.xacml.ctx.RequestCtx;
import com.sun.xacml.ctx.ResponseCtx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

import javax.servlet.http.HttpSession;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-04
 * @Time: 10:33
 */
@Controller
@RequestMapping("/authorization")
public class Authorization {
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/role/{userId}")
    public String authorization(@PathVariable("userId") Integer userId, @RequestParam("AuthorizationRole") String[] roleIds) {

        UserRole userRole;


        for (String roleId : roleIds
                ) {


            userRole = new UserRole(userId, Integer.parseInt(roleId));
            userRoleService.saveUserRole(userRole);

        }

        return "redirect:/user/login";
    }


    /**
     * 构建请求参数，并且获取评估，得到评估结果
     *
     * @param role
     * @param session
     * @return
     */
    @RequestMapping("/request/{userId}/{role}")
    public String employee(Model model, @PathVariable("userId") Integer userId, @PathVariable("role") String role, HttpSession session) {
        List<Role> roles = roleService.getRoleByUserId(userId);
        String roleString = "";
        for (Role rol :
                roles) {

            if (rol.getRoleName().equals(role)) {
                roleString = rol.getRoleName();
            }

        }


        AttributeValueDTO attributeValueDTO = (AttributeValueDTO) session.getAttribute("attributeValueDTO");
        attributeValueDTO.setRole(roleString);
        if (attributeValueDTO.getRole().equals("manager")) {
            attributeValueDTO.setActionValue("read:2-3");

        }
        if (attributeValueDTO.getRole().equals("ceo")) {
            attributeValueDTO.setActionValue("read:4-7");

        }

        System.out.println(attributeValueDTO);

        System.out.println("Role----"+attributeValueDTO.getRole() + "----Role");
//        String[] policyFile = {"E:\\maven\\workspace\\java2\\authorization\\src\\main\\resources\\EmployeePolicy\\UserECOPolicy.xml",
//                "E:\\maven\\workspace\\java2\\authorization\\src\\main\\resources\\EmployeePolicy\\UserEmployeePolicy.xml",
//                "E:\\maven\\workspace\\java2\\authorization\\src\\main\\resources\\EmployeePolicy\\UserManagerPolicy.xml"
//        };
        String[] policyFile = {
                "E:\\maven\\workspace\\java2\\authorization\\src\\main\\resources\\EmployeePolicy\\UserEmployeePolicy.xml",
                "E:\\maven\\workspace\\java2\\authorization\\src\\main\\resources\\EmployeePolicy\\UserManagerPolicy.xml",
                "E:\\maven\\workspace\\java2\\authorization\\src\\main\\resources\\EmployeePolicy\\UserECOPolicy.xml"
        };

        ResponseCtx result = null;
        try {
            RequestCtx request = AccessPolicyEnforcementPoint.getRequest(attributeValueDTO);
            SimplePDP simplePDP = new SimplePDP(policyFile);
            result = simplePDP.getResult(request);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Response response = new Response(result);
        String[] decision = response.getDecision();
        String responseStream = response.getResponse();
        System.out.println(responseStream);

        model.addAttribute("decision", decision[0]);
        model.addAttribute("request", responseStream);
        model.addAttribute("attributeValueDTO", attributeValueDTO);
//        session.invalidate();
        return "authorization";
    }
}
