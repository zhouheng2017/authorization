package com.authorization.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 12:49
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleId;

    /**
     * 中文名称，管理员，超级管理员
     */
    private String title;

    /**
     * 角色名称admin，superadmin
     */
    private String roleName;

    private Date createTime;

    private Date modifyTime;

    private List<User> users;

    public Role() {
    }

    public Role(Integer roleId, String title, String roleName) {
        this.roleId = roleId;
        this.title = title;
        this.roleName = roleName;
    }


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", title='" + title + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", users=" + users +
                '}';
    }
}
