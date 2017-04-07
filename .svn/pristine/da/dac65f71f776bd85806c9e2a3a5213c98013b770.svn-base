CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `chinesename` varchar(10) NOT NULL COMMENT '中文名',
  `dept` tinyint(4) NOT NULL COMMENT '部门',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `tel` varchar(4) NOT NULL COMMENT '电话号码',
  `sys_role` tinyint(4) NOT NULL DEFAULT '2' COMMENT '用户组',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态： 0-离职  1-在职',
  `register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_date` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `dimission_date` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '离职时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `chinesename` (`chinesename`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
