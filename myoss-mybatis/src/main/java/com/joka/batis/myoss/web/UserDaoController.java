package com.joka.batis.myoss.web;

import com.alibaba.fastjson.JSONObject;
import com.joka.batis.myoss.dao.UserDao;
import com.joka.batis.myoss.domin.UserDomin;
import com.joka.batisdemo.common.dto.UserDTO;
import com.joka.batisdemo.common.util.IDCardNoUtils;
import com.joka.batisdemo.common.util.NameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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
        List<UserDomin> userDTOS = userDao.selectAll();
        return JSONObject.toJSONString(userDTOS);
    }

    @RequestMapping("/selectOne")
    public String selectOne(){
        UserDomin userDomin = new UserDomin();
        userDomin.setId(10000L);
        UserDomin userDTO = userDao.selectOne(userDomin);
        return JSONObject.toJSONString(userDTO);
    }

    @RequestMapping("/selectByParam")
    public String selectByParam(){
        UserDomin userDTO = new UserDomin();
        userDTO.setUserName("张三");
        List<UserDomin> userDTOS = userDao.selectList(userDTO);
        return JSONObject.toJSONString(userDTOS);
    }

    @RequestMapping("/selectIn")
    public String selectIn(){
        List<String> ids = Arrays.asList("18779880000", "440812199102169182");
        List<UserDomin> userDTOS = userDao.selectIn(ids);
        return JSONObject.toJSONString(userDTOS);
    }

    @RequestMapping("/selectByUserNameOrUserNo")
    public String selectByUserNameOrUserNo(){
        UserDomin userDTO = userDao.selectByUserNameOrUserNo("张三", "18779880000");
        return JSONObject.toJSONString(userDTO);
    }

    @RequestMapping("/insertOne")
    public String insertOne(){
        UserDomin userDTO = createUser();
        int insert = userDao.insert(userDTO);
        return String.valueOf(insert);
    }

    @RequestMapping("/batchInsert")
    public String batchInsert(){
        List<UserDomin> userDTOS = Arrays.asList(createUser(), createUser(), createUser());
        userDao.batchInsert(userDTOS);
        return "true";
    }

    @RequestMapping("/updateById")
    public String updateById(){
        UserDomin record = new UserDomin();
        record.setIsDeleted("N");

        UserDomin condition = new UserDomin();
        condition.setId(10000L);

        int i = userDao.updateByCondition(record, condition);
        return String.valueOf(i);
    }

    private static UserDomin createUser() {

        UserDomin userDTO = new UserDomin();
        userDTO.setUserName(NameUtils.getName());
        userDTO.setUserNo(IDCardNoUtils.getRandomID());
        userDTO.setUserType(1);
        userDTO.setStatus(1);

        return userDTO;

    }
}
