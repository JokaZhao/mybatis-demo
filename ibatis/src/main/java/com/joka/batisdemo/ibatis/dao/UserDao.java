package com.joka.batisdemo.ibatis.dao;

import com.joka.batisdemo.common.dto.UserDTO;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/9/26 10:59.
 *
 * @author zhaozengjie
 * Description :
 */
public interface UserDao {

    List<UserDTO> selectAll();

    UserDTO selectById(Long id);

    List<UserDTO> selectByParam(Map<String,Object> param);

    List<UserDTO> selectIn(List<String> ids);

    UserDTO selectByUserNameOrUserNo(String userName,String userNo);

    void insertOne(UserDTO userDTO);

    void batchInsert(List<UserDTO> data);

    long updateById(UserDTO userDTO,Long id);

}
