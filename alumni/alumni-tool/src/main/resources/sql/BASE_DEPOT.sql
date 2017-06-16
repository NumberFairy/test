/*
Navicat MySQL Data Transfer

Source Server         : TWERP
Source Server Version : 50173
Source Host           : 192.168.163.50:3306
Source Database       : ERP

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-02-28 15:36:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for BASE_DEPOT
-- ----------------------------
DROP TABLE IF EXISTS `BASE_DEPOT`;
CREATE TABLE `BASE_DEPOT` (
  `ID` varchar(36) NOT NULL,
  `DEPOT_CODE` varchar(36) DEFAULT NULL COMMENT '库房编号',
  `TYPE` varchar(36) DEFAULT NULL COMMENT '库房类型',
  `NAME` varchar(100) DEFAULT NULL COMMENT '库房名称',
  `ENGLISH_NAME` varchar(100) DEFAULT NULL COMMENT '库房英文名称',
  `LOCATION` longtext COMMENT '物理位置',
  `BUIT_IN` int(11) DEFAULT NULL COMMENT '是否内置库房0：否1：是',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE` datetime DEFAULT NULL COMMENT '更新时间',
  `RE_VARCHAR_0` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_0',
  `RE_VARCHAR_1` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_1',
  `RE_VARCHAR_2` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_2',
  `RE_VARCHAR_3` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_3',
  `RE_VARCHAR_4` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_4',
  `RE_VARCHAR_5` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_5',
  `RE_VARCHAR_6` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_6',
  `RE_VARCHAR_7` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_7',
  `RE_VARCHAR_8` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_8',
  `RE_VARCHAR_9` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_9',
  `RE_VARCHAR_10` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_10',
  `RE_VARCHAR_11` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_11',
  `RE_VARCHAR_12` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_12',
  `RE_VARCHAR_13` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_13',
  `RE_VARCHAR_14` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_14',
  `RE_VARCHAR_15` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_15',
  `RE_VARCHAR_16` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_16',
  `RE_VARCHAR_17` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_17',
  `RE_VARCHAR_18` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_18',
  `RE_VARCHAR_19` varchar(255) DEFAULT NULL COMMENT 'RE_VARCHAR_19',
  `RE_INT_0` int(11) DEFAULT NULL COMMENT 'RE_INT_0',
  `RE_INT_1` int(11) DEFAULT NULL COMMENT 'RE_INT_1',
  `RE_INT_2` int(11) DEFAULT NULL COMMENT 'RE_INT_2',
  `RE_INT_3` int(11) DEFAULT NULL COMMENT 'RE_INT_3',
  `RE_INT_4` int(11) DEFAULT NULL COMMENT 'RE_INT_4',
  `RE_DOUBLE_0` double(8,2) DEFAULT NULL COMMENT 'RE_DOUBLE_0',
  `RE_DOUBLE_1` double(8,2) DEFAULT NULL COMMENT 'RE_DOUBLE_1',
  `RE_DOUBLE_2` double(8,2) DEFAULT NULL COMMENT 'RE_DOUBLE_2',
  `RE_DOUBLE_3` double(8,2) DEFAULT NULL COMMENT 'RE_DOUBLE_3',
  `RE_DOUBLE_4` double(8,2) DEFAULT NULL COMMENT 'RE_DOUBLE_4',
  `RE_DATE_0` date DEFAULT NULL COMMENT 'RE_DATE_0',
  `RE_DATE_1` date DEFAULT NULL COMMENT 'RE_DATE_1',
  `RE_DATE_2` date DEFAULT NULL COMMENT 'RE_DATE_2',
  `RE_DATE_3` date DEFAULT NULL COMMENT 'RE_DATE_3',
  `RE_DATE_4` date DEFAULT NULL COMMENT 'RE_DATE_4',
  `RE_DATETIME_0` datetime DEFAULT NULL COMMENT 'RE_DATETIME_0',
  `RE_DATETIME_1` datetime DEFAULT NULL COMMENT 'RE_DATETIME_1',
  `RE_DATETIME_2` datetime DEFAULT NULL COMMENT 'RE_DATETIME_2',
  `RE_DATETIME_3` datetime DEFAULT NULL COMMENT 'RE_DATETIME_3',
  `RE_DATETIME_4` datetime DEFAULT NULL COMMENT 'RE_DATETIME_4',
  `RE_LONGTEXT_0` longtext COMMENT 'RE_LONGTEXT_0',
  `RE_LONGTEXT_1` longtext COMMENT 'RE_LONGTEXT_1',
  `RE_LONGTEXT_2` longtext COMMENT 'RE_LONGTEXT_2',
  `RE_LONGTEXT_3` longtext COMMENT 'RE_LONGTEXT_3',
  `RE_LONGTEXT_4` longtext COMMENT 'RE_LONGTEXT_4',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房类型表';

-- ----------------------------
-- Records of BASE_DEPOT
-- ----------------------------
INSERT INTO `BASE_DEPOT` VALUES ('1', '1', '1', '原材料', 'material', '', '1', '2017-02-24 18:08:19', '2017-02-24 18:08:22', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `BASE_DEPOT` VALUES ('2', '2', '2', '半成品', 'semi-product', '', '1', '2017-02-24 00:00:00', '2017-02-28 11:09:59', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `BASE_DEPOT` VALUES ('3', '3', '3', '成品库', 'product', '', '1', '2017-02-17 00:00:00', '2017-02-17 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `BASE_DEPOT` VALUES ('4', '4', '4', '临时库', 'temp', '', '1', '2017-02-17 00:00:00', '2017-02-17 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `BASE_DEPOT` VALUES ('5', '5', '4', '维修库', 'repair', '', '1', '2017-02-17 00:00:00', '2017-02-17 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `BASE_DEPOT` VALUES ('6', '6', '4', '消耗库', 'loss', '', '1', '2017-02-17 00:00:00', '2017-02-17 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `BASE_DEPOT` VALUES ('7', '7', '4', '样品库', 'sample', '', '1', '2017-02-24 18:08:54', '2017-02-24 18:08:56', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `BASE_DEPOT` VALUES ('8', '8', '4', '其他', 'other', null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
