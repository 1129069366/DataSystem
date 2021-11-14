package com.system.DataSystem.controller.Impl;

import com.system.DataSystem.controller.CategoryController;
import com.system.DataSystem.domain.Battle;
import com.system.DataSystem.domain.Category;
import com.system.DataSystem.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-30 14:55
 **/
@RestController
@RequestMapping("/category")
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("根据id查找分类信息")
    @GetMapping("/get/{id}")
    public Category getCategoryById(@PathVariable("id") String id){
        Integer _id = Integer.parseInt(id);
        Category category = categoryService.findCategoryById(_id);
        if(category==null){
            Category c = new Category();
            c.setC_name("找不到！！");
            return c;
        }
        return category;
    }

    @GetMapping("/findAll")
    @ApiOperation("查找智能体全部分类")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @ApiOperation("添加分类信息")
    @PostMapping("/add")
    public String addCategory(@RequestBody Category category){
        categoryService.add(category);
        return "success";
    }

    @ApiOperation("根据id删除分类信息")
    @DeleteMapping("/del/{id}")
    public String delCategoryById(@PathVariable("id")String id){
        Integer _id = Integer.parseInt(id);
        categoryService.delCategoryById(_id);
        return "success";
    }


}
