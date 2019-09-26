package com.joka.batisdemo.ibatis.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ibatis.sqlmap.client.SqlMapSession;
import com.joka.batisdemo.common.dto.UserDTO;
import com.joka.batisdemo.ibatis.dao.BaseDao;
import com.joka.batisdemo.ibatis.dao.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2019/9/26 14:35.
 *
 * @author zhaozengjie
 * Description :
 */
public class UserDaoImpl extends BaseDao<UserDTO> implements UserDao{


    public UserDaoImpl(SqlMapClient sqlMapClient) {
        super(sqlMapClient);
    }

    @Override
    public List<UserDTO> selectAll() {

        List<UserDTO> sellectAll = executeQueryForList("selectAll", null);

        return sellectAll;
    }

    @Override
    public UserDTO selectById(Long id) {

        UserDTO userDTO = executeQueryForObject("selectById", id);

        return userDTO;
    }

    @Override
    public List<UserDTO> selectByParam(Map<String, Object> param) {

        List<UserDTO> selectByParam = executeQueryForList("selectByParam", param);

        return selectByParam;
    }

    @Override
    public List<UserDTO> selectIn(List<String> list) {

        List<UserDTO> selectIn = executeQueryForList("selectIn", list);

        return selectIn;
    }

    @Override
    public UserDTO selectByUserNameOrUserNo(String userName, String userNo) {

        Map<String,String> param = new HashMap<>();
        param.put("userName",userName);
        param.put("userNo",userNo);

        UserDTO userDTO = executeQueryForObject("selectByUserNameOrUserNo", param);

        return userDTO;
    }

    @Override
    public void insertOne(UserDTO userDTO) {

        insert("insertOne", userDTO);

    }

    @Override
    public void batchInsert(List<UserDTO> data) {

        insert("batchInsert",data);

    }

    @Override
    public long updateById(UserDTO userDTO, Long id) {

        Map<String,Object> param = new HashMap<>();

        userDTO.setId(id);

        param.put("record",userDTO);

        int updateById = update("updateById", param);

        return updateById;
    }
}
