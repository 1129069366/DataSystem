package com.system.DataSystem.controller.Impl;

import com.system.DataSystem.controller.BattleController;
import com.system.DataSystem.controller.EnvironmentController;
import com.system.DataSystem.domain.Battle;
import com.system.DataSystem.domain.Environment;
import com.system.DataSystem.service.BattleService;
import com.system.DataSystem.service.EnvironmentService;
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
@RequestMapping("/environment")
public class EnvironmentControllerImpl implements EnvironmentController {

    @Autowired
    private EnvironmentService environmentService;

    @ApiOperation("根据id查找环境信息")
    @GetMapping("/get/{id}")
    public Environment getBattleById(@PathVariable("id") String id){
        Integer _id = Integer.parseInt(id);
        Environment environment = environmentService.findBattleById(_id);
        if(environment==null){
            Environment e = new Environment();
            e.setE_name("找不到！！");
            return e;
        }
        return environment;
    }

    @ApiOperation("查询所有环境信息")
    @GetMapping("/findAll")
    public List<Environment> findAll(){
        return environmentService.findAll();
    }


    @ApiOperation("添加环境信息")
    @PostMapping("/add")
    public String addEnvironment(@RequestBody Environment environment){
        environment.setCreate_time(new Date());
        environmentService.add(environment);
        return "success";
    }

    @ApiOperation("根据id删除环境信息")
    @DeleteMapping("/del/{id}")
    public String delEnvironmentById(@PathVariable("id")String id){
        Integer _id = Integer.parseInt(id);
        environmentService.delEnvironmentById(_id);
        return "success";

    }






}
