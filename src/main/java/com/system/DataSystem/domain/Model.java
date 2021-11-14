package com.system.DataSystem.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-30 11:10
 **/
@Table(name = "model")
@Data
@ToString
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略
    Integer id;

    String environment;

    String m_name;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date begin_time;
}
