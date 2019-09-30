package com.joka.batis.spring.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/9/30 11:09.
 *
 * @author zhaozengjie
 * Description :
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping("/v1")
    @ResponseBody
    public String sayHello(){

        return "Hello World";

    }

}
