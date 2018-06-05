package com.authorization.dao;

import com.authorization.model.Category;
import com.authorization.model.Page;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-03-15
 * @Time: 16:16
 */
public interface CategoryMapper {

    /**
     * 存储category的数据是Category类型
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 通过id删除Category
     * @param id
     */
    void deleteCategory(Integer id);

    /**
     * 通过id 获得Category
     * @param id id
     */
    Category getCategoryById(Integer id);


    /**
     * update
     * @param category
     */
    void updateCategory(Category category);

    /**
     * listCategory
     * @return
     */
    List<Category> listCategory();

    /**
     * 带分页的查询
     * @param page
     * @return
     */
    List<Category> listCategory(Page page);

    /**
     * 计数
     * @return
     */
    int total();

}
