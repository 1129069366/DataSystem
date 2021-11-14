package com.system.DataSystem.controller.Impl;

import com.system.DataSystem.controller.TrainController;
import com.system.DataSystem.domain.Battle;
import com.system.DataSystem.domain.Train;
import com.system.DataSystem.service.BattleService;
import com.system.DataSystem.service.TrainService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-30 13:07
 **/
@RestController
@RequestMapping("/train")
public class TrainControllerImpl implements TrainController {

    @Autowired
    private TrainService trainService;

    @ApiOperation("根据id查找训练信息")
    @GetMapping("/get/{id}")
    public Train getTrainById(@PathVariable("id") String id){
        Integer _id = Integer.parseInt(id);
        Train train = trainService.findTrainById(_id);
        if(train==null){
            Train t = new Train();
            t.setState("找不到！！");
            return t;
        }
        return train;
    }

    @ApiOperation("查询所有训练信息")
    @GetMapping("/findAll")
    public List<Train> findAll(){
        return trainService.findAll();
    }


    @ApiOperation("添加训练信息")
    @PostMapping("/add")
    public String addTrain(@RequestBody Train train){
        train.setState("训练中");
        train.setCreate_time(new Date());
        trainService.add(train);
        return "success";
    }

    @ApiOperation("根据id删除训练信息")
    @DeleteMapping("/del/{id}")
    public String delTrainById(@PathVariable("id")String id){
        Integer _id = Integer.parseInt(id);
        trainService.delTrainById(_id);
        return "success";

    }


    @ApiOperation("根据id修改进度信息")
    @PutMapping("/update/{id}")
    public String updateById(@PathVariable("id")String id){
        Integer _id = Integer.parseInt(id);
        Train trainById = trainService.findTrainById(_id);
//        trainById.setId(null);
        trainById.setProgress(100);
        trainById.setState("训练结束");
        trainService.updateById(trainById,_id);
        return "success";


    }








}
