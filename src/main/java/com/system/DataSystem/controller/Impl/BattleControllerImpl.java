package com.system.DataSystem.controller.Impl;

import com.system.DataSystem.controller.BattleController;
import com.system.DataSystem.domain.Battle;
import com.system.DataSystem.domain.Train;
import com.system.DataSystem.service.BattleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-30 13:07
 **/
@RestController
@RequestMapping("/battle")
public class BattleControllerImpl implements BattleController {

    @Autowired
    private BattleService battleService;

    @ApiOperation("根据id查找对战信息")
    @GetMapping("/get/{id}")
    public Battle getBattleById(@PathVariable("id") String id){
        Integer _id = Integer.parseInt(id);
        Battle battle = battleService.findBattleById(_id);
        if(battle==null){
            Battle b = new Battle();
            b.setB_name("找不到！！");
            return b;
        }
        return battle;
    }

    @ApiOperation("查询所有对战信息")
    @GetMapping("/findAll")
    public List<Battle> findAll(){
        return battleService.findAll();
    }


    @ApiOperation("添加对战信息")
    @PostMapping("/add")
    public String addBattle(@RequestBody Battle battle){
        battle.setState("对战中");
        battle.setCreate_time(new Date());
        int detail = new Random().nextInt(71)+30;
        battle.setDetail(detail);
        battleService.add(battle);
        return "success";
    }


    @ApiOperation("根据id删除对战信息")
    @DeleteMapping("/del/{id}")
    public String delBattleById(@PathVariable("id") String id){
        Integer _id = Integer.parseInt(id);
        battleService.delBattleById(_id);
        return "success";
    }


    @ApiOperation("根据id修改进度信息")
    @PutMapping("/update/{id}")
    public String updateById(@PathVariable("id")String id){
        Integer _id = Integer.parseInt(id);
        Battle battle = battleService.findBattleById(_id);
        battle.setDetail(100);
        battle.setState("对战结束");
        battleService.updateById(battle,_id);
        return "success";

    }








}
