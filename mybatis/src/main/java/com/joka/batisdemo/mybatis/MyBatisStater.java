package com.joka.batisdemo.mybatis;

import com.joka.batisdemo.common.dto.UserDTO;
import com.joka.batisdemo.mybatis.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created on 2019/9/17 19:16.
 *
 * @author zhaozengjie
 * Description :
 */
public class MyBatisStater {

    public static void main(String[] args) throws IOException {

        String resource = "datasource/mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            final List<UserDTO> userDTOS = mapper.selectAll();


            System.out.println(userDTOS.toString());
        }


    }
}
