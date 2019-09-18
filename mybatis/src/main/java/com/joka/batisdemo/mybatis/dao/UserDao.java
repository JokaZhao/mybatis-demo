package com.joka.batisdemo.mybatis.dao;


import com.joka.batisdemo.common.dto.UserDTO;

import java.util.List;

/**
 * Created on 2019/9/16 18:47.
 *
 * @author zhaozengjie
 * Description :
 */
public interface UserDao {

    List<UserDTO> selectAll();
}
