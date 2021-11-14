package com.system.DataSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: DataSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-29 22:28
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.system.DataSystem"})
public class DataSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataSystemApplication.class);
    }
}
