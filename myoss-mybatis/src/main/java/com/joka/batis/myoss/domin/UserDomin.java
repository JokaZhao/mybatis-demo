package com.joka.batis.myoss.domin;

import app.myoss.cloud.mybatis.repository.entity.AuditIdEntity;
import app.myoss.cloud.mybatis.table.annotation.GenerationType;
import app.myoss.cloud.mybatis.table.annotation.SequenceGenerator;
import app.myoss.cloud.mybatis.table.annotation.Table;
import com.joka.batisdemo.common.dto.UserDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2019/9/30 15:05.
 *
 * @author zhaozengjie
 * Description :
 */
@Table(name = "user")
@Accessors(chain = true)
@SequenceGenerator(strategy = GenerationType.USE_GENERATED_KEYS)
@Data
public class UserDomin extends AuditIdEntity<Long> implements Serializable {
    private static final long serialVersionUID = -2288640712853374837L;

    private Long id;

    private String userName;

    private String userNo;

    private Integer userType;

    private Integer status;

    private Date gmtCreated;

    private Date gmtModified;

    private String creator;

    private String modifier;

    private String isDeleted;


}
