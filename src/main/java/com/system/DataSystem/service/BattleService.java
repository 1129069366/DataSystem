package com.system.DataSystem.service;

import com.system.DataSystem.dao.BattleRepository;
import com.system.DataSystem.domain.Battle;
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
public class BattleService {

    @Autowired
    private BattleRepository battleRepository;

    /**
     * 根据id查找battle信息
     * @param id
     * @return
     */
    public Battle findBattleById(Integer id) {
        Optional<Battle> optional = battleRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    /**
     * 添加battle信息
     * @param battle
     */
    public void add(Battle battle) {
        battleRepository.save(battle);
    }

    /**
     * 查询所有battle信息
     * @return
     */
    public List<Battle> findAll() {
        return battleRepository.findAll();
    }

    /**
     * 根据id删除
     * @param id
     */
    public void delBattleById(Integer id) {
        battleRepository.deleteById(id);
    }

    /**
     *
     * @param battle
     * @param id
     */
    public void updateById(Battle battle, Integer id) {
        delBattleById(id);
        add(battle);
    }
}
