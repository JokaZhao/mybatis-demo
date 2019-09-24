package com.joka.batisdemo.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.joka.batisdemo.common.dto.UserDTO;
import com.joka.batisdemo.common.util.IDCardNoUtils;
import com.joka.batisdemo.common.util.NameUtils;
import com.joka.batisdemo.mybatis.dao.UserDao;
import com.sun.javafx.binding.StringFormatter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created on 2019/9/17 19:16.
 *
 * @author zhaozengjie
 * Description :
 */
public class MyBatisStater {

    private static Logger logger = LoggerFactory.getLogger(MyBatisStater.class);

    static SqlSessionFactory sqlSessionFactory;

    static Optional<SqlSession> sqlSession;

    public static void main(String[] args) throws IOException {

        try {
            init();

            selectAll();

            selectOne();

            selectByParam();
            insertOne();
            selectIn();

        } finally {

        }
    }

    public static void init() throws IOException {
        String resource = "datasource/mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = Optional.of(sqlSessionFactory.openSession());
    }

    public static void selectAll() {
        sqlSession.ifPresent(r -> {
            final UserDao mapper = r.getMapper(UserDao.class);
            List<UserDTO> userDTOS = mapper.selectAll();
            System.out.println(StringFormatter.format("selectAll : %s", JSONObject.toJSONString(userDTOS)));

        });
    }

    public static void selectOne() {
        sqlSession.ifPresent(r -> {
            UserDao mapper = r.getMapper(UserDao.class);
            UserDTO userDTO = mapper.selectById(10000L);
            System.out.println(StringFormatter.format("selectOne : %s", JSONObject.toJSONString(userDTO)));
        });
    }

    public static void selectByParam() {
        sqlSession.ifPresent(r -> {
            UserDao mapper = r.getMapper(UserDao.class);
            Map<String, Object> param = new HashMap<>();
            param.put("user_name", "张三");
            List<UserDTO> userDTOS1 = mapper.selectByParam(param);
            System.out.println(StringFormatter.format("selectByParam : %s", JSONObject.toJSONString(userDTOS1)));
        });
    }

    public static void selectIn() {

        sqlSession.ifPresent(r -> {

            UserDao mapper = r.getMapper(UserDao.class);
            List<String> ids = Arrays.asList("18779880000", "440812199102169182");

            List<UserDTO> dtoList = mapper.selectIn(ids);

            dtoList.forEach(dto ->System.out.println(JSONObject.toJSONString(dto)));

        });

    }

    public static void insertOne() {

        UserDTO userDTO = createUser();

        sqlSession.ifPresent(r -> {
            UserDao mapper = r.getMapper(UserDao.class);
            try {
                mapper.insertOne(userDTO);
                r.commit();
            } catch (Exception e) {
                logger.error("", e);
            }
        });

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
