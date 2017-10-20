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

/*Table structure for table `cms_activity` */

DROP TABLE IF EXISTS `cms_activity`;

CREATE TABLE `cms_activity` (
  `id` varchar(18) NOT NULL COMMENT '序号',
  `interest_group_id` varchar(18) DEFAULT NULL COMMENT '所属兴趣组',
  `activity_name` varchar(255) DEFAULT NULL COMMENT '活动名称',
  `activity_logo` varchar(255) DEFAULT NULL COMMENT '活动logo',
  `activity_des` varchar(255) DEFAULT NULL COMMENT '活动摘要',
  `activity_content` varchar(255) DEFAULT NULL COMMENT '活动内容',
  `activity_start_time` timestamp NULL DEFAULT NULL COMMENT '活动开始时间',
  `activity_end_time` timestamp NULL DEFAULT NULL COMMENT '活动结束时间',
  `activity_addr` varchar(100) DEFAULT NULL COMMENT '活动地点',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(18) DEFAULT NULL COMMENT '创建者',
  `flag` varchar(255) DEFAULT NULL COMMENT '状态标识 00：无效；10：推荐；20：置顶',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_activity` */

insert  into `cms_activity`(`id`,`interest_group_id`,`activity_name`,`activity_logo`,`activity_des`,`activity_content`,`activity_start_time`,`activity_end_time`,`activity_addr`,`create_time`,`create_by`,`flag`) values ('1','1','缘来在当地','http://pic6.wed114.cn/20130421/20130421234458107.JPG','简介','2008年，钟扬第三次向上海市科委申请课题，终于成功。实验之后，又建立起10亩大的种植基地。\r\n经佐琴提供的钟扬2010年底向上海市科委报告的内容显示，他们的实验表明，可以通过不断保温抗寒驯化，增强红树在临港地区的适应性，而上海气温外的其余自然条件都符合红树的生长条件。','2017-10-05 11:00:00','2017-10-05 15:00:00','东方明珠','2017-10-06 17:34:50',NULL,'10'),('10','1','咕嘟咕嘟','https://static.vux.li/demo/3.jpg','咕嘟','随着这位植物学家9月25日上午因车祸意外离世，这一宏愿也成为了他的身后事，只能待其他人来完成。','2017-10-19 00:00:00','2017-10-28 23:59:59','阿拉善',NULL,NULL,NULL),('11','1','破破破','http://pic6.wed114.cn/20130421/20130421234458107.JPG','时尚','将生长在更南方的红树，移植到上海，在海边增添一片绵延不断的森林，是钟扬生前特别重视的一个项目。他预计，需要几十年甚至两百年才能完成“南树北移”的心愿。','2017-10-20 00:00:00','2017-10-28 23:59:59','北京',NULL,NULL,NULL),('2','2','使人成熟的是经历，而不是岁月','https://static.vux.li/demo/2.jpg','岁月催人老','但钟扬对此抱有信心，2000年调入上海他就思考谋划这个问题。在他看来，这不仅仅有科研意义，红树林促淤保滩，对空气和水质都有净化作用，如果成功，将是上海一张新的生态名片。','2017-10-06 17:37:13','2017-10-07 17:34:53','天安门','2017-10-06 17:34:55',NULL,'10'),('3','3','绝口不提不是因为忘记，而是因为铭记','https://static.vux.li/demo/3.jpg','铭记','此前，红树林最北生长在温州，上海纬度高了3度，很多人怀疑南树北移的可能性。钟扬生前曾回忆，一位教授听到后，连忙劝说他，“不能瞎搞，这个搞不活的。”','2017-10-06 17:37:16','2017-10-07 17:34:55','故宫','2017-10-06 17:34:58',NULL,'10'),('4','4','嘻哈','https://static.vux.li/demo/2.jpg','嘻嘻哈哈','桐花树已繁衍三代，最近又结了种子。 能否忍受住寒冬，正是红树林落地上海的关键。','2017-10-14 17:37:19','2017-10-15 17:34:59','水立方','2017-10-06 17:35:01',NULL,'20'),('5','1','123木头人','http://pic6.wed114.cn/20130421/20130421234458107.JPG','游戏','“我们已经看到希望了，（桐花树）第三代种子已经开始适应上海气候了，冬天最冷的时候，零下八度，它能承受。”上海虹升农业公司董事长吉临娟说，她的公司是钟扬在当地的合作方。','2017-10-06 17:00:00','2017-10-08 23:59:59','鸟巢',NULL,NULL,NULL),('6','1','瑞奇','https://static.vux.li/demo/2.jpg','狗狗','但好消息是，2011年从珠海接种的两年生桐花树幼苗，到2016年底已繁衍至第三代，耐寒性大大提高。另一种红树“秋茄”，2016年也第一次结了种子，繁衍出第二代。','2017-10-06 17:00:00','2017-10-08 23:59:59','富华游乐园',NULL,NULL,NULL),('7','1','嘟嘟','https://static.vux.li/demo/3.jpg','嘟嘟侠','新场地有限，加之迁徙损害植物的根系，这次搬迁对项目推进影响不小。令经佐琴尤为可惜的是，几十棵长到两米多高的无瓣海棠，未能在搬迁中保留下来。','2017-10-07 00:00:00','2017-10-08 23:59:59','水上皇宫',NULL,NULL,NULL),('8','1','小黄人','http://pic6.wed114.cn/20130421/20130421234458107.JPG','俩眼','“别看你们看到东西不多，其实很不容易。”钟扬生前的助手经佐琴说，原来红树林种在南汇嘴公园，试验种植基地占地十亩，有19个大棚，但2016年底原址要做停车场，只能搬迁。','2017-10-07 00:00:00','2017-10-08 23:59:59','五角大楼',NULL,NULL,NULL),('9','1','绝地武士','https://static.vux.li/demo/2.jpg','手拿荧光棒','去年底移植过来的两大棚红树。 本文图片均为 澎湃新闻记者 赖鑫林 图 9月29日，澎湃新闻（www.thepaper.cn）记者实地探访了这片红树林，从复旦大学驱车80公里，抵达位于上海东南角的南汇新城镇，穿过田垄、泥地，见到了眼前两个大棚，里面种着桐花树、秋茄、无瓣海棠等多种红树，大部分长势良好。','2017-10-18 00:00:00','2017-10-28 23:59:59','迪拜',NULL,NULL,NULL);

/*Table structure for table `cms_activity_customer` */

DROP TABLE IF EXISTS `cms_activity_customer`;

CREATE TABLE `cms_activity_customer` (
  `activity_id` varchar(18) NOT NULL COMMENT '活动序号',
  `customer_id` varchar(18) NOT NULL COMMENT '用户序号',
  PRIMARY KEY (`activity_id`,`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_activity_customer` */

insert  into `cms_activity_customer`(`activity_id`,`customer_id`) values ('1','5'),('10','5'),('11','5'),('2','5'),('9','5');

/*Table structure for table `cms_comment` */

DROP TABLE IF EXISTS `cms_comment`;

CREATE TABLE `cms_comment` (
  `id` varchar(20) NOT NULL COMMENT '主键id',
  `comment_type` varchar(255) DEFAULT NULL COMMENT '评论类型(1评论2回复)',
  `comment_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `comment_target_id` varchar(20) DEFAULT NULL COMMENT '评论的目标id',
  `comment_by_name` varchar(255) DEFAULT NULL COMMENT '发表评论的用户昵称',
  `comment_by` bigint(11) DEFAULT NULL COMMENT '发表评论的用户id',
  `comment_target_user_name` varchar(255) DEFAULT NULL COMMENT '评论的目标用户昵称',
  `comment_target_user_id` bigint(11) DEFAULT NULL COMMENT '评论的目标用户id',
  `comment_likeCount` bigint(11) DEFAULT NULL COMMENT '该评论被点赞的数量',
  `comment_time` timestamp NULL DEFAULT NULL COMMENT '评论时间',
  `comment_module_no` varchar(255) DEFAULT NULL COMMENT '评论模块编号1、圈子2、话题',
  `merchant_id` varchar(20) DEFAULT NULL COMMENT '商户号',
  `org_id` varchar(20) DEFAULT NULL COMMENT '机构号',
  `parent_id` varchar(20) DEFAULT NULL COMMENT '回复评论的目标id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_comment` */

insert  into `cms_comment`(`id`,`comment_type`,`comment_content`,`comment_target_id`,`comment_by_name`,`comment_by`,`comment_target_user_name`,`comment_target_user_id`,`comment_likeCount`,`comment_time`,`comment_module_no`,`merchant_id`,`org_id`,`parent_id`) values ('1','1','fdsafasfsafafsa官方的士大夫赴德国大使馆','232135125','博雷',1,NULL,NULL,NULL,'2017-10-07 00:00:00','2',NULL,NULL,NULL),('114781756879810560','1','fsadfasfas大撒手','232135125','雷继文3',1,NULL,NULL,NULL,'2017-10-09 00:00:00','2',NULL,NULL,NULL),('114787026779516928','1','发点撒疯发点撒大大是否啊啥大事发生嘎洒上发发','232135125','雷继文3',1,NULL,NULL,NULL,'2017-10-09 15:23:45','2',NULL,NULL,NULL),('114787582990364672','1','范德萨发发沙发沙发发生的发生','232135125','雷继文3',1,NULL,NULL,NULL,'2017-10-09 15:25:58','2',NULL,NULL,NULL),('115199333993033728','1','很健康环境','1','飞雷',1,NULL,NULL,0,'2017-10-10 18:42:07','1',NULL,NULL,NULL),('115201880648593408','1','放大时发生大幅改善的风格的话','1','飞雷',1,NULL,NULL,0,'2017-10-10 18:52:14','1',NULL,NULL,NULL),('115205911567675392','1','法国和梵蒂冈','1','飞雷',1,NULL,NULL,0,'2017-10-10 19:08:15','1',NULL,NULL,'115199333993033728'),('115209164623720448','2','范德萨风格的是个好地方','1','飞雷',1,'飞雷',1,0,'2017-10-10 19:21:11','1',NULL,NULL,'115199333993033728'),('115211248228118528','2','公司都斤斤计较斤斤计较','1','飞雷',1,'飞雷',1,0,'2017-10-10 19:29:28','1',NULL,NULL,'115199333993033728'),('115211457221898240','2','法式风格沙发的杀手锏','1','飞雷',1,'飞雷',1,0,'2017-10-10 19:30:18','1',NULL,NULL,'115199333993033728'),('117753043461877760','2','gfdshtgj发点撒疯','232135125','飞雷',1,NULL,NULL,NULL,'2017-10-17 19:49:41','1',NULL,NULL,'115199333993033728'),('117753360266047488','2','范德萨发生过官方灌灌灌灌灌','232135125','飞雷',1,NULL,NULL,NULL,'2017-10-17 19:50:57','1',NULL,NULL,'115199333993033728'),('117753684569632768','2','ffffffsdddd','232135125','飞雷',1,NULL,NULL,NULL,'2017-10-17 19:52:13','1',NULL,NULL,'117755351130189824'),('117754259164114944','2','发声法发顺丰','1','飞雷',1,'飞雷',1,0,'2017-10-17 19:54:29','1',NULL,NULL,'117755351130189824'),('117755351130189824','2','刚回家看见的','1','飞雷',1,'飞雷',1,0,'2017-10-17 19:58:49','1',NULL,NULL,'114787582990364672'),('117755521406349312','2','刚回家看见的谁说的啧啧啧','1','飞雷',1,'飞雷',1,0,'2017-10-17 19:59:30','1',NULL,NULL,'114787582990364672'),('118011389351833600','1','呃呃呃','232135125','飞雷',1,NULL,NULL,NULL,'2017-10-18 12:56:13','2',NULL,NULL,'114787582990364672'),('118011617928818688','2','嗯嗯','1','飞雷',1,'飞雷',1,0,'2017-10-18 12:57:08','1',NULL,NULL,'114787582990364672'),('118011618427940864','2','嗯嗯','1','飞雷',1,'飞雷',1,0,'2017-10-18 12:57:08','1',NULL,NULL,'114787582990364672'),('118067588667551744','2','呃呃呃','1','飞雷',1,'飞雷',1,0,'2017-10-18 16:39:32','1',NULL,NULL,NULL),('118068309773266944','1','哈哈哈少喝点酒','1','飞雷',1,NULL,NULL,0,'2017-10-18 16:42:24','1',NULL,NULL,NULL),('118068542313869312','1','急急急','232135125','飞雷',1,NULL,NULL,NULL,'2017-10-18 16:43:20','2',NULL,NULL,NULL),('118077880147390464','1','ML偶遇','1','飞雷',1,NULL,NULL,0,'2017-10-18 17:20:26','1',NULL,NULL,NULL),('118503056836145152','2','OK','1','飞雷',1,'飞雷',1,0,'2017-10-19 21:29:56','1',NULL,NULL,NULL),('118503159227494400','2','OK','1','飞雷',1,'飞雷',1,0,'2017-10-19 21:30:21','1',NULL,NULL,NULL);

/*Table structure for table `cms_customer_special_column` */

DROP TABLE IF EXISTS `cms_customer_special_column`;

CREATE TABLE `cms_customer_special_column` (
  `customer_id` bigint(11) DEFAULT NULL COMMENT '客户id',
  `special_column_id` bigint(11) DEFAULT NULL COMMENT '客户订阅的专栏id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_customer_special_column` */

insert  into `cms_customer_special_column`(`customer_id`,`special_column_id`) values (1,1),(1,3);

/*Table structure for table `cms_interest_group` */

DROP TABLE IF EXISTS `cms_interest_group`;

CREATE TABLE `cms_interest_group` (
  `id` varchar(18) NOT NULL COMMENT '序号',
  `org_id` varchar(18) DEFAULT NULL COMMENT '所属机构',
  `merchant_id` varchar(18) DEFAULT NULL COMMENT '所属商户',
  `group_category_id` varchar(18) DEFAULT NULL COMMENT '小组所属类别序号',
  `group_name` varchar(255) DEFAULT NULL COMMENT '小组名称',
  `group_logo` varchar(255) DEFAULT NULL COMMENT '小组logo',
  `group_slogan` varchar(255) DEFAULT NULL COMMENT '小组口号',
  `group_intro` varchar(255) DEFAULT NULL COMMENT '小组简介',
  `createtime` varchar(255) DEFAULT NULL COMMENT '小组创建时间',
  `custmer_no` varchar(255) DEFAULT NULL COMMENT '小组创建人',
  `group_address` varchar(255) DEFAULT NULL COMMENT '小组地址',
  `flag` varchar(255) DEFAULT NULL COMMENT '状态标识 00：无效；10：推荐；20：置顶',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_interest_group` */

insert  into `cms_interest_group`(`id`,`org_id`,`merchant_id`,`group_category_id`,`group_name`,`group_logo`,`group_slogan`,`group_intro`,`createtime`,`custmer_no`,`group_address`,`flag`) values ('1','2','1','1','博羸兄弟读书会1','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498377657432&di=3c88ee6faafa397ce0e5f22d3c9250ec&imgtype=0&src=http%3A%2F%2Ffe.topitme.com%2Fe%2F1e%2F41%2F1123162901b2c411eeo.jpg','口号1','1.付费养成好习惯！一个打卡周期为7天，保证金10元，中间如有中断，保证金将注入奖金池，活动结束后平分给打卡成功的人员（平台会扣除少量管理金）2.每日尽量以语音形式打卡，也欢迎将读书内容以图片形式分享。',NULL,NULL,NULL,'20'),('2','2','1','1','博羸兄弟读书会2','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498377657432&di=3c88ee6faafa397ce0e5f22d3c9250ec&imgtype=0&src=http%3A%2F%2Ffe.topitme.com%2Fe%2F1e%2F41%2F1123162901b2c411eeo.jpg','口号2','1.付费养成好习惯！一个打卡周期为7天，保证金10元，中间如有中断，保证金将注入奖金池，活动结束后平分给打卡成功的人员（平台会扣除少量管理金）2.每日尽量以语音形式打卡，也欢迎将读书内容以图片形式分享。',NULL,NULL,NULL,'20'),('3','2','1','2','飞雷开源项目1','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498371853471&di=1ac1aab9cd15bcd5c675cbdf14f5f0a9&imgtype=0&src=http%3A%2F%2Fpic.ffpic.com%2Ffiles%2F2014%2F1217%2F1216wyxqxtpgpsjzm3.jpg','口号3','简介啦啦',NULL,NULL,NULL,'20'),('4','2','1','2','飞雷开源项目2','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498371853471&di=1ac1aab9cd15bcd5c675cbdf14f5f0a9&imgtype=0&src=http%3A%2F%2Fpic.ffpic.com%2Ffiles%2F2014%2F1217%2F1216wyxqxtpgpsjzm3.jpg','口号4','简介碰碰',NULL,NULL,NULL,'20');

/*Table structure for table `cms_interest_group_category` */

DROP TABLE IF EXISTS `cms_interest_group_category`;

CREATE TABLE `cms_interest_group_category` (
  `id` varchar(18) NOT NULL COMMENT '序号',
  `org_id` varchar(18) DEFAULT NULL COMMENT '所属机构',
  `merchant_id` varchar(18) DEFAULT NULL COMMENT '所属商户',
  `category_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `createtime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `flag` varchar(255) DEFAULT NULL COMMENT '状态标志 00：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_interest_group_category` */

insert  into `cms_interest_group_category`(`id`,`org_id`,`merchant_id`,`category_name`,`createtime`,`flag`) values ('1','2','1','读书',NULL,NULL),('2','2','1','社团',NULL,NULL);

/*Table structure for table `cms_interest_group_customer` */

DROP TABLE IF EXISTS `cms_interest_group_customer`;

CREATE TABLE `cms_interest_group_customer` (
  `group_id` varchar(18) NOT NULL COMMENT '团队序号',
  `customer_id` varchar(18) NOT NULL COMMENT '用户序号',
  PRIMARY KEY (`group_id`,`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_interest_group_customer` */

insert  into `cms_interest_group_customer`(`group_id`,`customer_id`) values ('1','5'),('2','5'),('4','5');

/*Table structure for table `cms_special_column` */

DROP TABLE IF EXISTS `cms_special_column`;

CREATE TABLE `cms_special_column` (
  `id` bigint(11) DEFAULT NULL,
  `column_name` varchar(255) DEFAULT NULL COMMENT '专栏名称',
  `column_desc` varchar(255) DEFAULT NULL COMMENT '专栏介绍',
  `column_logo` varchar(255) DEFAULT NULL COMMENT '专栏logo',
  `create_by` bigint(11) DEFAULT NULL COMMENT '专栏创建人',
  `create_time` varchar(255) DEFAULT NULL COMMENT '专栏创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_special_column` */

insert  into `cms_special_column`(`id`,`column_name`,`column_desc`,`column_logo`,`create_by`,`create_time`) values (1,'学长有话说','学长学姐给学弟学妹的留言或建议','http://img1.cache.netease.com/tech/2013/5/17/20130517151816fa504.jpg',121,NULL),(2,'那些我的故事','今日头条李航：深度学习NLP的现有优势与未来挑战','http://img6.cache.netease.com/tech/2011/10/9/20111009144003e4f68.png',121,NULL),(3,'什么情况','没有情况就是最大的情况','http://img6.cache.netease.com/tech/2011/10/9/20111009144003e4f68.png',NULL,NULL);

/*Table structure for table `cms_special_column_content` */

DROP TABLE IF EXISTS `cms_special_column_content`;

CREATE TABLE `cms_special_column_content` (
  `id` bigint(11) NOT NULL,
  `special_column_id` bigint(11) DEFAULT NULL COMMENT '所属专栏',
  `column_content_title` varchar(255) DEFAULT NULL COMMENT '专栏内容名称',
  `column_content_logo` varchar(255) DEFAULT NULL COMMENT '专栏内容Logo',
  `column_content` varchar(255) DEFAULT NULL COMMENT '专栏具体内容',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_special_column_content` */

insert  into `cms_special_column_content`(`id`,`special_column_id`,`column_content_title`,`column_content_logo`,`column_content`,`create_time`,`create_by`) values (1,1,'到底谁在说谎',NULL,'你都忘记自己说了什么了吧','2017-08-11',NULL),(2,1,'今日头条李航：深度学习NLP的现有优势与未来挑战','http://192.168.1.136:8888/static/img/kj.c99540e.png','近日，AI 技术大牛李航博士（已加入今日头条）在《国家科学评论》（National Science Review，NSR）上发表了一篇题为《Deep Learning for Natural Language Processing: Advantages and Challenges》的论文，扼要地探讨了深度学习 NLP 的当前现状与未来机遇。作者认为深度学习可通过与强化学习、推断等技术的结合，进一步扩展 NLP 的边界','2017-08-11',NULL),(3,1,'不知道的故事',NULL,'谁知道谁说了胡话','2017-08-11',NULL);

/*Table structure for table `cms_topic` */

DROP TABLE IF EXISTS `cms_topic`;

CREATE TABLE `cms_topic` (
  `id` varchar(20) NOT NULL COMMENT '主键，雪花算法生成',
  `title` varchar(200) DEFAULT NULL COMMENT '话题标题',
  `content` text COMMENT '话题内容',
  `discription` text COMMENT '描述',
  `img` varchar(50) DEFAULT NULL COMMENT '背景图片',
  `create_by` varchar(20) DEFAULT NULL COMMENT '发起话题人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发起时间',
  `flag` varchar(10) DEFAULT NULL COMMENT '审核删除标识',
  `merchant_id` varchar(20) DEFAULT NULL COMMENT '商户号',
  `org_id` varchar(20) DEFAULT NULL COMMENT '机构号',
  PRIMARY KEY (`id`),
  KEY `create_by` (`create_by`),
  KEY `flag` (`flag`),
  KEY `createTime` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_topic` */

insert  into `cms_topic`(`id`,`title`,`content`,`discription`,`img`,`create_by`,`create_time`,`flag`,`merchant_id`,`org_id`) values ('232135125','xxxxxx','ff仿盛大发发沙发沙发沙发的时光','法师的发生地方嘎是个vvG给','https://timgsa.baidu.com/timg?image&quality=80&siz','1','2017-10-07 19:37:33',NULL,NULL,NULL);

/*Table structure for table `cms_view_favort` */

DROP TABLE IF EXISTS `cms_view_favort`;

CREATE TABLE `cms_view_favort` (
  `id` varchar(20) NOT NULL COMMENT '主键，js无法转化18位数字',
  `create_by` varchar(20) DEFAULT NULL COMMENT '外键索引，用户编号',
  `point_id` varchar(20) DEFAULT NULL COMMENT '外键索引，观点编号',
  `favort_status` int(1) DEFAULT NULL COMMENT '1点赞2取消赞',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `merchant_id` varchar(20) DEFAULT NULL COMMENT '商户号',
  `org_id` varchar(20) DEFAULT NULL COMMENT '机构号',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`create_by`),
  KEY `point_id` (`point_id`),
  KEY `favort_status` (`favort_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_view_favort` */

insert  into `cms_view_favort`(`id`,`create_by`,`point_id`,`favort_status`,`create_time`,`update_time`,`merchant_id`,`org_id`) values ('113995364947996672','1','113685746942226432',1,'2017-10-07 18:54:55','2017-10-07 18:55:04',NULL,NULL),('113995541674995712','1','113686925717811200',2,'2017-10-07 10:58:45','2017-10-07 10:58:54',NULL,NULL),('113995548096475136','1','2',1,'2017-10-07 10:58:42','2017-10-07 10:58:42',NULL,NULL),('114115673135001600','1','1',1,'2017-10-07 18:56:02','2017-10-07 18:56:02',NULL,NULL);

/*Table structure for table `cms_view_point` */

DROP TABLE IF EXISTS `cms_view_point`;

CREATE TABLE `cms_view_point` (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `create_by` bigint(20) DEFAULT NULL COMMENT '索引，用户编号',
  `point_text` text COMMENT '发表观点，文字内容',
  `point_img` varchar(300) DEFAULT NULL COMMENT '发表观点，图片路径，json格式',
  `point_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发表时间',
  `point_address` varchar(50) DEFAULT NULL COMMENT '发表地点',
  `favort_count` int(11) DEFAULT NULL COMMENT '点赞数量',
  `comment_count` int(11) DEFAULT NULL COMMENT '评论数量',
  `merchant_id` varchar(20) DEFAULT NULL COMMENT '商户号',
  `org_id` varchar(20) DEFAULT NULL COMMENT '机构号',
  PRIMARY KEY (`id`),
  KEY `customer_no` (`create_by`),
  KEY `point_time` (`point_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_view_point` */

insert  into `cms_view_point`(`id`,`create_by`,`point_text`,`point_img`,`point_time`,`point_address`,`favort_count`,`comment_count`,`merchant_id`,`org_id`) values ('1',1,'今天很高兴',NULL,'2017-10-19 21:30:21',NULL,1,3,NULL,NULL),('10',1,'哈哈哈',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('11',1,'反复发生的飞洒',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('113682088087269376',1,'ffsdfsafasf',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('113684171045744640',1,'??????????fffffff',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('113685746942226432',1,'gfdgdsgdsgasdfSDFAAF',NULL,'2017-10-07 18:54:55',NULL,1,0,NULL,NULL),('113685880467894272',1,'?????ffasdfffffdddd',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('113686925717811200',1,'???????????',NULL,'2017-10-07 15:21:08',NULL,4,0,NULL,NULL),('113687867909484544',1,'???????',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('113688639346847744',1,'发生大事发生东方航空好过分离开',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('113697885811650560',1,'FGADSFAS四大发顺丰',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('113698853001375744',1,'防守打法沙发沙发是',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('113699404845953024',1,'范德萨发生发撒啊啊啊啊',NULL,'2017-10-06 15:21:47',NULL,0,0,NULL,NULL),('12',1,'仿佛大法',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('13',1,'就很快会干',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('14',1,'范德萨烦恼呢',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('15',1,'放到沙发上',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('16',1,'454',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('17',1,' 活生生的功夫',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('18',1,'反反复复',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('19',1,'凤飞飞的说法',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('2',1,'卡卡卡',NULL,'2017-10-07 10:58:34',NULL,1,0,NULL,NULL),('20',1,'发撒旦发生的',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('21',1,'43151361361',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('22',1,'反反复复撒按时',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('23',1,'反反复复SdAS',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('24',1,'功夫帝国',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('25',1,'古古怪怪',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('26',1,'哈哈哈哈哈哈哈哈哈哈哈哈哈哈',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('27',1,'哈哈哈哈巅峰大赛',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('28',1,'反复反复发生的',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('29',1,'从撒的萨嘎市场v撒旦法所发生的fsdfa',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('3',1,'隐隐约约',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('30',1,'发撒旦发生的',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('31',1,'发货很健康了；；',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('4',1,'4454',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('5',1,'343434',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('6',1,'rrrrr',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('7',1,'任溶溶',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('8',1,'哈哈哈哈',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL),('9',1,'法国换个地方',NULL,'2017-10-06 15:41:18',NULL,0,0,NULL,NULL);

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
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `age` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `merchant_no` varchar(20) DEFAULT NULL COMMENT '商户号',
  `org_no` varchar(10) DEFAULT NULL COMMENT '所属机构',
  `avatar` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_base` */

insert  into `crm_customer_base`(`id`,`customer_no`,`cust_name`,`phone`,`sex`,`address`,`nickname`,`age`,`birthday`,`merchant_no`,`org_no`,`avatar`) values (1,'b3434','雷继文3','1','1','山东','飞雷','1','2017-04-21','1','1','https://timgsa.baidu'),(4,'000000','李发文','15205442200','1','山东','centerroot','1','2017-10-15','1','1','https://git.oschina.net/uploads/images/2017/0604/182759_5137b6fa_61523.jpeg'),(5,'111111','李发文001','15205442200','1','山东','lfw','1','2017-10-16','1','1','https://git.oschina.net/uploads/images/2017/0604/182759_5137b6fa_61523.jpeg');

/*Table structure for table `crm_customer_base_extend` */

DROP TABLE IF EXISTS `crm_customer_base_extend`;

CREATE TABLE `crm_customer_base_extend` (
  `customer_id` bigint(20) NOT NULL COMMENT '客户id,外键',
  `follow_customer_no` varchar(60) DEFAULT NULL COMMENT '关注客户号',
  `school_name` varchar(50) DEFAULT NULL COMMENT '学校',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_base_extend` */

insert  into `crm_customer_base_extend`(`customer_id`,`follow_customer_no`,`school_name`) values (1,'','青岛大学2');

/*Table structure for table `crm_customer_proficient` */

DROP TABLE IF EXISTS `crm_customer_proficient`;

CREATE TABLE `crm_customer_proficient` (
  `customer_id` bigint(20) NOT NULL COMMENT '客户号',
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
  `merchant_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商户名称',
  `brief_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商户简介',
  `merchant_address` varchar(255) DEFAULT NULL COMMENT '商户位置',
  `merchant_phone` int(11) DEFAULT NULL,
  `merchant_logo` char(10) DEFAULT NULL COMMENT '商户logo',
  PRIMARY KEY (`id`,`merchant_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `crm_merchant_base` */

insert  into `crm_merchant_base`(`id`,`merchant_no`,`org_id`,`merchant_name`,`brief_intro`,`merchant_address`,`merchant_phone`,`merchant_logo`) values (1,'admin',2,'测试001','商户简介','商户地址哈哈哈',NULL,NULL);

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
  `id` bigint(20) NOT NULL COMMENT '商户品分类id',
  `product_name` varchar(60) DEFAULT NULL COMMENT '商品名称',
  `product_des` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品描述',
  `product_price` varchar(10) DEFAULT NULL COMMENT '商品价格',
  `product_status` varchar(10) DEFAULT NULL COMMENT '商户状态（上架、下架、推荐、）',
  `merchant_no` bigint(20) DEFAULT NULL COMMENT '所属商户',
  `product_logo` varchar(100) DEFAULT NULL COMMENT '商品首页展示图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `erp_product` */

insert  into `erp_product`(`id`,`product_name`,`product_des`,`product_price`,`product_status`,`merchant_no`,`product_logo`) values (1,'1','1','1','1',1,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(2,'2','2','2','2',2,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(3,'3','3','3','3',3,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(4,'4','4','4','4',4,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(5,'5','5','5','5',5,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(6,'6','6','6','6',6,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(7,'7','7','7','7',7,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(8,'8','8','8','8',8,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(9,'9','9','9','9',9,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(10,'10','10','10','10',10,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(11,'11','11','11','11',11,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(12,'12','12','12','12',12,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(13,'13','13','13','13',13,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg'),(14,'14','14','14','14',14,'https://static.lagou.com/thumbnail_160x160/i/image/M00/03/92/CgqKkVbBYTuACjXlAAAJxQps9mg044.jpg');

/*Table structure for table `erp_product_categary` */

DROP TABLE IF EXISTS `erp_product_categary`;

CREATE TABLE `erp_product_categary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) DEFAULT NULL COMMENT '所属组织机构',
  `categary_name` varbinary(60) DEFAULT NULL COMMENT '商品类名',
  `merchant_id` bigint(10) DEFAULT NULL COMMENT '所属商户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `erp_product_categary` */

insert  into `erp_product_categary`(`id`,`org_id`,`categary_name`,`merchant_id`) values (1,44,'erere',344),(2,NULL,'wewe',NULL),(3,NULL,'2342343',NULL),(4,NULL,'2323232',NULL),(5,NULL,'商品信息',NULL),(6,NULL,'商品信息',NULL),(7,NULL,'商品信息',NULL),(8,NULL,NULL,NULL),(9,NULL,'3434',1),(10,NULL,'3434',1),(11,0,'23232',1),(12,0,'23232343',1);

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

/*Table structure for table `sys_err_code` */

DROP TABLE IF EXISTS `sys_err_code`;

CREATE TABLE `sys_err_code` (
  `app_code` varchar(255) DEFAULT NULL,
  `err_code` varchar(255) NOT NULL,
  `err_msg` varchar(255) DEFAULT NULL,
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`err_code`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_err_code` */

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`chinesename`,`dept`,`email`,`tel`,`sys_role`,`state`,`register_date`,`update_date`,`dimission_date`) values (1,'费雷','','费雷',0,'1136113717@qq.com','1836',2,1,'2017-09-16 11:13:04','2017-09-16 11:12:59','2017-09-16 11:13:01');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
