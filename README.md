# mybatis-demo
本DEMO给出各种写法案例
- MyBatis
- IBatis
- 多表查询支持

## DB DDL脚本
    CREATE TABLE `user` (
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
    ) ENGINE=InnoDB AUTO_INCREMENT=10019 DEFAULT CHARSET=utf8 COMMENT='用户信息表'
   
## 初始化数据 DML脚本
    INSERT INTO test.`user`(id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10000, '张三', '18779880000', 1, 1, 'N', '2019-09-17 19:30:59.000', 'system', '2019-09-17 19:30:59.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10028, '陈功', '440812199102169182', 1, 1, 'N', '2019-09-24 19:48:43.000', 'system', '2019-09-26 16:07:46.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10029, '俞翔旭', '121814197308253173', 1, 1, 'N', '2019-09-24 19:55:58.000', 'system', '2019-09-24 19:55:58.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10030, '任有', '711017199709211756', 1, 1, 'N', '2019-09-25 18:04:19.000', 'system', '2019-09-25 18:04:19.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10031, '项盛', '531814199708101071', 1, 1, 'N', '2019-09-25 18:04:19.000', 'system', '2019-09-25 18:04:19.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10032, '安伊亚', '511705197109047858', 1, 1, 'N', '2019-09-25 18:04:19.000', 'system', '2019-09-25 18:04:19.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10033, '计宁', '361111197106205117', 1, 1, 'N', '2019-09-26 16:03:58.000', 'system', '2019-09-26 16:03:58.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10034, '沈玲', '431717198605104308', 1, 1, 'N', '2019-09-26 16:04:22.000', 'system', '2019-09-26 16:04:22.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10035, '尹平保', '461220199812139727', 1, 1, 'N', '2019-09-26 16:05:26.000', 'system', '2019-09-26 16:05:26.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10036, '水星', '431505199904205424', 1, 1, 'N', '2019-09-26 16:05:26.000', 'system', '2019-09-26 16:05:26.000', 'system');
    INSERT INTO test.`user`
    (id, user_name, user_no, user_type, status, is_deleted, gmt_created, creator, gmt_modified, modifier)
    VALUES(10037, '黄奇', '811126197603074501', 1, 1, 'N', '2019-09-26 16:05:26.000', 'system', '2019-09-26 16:05:26.000', 'system');
