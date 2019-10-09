package com.joka.sharding.mybatis.web;

import com.alibaba.fastjson.JSONObject;
import com.joka.batisdemo.common.dto.UserDTO;
import com.joka.batisdemo.common.util.IDCardNoUtils;
import com.joka.batisdemo.common.util.NameUtils;
import com.joka.sharding.mybatis.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<UserDTO> userDTOS = userDao.selectAll();
        return JSONObject.toJSONString(userDTOS);
    }

    @RequestMapping("/selectOne/{id}")
    public String selectOne(@PathVariable(value = "id") Long id){
        UserDTO userDTO = userDao.selectById(id);
        return JSONObject.toJSONString(userDTO);
    }

    @RequestMapping("/selectByParam/{name}")
    public String selectByParam(@PathVariable(value = "name") String name){
        Map<String, Object> param = new HashMap<>();
        param.put("userName", name);
        List<UserDTO> userDTOS = userDao.selectByParam(param);
        return JSONObject.toJSONString(userDTOS);
    }

    @RequestMapping("/selectIn/{ids}")
    public String selectIn(@PathVariable(value = "ids") String ids){
        String[] split = ids.split("-");
        List<String> strings = Arrays.asList(split);
        List<UserDTO> userDTOS = userDao.selectIn(strings);
        return JSONObject.toJSONString(userDTOS);
    }

    @RequestMapping("/selectByUserNameOrUserNo/{name}/{no}")
    public String selectByUserNameOrUserNo(@PathVariable(value = "name") String name,@PathVariable(value = "no") String no){
        UserDTO userDTO = userDao.selectByUserNameOrUserNo(name,no);
        return JSONObject.toJSONString(userDTO);
    }

    @RequestMapping("/insertOne")
    public String insertOne(){
        UserDTO userDTO = createUser();
        userDao.insertOne(userDTO);
        return "OK";
    }

    @RequestMapping("/updateById/{id}")
    public String updateById(@PathVariable(value = "id") Long id){
        UserDTO record = new UserDTO();
        record.setIsDeleted("N");

        long i = userDao.updateById(record, id);
        return String.valueOf(i);
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
