package com.authorization.service.impl;

import com.authorization.dao.RoleMapper;
import com.authorization.model.Page;
import com.authorization.model.Role;
import com.authorization.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 15:40
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    /**
     * get role by id
     *
     * @param id
     * @return
     */
    public Role getRoleById(Integer id) {
        return roleMapper.getRoleById(id);
    }

    /**
     * 存储role
     *
     * @param role
     */
    public void saveRole(Role role) {

        roleMapper.saveRole(role);
    }

    /**
     * 删除role
     *
     * @param id
     */
    public void deleteRole(Integer id) {
        roleMapper.deleteRole(id);

    }

    /**
     * 更新role
     *
     * @param role
     */
    public void updateRole(Role role) {

        roleMapper.updateRole(role);

    }

    /**
     * 显示role
     *
     * @return
     */
    public List<Role> listRole() {

        return roleMapper.listRole();
    }

    /**
     * 带分页的显示
     *
     * @param page
     * @return
     */
    public List<Role> listRole(Page page) {
        return roleMapper.listRole(page);
    }

    /**
     * 获得总数
     *
     * @return
     */
    public int total() {
        return roleMapper.total();
    }

    public List<Role> getRoleByUserId(Integer userId) {
        return roleMapper.getRoleByUserId(userId);
    }

}
