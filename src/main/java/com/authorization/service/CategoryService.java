package com.authorization.service;

import com.authorization.model.Category;
import com.authorization.model.Page;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-03-15
 * @Time: 20:32
 */
public interface CategoryService {


    /**
     * get category by id
     *
     * @param id
     * @return
     */
    Category getCategoryById(Integer id);

    /**
     * 存储category
     *
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 删除category
     *
     * @param id
     */
    void deleteCategory(Integer id);

    /**
     * 更新category
     *
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 显示category
     *
     * @return
     */
    List<Category> listCategory();

    /**
     * 带分页的显示
     *
     * @param page
     * @return
     */
    List<Category> listCategory(Page page);

    /**
     * 获得总数
     *
     * @return
     */
    int total();


}
