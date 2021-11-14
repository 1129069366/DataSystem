package com.system.DataSystem.controller.Impl;


import com.system.DataSystem.controller.ModelController;
import com.system.DataSystem.domain.Battle;
import com.system.DataSystem.domain.Model;
import com.system.DataSystem.service.BattleService;
import com.system.DataSystem.service.ModelService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/model")
public class ModelControllerImpl implements ModelController {

    @Autowired
    private ModelService modelService;

    @ApiOperation("根据id查找模型信息")
    @GetMapping("/get/{id}")
    public Model getModelById(@PathVariable("id") String id){
        Integer _id = Integer.parseInt(id);
        Model model = modelService.findModelById(_id);
        if(model==null){
            Model m = new Model();
            m.setM_name("找不到！！");
            return m;
        }
        return model;
    }

    @ApiOperation("查询所有模型信息")
    @GetMapping("/findAll")
    public List<Model> findAll(){
        return modelService.findAll();
    }


    @ApiOperation("添加模型信息")
    @PostMapping("/add")
    public String addBattle(@RequestBody Model model ){
        model.setBegin_time(new Date());
        modelService.add(model);
        return "success";
    }

    @ApiOperation("根据id删除模型信息")
    @DeleteMapping("/del/{id}")
    public String delEnvironmentById(@PathVariable("id")String id){
        Integer _id = Integer.parseInt(id);
        modelService.delModelById(_id);
        return "success";

    }








}
