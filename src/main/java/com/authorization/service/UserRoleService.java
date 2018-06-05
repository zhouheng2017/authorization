package com.authorization.service;

import com.authorization.model.Page;
import com.authorization.model.UserRole;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 12:43
 */
public interface UserRoleService {

    /**
     * get userRole by id
     *
     * @param id
     * @return
     */
    UserRole getUserRoleById(Integer id);

    /**
     * 存储userRole
     *
     * @param userRole
     */
    void saveUserRole(UserRole userRole);

    /**
     * 删除userRole
     *
     * @param id
     */
    void deleteUserRole(Integer id);

    /**
     * 更新userRole
     *
     * @param userRole
     */
    void updateUserRole(UserRole userRole);

    /**
     * 显示userRole
     *
     * @return
     */
    List<UserRole> listUserRole();

    /**
     * 带分页的显示
     *
     * @param page
     * @return
     */
    List<UserRole> listUserRole(Page page);

    /**
     * 获得总数
     *
     * @return
     */
    int total();

}
