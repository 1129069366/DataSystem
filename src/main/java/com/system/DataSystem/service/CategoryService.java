package com.system.DataSystem.service;

import com.system.DataSystem.dao.BattleRepository;
import com.system.DataSystem.dao.CategoryRepository;
import com.system.DataSystem.domain.Battle;
import com.system.DataSystem.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-30 13:08
 **/
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * 根据id查找Category信息
     * @param id
     * @return
     */
    public Category findCategoryById(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    /**
     * 添加Category信息
     * @param category
     */
    public void add(Category category) {
        categoryRepository.save(category);
    }

    /**
     * 查询所有Category信息
     * @return
     */
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * 根据id删除Category信息
     * @param id
     */
    public void delCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
