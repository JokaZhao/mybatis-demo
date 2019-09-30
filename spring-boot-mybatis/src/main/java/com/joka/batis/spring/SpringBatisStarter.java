package com.joka.batis.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created on 2019/9/30 11:05.
 *
 * @author zhaozengjie
 * Description :
 */
@MapperScan("com.joka.batis.spring.dao")
@SpringBootApplication
public class SpringBatisStarter {


    public static void main(String[] args) {
        SpringApplication.run(SpringBatisStarter.class);
    }

}
