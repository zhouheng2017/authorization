package com.authorization.dao;

import com.authorization.model.Role;
import com.authorization.model.Page;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 13:06
 */
public interface RoleMapper {

    /**
     * 存储role的数据是Role类型
     * @param role
     */
    void saveRole(Role role);

    /**
     * 通过id删除Role
     * @param id
     */
    void deleteRole(Integer id);

    /**
     * 通过id 获得Role
     * @param id id
     */
    Role getRoleById(Integer id);


    /**
     * update
     * @param role
     */
    void updateRole(Role role);

    /**
     * listRole
     * @return
     */
    List<Role> listRole();

    /**
     * 带分页的查询
     * @param page
     * @return
     */
    List<Role> listRole(Page page);

    /**
     * 计数
     * @return
     */
    int total();

    List<Role> getRoleByUserId(Integer userId);

}
