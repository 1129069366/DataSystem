package com.system.DataSystem.service;

import com.system.DataSystem.dao.CategoryRepository;
import com.system.DataSystem.dao.TrainRepository;
import com.system.DataSystem.domain.Category;
import com.system.DataSystem.domain.Train;
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
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    /**
     * 根据id查找Category信息
     * @param id
     * @return
     */
    public Train findTrainById(Integer id) {
        Optional<Train> optional = trainRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    /**
     * 添加Category信息
     * @param train
     */
    public void add(Train train) {
        trainRepository.save(train);
    }

    /**
     * 查询所有Category信息
     * @return
     */
    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    /**
     * 根据模型删除信息
     * @param id
     */
    public void delTrainById(Integer id) {
        trainRepository.deleteById(id);
    }

    /**
     * 根据id更新训练信息
     * @param trainById
     * @param id
     */
    public void updateById(Train trainById,Integer id) {
        delTrainById(id);
        add(trainById);
    }
}
