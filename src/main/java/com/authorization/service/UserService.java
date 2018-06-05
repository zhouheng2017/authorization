package com.authorization.service;

import com.authorization.model.Role;
import com.authorization.model.User;
import com.authorization.model.Page;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 12:42
 */
public interface UserService {

    /**
     * get user by id
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 存储user
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 删除user
     *
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 更新user
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 显示user
     *
     * @return
     */
    List<User> listUser();

    /**
     * 带分页的显示
     *
     * @param page
     * @return
     */
    List<User> listUser(Page page);

    /**
     * 获得总数
     *
     * @return
     */
    int total();

    List<Role> getRoleByUserId(Integer userId);

    User getUserByName(String username);



}
