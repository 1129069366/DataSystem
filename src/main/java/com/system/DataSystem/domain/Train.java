package com.system.DataSystem.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


/**
 * @program: DataSystem
 * @description 训练管理相关表实体类
 * @author: Mr.Yang
 * @create: 2021-10-30 11:10
 **/
@Table(name = "train")
@Data
@ToString
@Entity
public class Train {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略
    Integer id;

    String state;

    String t_name;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date create_time;

    String e_sort;

    String category;

    Integer progress;
}
