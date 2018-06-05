package com.authorization.controller;

import com.authorization.model.Category;
import com.authorization.model.Page;
import net.sf.json.JSONObject;
import com.authorization.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-03-15
 * @Time: 16:10
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @ResponseBody
    @RequestMapping("/submitCategory")
    public String submitCategory(@RequestBody Category category) {
        System.out.println("获取到的category" + category);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory() {

        Category category = new Category();
        category.setId(1009);
        category.setName("第1009个category");
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("category", JSONObject.toJSON(category));

        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping("/getMany")
    public String getMang() {

        List<Category> categorys = new ArrayList<Category>();


        for (int i = 130; i < 140; i++) {

            Category category = new Category();
            category.setId(i);
            category.setName("name" + i);
            categorys.add(category);
        }

//        return JSONOPbject.toJSON().toString(categorys);

        return null;
    }

    /**
     * 增加操作
     *
     *
     * @return
     */
    @RequestMapping(value = "/cs", method = RequestMethod.GET)
    public String saveCategory(Map<String, Object> map) {
        map.put("category", new Category());

        return "view";
    }

    /**
     * 增加操作
     * @param category
     * @return
     */
    @RequestMapping(value = "/cs", method = RequestMethod.POST)
    public ModelAndView saveCategory(Category category) {
        ModelAndView modelAndView = new ModelAndView("redirect:/category/listCategory");
        categoryService.saveCategory(category);

        logger.debug("category{}", category);
        return modelAndView;
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/cs/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteCategory(@PathVariable(value = "id", required = false) Integer id) {
        categoryService.deleteCategory(id);

        ModelAndView modelAndView = new ModelAndView("redirect:/category/listCategory");
        modelAndView.addObject("result", true);

        logger.debug("{} is deleted", id);

        return modelAndView;
    }




    @RequestMapping(value = "/cs/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id, Map<String, Object> map) {

        map.put("category", categoryService.getCategoryById(id));
        return "view";
    }
    /**
     * 更新操作
     *
     * @param category
     * @return
     */
    @RequestMapping(value = "/cs", method = RequestMethod.PUT)
    public String updateCategory(Category category) {
        System.out.println("CategoryID" + category.getId());

        categoryService.updateCategory(category);
        logger.error("category {}", category);
        return "redirect:/category/listCategory";
    }

    @RequestMapping(value = "/listCategory", method = RequestMethod.GET)
    public ModelAndView listAll(Page page) {
        logger.error("{}", page);
        ModelAndView modelAndView = new ModelAndView("listCategory");
        List<Category> list = categoryService.listCategory(page);
        page.calculateLast(categoryService.total());
        modelAndView.addObject("cs", list);
        logger.debug("{}", page);

        return modelAndView;
    }
}
