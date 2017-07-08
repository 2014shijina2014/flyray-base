/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.7.9-log : Database - flyray-security
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`flyray-security` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `flyray-security`;

--  quartz自带表结构

CREATE TABLE QRTZ_JOB_DETAILS(
SCHED_NAME VARCHAR(120) NOT NULL,
JOB_NAME VARCHAR(200) NOT NULL,
JOB_GROUP VARCHAR(200) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
JOB_CLASS_NAME VARCHAR(250) NOT NULL,
IS_DURABLE VARCHAR(1) NOT NULL,
IS_NONCONCURRENT VARCHAR(1) NOT NULL,
IS_UPDATE_DATA VARCHAR(1) NOT NULL,
REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
JOB_NAME VARCHAR(200) NOT NULL,
JOB_GROUP VARCHAR(200) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
NEXT_FIRE_TIME BIGINT(13) NULL,
PREV_FIRE_TIME BIGINT(13) NULL,
PRIORITY INTEGER NULL,
TRIGGER_STATE VARCHAR(16) NOT NULL,
TRIGGER_TYPE VARCHAR(8) NOT NULL,
START_TIME BIGINT(13) NOT NULL,
END_TIME BIGINT(13) NULL,
CALENDAR_NAME VARCHAR(200) NULL,
MISFIRE_INSTR SMALLINT(2) NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_SIMPLE_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
REPEAT_COUNT BIGINT(7) NOT NULL,
REPEAT_INTERVAL BIGINT(12) NOT NULL,
TIMES_TRIGGERED BIGINT(10) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_CRON_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
CRON_EXPRESSION VARCHAR(120) NOT NULL,
TIME_ZONE_ID VARCHAR(80),
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_SIMPROP_TRIGGERS
  (          
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    STR_PROP_1 VARCHAR(512) NULL,
    STR_PROP_2 VARCHAR(512) NULL,
    STR_PROP_3 VARCHAR(512) NULL,
    INT_PROP_1 INT NULL,
    INT_PROP_2 INT NULL,
    LONG_PROP_1 BIGINT NULL,
    LONG_PROP_2 BIGINT NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR(1) NULL,
    BOOL_PROP_2 VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_BLOB_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
BLOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
INDEX (SCHED_NAME,TRIGGER_NAME, TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_CALENDARS (
SCHED_NAME VARCHAR(120) NOT NULL,
CALENDAR_NAME VARCHAR(200) NOT NULL,
CALENDAR BLOB NOT NULL,
PRIMARY KEY (SCHED_NAME,CALENDAR_NAME))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_FIRED_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
ENTRY_ID VARCHAR(95) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
INSTANCE_NAME VARCHAR(200) NOT NULL,
FIRED_TIME BIGINT(13) NOT NULL,
SCHED_TIME BIGINT(13) NOT NULL,
PRIORITY INTEGER NOT NULL,
STATE VARCHAR(16) NOT NULL,
JOB_NAME VARCHAR(200) NULL,
JOB_GROUP VARCHAR(200) NULL,
IS_NONCONCURRENT VARCHAR(1) NULL,
REQUESTS_RECOVERY VARCHAR(1) NULL,
PRIMARY KEY (SCHED_NAME,ENTRY_ID))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_SCHEDULER_STATE (
SCHED_NAME VARCHAR(120) NOT NULL,
INSTANCE_NAME VARCHAR(200) NOT NULL,
LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
CHECKIN_INTERVAL BIGINT(13) NOT NULL,
PRIMARY KEY (SCHED_NAME,INSTANCE_NAME))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_LOCKS (
SCHED_NAME VARCHAR(120) NOT NULL,
LOCK_NAME VARCHAR(40) NOT NULL,
PRIMARY KEY (SCHED_NAME,LOCK_NAME))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE INDEX IDX_QRTZ_J_REQ_RECOVERY ON QRTZ_JOB_DETAILS(SCHED_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_J_GRP ON QRTZ_JOB_DETAILS(SCHED_NAME,JOB_GROUP);

CREATE INDEX IDX_QRTZ_T_J ON QRTZ_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_JG ON QRTZ_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_C ON QRTZ_TRIGGERS(SCHED_NAME,CALENDAR_NAME);
CREATE INDEX IDX_QRTZ_T_G ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_T_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_G_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NEXT_FIRE_TIME ON QRTZ_TRIGGERS(SCHED_NAME,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE_GRP ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE);

CREATE INDEX IDX_QRTZ_FT_TRIG_INST_NAME ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME);
CREATE INDEX IDX_QRTZ_FT_INST_JOB_REQ_RCVRY ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_FT_J_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_JG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_T_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_FT_TG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);

/*Table structure for table `schedule_job` */

DROP TABLE IF EXISTS `schedule_job`;

CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务';

/*Data for the table `schedule_job` */


/*Table structure for table `schedule_job_log` */

DROP TABLE IF EXISTS `schedule_job_log`;

CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

/*Data for the table `schedule_job_log` */


/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

/*Data for the table `sys_config` */

insert  into `sys_config`(`id`,`key`,`value`,`status`,`remark`) values (1,'CLOUD_STORAGE_CONFIG_KEY','{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}',0,'云存储配置信息');

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Data for the table `sys_log` */

insert  into `sys_log`(`id`,`username`,`operation`,`method`,`params`,`ip`,`create_date`) values (1,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"icon\":\"fa fa-tasks\",\"name\":\"组织机构管理\",\"orderNum\":0,\"parentId\":1,\"parentName\":\"系统管理\",\"type\":1,\"url\":\"sys/org.html\"}','0:0:0:0:0:0:0:1','2017-04-04 18:57:06'),(2,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"查看\",\"orderNum\":0,\"parentId\":31,\"parentName\":\"组织机构管理\",\"perms\":\"sys:org:list,sys:org:info\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-04 20:40:19'),(3,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"新增\",\"orderNum\":0,\"parentId\":31,\"parentName\":\"组织机构管理\",\"perms\":\"sys:org:save,sys:org:select\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-04 20:41:37'),(4,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"修改\",\"orderNum\":0,\"parentId\":31,\"parentName\":\"组织机构管理\",\"perms\":\"sys:org:update,sys:org:select\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-04 20:42:34'),(5,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\" 删除\",\"orderNum\":0,\"parentId\":31,\"parentName\":\"组织机构管理\",\"perms\":\"sys:org:delete\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-04 20:43:18'),(6,'admin','保存组织机构','me.flyray.rbac.controller.SysOrgController.save()','{\"orgLevel\":\"12112\",\"orgName\":\"12212\",\"orgNo\":\"飞雷科技\",\"parentId\":0}','0:0:0:0:0:0:0:1','2017-04-05 21:25:38'),(7,'admin','保存组织机构','me.flyray.rbac.controller.SysOrgController.save()','{\"orgLevel\":\"12112\",\"orgName\":\"12212\",\"orgNo\":\"飞雷科技\",\"parentId\":0}','0:0:0:0:0:0:0:1','2017-04-05 21:26:10'),(8,'admin','保存组织机构','me.flyray.rbac.controller.SysOrgController.save()','{\"orgLevel\":\"24\",\"orgName\":\"33\",\"orgNo\":\"33\",\"parentId\":0}','0:0:0:0:0:0:0:1','2017-04-05 21:56:36'),(9,'admin','保存组织机构','me.flyray.rbac.controller.SysOrgController.save()','{\"orgLevel\":\"232\",\"orgName\":\"222\",\"orgNo\":\"飞雷科技\",\"parentId\":0}','0:0:0:0:0:0:0:1','2017-04-05 22:32:10'),(10,'admin','修改组织机构信息','me.flyray.rbac.controller.SysOrgController.update()','{\"createTime\":1491402729000,\"lastUpdateTime\":1491402729000,\"orgId\":2,\"orgLevel\":\"232\",\"orgName\":\"222323\",\"orgNo\":\"飞雷科技\"}','0:0:0:0:0:0:0:1','2017-04-05 22:32:21'),(11,'admin','修改组织机构信息','me.flyray.rbac.controller.SysOrgController.update()','{\"createTime\":1491402729000,\"lastUpdateTime\":1491402729000,\"orgId\":2,\"orgLevel\":\"232\",\"orgName\":\"222444\",\"orgNo\":\"飞雷科技\"}','0:0:0:0:0:0:0:1','2017-04-05 22:33:48'),(12,'admin','修改组织机构信息','me.flyray.rbac.controller.SysOrgController.update()','{\"createTime\":1491402729000,\"lastUpdateTime\":1491402729000,\"orgId\":2,\"orgLevel\":\"232\",\"orgName\":\"222333\",\"orgNo\":\"飞雷科技\"}','0:0:0:0:0:0:0:1','2017-04-05 22:38:20'),(13,'admin','修改组织机构信息','me.flyray.rbac.controller.SysOrgController.update()','{\"createTime\":1491402729000,\"lastUpdateTime\":1491402729000,\"orgId\":2,\"orgLevel\":\"232\",\"orgName\":\"222444\",\"orgNo\":\"飞雷科技\"}','0:0:0:0:0:0:0:1','2017-04-05 22:42:37'),(14,'admin','删除组织机构','me.flyray.rbac.controller.SysOrgController.delete()','[2]','0:0:0:0:0:0:0:1','2017-04-05 22:42:48'),(15,'admin','修改组织机构信息','me.flyray.rbac.controller.SysOrgController.update()','{\"createTime\":1491402729000,\"lastUpdateTime\":1491402729000,\"orgId\":2,\"orgLevel\":\"232\",\"orgName\":\"222444\",\"orgNo\":\"飞雷科技\"}','0:0:0:0:0:0:0:1','2017-04-05 22:42:55'),(16,'admin','保存组织机构','me.flyray.rbac.controller.SysOrgController.save()','{\"orgLevel\":\"23\",\"orgName\":\"232\",\"orgNo\":\"2232\",\"parentId\":0}','0:0:0:0:0:0:0:1','2017-04-05 22:43:11'),(17,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"pay/pay_channel.html\"}','0:0:0:0:0:0:0:1','2017-04-10 21:14:18'),(18,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"支付通道\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"pay/pay_channel.html\"}','0:0:0:0:0:0:0:1','2017-04-10 21:14:30'),(19,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"新增\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"perms\":\"pay:payChannel:save\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-10 21:19:14'),(20,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"新增\",\"orderNum\":0,\"parentId\":36,\"parentName\":\"支付通道\",\"perms\":\"pay:payChannel:save\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-10 21:19:23'),(21,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"支付通道管理\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','0:0:0:0:0:0:0:1','2017-04-10 21:20:46'),(22,'admin','修改菜单','me.flyray.rbac.controller.SysMenuController.update()','{\"menuId\":36,\"name\":\"支付通道\",\"orderNum\":0,\"parentId\":38,\"parentName\":\"支付通道管理\",\"type\":1,\"url\":\"pay/pay_channel.html\"}','0:0:0:0:0:0:0:1','2017-04-10 21:21:44'),(23,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"删除\",\"orderNum\":0,\"parentId\":38,\"parentName\":\"支付通道管理\",\"perms\":\"pay:payChannel:delete\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-10 21:23:16'),(24,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"删除\",\"orderNum\":0,\"parentId\":36,\"parentName\":\"支付通道\",\"perms\":\"pay:payChannel:delete\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-10 21:23:24'),(25,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"修改\",\"orderNum\":0,\"parentId\":36,\"parentName\":\"支付通道\",\"perms\":\"pay:payChannel:update\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-10 21:24:27'),(26,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"查看\",\"orderNum\":0,\"parentId\":36,\"parentName\":\"支付通道\",\"perms\":\"pay:payChannel:list,pay:payChannel:info\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-10 21:36:06'),(27,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"icon\":\"fa fa-address-card-o\",\"name\":\"会员管理\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','0:0:0:0:0:0:0:1','2017-04-13 20:57:23'),(28,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"icon\":\"fa fa-calculator\",\"name\":\"商户管理\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','0:0:0:0:0:0:0:1','2017-04-13 20:58:43'),(29,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"会员信息\",\"orderNum\":0,\"parentId\":42,\"parentName\":\"会员管理\",\"type\":1,\"url\":\"/crm/customer.html\"}','0:0:0:0:0:0:0:1','2017-04-13 21:49:32'),(30,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"会员信息\",\"orderNum\":0,\"parentId\":42,\"parentName\":\"会员管理\",\"type\":1,\"url\":\"/crm/customer.html\"}','0:0:0:0:0:0:0:1','2017-04-13 21:49:33'),(31,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"商户信息\",\"orderNum\":0,\"parentId\":43,\"parentName\":\"商户管理\",\"type\":1,\"url\":\"/crm/merchant.html\"}','0:0:0:0:0:0:0:1','2017-04-13 21:50:24'),(32,'admin','删除菜单','me.flyray.rbac.controller.SysMenuController.delete()','[45]','0:0:0:0:0:0:0:1','2017-04-13 21:51:04'),(33,'admin','修改菜单','me.flyray.rbac.controller.SysMenuController.update()','{\"menuId\":44,\"name\":\"会员信息\",\"orderNum\":0,\"parentId\":42,\"parentName\":\"会员管理\",\"type\":1,\"url\":\"crm/customer.html\"}','0:0:0:0:0:0:0:1','2017-04-16 10:56:01'),(34,'admin','修改菜单','me.flyray.rbac.controller.SysMenuController.update()','{\"menuId\":46,\"name\":\"商户信息\",\"orderNum\":0,\"parentId\":43,\"parentName\":\"商户管理\",\"type\":1,\"url\":\"crm/merchant.html\"}','0:0:0:0:0:0:0:1','2017-04-16 10:56:12'),(35,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"新增\",\"orderNum\":0,\"parentId\":42,\"parentName\":\"会员管理\",\"perms\":\"crm:customer:save\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-16 10:57:45'),(36,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"新增\",\"orderNum\":0,\"parentId\":44,\"parentName\":\"会员信息\",\"perms\":\"crm:customer:save\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-16 10:57:53'),(37,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"删除\",\"orderNum\":0,\"parentId\":44,\"parentName\":\"会员信息\",\"perms\":\"crm:customer:delete\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-16 10:58:30'),(38,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"查询\",\"orderNum\":0,\"parentId\":44,\"parentName\":\"会员信息\",\"perms\":\"crm:customer:list,crm:customer:info\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-16 10:59:33'),(39,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"修改\",\"orderNum\":0,\"parentId\":44,\"parentName\":\"会员信息\",\"perms\":\"crm:customer:update\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-16 11:01:47'),(40,'admin','保存配置','me.flyray.rbac.controller.pay.PayChannelController.save()','{}','0:0:0:0:0:0:0:1','2017-04-16 14:18:46'),(41,'admin','保存配置','me.flyray.rbac.controller.pay.PayChannelController.save()','{}','0:0:0:0:0:0:0:1','2017-04-16 14:20:36'),(42,'admin','保存配置','me.flyray.rbac.controller.pay.PayChannelController.save()','{}','0:0:0:0:0:0:0:1','2017-04-16 14:51:04'),(43,'admin','保存配置','me.flyray.rbac.controller.pay.PayChannelController.save()','{}','0:0:0:0:0:0:0:1','2017-04-16 14:56:26'),(44,'admin','保存配置','me.flyray.rbac.controller.pay.PayChannelController.save()','{\"payChannelNo\":\"test\",\"payCompanyNo\":\"test\",\"feeRatio\":\"1\"}','0:0:0:0:0:0:0:1','2017-04-16 15:50:20'),(45,'admin','保存配置','me.flyray.rbac.controller.pay.PayChannelController.save()','{\"payChannelNo\":\"test2\",\"payCompanyNo\":\"test2\",\"feeRatio\":\"1\"}','0:0:0:0:0:0:0:1','2017-04-16 15:50:47'),(46,'admin','保存配置','me.flyray.rbac.controller.pay.PayChannelController.save()','{\"payChannelNo\":\"test2\",\"payCompanyNo\":\"test2\",\"feeRatio\":\"1\"}','0:0:0:0:0:0:0:1','2017-04-16 15:51:25'),(47,'admin','删除配置','me.flyray.rbac.controller.pay.PayChannelController.delete()','[1]','0:0:0:0:0:0:0:1','2017-04-16 15:51:58'),(48,'admin','保存组织机构','me.flyray.rbac.controller.SysOrgController.save()','{\"orgLevel\":\"5\",\"orgName\":\"54\",\"orgNo\":\"54\",\"parentId\":0}','0:0:0:0:0:0:0:1','2017-04-16 16:01:33'),(49,'admin','修改组织机构信息','me.flyray.rbac.controller.SysOrgController.update()','{\"createTime\":1491403390000,\"lastUpdateTime\":1491403390000,\"orgId\":3,\"orgLevel\":\"233\",\"orgName\":\"2322333333333\",\"orgNo\":\"223233333333\",\"parentId\":232323}','0:0:0:0:0:0:0:1','2017-04-16 16:01:59'),(50,'admin','修改组织机构信息','me.flyray.rbac.controller.SysOrgController.update()','{\"createTime\":1491403390000,\"lastUpdateTime\":1491403390000,\"orgId\":3,\"orgLevel\":\"233\",\"orgName\":\"23\",\"orgNo\":\"2\"}','0:0:0:0:0:0:0:1','2017-04-16 16:02:26'),(51,'admin','保存配置','me.flyray.rbac.controller.pay.PayChannelController.save()','{\"payChannelNo\":\"ee\",\"payCompanyNo\":\"eee\",\"feeRatio\":\"ee\"}','0:0:0:0:0:0:0:1','2017-04-16 16:12:33'),(52,'admin','修改配置','me.flyray.rbac.controller.pay.PayChannelController.update()','{\"payChannelNo\":\"444\",\"payCompanyNo\":\"444\",\"id\":2,\"feeRatio\":\"44\"}','0:0:0:0:0:0:0:1','2017-04-16 17:21:44'),(53,'admin','修改配置','me.flyray.rbac.controller.pay.PayChannelController.update()','{\"payChannelNo\":\"test3\",\"payCompanyNo\":\"test3\",\"id\":5,\"feeRatio\":\"1.00\"}','0:0:0:0:0:0:0:1','2017-04-16 17:25:10'),(54,'admin','修改配置','me.flyray.rbac.controller.pay.PayChannelController.update()','{\"payChannelNo\":\"test3\",\"payCompanyNo\":\"test3\",\"id\":5,\"feeRatio\":1}','0:0:0:0:0:0:0:1','2017-04-16 17:41:41'),(55,'admin','修改配置','me.flyray.rbac.controller.pay.PayChannelController.update()','{\"payChannelNo\":\"test4\",\"payCompanyNo\":\"test4\",\"id\":5,\"feeRatio\":\"1.00\"}','0:0:0:0:0:0:0:1','2017-04-16 18:48:00'),(56,'admin','修改配置','me.flyray.rbac.controller.pay.PayChannelController.update()','{\"payChannelNo\":\"test3\",\"payCompanyNo\":\"test3\",\"id\":5,\"feeRatio\":\"1.00\"}','0:0:0:0:0:0:0:1','2017-04-16 18:58:29'),(57,'admin','修改配置','me.flyray.rbac.controller.pay.PayChannelController.update()','{\"payChannelNo\":\"test3\",\"payCompanyNo\":\"test3\",\"id\":5,\"feeRatio\":\"1.00\"}','0:0:0:0:0:0:0:1','2017-04-16 19:14:33'),(58,'admin','修改配置','me.flyray.rbac.controller.pay.PayChannelController.update()','{\"payChannelNo\":\"test1\",\"payCompanyNo\":\"test1\",\"id\":2,\"feeRatio\":\"9\"}','0:0:0:0:0:0:0:1','2017-04-16 19:15:10'),(59,'admin','修改配置','me.flyray.rbac.controller.pay.PayChannelController.update()','{\"payChannelNo\":\"test0\",\"payCompanyNo\":\"test0\",\"id\":1,\"feeRatio\":\"0\"}','0:0:0:0:0:0:0:1','2017-04-16 19:15:31'),(60,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 09:37:55'),(61,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 09:47:11'),(62,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 10:15:01'),(63,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 11:29:37'),(64,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 12:10:24'),(65,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 12:15:28'),(66,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 12:19:07'),(67,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 12:20:22'),(68,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 12:21:30'),(69,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 12:44:08'),(70,'admin','保存配置','me.flyray.rbac.controller.pay.PayChannelController.save()','{\"payChannelNo\":\"testtttt\",\"payCompanyNo\":\"t4ettttt\",\"feeRatio\":\"1\"}','0:0:0:0:0:0:0:1','2017-04-21 14:30:55'),(71,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 16:30:12'),(72,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 16:57:51'),(73,'admin','保存客户会员','me.flyray.rbac.controller.crm.CustomerController.save()','{}','0:0:0:0:0:0:0:1','2017-04-21 17:25:45'),(74,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"商品管理\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','0:0:0:0:0:0:0:1','2017-04-24 22:33:29'),(75,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"icon\":\"fa fa-film\",\"name\":\"商品分类\",\"orderNum\":0,\"parentId\":51,\"parentName\":\"商品管理\",\"type\":1,\"url\":\"erp/product_categary.html\"}','0:0:0:0:0:0:0:1','2017-04-24 22:36:37'),(76,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"新增\",\"orderNum\":0,\"parentId\":52,\"parentName\":\"商品分类\",\"perms\":\"erp:productCategary:save\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-24 22:37:51'),(77,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"查看\",\"orderNum\":0,\"parentId\":52,\"parentName\":\"商品分类\",\"perms\":\"erp:productCategary:list,erp:productCategary:info\\t\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-24 22:38:52'),(78,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"删除\",\"orderNum\":0,\"parentId\":52,\"parentName\":\"商品分类\",\"perms\":\"erp:productCategary:delete\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-24 22:39:48'),(79,'admin','保存菜单','me.flyray.rbac.controller.SysMenuController.save()','{\"name\":\"更新\",\"orderNum\":0,\"parentId\":52,\"parentName\":\"商品分类\",\"perms\":\"erp:productCategary:delete\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-24 22:40:09'),(80,'admin','保存客户会员','me.flyray.rbac.controller.erp.ProductCategaryController.save()','{\"categaryName\":\"33\",\"orgId\":\"33\",\"merchantNo\":\"33\"}','0:0:0:0:0:0:0:1','2017-04-24 22:51:34'),(81,'admin','保存客户会员','me.flyray.rbac.controller.erp.ProductCategaryController.save()','{\"categaryName\":\"eee\",\"orgId\":\"444\",\"merchantNo\":\"eeee\"}','0:0:0:0:0:0:0:1','2017-04-24 23:00:29'),(82,'admin','保存客户会员','me.flyray.rbac.controller.erp.ProductCategaryController.save()','{\"categaryName\":\"erere\",\"orgId\":\"44\",\"merchantNo\":\"344r\"}','0:0:0:0:0:0:0:1','2017-04-24 23:08:33'),(83,'admin','修改菜单','me.flyray.rbac.controller.SysMenuController.update()','{\"menuId\":56,\"name\":\"更新\",\"orderNum\":0,\"parentId\":52,\"parentName\":\"商品分类\",\"perms\":\"erp:productCategary:update\",\"type\":2}','0:0:0:0:0:0:0:1','2017-04-24 23:10:21');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`parent_id`,`name`,`url`,`perms`,`type`,`icon`,`order_num`) values (1,0,'系统管理',NULL,NULL,0,'fa fa-cog',0),(2,1,'管理员列表','sys/user.html',NULL,1,'fa fa-user',1),(3,1,'角色管理','sys/role.html',NULL,1,'fa fa-user-secret',2),(4,1,'菜单管理','sys/menu.html',NULL,1,'fa fa-th-list',3),(5,1,'SQL监控','druid/sql.html',NULL,1,'fa fa-bug',4),(6,1,'定时任务','sys/schedule.html',NULL,1,'fa fa-tasks',5),(7,6,'查看',NULL,'sys:schedule:list,sys:schedule:info',2,NULL,0),(8,6,'新增',NULL,'sys:schedule:save',2,NULL,0),(9,6,'修改',NULL,'sys:schedule:update',2,NULL,0),(10,6,'删除',NULL,'sys:schedule:delete',2,NULL,0),(11,6,'暂停',NULL,'sys:schedule:pause',2,NULL,0),(12,6,'恢复',NULL,'sys:schedule:resume',2,NULL,0),(13,6,'立即执行',NULL,'sys:schedule:run',2,NULL,0),(14,6,'日志列表',NULL,'sys:schedule:log',2,NULL,0),(15,2,'查看',NULL,'sys:user:list,sys:user:info',2,NULL,0),(16,2,'新增',NULL,'sys:user:save,sys:role:select',2,NULL,0),(17,2,'修改',NULL,'sys:user:update,sys:role:select',2,NULL,0),(18,2,'删除',NULL,'sys:user:delete',2,NULL,0),(19,3,'查看',NULL,'sys:role:list,sys:role:info',2,NULL,0),(20,3,'新增',NULL,'sys:role:save,sys:menu:perms',2,NULL,0),(21,3,'修改',NULL,'sys:role:update,sys:menu:perms',2,NULL,0),(22,3,'删除',NULL,'sys:role:delete',2,NULL,0),(23,4,'查看',NULL,'sys:menu:list,sys:menu:info',2,NULL,0),(24,4,'新增',NULL,'sys:menu:save,sys:menu:select',2,NULL,0),(25,4,'修改',NULL,'sys:menu:update,sys:menu:select',2,NULL,0),(26,4,'删除',NULL,'sys:menu:delete',2,NULL,0),(27,1,'参数管理','sys/config.html','sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete',1,'fa fa-sun-o',6),(28,1,'代码生成器','sys/generator.html','sys:generator:list,sys:generator:code',1,'fa fa-rocket',8),(29,1,'系统日志','sys/log.html','sys:log:list',1,'fa fa-file-text-o',7),(30,1,'文件上传','sys/oss.html','sys:oss:all',1,'fa fa-file-image-o',6),(31,1,'组织机构管理','sys/org.html',NULL,1,'fa fa-tasks',0),(32,31,'查看',NULL,'sys:org:list,sys:org:info',2,NULL,0),(33,31,'新增',NULL,'sys:org:save,sys:org:select',2,NULL,0),(34,31,'修改',NULL,'sys:org:update,sys:org:select',2,NULL,0),(35,31,' 删除',NULL,'sys:org:delete',2,NULL,0),(36,38,'支付通道','pay/pay_channel.html',NULL,1,NULL,0),(37,36,'新增',NULL,'pay:payChannel:save',2,NULL,0),(38,0,'支付通道管理',NULL,NULL,0,NULL,0),(39,36,'删除',NULL,'pay:payChannel:delete',2,NULL,0),(40,36,'修改',NULL,'pay:payChannel:update',2,NULL,0),(41,36,'查看',NULL,'pay:payChannel:list,pay:payChannel:info',2,NULL,0),(42,0,'会员管理',NULL,NULL,0,'fa fa-address-card-o',0),(43,0,'商户管理',NULL,NULL,0,'fa fa-calculator',0),(44,42,'会员信息','crm/customer.html',NULL,1,NULL,0),(46,43,'商户信息','crm/merchant.html',NULL,1,NULL,0),(47,44,'新增',NULL,'crm:customer:save',2,NULL,0),(48,44,'删除',NULL,'crm:customer:delete',2,NULL,0),(49,44,'查询',NULL,'crm:customer:list,crm:customer:info',2,NULL,0),(50,44,'修改',NULL,'crm:customer:update',2,NULL,0),(51,0,'商品管理',NULL,NULL,0,NULL,0),(52,51,'商品分类','erp/product_categary.html',NULL,1,'fa fa-film',0),(53,52,'新增',NULL,'erp:productCategary:save',2,NULL,0),(54,52,'查看',NULL,'erp:productCategary:list,erp:productCategary:info	',2,NULL,0),(55,52,'删除',NULL,'erp:productCategary:delete',2,NULL,0),(56,52,'更新',NULL,'erp:productCategary:update',2,NULL,0);

/*Table structure for table `sys_org` */

DROP TABLE IF EXISTS `sys_org`;

CREATE TABLE `sys_org` (
  `org_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `org_no` varchar(32) DEFAULT NULL COMMENT '机构部门编号',
  `org_name` varchar(60) DEFAULT NULL COMMENT '机构部门名称',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '所属机构部门',
  `create_by` bigint(11) DEFAULT NULL COMMENT '创建人user_id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update_by` bigint(11) DEFAULT NULL COMMENT '最后修改人user_id',
  `last_update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `org_sort` int(11) DEFAULT NULL COMMENT '机构部门排序号',
  `status_flag` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `sys_org` */

insert  into `sys_org`(`org_id`,`org_no`,`org_name`,`parent_id`,`create_by`,`create_time`,`last_update_by`,`last_update_time`,`org_level`) values (3,'2','23',NULL,NULL,'2017-04-05 22:43:10',NULL,'2017-04-05 22:43:10',233),(4,'54','54',NULL,NULL,'2017-04-16 16:01:32',NULL,'2017-04-16 16:01:32',5);

/*Table structure for table `sys_oss` */

DROP TABLE IF EXISTS `sys_oss`;

CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文件上传';

/*Data for the table `sys_oss` */

insert  into `sys_oss`(`id`,`url`,`create_date`) values (1,'http://7xqbwh.dl1.z0.glb.clouddn.com/upload/20170330/044d99a1f13e45f0ba291a7713d4d800','2017-03-30 22:55:43');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*Data for the table `sys_role_menu` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`username`,`password`,`email`,`mobile`,`status`,`create_user_id`,`create_time`) values (1,'admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','root@renren.io','13612345678',1,NULL,'2016-11-11 11:11:11');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sort_no` int(11) DEFAULT NULL COMMENT '排序编号',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级字典',
  `dict_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `dict_type` varchar(255) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';



/*Data for the table `sys_user_role` */

/*Table structure for table `tb_token` */

DROP TABLE IF EXISTS `tb_token`;

CREATE TABLE `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

/*Data for the table `tb_token` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `tb_user` */

insert  into `tb_user`(`user_id`,`username`,`mobile`,`password`,`create_time`) values (1,'mark','13612345678','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','2017-03-23 22:37:41');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
