package com.joka.batis.spring.web;

import com.alibaba.fastjson.JSONObject;
import com.joka.batis.spring.dao.UserDao;
import com.joka.batisdemo.common.dto.UserDTO;
import com.joka.batisdemo.common.util.IDCardNoUtils;
import com.joka.batisdemo.common.util.NameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2019/9/30 11:21.
 *
 * @author zhaozengjie
 * Description :
 */
@RestController
@RequestMapping("/user")
@ResponseBody
public class UserDaoController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/selectAll")
    public String selectAll(){
        return JSONObject.toJSONString(userDao.selectAll());
    }

    @RequestMapping("/selectOne")
    public String selectOne(){
        return JSONObject.toJSONString(userDao.selectById(10000L));
    }

    @RequestMapping("/selectByParam")
    public String selectByParam(){
        Map<String, Object> param = new HashMap<>();
        param.put("userName", "张三");
        List<UserDTO> userDTOS = userDao.selectByParam(param);
        return JSONObject.toJSONString(userDTOS);
    }

    @RequestMapping("/selectIn")
    public String selectIn(){
        List<String> ids = Arrays.asList("18779880000", "440812199102169182");

        List<UserDTO> userDTOS = userDao.selectIn(ids);
        return JSONObject.toJSONString(userDTOS);
    }

    @RequestMapping("/selectByUserNameOrUserNo")
    public String selectByUserNameOrUserNo(){
        UserDTO userDTO = userDao.selectByUserNameOrUserNo("张三", "18779880000");
        return JSONObject.toJSONString(userDTO);
    }

    @RequestMapping("/insertOne")
    public String insertOne(){
        UserDTO userDTO = createUser();
        userDao.insertOne(userDTO);
        return "true";
    }

    @RequestMapping("/batchInsert")
    public String batchInsert(){
        List<UserDTO> userDTOS = Arrays.asList(createUser(), createUser(), createUser());
        userDao.batchInsert(userDTOS);
        return "true";
    }

    @RequestMapping("/updateById")
    public String updateById(){
        UserDTO userDTO = new UserDTO();
        userDTO.setIsDeleted("Y");
        long l = userDao.updateById(userDTO, 10000L);
        return String.valueOf(l);
    }

    private static UserDTO createUser() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(NameUtils.getName());
        userDTO.setUserNo(IDCardNoUtils.getRandomID());
        userDTO.setUserType(1);
        userDTO.setStatus(1);

        return userDTO;

    }
}
