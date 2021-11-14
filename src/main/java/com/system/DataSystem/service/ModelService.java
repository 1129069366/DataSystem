package com.system.DataSystem.service;

import com.system.DataSystem.dao.CategoryRepository;
import com.system.DataSystem.dao.ModelRepository;
import com.system.DataSystem.domain.Category;
import com.system.DataSystem.domain.Model;
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
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    /**
     * 根据id查找Model信息
     * @param id
     * @return
     */
    public Model findModelById(Integer id) {
        Optional<Model> optional = modelRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    /**
     * 添加model信息
     * @param model
     */
    public void add(Model model) {
        modelRepository.save(model);
    }

    /**
     * 查询所有Model信息
     * @return
     */
    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    /**
     * 删除模型信息
     * @param id
     */
    public void delModelById(Integer id) {
        modelRepository.deleteById(id);
    }
}
