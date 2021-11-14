package com.system.DataSystem.domain;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;


/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-30 11:10
 **/
@Table(name = "category")
@Data
@ToString
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //配置主键的生成策略
    Integer id;

    String category;

    String c_name;

    String algorithms;
}
