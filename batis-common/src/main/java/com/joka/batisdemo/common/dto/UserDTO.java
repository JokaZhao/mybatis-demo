package com.joka.batisdemo.common.dto;

import lombok.Data;

/**
 * Created on 2019/9/17 19:21.
 *
 * @author zhaozengjie
 * Description :
 */
@Data
public class UserDTO extends BaseDTO{

    private Long id;

    private String userName;

    private String userNo;

    private Integer userType;

    private Integer status;

}
