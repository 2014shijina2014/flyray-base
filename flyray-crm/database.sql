/*Table structure for table `crm_customer_auth` */

DROP TABLE IF EXISTS `crm_customer_auth`;

CREATE TABLE `crm_customer_auth` (
  `id` BIGINT(20) NOT NULL COMMENT '客户（会员）Id\n            ',
  `customer_no` VARCHAR(60) NOT NULL COMMENT '客户（会员）号',
  `identity_type` VARCHAR(20) DEFAULT NULL COMMENT '登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）',
  `identifier` VARCHAR(20) DEFAULT NULL COMMENT '标识（手机号 邮箱 用户名或第三方应用的唯一标识）',
  `credential` VARCHAR(64) DEFAULT NULL COMMENT '密码凭证（站内的保存密码，站外的不保存或保存token）',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_auth` */

/*Table structure for table `crm_customer_base` */

DROP TABLE IF EXISTS `crm_customer_base`;

CREATE TABLE `crm_customer_base` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customer_no` VARCHAR(60) NOT NULL COMMENT '客户号',
  `cust_name` VARCHAR(30) DEFAULT NULL,
  `phone` INT(11) DEFAULT NULL,
  `sex` VARBINARY(2) DEFAULT NULL,
  `address` VARCHAR(255) DEFAULT NULL,
  `nickname` VARCHAR(30) DEFAULT NULL,
  `age` INT(2) DEFAULT NULL,
  `birthday` DATE DEFAULT NULL,
  `avatar` VARCHAR(60) DEFAULT NULL COMMENT '用户头像',
  `merchant_no` BIGINT(20) DEFAULT NULL COMMENT '商户号',
  `org_no` CHAR(10) DEFAULT NULL COMMENT '所属机构',
  PRIMARY KEY (`id`,`customer_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_base` */

/*Table structure for table `crm_merchant_base` */

DROP TABLE IF EXISTS `crm_merchant_base`;

CREATE TABLE `crm_merchant_base` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `merchant_no` VARCHAR(60) NOT NULL,
  `org_no` BIGINT(20) DEFAULT NULL COMMENT '所属机构',
  `merchant_name` VARBINARY(60) DEFAULT NULL COMMENT '商户名称',
  `brief_intro` VARBINARY(255) DEFAULT NULL COMMENT '商户简介',
  `merchant_address` VARCHAR(255) DEFAULT NULL COMMENT '商户位置',
  `merchant_phone` INT(11) DEFAULT NULL,
  `merchant_logo` CHAR(10) DEFAULT NULL COMMENT '商户logo',
  PRIMARY KEY (`id`,`merchant_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `crm_merchant_base` */