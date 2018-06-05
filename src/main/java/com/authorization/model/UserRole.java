package com.authorization.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 12:56
 */
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userRoleId;

    /**
     * 用户的id
     */
    private Integer userId;

    /**
     * 角色的id
     */
    private Integer roleId;


    public UserRole() {
    }

    public UserRole(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", userId=" + userId +
                ", roleId=" + roleId+
                '}';
    }
}
