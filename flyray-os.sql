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
  `highlights` text COMMENT '活动花絮',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_activity` */

insert  into `cms_activity`(`id`,`interest_group_id`,`activity_name`,`activity_logo`,`activity_des`,`activity_content`,`activity_start_time`,`activity_end_time`,`activity_addr`,`create_time`,`create_by`,`flag`,`highlights`) values ('1','1','缘来在当地','http://pic6.wed114.cn/20130421/20130421234458107.JPG','简介','2008年，钟扬第三次向上海市科委申请课题，终于成功。实验之后，又建立起10亩大的种植基地。\r\n经佐琴提供的钟扬2010年底向上海市科委报告的内容显示，他们的实验表明，可以通过不断保温抗寒驯化，增强红树在临港地区的适应性，而上海气温外的其余自然条件都符合红树的生长条件。','2017-11-15 11:00:00','2017-12-30 15:00:00','东方明珠','2017-10-06 17:34:50',NULL,'10','<p>伺服电机浪费<br></p><p><strong>士大夫</strong></p><p><span><em><strong>撒地方看见实力打脸士大夫飞</strong></em></span></p><p>士大夫萨科技<strong><br></strong></p><p><img src=\"http://ueditor.baidu.com/server/ueditor/upload/image/demo.jpg\" title=\"\" alt=\"demo.jpg\" _src=\"/server/ueditor/upload/image/demo.jpg\"></p><p><img src=\"http://img.baidu.com/hi/jx2/j_0025.gif\" _src=\"http://img.baidu.com/hi/jx2/j_0025.gif\">​胜多少的几番</p>'),('10','1','咕嘟咕嘟','https://static.vux.li/demo/3.jpg','咕嘟','随着这位植物学家9月25日上午因车祸意外离世，这一宏愿也成为了他的身后事，只能待其他人来完成。','2017-11-16 00:00:00','2017-12-30 23:59:59','阿拉善',NULL,NULL,NULL,NULL),('11','1','破破破','http://pic6.wed114.cn/20130421/20130421234458107.JPG','时尚','将生长在更南方的红树，移植到上海，在海边增添一片绵延不断的森林，是钟扬生前特别重视的一个项目。他预计，需要几十年甚至两百年才能完成“南树北移”的心愿。','2017-11-17 00:00:00','2017-12-09 23:59:59','北京',NULL,NULL,NULL,NULL),('2','2','使人成熟的是经历，而不是岁月','https://static.vux.li/demo/2.jpg','岁月催人老','但钟扬对此抱有信心，2000年调入上海他就思考谋划这个问题。在他看来，这不仅仅有科研意义，红树林促淤保滩，对空气和水质都有净化作用，如果成功，将是上海一张新的生态名片。','2017-11-18 17:37:13','2017-12-19 17:34:53','天安门','2017-10-06 17:34:55',NULL,'10',NULL),('3','3','绝口不提不是因为忘记，而是因为铭记','https://static.vux.li/demo/3.jpg','铭记','此前，红树林最北生长在温州，上海纬度高了3度，很多人怀疑南树北移的可能性。钟扬生前曾回忆，一位教授听到后，连忙劝说他，“不能瞎搞，这个搞不活的。”','2017-11-06 17:37:16','2017-12-16 17:34:55','故宫','2017-10-06 17:34:58',NULL,'10',NULL),('4','4','嘻哈','https://static.vux.li/demo/2.jpg','嘻嘻哈哈','桐花树已繁衍三代，最近又结了种子。 能否忍受住寒冬，正是红树林落地上海的关键。','2017-11-14 17:37:19','2017-12-15 17:34:59','水立方','2017-10-06 17:35:01',NULL,'20',NULL),('5','1','123木头人','http://pic6.wed114.cn/20130421/20130421234458107.JPG','游戏','“我们已经看到希望了，（桐花树）第三代种子已经开始适应上海气候了，冬天最冷的时候，零下八度，它能承受。”上海虹升农业公司董事长吉临娟说，她的公司是钟扬在当地的合作方。','2017-11-06 17:00:00','2017-12-17 23:59:59','鸟巢',NULL,NULL,NULL,NULL),('6','1','瑞奇','https://static.vux.li/demo/2.jpg','狗狗','但好消息是，2011年从珠海接种的两年生桐花树幼苗，到2016年底已繁衍至第三代，耐寒性大大提高。另一种红树“秋茄”，2016年也第一次结了种子，繁衍出第二代。','2017-11-06 17:00:00','2017-12-08 23:59:59','富华游乐园',NULL,NULL,NULL,NULL),('7','1','嘟嘟','https://static.vux.li/demo/3.jpg','嘟嘟侠','新场地有限，加之迁徙损害植物的根系，这次搬迁对项目推进影响不小。令经佐琴尤为可惜的是，几十棵长到两米多高的无瓣海棠，未能在搬迁中保留下来。','2017-11-07 00:00:00','2017-12-16 23:59:59','水上皇宫',NULL,NULL,NULL,NULL),('8','1','小黄人','http://pic6.wed114.cn/20130421/20130421234458107.JPG','俩眼','“别看你们看到东西不多，其实很不容易。”钟扬生前的助手经佐琴说，原来红树林种在南汇嘴公园，试验种植基地占地十亩，有19个大棚，但2016年底原址要做停车场，只能搬迁。','2017-10-07 00:00:00','2017-10-30 23:59:59','五角大楼',NULL,NULL,NULL,'<p>伺服电机浪费<br></p><p><strong>士大夫</strong></p><p><span><em><strong>撒地方看见实力打脸士大夫飞</strong></em></span></p><p>士大夫萨科技<strong><br></strong></p><p><img src=\"http://ueditor.baidu.com/server/ueditor/upload/image/demo.jpg\" title=\"\" alt=\"demo.jpg\" _src=\"/server/ueditor/upload/image/demo.jpg\"></p><p><img src=\"http://img.baidu.com/hi/jx2/j_0025.gif\" _src=\"http://img.baidu.com/hi/jx2/j_0025.gif\">​胜多少的几番</p>'),('9','1','绝地武士','https://static.vux.li/demo/2.jpg','手拿荧光棒','去年底移植过来的两大棚红树。 本文图片均为 澎湃新闻记者 赖鑫林 图 9月29日，澎湃新闻（www.thepaper.cn）记者实地探访了这片红树林，从复旦大学驱车80公里，抵达位于上海东南角的南汇新城镇，穿过田垄、泥地，见到了眼前两个大棚，里面种着桐花树、秋茄、无瓣海棠等多种红树，大部分长势良好。','2017-11-18 00:00:00','2017-12-16 23:59:59','迪拜',NULL,NULL,NULL,NULL);

/*Table structure for table `cms_activity_customer` */

DROP TABLE IF EXISTS `cms_activity_customer`;

CREATE TABLE `cms_activity_customer` (
  `activity_id` varchar(18) NOT NULL COMMENT '活动序号',
  `customer_id` varchar(18) NOT NULL COMMENT '用户序号',
  PRIMARY KEY (`activity_id`,`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_activity_customer` */

insert  into `cms_activity_customer`(`activity_id`,`customer_id`) values ('1','124935467304235008'),('1','125020732127457280'),('1','125027187480080384'),('10','125020732127457280'),('11','125020732127457280'),('9','125020732127457280');

/*Table structure for table `cms_comment` */

DROP TABLE IF EXISTS `cms_comment`;

CREATE TABLE `cms_comment` (
  `id` varchar(35) NOT NULL COMMENT '主键id',
  `comment_type` varchar(255) DEFAULT NULL COMMENT '评论类型(1评论2回复)',
  `comment_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `comment_target_id` varchar(35) DEFAULT NULL COMMENT '评论的目标id',
  `comment_by_name` varchar(255) DEFAULT NULL COMMENT '发表评论的用户昵称',
  `comment_by` varchar(32) DEFAULT NULL COMMENT '发表评论的用户id',
  `comment_target_user_name` varchar(255) DEFAULT NULL COMMENT '评论的目标用户昵称',
  `comment_target_user_id` varchar(32) DEFAULT NULL COMMENT '评论的目标用户id',
  `comment_likeCount` bigint(11) DEFAULT NULL COMMENT '该评论被点赞的数量',
  `comment_time` timestamp NULL DEFAULT NULL COMMENT '评论时间',
  `comment_module_no` varchar(255) DEFAULT NULL COMMENT '评论模块编号1、圈子2、话题',
  `merchant_id` varchar(20) DEFAULT NULL COMMENT '商户号',
  `org_id` varchar(20) DEFAULT NULL COMMENT '机构号',
  `parent_id` varchar(20) DEFAULT NULL COMMENT '回复评论的目标id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_comment` */

