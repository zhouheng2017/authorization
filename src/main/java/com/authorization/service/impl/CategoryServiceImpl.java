package com.authorization.service.impl;

import com.authorization.dao.CategoryMapper;
import com.authorization.model.Category;
import com.authorization.model.Page;
import com.authorization.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-03-15
 * @Time: 20:33
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * get category by id
     *
     * @param id
     * @return
     */
    public Category getCategoryById(Integer id) {
        return categoryMapper.getCategoryById(id);
    }

    /**
     * 存储category
     *
     * @param category
     */
//    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public void saveCategory(Category category) {
        categoryMapper.saveCategory(category);

    }

    /**
     * 删除category
     *
     * @param id
     */
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
    }

    /**
     * 更新category
     *
     * @param category
     */
    public void updateCategory(Category category) {

        categoryMapper.updateCategory(category);
    }

    /**
     * 显示category
     *
     * @return
     */
    public List<Category> listCategory() {
        return categoryMapper.listCategory();
    }

    /**
     * 带分页的显示
     *
     * @param page
     * @return
     */
    public List<Category> listCategory(Page page) {
        return categoryMapper.listCategory(page);
    }

    /**
     * 获得总数
     *
     * @return
     */
    public int total() {
        return categoryMapper.total();
    }

}
