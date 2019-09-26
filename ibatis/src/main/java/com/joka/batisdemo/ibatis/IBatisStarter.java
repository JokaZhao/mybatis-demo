package com.joka.batisdemo.ibatis;

import com.alibaba.fastjson.JSONObject;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.joka.batisdemo.common.dto.UserDTO;
import com.joka.batisdemo.common.util.IDCardNoUtils;
import com.joka.batisdemo.common.util.NameUtils;
import com.joka.batisdemo.ibatis.dao.UserDao;
import com.joka.batisdemo.ibatis.dao.impl.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2019/9/26 10:58.
 *
 * @author zhaozengjie
 * Description :
 */
public class IBatisStarter {

    private static Logger logger = LoggerFactory.getLogger(IBatisStarter.class);
    public static SqlMapClient sqlmapclient = null;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("ibatis-sql-map.xml");
            sqlmapclient = SqlMapClientBuilder.buildSqlMapClient(reader);
        } catch (IOException e) {
            logger.error("", e);
        }
    }


    public static void main(String[] args) {

        UserDao userDao = new UserDaoImpl(sqlmapclient);

//        selectAll(userDao);

//        selectOne(userDao);

//        selectByParam(userDao);

//        selectIn(userDao);

//        selectByUserNameOrUserNo(userDao);

//        insertOne(userDao);

//        batchInsert(userDao);

        updateById(userDao);

    }

    public static void selectAll(UserDao mapper) {
        List<UserDTO> userDTOS = mapper.selectAll();
        logger.info(String.format("selectAll : %s", JSONObject.toJSONString(userDTOS)));

    }

    public static void selectOne(UserDao mapper) {
        UserDTO userDTO = mapper.selectById(10000L);
        logger.info(String.format("selectOne : %s", JSONObject.toJSONString(userDTO)));
    }

    public static void selectByParam(UserDao mapper) {
        Map<String, Object> param = new HashMap<>();
        param.put("userName", "张三");
        List<UserDTO> userDTOS1 = mapper.selectByParam(param);
        logger.info(String.format("selectByParam : %s", JSONObject.toJSONString(userDTOS1)));
    }

    public static void selectIn(UserDao mapper) {

        List<String> ids = Arrays.asList("18779880000", "440812199102169182");

        List<UserDTO> dtoList = mapper.selectIn(ids);

        dtoList.forEach(dto -> logger.info(JSONObject.toJSONString(dto)));

    }

    public static void selectByUserNameOrUserNo(UserDao mapper) {

        UserDTO userDTO = mapper.selectByUserNameOrUserNo("张三", "18779880000");

        logger.info(JSONObject.toJSONString(userDTO));


    }

    public static void insertOne(UserDao mapper) {

        UserDTO userDTO = createUser();

        try {
            mapper.insertOne(userDTO);
        } catch (Exception e) {
            logger.error("", e);
        }


    }

    public static void batchInsert(UserDao mapper) {

        try {
            List<UserDTO> userDTOS = Arrays.asList(createUser(), createUser(), createUser());
            mapper.batchInsert(userDTOS);
        } catch (Exception e) {
            logger.error("", e);
        }

    }

    public static void updateById(UserDao mapper) {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setIsDeleted("Y");
            mapper.updateById(userDTO, 10028L);
        } catch (Exception e) {
            logger.error("", e);
        }

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
