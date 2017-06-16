/*
Navicat MySQL Data Transfer

Source Server         : ERP
Source Server Version : 50173
Source Host           : 192.168.163.50:3306
Source Database       : ERP

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-03-08 17:18:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for FLOW_ACTIVE
-- ----------------------------
DROP TABLE IF EXISTS `FLOW_ACTIVE`;
CREATE TABLE `FLOW_ACTIVE` (
  `ID` varchar(36) NOT NULL,
  `APPLY_ID` varchar(36) DEFAULT NULL COMMENT '申请编号，即表单id',
  `APLLY_PERSON_ID` varchar(36) DEFAULT NULL COMMENT '申请人id',
  `APLLY_PERSON_NAME` varchar(36) DEFAULT NULL COMMENT '申请人姓名',
  `CURRENT_AUDITOR_ID` varchar(36) DEFAULT NULL COMMENT '当前审核人id',
  `CURRENT_AUDITOR_NAME` varchar(36) DEFAULT NULL COMMENT '当前审核人姓名',
  `FLOW_STEP` int(2) DEFAULT NULL COMMENT '步骤',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动流程';
