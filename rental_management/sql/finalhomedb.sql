/*
SQLyog Ultimate v8.63 
MySQL - 5.5.37 : Database - home_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`home_db` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `home_db`;

/*Table structure for table `gd_address_tree` */

DROP TABLE IF EXISTS `gd_address_tree`;

CREATE TABLE `gd_address_tree` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `LOCATION` varchar(20) DEFAULT NULL COMMENT '位置',
  `PID` int(20) DEFAULT NULL COMMENT '父级ID',
  `LEVEL_JUDGE` int(11) DEFAULT NULL COMMENT '等级判断',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=gbk;

/*Data for the table `gd_address_tree` */

insert  into `gd_address_tree`(`ID`,`LOCATION`,`PID`,`LEVEL_JUDGE`) values (1,'广东省',0,1),(2,'广州市',1,2),(3,'天河区',2,3),(4,'白云区',2,3),(5,'越秀区',2,3),(6,'从化区',2,3),(7,'棠下街道',3,4),(9,'五山街道',3,4),(10,'吴村街道',3,4),(11,'车陂街道',3,4),(12,'沙河街道',3,4),(13,'石牌街道',3,4),(14,'兴华街道',3,4),(15,'沙东街道',3,4),(16,'林和街道',3,4),(17,'佛山市',1,2),(23,'中山市',1,2),(24,'江门市',1,2),(25,'恩平市',24,3),(26,'钟落潭',4,4),(27,'鹤山市',24,3),(28,'棠安路100号',7,5),(29,'棠安路120号',7,5),(30,'棠安路130号',7,5),(31,'棠安路180号',7,5);

/*Table structure for table `gd_card_reg` */

DROP TABLE IF EXISTS `gd_card_reg`;

CREATE TABLE `gd_card_reg` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CARD_NO` varchar(20) DEFAULT NULL COMMENT '卡号',
  `CDP` varchar(20) DEFAULT NULL COMMENT '创建人',
  `EFFECT_TIME` date DEFAULT NULL COMMENT '有效期',
  `CDT` date DEFAULT NULL COMMENT '创建时间',
  `NAME` varchar(20) DEFAULT NULL COMMENT '姓名',
  `STATUS` int(20) DEFAULT NULL COMMENT '发卡状态0:开卡未下发；1开卡成功；2销卡未下发；3销卡成功',
  `USER_ID` int(20) DEFAULT NULL COMMENT '人员ID',
  `CANCEL_DATE` date DEFAULT NULL COMMENT '注销日期',
  `PERSON_ID` int(11) DEFAULT NULL COMMENT '使用者ID',
  PRIMARY KEY (`ID`),
  KEY `IDX_gd_card_reg_USER_ID` (`USER_ID`),
  KEY `IDX_gd_card_reg_PERSON_ID` (`PERSON_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=gbk;

/*Data for the table `gd_card_reg` */

insert  into `gd_card_reg`(`ID`,`CARD_NO`,`CDP`,`EFFECT_TIME`,`CDT`,`NAME`,`STATUS`,`USER_ID`,`CANCEL_DATE`,`PERSON_ID`) values (1,'8888','李白','2001-11-11','2001-11-11','兰陵王',1,1,'2002-11-11',1),(2,'13888','李白','2011-11-11','2011-11-12','荆轲',1,1,'2012-11-11',2),(3,'999999',NULL,'2012-11-11','2012-11-11','高渐离',1,1,'2012-11-11',3),(4,'888',NULL,'2018-01-18','2017-09-27','娜可露露修改',1,1,'2012-11-11',4),(5,'520',NULL,'2017-09-27','2017-09-27','武藤',1,1,NULL,5),(6,'8888',NULL,'2018-09-21','2017-09-27','百里守约',1,1,NULL,6),(7,'2222',NULL,'2017-09-21','2017-09-27','蔡文姬',1,1,NULL,7),(8,'419',NULL,'2018-03-08','2017-09-29','不知火舞',1,1,NULL,8),(9,'419',NULL,'2018-03-08','2017-09-29','黄忠',1,1,NULL,9),(10,'419',NULL,'2017-09-14','2017-09-29','芈月',1,1,NULL,11),(14,'419',NULL,'2017-09-14','2017-09-29','花木兰',1,1,NULL,18),(15,'419',NULL,'2017-09-14','2017-09-29','东皇太一',1,1,NULL,19),(16,'419',NULL,'2017-09-14','2017-09-29','女娲',1,1,NULL,20),(17,'419',NULL,'2017-09-14','2017-09-29','神农',1,1,NULL,21),(18,'419',NULL,'2017-09-14','2017-09-29','蚩尤',1,1,NULL,22);

/*Table structure for table `gd_dev_card` */

DROP TABLE IF EXISTS `gd_dev_card`;

