/*Table structure for table `pay_channel` */

DROP TABLE IF EXISTS `pay_channel`;

CREATE TABLE `pay_channel` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `pay_channel_no` VARCHAR(32) DEFAULT NULL COMMENT ' 支付通道编号',
  `pay_company_no` VARCHAR(32) DEFAULT NULL COMMENT '支付公司',
  `fee_ratio` DECIMAL(18,2) DEFAULT NULL COMMENT ' 通道费率',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `pay_channel` */

/*Table structure for table `pay_channel_config` */

DROP TABLE IF EXISTS `pay_channel_config`;

CREATE TABLE `pay_channel_config` (
  `pay_channel_no` VARCHAR(32) DEFAULT NULL COMMENT ' 支付通道编号',
  `pay_company_no` VARCHAR(32) DEFAULT NULL COMMENT '支付公司',
  `org_no` VARCHAR(32) DEFAULT NULL COMMENT '组织机构',
  `merchant_no` VARCHAR(32) DEFAULT NULL COMMENT '商户号'
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `pay_channel_config` */

/*Table structure for table `pay_channel_interface` */

DROP TABLE IF EXISTS `pay_channel_interface`;

CREATE TABLE `pay_channel_interface` (
  `pay_channel_no` VARCHAR(32) DEFAULT NULL COMMENT '支付通道编号',
  `pay_service_name` VARCHAR(32) DEFAULT NULL COMMENT '支付接口名称',
  `refund_service_name` VARCHAR(32) DEFAULT NULL COMMENT '退款接口名称'
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `pay_channel_interface` */

/*Table structure for table `pay_order` */

DROP TABLE IF EXISTS `pay_order`;

CREATE TABLE `pay_order` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `pay_order_no` VARCHAR(60) NOT NULL COMMENT ' 订单号',
  `customer_no` VARCHAR(60) DEFAULT NULL COMMENT '客户账号',
  `merchant_no` VARCHAR(60) DEFAULT NULL COMMENT ' 商户账号',
  `pay_time` DATETIME DEFAULT NULL COMMENT '交易时间',
  `pay_fee` DECIMAL(18,2) DEFAULT NULL COMMENT '交易手续费',
  `pay_amt` DECIMAL(18,2) DEFAULT NULL COMMENT '交易金额',
  `body` TEXT COMMENT '订单描述',
  `pay_method` VARCHAR(32) DEFAULT NULL COMMENT '支付方式（1支付宝2微信3余额 13余额支付宝）',
  `order_status` VARCHAR(10) DEFAULT NULL COMMENT '交易状态（未支付、支付中、支付失败、支付成功、已部分退款、已退款）',
  `org_no` VARCHAR(32) DEFAULT NULL COMMENT '机构编号',
  `redunded_amt` DECIMAL(18,2) DEFAULT NULL COMMENT ' 已退款金额',
  PRIMARY KEY (`id`,`pay_order_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `pay_order` */

/*Table structure for table `pay_serial` */

DROP TABLE IF EXISTS `pay_serial`;

CREATE TABLE `pay_serial` (
  `serial_no` VARCHAR(32) NOT NULL COMMENT '支付流水号',
  `pay_order_no` VARCHAR(32) NOT NULL COMMENT '订单号',
  `pay_channel_no` VARCHAR(32) DEFAULT NULL COMMENT '支付渠道号',
  `pay_company_no` VARCHAR(32) DEFAULT NULL COMMENT '支付公司编号',
  `pay_amt` DECIMAL(18,2) DEFAULT NULL COMMENT '交易金额',
  `pay_fee` DECIMAL(18,0) DEFAULT NULL COMMENT '交易手续费',
  `account_status` VARCHAR(10) DEFAULT NULL COMMENT '支付记账状态',
  `pay_status` VARCHAR(10) DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`serial_no`,`pay_order_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `pay_serial` */

/*Table structure for table `refund_order` */

DROP TABLE IF EXISTS `refund_order`;

CREATE TABLE `refund_order` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `pay_order_no` VARCHAR(32) NOT NULL COMMENT '支付订单号',
  `refund_order_no` VARCHAR(32) DEFAULT NULL COMMENT '退款订单号',
  `refund_amt` DECIMAL(18,2) DEFAULT NULL COMMENT '退款金额',
  `org_no` VARCHAR(32) DEFAULT NULL COMMENT ' 机构编号',
  `refund_fee` DECIMAL(18,2) DEFAULT NULL COMMENT '退款手续费',
  `refund_time` DATETIME DEFAULT NULL COMMENT '退款时间',
  `refund_reason` TEXT COMMENT '退款原因',
  `refund_method` VARCHAR(10) DEFAULT NULL COMMENT '跟支付方式对应',
  PRIMARY KEY (`id`,`pay_order_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `refund_order` */

/*Table structure for table `refund_serial` */

DROP TABLE IF EXISTS `refund_serial`;

CREATE TABLE `refund_serial` (
  `serial_no` VARCHAR(32) NOT NULL COMMENT '退款流水号',
  `redun_order_no` VARCHAR(32) NOT NULL COMMENT '退款订单号',
  `pay_company_no` VARCHAR(32) DEFAULT NULL COMMENT '支付公司',
  `redund_amt` DECIMAL(18,2) DEFAULT NULL COMMENT '退款金额',
  `account_status` VARCHAR(10) DEFAULT NULL COMMENT '记账状态',
  `refund_status` VARCHAR(10) DEFAULT NULL COMMENT '退款状态',
  PRIMARY KEY (`serial_no`,`redun_order_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `refund_serial` */