package com.system.DataSystem.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-30 13:02
 **/
@Api("对战管理相关接口")
public interface BattleController {
    public String delBattleById(String id);
}
