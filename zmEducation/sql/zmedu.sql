/*
Navicat MySQL Data Transfer

Source Server         : hzt
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : zmedu

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2018-01-02 16:11:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(400) DEFAULT NULL,
  `info` varchar(400) DEFAULT NULL,
  `price` varchar(400) DEFAULT NULL,
  `mechanism_id` int(11) DEFAULT NULL,
  `duration` datetime DEFAULT NULL,
  `TYPE` varchar(400) DEFAULT NULL,
  `class_type` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('23', '初中教师资格证培训', '培训初中教师资格证', '1800/课程', '10', '2017-12-25 00:00:00', '教师资格证', '冲刺班');
INSERT INTO `courses` VALUES ('24', '初中教师资格证培训', '培训初中教师资格证', '1800/课程', '10', '2017-12-25 00:00:00', '教师资格证', '冲刺班');
INSERT INTO `courses` VALUES ('26', '高中教师资格证培训', '培训高中教师资格证', '2500/课程', '11', '2017-12-26 14:32:27', '教师资格证', '冲刺班');
INSERT INTO `courses` VALUES ('27', '小学教师资格证培训', '培训小学教师资格证', '2000/课程', '11', '2017-12-25 00:00:00', '教师资格证', '包过班');
INSERT INTO `courses` VALUES ('28', '大学教师资格证培训', '培训大学教师资格证', '5000/课程', '12', '2017-12-25 00:00:00', '教师资格证', '冲刺班');
INSERT INTO `courses` VALUES ('29', '小学教师资格证培训', '培训小学教师资格证', '2500/课程', '12', '2017-12-26 00:00:00', '教师资格证', '合约班');
INSERT INTO `courses` VALUES ('30', '幼儿园教师资格证培训', '培训大学教师资格证', '2000/课程', '11', '2017-12-25 00:00:00', '教师资格证', '冲刺班');
INSERT INTO `courses` VALUES ('31', '幼儿园教师资格证培训', '培训大学教师资格证', '2000/课程', '12', '2017-12-25 00:00:00', '教师资格证', '冲刺班');

-- ----------------------------
-- Table structure for enviro
-- ----------------------------
DROP TABLE IF EXISTS `enviro`;
CREATE TABLE `enviro` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(40) DEFAULT NULL,
  `pic_url` varchar(400) DEFAULT NULL,
  `courses_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enviro
-- ----------------------------

-- ----------------------------
-- Table structure for mechanism
-- ----------------------------
DROP TABLE IF EXISTS `mechanism`;
CREATE TABLE `mechanism` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(40) DEFAULT NULL,
  `address` varchar(400) DEFAULT NULL,
  `info` varchar(400) DEFAULT NULL,
  `logo` varchar(400) DEFAULT NULL,
  `test_service` varchar(400) DEFAULT NULL,
  `school_permit` varchar(400) DEFAULT NULL,
  `business_license` varchar(400) DEFAULT NULL,
  `contact` varchar(400) DEFAULT NULL,
  `phone` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mechanism
-- ----------------------------
INSERT INTO `mechanism` VALUES ('10', '仲恺农业工程学院', '广东省广州市海珠区仲恺路500号', '本科院校', 'http://127.0.0.1:8080/zmEducation/img/logo/1.jpg', '报名/打印准考证/考试通知/代取证书', 'http://127.0.0.1:8080/zmEducation/img/permit/1.jpg', 'http://127.0.0.1:8080/zmEducation/img/license/1.jpg', '641694064', '16784511346');
INSERT INTO `mechanism` VALUES ('11', '灯塔教育机构', '广东省广州市天河区科韵路120号', '培训机构', 'http://127.0.0.1:8080/zmEducation/img/logo/2.jpg', '报名/打印准考证/考试通知/代取证书', 'http://127.0.0.1:8080/zmEducation/img/permit/2.jpg', 'http://127.0.0.1:8080/zmEducation/img/license/2.jpg', '641694064', '16784511346');
INSERT INTO `mechanism` VALUES ('12', '领航教育机构', '广东省广州市越秀区江湾路80号', '普通培训机构', 'http://127.0.0.1:8080/zmEducation/img/logo/3.jpg', '报名/打印准考证/考试通知/代取证书', 'http://127.0.0.1:8080/zmEducation/img/permit/3.jpg', 'http://127.0.0.1:8080/zmEducation/img/license/3.jpg', '641694064', '16784511346');

-- ----------------------------
-- Table structure for role_menu_limit
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_limit`;
CREATE TABLE `role_menu_limit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(20) DEFAULT NULL,
  `menu_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu_limit
-- ----------------------------
INSERT INTO `role_menu_limit` VALUES ('2', '1', '2');
INSERT INTO `role_menu_limit` VALUES ('3', '1', '3');
INSERT INTO `role_menu_limit` VALUES ('4', '1', '4');
INSERT INTO `role_menu_limit` VALUES ('9', '1', '7');
INSERT INTO `role_menu_limit` VALUES ('10', '1', '8');
INSERT INTO `role_menu_limit` VALUES ('11', '1', '9');
INSERT INTO `role_menu_limit` VALUES ('14', '1', '10');
INSERT INTO `role_menu_limit` VALUES ('16', '2', '2');
INSERT INTO `role_menu_limit` VALUES ('17', '2', '3');
INSERT INTO `role_menu_limit` VALUES ('18', '2', '4');
INSERT INTO `role_menu_limit` VALUES ('21', '2', '7');
INSERT INTO `role_menu_limit` VALUES ('22', '2', '8');
INSERT INTO `role_menu_limit` VALUES ('24', '2', '9');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) DEFAULT NULL,
  `page_url` varchar(400) DEFAULT NULL,
  `p_Id` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', null, '0');
INSERT INTO `sys_menu` VALUES ('2', '机构管理', null, '1');
INSERT INTO `sys_menu` VALUES ('3', '课程管理', null, '1');
INSERT INTO `sys_menu` VALUES ('4', '角色管理', '/systemrole/list.do', '1');
INSERT INTO `sys_menu` VALUES ('5', '流程管理', null, '0');
INSERT INTO `sys_menu` VALUES ('6', '业务管理', null, '0');
INSERT INTO `sys_menu` VALUES ('7', '用户管理', '/systemuser/list.do', '1');
INSERT INTO `sys_menu` VALUES ('8', '信息登记', '/card/6.do', '6');
INSERT INTO `sys_menu` VALUES ('9', '报名数据管理', null, '5');
INSERT INTO `sys_menu` VALUES ('10', '菜单管理', '/systemmenu/list.do', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(400) DEFAULT NULL,
  `flag` varchar(400) DEFAULT NULL,
  `STATUS` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', 'ROLE_ADMIN', '1');
INSERT INTO `sys_role` VALUES ('2', '公司总经理', 'ROLE_MANAGER_GENERAL', '1');
INSERT INTO `sys_role` VALUES ('3', '部门经理', 'ROLE_MANAGER', '1');
INSERT INTO `sys_role` VALUES ('4', '普通用户', 'ROLE_USER', '1');
INSERT INTO `sys_role` VALUES ('5', '租户', 'ROLE_CUSTOMER', '1');
INSERT INTO `sys_role` VALUES ('6', 'xxx', 'xxx', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(4000) DEFAULT NULL,
  `PASSWORD` varchar(4000) DEFAULT NULL,
  `STATUS` int(20) DEFAULT NULL,
  `role_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'li', '123', '1', '1');
INSERT INTO `sys_user` VALUES ('2', 'wang', '123', '0', '1');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(400) DEFAULT NULL,
  `info` varchar(400) DEFAULT NULL,
  `mechanism_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '蔡李佛', '生物老师', '11');
INSERT INTO `teacher` VALUES ('2', '华罗庚', '数学老师', '12');
INSERT INTO `teacher` VALUES ('3', 'Tom', '英语老师', '11');
INSERT INTO `teacher` VALUES ('4', '季昌明', '语文老师', '11');
INSERT INTO `teacher` VALUES ('5', '杨政宁', '物理老师', '12');
INSERT INTO `teacher` VALUES ('6', '高育良', '化学老师', '12');
INSERT INTO `teacher` VALUES ('7', '张宪超', '财务老师', '10');
INSERT INTO `teacher` VALUES ('8', '马士兵', '计算机老师', '10');
INSERT INTO `teacher` VALUES ('9', 'Mary', '幼儿英语老师', '11');
INSERT INTO `teacher` VALUES ('10', '李林', '幼儿数学老师', '12');

-- ----------------------------
-- Table structure for testbook
-- ----------------------------
DROP TABLE IF EXISTS `testbook`;
CREATE TABLE `testbook` (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) DEFAULT NULL,
  `info` varchar(400) DEFAULT NULL,
  `courses_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testbook
-- ----------------------------
INSERT INTO `testbook` VALUES ('2', '初中教师资格证教材', '适用于初中教师资格证报考者学习', '23');
INSERT INTO `testbook` VALUES ('3', '初中教师资格证教材', '适用于初中教师资格证报考者学习', '24');
INSERT INTO `testbook` VALUES ('4', '小学教师资格证教材', '适用于小学教师资格证报考者学习', '27');
INSERT INTO `testbook` VALUES ('5', '高中教师资格证教材', '适用于高中教师资格证报考者学习', '26');
INSERT INTO `testbook` VALUES ('6', '小学教师资格证教材', '适用于小学教师资格证报考者学习', '27');
INSERT INTO `testbook` VALUES ('7', '大学教师资格证教材', '适用于大学教师资格证报考者学习', '28');
INSERT INTO `testbook` VALUES ('8', '小学教师资格证教材', '适用于小学教师资格证报考者学习', '29');
INSERT INTO `testbook` VALUES ('9', '幼儿园教师资格证教材', '适用于幼儿园教师资格证报考者学习', '30');
INSERT INTO `testbook` VALUES ('10', '幼儿园教师资格证教材', '适用于幼儿园教师资格证报考者学习', '31');
