package com.authorization.service.impl;

import com.authorization.dao.UserMapper;
import com.authorization.model.Page;
import com.authorization.model.Role;
import com.authorization.model.User;
import com.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 13:05
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * get user by id
     *
     * @param id
     * @return
     */
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    /**
     * 存储user
     *
     * @param user
     */
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    /**
     * 删除user
     *
     * @param id
     */
    public void deleteUser(Integer id) {

        userMapper.deleteUser(id);

    }

    /**
     * 更新user
     *
     * @param user
     */
    public void updateUser(User user) {

        userMapper.updateUser(user);

    }

    /**
     * 显示user
     *
     * @return
     */
    public List<User> listUser() {
        return userMapper.listUser();
    }

    /**
     * 带分页的显示
     *
     * @param page
     * @return
     */
    public List<User> listUser(Page page) {
        return userMapper.listUser(page);
    }

    /**
     * 获得总数
     *
     * @return
     */
    public int total() {
        return userMapper.total();
    }

    public List<Role> getRoleByUserId(Integer userId) {
        return userMapper.getRoleByUserId(userId);
    }

    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

}
