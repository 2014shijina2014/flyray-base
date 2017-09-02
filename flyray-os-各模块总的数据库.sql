/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.16-log : Database - flyray-os
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`flyray-os` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `flyray-os`;

/*Table structure for table `crm_customer_auth` */

DROP TABLE IF EXISTS `crm_customer_auth`;

CREATE TABLE `crm_customer_auth` (
  `id` bigint(20) NOT NULL COMMENT '客户（会员）Id\n            ',
  `identity_type` varchar(20) DEFAULT NULL COMMENT '登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）',
  `identifier` varchar(20) DEFAULT NULL COMMENT '标识（手机号 邮箱 用户名或第三方应用的唯一标识）',
  `credential` varchar(64) DEFAULT NULL COMMENT '密码凭证（站内的保存密码，站外的不保存或保存token）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_auth` */

/*Table structure for table `crm_customer_base` */

DROP TABLE IF EXISTS `crm_customer_base`;

CREATE TABLE `crm_customer_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_no` varchar(60) DEFAULT NULL COMMENT '客户号',
  `cust_name` varchar(30) DEFAULT NULL,
  `phone` varbinary(11) DEFAULT NULL,
  `sex` varbinary(2) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `age` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `merchant_no` varchar(20) DEFAULT NULL COMMENT '商户号',
  `org_no` varchar(10) DEFAULT NULL COMMENT '所属机构',
  `avatar` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_base` */

insert  into `crm_customer_base`(`id`,`customer_no`,`cust_name`,`phone`,`sex`,`address`,`nickname`,`age`,`birthday`,`merchant_no`,`org_no`,`avatar`) values (1,'b3434','雷继文','1','1','山东','飞雷','1','2017-04-21','1','1',NULL),(2,'2','2','2','2','2','2','2',NULL,'2','2','2'),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `crm_customer_base_extend` */

DROP TABLE IF EXISTS `crm_customer_base_extend`;

CREATE TABLE `crm_customer_base_extend` (
  `customer_no` varchar(60) NOT NULL COMMENT '客户号',
  `follow_customer_no` varchar(60) NOT NULL COMMENT '关注客户号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_base_extend` */

/*Table structure for table `crm_customer_proficient` */

DROP TABLE IF EXISTS `crm_customer_proficient`;

CREATE TABLE `crm_customer_proficient` (
  `customer_no` varchar(60) NOT NULL COMMENT '客户号',
  `cert_photo_file_no` varchar(20) NOT NULL COMMENT '身份证正面照片',
  `leval` varchar(2) NOT NULL COMMENT '专家等级：00-普通；01-热门'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_proficient` */

/*Table structure for table `crm_merchant_base` */

DROP TABLE IF EXISTS `crm_merchant_base`;

CREATE TABLE `crm_merchant_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_no` varchar(60) NOT NULL,
  `org_id` bigint(20) DEFAULT NULL COMMENT '所属机构',
  `merchant_name` varchar(60) DEFAULT NULL COMMENT '商户名称',
  `brief_intro` varchar(255) DEFAULT NULL COMMENT '商户简介',
  `merchant_address` varchar(255) DEFAULT NULL COMMENT '商户位置',
  `merchant_phone` int(11) DEFAULT NULL,
  `merchant_logo` char(10) DEFAULT NULL COMMENT '商户logo',
  PRIMARY KEY (`id`,`merchant_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_merchant_base` */

/*Table structure for table `crm_photo_file` */

DROP TABLE IF EXISTS `crm_photo_file`;

CREATE TABLE `crm_photo_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `file_name` varchar(200) NOT NULL COMMENT '文件名',
  `path` varchar(200) NOT NULL COMMENT '路径',
  `add_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_photo_file` */

/*Table structure for table `crm_proficient_recommend` */

DROP TABLE IF EXISTS `crm_proficient_recommend`;

CREATE TABLE `crm_proficient_recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `customer_no` varchar(60) NOT NULL COMMENT '客户号',
  `recommend_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '推荐时间',
  `recommend_photo_file` varchar(200) NOT NULL COMMENT '推荐位置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_proficient_recommend` */

/*Table structure for table `erp_product` */

DROP TABLE IF EXISTS `erp_product`;

CREATE TABLE `erp_product` (
  `categary_id` bigint(20) DEFAULT NULL COMMENT '商户品分类id',
  `product_name` varbinary(60) DEFAULT NULL COMMENT '商品名称',
  `product_des` varbinary(255) DEFAULT NULL COMMENT '商品描述',
  `product_price` char(10) DEFAULT NULL COMMENT '商品价格',
  `merchant_no` bigint(20) DEFAULT NULL COMMENT '所属商户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `erp_product` */

/*Table structure for table `erp_product_categary` */

DROP TABLE IF EXISTS `erp_product_categary`;

CREATE TABLE `erp_product_categary` (
  `id` bigint(20) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL COMMENT '所属组织机构',
  `categary_name` varbinary(60) DEFAULT NULL COMMENT '商品类名',
  `merchant_id` char(10) DEFAULT NULL COMMENT '所属商户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `erp_product_categary` */

insert  into `erp_product_categary`(`id`,`org_id`,`categary_name`,`merchant_id`) values (NULL,44,'erere','344r');

/*Table structure for table `pay_channel` */

DROP TABLE IF EXISTS `pay_channel`;

CREATE TABLE `pay_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_channel_no` varchar(32) DEFAULT NULL COMMENT ' 支付通道编号',
  `pay_company_no` varchar(32) DEFAULT NULL COMMENT '支付公司',
  `fee_ratio` decimal(18,2) DEFAULT NULL COMMENT ' 通道费率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `pay_channel` */

insert  into `pay_channel`(`id`,`pay_channel_no`,`pay_company_no`,`fee_ratio`) values (1,'test0','test0','0.00'),(2,'test1','test1','9.00'),(3,'test','test','1.00'),(4,'test2','test2','1.00'),(5,'test3','test3','1.00'),(6,'payChannelNo','payCompanyNo','1.00'),(7,'payChannelNo','payCompanyNo','1.00');

/*Table structure for table `pay_channel_config` */

DROP TABLE IF EXISTS `pay_channel_config`;

CREATE TABLE `pay_channel_config` (
  `pay_channel_no` varchar(32) DEFAULT NULL COMMENT ' 支付通道编号',
  `pay_company_no` varchar(32) DEFAULT NULL COMMENT '支付公司',
  `org_no` varchar(32) DEFAULT NULL COMMENT '组织机构',
  `merchant_no` varchar(32) DEFAULT NULL COMMENT '商户号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pay_channel_config` */

/*Table structure for table `pay_channel_interface` */

DROP TABLE IF EXISTS `pay_channel_interface`;

CREATE TABLE `pay_channel_interface` (
  `pay_channel_no` varchar(32) DEFAULT NULL COMMENT '支付通道编号',
  `pay_service_name` varchar(32) DEFAULT NULL COMMENT '支付接口名称',
  `refund_service_name` varchar(32) DEFAULT NULL COMMENT '退款接口名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pay_channel_interface` */

/*Table structure for table `pay_order` */

DROP TABLE IF EXISTS `pay_order`;

CREATE TABLE `pay_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_order_no` varchar(60) NOT NULL COMMENT ' 订单号',
  `customer_no` varchar(60) DEFAULT NULL COMMENT '客户账号',
  `merchant_no` varchar(60) DEFAULT NULL COMMENT ' 商户账号',
  `pay_time` datetime DEFAULT NULL COMMENT '交易时间',
  `pay_fee` decimal(18,2) DEFAULT NULL COMMENT '交易手续费',
  `pay_amt` decimal(18,2) DEFAULT NULL COMMENT '交易金额',
  `body` text COMMENT '订单描述',
  `pay_method` varchar(32) DEFAULT NULL COMMENT '支付方式（1支付宝2微信3余额 13余额支付宝）',
  `order_status` varchar(10) DEFAULT NULL COMMENT '交易状态（未支付、支付中、支付失败、支付成功、已部分退款、已退款）',
  `org_no` varchar(32) DEFAULT NULL COMMENT '机构编号',
  `redunded_amt` decimal(18,2) DEFAULT NULL COMMENT ' 已退款金额',
  PRIMARY KEY (`id`,`pay_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pay_order` */

/*Table structure for table `pay_serial` */

DROP TABLE IF EXISTS `pay_serial`;

CREATE TABLE `pay_serial` (
  `serial_no` varchar(32) NOT NULL COMMENT '支付流水号',
  `pay_order_no` varchar(32) NOT NULL COMMENT '订单号',
  `pay_channel_no` varchar(32) DEFAULT NULL COMMENT '支付渠道号',
  `pay_company_no` varchar(32) DEFAULT NULL COMMENT '支付公司编号',
  `pay_amt` decimal(18,2) DEFAULT NULL COMMENT '交易金额',
  `pay_fee` decimal(18,0) DEFAULT NULL COMMENT '交易手续费',
  `account_status` varchar(10) DEFAULT NULL COMMENT '支付记账状态',
  `pay_status` varchar(10) DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`serial_no`,`pay_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pay_serial` */

/*Table structure for table `refund_order` */

DROP TABLE IF EXISTS `refund_order`;

CREATE TABLE `refund_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_order_no` varchar(32) NOT NULL COMMENT '支付订单号',
  `refund_order_no` varchar(32) DEFAULT NULL COMMENT '退款订单号',
  `refund_amt` decimal(18,2) DEFAULT NULL COMMENT '退款金额',
  `org_no` varchar(32) DEFAULT NULL COMMENT ' 机构编号',
  `refund_fee` decimal(18,2) DEFAULT NULL COMMENT '退款手续费',
  `refund_time` datetime DEFAULT NULL COMMENT '退款时间',
  `refund_reason` text COMMENT '退款原因',
  `refund_method` varchar(10) DEFAULT NULL COMMENT '跟支付方式对应',
  PRIMARY KEY (`id`,`pay_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `refund_order` */

/*Table structure for table `refund_serial` */

DROP TABLE IF EXISTS `refund_serial`;

CREATE TABLE `refund_serial` (
  `serial_no` varchar(32) NOT NULL COMMENT '退款流水号',
  `redun_order_no` varchar(32) NOT NULL COMMENT '退款订单号',
  `pay_company_no` varchar(32) DEFAULT NULL COMMENT '支付公司',
  `redund_amt` decimal(18,2) DEFAULT NULL COMMENT '退款金额',
  `account_status` varchar(10) DEFAULT NULL COMMENT '记账状态',
  `refund_status` varchar(10) DEFAULT NULL COMMENT '退款状态',
  PRIMARY KEY (`serial_no`,`redun_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `refund_serial` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
