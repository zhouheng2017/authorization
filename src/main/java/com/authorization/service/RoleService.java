package com.authorization.service;

import com.authorization.model.Page;
import com.authorization.model.Role;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 12:43
 */
public interface RoleService {


    /**
     * get role by id
     *
     * @param id
     * @return
     */
    Role getRoleById(Integer id);

    /**
     * 存储role
     *
     * @param role
     */
    void saveRole(Role role);

    /**
     * 删除role
     *
     * @param id
     */
    void deleteRole(Integer id);

    /**
     * 更新role
     *
     * @param role
     */
    void updateRole(Role role);

    /**
     * 显示role
     *
     * @return
     */
    List<Role> listRole();

    /**
     * 带分页的显示
     *
     * @param page
     * @return
     */
    List<Role> listRole(Page page);

    /**
     * 获得总数
     *
     * @return
     */
    int total();

    List<Role> getRoleByUserId(Integer userId);

}
