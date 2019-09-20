package com.joka.batisdemo.mybatis.dao;


import com.joka.batisdemo.common.dto.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/9/16 18:47.
 *
 * @author zhaozengjie
 * Description : 涵盖了日常基本操作
 */
public interface UserDao {

    List<UserDTO> selectAll();

    UserDTO selectById(Long id);

    List<UserDTO> selectByParam(Map<String,Object> param);

    List<UserDTO> selectIn(List<String> ids);

    UserDTO selectByUserNameOrUserNo(String userName,String userNo);

    void insertOne(UserDTO userDTO);

    void batchInsert(List<UserDTO> data);

    long updateById(@Param("record") UserDTO userDTO,@Param("id")Long id);


}