insert  into `cms_comment`(`id`,`comment_type`,`comment_content`,`comment_target_id`,`comment_by_name`,`comment_by`,`comment_target_user_name`,`comment_target_user_id`,`comment_likeCount`,`comment_time`,`comment_module_no`,`merchant_id`,`org_id`,`parent_id`) values ('130268144131649536','1','能评论了','3','博羸兄弟','124935467304235008',NULL,NULL,0,'2017-11-21 08:40:11','04',NULL,NULL,NULL),('130268242286751744','1','能评论了','3','博羸兄弟','124935467304235008',NULL,NULL,0,'2017-11-21 08:40:35','01',NULL,NULL,NULL),('130271202139975680','1','可以的','2','博羸兄弟','124935467304235008',NULL,NULL,0,'2017-11-21 08:52:21','01',NULL,NULL,NULL),('130853973904338944','1','做一个登陆','124642962226556928','博羸兄弟','124935467304235008',NULL,NULL,0,'2017-11-22 23:28:04','03',NULL,NULL,NULL),('131123306693931008','1','时间末尾还有一个点','124642962226556928','留白','125024706939334656',NULL,NULL,0,'2017-11-23 17:18:18','03',NULL,NULL,NULL),('131123450990571520','1','时间颜色好像有点太深了','124642962226556928','留白','125024706939334656',NULL,NULL,0,'2017-11-23 17:18:53','03',NULL,NULL,NULL),('131123848572841984','1','数据是后台添加的吗','2','留白','125024706939334656',NULL,NULL,0,'2017-11-23 17:20:27','01',NULL,NULL,NULL),('131521548858437632','1','是的','124642962226556928','博羸兄弟','124935467304235008',NULL,NULL,0,'2017-11-24 19:40:46','03',NULL,NULL,NULL),('131521921069363200','1','什么情况','1','博羸兄弟','124935467304235008',NULL,NULL,0,'2017-11-24 19:42:15','01',NULL,NULL,NULL),('131565113751908352','1','世界经济数据','232135125','博羸兄弟','124935467304235008',NULL,NULL,0,'2017-11-24 22:33:53','03',NULL,NULL,NULL),('131741768948658176','1','后台写专栏','2','飞雷(flyray.me)','126053428421210112',NULL,NULL,0,'2017-11-25 10:15:51','01',NULL,NULL,NULL),('131742069768335360','1','对于这个话题，我绝对没意见！','124642962226556928','飞雷(flyray.me)','126053428421210112',NULL,NULL,0,'2017-11-25 10:17:03','03',NULL,NULL,NULL),('132645908390359040','1','写代码！','132274596790677504','Alex','126099747600871424',NULL,NULL,0,'2017-11-27 22:08:35','02',NULL,NULL,NULL),('132646031568678912','1','写','132274596790677504','Alex','126099747600871424',NULL,NULL,0,'2017-11-27 22:09:04','02',NULL,NULL,NULL),('132646072341508096','2','代码','132274596790677504','Alex','126099747600871424','Alex','126099747600871424',0,'2017-11-27 22:09:14','02',NULL,NULL,NULL),('132646144881995776','1','写','132274596790677504','Alex','126099747600871424',NULL,NULL,0,'2017-11-27 22:09:31','02',NULL,NULL,NULL),('132649462626791424','1','什么年会？','132646497228697600','博羸兄弟','124935467304235008',NULL,NULL,0,'2017-11-27 22:22:42','02',NULL,NULL,NULL),('132649621322477568','2','哈哈','132274596790677504','博羸兄弟','124935467304235008','Alex','126099747600871424',0,'2017-11-27 22:23:20','02',NULL,NULL,NULL),('132649984696004608','1','活动怎么都开始了','2','博羸兄弟','124935467304235008',NULL,NULL,0,'2017-11-27 22:24:47','04',NULL,NULL,NULL);

/*Table structure for table `cms_customer_special_column` */

DROP TABLE IF EXISTS `cms_customer_special_column`;