CREATE TABLE `gd_dev_card` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DEV_ID` int(20) DEFAULT NULL COMMENT '设备ID',
  `CARD_ID` int(20) DEFAULT NULL COMMENT '卡ID',
  PRIMARY KEY (`ID`),
  KEY `IDX_gd_dev_card_DEV_ID` (`DEV_ID`),
  KEY `IDX_gd_dev_card_CARD_ID` (`CARD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `gd_dev_card` */

/*Table structure for table `gd_dev_let` */

DROP TABLE IF EXISTS `gd_dev_let`;

CREATE TABLE `gd_dev_let` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CDP` varchar(20) DEFAULT NULL COMMENT '登记人',
  `NAME` varchar(20) DEFAULT NULL COMMENT '设备名称',
  `HOUSE_ADDRESS` varchar(100) DEFAULT NULL COMMENT '房屋地址',
  `HOUSE_ID` int(100) DEFAULT NULL COMMENT '房屋ID',
  PRIMARY KEY (`ID`),
  KEY `IDX_gd_dev_let_HOUSE_ID` (`HOUSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

/*Data for the table `gd_dev_let` */

insert  into `gd_dev_let`(`ID`,`CDP`,`NAME`,`HOUSE_ADDRESS`,`HOUSE_ID`) values (1,'高渐离','乐天大厦1楼','广东省广州市天河区棠下街道棠安路180号',4),(2,'高渐离','乐天大厦2楼','广东省广州市天河区棠下街道棠安路180号',4),(3,'高渐离','乐天大厦3楼','广东省广州市天河区棠下街道棠安路180号',4),(4,'王维','天豪酒店','广东省广州市天河区棠下街道棠安路100号',28),(5,'王维','科韵路小学','广东省广州市天河区棠下街道棠安路180号',31),(6,'王维','裕辉商务大厦','广东省广州市天河区棠下街道棠安路130号',30);

/*Table structure for table `gd_house_info` */

DROP TABLE IF EXISTS `gd_house_info`;

