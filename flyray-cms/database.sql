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




CREATE TABLE
    crm_customer_base_extend
    (
        customer_no VARCHAR(60) NOT NULL COMMENT '客户号',
        follow_customer_no VARCHAR(60) NOT NULL COMMENT '关注客户号'
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
CREATE TABLE
    crm_customer_proficient
    (
        customer_no VARCHAR(60) NOT NULL COMMENT '客户号',
        cert_photo_file_no VARCHAR(20) NOT NULL COMMENT '身份证正面照片',
        leval VARCHAR(2) NOT NULL COMMENT '专家等级：00-普通；01-热门'
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE
    crm_photo_file
    (
        id INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
        file_name VARCHAR(200) NOT NULL COMMENT '文件名',
        path VARCHAR(200) NOT NULL COMMENT '路径',
        add_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE
    crm_proficient_recommend
    (
        id INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
        customer_no VARCHAR(60) NOT NULL COMMENT '客户号',
        recommend_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '推荐时间',
        recommend_photo_file VARCHAR(200) NOT NULL COMMENT '推荐位置',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

