### 分表建表语句
    create database user_0;
    create database user_1;
    CREATE TABLE `user_0`.`user_00` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `user_name` varchar(45) NOT NULL COMMENT '用户姓名',
      `user_no` varchar(20) NOT NULL COMMENT '用户标识码',
      `user_type` tinyint(2) NOT NULL COMMENT '用户标识类型:1-身份证号,2-手机号码',
      `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态:1-生效,0-无效',
      `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除',
      `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `creator` varchar(64) NOT NULL DEFAULT 'system' COMMENT '创建人ID',
      `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
      `modifier` varchar(64) NOT NULL DEFAULT 'system' COMMENT '修改人ID',
      PRIMARY KEY (`id`),
      UNIQUE KEY `uniq_user_name_user_no` (`user_name`,`user_no`) USING BTREE,
      KEY `idx_user_no` (`user_no`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=10019 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
    
    CREATE TABLE `user_0`.`user_01` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `user_name` varchar(45) NOT NULL COMMENT '用户姓名',
      `user_no` varchar(20) NOT NULL COMMENT '用户标识码',
      `user_type` tinyint(2) NOT NULL COMMENT '用户标识类型:1-身份证号,2-手机号码',
      `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态:1-生效,0-无效',
      `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除',
      `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `creator` varchar(64) NOT NULL DEFAULT 'system' COMMENT '创建人ID',
      `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
      `modifier` varchar(64) NOT NULL DEFAULT 'system' COMMENT '修改人ID',
      PRIMARY KEY (`id`),
      UNIQUE KEY `uniq_user_name_user_no` (`user_name`,`user_no`) USING BTREE,
      KEY `idx_user_no` (`user_no`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=10019 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
    
    CREATE TABLE `user_1`.`user_02` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `user_name` varchar(45) NOT NULL COMMENT '用户姓名',
      `user_no` varchar(20) NOT NULL COMMENT '用户标识码',
      `user_type` tinyint(2) NOT NULL COMMENT '用户标识类型:1-身份证号,2-手机号码',
      `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态:1-生效,0-无效',
      `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除',
      `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `creator` varchar(64) NOT NULL DEFAULT 'system' COMMENT '创建人ID',
      `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
      `modifier` varchar(64) NOT NULL DEFAULT 'system' COMMENT '修改人ID',
      PRIMARY KEY (`id`),
      UNIQUE KEY `uniq_user_name_user_no` (`user_name`,`user_no`) USING BTREE,
      KEY `idx_user_no` (`user_no`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=10019 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
    
    
    CREATE TABLE `user_1`.`user_03` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `user_name` varchar(45) NOT NULL COMMENT '用户姓名',
      `user_no` varchar(20) NOT NULL COMMENT '用户标识码',
      `user_type` tinyint(2) NOT NULL COMMENT '用户标识类型:1-身份证号,2-手机号码',
      `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态:1-生效,0-无效',
      `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除',
      `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `creator` varchar(64) NOT NULL DEFAULT 'system' COMMENT '创建人ID',
      `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
      `modifier` varchar(64) NOT NULL DEFAULT 'system' COMMENT '修改人ID',
      PRIMARY KEY (`id`),
      UNIQUE KEY `uniq_user_name_user_no` (`user_name`,`user_no`) USING BTREE,
      KEY `idx_user_no` (`user_no`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=10019 DEFAULT CHARSET=utf8 COMMENT='用户信息表';


