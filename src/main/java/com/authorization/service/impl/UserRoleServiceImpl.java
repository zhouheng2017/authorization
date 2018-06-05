package com.authorization.service.impl;

import com.authorization.dao.UserRoleMapper;
import com.authorization.model.Page;
import com.authorization.model.UserRole;
import com.authorization.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 20:01
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;
    /**
     * get userRole by id
     *
     * @param id
     * @return
     */
    public UserRole getUserRoleById(Integer id) {
        return userRoleMapper.getUserRoleById(id);
    }

    /**
     * 存储userRole
     *
     * @param userRole
     */
    public void saveUserRole(UserRole userRole) {

        userRoleMapper.saveUserRole(userRole);

    }

    /**
     * 删除userRole
     *
     * @param id
     */
    public void deleteUserRole(Integer id) {
        userRoleMapper.deleteUserRole(id);
    }

    /**
     * 更新userRole
     *
     * @param userRole
     */
    public void updateUserRole(UserRole userRole) {

        userRoleMapper.updateUserRole(userRole);

    }

    /**
     * 显示userRole
     *
     * @return
     */
    public List<UserRole> listUserRole() {
        return userRoleMapper.listUserRole();
    }

    /**
     * 带分页的显示
     *
     * @param page
     * @return
     */
    public List<UserRole> listUserRole(Page page) {
        return userRoleMapper.listUserRole(page);
    }

    /**
     * 获得总数
     *
     * @return
     */
    public int total() {
        return userRoleMapper.total();
    }



}
