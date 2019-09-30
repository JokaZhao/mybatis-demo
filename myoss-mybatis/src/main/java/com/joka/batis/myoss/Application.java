package com.joka.batis.myoss;

import app.myoss.cloud.mybatis.mapper.template.CrudMapper;
import app.myoss.cloud.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created on 2019/9/30 14:12.
 *
 * @author zhaozengjie
 * Description :
 */
@MapperScan(basePackageClasses = Application.class, factoryBean = MapperFactoryBean.class, markerInterface = CrudMapper.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
