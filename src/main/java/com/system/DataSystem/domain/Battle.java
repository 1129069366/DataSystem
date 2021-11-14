package com.system.DataSystem.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-30 10:55
 **/
@Table(name = "battle")
@Data
@ToString
@Entity
public class Battle {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //配置主键的生成策略
    Integer id;

    String state;

    String b_name;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date create_time;

    String env;

    String model1;

    String model2;

    Integer detail;

}
