package com.joka.batis.myoss.dao;

import app.myoss.cloud.mybatis.mapper.template.CrudMapper;
import com.joka.batis.myoss.domin.UserDomin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2019/9/30 14:13.
 *
 * @author zhaozengjie
 * Description :
 */
@Repository
public interface UserDao extends CrudMapper<UserDomin> {

    List<UserDomin> selectAll();

    List<UserDomin> selectIn(List<String> ids);

    UserDomin selectByUserNameOrUserNo(String userName, String userNo);

    void batchInsert(List<UserDomin> data);

}
