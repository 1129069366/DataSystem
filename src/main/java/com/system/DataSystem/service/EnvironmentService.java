package com.system.DataSystem.service;

import com.system.DataSystem.dao.CategoryRepository;
import com.system.DataSystem.dao.EnvironmentRepository;
import com.system.DataSystem.domain.Category;
import com.system.DataSystem.domain.Environment;
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
public class EnvironmentService {

    @Autowired
    private EnvironmentRepository environmentRepository;

    /**
     * 根据id查找Category信息
     * @param id
     * @return
     */
    public Environment findBattleById(Integer id) {
        Optional<Environment> optional = environmentRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    /**
     * 添加Category信息
     * @param environment
     */
    public void add(Environment environment) {
        environmentRepository.save(environment);
    }

    /**
     * 查询所有Category信息
     * @return
     */
    public List<Environment> findAll() {
        return environmentRepository.findAll();
    }

    /**
     * 根据id删除环境信息
     * @param id
     */
    public void delEnvironmentById(Integer id) {
        environmentRepository.deleteById(id);
    }



}
