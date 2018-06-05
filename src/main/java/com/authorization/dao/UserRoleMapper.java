package com.authorization.dao;

import com.authorization.model.Page;
import com.authorization.model.UserRole;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 13:06
 */
public interface UserRoleMapper {

    /**
     * 存储UserRole的数据是UserRole类型
     * @param UserRole
     */
    void saveUserRole(UserRole UserRole);

    /**
     * 通过id删除UserRole
     * @param id
     */
    void deleteUserRole(Integer id);

    /**
     * 通过id 获得UserRole
     * @param id id
     */
    UserRole getUserRoleById(Integer id);


    /**
     * update
     * @param UserRole
     */
    void updateUserRole(UserRole UserRole);

    /**
     * listUserRole
     * @return
     */
    List<UserRole> listUserRole();

    /**
     * 带分页的查询
     * @param page
     * @return
     */
    List<UserRole> listUserRole(Page page);

    /**
     * 计数
     * @return
     */
    int total();

    UserRole getUserRoleByUserIdAndRoleId(Integer userId, Integer roleId);

    void deleteUserRoleByUserId(Integer userId);

}