CREATE TABLE `gd_house_info` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `HOUSE_ID` int(100) DEFAULT NULL COMMENT '栋ID',
  `ADDRESS` varchar(100) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`ID`),
  KEY `IDX_gd_house_info_HOUSE_ID` (`HOUSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

/*Data for the table `gd_house_info` */

insert  into `gd_house_info`(`ID`,`HOUSE_ID`,`ADDRESS`) values (1,28,'广东省广州市天河区棠下街道棠安路100号'),(2,29,'广东省广州市天河区棠下街道棠安路120号'),(3,30,'广东省广州市天河区棠下街道棠安路130号'),(4,31,'广东省广州市天河区棠下街道棠安路180号');

/*Table structure for table `gd_login` */

DROP TABLE IF EXISTS `gd_login`;

CREATE TABLE `gd_login` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` int(100) DEFAULT NULL COMMENT '用户ID',
  `LOGIN_DATE` datetime DEFAULT NULL COMMENT '登陆时间',
  `LOGIN_SATUS` int(100) DEFAULT NULL COMMENT '登陆状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `gd_login` */

/*Table structure for table `gd_role_menu` */

DROP TABLE IF EXISTS `gd_role_menu`;

CREATE TABLE `gd_role_menu` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLE_ID` int(20) DEFAULT NULL COMMENT '角色ID',
  `MENU_ID` int(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`ID`),
  KEY `IDX_gd_role_menu_ROLE_ID` (`ROLE_ID`),
  KEY `IDX_gd_role_menu_MENU_ID` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `gd_role_menu` */

/*Table structure for table `gd_user_address` */

DROP TABLE IF EXISTS `gd_user_address`;

CREATE TABLE `gd_user_address` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` int(20) DEFAULT NULL COMMENT '用户ID',
  `ADDRESS_ID` int(20) DEFAULT NULL COMMENT '地址ID',
  PRIMARY KEY (`ID`),
  KEY `IDX_gd_user_address_USER_ID` (`USER_ID`),
  KEY `IDX_gd_user_aess_ADDRESS_ID` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `gd_user_address` */

/*Table structure for table `person_info` */

DROP TABLE IF EXISTS `person_info`;

CREATE TABLE `person_info` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `HOUSE_ID` varchar(20) DEFAULT NULL COMMENT '房屋编号',
  `IDENTITY_NUMBER` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `NAME` varchar(20) DEFAULT NULL COMMENT '人员姓名',
  `ADDRESS` varchar(100) DEFAULT NULL COMMENT '地址',
  `BRITH_DATE` date DEFAULT NULL COMMENT '出生日期',
  `NATION` varchar(20) DEFAULT NULL COMMENT '民族',
  `PHONE` varchar(20) DEFAULT NULL COMMENT '电话',
  `PHOTOGRAPH` varchar(100) DEFAULT NULL COMMENT '照片',
  `SEX` int(10) DEFAULT NULL COMMENT '性别',
  `ISLOGOFF` varchar(10) DEFAULT NULL COMMENT '是否注销',
  `AGE` int(10) DEFAULT NULL COMMENT '年龄',
  `LOGOFFREASON` varchar(10) DEFAULT NULL COMMENT '注销原因',
  `LOGOFFTIME` date DEFAULT NULL COMMENT '注销时间',
  `LOGOFF_PERSON` varchar(10) DEFAULT NULL COMMENT '注销人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=gbk;

/*Data for the table `person_info` */

insert  into `person_info`(`ID`,`HOUSE_ID`,`IDENTITY_NUMBER`,`NAME`,`ADDRESS`,`BRITH_DATE`,`NATION`,`PHONE`,`PHOTOGRAPH`,`SEX`,`ISLOGOFF`,`AGE`,`LOGOFFREASON`,`LOGOFFTIME`,`LOGOFF_PERSON`) values (1,'1','19001111','兰陵王','兰陵','1900-11-11','1','110','111',1,'1',20,'1','2001-11-11','1'),(2,'1','19220101','荆轲','楚国','1922-01-01','1','119','111',1,'1',16,'1','2001-01-21','1'),(3,'1','272826298','高渐离','广州','2017-09-27','1','289229269',NULL,1,NULL,NULL,'0',NULL,NULL),(4,'1','20170918','娜可露露','广州','2017-09-13','1','110',NULL,1,NULL,NULL,'0',NULL,NULL),(5,NULL,'520','武藤','东京','2007-01-08',NULL,'110',NULL,2,NULL,NULL,'0',NULL,NULL),(6,NULL,'8888','百里守约','广东省广州市天河区棠下街道棠安路180号乐天大厦2楼','2017-03-01',NULL,'13888',NULL,1,NULL,NULL,'0',NULL,NULL),(7,NULL,'2222','蔡文姬','广东省广州市天河区棠下街道棠安路180号乐天大厦3楼','2012-09-11',NULL,'1110',NULL,2,NULL,NULL,'0',NULL,NULL),(8,NULL,'419','不知火舞','广东省广州市天河区棠下街道棠安路100号天豪酒店','2012-02-01',NULL,'10086',NULL,2,NULL,NULL,'0',NULL,NULL),(9,NULL,'419','黄忠','广东省广州市天河区棠下街道棠安路100号天豪酒店','2012-02-01',NULL,'10086',NULL,2,NULL,NULL,'0',NULL,NULL),(10,NULL,'419','黄忠','广东省广州市天河区棠下街道棠安路100号天豪酒店','2012-02-01',NULL,'10086',NULL,2,NULL,NULL,'0',NULL,NULL),(17,NULL,'419','芈月','广东省广州市天河区棠下街道棠安路180号科韵路小学','2017-05-10',NULL,'10002',NULL,2,NULL,NULL,'0',NULL,NULL),(18,NULL,'419','花木兰','广东省广州市天河区棠下街道棠安路130号裕辉商务大厦','2017-05-10',NULL,'10002',NULL,1,NULL,NULL,'0',NULL,NULL),(19,NULL,'419','东皇太一','广东省广州市天河区棠下街道棠安路100号天豪酒店','2017-05-10',NULL,'10002',NULL,1,NULL,NULL,'0',NULL,NULL),(20,NULL,'419','女娲','广东省广州市天河区棠下街道棠安路100号天豪酒店','2017-05-10',NULL,'10002',NULL,2,NULL,NULL,'0',NULL,NULL),(21,NULL,'419','神农','广东省广州市天河区棠下街道棠安路180号乐天大厦3楼','2017-05-10',NULL,'10002',NULL,2,NULL,NULL,'0',NULL,NULL),(22,NULL,'419','蚩尤','广东省广州市天河区棠下街道棠安路180号乐天大厦3楼','2017-05-10',NULL,'10002',NULL,2,NULL,NULL,'0',NULL,NULL),(23,NULL,'11111','刘备','广东省广州市天河区棠下街道棠安路130号裕辉商务大厦','2017-09-07',NULL,'10029273',NULL,1,NULL,NULL,'0',NULL,NULL);

/*Table structure for table `tbl_system_menu` */

DROP TABLE IF EXISTS `tbl_system_menu`;

CREATE TABLE `tbl_system_menu` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DEFINE_RIGHT` varchar(100) DEFAULT NULL COMMENT '自定义权限',
  `NAME` varchar(100) DEFAULT NULL COMMENT '名称',
  `PAGE_URL` varchar(100) DEFAULT NULL COMMENT '访问地址',
  `PID` int(20) DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

/*Data for the table `tbl_system_menu` */

insert  into `tbl_system_menu`(`ID`,`DEFINE_RIGHT`,`NAME`,`PAGE_URL`,`PID`) values (1,'高层','系统管理',NULL,0),(2,'系统层','用户管理','/systemuser/list.do',1),(3,'系统层','地址管理','/jsp/system/sys-address.jsp',1),(4,'系统层','角色管理','/systemrole/list.do',1),(5,'高层','流程管理',NULL,0),(6,'高层','业务管理',NULL,0),(7,'业务层','开户办卡','/card/card-input.do',6),(8,'业务层','信息登记','/card/6.do',6),(9,'流程层','设备管理','/jsp/system/sys-dev.jsp',5),(10,'系统层','菜单管理','/systemmenu/list.do',1);

/*Table structure for table `tbl_system_role_info` */

DROP TABLE IF EXISTS `tbl_system_role_info`;

CREATE TABLE `tbl_system_role_info` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `FLAG` varchar(100) DEFAULT NULL COMMENT '系统标示',
  `ROLE_NAME` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `LOCATION_ID` varchar(100) DEFAULT NULL COMMENT '描述',
  `USER_ID` int(100) DEFAULT NULL,
  `STATUS` int(50) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

/*Data for the table `tbl_system_role_info` */

insert  into `tbl_system_role_info`(`ID`,`FLAG`,`ROLE_NAME`,`LOCATION_ID`,`USER_ID`,`STATUS`) values (1,'ROLE_ADMIN','系统管理员',NULL,NULL,1),(2,'ROLE_MANAGER_GENERAL','公司总经理',NULL,NULL,1),(3,'ROLE_MANAGER','部门经理',NULL,NULL,1),(4,'ROLE_USER','普通用户',NULL,NULL,1),(5,'ROLE_CUSTOMER','租户',NULL,NULL,1),(6,'xxx','路人甲',NULL,NULL,0),(7,'xxxx','路人乙',NULL,NULL,0),(8,NULL,NULL,NULL,NULL,1),(9,NULL,NULL,NULL,NULL,0);

/*Table structure for table `tbl_system_role_limit` */

DROP TABLE IF EXISTS `tbl_system_role_limit`;

CREATE TABLE `tbl_system_role_limit` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DEFINED` varchar(100) DEFAULT NULL COMMENT '自定义权限',
  `MENU_ID` int(100) DEFAULT NULL COMMENT '菜单ID',
  `R` int(100) DEFAULT NULL COMMENT '是否可读',
  `ROLE_ID` int(100) DEFAULT NULL COMMENT '角色ID',
  `W` int(100) DEFAULT NULL COMMENT '是否可写',
  PRIMARY KEY (`ID`),
  KEY `IDX_tbl_systemit_ROLE_ID` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=gbk;

/*Data for the table `tbl_system_role_limit` */

insert  into `tbl_system_role_limit`(`ID`,`DEFINED`,`MENU_ID`,`R`,`ROLE_ID`,`W`) values (2,NULL,2,NULL,1,NULL),(3,NULL,3,NULL,1,NULL),(4,NULL,4,NULL,1,NULL),(5,NULL,7,NULL,1,NULL),(8,NULL,8,NULL,1,NULL),(9,NULL,9,NULL,1,NULL),(10,NULL,10,NULL,1,NULL),(11,NULL,1,NULL,2,NULL),(12,NULL,5,NULL,2,NULL),(13,NULL,6,NULL,2,NULL),(14,NULL,8,NULL,2,NULL),(15,NULL,9,NULL,2,NULL),(16,NULL,10,NULL,2,NULL),(17,NULL,3,NULL,3,NULL),(18,NULL,7,NULL,3,NULL),(19,NULL,8,NULL,3,NULL),(20,NULL,9,NULL,3,NULL),(21,NULL,10,NULL,3,NULL);

/*Table structure for table `tbl_system_user_info` */

DROP TABLE IF EXISTS `tbl_system_user_info`;

CREATE TABLE `tbl_system_user_info` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '登陆密码',
  `PHONE` varchar(100) DEFAULT NULL COMMENT '用户电话',
  `SEX` int(100) DEFAULT NULL COMMENT '用户性别',
  `STATUS` varchar(100) DEFAULT NULL COMMENT '状态',
  `ROLE_ID` int(100) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`),
  KEY `IDX_tbl_systenfo_ROLE_ID` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

/*Data for the table `tbl_system_user_info` */

insert  into `tbl_system_user_info`(`ID`,`NAME`,`PASSWORD`,`PHONE`,`SEX`,`STATUS`,`ROLE_ID`) values (1,'李白','000000','110',1,'1',1),(2,'王维','000000','119',1,'1',1),(3,'杜甫','000000','120',1,'1',2),(4,'李商隐','000000','110',1,'1',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
