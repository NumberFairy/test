/*
Navicat MySQL Data Transfer

Source Server         : ERP
Source Server Version : 50173
Source Host           : 192.168.163.50:3306
Source Database       : ERP

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-03-08 17:09:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for FLOW_BASE
-- ----------------------------
DROP TABLE IF EXISTS `FLOW_BASE`;
CREATE TABLE `FLOW_BASE` (
  `ID` varchar(36) NOT NULL,
  `APPLY_ID` varchar(36) DEFAULT NULL COMMENT '申请编号，即表单id',
  `APLLY_PERSON_ID` varchar(36) DEFAULT NULL COMMENT '申请人id',
  `APLLY_PERSON_NAME` varchar(36) DEFAULT NULL COMMENT '申请人姓名',
  `AUDITOR_ID` varchar(36) DEFAULT NULL COMMENT '审核人id',
  `AUDITOR_NAME` varchar(36) DEFAULT NULL COMMENT '审核人姓名',
  `AUDIT_TIME` datetime DEFAULT NULL COMMENT '审核时间',
  `AUDIT_RESULT` int(1) DEFAULT NULL COMMENT '审核结果',
  `AUDIT_MSG` varchar(255) DEFAULT NULL COMMENT '审核消息',
  `FLOW_STEP` int(2) DEFAULT NULL COMMENT '步骤',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程基本表';