CREATE TABLE `cms_customer_special_column` (
  `customer_id` bigint(11) DEFAULT NULL COMMENT '客户id',
  `special_column_id` bigint(11) DEFAULT NULL COMMENT '客户订阅的专栏id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_customer_special_column` */

insert  into `cms_customer_special_column`(`customer_id`,`special_column_id`) values (1,1),(1,3),(0,1),(0,1),(124935467304235008,3),(125027187480080384,2),(127173699538530304,1);

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

insert  into `cms_interest_group`(`id`,`org_id`,`merchant_id`,`group_category_id`,`group_name`,`group_logo`,`group_slogan`,`group_intro`,`createtime`,`custmer_no`,`group_address`,`flag`) values ('1','2','1','1','博羸兄弟读书会1','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498377657432&di=3c88ee6faafa397ce0e5f22d3c9250ec&imgtype=0&src=http%3A%2F%2Ffe.topitme.com%2Fe%2F1e%2F41%2F1123162901b2c411eeo.jpg','口号1','1.付费养成好习惯！一个打卡周期为7天，保证金10元，中间如有中断，保证金将注入奖金池，活动结束后平分给打卡成功的人员（平台会扣除少量管理金）2.每日尽量以语音形式打卡，也欢迎将读书内容以图片形式分享。',NULL,NULL,NULL,'80'),('2','2','1','1','博羸兄弟读书会2','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498377657432&di=3c88ee6faafa397ce0e5f22d3c9250ec&imgtype=0&src=http%3A%2F%2Ffe.topitme.com%2Fe%2F1e%2F41%2F1123162901b2c411eeo.jpg','口号2','1.付费养成好习惯！一个打卡周期为7天，保证金10元，中间如有中断，保证金将注入奖金池，活动结束后平分给打卡成功的人员（平台会扣除少量管理金）2.每日尽量以语音形式打卡，也欢迎将读书内容以图片形式分享。',NULL,NULL,NULL,'20'),('3','2','1','2','飞雷开源项目1','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498371853471&di=1ac1aab9cd15bcd5c675cbdf14f5f0a9&imgtype=0&src=http%3A%2F%2Fpic.ffpic.com%2Ffiles%2F2014%2F1217%2F1216wyxqxtpgpsjzm3.jpg','口号3','简介啦啦',NULL,NULL,NULL,'20'),('4','2','1','2','飞雷开源项目2','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498371853471&di=1ac1aab9cd15bcd5c675cbdf14f5f0a9&imgtype=0&src=http%3A%2F%2Fpic.ffpic.com%2Ffiles%2F2014%2F1217%2F1216wyxqxtpgpsjzm3.jpg','口号4','简介碰碰',NULL,NULL,NULL,'20'),('5','2','1','3','驴友户外1','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498371853471&di=1ac1aab9cd15bcd5c675cbdf14f5f0a9&imgtype=0&src=http%3A%2F%2Fpic.ffpic.com%2Ffiles%2F2014%2F1217%2F1216wyxqxtpgpsjzm3.jpg','说走就走','走啦',NULL,NULL,NULL,'20'),('6','2','1','3','驴友户外2','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498371853471&di=1ac1aab9cd15bcd5c675cbdf14f5f0a9&imgtype=0&src=http%3A%2F%2Fpic.ffpic.com%2Ffiles%2F2014%2F1217%2F1216wyxqxtpgpsjzm3.jpg','说来就来','哈哈',NULL,NULL,NULL,'20');

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

insert  into `cms_interest_group_category`(`id`,`org_id`,`merchant_id`,`category_name`,`createtime`,`flag`) values ('1','2','1','读书',NULL,NULL),('2','2','1','社团',NULL,NULL),('3','2','1','户外',NULL,NULL);

/*Table structure for table `cms_interest_group_customer` */

DROP TABLE IF EXISTS `cms_interest_group_customer`;

CREATE TABLE `cms_interest_group_customer` (
  `group_id` varchar(18) NOT NULL COMMENT '团队序号',
  `customer_id` varchar(18) NOT NULL COMMENT '用户序号',
  PRIMARY KEY (`group_id`,`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_interest_group_customer` */

insert  into `cms_interest_group_customer`(`group_id`,`customer_id`) values ('1','125020732127457280'),('2','124935467304235008'),('2','125024706939334656'),('2','138715242221023232'),('4','124935467304235008'),('5','138715242221023232'),('6','138715242221023232');

/*Table structure for table `cms_special_column` */

DROP TABLE IF EXISTS `cms_special_column`;

CREATE TABLE `cms_special_column` (
  `id` bigint(11) NOT NULL DEFAULT '0',
  `column_name` varchar(255) DEFAULT NULL COMMENT '专栏名称',
  `column_desc` varchar(255) DEFAULT NULL COMMENT '专栏介绍',
  `column_logo` varchar(255) DEFAULT NULL COMMENT '专栏logo',
  `create_by` bigint(11) DEFAULT NULL COMMENT '专栏创建人',
  `create_time` varchar(255) DEFAULT NULL COMMENT '专栏创建时间',
  `column_status` varchar(10) DEFAULT NULL COMMENT '专栏状态：0上架1下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_special_column` */

insert  into `cms_special_column`(`id`,`column_name`,`column_desc`,`column_logo`,`create_by`,`create_time`,`column_status`) values (1,'学长有话说','学长学姐给学弟学妹的留言或建议','http://images.china.cn/attachement/jpg/site1000/20171101/6c0b840a25301b63b4a90c.jpg',121,NULL,'1'),(2,'那些我的故事','今日头条李航：深度学习NLP的现有优势与未来挑战','http://images.china.cn/attachement/jpg/site1000/20171101/6c0b840a25301b63b4a90c.jpg',121,NULL,'1'),(126397786123153408,'test2','test2','http://images.china.cn/attachement/jpg/site1000/20171101/6c0b840a25301b63b4a90c.jpg',1,NULL,'1');

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
  `img` varchar(250) DEFAULT NULL COMMENT '背景图片',
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

insert  into `cms_topic`(`id`,`title`,`content`,`discription`,`img`,`create_by`,`create_time`,`flag`,`merchant_id`,`org_id`) values ('124642962226556928','fdsafa25463','\n            <i><i>\n        </i></i>\n            <i><i>\n        </i></i>\n            <i><i>\n        </i></i>\n            <i><i>\n        </i></i>\n            <i><i>\n        </i></i>\n            <i><i>\n        </i></i>\n            <i><i>\n        </i></i>\n            <i><i>\n        </i></i>\n            <i><i>\n        </i></i>adasf2hfdsgggggggggggggggggg灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌灌古古怪怪古古怪怪古古怪怪古古怪怪古古怪怪古古怪怪嘎嘎嘎三顿饭豆豆豆豆豆豆豆豆豆豆豆豆豆豆豆豆豆豆豆豆豆44444444444444444444666666666','fsdafas266435','1511707251864.png','1','2017-11-26 22:40:49',NULL,NULL,NULL),('232135125','如何规划大学生涯','ff仿盛大发发沙发沙发沙发的时光','法师的发生地方嘎是个vvG给','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509612925250&di=79ee7798e9001db7b363a2e860cf5131&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D3484471702%2C1705537644%26fm%3D214%26gp%3D0.jpg','1','2017-10-07 19:37:33',NULL,NULL,NULL);

/*Table structure for table `cms_view_favort` */

DROP TABLE IF EXISTS `cms_view_favort`;

CREATE TABLE `cms_view_favort` (
  `id` varchar(35) NOT NULL COMMENT '主键，js无法转化18位数字',
  `create_by` varchar(35) DEFAULT NULL COMMENT '外键索引，用户编号',
  `point_id` varchar(35) DEFAULT NULL COMMENT '外键索引，观点编号',
  `favort_status` int(1) DEFAULT NULL COMMENT '1点赞2取消赞',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `merchant_id` varchar(35) DEFAULT NULL COMMENT '商户号',
  `org_id` varchar(35) DEFAULT NULL COMMENT '机构号',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`create_by`),
  KEY `point_id` (`point_id`),
  KEY `favort_status` (`favort_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_view_favort` */

insert  into `cms_view_favort`(`id`,`create_by`,`point_id`,`favort_status`,`create_time`,`update_time`,`merchant_id`,`org_id`) values ('126748671240056832','1','126726883575607296',1,'2017-11-11 15:34:55','2017-11-11 15:35:20','1','2'),('129724861915607040','1','127099322797142016',1,'2017-11-19 20:41:23','2017-11-19 20:41:23','1','2'),('130070694989148160','1','129724837521534976',2,'2017-11-26 15:30:35','2017-11-26 15:30:35','1','2'),('131123087109533696','1','131123066909765632',1,'2017-11-23 17:17:26','2017-11-23 17:17:26','1','2'),('131221397916889088','1','131221363427127296',2,'2017-11-26 17:37:28','2017-11-26 17:37:29','1','2'),('131221407345684480','1','130778146722295808',2,'2017-11-25 10:12:55','2017-11-25 10:12:56','1','2'),('131777030290419712','1','127097385477484544',1,'2017-11-25 12:35:58','2017-11-25 12:35:58','1','2'),('132183376630394880','1','131739452342284288',1,'2017-11-26 15:30:38','2017-11-26 15:30:38','1','2'),('132223947734528000','1','131741516355088384',1,'2017-11-26 18:11:51','2017-11-26 18:11:51','1','2'),('132645602222944256','1','132274596790677504',1,'2017-11-27 22:07:22','2017-11-27 22:07:22','1','2'),('145287041591291904','1','127090358147624960',1,'2018-01-01 19:19:56','2018-01-01 19:19:56','1','2');

/*Table structure for table `cms_view_point` */

DROP TABLE IF EXISTS `cms_view_point`;

CREATE TABLE `cms_view_point` (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `create_by` varchar(32) DEFAULT NULL COMMENT '索引，用户编号',
  `point_text` text COMMENT '发表观点，文字内容',
  `point_img` varchar(300) DEFAULT NULL COMMENT '发表观点，图片路径，json格式',
  `point_time` timestamp NULL DEFAULT NULL COMMENT '发表时间',
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

insert  into `cms_view_point`(`id`,`create_by`,`point_text`,`point_img`,`point_time`,`point_address`,`favort_count`,`comment_count`,`merchant_id`,`org_id`) values ('126726883575607296','124935467304235008','测试期间数据暂时不持久化',NULL,'2017-11-11 14:08:29',NULL,1,7,NULL,NULL),('126795219973976064','124935467304235008','种子用户在哪里',NULL,'2017-11-11 18:40:02',NULL,0,0,NULL,NULL),('127090358147624960','126660841503469568','厉害了，',NULL,'2017-11-12 14:12:48',NULL,1,0,NULL,NULL),('127091613263736832','126099747600871424','厉害了',NULL,'2017-11-12 14:17:47',NULL,0,0,NULL,NULL),('127097385477484544','127096453364723712','不能传图片啊……',NULL,'2017-11-12 14:40:44',NULL,1,1,NULL,NULL),('127099322797142016','124935467304235008','图片上传还在优化中',NULL,'2017-11-12 14:48:26',NULL,1,0,NULL,NULL),('127146078998114304','124935467304235008','中年的危机意识太强',NULL,'2017-11-12 17:54:13',NULL,0,0,NULL,NULL),('127146304211267584','124935467304235008','还需要开发一个匿名功能',NULL,'2017-11-12 17:55:07',NULL,0,0,NULL,NULL),('127417770873991168','127417305234944000','','1510545229515.jpg','2017-11-13 11:53:50',NULL,0,0,NULL,NULL),('127941121736454144','124935467304235008','每天都坚持，一年后就与众不同',NULL,'2017-11-14 22:33:26',NULL,0,0,NULL,NULL),('128952478854295552','124935467304235008','量变引起质变，先上量！',NULL,'2017-11-17 17:32:12',NULL,0,0,NULL,NULL),('129404404947496960','124935467304235008','好像没毛病','1511018879989.jpeg','2017-11-18 23:28:00',NULL,0,0,NULL,NULL),('129724837521534976','124935467304235008','活动转发要修复一下',NULL,'2017-11-19 20:41:17',NULL,0,1,NULL,NULL),('130778146722295808','124935467304235008','好好的家',NULL,'2017-11-22 18:26:46',NULL,0,0,NULL,NULL),('131123066909765632','125024706939334656','随便看看',NULL,'2017-11-23 17:17:21',NULL,1,0,NULL,NULL),('131221363427127296','125231749239418880','就这么简单',NULL,'2017-11-23 23:47:57',NULL,0,0,NULL,NULL),('131566439252635648','124935467304235008','show','1511534349135.jpeg','2017-11-24 22:39:09',NULL,0,0,NULL,NULL),('131739452342284288','124935467304235008','难过的时候就看一看大海！',NULL,'2017-11-25 10:06:39',NULL,1,0,NULL,NULL),('131741516355088384','126053428421210112','我要像风一样自由！',NULL,'2017-11-25 10:14:51',NULL,1,0,NULL,NULL),('131880969379786752','124935467304235008','故事从这里发生！',NULL,'2017-11-25 19:28:59',NULL,0,0,NULL,NULL),('132183451175759872','126053428421210112','每天脑洞大开',NULL,'2017-11-26 15:30:56',NULL,0,0,NULL,NULL),('132274596790677504','124935467304235008','没人玩，我该想点什么办法呢',NULL,'2017-11-26 21:33:07',NULL,1,6,NULL,NULL),('132646497228697600','126099747600871424','年会年会',NULL,'2017-11-27 22:10:55',NULL,0,1,NULL,NULL),('134078220453818368','124935467304235008','多么怀念夏天，可以跑步、打球',NULL,'2017-12-01 21:00:04',NULL,0,0,NULL,NULL),('134078736168660992','124935467304235008','总算想明白了一件事，只需要为自己就好！',NULL,'2017-12-01 21:02:07',NULL,0,0,NULL,NULL),('136268010695700480','124935467304235008','不知道努力是为了什么，但不努力又是为了什么！',NULL,'2017-12-07 22:01:31',NULL,0,0,NULL,NULL),('153257141116088320','126099747600871424','还没做好？',NULL,'2018-01-23 19:10:15',NULL,0,0,NULL,NULL),('153257872040669184','126099747600871424','','1516705989719.JPG','2018-01-23 19:13:10',NULL,0,0,NULL,NULL);

/*Table structure for table `crm_customer_account` */

DROP TABLE IF EXISTS `crm_customer_account`;

CREATE TABLE `crm_customer_account` (
  `customer_id` varchar(60) DEFAULT NULL,
  `customer_account_no` varchar(60) DEFAULT NULL,
  `account_type` varchar(2) DEFAULT NULL,
  `value` varchar(20) DEFAULT '0',
  `freeze_value` varchar(20) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_account` */

insert  into `crm_customer_account`(`customer_id`,`customer_account_no`,`account_type`,`value`,`freeze_value`) values ('124935467304235008',NULL,'03','75','0'),('125020732127457280',NULL,'03','0','0'),('125024706939334656',NULL,'03','0','0'),('125027187480080384',NULL,'03','0','0'),('125231749239418880',NULL,'03','0','0'),('125342037682958336',NULL,'03','0','0'),('125377732019499008',NULL,'03','0','0'),('125736368432492544',NULL,'03','0','0'),('125749963648151552',NULL,'03','0','0'),('126053428421210112',NULL,'03','0','0'),('126099747600871424',NULL,'03','0','0'),('126660841503469568',NULL,'03','0','0'),('126720488717430784',NULL,'03','0','0'),('126720680652976128',NULL,'03','0','0'),('126721100876099584',NULL,'03','0','0'),('126721242664546304',NULL,'03','0','0'),('126721674510086144',NULL,'03','0','0'),('126721945306935296',NULL,'03','0','0'),('126722487613665280',NULL,'03','0','0'),('126723718797078528',NULL,'03','0','0'),('126724384697364480',NULL,'03','0','0'),('126729437567004672',NULL,'03','0','0'),('126732601615724544',NULL,'03','0','0'),('126735878193426432',NULL,'03','0','0'),('126740676863078400',NULL,'03','0','0'),('126744430152790016',NULL,'03','0','0'),('126746094897213440',NULL,'03','0','0'),('126762816261861376',NULL,'03','0','0'),('126769398613815296',NULL,'03','0','0'),('126808397889941504',NULL,'03','0','0'),('126852762964340736',NULL,'03','0','0'),('126854309177733120',NULL,'03','0','0'),('127096453364723712',NULL,'03','0','0'),('127096481688858624',NULL,'03','0','0'),('127096606842695680',NULL,'03','0','0'),('127098179597643776',NULL,'03','0','0'),('127098777697005568',NULL,'03','0','0'),('127098875675947008',NULL,'03','0','0'),('127109414108016640',NULL,'03','0','0'),('127116486442758144','12711648796948480056B1','03','0','0'),('127119959322275840','12711996022824550483B7','03','0','0'),('127126861485715456','1271268623287705603FD9','03','0','0'),('127138764375207936','1271387652769832961D48','03','0','0'),('127148722001031168','127148722894417920E404','03','0','0'),('127162697531011072','127162698420203520BEDB','03','0','0'),('127164447885373440','1271644487745658884662','03','0','0'),('127167389786976256','1271673906719744001AC7','03','0','0'),('127167837096914944','127167837981913088E1F0','03','0','0'),('127173699538530304','12717370042352844869EC','03','0','0'),('127176397306474496','1271763981872783364F91','03','0','0'),('127176605994070016','127176606761627648AB63','03','0','0'),('127181562700902400','12718156359428915249D7','03','0','0'),('127417305234944000','12741730611155353685D4','03','0','0'),('127417308036739072','127417308804296704A162','03','0','0'),('127419547459530752','127419548348723200BA97','03','0','0'),('127422419966373888','127422420847177728B738','03','0','0'),('127430050978213888','127430051838046208ACD4','03','0','0'),('127435046662713344','12743504754351718451AD','03','0','0'),('127519511858655232','1275195127394590725960','03','0','0'),('127582142950813696','1275821438358118404D86','03','0','0'),('131683906943725568','1316839084830351366962','03','5','0'),('131741455688675328','1317414564394557449E39','03','0','0'),('131744270830022656','1317442716395233286199','03','0','0'),('131749622489296896','1317496233491292161D5F','03','0','0'),('131834453873143808','1318344547371704322156','03','0','0'),('131961241374830592','13196124223046860811F0','03','0','0'),('132223253480747008','132223254365745152E282','03','0','0'),('132223879489007616','13222388032786841611D8','03','0','0'),('132224891129966592','132224891960438784BADF','03','0','0'),('132226845084233728','1322268459147059202A29','03','0','0'),('132230445445427200','13223044628848230425CB','03','0','0'),('132241231500816384','132241232331288576AE13','03','0','0'),('132621535377895424','1326215362335334407D3E','03','0','0'),('132626610548649984','1326266113413734402940','03','0','0'),('132626992872042496','132626993685737472BC0F','03','0','0'),('132650697064984576','1326506978660966404C1E','03','0','0'),('138715242221023232','1387152437016125446726','03','0','0'),('139686805137272832','13968680669335961679A2','03','0','0'),('145867009387933696','1458670109817692161F34','03','0','0'),('153936539460841472','15393654174673715255F4','03','0','0');

/*Table structure for table `crm_customer_account_journal` */

DROP TABLE IF EXISTS `crm_customer_account_journal`;

CREATE TABLE `crm_customer_account_journal` (
  `id` bigint(11) DEFAULT NULL COMMENT '流水ID',
  `Journal_no` varchar(255) DEFAULT NULL COMMENT '流水号',
  `customer_id` varchar(255) DEFAULT NULL COMMENT '客户号',
  `customer_account_no` varchar(255) DEFAULT NULL COMMENT '客户账户',
  `amt` decimal(10,2) DEFAULT NULL COMMENT '发生额',
  `funds_direction` varchar(10) DEFAULT NULL COMMENT '发生额方向 借方 贷方',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_account_journal` */

insert  into `crm_customer_account_journal`(`id`,`Journal_no`,`customer_id`,`customer_account_no`,`amt`,`funds_direction`,`create_time`) values (132204416026816512,'2017112616541400000',NULL,NULL,'5.00','00','2017-11-26 16:54:15'),(132204483458641920,'2017112616543000001',NULL,NULL,'5.00','00','2017-11-26 16:54:31'),(132208087066226688,'2017112617084900002',NULL,NULL,'5.00','00','2017-11-26 17:08:50'),(132208216456310784,'2017112617092000003',NULL,NULL,'5.00','00','2017-11-26 17:09:21'),(132209755728130048,'2017112617152700004',NULL,NULL,'5.00','00','2017-11-26 17:15:28'),(132223255217188864,'2017112618090600000',NULL,NULL,'5.00','00','2017-11-26 18:09:06'),(132223881128980480,'2017112618113500001',NULL,NULL,'5.00','00','2017-11-26 18:11:35'),(132224892753162240,'2017112618153600002',NULL,NULL,'5.00','00','2017-11-26 18:15:37'),(132226846707429376,'2017112618232200003',NULL,NULL,'5.00','00','2017-11-26 18:23:23'),(132230447228006400,'2017112618374000004',NULL,'1316839084830351366962','5.00','00','2017-11-26 18:37:41'),(132241233128206336,'2017112619203200005',NULL,NULL,'5.00','00','2017-11-26 19:20:33'),(132621537080782848,'2017112720314400000',NULL,NULL,'5.00','00','2017-11-27 20:31:44'),(132626612142485504,'2017112720515400001',NULL,NULL,'5.00','00','2017-11-27 20:51:54'),(132626994453295104,'2017112720532500002',NULL,NULL,'5.00','00','2017-11-27 20:53:25'),(132650698683985920,'2017112722273600003',NULL,NULL,'5.00','00','2017-11-27 22:27:37'),(138715244464975872,'2017121416055700004',NULL,NULL,'5.00','00','2017-12-14 16:05:57');

/*Table structure for table `crm_customer_auth` */

DROP TABLE IF EXISTS `crm_customer_auth`;

CREATE TABLE `crm_customer_auth` (
  `customer_id` varchar(20) NOT NULL COMMENT '客户（会员）Id\n            ',
  `identity_type` varchar(20) DEFAULT NULL COMMENT '登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）',
  `identifier` varchar(20) DEFAULT NULL COMMENT '标识（手机号 邮箱 用户名或第三方应用的唯一标识）',
  `credential` varchar(64) DEFAULT NULL COMMENT '密码凭证（站内的保存密码，站外的不保存或保存token）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_auth` */

insert  into `crm_customer_auth`(`customer_id`,`identity_type`,`identifier`,`credential`) values ('124935467304235008','weixin',NULL,'o-rSJ08RGemk_BQH1PBi1kzOcSnA'),('125020732127457280','weixin',NULL,'o-rSJ01XQ3FPcNd8hk7Lhc8PPO1U'),('125024706939334656','weixin',NULL,'o-rSJ040yBrZAnD0LHEWIr7tB_DM'),('125027187480080384','weixin',NULL,'o-rSJ0wF3Ge08uPX4PqA1OoU7E2w'),('125231749239418880','weixin',NULL,'o-rSJ06U42APVKjT4DX9kgImsGoQ'),('125342037682958336','weixin',NULL,'o-rSJ0w5BATyo76qBeCMnFa2HrZg'),('125377732019499008','weixin',NULL,'o-rSJ0xyH_bgCbcVMNko_Qfvx7q0'),('125736368432492544','weixin',NULL,'o-rSJ06-qcCZjH7HJbfUs4KGtqf0'),('125749963648151552','weixin',NULL,'o-rSJ0-yrHjtThz_cjpyesz7Grq0'),('126053428421210112','weixin',NULL,'o-rSJ0yTlMCZcvDM_1Y8acijyELE'),('126099747600871424','weixin',NULL,'o-rSJ05WOOf7yvdc6UiwU-F9wMbg'),('126660841503469568','weixin',NULL,'o-rSJ002sR-H57WVkrGnE6IRQLMk'),('126720488717430784','weixin',NULL,'o-rSJ03FVd-XOCXE0Cd5dw-ykocs'),('126720680652976128','weixin',NULL,'o-rSJ09v95I2eR-EbmHRNpLB220o'),('126721100876099584','weixin',NULL,'o-rSJ0zyOEmP3l8EWQUC7reJXyi0'),('126721242664546304','weixin',NULL,'o-rSJ04FJ-DW2rnd4omRrX-eBvuM'),('126721674510086144','weixin',NULL,'o-rSJ02mKGdiBiOxlaLlTzJQsvtg'),('126721945306935296','weixin',NULL,'o-rSJ09xb1-DE8wt5rUJcGbwxC-w'),('126722487613665280','weixin',NULL,'o-rSJ03CWxxTViRHY-wXR3qGvGrk'),('126723718797078528','weixin',NULL,'o-rSJ09HNh7pAnx83rvLNYC16ozA'),('126724384697364480','weixin',NULL,'o-rSJ02_lm39Ew7TSvs7Tn0xuNDs'),('126729437567004672','weixin',NULL,'o-rSJ01AUI-6ApQO0lpFaoNcGzbw'),('126732601615724544','weixin',NULL,'o-rSJ07RhEaay8lJe6v6t6uvM8Zs'),('126735878193426432','weixin',NULL,'o-rSJ0w05MUAbddFcJ5vESt2lEO8'),('126740676863078400','weixin',NULL,'o-rSJ05k3rBYtl6Nf11-r4nAoj6M'),('126744430152790016','weixin',NULL,'o-rSJ00a2qotjIml4Kvw242HoKIE'),('126746094897213440','weixin',NULL,'o-rSJ07F3lLQ0wBHozVUTLeo7Mag'),('126762816261861376','weixin',NULL,'o-rSJ01SS4NpDJNKtmB08uRExAfg'),('126769398613815296','weixin',NULL,'o-rSJ0651yRWmkX47KS0NmWmm8TE'),('126808397889941504','weixin',NULL,'o-rSJ01xNn-S0UvuJSc6LnKpCo-s'),('126852762964340736','weixin',NULL,'o-rSJ06hADzmRUmE0tZDWons6dX4'),('126854309177733120','weixin',NULL,'o-rSJ03oMtMteJCBd3PDHy7gD6fA'),('127096453364723712','weixin',NULL,'o-rSJ0zGM5jOFdA1kIQCN8SWgznU'),('127096481688858624','weixin',NULL,'o-rSJ0_M1iruqdEgEY1Qw7z4w2oM'),('127096606842695680','weixin',NULL,'o-rSJ07cJKb1OYC_c9-tH4qXwCPQ'),('127098179597643776','weixin',NULL,'o-rSJ065m_Sr4vhTvNB55zGeRer4'),('127098777697005568','weixin',NULL,'o-rSJ07lTQ0ewflmTVyt4c3pzDbI'),('127098875675947008','weixin',NULL,'o-rSJ017hXKV7POHnw-BjkkPUC2Q'),('127109414108016640','weixin',NULL,'o-rSJ0_3IcPUcsBSuVNuTcWAGiZ4'),('127116486442758144','weixin',NULL,'o-rSJ06xChtsnVwFtTptlHP7hmMA'),('127119959322275840','weixin',NULL,'o-rSJ08ERf4kAtbb96NL_hLpZrCY'),('127126861485715456','weixin',NULL,'o-rSJ02gDwLoSFGh9QdUWng93ZkQ'),('127138764375207936','weixin',NULL,'o-rSJ08-6RglwSaJWkwIz-sph8lU'),('127148722001031168','weixin',NULL,'o-rSJ0-k4B1cQ7KecOs-bP2y_Ou0'),('127162697531011072','weixin',NULL,'o-rSJ04JDuw3cswC-TYlfL-B_IbA'),('127164447885373440','weixin',NULL,'o-rSJ0wKWBWC-LO8s4X0_Zox38eY'),('127167389786976256','weixin',NULL,'o-rSJ0_zMWS3nuy3jeKerWvBpGJc'),('127167837096914944','weixin',NULL,'o-rSJ0zMQ-xs87jDZX_xnGWn85mU'),('127173699538530304','weixin',NULL,'o-rSJ08nXZPj39hlbBCHTSyLbMNM'),('127176397306474496','weixin',NULL,'o-rSJ01StYYnuDmv-U03PGBlaipA'),('127176605994070016','weixin',NULL,'o-rSJ0zUYgNUeyERXV8B66NEO9oM'),('127181562700902400','weixin',NULL,'o-rSJ03zI_4iNn9rGS-CJm0MrR2E'),('127417305234944000','weixin',NULL,'o-rSJ09Ad0OnXIwqx4h7vscNvOvM'),('127417308036739072','weixin',NULL,'o-rSJ0wHR01-8F5OcDWwOLfo3DAQ'),('127419547459530752','weixin',NULL,'o-rSJ07VDFieZJeP1Y-1wwdRbYf4'),('127422419966373888','weixin',NULL,'o-rSJ08Ms5VpWo5CejgtZAThAl3M'),('127430050978213888','weixin',NULL,'o-rSJ0w2yDHnFQyxvdNobtSKvv98'),('127435046662713344','weixin',NULL,'o-rSJ01hwrG7xXsAV2wPtwEsRaD4'),('127519511858655232','weixin',NULL,'o-rSJ06_D7GdKJzXtLvRQM4Zj3B4'),('127582142950813696','weixin',NULL,'o-rSJ03OrJkKWoqsiJnzbZeo9fbc'),('131683906943725568','weixin',NULL,'o-rSJ02EEIvUYMRGhSiN1l1L3a0I'),('131741455688675328','weixin',NULL,'o-rSJ04ne3MpdG76m1A_Mjuncfi8'),('131744270830022656','weixin',NULL,'o-rSJ01J9LRF3kNLUrZHV0HyjONs'),('131749622489296896','weixin',NULL,'o-rSJ01qaufS007GBFJTqt6D5m5c'),('131834453873143808','weixin',NULL,'o-rSJ0xa0AJGFwl14fjbljoV3Mw8'),('131961241374830592','weixin',NULL,'o-rSJ0x06HeirldoOy_PhHyIh1G0'),('132223253480747008','weixin',NULL,'o-rSJ081fgtAUXc4TBBSc2TFZNXo'),('132223879489007616','weixin',NULL,'o-rSJ0-ai_uQtRJ0bUcKCkW8Kr9E'),('132224891129966592','weixin',NULL,'o-rSJ01zNpi0cWYoc8isSu5fcwLs'),('132226845084233728','weixin',NULL,'o-rSJ0zVP91-V7O_UXf7eCHZ2pHM'),('132230445445427200','weixin',NULL,'o-rSJ08JVPCAedMavtrYksmOlcns'),('132241231500816384','weixin',NULL,'o-rSJ0--R5_gcZicO2WVFvhSyrJA'),('132621535377895424','weixin',NULL,'o-rSJ05p1EF7YJ51OdeJsMm08erU'),('132626610548649984','weixin',NULL,'o-rSJ08nr0ggCgCa74fXCEwXFzK4'),('132626992872042496','weixin',NULL,'o-rSJ0ygUvFCzrUyIMYDCpJWoI8g'),('132650697064984576','weixin',NULL,'o-rSJ0xe-F4uEsXDj10567Es5dsQ'),('138715242221023232','weixin',NULL,'o-rSJ0zVdipfV6eLnIApmQK7QyMg'),('139686805137272832','weixin',NULL,'o-rSJ08GsaGc8PYniAFEKxiU6HmE'),('145867009387933696','weixin',NULL,'o-rSJ0wiGq2SO7i2g045PUa-3wFw'),('153936539460841472','weixin',NULL,'o-rSJ0xlSVZZA6iDtfuLoQarPVeg');

/*Table structure for table `crm_customer_base` */

DROP TABLE IF EXISTS `crm_customer_base`;

CREATE TABLE `crm_customer_base` (
  `id` varchar(20) NOT NULL,
  `customer_no` varchar(60) DEFAULT NULL COMMENT '客户号',
  `cust_name` varchar(30) DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `age` varchar(3) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `merchant_id` varchar(20) DEFAULT NULL COMMENT '商户号',
  `org_id` varchar(10) DEFAULT NULL COMMENT '所属机构',
  `avatar` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_base` */

insert  into `crm_customer_base`(`id`,`customer_no`,`cust_name`,`phone`,`sex`,`address`,`nickname`,`age`,`birthday`,`merchant_id`,`org_id`,`avatar`) values ('124935467304235008','124935467304235008B958',NULL,'1365754777','男','中国-广东-深圳','博羸兄弟',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erMgmcaSXhxkxMQp3LemJFYoicrw20VEuaZ6OSHOiawOzibMe7iclXicJRicbomXibyXBoaxfY23MBHZxleg/0'),('125020732127457280','12502073212745728073CB',NULL,'15205442200','男','阿鲁巴--','CenterRoot',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK2LQJJqvGX6KqoMbHiahRVv8nJyRYAPIJibBo06BD28gWN6Jicic6x9IS5nuuXmIw1qGVDDCQbM30wAQ/0'),('125024706939334656','125024706939334656A69A',NULL,NULL,'男','厄立特里亚--','留白',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLf3rtBCgIYc7rpVDGTtNHhoVLF5lpQU5kYGghcbMdMWFv9t08sloSlrqaTbpArictIrO0RL3dib6qg/0'),('125027187480080384','125027187480080384972C',NULL,'132155665','男','中国-广东-深圳','岁月静好',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoDiak1CmRebx734SyxrrASxptVpl4LL7JstvEky0Arv5F1icdfOaucrH0AHU5HdiaaOEmdgj0hsoFeQ/0'),('125231749239418880','125231749239418880F237',NULL,NULL,'未知','--','Robert',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq1FhE1nHUy5yK2DXMw6bXIBKkxWCLCIIALscQx1Gia9M0Xbug0qpyQJbCf1G9qkO86HfmnwkCUvpw/0'),('125342037682958336','125342037682958336E9F7',NULL,NULL,'男','中国-辽宁-沈阳','杨立志',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLR7uwhnUYe4yh45zddvhHPhuYkrMJuDSThCPcqmjv5BSnibOoV9hLeBUmEJeLVcMqaSP69iaoowpiag/0'),('125377732019499008','125377732019499008ADF6',NULL,NULL,'男','中国-广东-深圳','田林',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/PBicsK1qKM11sV08fIGkkuVsqc4ho6dYR5ETYia0qyS4ZicqwhWRyibEBJAuibGQmer81bsws1ldysSiaX4uTwmmvV4Q/0'),('125736368432492544','125736368432492544FCCC',NULL,NULL,'男','所罗门群岛--','正',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLGC8h4EXJZ6sib4lp0FULTtnxkK8yfGcrvRmbGNcftItlIcV9GH4Ou2OWDRFmGDzoZISCNPn7PPkg/0'),('125749963648151552','1257499636481515521E75',NULL,NULL,'女','中国-山东-青岛','小太阳',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqlwr1g2WYoYZYE1yHctfOksSraU7QXySBGL6ibN1eGVNry91WQzfvFRVwnQPmGw9gPH4ybYiaHYsicw/0'),('126053428421210112','1260534284212101129FEA',NULL,NULL,'女','中国-山东-潍坊','飞雷(flyray.me)',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/ejCTtdTlhlu1RZD5yAmSZicF1FUSgz4IXPjqicR15jibFezOTYRt3slLoZDP2QYV2tG73RA6uic9nW3GzibKxiaqEn7Q/0'),('126099747600871424','126099747600871424AD3C',NULL,NULL,'男','中国-山东-青岛','Alex',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/QfiaxiayIgWBxaxHHAbOcj3M1Vtfjk4vDyibXJRZXXfvKoojKAs1QL6F0zv9lbd49B6XqVr6fpoicGtiah9mz1NDQ9A/0'),('126660841503469568','126660841503469568A4FC',NULL,NULL,'男','中国-山东-青岛','        来日方长',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJMrh2ibBfsLfKRubVic3unicaNI7v47Ujm6m26QWia9U39icDYYanRaou3M1sMymeGzPYV2gRqxbupJuw/0'),('126720488717430784','126720488717430784F5F9',NULL,NULL,'男','中国-江西-新余','诶物',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eofP362hhCAuQhaYWLx8QY6jrNz5f2hwWT3h7udgtXF197B0aic8icCCIGYQRzgGm6Sf6uAuZdmRLng/0'),('126720680652976128','126720680652976128B06E',NULL,NULL,'男','安道尔--','吴刚伟',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/pyqGGu4CcexvNtM6aQrVQ6Xa7XaPNbG1dKDpp4PBJy896wvE4GGpE42wDOIFcgrStE5mPF8zb8GjKqFTgc0LmQ/0'),('126721100876099584','126721100876099584EEB4',NULL,NULL,'男','中国-山东-青岛','大鹏',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkBf7f1pcXjjqTBr807FicglXdH0ibRfxfoCZEKgHslAibTs7IaPz6X7WOdAthz862A2Mwjzawcibavg/0'),('126721242664546304','126721242664546304D06C',NULL,NULL,'男','中国-山东-潍坊','亓才',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/ajNVdqHZLLBc6LY3bAVloMK9Oz54hsJUZ5zKOSficEaK8313Gr3qCZIViavHBS7lBUv4M60QiaYOwRfEp7tVxxrAw/0'),('126721674510086144','126721674510086144C1E5',NULL,NULL,'女','中国-山东-青岛','杨春艳',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/5j9BTHE55BOJmS50q0cIDlthIgBezjfkUnmdE83WckTWj1LC068C31M6MUOOGvU1HlYrdBFmVxVR4S0QFLsltw/0'),('126721945306935296','1267219453069352967DEF',NULL,NULL,'男','中国-广东-深圳','暖风',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/ZVKXWzialz6jCSWv9MlbRTsFzzu3t5gr6Q6Xbd2jiamibQZttSy1Qe5eGnC26gs0oo1iavARjkMapClqbStHpU376Q/0'),('126722487613665280','1267224876136652808584',NULL,NULL,'男','中国-山东-淄博','进@Ryne',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep3Xtf4rhhtTX3Uut8FmO78R4LmvpeGXjWkMH1MRQlfOeic17Tc7wDXv6WBjDHCUePicl7buLmyh7Tg/0'),('126723718797078528','126723718797078528CA98',NULL,NULL,'男','中国-广东-深圳','rocyuan',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/TwRxYX40B71rJwibibfiavo0ibWKEic29QmrdbD6lesSzdlwx0Agb2vxhtu27mqmDybia0uncEibkewHol7Ijb8RXrjWg/0'),('126724384697364480','1267243846973644808E31',NULL,NULL,'男','安道尔--','那山那城',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJzdj6zCMslwDYYToLhuoJ3BFBUz0XsYTFEyRTqTeHhrzHiaVeia7MHkA7KUP1rlV57Mx4qbRBvto5A/0'),('126729437567004672','1267294375670046720F55',NULL,NULL,'男','中国-山东-青岛','z',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkFiaGXibqiav3uO2TJ6kk0SLfPiaR9mzu9ia4CGtcFbxvibprMQ3xleYCKzTiaiagPpialYCgI3HxWRLia45g/0'),('126732601615724544','1267326016157245445C8A',NULL,NULL,'男','中国-山东-潍坊','历久弥坚',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKiahKiaOicuUzPgaXAWHL6KRAC6nQbFwJ13pE2sEl9GgTV4XbZA0PDcsYibKiaz5JlVibYHibaSLHsT1jibw/0'),('126735878193426432','126735878193426432F8B1',NULL,NULL,'男','韩国-首尔-','A 冷月白狐',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoJCOs8eLVMK0ia45oqtBeWpgiauy6SItYPCt6ZbF7jFmq1SQ1bq1Ezss0RxCx8GfeCN9bSQ2vibOzDw/0'),('126740676863078400','1267406768630784007D01',NULL,NULL,'男','中国-山东-潍坊','李先生',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEJicaLyW31vTAn7bYfJgib8icLQ21keedhpMXTRUM4HfL8lrKyL2Svicrm03OmzRyjaTZezECsc6gR5yw/0'),('126744430152790016','126744430152790016EE06',NULL,NULL,'男','中国-山东-潍坊','小豆芽',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/c7d9vbnibpT2ric5Bbf8epBnGZwsyHNf2pU2uNEZ0gRYz5dpwHDwS1aL3BQBGZay91uZdxsOiaiac3VY3vCzZiaYhGw/0'),('126746094897213440','1267460948972134403583',NULL,NULL,'女','中国-云南-昆明','凹凸忽显回忆',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJgu0ASKJnK5FxpAMiaCROGwYh50dUf4uBzwzz3ZuU50E3II3FbLbBTI4vLMNbzwBEv54TI0CGI3oQ/0'),('126762816261861376','1267628162618613764F42',NULL,NULL,'女','奥地利-维也纳-','阿～银行信贷  王',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIl03YHWlzIHsGpiaNibSla8xTQwZx3bUZxA8NsohbUMk6gKHk5xqFwArWNYoJPppr6pIWxgjicMbAPQ/0'),('126769398613815296','126769398613815296058D',NULL,NULL,'男','中国-云南-大理','robin',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/c3GB3cAibjkQlxc6PGbNcYsIchSichj2eaDhQjrgcD6Vgrkic5dKLHIjXtIMBws811OjGibaaW324iaopRoG1mRYHnQ/0'),('126808397889941504','126808397889941504919E',NULL,NULL,'女','中国-山东-潍坊','宁静致远',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ96vbiaNKL3pC3BX456CnlCO2XHbUCucBE27XDkgMTBibTBvcibFhWXI1vD0ZhrJa6ZDATqMtxEOWLA/0'),('126852762964340736','1268527629643407362053',NULL,NULL,'男','中国-山东-潍坊','星',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLST3pS1ya042kX1FibYicyYcySreabqnZia0YnYc7srVzP2IDYicFjlYML5NDQbJhnqicqRUacCO1EcXw/0'),('126854309177733120','126854309177733120CA11',NULL,NULL,'女','挪威--','不羁    .',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/VYneMJE72icj4I4ILwvD3sOW8cMCwW9iaIsOxMcznPnmnbVQLlUAW6iaSE7Ow411J2gpVYr6LELl54ECyzGM0wUag/0'),('127096453364723712','1270964533647237120CFA',NULL,NULL,'女','泽西岛--','姜',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJW45daJTxMAnjV3wkBLlgpAcYjwrhSE8qKVZhkD7fTic7MrKD9ty1LfAO4Y2Gh9L0CLiaCq5CXo8Rw/0'),('127096481688858624','1270964816888586243104',NULL,NULL,'男','爱尔兰-多内加尔-',',',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epHHamLlLcoZNca64YuYPWibVER9CnnYyA2jKHibzx4P98qVqLjZhCOVYfjBLHFV159ziaEyhiaIcmaTQ/0'),('127096606842695680','127096606842695680BD70',NULL,NULL,'女','中国-山东-潍坊','飞',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqC1eC2M6v7pBNPcnX8K0TTw3P5c3BXwCg8yI2nxyZgyicgenicO90z6nM6NUoZ9baYNzAjVAU18PkA/0'),('127098179597643776','12709817959764377635FA',NULL,NULL,'男','中国-山西-太原','江枫瑶影',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKPoje4X1mKCy0lc9tVeqRKNODfKnR7nh3Qlly5HiacsWepdtYR5qFOweicpicjCFlSbcEjqiaiaf6icIMg/0'),('127098777697005568','127098777697005568113B',NULL,NULL,'女','新加坡--','神秘妖妖',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoWc442fSiaMiawQDmHF8npXY29In43SyibeFpj8j1libwvbEb4aGm3k50MER2zzhjO1tib1ROMSSABMaw/0'),('127098875675947008','127098875675947008E920',NULL,NULL,'男','中国-山东-潍坊','will chen',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKZyiaicNgDvbftVv5o4jQpcuaKPmlibDdMUdUvd8mmffWwHl0Lic0nUF6AZicwuFvfVg9CNsPGicIMia6pg/0'),('127109414108016640','127109414108016640CB56',NULL,NULL,'男','中国-北京-朝阳','创造财富',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/ds2IFK7cnxGsnf9bONyj0b4aKl9HHdRVpfeHkMZ88qtpwSwlwWEHngDCJLdnyE5cmFBwDEWaaNK5lsG8ISmHcQ/0'),('127116486442758144','12711648644275814474F8',NULL,NULL,'男','中国-山东-潍坊','AAA污水处理18863692872',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/NFkoWkQMVq3w722s0OvZex9Etx8hs40Wicoib3o5U80ZLPRkMjTMc9pag3fwl0aAqwhibJ4avicHspCBsZT67Ez8Gg/0'),('127119959322275840','1271199593222758408922',NULL,NULL,'男','安道尔--','^ǒ^',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKhQ9UpNVJEXk7l4Agn18JicJnyjICSuk7HJ3DktSxMvykKOfUkHsu2CDTbSCJ0kEKiaq7KnAY33ArA/0'),('127126861485715456','127126861485715456B736',NULL,NULL,'男','中国--','戒个和尚叫三戒',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI6ra6icibeicqZSn1xIkuycbEdA8sz9ESeZcXFBNoc1iccukqATZ66ibjoPyMT14RTUDhUD0gJH6xUiajQ/0'),('127138764375207936','12713876437520793657A2',NULL,NULL,'未知','--','朱丹',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/s70y540FEyLEMSjaUClZZR53T5PkiaQw0GibLY0lEyoAZOq2kdMHbCYKCeOHRndzWuNrt051msyCzl8Ccialwaklg/0'),('127148722001031168','127148722001031168A7EB',NULL,NULL,'男','中国-湖南-长沙','leon',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epmqtj92qU8COgv6GoCvwEc8rqPRnRZG4SBYA7N7G2m7dh5Azk8vXLUicUFn3qic5jYuicEsgGVMGyuA/0'),('127162697531011072','1271626975310110720D55',NULL,NULL,'男','中国-山东-潍坊','小乙',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epz6qrnyhzMZh8dbjPibySz49aQkHJSKAP2ia4S1bRAwhficyE5xZbbhPxibZJCEY45ZO7g6iazDrfsACQ/0'),('127164447885373440','1271644478853734401DC2',NULL,NULL,'男','中国-北京-海淀','认真就输了',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJnoSedDEDcxXcg6JUr1Trot8SuibqI18icueXkH8icRlhy4vDXDSruLe8sBST9MBz3CLOMEoJKPT44Q/0'),('127167389786976256','1271673897869762564EE1',NULL,NULL,'男','中国-山东-潍坊','安得书屋二三间',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEJKE0opwbxN827NMc1icgc0o8BSZ5lgwytbWadBkyJQSyOxtqB74NgrTzdtZ0tghZbUMrKCITtlVibQ/0'),('127167837096914944','1271678370969149441B80',NULL,NULL,'男','阿鲁巴--','',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIKD2KxZwvxAkcH5SP9k4rylhQRdYqYHLU8ThBM7kgMthxibKFA08MvrI0WUibLrVD0Z7yqwOZIn2pA/0'),('127173699538530304','127173699538530304A319',NULL,NULL,'男','中国-山东-青岛','L草沐',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKZNZwuU2rrAY1WfPPdwaSc7lmJiaic73F9bCiamW5u9xJfspW9Y8iak0k7AFPWVt0yZhqYyZ25Ms7Rbw/0'),('127176397306474496','1271763973064744960C2E',NULL,NULL,'男','中国-山东-淄博','A总裁',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epBjLGUmOnGYJFIia0scldKmYkKlnhNP3D7BrsMIoko7keXiaPSxoNH02RDvMGxOxIcV4mWj15tD6vg/0'),('127176605994070016','12717660599407001606ED',NULL,NULL,'未知','中国-辽宁-辽阳','有你真好',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/r83191R6KFDymTevVyeT9Fic0nNJz6ibOZYG0uiakZb7wPMRqGaIvZGMyLSjvD2vmzOttiaxRJFiaYg7jibIib26sLTZg/0'),('127181562700902400','127181562700902400AAAC',NULL,NULL,'男','中国-山东-潍坊','王一杯沾酒倒',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erEemBD5MSAY5jS5rxGLzicxXRrjggJGWzqx6f1A0PXFhxmCKXCTqU1vZjgQ2UWUe20xVbZJ4yz5FQ/0'),('127417305234944000','1274173052349440007DA6',NULL,NULL,'男','中国-山东-青岛','宋力Erik',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIyxa93JHHicUIs8XVq5fTHPQtCEfKXtoYz1EZBU80MyaCXWasIic216kll8Erwvf45dCJTwg6zsOew/0'),('127417308036739072','127417308036739072A9DE',NULL,NULL,'男','中国-湖北-荆门','伦伦子',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo0ZIZUric4CmVgjzQEibZ3hyOBZicbF0lNxb20WZGiaE6dXeleib0Xem1WmLXs2BmhjoDQhJ90b93n8iag/0'),('127419547459530752','1274195474595307528CD9',NULL,NULL,'男','中国-山东-青岛','Mr.Trouble',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKUgmsyyyBJHguAicPN7pO5T2moyj2b1k3YLqtG56WdIv68E0dH0G9Zb4Q17kAmyAovLH9BTcLNBDg/0'),('127422419966373888','1274224199663738887568',NULL,NULL,'女','中国-上海-','Loretta',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJcwAOlhic6eF0qX9ichicRo3N4nLRxyriaUuRzicJwEOWkGFEnWibXxP0GTSH49wKaZAggbMWOb6iaOFBew/0'),('127430050978213888','1274300509782138886FDC',NULL,NULL,'男','中国-山东-青岛','Q克L赵',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKlYbeHSBI5f7d5DgCKTbweY8MaUa8r3icJNicRicFM6gW76qMlgkVkgSz0yrYq7PHDyC2SNVx7ZwzEw/0'),('127435046662713344','127435046662713344EF68',NULL,NULL,'男','中国-福建-漳州','何文建',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epUXV0eUgziaSKtib35Ly89iajvsZcPRjU5Oe0ZXGEkyySktqoRQxk9yYH10wm8NVCQmxIDFXgjXJvWw/0'),('127519511858655232','12751951185865523203C3',NULL,NULL,'未知','--','朦胧的幸福',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/2dQZbQ22fnc7tOPs7mh00XSf7icSBogpicFhNpLyZzNYzHiapwO43HtmeOnIFREyGNEiaRuHntRHsgCOBibkicj4XVnA/0'),('127582142950813696','1275821429508136963377',NULL,NULL,'女','中国-云南-','lee',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/rFUia6e4StJX4ekbRCWQS4UdqZzurIc8pbswHGsB74r9jtrR79F6NdPAlMPeoyOSOODMXrhJwPUjIupueIZ01jA/0'),('131683906943725568','1316839069437255682A56',NULL,NULL,'女','EE--','丫头爱吃肉',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/1gzC2R9J7Fjng9HrqtfS3d193lRNngd6cQwLuSGOlt5FQCxIvvo2p5OvhQSSPGBlFAEcEhOFaicy2RfPsibDeqDw/0'),('131741455688675328','1317414556886753282226',NULL,NULL,'女','中国-山东-潍坊','小乔',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKib8SOSohCHZnYaRqMMLmNISHoVsm9ia8eRshjkneoniccxmCJ833qGuEN1WsjU7KTpVEKoKg3U3FaA/0'),('131744270830022656','13174427083002265644A6',NULL,NULL,'女','中国-贵州-六盘水','。',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIf1sb7hVymuRAoL8zqC2Q9OibIe3icjb1NhGI2pqB0BymCiaXoEzdUk89kB4cI8ote4aw3DicCic9eOFQ/0'),('131749622489296896','1317496224892968966791',NULL,NULL,'女','安道尔--','王海燕',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/kOvKM9wqUc8eMicCtMBvVMPBvsImaFicsvKb0icv5rjQic5cBNkBQWDbTbkz5FQPanMZ9Dtja3fY5VmpKFNicNpxC5A/0'),('131834453873143808','131834453873143808417F',NULL,NULL,'男','中国-山东-潍坊','田浩利',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqEBjf14jyibbfr4ibVbLK3DEJwaFn9hlKAyZ9ia2V5GJQlCGZJpslsQrVexXtey2nlpJOmn9MGdrk2Q/0'),('131961241374830592','13196124137483059289A2',NULL,NULL,'女','中国-山东-济南','白玫瑰',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqybr0ibIJGxxiaFnuXq46P0aBxoZnnf7kMvPJXBLU1ibjibP3scdNMjBcfrKq4hJanyC6t1NLboOYVEg/0'),('132223253480747008','132223253480747008B9EE',NULL,NULL,'男','中国-广东-深圳','张鹏',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Kjc3pBuKRk3SBsqTgMERobLFYias7q375X91IHox2yS9IRcVRe3SiaZaR4VSEopldTmMa92kXEkJ4Jib94FVb5cYA/0'),('132223879489007616','132223879489007616E09B',NULL,NULL,'女','中国-山西-运城','坚定',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/A9kY5lw75LqAY8oRr8q6m5WQNez5E2KLjkGtJ2vKMRcY6cPyUcdDQhCVdm4XEwQibLwy7naN7S76PC6VlcV97rw/0'),('132224891129966592','13222489112996659295D4',NULL,NULL,'男','中国-山东-潍坊','张磊',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLOgqkXdyrgWkibxWNvgazOSSDYlibfMSVsv8J2IjyOyiaEvuj2k5O3qD8djNbNJWmKO3riacsnKw64ow/0'),('132226845084233728','132226845084233728069F',NULL,NULL,'女','中国-山东-潍坊','宗海霞',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJkDfewohhPedWtpnDyhqInXgvh7xqtib36chP77JM9O4DRUfGhmx2roiaAtnDR68YayVKr4kb5DSLQ/0'),('132230445445427200','132230445445427200CF32',NULL,NULL,'男','中国-湖北-武汉','高粱甜了',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/eIMz02ztbevsCgeia4VJDXjNoRNKfAzUtLHtenLXC4icG9BxhtypyE6Vx3ziaoD8iaTlfNthYQdl5JPoXPPRR7Yf5Q/0'),('132241231500816384','132241231500816384732E',NULL,NULL,'男','中国-山东-潍坊','张宝昌',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo2C3nj2Nv5vbpQF9ribbZ60cuibYkqL1w6DXq3ica3zkNY37bibxJZdFwTLY63U3ketwlCj5Sbmtvy0Q/0'),('132621535377895424','1326215353778954241C1A',NULL,NULL,'男','中国-山东-青岛','范昌府',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKm0OlDBooicSZpLFjbYROWGGMOV3e2zIVIic5MvqoZNnJOqdxU31sjIKRM9eJsKnLGQokmypw3p5QQ/0'),('132626610548649984','132626610548649984EE0D',NULL,NULL,'女','中国-云南-大理','林夕',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/icob5wCbib8yXAegIPOJ1MPaCZARxV8mJySN8GP4bMqspzPQIy0zT1QicCl4j3aURQaOd5j3aiciayBUia91XdfgeWvw/0'),('132626992872042496','132626992872042496AA28',NULL,NULL,'男','澳大利亚-新南威尔士-悉尼','宋文智',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep6wCr7tTia42P4xO5CdoIM0yuncrlX8g41Wk3kwQVVp0abic0s6WhlYN9qyLJRWHa2aGfYD9Y66FOA/0'),('132650697064984576','13265069706498457664AC',NULL,NULL,'女','中国-广东-深圳','小丑妖',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLv9HJIW4OACtltdiaUbutB5TvqhlV4wjjReTCX5s0oHCrjbDTiaM2C3LAgCg9NMIKvl5s6490V6rdg/0'),('138715242221023232','1387152422210232321F2D',NULL,NULL,'男','中国-上海-浦东新区','李帅',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/vddjtIKQJttjIfH5rgeqEd48gMuic5wVIxYok1C81m8GMRfNUlBgnxNwdrZgxBibxQS1eiavsF6oHXhDtgichVhxrg/0'),('139686805137272832','1396868051372728327EE8',NULL,NULL,'男','中国-山东-潍坊','你可是齐天大圣啊',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLLoia2SRQOSAQER44SlJCYGvOcGT3kp6346MibtsoH43krsdoUs3T8WxPqmpz8Lf6h1l5hXozqiaNOQ/0'),('145867009387933696','1458670093879336962CE6',NULL,NULL,'未知','--','嗣和',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKPHBC4ZIBrRjbB7r69IeERnrzIcibFZJpBWQdUnibf5lA8pRHhtUtgns7C0qGnYt4w9q5IYDM7eUTw/0'),('153936539460841472','15393653946084147281AF',NULL,NULL,'男','中国-山东-青岛','陈哲',NULL,NULL,NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq8sl54op1nEFkRy2POOFUELdZP3aSMKyRwzwYQoy5ZLsicW2KBkqH7OKiaxslYQSw9yrt401cVvyGg/132');

/*Table structure for table `crm_customer_base_extend` */

DROP TABLE IF EXISTS `crm_customer_base_extend`;

CREATE TABLE `crm_customer_base_extend` (
  `customer_id` varchar(60) NOT NULL COMMENT '客户id,外键',
  `follow_customer_id` varchar(60) DEFAULT NULL COMMENT '关注客户号',
  `school_name` varchar(50) DEFAULT '地球' COMMENT '学校',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_base_extend` */

insert  into `crm_customer_base_extend`(`customer_id`,`follow_customer_id`,`school_name`) values ('124935467304235008','0','青岛科技大学'),('125020732127457280',NULL,'地球'),('125024706939334656',NULL,'地球'),('125027187480080384',NULL,'地球'),('125231749239418880',NULL,'地球'),('125342037682958336',NULL,'地球'),('125377732019499008',NULL,'地球'),('125736368432492544',NULL,'地球'),('125749963648151552',NULL,'地球'),('126053428421210112',NULL,'地球'),('126099747600871424',NULL,'地球'),('126491339960627200',NULL,'地球'),('126660841503469568',NULL,'地球'),('126720488717430784',NULL,'地球'),('126720680652976128',NULL,'地球'),('126721100876099584',NULL,'地球'),('126721242664546304',NULL,'地球'),('126721674510086144',NULL,'地球'),('126721945306935296',NULL,'地球'),('126722487613665280',NULL,'地球'),('126723718797078528',NULL,'地球'),('126724384697364480',NULL,'地球'),('126725433688600576',NULL,'地球'),('126725460192407552',NULL,'地球'),('126729437567004672',NULL,'地球'),('126732601615724544',NULL,'地球'),('126735878193426432',NULL,'地球'),('126740151660720128',NULL,'地球'),('126740676863078400',NULL,'地球'),('126744430152790016',NULL,'地球'),('126746094897213440',NULL,'地球'),('126762816261861376',NULL,'地球'),('126769398613815296',NULL,'地球'),('126808397889941504',NULL,'地球'),('126852762964340736',NULL,'地球'),('126854309177733120',NULL,'地球'),('127096453364723712',NULL,'地球'),('127096481688858624',NULL,'地球'),('127096606842695680',NULL,'地球'),('127098179597643776',NULL,'地球'),('127098777697005568',NULL,'地球'),('127098875675947008',NULL,'地球'),('127109414108016640',NULL,'地球'),('127116486442758144',NULL,'地球'),('127119959322275840',NULL,'地球'),('127126861485715456',NULL,'地球'),('127138764375207936',NULL,'地球'),('127148722001031168',NULL,'地球'),('127162697531011072',NULL,'地球'),('127164447885373440',NULL,'地球'),('127167389786976256',NULL,'地球'),('127167837096914944',NULL,'地球'),('127173699538530304',NULL,'地球'),('127176397306474496',NULL,'地球'),('127176605994070016',NULL,'地球'),('127181562700902400',NULL,'地球'),('127417305234944000',NULL,'地球'),('127417308036739072',NULL,'地球'),('127419547459530752',NULL,'地球'),('127422419966373888',NULL,'地球'),('127430050978213888',NULL,'地球'),('127435046662713344',NULL,'地球'),('127519511858655232',NULL,'地球'),('127582142950813696',NULL,'地球'),('131683906943725568',NULL,'地球'),('131741291389399040',NULL,'地球'),('131741334808834048',NULL,'地球'),('131741353251188736',NULL,'地球'),('131741455688675328',NULL,'地球'),('131743278591913984',NULL,'地球'),('131744270830022656',NULL,'地球'),('131749622489296896',NULL,'地球'),('131834453873143808',NULL,'地球'),('131961241374830592',NULL,'地球'),('132223253480747008',NULL,'地球'),('132223879489007616',NULL,'地球'),('132224891129966592',NULL,'地球'),('132226845084233728',NULL,'地球'),('132230445445427200',NULL,'地球'),('132241231500816384',NULL,'地球'),('132619443447803904',NULL,'地球'),('132621535377895424',NULL,'地球'),('132623501176877056',NULL,'地球'),('132626610548649984',NULL,'地球'),('132626992872042496',NULL,'地球'),('132650697064984576',NULL,'地球'),('138715242221023232',NULL,'地球'),('139686805137272832',NULL,'地球'),('145867009387933696',NULL,'地球'),('153936539460841472',NULL,'地球');

/*Table structure for table `crm_customer_proficient` */

DROP TABLE IF EXISTS `crm_customer_proficient`;

CREATE TABLE `crm_customer_proficient` (
  `customer_id` bigint(20) NOT NULL COMMENT '客户号',
  `cert_photo_file_no` varchar(20) NOT NULL COMMENT '身份证正面照片',
  `leval` varchar(2) NOT NULL COMMENT '专家等级：00-普通；01-热门'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_proficient` */

/*Table structure for table `crm_customer_relations` */

DROP TABLE IF EXISTS `crm_customer_relations`;

CREATE TABLE `crm_customer_relations` (
  `wx_id` varchar(60) DEFAULT NULL COMMENT '公众号ID',
  `customer_id` varchar(60) DEFAULT NULL COMMENT '客户编号',
  `fx_level` varchar(60) DEFAULT NULL COMMENT '分销级数',
  `parent_id` varchar(60) DEFAULT NULL COMMENT '推荐客户编号',
  `child_id` varchar(60) DEFAULT NULL COMMENT '所推荐客户编号',
  `invited_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_relations` */

insert  into `crm_customer_relations`(`wx_id`,`customer_id`,`fx_level`,`parent_id`,`child_id`,`invited_time`) values (NULL,'126491339960627200','1','124935467304235008',NULL,'2017-11-10 22:32:34'),(NULL,'125027187480080384','1','124935467304235008',NULL,'2017-11-11 13:36:51'),(NULL,'125377732019499008','1','124935467304235008',NULL,'2017-11-11 13:39:25'),(NULL,'126720488717430784','1','124935467304235008',NULL,'2017-11-11 13:43:05'),(NULL,'126720680652976128','1','124935467304235008',NULL,'2017-11-11 13:43:50'),(NULL,'126721100876099584','1','124935467304235008',NULL,'2017-11-11 13:45:31'),(NULL,'126721242664546304','1','124935467304235008',NULL,'2017-11-11 13:46:04'),(NULL,'126721674510086144','1','124935467304235008',NULL,'2017-11-11 13:47:47'),(NULL,'126721945306935296','1','124935467304235008',NULL,'2017-11-11 13:48:52'),(NULL,'126722487613665280','1','124935467304235008',NULL,'2017-11-11 13:51:01'),(NULL,'126723718797078528','1','124935467304235008',NULL,'2017-11-11 13:55:55'),(NULL,'125749963648151552','1','124935467304235008',NULL,'2017-11-11 13:57:35'),(NULL,'125020732127457280','1','124935467304235008',NULL,'2017-11-11 13:57:44'),('2','126808397889941504','1','124935467304235008',NULL,'2017-11-11 19:32:24'),('2','126808397889941504','1','124935467304235008',NULL,'2017-11-11 19:32:24'),('2','126854309177733120','1','125027187480080384',NULL,'2017-11-11 22:34:50'),('2','126721100876099584','1','124935467304235008',NULL,'2017-11-26 00:29:22'),('2','131683906943725568','1','124935467304235008',NULL,'2017-11-26 00:42:27'),('2','131961241374830592','1','124935467304235008',NULL,'2017-11-26 00:47:58'),('2','126053428421210112','1','124935467304235008',NULL,'2017-11-26 16:27:28'),('2','132223253480747008','1','124935467304235008',NULL,'2017-11-26 18:09:06'),('2','132223879489007616','1','124935467304235008',NULL,'2017-11-26 18:11:35'),('2','132224891129966592','1','124935467304235008',NULL,'2017-11-26 18:15:37'),('2','132226845084233728','1','124935467304235008',NULL,'2017-11-26 18:23:22'),('2','132230445445427200','1','131683906943725568',NULL,'2017-11-26 18:37:41'),('2','132230445445427200','2','131683906943725568',NULL,'2017-11-26 18:37:41'),('2','132241231500816384','1','124935467304235008',NULL,'2017-11-26 19:20:32'),('2','132621535377895424','1','124935467304235008',NULL,'2017-11-27 20:31:44'),('2','132626610548649984','1','124935467304235008',NULL,'2017-11-27 20:51:54'),('2','132626992872042496','1','124935467304235008',NULL,'2017-11-27 20:53:25'),('2','132650697064984576','1','124935467304235008',NULL,'2017-11-27 22:27:37'),('2','138715242221023232','1','124935467304235008',NULL,'2017-12-14 16:05:57');

/*Table structure for table `crm_customer_role` */

DROP TABLE IF EXISTS `crm_customer_role`;

CREATE TABLE `crm_customer_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_no` varchar(60) DEFAULT NULL COMMENT '客户角色编号',
  `role_name` varchar(100) DEFAULT NULL COMMENT '客户角色名称',
  `merchant_id` bigint(20) DEFAULT NULL COMMENT '所属商户',
  `org_id` bigint(20) DEFAULT NULL COMMENT '所属机构',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_role` */

insert  into `crm_customer_role`(`id`,`role_no`,`role_name`,`merchant_id`,`org_id`) values (1,'123','tianl',456,456),(2,'252578','tianfei',123,123),(5,'3434','343',NULL,NULL),(9,'252578','bryan',6666666666666,44444444444444),(10,'252578','bryan',777777777777,3333),(11,'199312','kingdee',111,2222),(12,'199312','bryancrash',333,2222);

/*Table structure for table `crm_customer_role_relations` */

DROP TABLE IF EXISTS `crm_customer_role_relations`;

CREATE TABLE `crm_customer_role_relations` (
  `customer_id` varchar(60) NOT NULL COMMENT '客户号',
  `customer_role_id` bigint(60) NOT NULL COMMENT '客户角色',
  `org_id` varchar(60) DEFAULT NULL COMMENT '所属机构',
  `merchant_id` varchar(60) DEFAULT NULL COMMENT '所属商户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_role_relations` */

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `pay_channel` */

insert  into `pay_channel`(`id`,`pay_channel_no`,`pay_company_no`,`fee_ratio`) values (1,'test0','test0','0.00'),(2,'test1','test1','9.00'),(5,'test3','test3','1.00'),(6,'payChannelNo444','payCompanyNo444','1.30'),(7,'payChannelNo','payCompanyNo','1.00'),(8,'test999','test000','1.10');

/*Table structure for table `pay_channel_config` */

DROP TABLE IF EXISTS `pay_channel_config`;

CREATE TABLE `pay_channel_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_channel_no` varchar(32) DEFAULT NULL COMMENT ' 支付通道编号',
  `pay_company_no` varchar(32) DEFAULT NULL COMMENT '支付公司',
  `org_id` varchar(32) DEFAULT NULL COMMENT '组织机构',
  `merchant_id` varchar(32) DEFAULT NULL COMMENT '商户号',
  `mer_account` varchar(32) DEFAULT NULL,
  `mer_key` varchar(64) DEFAULT NULL,
  `sing_type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `pay_channel_config` */

insert  into `pay_channel_config`(`id`,`pay_channel_no`,`pay_company_no`,`org_id`,`merchant_id`,`mer_account`,`mer_key`,`sing_type`) values (1,'test0','test0','1','1','mer_accounttest','SKT','KTSD');

/*Table structure for table `pay_channel_interface` */

DROP TABLE IF EXISTS `pay_channel_interface`;

CREATE TABLE `pay_channel_interface` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_channel_no` varchar(32) DEFAULT NULL COMMENT '支付通道编号',
  `pay_company_no` varchar(32) DEFAULT NULL,
  `service_name` varchar(32) DEFAULT NULL COMMENT '支付接口名称',
  `trade_type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
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
  `out_trade_no` varchar(64) DEFAULT NULL,
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
