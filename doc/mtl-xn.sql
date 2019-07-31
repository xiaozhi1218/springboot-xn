/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : mtl-xn

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-07-29 14:42:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mtl_adminuser`
-- ----------------------------
DROP TABLE IF EXISTS `mtl_adminuser`;
CREATE TABLE `mtl_adminuser` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户图像',
  `state` int(6) DEFAULT NULL COMMENT '状态',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `regions_id` int(10) DEFAULT NULL COMMENT '区域id',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` date DEFAULT NULL COMMENT '创建日期',
  `creator` int(8) DEFAULT NULL COMMENT '创建者',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`userid`),
  KEY `userid` (`userid`) USING BTREE,
  KEY `dept_id` (`regions_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='平台用户';

-- ----------------------------
-- Records of mtl_adminuser
-- ----------------------------
INSERT INTO `mtl_adminuser` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '13888888888', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '1', '医互链点', '2800', '', null, '0', '1');
INSERT INTO `mtl_adminuser` VALUES ('2', 'chanpin', 'e10adc3949ba59abbe56e057f20f883e', '13966666666', '', '1', '张三', '1', '', '2019-02-20', '1', '1');
INSERT INTO `mtl_adminuser` VALUES ('3', 'kuguan', null, '13099999999', '', '1', '张家辉', '2800', '', null, '1', '1');
INSERT INTO `mtl_adminuser` VALUES ('11', 'jerry', null, '13912345098', null, '0', '杰瑞', null, null, '2019-04-04', '1', '1');
INSERT INTO `mtl_adminuser` VALUES ('12', null, null, null, null, '0', null, null, null, '2019-04-10', '1', '1');

-- ----------------------------
-- Table structure for `mtl_department`
-- ----------------------------
DROP TABLE IF EXISTS `mtl_department`;
CREATE TABLE `mtl_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级部门id',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `master` int(11) DEFAULT NULL COMMENT '部门负责人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mtl_department
-- ----------------------------

-- ----------------------------
-- Table structure for `mtl_dict`
-- ----------------------------
DROP TABLE IF EXISTS `mtl_dict`;
CREATE TABLE `mtl_dict` (
  `id` int(255) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(11) DEFAULT NULL COMMENT '是否删除',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `title` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `sort_order` decimal(10,2) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mtl_dict
-- ----------------------------
INSERT INTO `mtl_dict` VALUES ('000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', 'admin', '2018-11-14 22:15:43', '0', 'admin', '2018-11-27 01:39:06', '', '性别', 'sex', '0.00');
INSERT INTO `mtl_dict` VALUES ('000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002', 'admin', '2018-11-15 14:38:53', '0', 'admin', '2018-11-27 01:39:15', '', '消息类型', 'message_type', '1.00');
INSERT INTO `mtl_dict` VALUES ('000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003', 'admin', '2018-11-15 15:00:07', '0', 'admin', '2018-11-27 01:39:22', '', '按钮权限类型', 'permission_type', '3.00');

-- ----------------------------
-- Table structure for `mtl_dict_data`
-- ----------------------------
DROP TABLE IF EXISTS `mtl_dict_data`;
CREATE TABLE `mtl_dict_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(11) DEFAULT NULL COMMENT '是否删除',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `dict_id` int(255) DEFAULT NULL COMMENT '字典id',
  `sort_order` decimal(10,2) DEFAULT NULL COMMENT '排序',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `title` varchar(255) DEFAULT NULL COMMENT '名称',
  `value` varchar(255) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mtl_dict_data
-- ----------------------------
INSERT INTO `mtl_dict_data` VALUES ('1', 'admin', '2018-11-14 23:44:19', '0', 'admin', '2018-11-14 23:50:23', '', '1', '0.00', '0', '男', '1');
INSERT INTO `mtl_dict_data` VALUES ('2', 'admin', '2018-11-14 23:48:24', '0', 'admin', '2018-11-14 23:50:14', '', '1', '1.00', '0', '女', '0');
INSERT INTO `mtl_dict_data` VALUES ('3', 'admin', '2018-11-14 23:50:57', '0', 'admin', '2018-11-15 17:27:15', '', '1', '2.00', '-1', '保密', '2');
INSERT INTO `mtl_dict_data` VALUES ('4', 'admin', '2018-11-15 14:48:00', '0', 'admin', '2018-11-15 14:48:41', '', '2', '0.00', '0', '系统公告', '0');
INSERT INTO `mtl_dict_data` VALUES ('5', 'admin', '2018-11-15 14:48:14', '0', 'admin', '2018-11-15 14:48:44', '', '2', '1.00', '0', '提醒', '1');
INSERT INTO `mtl_dict_data` VALUES ('6', 'admin', '2018-11-15 14:48:30', '0', 'admin', '2018-11-15 14:48:48', '', '2', '2.00', '0', '私信', '2');
INSERT INTO `mtl_dict_data` VALUES ('7', 'admin', '2018-11-15 15:08:26', '0', 'admin', '2018-11-15 15:08:26', '', '3', '0.00', '0', '查看操作(view)', 'view');
INSERT INTO `mtl_dict_data` VALUES ('8', 'admin', '2018-11-15 15:08:49', '0', 'admin', '2018-11-15 15:08:57', '', '3', '1.00', '0', '添加操作(add)', 'add');
INSERT INTO `mtl_dict_data` VALUES ('9', 'admin', '2018-11-15 15:09:15', '0', 'admin', '2018-11-15 15:09:15', '', '3', '2.00', '0', '编辑操作(edit)', 'edit');
INSERT INTO `mtl_dict_data` VALUES ('10', 'admin', '2018-11-15 15:09:32', '0', 'admin', '2018-11-15 15:09:32', '', '3', '3.00', '0', '删除操作(delete)', 'delete');
INSERT INTO `mtl_dict_data` VALUES ('11', 'admin', '2018-11-15 15:09:46', '0', 'admin', '2018-11-15 15:09:46', '', '3', '4.00', '0', '清空操作(clear)', 'clear');
INSERT INTO `mtl_dict_data` VALUES ('12', 'admin', '2018-11-15 15:10:02', '0', 'admin', '2018-11-15 15:10:02', '', '3', '5.00', '0', '启用操作(enable)', 'enable');
INSERT INTO `mtl_dict_data` VALUES ('13', 'admin', '2018-11-15 15:10:16', '0', 'admin', '2018-11-15 15:10:16', '', '3', '6.00', '0', '禁用操作(disable)', 'disable');
INSERT INTO `mtl_dict_data` VALUES ('14', 'admin', '2018-11-15 15:10:27', '0', 'admin', '2018-11-15 15:10:27', '', '3', '7.00', '0', '搜索操作(search)', 'search');
INSERT INTO `mtl_dict_data` VALUES ('15', 'admin', '2018-11-15 15:10:38', '0', 'admin', '2018-11-15 15:10:38', '', '3', '8.00', '0', '上传文件(upload)', 'upload');
INSERT INTO `mtl_dict_data` VALUES ('16', 'admin', '2018-11-15 15:10:53', '0', 'admin', '2018-11-15 15:10:53', '', '3', '9.00', '0', '导出操作(output)', 'output');
INSERT INTO `mtl_dict_data` VALUES ('17', 'admin', '2018-11-15 15:11:09', '0', 'admin', '2018-11-15 15:11:09', '', '3', '10.00', '0', '导入操作(input)', 'input');
INSERT INTO `mtl_dict_data` VALUES ('18', 'admin', '2018-11-15 15:11:21', '0', 'admin', '2018-11-15 15:11:21', '', '3', '11.00', '0', '分配权限(editPerm)', 'editPerm');
INSERT INTO `mtl_dict_data` VALUES ('19', 'admin', '2018-11-15 15:11:34', '0', 'admin', '2018-11-15 15:11:34', '', '3', '12.00', '0', '设为默认(setDefault)', 'setDefault');
INSERT INTO `mtl_dict_data` VALUES ('20', 'admin', '2018-11-15 15:12:26', '0', 'admin', '2018-11-15 15:12:26', '', '3', '13.00', '0', '其他操作(other)', 'other');

-- ----------------------------
-- Table structure for `mtl_iconfont`
-- ----------------------------
DROP TABLE IF EXISTS `mtl_iconfont`;
CREATE TABLE `mtl_iconfont` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mtl_iconfont
-- ----------------------------
INSERT INTO `mtl_iconfont` VALUES ('1', 'fa-glass');
INSERT INTO `mtl_iconfont` VALUES ('2', 'fa-music');
INSERT INTO `mtl_iconfont` VALUES ('3', 'fa-search');
INSERT INTO `mtl_iconfont` VALUES ('4', 'fa-envelope-o');
INSERT INTO `mtl_iconfont` VALUES ('5', 'fa-heart');
INSERT INTO `mtl_iconfont` VALUES ('6', 'fa-star');
INSERT INTO `mtl_iconfont` VALUES ('7', 'fa-star-o');
INSERT INTO `mtl_iconfont` VALUES ('8', 'fa-user');
INSERT INTO `mtl_iconfont` VALUES ('9', 'fa-film');
INSERT INTO `mtl_iconfont` VALUES ('10', 'fa-th-large');
INSERT INTO `mtl_iconfont` VALUES ('11', 'fa-th');
INSERT INTO `mtl_iconfont` VALUES ('12', 'fa-th-list');
INSERT INTO `mtl_iconfont` VALUES ('13', 'fa-check');
INSERT INTO `mtl_iconfont` VALUES ('14', 'fa-remove');
INSERT INTO `mtl_iconfont` VALUES ('15', 'fa-close');
INSERT INTO `mtl_iconfont` VALUES ('16', 'fa-times');
INSERT INTO `mtl_iconfont` VALUES ('17', 'fa-search-plus');
INSERT INTO `mtl_iconfont` VALUES ('18', 'fa-search-minus');
INSERT INTO `mtl_iconfont` VALUES ('19', 'fa-power-off');
INSERT INTO `mtl_iconfont` VALUES ('20', 'fa-signal');
INSERT INTO `mtl_iconfont` VALUES ('21', 'fa-gear');
INSERT INTO `mtl_iconfont` VALUES ('22', 'fa-cog');
INSERT INTO `mtl_iconfont` VALUES ('23', 'fa-trash-o');
INSERT INTO `mtl_iconfont` VALUES ('24', 'fa-home');
INSERT INTO `mtl_iconfont` VALUES ('25', 'fa-file-o');
INSERT INTO `mtl_iconfont` VALUES ('26', 'fa-clock-o');
INSERT INTO `mtl_iconfont` VALUES ('27', 'fa-road');
INSERT INTO `mtl_iconfont` VALUES ('28', 'fa-download');
INSERT INTO `mtl_iconfont` VALUES ('29', 'fa-arrow-circle-o-do');
INSERT INTO `mtl_iconfont` VALUES ('30', 'fa-arrow-circle-o-up');
INSERT INTO `mtl_iconfont` VALUES ('31', 'fa-inbox');
INSERT INTO `mtl_iconfont` VALUES ('32', 'fa-play-circle-o');
INSERT INTO `mtl_iconfont` VALUES ('33', 'fa-rotate-right');
INSERT INTO `mtl_iconfont` VALUES ('34', 'fa-repeat');
INSERT INTO `mtl_iconfont` VALUES ('35', 'fa-refresh');
INSERT INTO `mtl_iconfont` VALUES ('36', 'fa-list-alt');
INSERT INTO `mtl_iconfont` VALUES ('37', 'fa-lock');
INSERT INTO `mtl_iconfont` VALUES ('38', 'fa-flag');
INSERT INTO `mtl_iconfont` VALUES ('39', 'fa-headphones');
INSERT INTO `mtl_iconfont` VALUES ('40', 'fa-volume-off');
INSERT INTO `mtl_iconfont` VALUES ('41', 'fa-volume-down');
INSERT INTO `mtl_iconfont` VALUES ('42', 'fa-volume-up');
INSERT INTO `mtl_iconfont` VALUES ('43', 'fa-qrcode');
INSERT INTO `mtl_iconfont` VALUES ('44', 'fa-barcode');
INSERT INTO `mtl_iconfont` VALUES ('45', 'fa-tag');
INSERT INTO `mtl_iconfont` VALUES ('46', 'fa-tags');
INSERT INTO `mtl_iconfont` VALUES ('47', 'fa-book');
INSERT INTO `mtl_iconfont` VALUES ('48', 'fa-bookmark');
INSERT INTO `mtl_iconfont` VALUES ('49', 'fa-print');
INSERT INTO `mtl_iconfont` VALUES ('50', 'fa-camera');
INSERT INTO `mtl_iconfont` VALUES ('51', 'fa-font');
INSERT INTO `mtl_iconfont` VALUES ('52', 'fa-bold');
INSERT INTO `mtl_iconfont` VALUES ('53', 'fa-italic');
INSERT INTO `mtl_iconfont` VALUES ('54', 'fa-text-height');
INSERT INTO `mtl_iconfont` VALUES ('55', 'fa-text-width');
INSERT INTO `mtl_iconfont` VALUES ('56', 'fa-align-left');
INSERT INTO `mtl_iconfont` VALUES ('57', 'fa-align-center');
INSERT INTO `mtl_iconfont` VALUES ('58', 'fa-align-right');
INSERT INTO `mtl_iconfont` VALUES ('59', 'fa-align-justify');
INSERT INTO `mtl_iconfont` VALUES ('60', 'fa-list');
INSERT INTO `mtl_iconfont` VALUES ('61', 'fa-dedent');
INSERT INTO `mtl_iconfont` VALUES ('62', 'fa-outdent');
INSERT INTO `mtl_iconfont` VALUES ('63', 'fa-indent');
INSERT INTO `mtl_iconfont` VALUES ('64', 'fa-video-camera');
INSERT INTO `mtl_iconfont` VALUES ('65', 'fa-photo');
INSERT INTO `mtl_iconfont` VALUES ('66', 'fa-image');
INSERT INTO `mtl_iconfont` VALUES ('67', 'fa-picture-o');
INSERT INTO `mtl_iconfont` VALUES ('68', 'fa-pencil');
INSERT INTO `mtl_iconfont` VALUES ('69', 'fa-map-marker');
INSERT INTO `mtl_iconfont` VALUES ('70', 'fa-adjust');
INSERT INTO `mtl_iconfont` VALUES ('71', 'fa-tint');
INSERT INTO `mtl_iconfont` VALUES ('72', 'fa-edit');
INSERT INTO `mtl_iconfont` VALUES ('73', 'fa-pencil-square-o');
INSERT INTO `mtl_iconfont` VALUES ('74', 'fa-share-square-o');
INSERT INTO `mtl_iconfont` VALUES ('75', 'fa-check-square-o');
INSERT INTO `mtl_iconfont` VALUES ('76', 'fa-arrows');
INSERT INTO `mtl_iconfont` VALUES ('77', 'fa-step-backward');
INSERT INTO `mtl_iconfont` VALUES ('78', 'fa-fast-backward');
INSERT INTO `mtl_iconfont` VALUES ('79', 'fa-backward');
INSERT INTO `mtl_iconfont` VALUES ('80', 'fa-play');
INSERT INTO `mtl_iconfont` VALUES ('81', 'fa-pause');
INSERT INTO `mtl_iconfont` VALUES ('82', 'fa-stop');
INSERT INTO `mtl_iconfont` VALUES ('83', 'fa-forward');
INSERT INTO `mtl_iconfont` VALUES ('84', 'fa-fast-forward');
INSERT INTO `mtl_iconfont` VALUES ('85', 'fa-step-forward');
INSERT INTO `mtl_iconfont` VALUES ('86', 'fa-eject');
INSERT INTO `mtl_iconfont` VALUES ('87', 'fa-chevron-left');
INSERT INTO `mtl_iconfont` VALUES ('88', 'fa-chevron-right');
INSERT INTO `mtl_iconfont` VALUES ('89', 'fa-plus-circle');
INSERT INTO `mtl_iconfont` VALUES ('90', 'fa-minus-circle');
INSERT INTO `mtl_iconfont` VALUES ('91', 'fa-times-circle');
INSERT INTO `mtl_iconfont` VALUES ('92', 'fa-check-circle');
INSERT INTO `mtl_iconfont` VALUES ('93', 'fa-question-circle');
INSERT INTO `mtl_iconfont` VALUES ('94', 'fa-info-circle');
INSERT INTO `mtl_iconfont` VALUES ('95', 'fa-crosshairs');
INSERT INTO `mtl_iconfont` VALUES ('96', 'fa-times-circle-o');
INSERT INTO `mtl_iconfont` VALUES ('97', 'fa-check-circle-o');
INSERT INTO `mtl_iconfont` VALUES ('98', 'fa-ban');
INSERT INTO `mtl_iconfont` VALUES ('99', '');
INSERT INTO `mtl_iconfont` VALUES ('100', 'fa-arrow-right');
INSERT INTO `mtl_iconfont` VALUES ('101', 'fa-arrow-up');
INSERT INTO `mtl_iconfont` VALUES ('102', 'fa-arrow-down');
INSERT INTO `mtl_iconfont` VALUES ('103', 'fa-mail-forward');
INSERT INTO `mtl_iconfont` VALUES ('104', 'fa-share');
INSERT INTO `mtl_iconfont` VALUES ('105', 'fa-expand');
INSERT INTO `mtl_iconfont` VALUES ('106', 'fa-compress');
INSERT INTO `mtl_iconfont` VALUES ('107', 'fa-plus');
INSERT INTO `mtl_iconfont` VALUES ('108', 'fa-minus');
INSERT INTO `mtl_iconfont` VALUES ('109', 'fa-asterisk');
INSERT INTO `mtl_iconfont` VALUES ('110', 'fa-exclamation-circl');
INSERT INTO `mtl_iconfont` VALUES ('111', 'fa-gift');
INSERT INTO `mtl_iconfont` VALUES ('112', 'fa-leaf');
INSERT INTO `mtl_iconfont` VALUES ('113', 'fa-fire');
INSERT INTO `mtl_iconfont` VALUES ('114', 'fa-eye');
INSERT INTO `mtl_iconfont` VALUES ('115', 'fa-eye-slash');
INSERT INTO `mtl_iconfont` VALUES ('116', 'fa-warning');
INSERT INTO `mtl_iconfont` VALUES ('117', 'fa-exclamation-trian');
INSERT INTO `mtl_iconfont` VALUES ('118', 'fa-plane');
INSERT INTO `mtl_iconfont` VALUES ('119', 'fa-calendar');
INSERT INTO `mtl_iconfont` VALUES ('120', 'fa-random');
INSERT INTO `mtl_iconfont` VALUES ('121', 'fa-comment');
INSERT INTO `mtl_iconfont` VALUES ('122', 'fa-magnet');
INSERT INTO `mtl_iconfont` VALUES ('123', 'fa-chevron-up');
INSERT INTO `mtl_iconfont` VALUES ('124', 'fa-chevron-down');
INSERT INTO `mtl_iconfont` VALUES ('125', 'fa-retweet');
INSERT INTO `mtl_iconfont` VALUES ('126', 'fa-shopping-cart');
INSERT INTO `mtl_iconfont` VALUES ('127', 'fa-folder');
INSERT INTO `mtl_iconfont` VALUES ('128', 'fa-folder-open');
INSERT INTO `mtl_iconfont` VALUES ('129', 'fa-arrows-v');
INSERT INTO `mtl_iconfont` VALUES ('130', 'fa-arrows-h');
INSERT INTO `mtl_iconfont` VALUES ('131', 'fa-bar-chart-o');
INSERT INTO `mtl_iconfont` VALUES ('132', 'fa-bar-chart');
INSERT INTO `mtl_iconfont` VALUES ('133', 'fa-twitter-square');
INSERT INTO `mtl_iconfont` VALUES ('134', 'fa-facebook-square');
INSERT INTO `mtl_iconfont` VALUES ('135', 'fa-camera-retro');
INSERT INTO `mtl_iconfont` VALUES ('136', 'fa-key');
INSERT INTO `mtl_iconfont` VALUES ('137', 'fa-gears');
INSERT INTO `mtl_iconfont` VALUES ('138', 'fa-cogs');
INSERT INTO `mtl_iconfont` VALUES ('139', 'fa-comments');
INSERT INTO `mtl_iconfont` VALUES ('140', 'fa-thumbs-o-up');
INSERT INTO `mtl_iconfont` VALUES ('141', 'fa-thumbs-o-down');
INSERT INTO `mtl_iconfont` VALUES ('142', 'fa-star-half');
INSERT INTO `mtl_iconfont` VALUES ('143', 'fa-heart-o');
INSERT INTO `mtl_iconfont` VALUES ('144', 'fa-sign-out');
INSERT INTO `mtl_iconfont` VALUES ('145', 'fa-linkedin-square');
INSERT INTO `mtl_iconfont` VALUES ('146', 'fa-thumb-tack');
INSERT INTO `mtl_iconfont` VALUES ('147', 'fa-external-link');
INSERT INTO `mtl_iconfont` VALUES ('148', 'fa-sign-in');
INSERT INTO `mtl_iconfont` VALUES ('149', 'fa-trophy');
INSERT INTO `mtl_iconfont` VALUES ('150', 'fa-github-square');
INSERT INTO `mtl_iconfont` VALUES ('151', 'fa-upload');
INSERT INTO `mtl_iconfont` VALUES ('152', 'fa-lemon-o');
INSERT INTO `mtl_iconfont` VALUES ('153', 'fa-phone');
INSERT INTO `mtl_iconfont` VALUES ('154', 'fa-square-o');
INSERT INTO `mtl_iconfont` VALUES ('155', 'fa-bookmark-o');
INSERT INTO `mtl_iconfont` VALUES ('156', 'fa-phone-square');
INSERT INTO `mtl_iconfont` VALUES ('157', 'fa-twitter');
INSERT INTO `mtl_iconfont` VALUES ('158', 'fa-facebook');
INSERT INTO `mtl_iconfont` VALUES ('159', 'fa-github');
INSERT INTO `mtl_iconfont` VALUES ('160', 'fa-unlock');
INSERT INTO `mtl_iconfont` VALUES ('161', 'fa-credit-card');
INSERT INTO `mtl_iconfont` VALUES ('162', 'fa-rss');
INSERT INTO `mtl_iconfont` VALUES ('163', 'fa-hdd-o');
INSERT INTO `mtl_iconfont` VALUES ('164', 'fa-bullhorn');
INSERT INTO `mtl_iconfont` VALUES ('165', 'fa-bell');
INSERT INTO `mtl_iconfont` VALUES ('166', 'fa-certificate');
INSERT INTO `mtl_iconfont` VALUES ('167', 'fa-hand-o-right');
INSERT INTO `mtl_iconfont` VALUES ('168', 'fa-hand-o-left');
INSERT INTO `mtl_iconfont` VALUES ('169', 'fa-hand-o-up');
INSERT INTO `mtl_iconfont` VALUES ('170', 'fa-hand-o-down');
INSERT INTO `mtl_iconfont` VALUES ('171', 'fa-arrow-circle-left');
INSERT INTO `mtl_iconfont` VALUES ('172', 'fa-arrow-circle-righ');
INSERT INTO `mtl_iconfont` VALUES ('173', 'fa-arrow-circle-up');
INSERT INTO `mtl_iconfont` VALUES ('174', 'fa-arrow-circle-down');
INSERT INTO `mtl_iconfont` VALUES ('175', 'fa-globe');
INSERT INTO `mtl_iconfont` VALUES ('176', 'fa-wrench');
INSERT INTO `mtl_iconfont` VALUES ('177', 'fa-tasks');
INSERT INTO `mtl_iconfont` VALUES ('178', 'fa-filter');
INSERT INTO `mtl_iconfont` VALUES ('179', 'fa-briefcase');
INSERT INTO `mtl_iconfont` VALUES ('180', 'fa-arrows-alt');
INSERT INTO `mtl_iconfont` VALUES ('181', 'fa-group');
INSERT INTO `mtl_iconfont` VALUES ('182', 'fa-users');
INSERT INTO `mtl_iconfont` VALUES ('183', 'fa-chain');
INSERT INTO `mtl_iconfont` VALUES ('184', 'fa-link');
INSERT INTO `mtl_iconfont` VALUES ('185', 'fa-cloud');
INSERT INTO `mtl_iconfont` VALUES ('186', 'fa-flask');
INSERT INTO `mtl_iconfont` VALUES ('187', 'fa-cut');
INSERT INTO `mtl_iconfont` VALUES ('188', 'fa-scissors');
INSERT INTO `mtl_iconfont` VALUES ('189', 'fa-copy');
INSERT INTO `mtl_iconfont` VALUES ('190', 'fa-files-o');
INSERT INTO `mtl_iconfont` VALUES ('191', 'fa-paperclip');
INSERT INTO `mtl_iconfont` VALUES ('192', 'fa-save');
INSERT INTO `mtl_iconfont` VALUES ('193', 'fa-floppy-o');
INSERT INTO `mtl_iconfont` VALUES ('194', 'fa-square');
INSERT INTO `mtl_iconfont` VALUES ('195', 'fa-navicon');
INSERT INTO `mtl_iconfont` VALUES ('196', 'fa-reorder');
INSERT INTO `mtl_iconfont` VALUES ('197', 'fa-bars');
INSERT INTO `mtl_iconfont` VALUES ('198', 'fa-list-ul');
INSERT INTO `mtl_iconfont` VALUES ('199', 'fa-list-ol');
INSERT INTO `mtl_iconfont` VALUES ('200', 'fa-strikethrough');
INSERT INTO `mtl_iconfont` VALUES ('201', 'fa-underline');
INSERT INTO `mtl_iconfont` VALUES ('202', 'fa-table');
INSERT INTO `mtl_iconfont` VALUES ('203', 'fa-magic');
INSERT INTO `mtl_iconfont` VALUES ('204', 'fa-truck');
INSERT INTO `mtl_iconfont` VALUES ('205', 'fa-pinterest');
INSERT INTO `mtl_iconfont` VALUES ('206', 'fa-pinterest-square');
INSERT INTO `mtl_iconfont` VALUES ('207', 'fa-google-plus-squar');
INSERT INTO `mtl_iconfont` VALUES ('208', 'fa-google-plus');
INSERT INTO `mtl_iconfont` VALUES ('209', 'fa-money');
INSERT INTO `mtl_iconfont` VALUES ('210', 'fa-caret-down');
INSERT INTO `mtl_iconfont` VALUES ('211', 'fa-caret-up');
INSERT INTO `mtl_iconfont` VALUES ('212', 'fa-caret-left');
INSERT INTO `mtl_iconfont` VALUES ('213', 'fa-caret-right');
INSERT INTO `mtl_iconfont` VALUES ('214', 'fa-columns');
INSERT INTO `mtl_iconfont` VALUES ('215', 'fa-unsorted');
INSERT INTO `mtl_iconfont` VALUES ('216', 'fa-sort');
INSERT INTO `mtl_iconfont` VALUES ('217', 'fa-sort-down');
INSERT INTO `mtl_iconfont` VALUES ('218', 'fa-sort-desc');
INSERT INTO `mtl_iconfont` VALUES ('219', 'fa-sort-up');
INSERT INTO `mtl_iconfont` VALUES ('220', 'fa-sort-asc');
INSERT INTO `mtl_iconfont` VALUES ('221', 'fa-envelope');
INSERT INTO `mtl_iconfont` VALUES ('222', 'fa-linkedin');
INSERT INTO `mtl_iconfont` VALUES ('223', 'fa-rotate-left');
INSERT INTO `mtl_iconfont` VALUES ('224', 'fa-undo');
INSERT INTO `mtl_iconfont` VALUES ('225', 'fa-legal');
INSERT INTO `mtl_iconfont` VALUES ('226', 'fa-gavel');
INSERT INTO `mtl_iconfont` VALUES ('227', 'fa-dashboard');
INSERT INTO `mtl_iconfont` VALUES ('228', 'fa-tachometer');
INSERT INTO `mtl_iconfont` VALUES ('229', 'fa-comment-o');
INSERT INTO `mtl_iconfont` VALUES ('230', 'fa-comments-o');
INSERT INTO `mtl_iconfont` VALUES ('231', 'fa-flash');
INSERT INTO `mtl_iconfont` VALUES ('232', 'fa-bolt');
INSERT INTO `mtl_iconfont` VALUES ('233', 'fa-sitemap');
INSERT INTO `mtl_iconfont` VALUES ('234', 'fa-umbrella');
INSERT INTO `mtl_iconfont` VALUES ('235', 'fa-paste');
INSERT INTO `mtl_iconfont` VALUES ('236', 'fa-clipboard');
INSERT INTO `mtl_iconfont` VALUES ('237', 'fa-lightbulb-o');
INSERT INTO `mtl_iconfont` VALUES ('238', 'fa-exchange');
INSERT INTO `mtl_iconfont` VALUES ('239', 'fa-cloud-download');
INSERT INTO `mtl_iconfont` VALUES ('240', 'fa-cloud-upload');
INSERT INTO `mtl_iconfont` VALUES ('241', 'fa-user-md');
INSERT INTO `mtl_iconfont` VALUES ('242', 'fa-stethoscope');
INSERT INTO `mtl_iconfont` VALUES ('243', 'fa-suitcase');
INSERT INTO `mtl_iconfont` VALUES ('244', 'fa-bell-o');
INSERT INTO `mtl_iconfont` VALUES ('245', 'fa-coffee');
INSERT INTO `mtl_iconfont` VALUES ('246', 'fa-cutlery');
INSERT INTO `mtl_iconfont` VALUES ('247', 'fa-file-text-o');
INSERT INTO `mtl_iconfont` VALUES ('248', 'fa-building-o');
INSERT INTO `mtl_iconfont` VALUES ('249', 'fa-hospital-o');
INSERT INTO `mtl_iconfont` VALUES ('250', 'fa-ambulance');
INSERT INTO `mtl_iconfont` VALUES ('251', 'fa-medkit');
INSERT INTO `mtl_iconfont` VALUES ('252', 'fa-fighter-jet');
INSERT INTO `mtl_iconfont` VALUES ('253', 'fa-beer');
INSERT INTO `mtl_iconfont` VALUES ('254', 'fa-h-square');
INSERT INTO `mtl_iconfont` VALUES ('255', 'fa-plus-square');
INSERT INTO `mtl_iconfont` VALUES ('256', 'fa-angle-double-left');
INSERT INTO `mtl_iconfont` VALUES ('257', 'fa-angle-double-righ');
INSERT INTO `mtl_iconfont` VALUES ('258', 'fa-angle-double-up');
INSERT INTO `mtl_iconfont` VALUES ('259', 'fa-angle-double-down');
INSERT INTO `mtl_iconfont` VALUES ('260', 'fa-angle-left');
INSERT INTO `mtl_iconfont` VALUES ('261', 'fa-angle-right');
INSERT INTO `mtl_iconfont` VALUES ('262', 'fa-angle-up');
INSERT INTO `mtl_iconfont` VALUES ('263', 'fa-angle-down');
INSERT INTO `mtl_iconfont` VALUES ('264', 'fa-desktop');
INSERT INTO `mtl_iconfont` VALUES ('265', 'fa-laptop');
INSERT INTO `mtl_iconfont` VALUES ('266', 'fa-tablet');
INSERT INTO `mtl_iconfont` VALUES ('267', 'fa-mobile-phone');
INSERT INTO `mtl_iconfont` VALUES ('268', 'fa-mobile');
INSERT INTO `mtl_iconfont` VALUES ('269', 'fa-circle-o');
INSERT INTO `mtl_iconfont` VALUES ('270', 'fa-quote-left');
INSERT INTO `mtl_iconfont` VALUES ('271', 'fa-quote-right');
INSERT INTO `mtl_iconfont` VALUES ('272', 'fa-spinner');
INSERT INTO `mtl_iconfont` VALUES ('273', 'fa-circle');
INSERT INTO `mtl_iconfont` VALUES ('274', 'fa-mail-reply');
INSERT INTO `mtl_iconfont` VALUES ('275', 'fa-reply');
INSERT INTO `mtl_iconfont` VALUES ('276', 'fa-github-alt');
INSERT INTO `mtl_iconfont` VALUES ('277', 'fa-folder-o');
INSERT INTO `mtl_iconfont` VALUES ('278', 'fa-folder-open-o');
INSERT INTO `mtl_iconfont` VALUES ('279', 'fa-smile-o');
INSERT INTO `mtl_iconfont` VALUES ('280', 'fa-frown-o');
INSERT INTO `mtl_iconfont` VALUES ('281', 'fa-meh-o');
INSERT INTO `mtl_iconfont` VALUES ('282', 'fa-gamepad');
INSERT INTO `mtl_iconfont` VALUES ('283', 'fa-keyboard-o');
INSERT INTO `mtl_iconfont` VALUES ('284', 'fa-flag-o');
INSERT INTO `mtl_iconfont` VALUES ('285', 'fa-flag-checkered');
INSERT INTO `mtl_iconfont` VALUES ('286', 'fa-terminal');
INSERT INTO `mtl_iconfont` VALUES ('287', 'fa-code');
INSERT INTO `mtl_iconfont` VALUES ('288', 'fa-mail-reply-all');
INSERT INTO `mtl_iconfont` VALUES ('289', 'fa-reply-all');
INSERT INTO `mtl_iconfont` VALUES ('290', 'fa-star-half-empty');
INSERT INTO `mtl_iconfont` VALUES ('291', 'fa-star-half-full');
INSERT INTO `mtl_iconfont` VALUES ('292', 'fa-star-half-o');
INSERT INTO `mtl_iconfont` VALUES ('293', 'fa-location-arrow');
INSERT INTO `mtl_iconfont` VALUES ('294', 'fa-crop');
INSERT INTO `mtl_iconfont` VALUES ('295', 'fa-code-fork');
INSERT INTO `mtl_iconfont` VALUES ('296', 'fa-unlink');
INSERT INTO `mtl_iconfont` VALUES ('297', 'fa-chain-broken');
INSERT INTO `mtl_iconfont` VALUES ('298', 'fa-question');
INSERT INTO `mtl_iconfont` VALUES ('299', 'fa-info');
INSERT INTO `mtl_iconfont` VALUES ('300', 'fa-exclamation');
INSERT INTO `mtl_iconfont` VALUES ('301', 'fa-superscript');
INSERT INTO `mtl_iconfont` VALUES ('302', 'fa-subscript');
INSERT INTO `mtl_iconfont` VALUES ('303', 'fa-eraser');
INSERT INTO `mtl_iconfont` VALUES ('304', 'fa-puzzle-piece');
INSERT INTO `mtl_iconfont` VALUES ('305', 'fa-microphone');
INSERT INTO `mtl_iconfont` VALUES ('306', 'fa-microphone-slash');
INSERT INTO `mtl_iconfont` VALUES ('307', 'fa-shield');
INSERT INTO `mtl_iconfont` VALUES ('308', 'fa-calendar-o');
INSERT INTO `mtl_iconfont` VALUES ('309', 'fa-fire-extinguisher');
INSERT INTO `mtl_iconfont` VALUES ('310', 'fa-rocket');
INSERT INTO `mtl_iconfont` VALUES ('311', 'fa-maxcdn');
INSERT INTO `mtl_iconfont` VALUES ('312', 'fa-chevron-circle-le');
INSERT INTO `mtl_iconfont` VALUES ('313', 'fa-chevron-circle-ri');
INSERT INTO `mtl_iconfont` VALUES ('314', 'fa-chevron-circle-up');
INSERT INTO `mtl_iconfont` VALUES ('315', 'fa-chevron-circle-do');
INSERT INTO `mtl_iconfont` VALUES ('316', 'fa-html5');
INSERT INTO `mtl_iconfont` VALUES ('317', 'fa-css3');
INSERT INTO `mtl_iconfont` VALUES ('318', 'fa-anchor');
INSERT INTO `mtl_iconfont` VALUES ('319', 'fa-unlock-alt');
INSERT INTO `mtl_iconfont` VALUES ('320', 'fa-bullseye');
INSERT INTO `mtl_iconfont` VALUES ('321', 'fa-ellipsis-h');
INSERT INTO `mtl_iconfont` VALUES ('322', 'fa-ellipsis-v');
INSERT INTO `mtl_iconfont` VALUES ('323', 'fa-rss-square');
INSERT INTO `mtl_iconfont` VALUES ('324', 'fa-play-circle');
INSERT INTO `mtl_iconfont` VALUES ('325', 'fa-ticket');
INSERT INTO `mtl_iconfont` VALUES ('326', 'fa-minus-square');
INSERT INTO `mtl_iconfont` VALUES ('327', 'fa-minus-square-o');
INSERT INTO `mtl_iconfont` VALUES ('328', 'fa-level-up');
INSERT INTO `mtl_iconfont` VALUES ('329', 'fa-level-down');
INSERT INTO `mtl_iconfont` VALUES ('330', 'fa-check-square');
INSERT INTO `mtl_iconfont` VALUES ('331', 'fa-pencil-square');
INSERT INTO `mtl_iconfont` VALUES ('332', 'fa-external-link-squ');
INSERT INTO `mtl_iconfont` VALUES ('333', 'fa-share-square');
INSERT INTO `mtl_iconfont` VALUES ('334', 'fa-compass');
INSERT INTO `mtl_iconfont` VALUES ('335', 'fa-toggle-down');
INSERT INTO `mtl_iconfont` VALUES ('336', 'fa-caret-square-o-do');
INSERT INTO `mtl_iconfont` VALUES ('337', 'fa-toggle-up');
INSERT INTO `mtl_iconfont` VALUES ('338', 'fa-caret-square-o-up');
INSERT INTO `mtl_iconfont` VALUES ('339', 'fa-toggle-right');
INSERT INTO `mtl_iconfont` VALUES ('340', 'fa-caret-square-o-ri');
INSERT INTO `mtl_iconfont` VALUES ('341', 'fa-euro');
INSERT INTO `mtl_iconfont` VALUES ('342', 'fa-eur');
INSERT INTO `mtl_iconfont` VALUES ('343', 'fa-gbp');
INSERT INTO `mtl_iconfont` VALUES ('344', 'fa-dollar');
INSERT INTO `mtl_iconfont` VALUES ('345', 'fa-usd');
INSERT INTO `mtl_iconfont` VALUES ('346', 'fa-rupee');
INSERT INTO `mtl_iconfont` VALUES ('347', 'fa-inr');
INSERT INTO `mtl_iconfont` VALUES ('348', 'fa-cny');
INSERT INTO `mtl_iconfont` VALUES ('349', 'fa-rmb');
INSERT INTO `mtl_iconfont` VALUES ('350', 'fa-yen');
INSERT INTO `mtl_iconfont` VALUES ('351', 'fa-jpy');
INSERT INTO `mtl_iconfont` VALUES ('352', 'fa-ruble');
INSERT INTO `mtl_iconfont` VALUES ('353', 'fa-rouble');
INSERT INTO `mtl_iconfont` VALUES ('354', 'fa-rub');
INSERT INTO `mtl_iconfont` VALUES ('355', 'fa-won');
INSERT INTO `mtl_iconfont` VALUES ('356', 'fa-krw');
INSERT INTO `mtl_iconfont` VALUES ('357', 'fa-bitcoin');
INSERT INTO `mtl_iconfont` VALUES ('358', 'fa-btc');
INSERT INTO `mtl_iconfont` VALUES ('359', 'fa-file');
INSERT INTO `mtl_iconfont` VALUES ('360', 'fa-file-text');
INSERT INTO `mtl_iconfont` VALUES ('361', 'fa-sort-alpha-asc');
INSERT INTO `mtl_iconfont` VALUES ('362', 'fa-sort-alpha-desc');
INSERT INTO `mtl_iconfont` VALUES ('363', 'fa-sort-amount-asc');
INSERT INTO `mtl_iconfont` VALUES ('364', 'fa-sort-amount-desc');
INSERT INTO `mtl_iconfont` VALUES ('365', 'fa-sort-numeric-asc');
INSERT INTO `mtl_iconfont` VALUES ('366', 'fa-sort-numeric-desc');
INSERT INTO `mtl_iconfont` VALUES ('367', 'fa-thumbs-up');
INSERT INTO `mtl_iconfont` VALUES ('368', 'fa-thumbs-down');
INSERT INTO `mtl_iconfont` VALUES ('369', 'fa-youtube-square');
INSERT INTO `mtl_iconfont` VALUES ('370', 'fa-youtube');
INSERT INTO `mtl_iconfont` VALUES ('371', 'fa-xing');
INSERT INTO `mtl_iconfont` VALUES ('372', 'fa-xing-square');
INSERT INTO `mtl_iconfont` VALUES ('373', 'fa-youtube-play');
INSERT INTO `mtl_iconfont` VALUES ('374', 'fa-dropbox');
INSERT INTO `mtl_iconfont` VALUES ('375', 'fa-stack-overflow');
INSERT INTO `mtl_iconfont` VALUES ('376', 'fa-instagram');
INSERT INTO `mtl_iconfont` VALUES ('377', 'fa-flickr');
INSERT INTO `mtl_iconfont` VALUES ('378', 'fa-adn');
INSERT INTO `mtl_iconfont` VALUES ('379', 'fa-bitbucket');
INSERT INTO `mtl_iconfont` VALUES ('380', 'fa-bitbucket-square');
INSERT INTO `mtl_iconfont` VALUES ('381', 'fa-tumblr');
INSERT INTO `mtl_iconfont` VALUES ('382', 'fa-tumblr-square');
INSERT INTO `mtl_iconfont` VALUES ('383', 'fa-long-arrow-down');
INSERT INTO `mtl_iconfont` VALUES ('384', 'fa-long-arrow-up');
INSERT INTO `mtl_iconfont` VALUES ('385', 'fa-long-arrow-left');
INSERT INTO `mtl_iconfont` VALUES ('386', 'fa-long-arrow-right');
INSERT INTO `mtl_iconfont` VALUES ('387', 'fa-apple');
INSERT INTO `mtl_iconfont` VALUES ('388', 'fa-windows');
INSERT INTO `mtl_iconfont` VALUES ('389', 'fa-android');
INSERT INTO `mtl_iconfont` VALUES ('390', 'fa-linux');
INSERT INTO `mtl_iconfont` VALUES ('391', 'fa-dribbble');
INSERT INTO `mtl_iconfont` VALUES ('392', 'fa-skype');
INSERT INTO `mtl_iconfont` VALUES ('393', 'fa-foursquare');
INSERT INTO `mtl_iconfont` VALUES ('394', 'fa-trello');
INSERT INTO `mtl_iconfont` VALUES ('395', 'fa-female');
INSERT INTO `mtl_iconfont` VALUES ('396', 'fa-male');
INSERT INTO `mtl_iconfont` VALUES ('397', 'fa-gittip');
INSERT INTO `mtl_iconfont` VALUES ('398', 'fa-sun-o');
INSERT INTO `mtl_iconfont` VALUES ('399', 'fa-moon-o');
INSERT INTO `mtl_iconfont` VALUES ('400', 'fa-archive');
INSERT INTO `mtl_iconfont` VALUES ('401', 'fa-bug');
INSERT INTO `mtl_iconfont` VALUES ('402', 'fa-vk');
INSERT INTO `mtl_iconfont` VALUES ('403', 'fa-weibo');
INSERT INTO `mtl_iconfont` VALUES ('404', 'fa-renren');
INSERT INTO `mtl_iconfont` VALUES ('405', 'fa-pagelines');
INSERT INTO `mtl_iconfont` VALUES ('406', 'fa-stack-exchange');
INSERT INTO `mtl_iconfont` VALUES ('407', 'fa-arrow-circle-o-ri');
INSERT INTO `mtl_iconfont` VALUES ('408', 'fa-arrow-circle-o-le');
INSERT INTO `mtl_iconfont` VALUES ('409', 'fa-toggle-left');
INSERT INTO `mtl_iconfont` VALUES ('410', 'fa-caret-square-o-le');
INSERT INTO `mtl_iconfont` VALUES ('411', 'fa-dot-circle-o');
INSERT INTO `mtl_iconfont` VALUES ('412', 'fa-wheelchair');
INSERT INTO `mtl_iconfont` VALUES ('413', 'fa-vimeo-square');
INSERT INTO `mtl_iconfont` VALUES ('414', 'fa-turkish-lira');
INSERT INTO `mtl_iconfont` VALUES ('415', 'fa-try');
INSERT INTO `mtl_iconfont` VALUES ('416', 'fa-plus-square-o');
INSERT INTO `mtl_iconfont` VALUES ('417', 'fa-space-shuttle');
INSERT INTO `mtl_iconfont` VALUES ('418', 'fa-slack');
INSERT INTO `mtl_iconfont` VALUES ('419', 'fa-envelope-square');
INSERT INTO `mtl_iconfont` VALUES ('420', 'fa-wordpress');
INSERT INTO `mtl_iconfont` VALUES ('421', 'fa-openid');
INSERT INTO `mtl_iconfont` VALUES ('422', 'fa-institution');
INSERT INTO `mtl_iconfont` VALUES ('423', 'fa-bank');
INSERT INTO `mtl_iconfont` VALUES ('424', 'fa-university');
INSERT INTO `mtl_iconfont` VALUES ('425', 'fa-mortar-board');
INSERT INTO `mtl_iconfont` VALUES ('426', 'fa-graduation-cap');
INSERT INTO `mtl_iconfont` VALUES ('427', 'fa-yahoo');
INSERT INTO `mtl_iconfont` VALUES ('428', 'fa-google');
INSERT INTO `mtl_iconfont` VALUES ('429', 'fa-reddit');
INSERT INTO `mtl_iconfont` VALUES ('430', 'fa-reddit-square');
INSERT INTO `mtl_iconfont` VALUES ('431', 'fa-stumbleupon-circl');
INSERT INTO `mtl_iconfont` VALUES ('432', 'fa-stumbleupon');
INSERT INTO `mtl_iconfont` VALUES ('433', 'fa-delicious');
INSERT INTO `mtl_iconfont` VALUES ('434', 'fa-digg');
INSERT INTO `mtl_iconfont` VALUES ('435', 'fa-pied-piper');
INSERT INTO `mtl_iconfont` VALUES ('436', 'fa-pied-piper-alt');
INSERT INTO `mtl_iconfont` VALUES ('437', 'fa-drupal');
INSERT INTO `mtl_iconfont` VALUES ('438', 'fa-joomla');
INSERT INTO `mtl_iconfont` VALUES ('439', 'fa-language');
INSERT INTO `mtl_iconfont` VALUES ('440', 'fa-fax');
INSERT INTO `mtl_iconfont` VALUES ('441', 'fa-building');
INSERT INTO `mtl_iconfont` VALUES ('442', 'fa-child');
INSERT INTO `mtl_iconfont` VALUES ('443', 'fa-paw');
INSERT INTO `mtl_iconfont` VALUES ('444', 'fa-spoon');
INSERT INTO `mtl_iconfont` VALUES ('445', 'fa-cube');
INSERT INTO `mtl_iconfont` VALUES ('446', 'fa-cubes');
INSERT INTO `mtl_iconfont` VALUES ('447', 'fa-behance');
INSERT INTO `mtl_iconfont` VALUES ('448', 'fa-behance-square');
INSERT INTO `mtl_iconfont` VALUES ('449', 'fa-steam');
INSERT INTO `mtl_iconfont` VALUES ('450', 'fa-steam-square');
INSERT INTO `mtl_iconfont` VALUES ('451', 'fa-recycle');
INSERT INTO `mtl_iconfont` VALUES ('452', 'fa-automobile');
INSERT INTO `mtl_iconfont` VALUES ('453', 'fa-car');
INSERT INTO `mtl_iconfont` VALUES ('454', 'fa-cab');
INSERT INTO `mtl_iconfont` VALUES ('455', 'fa-taxi');
INSERT INTO `mtl_iconfont` VALUES ('456', 'fa-tree');
INSERT INTO `mtl_iconfont` VALUES ('457', 'fa-spotify');
INSERT INTO `mtl_iconfont` VALUES ('458', 'fa-deviantart');
INSERT INTO `mtl_iconfont` VALUES ('459', 'fa-soundcloud');
INSERT INTO `mtl_iconfont` VALUES ('460', 'fa-database');
INSERT INTO `mtl_iconfont` VALUES ('461', 'fa-file-pdf-o');
INSERT INTO `mtl_iconfont` VALUES ('462', 'fa-file-word-o');
INSERT INTO `mtl_iconfont` VALUES ('463', 'fa-file-excel-o');
INSERT INTO `mtl_iconfont` VALUES ('464', 'fa-file-powerpoint-o');
INSERT INTO `mtl_iconfont` VALUES ('465', 'fa-file-photo-o');
INSERT INTO `mtl_iconfont` VALUES ('466', 'fa-file-picture-o');
INSERT INTO `mtl_iconfont` VALUES ('467', 'fa-file-image-o');
INSERT INTO `mtl_iconfont` VALUES ('468', 'fa-file-zip-o');
INSERT INTO `mtl_iconfont` VALUES ('469', 'fa-file-archive-o');
INSERT INTO `mtl_iconfont` VALUES ('470', 'fa-file-sound-o');
INSERT INTO `mtl_iconfont` VALUES ('471', 'fa-file-audio-o');
INSERT INTO `mtl_iconfont` VALUES ('472', 'fa-file-movie-o');
INSERT INTO `mtl_iconfont` VALUES ('473', 'fa-file-video-o');
INSERT INTO `mtl_iconfont` VALUES ('474', 'fa-file-code-o');
INSERT INTO `mtl_iconfont` VALUES ('475', 'fa-vine');
INSERT INTO `mtl_iconfont` VALUES ('476', 'fa-codepen');
INSERT INTO `mtl_iconfont` VALUES ('477', 'fa-jsfiddle');
INSERT INTO `mtl_iconfont` VALUES ('478', 'fa-life-bouy');
INSERT INTO `mtl_iconfont` VALUES ('479', 'fa-life-buoy');
INSERT INTO `mtl_iconfont` VALUES ('480', 'fa-life-saver');
INSERT INTO `mtl_iconfont` VALUES ('481', 'fa-support');
INSERT INTO `mtl_iconfont` VALUES ('482', 'fa-life-ring');
INSERT INTO `mtl_iconfont` VALUES ('483', 'fa-circle-o-notch');
INSERT INTO `mtl_iconfont` VALUES ('484', 'fa-ra');
INSERT INTO `mtl_iconfont` VALUES ('485', 'fa-rebel');
INSERT INTO `mtl_iconfont` VALUES ('486', 'fa-ge');
INSERT INTO `mtl_iconfont` VALUES ('487', 'fa-empire');
INSERT INTO `mtl_iconfont` VALUES ('488', 'fa-git-square');
INSERT INTO `mtl_iconfont` VALUES ('489', 'fa-git');
INSERT INTO `mtl_iconfont` VALUES ('490', 'fa-hacker-news');
INSERT INTO `mtl_iconfont` VALUES ('491', 'fa-tencent-weibo');
INSERT INTO `mtl_iconfont` VALUES ('492', 'fa-qq');
INSERT INTO `mtl_iconfont` VALUES ('493', 'fa-wechat');
INSERT INTO `mtl_iconfont` VALUES ('494', 'fa-weixin');
INSERT INTO `mtl_iconfont` VALUES ('495', 'fa-send');
INSERT INTO `mtl_iconfont` VALUES ('496', 'fa-paper-plane');
INSERT INTO `mtl_iconfont` VALUES ('497', 'fa-send-o');
INSERT INTO `mtl_iconfont` VALUES ('498', 'fa-paper-plane-o');
INSERT INTO `mtl_iconfont` VALUES ('499', 'fa-history');
INSERT INTO `mtl_iconfont` VALUES ('500', 'fa-circle-thin');
INSERT INTO `mtl_iconfont` VALUES ('501', 'fa-header');
INSERT INTO `mtl_iconfont` VALUES ('502', 'fa-paragraph');
INSERT INTO `mtl_iconfont` VALUES ('503', 'fa-sliders');
INSERT INTO `mtl_iconfont` VALUES ('504', 'fa-share-alt');
INSERT INTO `mtl_iconfont` VALUES ('505', 'fa-share-alt-square');
INSERT INTO `mtl_iconfont` VALUES ('506', 'fa-bomb');
INSERT INTO `mtl_iconfont` VALUES ('507', 'fa-soccer-ball-o');
INSERT INTO `mtl_iconfont` VALUES ('508', 'fa-futbol-o');
INSERT INTO `mtl_iconfont` VALUES ('509', 'fa-tty');
INSERT INTO `mtl_iconfont` VALUES ('510', 'fa-binoculars');
INSERT INTO `mtl_iconfont` VALUES ('511', 'fa-plug');
INSERT INTO `mtl_iconfont` VALUES ('512', 'fa-slideshare');
INSERT INTO `mtl_iconfont` VALUES ('513', 'fa-twitch');
INSERT INTO `mtl_iconfont` VALUES ('514', 'fa-yelp');
INSERT INTO `mtl_iconfont` VALUES ('515', 'fa-newspaper-o');
INSERT INTO `mtl_iconfont` VALUES ('516', 'fa-wifi');
INSERT INTO `mtl_iconfont` VALUES ('517', 'fa-calculator');
INSERT INTO `mtl_iconfont` VALUES ('518', 'fa-paypal');
INSERT INTO `mtl_iconfont` VALUES ('519', 'fa-google-wallet');
INSERT INTO `mtl_iconfont` VALUES ('520', 'fa-cc-visa');
INSERT INTO `mtl_iconfont` VALUES ('521', 'fa-cc-mastercard');
INSERT INTO `mtl_iconfont` VALUES ('522', 'fa-cc-discover');
INSERT INTO `mtl_iconfont` VALUES ('523', 'fa-cc-amex');
INSERT INTO `mtl_iconfont` VALUES ('524', 'fa-cc-paypal');
INSERT INTO `mtl_iconfont` VALUES ('525', 'fa-cc-stripe');
INSERT INTO `mtl_iconfont` VALUES ('526', 'fa-bell-slash');
INSERT INTO `mtl_iconfont` VALUES ('527', 'fa-bell-slash-o');
INSERT INTO `mtl_iconfont` VALUES ('528', 'fa-trash');
INSERT INTO `mtl_iconfont` VALUES ('529', 'fa-copyright');
INSERT INTO `mtl_iconfont` VALUES ('530', 'fa-at');
INSERT INTO `mtl_iconfont` VALUES ('531', 'fa-eyedropper');
INSERT INTO `mtl_iconfont` VALUES ('532', 'fa-paint-brush');
INSERT INTO `mtl_iconfont` VALUES ('533', 'fa-birthday-cake');
INSERT INTO `mtl_iconfont` VALUES ('534', 'fa-area-chart');
INSERT INTO `mtl_iconfont` VALUES ('535', 'fa-pie-chart');
INSERT INTO `mtl_iconfont` VALUES ('536', 'fa-line-chart');
INSERT INTO `mtl_iconfont` VALUES ('537', 'fa-lastfm');
INSERT INTO `mtl_iconfont` VALUES ('538', 'fa-lastfm-square');
INSERT INTO `mtl_iconfont` VALUES ('539', 'fa-toggle-off');
INSERT INTO `mtl_iconfont` VALUES ('540', 'fa-toggle-on');
INSERT INTO `mtl_iconfont` VALUES ('541', 'fa-bicycle');
INSERT INTO `mtl_iconfont` VALUES ('542', 'fa-bus');
INSERT INTO `mtl_iconfont` VALUES ('543', 'fa-ioxhost');
INSERT INTO `mtl_iconfont` VALUES ('544', 'fa-angellist');
INSERT INTO `mtl_iconfont` VALUES ('545', 'fa-cc');
INSERT INTO `mtl_iconfont` VALUES ('546', 'fa-shekel');
INSERT INTO `mtl_iconfont` VALUES ('547', 'fa-sheqel');
INSERT INTO `mtl_iconfont` VALUES ('548', 'fa-ils');
INSERT INTO `mtl_iconfont` VALUES ('549', 'fa-meanpath');

-- ----------------------------
-- Table structure for `mtl_member`
-- ----------------------------
DROP TABLE IF EXISTS `mtl_member`;
CREATE TABLE `mtl_member` (
  `member_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '会员编号',
  `agent_id` int(10) DEFAULT NULL COMMENT '代理商编号',
  `parent_id` int(10) DEFAULT '0' COMMENT '上级编号（店铺id或者是医院id）',
  `lv_id` int(8) DEFAULT '1' COMMENT '等级编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `regtime` datetime DEFAULT NULL COMMENT '注册时间',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` int(8) DEFAULT '0' COMMENT '性别（0男，1女）',
  `birthday` bigint(20) DEFAULT NULL COMMENT '生日',
  `advance` decimal(20,2) DEFAULT '0.00' COMMENT '预付款',
  `province_id` int(10) DEFAULT NULL COMMENT '省份编号',
  `city_id` int(10) DEFAULT NULL COMMENT '城市编号',
  `region_id` int(10) DEFAULT NULL COMMENT '地区编号',
  `town_id` int(10) DEFAULT NULL COMMENT '城镇编号',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `region` varchar(50) DEFAULT NULL COMMENT '地区',
  `town` varchar(50) DEFAULT NULL COMMENT '城镇',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `zip` varchar(50) DEFAULT NULL COMMENT '邮政编号',
  `mobile` varchar(50) DEFAULT NULL COMMENT '移动电话',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `balance` decimal(30,8) DEFAULT '0.00000000' COMMENT '余额',
  `mmc_money` decimal(30,8) DEFAULT '0.00000000' COMMENT 'mmc金额',
  `charge_money` decimal(30,8) DEFAULT '0.00000000' COMMENT '充值金额',
  `income_money` decimal(30,8) DEFAULT '0.00000000' COMMENT '总收入（红包+积分返利）',
  `consume_money` decimal(30,8) DEFAULT '0.00000000' COMMENT '消费金额',
  `point` int(10) DEFAULT '0' COMMENT '积分',
  `consume_point` int(10) DEFAULT '0' COMMENT '消费积分',
  `over_points` int(10) DEFAULT '0' COMMENT '剩余积分',
  `Pending_profit` decimal(30,8) DEFAULT '0.00000000' COMMENT '积分返利',
  `over_profit` decimal(30,8) DEFAULT '0.00000000' COMMENT '剩余mmc返利',
  `consume_profit` decimal(30,8) DEFAULT '0.00000000' COMMENT '消费积分mmc',
  `rebate` decimal(30,8) DEFAULT '0.00000000' COMMENT '已返利（捡红包）',
  `mp` int(10) DEFAULT '0' COMMENT '会员积分',
  `QQ` varchar(50) DEFAULT NULL COMMENT 'QQ账号',
  `msn` varchar(50) DEFAULT NULL COMMENT 'msn账号',
  `remark` longtext COMMENT '备注',
  `lastlogin` bigint(20) DEFAULT '1280629569' COMMENT '最后一次登录',
  `is_agent` int(8) DEFAULT '0' COMMENT '是否是代理商(0、没有 1、有）',
  `logincount` int(10) DEFAULT '0' COMMENT '登录次数',
  `is_checked` int(8) DEFAULT '0' COMMENT '是否审核',
  `registerip` varchar(255) DEFAULT NULL COMMENT '注册ip地址',
  `recommend_point_state` int(8) DEFAULT '0' COMMENT '推荐积分声明',
  `last_send_email` int(10) DEFAULT NULL COMMENT '最后一次寄出的邮件',
  `info_full` int(8) DEFAULT '0' COMMENT '完整信息',
  `find_code` varchar(255) DEFAULT NULL COMMENT '发现编码',
  `face` varchar(255) DEFAULT NULL COMMENT '脸(头像)',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `midentity` int(8) DEFAULT NULL COMMENT '中间实体',
  `disabled` smallint(1) DEFAULT '0' COMMENT '过期的',
  `avatar` varchar(255) DEFAULT NULL COMMENT '身份证图',
  `reason` varchar(255) DEFAULT NULL COMMENT '未审核原因',
  `member_fee` int(10) DEFAULT NULL COMMENT '会费',
  `real_name` varchar(25) DEFAULT NULL COMMENT '实名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `id_card` varchar(255) DEFAULT NULL COMMENT '身份证',
  `state` int(1) DEFAULT '0' COMMENT '0-启用（待审核）1-（审核通过）2-禁用 3-审核中4-审核不通过',
  `type` int(4) DEFAULT '0' COMMENT '0-注册会员、1-医院院长、2-医院操作员、3-医生、4-商家',
  `open_id` varchar(255) DEFAULT NULL COMMENT '微信openId',
  `over_money` decimal(30,8) DEFAULT '0.00000000' COMMENT '剩余金额',
  `valid_time` datetime DEFAULT NULL COMMENT '有效期',
  `parent_type` int(2) DEFAULT NULL COMMENT '推荐人类型（0-商家店铺，1-医院）',
  PRIMARY KEY (`member_id`),
  KEY `ind_member_uname` (`user_name`,`email`) USING BTREE,
  KEY `ind_member_lvid` (`lv_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=512 DEFAULT CHARSET=utf8 COMMENT='会员管理';

-- ----------------------------
-- Records of mtl_member
-- ----------------------------
INSERT INTO `mtl_member` VALUES ('1', '1', null, '2', '连明国', 'kingapex@163.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-05-18 00:00:00', 'kingapex', '1', '-1', '0.00', '-1', '-1', '2906', '-1', '', '', '', '', '', '', '13888888888', '', '26.06034000', '0.00000000', '0.00000000', '0.04000000', '0.00000000', '1', '0', '-2', '-0.96000000', '0.03960000', '-0.99960000', '-1.00000000', '0', '', '', '<p>wwww</p>', '1330404354', '0', '2', '3', '0:0:0:0:0:0:0:1', '0', '-1', '0', '', 'http://assets.mtlyn.com/FuQgATN8pKagfoIgwvB2LZEihpQC', 'kingapex', '0', '0', 'http://assets.mtlyn.com/FrJSAi0mYRXreLUgG0j3Mv-WuF_G', '非本人', '1', '哇哇哇哇', '2019-06-08 05:48:01', '530111199605010658', '1', '0', null, '26.06034000', null, null);
INSERT INTO `mtl_member` VALUES ('3', '1', '79', '3', 'alice', '145@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-04-02 00:00:00', 'alice', '1', '19950402', '0.00', '-1', '-1', '2821', '-1', '', '', '', '', '', '', '18787098169', '', '10012.85020055', '0.00000000', '0.00000000', '28.81000001', '5940.00000000', '49', '38', '-23', '713.00500000', '219.69515285', '493.07587418', '0.74000001', '55', '', '', 'aaa', '1551202846', '0', '13', '2', '0:0:0:0:0:0:0:1', '0', '-1', '0', '', 'http://assets.mtlyn.com/FuQgATN8pKagfoIgwvB2LZEihpQC', 'alice', '0', '0', 'http://assets.mtlyn.com/FrJSAi0mYRXreLUgG0j3Mv-WuF_G', '信息不对', '1', '', '2019-06-08 05:25:25', '', '3', '0', null, '94072.85020055', null, '0');
INSERT INTO `mtl_member` VALUES ('18', null, '78', '1', '测试7', '5787@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-07-23 10:57:28', null, '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13676754439', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '20', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '575803092', null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, '东方 i 说', null, null, '0', '0', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('91', null, '0', '1', 'dsad', '158@163.com', null, '2019-06-15 00:58:37', null, '1', null, '0.00', null, null, null, null, null, null, null, null, null, null, '15887261040', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '1', '-1', '0.00000000', '1000.00000000', '0.00000000', '0.00000000', '0', null, '21323', '', '1280629569', '0', '0', '3', null, '0', null, '0', null, 'http://assets.mtlyn.com/FuQgATN8pKagfoIgwvB2LZEihpQC', null, null, '0', null, null, '1', '无数的', '2019-06-15 00:58:37', '530111199605010658', '0', '0', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('92', null, '0', '2', '寒松', '18064852095@163.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-06-17 10:10:09', 'han', '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '18064852095', null, '0.00000000', '0.00000000', '0.00000000', '0.43000000', '4529.11400000', '980', '1', '749', '0.00000000', '0.00000000', '8628.88600000', '0.43000000', '0', null, null, null, '1280629569', '0', '0', '1', null, '0', null, '0', null, 'http://assets.mtlyn.com/Fv9tOvKfe0Y9JjZv1DPlH2FiK50x', null, null, '0', 'http://assets.mtlyn.com/FvYzPsPMkDNbfthI3OrAvTmOhXPs,http://assets.mtlyn.com/FpDfEjFSUmttdYBfaVvg27uq-mKZ', null, null, '韩松华', '2019-07-13 09:42:57', '530129199623232323', '3', '0', null, '6040.88600000', null, null);
INSERT INTO `mtl_member` VALUES ('116', null, '92', '1', '哈哈', null, 'e10adc3949ba59abbe56e057f20f883e', '2019-06-19 17:25:50', '哈哈', '1', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13700618467', null, '0.06000000', '10.00000000', '0.00000000', '0.38400000', '24.00000000', '48', '1', '17', '0.38400000', '0.38400000', '12.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, 'https://wx.qlogo.cn/mmopen/vi_32/y8nfXociavYkXF2zjZzLrFrj2GKBLGOA6v2qp1dRBJxXso5DTNZ7kZCFMeV5FCzZZYrXfsQM3CbLia533RbMgdZQ/132', '允执厥中', null, '0', null, null, '0', null, null, null, '1', '0', 'of-YN5Ov4UE2hOXL5_nVKAXKA8p8', '6.06000000', null, null);
INSERT INTO `mtl_member` VALUES ('120', null, '0', '1', '刘东', null, 'e10adc3949ba59abbe56e057f20f883e', '2019-06-22 16:41:44', null, '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13100000003', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '1', '-1', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '1', null, '0', null, '0', null, 'https://wx.qlogo.cn/mmhead/LtTxicECRdnnazjWOksAZoD8L41r1utOwHQ0phZT7v6w/132', '施怡雯', null, '0', 'http://assets.mtlyn.com/Fg79FoW06Nllqnjuww-c2dYIaPqO,http://assets.mtlyn.com/Fg79FoW06Nllqnjuww-c2dYIaPqO', 'null', '0', '啦啦啦', null, '511602199409298888', '1', '3', 'of-YN5KpQns8PKEXq_eIhsch6kqQ', '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('122', null, '0', '1', '13999999999', null, 'e10adc3949ba59abbe56e057f20f883e', '2019-07-10 14:21:31', null, '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13999999999', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, '2019-07-10 14:21:31', null, '1', '0', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('123', null, '0', '1', '13666666666', null, 'e10adc3949ba59abbe56e057f20f883e', '2019-07-10 14:22:57', null, '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13666666666', null, '10000.01000000', '0.00000000', '0.00000000', '0.77000000', '3788.00000000', '16', '0', '16', '0.72000000', '0.77000000', '0.00000000', '0.05000000', '0', null, null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, '2019-07-10 14:22:57', null, '1', '0', null, '6212.01000000', null, null);
INSERT INTO `mtl_member` VALUES ('124', null, '0', '1', '18388287335', null, null, '2019-07-10 14:53:23', null, '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '18388287335', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, '2019-07-10 14:53:23', null, '0', '0', null, '10000.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('125', null, '0', '1', '15912503624', null, null, '2019-07-10 15:35:56', null, '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '15912503624', null, '0.00000000', '0.00000000', '0.00000000', '0.56000001', '0.00000000', '0', '0', '0', '0.00000000', '0.56000001', '0.00000000', '0.56000001', '0', null, null, null, '1280629569', '0', '0', '1', null, '0', null, '0', null, null, null, null, '0', 'http://assets.mtlyn.com/FhYk6wCrd1l2Z803CNHMFw7UMCkO,http://assets.mtlyn.com/FsitD-hfS0dvQqrv09568jPKLJGn', null, null, '山瑞纳', '2019-07-10 15:35:56', '372928198809157246', '1', '0', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('136', null, '0', '3', '张三', null, 'e10adc3949ba59abbe56e057f20f883e', '2019-07-13 04:29:47', '张三', '2', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13900000000', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, 'http://assets.mtlyn.com/Fi8WR2tE7ykgqsfyCvweS7olIKbS', null, null, '0', 'http://assets.mtlyn.com/Fi8WR2tE7ykgqsfyCvweS7olIKbS', null, null, null, null, null, '0', '1', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('137', null, '0', '1', '13529333333', null, '7336c25b11821022306e6b6e356d022f', '2019-07-15 10:37:26', null, '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13529333333', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '1', null, '0', null, '0', null, null, null, null, '0', 'http://assets.mtlyn.com/FuGTvyzNWHy6zqHKk8oHuRp2qsTY,http://assets.mtlyn.com/FjRfq2cTbhqCPV4npUU_HxiMbRqg', null, null, '吴玉平', '2019-07-15 10:37:26', '350321197311156011', '1', '0', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('138', null, '0', '1', '13669713031', null, null, '2019-07-15 12:47:19', null, '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13669713031', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, '2019-07-15 12:47:19', null, '0', '0', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('498', null, '137', '1', '18987875257', null, null, '2019-07-17 09:58:35', null, '0', null, '0.00', null, null, null, null, null, null, null, null, null, null, '18987875257', null, '10.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '1', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, '2019-07-17 09:58:35', null, '0', '0', null, '10.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('499', '-1', '-1', '1', '测试', '1254425923@qq.com', '', '2019-07-21 15:59:53', null, '1', '-1', '0.00', '-1', '-1', '-1', '-1', '', '', '', '', '', '', '13527152548', '', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '254582568', '', '', '1280629569', '0', '0', '0', '', '0', '-1', '0', '', 'http://assets.mtlyn.com/FsBghLzutG8XGUPa-BGeCfF2rIwb', null, '-1', '0', '', '', null, '好好', '2019-07-26 10:08:40', '531120198602252526', '4', '3', null, '0.00000000', null, '-1');
INSERT INTO `mtl_member` VALUES ('500', '-1', null, '3', '测试2', '2546345@qq.com', '', '2019-07-21 16:31:41', null, '2', '-1', '0.00', '-1', '-1', '-1', '-1', '', '', '', '', '', '', '13595874215', '', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '', '', '', '1280629569', '0', '0', '0', '', '0', '-1', '0', '', '', null, '-1', '0', '', '', null, '饭饭', '2019-07-22 16:38:32', '', '0', '3', null, '0.00000000', null, '-1');
INSERT INTO `mtl_member` VALUES ('501', null, null, '1', '测试会员', '12548@qq.com', null, '2019-07-21 16:44:52', null, '2', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13825458547', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, '', '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, '2019-07-21 16:44:52', null, '0', '0', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('502', null, null, '2', '测试', '254@qq.com', null, '2019-07-22 10:54:52', null, '1', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13554872348', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, '', '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, '2019-07-22 10:54:52', null, '0', '0', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('503', null, null, '1', '测试4', '1515@qq.com', null, '2019-07-22 11:33:01', null, '2', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13525947589', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '1', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, '2019-07-22 11:33:01', null, '0', '0', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('504', '-1', null, '2', '测试3', '254@qq.com', '', '2019-07-22 11:35:46', null, '0', '-1', '0.00', '-1', '-1', '-1', '-1', '', '', '', '', '', '', '15875895248', '', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '', '', '', '1280629569', '0', '0', '0', '', '0', '-1', '0', '', '', null, '-1', '0', '', '', null, '得的', '2019-07-22 11:38:43', '', '0', '3', null, '0.00000000', null, '-1');
INSERT INTO `mtl_member` VALUES ('505', '-1', '86', '1', '测试5', '2356@qq.con', '', '2019-07-22 11:49:13', null, '1', '-1', '0.00', '-1', '-1', '-1', '-1', '', '', '', '', '', '', '13595871254', '', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '125485', 'cdac', '', '1280629569', '0', '0', '0', '', '0', '-1', '0', '', '', null, '-1', '0', '', '', null, '对对对', '2019-07-24 17:29:13', '515455187602032415', '1', '3', null, '0.00000000', null, '-1');
INSERT INTO `mtl_member` VALUES ('506', '-1', '0', '3', '测试6', '265@qq.com', '', '2019-07-22 11:56:42', null, '1', '-1', '0.00', '-1', '-1', '-1', '-1', '', '', '', '', '', '', '13598741258', '', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '', '', '', '1280629569', '0', '0', '0', '', '0', '-1', '0', '', '', null, '-1', '0', '', '', null, '', '2019-07-22 11:56:52', '', '0', '3', null, '0.00000000', null, '-1');
INSERT INTO `mtl_member` VALUES ('508', null, '0', '3', '测试测试', '125@qq.com', null, '2019-07-24 17:34:17', null, '1', null, '0.00', null, null, null, null, null, null, null, null, null, null, '13587892584', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '222254', null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, '2019-07-24 17:34:17', null, '0', '3', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('509', '-1', '0', '1', '测试名医', '2545@qq.com', '123456', '2019-07-26 11:04:58', '测试名医', '0', '-1', '0.00', '-1', '-1', '-1', '-1', '', '', '', '', '北京市 市辖区 东城区 测试路', '', '18388287335', '', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '', '', '', '1280629569', '0', '0', '0', '', '0', '-1', '0', '', '', null, '-1', '0', '', '', null, '', '2019-07-26 09:54:48', '', '1', '3', null, '0.00000000', null, '-1');
INSERT INTO `mtl_member` VALUES ('510', null, '0', '1', '测试普通医生', null, '123456', '2019-07-26 16:43:15', '测试普通医生', '0', null, '0.00', null, null, null, null, null, null, null, null, '北京市 市辖区 东城区 测试路', null, '18388287333', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, 'null', null, null, null, null, '1', '3', null, '0.00000000', null, null);
INSERT INTO `mtl_member` VALUES ('511', null, '0', '1', null, null, '123456', '2019-07-26 10:53:11', '王贵', '1', null, '0.00', null, null, null, null, null, null, null, null, '云南省 昆明市 五华区 西站16', null, '13344556673', null, '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', '0', '0', '0.00000000', '0.00000000', '0.00000000', '0.00000000', '0', null, null, null, '1280629569', '0', '0', '0', null, '0', null, '0', null, null, null, null, '0', null, null, null, null, null, null, '1', '3', null, '0.00000000', null, null);

-- ----------------------------
-- Table structure for `mtl_menu`
-- ----------------------------
DROP TABLE IF EXISTS `mtl_menu`;
CREATE TABLE `mtl_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `sorder` int(11) DEFAULT '50',
  `type` int(11) DEFAULT NULL COMMENT '菜单类型',
  `datatype` varchar(50) DEFAULT NULL,
  `checked` int(6) DEFAULT '0' COMMENT '选中标识',
  `deleteflag` int(6) DEFAULT '0',
  `canexp` int(6) DEFAULT '0',
  `icon` varchar(255) DEFAULT NULL,
  `icon_hover` varchar(255) DEFAULT NULL,
  `is_display` int(6) DEFAULT '0',
  `permission` varchar(255) DEFAULT NULL COMMENT '主url',
  `menu_buttons` longtext COMMENT '功能权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of mtl_menu
-- ----------------------------
INSERT INTO `mtl_menu` VALUES ('124', '0', '系统管理', 'system', '1', '0', '', '0', '0', '0', 'fa fa-th-large fa-lg', '', '0', null, null);
INSERT INTO `mtl_menu` VALUES ('125', '124', '菜单管理', 'system/menu', '50', '1', '', '0', '0', '0', 'fa fa-sitemap fa-lg', '', '0', '/admin/menu', '[{\"iconname\":\"查询全部\",\"iconpermission\":\"/page\"},{\"iconname\":\"查询单条\",\"iconpermission\":\"/detail\"},{\"iconname\":\"新增\",\"iconpermission\":\"/saveOrUpdate\"},{\"iconname\":\"删除\",\"iconpermission\":\"/delete\"},{\"iconname\":\"根据权限查询菜单\",\"iconpermission\":\"/MenuTreeByRole\",\"type\":2,\"checked\":false},{\"iconname\":\"查询左侧菜单\",\"iconpermission\":\"/tree\",\"type\":2,\"checked\":false},{\"iconname\":\"图标\",\"iconpermission\":\"/iconfont/page\",\"type\":2,\"checked\":false}]');
INSERT INTO `mtl_menu` VALUES ('126', '124', '用户管理', 'system/user', '50', '1', '', '0', '0', '0', 'fa fa-user-md fa-lg', '', '0', '/admin/adminuser', '[{\"iconname\":\"查询全部\",\"iconpermission\":\"/page\"},{\"iconname\":\"查询单条\",\"iconpermission\":\"/detail\"},{\"iconname\":\"新增\",\"iconpermission\":\"/submit\"},{\"iconname\":\"修改\",\"iconpermission\":\"/submit\"},{\"iconname\":\"删除\",\"iconpermission\":\"/remove\"},{\"iconname\":\"登录用户\",\"iconpermission\":\"/info\",\"type\":2,\"checked\":false}]');
INSERT INTO `mtl_menu` VALUES ('183', '124', '字典管理', 'system/dict', '3', '1', '', '-1', '0', '-1', 'fa fa-book fa-lg', '', '0', '/admin/dict', '[{\"iconname\":\"查询全部\",\"iconpermission\":\"/list\"},{\"iconname\":\"查询单条\",\"iconpermission\":\"/detail\"},{\"iconname\":\"新增\",\"iconpermission\":\"/submit\"},{\"iconname\":\"修改\",\"iconpermission\":\"/submit\"},{\"iconname\":\"删除\",\"iconpermission\":\"/remove\"}]');
INSERT INTO `mtl_menu` VALUES ('195', '124', '区域管理', 'system/regions', '-1', '1', '', '-1', '0', '-1', 'fa fa-th-large fa-lg', '', '0', '/admin/regions', '[{\"iconname\":\"查询全部\",\"iconpermission\":\"/page\"},{\"iconname\":\"查询单条\",\"iconpermission\":\"/detail\"},{\"iconname\":\"新增或修改\",\"iconpermission\":\"/submit\"},{\"iconname\":\"用户区域树\",\"iconpermission\":\"/tree\"},{\"iconname\":\"删除\",\"iconpermission\":\"/remove\"},{\"iconname\":\"删除1\",\"iconpermission\":\"/delete\",\"type\":2,\"checked\":false},{\"iconname\":\"删除管理区域\",\"iconpermission\":\"/deleteRegions\",\"type\":2,\"checked\":false},{\"iconname\":\"新增或者修改\",\"iconpermission\":\"/saveOrUpdate\",\"type\":2,\"checked\":false}]');
INSERT INTO `mtl_menu` VALUES ('196', '124', '角色管理', 'system/role', '-1', '1', '', '-1', '0', '-1', 'fa fa-key fa-lg', '', '0', '/admin/role', '[{\"iconname\":\"查询全部\",\"iconpermission\":\"/page\"},{\"iconname\":\"查询单条\",\"iconpermission\":\"/detail\"},{\"iconname\":\"删除\",\"iconpermission\":\"/remove\"},{\"iconname\":\"修改保存\",\"iconpermission\":\"/submit\",\"type\":2,\"checked\":false}]');

-- ----------------------------
-- Table structure for `mtl_regions`
-- ----------------------------
DROP TABLE IF EXISTS `mtl_regions`;
CREATE TABLE `mtl_regions` (
  `region_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '区域id',
  `p_region_id` int(10) DEFAULT NULL COMMENT '父级区域id',
  `region_path` varchar(255) DEFAULT NULL COMMENT '区域路径',
  `region_grade` int(8) DEFAULT NULL COMMENT '区域等级',
  `local_name` varchar(100) NOT NULL COMMENT '本地名称',
  `zipcode` varchar(20) DEFAULT NULL COMMENT '邮编',
  `admin_user_id` int(11) DEFAULT NULL COMMENT '区域负责人id',
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mtl_regions
-- ----------------------------
INSERT INTO `mtl_regions` VALUES ('1', '0', ',1,', '1', '北京', '111', null);
INSERT INTO `mtl_regions` VALUES ('2', '0', ',2,', '1', '上海', '', '1');
INSERT INTO `mtl_regions` VALUES ('78', '2', ',2,78,', '2', '黄浦区', null, '1');
INSERT INTO `mtl_regions` VALUES ('452', '34', ',1,34,452,', '3', '燕郊', '101601', '1');
INSERT INTO `mtl_regions` VALUES ('967', '965', ',12,965,967,', '3', '通州区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2799', '72', ',1,72,2799,', '3', '三环以内', null, '1');
INSERT INTO `mtl_regions` VALUES ('2800', '1', ',1,2800,', '2', '海淀区', '', null);
INSERT INTO `mtl_regions` VALUES ('2801', '1', ',1,2801,', '2', '西城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2802', '1', ',1,2802,', '2', '东城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2803', '1', ',1,2803,', '2', '崇文区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2804', '1', ',1,2804,', '2', '宣武区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2805', '1', ',1,2805,', '2', '丰台区', '', '1');
INSERT INTO `mtl_regions` VALUES ('2806', '1', ',1,2806,', '2', '石景山区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2807', '1', ',1,2807,', '2', '门头沟', null, '1');
INSERT INTO `mtl_regions` VALUES ('2808', '1', ',1,2808,', '2', '房山区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2810', '1', ',1,2810,', '2', '大兴区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2812', '1', ',1,2812,', '2', '顺义区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2813', '2', ',2,2813,', '2', '徐汇区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2814', '1', ',1,2814,', '2', '怀柔区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2815', '2', ',2,2815,', '2', '长宁区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2816', '1', ',1,2816,', '2', '密云区', '', '1');
INSERT INTO `mtl_regions` VALUES ('2817', '2', ',2,2817,', '2', '静安区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2820', '2', ',2,2820,', '2', '闸北区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2821', '2802', ',1,2802,2821,', '3', '内环到三环里', null, '1');
INSERT INTO `mtl_regions` VALUES ('2822', '2', ',2,2822,', '2', '虹口区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2823', '2', ',2,2823,', '2', '杨浦区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2825', '2', ',2,2825,', '2', '闵行区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2826', '2', ',2,2826,', '2', '嘉定区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2827', '2801', ',1,2801,2827,', '3', '内环到二环里', null, null);
INSERT INTO `mtl_regions` VALUES ('2828', '2804', ',1,2804,2828,', '3', '内环到三环里', null, '1');
INSERT INTO `mtl_regions` VALUES ('2829', '2803', ',1,2803,2829,', '3', '一环到二环', null, '1');
INSERT INTO `mtl_regions` VALUES ('2830', '2', ',2,2830,', '2', '浦东新区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2831', '2806', ',1,2806,2831,', '3', '四环到五环内', null, '1');
INSERT INTO `mtl_regions` VALUES ('2832', '2805', ',1,2805,2832,', '3', '四环到五环之间', null, '1');
INSERT INTO `mtl_regions` VALUES ('2833', '2', ',2,2833,', '2', '青浦区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2834', '2', ',2,2834,', '2', '松江区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2835', '2', ',2,2835,', '2', '金山区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2837', '2', ',2,2837,', '2', '奉贤区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2841', '2', ',2,2841,', '2', '普陀区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2848', '2800', ',1,2800,2848,', '3', '三环以内', null, '1');
INSERT INTO `mtl_regions` VALUES ('2862', '2816', ',1,2816,2862,', '3', '城区以外', '', '1');
INSERT INTO `mtl_regions` VALUES ('2901', '1', ',1,2901,', '2', '昌平区', null, '1');
INSERT INTO `mtl_regions` VALUES ('2906', '2901', ',1,2901,2906,', '3', '城区以外', null, '1');
INSERT INTO `mtl_regions` VALUES ('2919', '2', ',2,2919,', '2', '崇明县', null, '1');
INSERT INTO `mtl_regions` VALUES ('2953', '1', ',1,2953,', '2', '平谷区', null, '1');
INSERT INTO `mtl_regions` VALUES ('3065', '1', ',1,3065,', '2', '延庆县', null, '1');
INSERT INTO `mtl_regions` VALUES ('3343', '731', ',10,731,3343,', '3', '宝山区', null, '1');
INSERT INTO `mtl_regions` VALUES ('4194', '2810', ',1,2810,4194,', '3', '四环至五环之间', null, '1');
INSERT INTO `mtl_regions` VALUES ('6115', '2814', ',1,2814,6115,', '3', '城区以内', null, '1');
INSERT INTO `mtl_regions` VALUES ('6666', '2953', ',1,2953,6666,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('6667', '2816', ',1,2816,6667,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('33993', '785', ',10,782,785,33993,', '4', '朝阳区', null, '1');
INSERT INTO `mtl_regions` VALUES ('49707', '274', ',5,274,49707,', '3', '三河市', '', '1');
INSERT INTO `mtl_regions` VALUES ('50779', '2919', ',2,2919,50779,', '3', '堡镇', null, '1');
INSERT INTO `mtl_regions` VALUES ('51125', '2812', ',1,2812,51125,', '3', '北石槽镇', null, '1');
INSERT INTO `mtl_regions` VALUES ('51216', '2809', ',1,2809,51216,', '3', '六环内（马驹桥镇）', null, '1');
INSERT INTO `mtl_regions` VALUES ('51505', '3065', ',1,3065,51505,', '3', '延庆镇', null, '1');
INSERT INTO `mtl_regions` VALUES ('51528', '2808', ',1,2808,51528,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51552', '2807', ',1,2807,51552,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51800', '2830', ',2,2830,51800,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51911', '2824', ',2,2824,51911,', '3', '罗店镇', '', '1');
INSERT INTO `mtl_regions` VALUES ('51928', '2837', ',2,2837,51928,', '3', '南桥镇', null, '1');
INSERT INTO `mtl_regions` VALUES ('51931', '2825', ',2,2825,51931,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51941', '2826', ',2,2826,51941,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51959', '2833', ',2,2833,51959,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51960', '2835', ',2,2835,51960,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51972', '2820', ',2,2820,51972,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51973', '2817', ',2,2817,51973,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51974', '2823', ',2,2823,51974,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51975', '2815', ',2,2815,51975,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51976', '2813', ',2,2813,51976,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51978', '78', ',2,78,51978,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51979', '2822', ',2,2822,51979,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51980', '2841', ',2,2841,51980,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('51982', '2834', ',2,2834,51982,', '3', '城区', null, '1');
INSERT INTO `mtl_regions` VALUES ('52007', '452', ',1,34,452,52007,', '-1', 'aa', '', '-1');

-- ----------------------------
-- Table structure for `mtl_role`
-- ----------------------------
DROP TABLE IF EXISTS `mtl_role`;
CREATE TABLE `mtl_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `regions_id` varchar(255) DEFAULT NULL COMMENT '所属区域id',
  `auth_action` longtext COMMENT '权限',
  `auth_url` longtext COMMENT 'url',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of mtl_role
-- ----------------------------
INSERT INTO `mtl_role` VALUES ('1', '超级管理员', '1', '[{\"parentId\":124,\"menu\":[{\"id\":125,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"删除\",\"根据权限查询菜单\",\"查询左侧菜单\",\"图标\"]},{\"id\":126,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\",\"登录用户\"]},{\"id\":183,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":195,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增或修改\",\"用户区域树\",\"删除\",\"删除1\",\"删除管理区域\",\"新增或者修改\"]},{\"id\":196,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"删除\",\"修改保存\"]},{\"id\":219,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]}]},{\"parentId\":127,\"menu\":[{\"id\":208,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\",\"商品下品牌查询\"]},{\"id\":210,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":211,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\",\"分类菜单\",\"标准\"]},{\"id\":213,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增或修改\",\"新增或修改\",\"删除\",\"获取商品类别\",\"所有分类\"]},{\"id\":235,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\",\"查询全部\",\"积分产品全部\"]},{\"id\":236,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\",\"查询产地\",\"新增或修改\"]},{\"id\":237,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":255,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]}]},{\"parentId\":129,\"menu\":[{\"id\":214,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":215,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\",\"模糊查询\"]},{\"id\":216,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\",\"查询等级\",\"查询代理商\"]},{\"id\":217,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":229,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":245,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":256,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]}]}]', '/admin/menu/tree,/admin/adminuser/info,/admin/menu/page,/admin/menu/detail,/admin/menu/saveOrUpdate,/admin/menu/delete,/admin/menu/MenuTreeByRole,/admin/menu/tree,/admin/menu/iconfont/page,/admin/adminuser/page,/admin/adminuser/detail,/admin/adminuser/submit,/admin/adminuser/submit,/admin/adminuser/remove,/admin/adminuser/info,/admin/dict/list,/admin/dict/detail,/admin/dict/submit,/admin/dict/submit,/admin/dict/remove,/admin/regions/page,/admin/regions/detail,/admin/regions/submit,/admin/regions/tree,/admin/regions/remove,/admin/regions/delete,/admin/regions/deleteRegions,/admin/regions/saveOrUpdate,/admin/role/page,/admin/role/detail,/admin/role/remove,/admin/role/submit,/admin/logicompany/page,/admin/logicompany/detail,/admin/logicompany/submit,/admin/logicompany/submit,/admin/logicompany/remove,/admin/brand/page,/admin/brand/detail,/admin/brand/submit,/admin/brand/submit,/admin/brand/remove,/admin/brand/listBrand,/admin/goods/page,/admin/goods/detail,/admin/goods/submit,/admin/goods/submit,/admin/goods/remove,/admin/specification/page,/admin/specification/detail,/admin/specification/submit,/admin/specification/submit,/admin/specification/remove,/admin/specification/getCatMenu,/admin/specification/getNorm,/admin/productCat/page,/admin/productCat/detail,/admin/productCat/submitVo,/admin/productCat/submit,/admin/productCat/submitVo,/admin/productCat/submit,/admin/productCat/remove,/admin/productCat/getCatmenu,/admin/productCat/catlist,/admin/Pointgoods/page,/admin/Pointgoods/searchPage,/admin/Pointgoods/detail,/admin/Pointgoods/submit,/admin/Pointgoods/submit,/admin/Pointgoods/remove,/admin/Pointgoods/page,/admin/Pointgoods/searchPage,/admin/Pointgoods/selPointProduct,/admin/salegoods/page,/admin/salegoods/detail,/admin/salegoods/submit,/admin/salegoods/submit,/admin/salegoods/remove,/admin/salegoods/selSaleProduct,/admin/salegoods/manySubmit,/admin/goodsproperty/page,/admin/goodsproperty/detail,/admin/goodsproperty/submit,/admin/goodsproperty/submit,/admin/goodsproperty/remove,/admin/goodsRate/page,/admin/goodsRate/detail,/admin/goodsRate/submit,/admin/goodsRate/submit,/admin/goodsRate/remove,/admin/membercomment/page,/admin/membercomment/detail,/admin/membercomment/submit,/admin/membercomment/submit,/admin/membercomment/remove,/admin/memberlv/page,/admin/memberlv/detail,/admin/memberlv/submit,/admin/memberlv/submit,/admin/memberlv/remove,/admin/memberlv/fuzzy,/admin/member/page,/admin/member/detail,/admin/member/submit,/admin/member/submit,/admin/member/remove,/admin/member/findAllLv,/admin/member/findAgent,/page,/detail,/submit,/submit,/remove,/page,/detail,/submit,/submit,/remove,/page,/detail,/submit,/submit,/remove,/page,/detail,/submit,/submit,/remove');
INSERT INTO `mtl_role` VALUES ('2', '产品部', '2800', '[{\"parentId\":124,\"menu\":[{\"id\":125,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":126,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":183,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":195,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":196,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":219,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]}]}]', null);
INSERT INTO `mtl_role` VALUES ('3', '库管', '2800', '[]', '');
INSERT INTO `mtl_role` VALUES ('4', '财务部', '2800', '[{\"parentId\":124,\"menu\":[{\"id\":125,\"selectedbutton\":[\"查询全部\",\"查询单条\"]},{\"id\":126,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]},{\"id\":183,\"selectedbutton\":[\"查询全部\",\"查询单条\",\"新增\",\"修改\",\"删除\"]}]}]', '');
INSERT INTO `mtl_role` VALUES ('5', '客服', '2800', null, null);
