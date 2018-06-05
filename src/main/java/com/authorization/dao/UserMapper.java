package com.authorization.dao;

import com.authorization.model.Role;
import com.authorization.model.User;
import com.authorization.model.Page;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-03
 * @Time: 13:06
 */
public interface UserMapper {
    /**
     * 存储user的数据是User类型
     * @param user
     */
    void saveUser(User user);

    /**
     * 通过id删除User
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 通过id 获得User
     * @param id id
     */
    User getUserById(Integer id);


    /**
     * update
     * @param user
     */
    void updateUser(User user);

    /**
     * listUser
     * @return
     */
    List<User> listUser();

    /**
     * 带分页的查询
     * @param page
     * @return
     */
    List<User> listUser(Page page);

    /**
     * 计数
     * @return
     */
    int total();

    List<Role> getRoleByUserId(Integer userId);

    User getUserByName(String username);
}
