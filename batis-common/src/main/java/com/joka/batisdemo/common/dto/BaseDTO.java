package com.joka.batisdemo.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created on 2019/9/17 19:23.
 *
 * @author zhaozengjie
 * Description :
 */
@Data
public class BaseDTO {

    private Date gmtCreated;

    private Date gmtModified;

    private String creator;

    private String modifier;

    private String isDeleted;

}
