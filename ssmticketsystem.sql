/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : ssmticketsystem

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-05-01 20:05:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ts_menu
-- ----------------------------
DROP TABLE IF EXISTS `ts_menu`;
CREATE TABLE `ts_menu` (
  `menuid` int(10) NOT NULL AUTO_INCREMENT,
  `admin` int(1) DEFAULT NULL,
  `menuname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `menuurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parentid` int(10) DEFAULT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_menu
-- ----------------------------
INSERT INTO `ts_menu` VALUES ('1', '1', '用户管理', null, '0');
INSERT INTO `ts_menu` VALUES ('2', '1', '系统管理', null, '0');
INSERT INTO `ts_menu` VALUES ('3', '0', '个人中心', null, '0');
INSERT INTO `ts_menu` VALUES ('4', '0', '票务管理', null, '0');
INSERT INTO `ts_menu` VALUES ('5', '1', '票务管理', null, '0');
INSERT INTO `ts_menu` VALUES ('11', '1', '首页', '/index.jsp', '1');
INSERT INTO `ts_menu` VALUES ('12', '1', '个人信息', '/ssmTicketSystem/pages/user/userinfo.jsp', '1');
INSERT INTO `ts_menu` VALUES ('13', '1', '用户信息', '/ssmTicketSystem/pages/user/alluserinfo.jsp', '1');
INSERT INTO `ts_menu` VALUES ('21', '1', '公告管理', '/ssmTicketSystem/pages/notice/notice.jsp', '2');
INSERT INTO `ts_menu` VALUES ('22', '1', '列车管理', '/ssmTicketSystem/pages/train/traininfo.jsp', '2');
INSERT INTO `ts_menu` VALUES ('23', '1', '始终站管理', '/ssmTicketSystem/pages/station/station.jsp', '2');
INSERT INTO `ts_menu` VALUES ('24', '1', '座位管理', '/ssmTicketSystem/pages/train/seatinfo.jsp', '2');
INSERT INTO `ts_menu` VALUES ('31', '0', '首页', '/index.jsp', '3');
INSERT INTO `ts_menu` VALUES ('32', '0', '用户信息', '/ssmTicketSystem/pages/user/userinfo.jsp', '3');
INSERT INTO `ts_menu` VALUES ('33', '0', '用户', 'html/page02.html', '3');
INSERT INTO `ts_menu` VALUES ('41', '0', '公告管理', '/ssmTicketSystem/pages/notice/notice.jsp', '4');
INSERT INTO `ts_menu` VALUES ('42', '0', '指标库列表', 'html/page02.html', '4');
INSERT INTO `ts_menu` VALUES ('51', '1', '车票管理', '/ssmTicketSystem/pages/ticket/adminticket.jsp', '5');

-- ----------------------------
-- Table structure for ts_notice
-- ----------------------------
DROP TABLE IF EXISTS `ts_notice`;
CREATE TABLE `ts_notice` (
  `noticeid` int(10) NOT NULL AUTO_INCREMENT,
  `noticetitle` varchar(50) DEFAULT NULL,
  `noticetext` text,
  `noticetime` date DEFAULT NULL,
  PRIMARY KEY (`noticeid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_notice
-- ----------------------------
INSERT INTO `ts_notice` VALUES ('1', '关于优化电子客票退票流程的公告', '为适应疫情防控需要，回应广大旅客诉愿，提升旅客购票体验，铁路部门决定，自2月28日起，12306网站（含手机客户端，下同）在原退票业务办理的基础上，增加现金购买或已领取报销凭证的有效电子客票办理退票业务。 <br/>　　旅客可通过12306网站查询相关购票订单信息，在开车前根据需要完成退票后（具体办理流程按网站提示操作），于退票之日起180天内（含当日），持购票时使用的乘车人身份证件原件前往任一铁路车站窗口办理退款手续，票款为现金支付的，退款仍为现金；票款为电子支付的，退至旅客购票时使用的支付账户；已领取的报销凭证需一并交回。请各位旅客妥善保管报销凭证，如有遗失、污损、票面不完整等情况，车站将无法返款。如旅客换取了票面不具有“仅供报销使用”字样的纸质车票，暂不能在网上办理退票。 <br/>　　根据现行退票费率规则，自旅客网上办理退票完成时间至乘车站开车时间计算核收退票手续费。符合疫情期间全额退票要求或其他相关条件的，免收退票手续费。', '2020-03-14');
INSERT INTO `ts_notice` VALUES ('2', '铁路部门再次调整免费退票措施', '为加强新型冠状病毒感染的肺炎疫情防控工作，配合各地2月10日前灵活安排工作的措施，进一步方便旅客办理退票，中国国家铁路集团有限公司决定，自2020年2月6日0时起，此前在车站、12306网站等各渠道已购买的全国铁路火车票，旅客在开车前自愿改变行程需退票的，铁路部门均不收取退票手续费，购买铁路乘意险的一同办理。 <br/>　　对无法在网上办理退票的旅客，铁路部门继续推出延长退票时限的服务措施。凡是于2月5日24时前使用现金购票或已于2月5日24时前换取纸质车票（含报销凭证）的旅客，如开车前无法到车站办理退票的，可延期至3月31日24时前办理退票；凡是火车票票面发站所在地车站进站通道关闭的，在进站通道恢复之日起30日内均可办理退票；退票须在购票地或出发地各车站办理，办理时继续免收退票费，铁路乘意险一同办理。 <br/>　　因各地学校开学时间不同，为方便学生旅客退票，铁路部门已于1月27日起，在办理学生票退票时均不收取退票手续费，购买铁路乘意险的一同办理。', '2020-01-17');
INSERT INTO `ts_notice` VALUES ('3', '铁路部门再出免费退票措施', '为落实国务院2020年春节假期延长安排，中国国家铁路集团有限公司决定，自2020年1月28日0时起，此前在车站、12306网站等各渠道，已购买的全国铁路火车票，旅客自愿改变行程需退票的，铁路部门均不收取退票手续费，购买铁路乘意险的一同办理。 <br/>　　因各地学校开学时间不同，从即时起，办理学生票退票时均不收取退票手续费，购买铁路乘意险的一同办理。 <br/>　　由于假期调整，铁路部门将及时调增热门方向和学生返校运力，满足旅客出行需要。', '2020-02-27');
INSERT INTO `ts_notice` VALUES ('4', '中国铁路广州局集团有限公司关于2020年3月9日至3月21日期间部分旅客列车临时停运的公告', '1、2020年3月12日至3月21日，广州开Z190次旅客列车临时停运。<br/><br/>2、2020年3月12日至3月21日，广州开K756/7次旅客列车临时停运。<br/><br/>3、2020年3月12日至3月21日，长沙开K1074次旅客列车临时停运。<br/><br/>4、2020年3月9日至3月15日，深圳北开D2358次旅客列车临时停运。<br/><br/>具体详情请登录www.12306.cn网站查询，并以车站当日公告为准。', '2020-03-17');

-- ----------------------------
-- Table structure for ts_order
-- ----------------------------
DROP TABLE IF EXISTS `ts_order`;
CREATE TABLE `ts_order` (
  `orderid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `order_username` varchar(25) DEFAULT NULL,
  `order_idcardname` varchar(25) DEFAULT NULL,
  `order_idcardnumber` varchar(25) DEFAULT NULL,
  `ticketid` int(10) DEFAULT NULL,
  `order_trainname` varchar(25) DEFAULT NULL,
  `order_startstation` varchar(25) DEFAULT NULL,
  `order_endstation` varchar(25) DEFAULT NULL,
  `order_starttime` datetime DEFAULT NULL,
  `order_arrivetime` datetime DEFAULT NULL,
  `order_price` double(10,1) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `seatid` int(10) DEFAULT NULL,
  `order_carriage` int(10) DEFAULT NULL,
  `order_seattype` varchar(25) DEFAULT NULL,
  `order_seatlocation` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `order_userid` (`userid`),
  KEY `order_ticketid` (`ticketid`),
  KEY `order_seatid` (`seatid`),
  CONSTRAINT `order_seatid` FOREIGN KEY (`seatid`) REFERENCES `ts_seat` (`seatid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `order_ticketid` FOREIGN KEY (`ticketid`) REFERENCES `ts_ticket` (`ticketid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `order_userid` FOREIGN KEY (`userid`) REFERENCES `ts_user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_order
-- ----------------------------
INSERT INTO `ts_order` VALUES ('1', '2', 'user1', '李四', '441203196502114231', '1', 'G1', '广州南', '湛江西', '2020-04-18 15:00:00', '2020-04-18 18:00:00', '298.0', '2020-04-19 14:47:38', '未支付', '1', '1', '商务座', 'S01A');

-- ----------------------------
-- Table structure for ts_seat
-- ----------------------------
DROP TABLE IF EXISTS `ts_seat`;
CREATE TABLE `ts_seat` (
  `seatid` int(10) NOT NULL AUTO_INCREMENT,
  `trainid` int(10) DEFAULT NULL,
  `seattype` varchar(25) DEFAULT NULL,
  `carriage` int(5) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `seatlocation` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`seatid`),
  KEY `seat_trainid` (`trainid`),
  CONSTRAINT `seat_trainid` FOREIGN KEY (`trainid`) REFERENCES `ts_train` (`trainid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_seat
-- ----------------------------
INSERT INTO `ts_seat` VALUES ('1', '1', '商务座', '1', '1', 'S01A');
INSERT INTO `ts_seat` VALUES ('2', '1', '商务座', '1', '0', 'S01B');
INSERT INTO `ts_seat` VALUES ('3', '1', '商务座', '1', '0', 'S01C');
INSERT INTO `ts_seat` VALUES ('4', '1', '商务座', '1', '0', 'S01D');
INSERT INTO `ts_seat` VALUES ('5', '1', '商务座', '1', '0', 'S01E');
INSERT INTO `ts_seat` VALUES ('6', '1', '一等座', '2', '0', 'Y01A');
INSERT INTO `ts_seat` VALUES ('7', '1', '一等座', '2', '0', 'Y01B');
INSERT INTO `ts_seat` VALUES ('8', '1', '一等座', '2', '0', 'Y01C');
INSERT INTO `ts_seat` VALUES ('9', '1', '一等座', '2', '0', 'Y01D');
INSERT INTO `ts_seat` VALUES ('10', '1', '一等座', '2', '0', 'Y01E');
INSERT INTO `ts_seat` VALUES ('11', '1', '一等座', '2', '0', 'Y01F');
INSERT INTO `ts_seat` VALUES ('12', '1', '一等座', '2', '0', 'Y01G');
INSERT INTO `ts_seat` VALUES ('13', '1', '一等座', '2', '0', 'Y01H');
INSERT INTO `ts_seat` VALUES ('14', '1', '一等座', '2', '0', 'Y01I');
INSERT INTO `ts_seat` VALUES ('15', '1', '一等座', '2', '0', 'Y01J');
INSERT INTO `ts_seat` VALUES ('16', '1', '二等座', '3', '0', 'E01A');
INSERT INTO `ts_seat` VALUES ('17', '1', '二等座', '3', '0', 'E01B');
INSERT INTO `ts_seat` VALUES ('18', '1', '二等座', '3', '0', 'E01C');
INSERT INTO `ts_seat` VALUES ('19', '1', '二等座', '3', '0', 'E01D');
INSERT INTO `ts_seat` VALUES ('20', '1', '二等座', '3', '0', 'E01E');
INSERT INTO `ts_seat` VALUES ('21', '1', '二等座', '3', '0', 'E01F');
INSERT INTO `ts_seat` VALUES ('22', '1', '二等座', '3', '0', 'E01G');
INSERT INTO `ts_seat` VALUES ('23', '1', '二等座', '3', '0', 'E01H');
INSERT INTO `ts_seat` VALUES ('24', '1', '二等座', '3', '0', 'E01I');
INSERT INTO `ts_seat` VALUES ('25', '1', '二等座', '3', '0', 'E01J');
INSERT INTO `ts_seat` VALUES ('26', '2', '商务座', '1', '0', 'S02A');
INSERT INTO `ts_seat` VALUES ('27', '2', '商务座', '1', '0', 'S02B');
INSERT INTO `ts_seat` VALUES ('28', '2', '商务座', '1', '0', 'S02C');
INSERT INTO `ts_seat` VALUES ('29', '2', '商务座', '1', '0', 'S02D');
INSERT INTO `ts_seat` VALUES ('30', '2', '商务座', '1', '0', 'S02E');
INSERT INTO `ts_seat` VALUES ('31', '2', '一等座', '2', '0', 'Y02A');
INSERT INTO `ts_seat` VALUES ('32', '2', '一等座', '2', '0', 'Y02B');
INSERT INTO `ts_seat` VALUES ('33', '2', '一等座', '2', '0', 'Y02C');
INSERT INTO `ts_seat` VALUES ('34', '2', '一等座', '2', '0', 'Y02D');
INSERT INTO `ts_seat` VALUES ('35', '2', '一等座', '2', '0', 'Y02E');
INSERT INTO `ts_seat` VALUES ('36', '2', '一等座', '2', '0', 'Y02F');
INSERT INTO `ts_seat` VALUES ('37', '2', '一等座', '2', '0', 'Y02G');
INSERT INTO `ts_seat` VALUES ('38', '2', '一等座', '2', '0', 'Y02H');
INSERT INTO `ts_seat` VALUES ('39', '2', '一等座', '2', '0', 'Y02I');
INSERT INTO `ts_seat` VALUES ('40', '2', '一等座', '2', '0', 'Y02J');
INSERT INTO `ts_seat` VALUES ('41', '2', '二等座', '3', '0', 'E02A');
INSERT INTO `ts_seat` VALUES ('42', '2', '二等座', '3', '0', 'E02B');
INSERT INTO `ts_seat` VALUES ('43', '2', '二等座', '3', '0', 'E02C');
INSERT INTO `ts_seat` VALUES ('44', '2', '二等座', '3', '0', 'E02D');
INSERT INTO `ts_seat` VALUES ('45', '2', '二等座', '3', '0', 'E02E');
INSERT INTO `ts_seat` VALUES ('46', '2', '二等座', '3', '0', 'E02F');
INSERT INTO `ts_seat` VALUES ('47', '2', '二等座', '3', '0', 'E02G');
INSERT INTO `ts_seat` VALUES ('48', '2', '二等座', '3', '0', 'E02H');
INSERT INTO `ts_seat` VALUES ('49', '2', '二等座', '3', '0', 'E02I');
INSERT INTO `ts_seat` VALUES ('50', '2', '二等座', '3', '0', 'E02J');
INSERT INTO `ts_seat` VALUES ('51', '3', '商务座', '1', '0', 'S03A');
INSERT INTO `ts_seat` VALUES ('52', '3', '商务座', '1', '0', 'S03B');
INSERT INTO `ts_seat` VALUES ('53', '3', '商务座', '1', '0', 'S03C');
INSERT INTO `ts_seat` VALUES ('54', '3', '商务座', '1', '0', 'S03D');
INSERT INTO `ts_seat` VALUES ('55', '3', '商务座', '1', '0', 'S03E');
INSERT INTO `ts_seat` VALUES ('56', '3', '一等座', '2', '0', 'Y03A');
INSERT INTO `ts_seat` VALUES ('57', '3', '一等座', '2', '0', 'Y03B');
INSERT INTO `ts_seat` VALUES ('58', '3', '一等座', '2', '0', 'Y03C');
INSERT INTO `ts_seat` VALUES ('59', '3', '一等座', '2', '0', 'Y03D');
INSERT INTO `ts_seat` VALUES ('60', '3', '一等座', '2', '0', 'Y03E');
INSERT INTO `ts_seat` VALUES ('61', '3', '一等座', '2', '0', 'Y03F');
INSERT INTO `ts_seat` VALUES ('62', '3', '一等座', '2', '0', 'Y03G');
INSERT INTO `ts_seat` VALUES ('63', '3', '一等座', '2', '0', 'Y03H');
INSERT INTO `ts_seat` VALUES ('64', '3', '一等座', '2', '0', 'Y03I');
INSERT INTO `ts_seat` VALUES ('65', '3', '一等座', '2', '0', 'Y03J');
INSERT INTO `ts_seat` VALUES ('66', '3', '二等座', '3', '0', 'E03A');
INSERT INTO `ts_seat` VALUES ('67', '3', '二等座', '3', '0', 'E03B');
INSERT INTO `ts_seat` VALUES ('68', '3', '二等座', '3', '0', 'E03C');
INSERT INTO `ts_seat` VALUES ('69', '3', '二等座', '3', '0', 'E03D');
INSERT INTO `ts_seat` VALUES ('70', '3', '二等座', '3', '0', 'E03E');
INSERT INTO `ts_seat` VALUES ('71', '3', '二等座', '3', '0', 'E03F');
INSERT INTO `ts_seat` VALUES ('72', '3', '二等座', '3', '0', 'E03G');
INSERT INTO `ts_seat` VALUES ('73', '3', '二等座', '3', '0', 'E03H');
INSERT INTO `ts_seat` VALUES ('74', '3', '二等座', '3', '0', 'E03I');
INSERT INTO `ts_seat` VALUES ('75', '3', '二等座', '3', '0', 'E03J');
INSERT INTO `ts_seat` VALUES ('76', '4', '商务座', '1', '0', 'S04A');
INSERT INTO `ts_seat` VALUES ('77', '4', '商务座', '1', '0', 'S04B');
INSERT INTO `ts_seat` VALUES ('78', '4', '商务座', '1', '0', 'S04C');
INSERT INTO `ts_seat` VALUES ('79', '4', '商务座', '1', '0', 'S04D');
INSERT INTO `ts_seat` VALUES ('80', '4', '商务座', '1', '0', 'S04E');
INSERT INTO `ts_seat` VALUES ('81', '4', '一等座', '2', '0', 'Y04A');
INSERT INTO `ts_seat` VALUES ('82', '4', '一等座', '2', '0', 'Y04B');
INSERT INTO `ts_seat` VALUES ('83', '4', '一等座', '2', '0', 'Y04C');
INSERT INTO `ts_seat` VALUES ('84', '4', '一等座', '2', '0', 'Y04D');
INSERT INTO `ts_seat` VALUES ('85', '4', '一等座', '2', '0', 'Y04E');
INSERT INTO `ts_seat` VALUES ('86', '4', '一等座', '2', '0', 'Y04F');
INSERT INTO `ts_seat` VALUES ('87', '4', '一等座', '2', '0', 'Y04G');
INSERT INTO `ts_seat` VALUES ('88', '4', '一等座', '2', '0', 'Y04H');
INSERT INTO `ts_seat` VALUES ('89', '4', '一等座', '2', '0', 'Y04I');
INSERT INTO `ts_seat` VALUES ('90', '4', '一等座', '2', '0', 'Y04J');
INSERT INTO `ts_seat` VALUES ('91', '4', '二等座', '3', '0', 'E04A');
INSERT INTO `ts_seat` VALUES ('92', '4', '二等座', '3', '0', 'E04B');
INSERT INTO `ts_seat` VALUES ('93', '4', '二等座', '3', '0', 'E04C');
INSERT INTO `ts_seat` VALUES ('94', '4', '二等座', '3', '0', 'E04D');
INSERT INTO `ts_seat` VALUES ('95', '4', '二等座', '3', '0', 'E04E');
INSERT INTO `ts_seat` VALUES ('96', '4', '二等座', '3', '0', 'E04F');
INSERT INTO `ts_seat` VALUES ('97', '4', '二等座', '3', '0', 'E04G');
INSERT INTO `ts_seat` VALUES ('98', '4', '二等座', '3', '0', 'E04H');
INSERT INTO `ts_seat` VALUES ('99', '4', '二等座', '3', '0', 'E04I');
INSERT INTO `ts_seat` VALUES ('100', '4', '二等座', '3', '0', 'E04J');
INSERT INTO `ts_seat` VALUES ('101', '5', '商务座', '1', '0', 'S05A');
INSERT INTO `ts_seat` VALUES ('102', '5', '商务座', '1', '0', 'S05B');
INSERT INTO `ts_seat` VALUES ('103', '5', '商务座', '1', '0', 'S05C');
INSERT INTO `ts_seat` VALUES ('104', '5', '商务座', '1', '0', 'S05D');
INSERT INTO `ts_seat` VALUES ('105', '5', '商务座', '1', '0', 'S05E');
INSERT INTO `ts_seat` VALUES ('106', '5', '一等座', '2', '0', 'Y05A');
INSERT INTO `ts_seat` VALUES ('107', '5', '一等座', '2', '0', 'Y05B');
INSERT INTO `ts_seat` VALUES ('108', '5', '一等座', '2', '0', 'Y05C');
INSERT INTO `ts_seat` VALUES ('109', '5', '一等座', '2', '0', 'Y05D');
INSERT INTO `ts_seat` VALUES ('110', '5', '一等座', '2', '0', 'Y05E');
INSERT INTO `ts_seat` VALUES ('111', '5', '一等座', '2', '0', 'Y05F');
INSERT INTO `ts_seat` VALUES ('112', '5', '一等座', '2', '0', 'Y05G');
INSERT INTO `ts_seat` VALUES ('113', '5', '一等座', '2', '0', 'Y05H');
INSERT INTO `ts_seat` VALUES ('114', '5', '一等座', '2', '0', 'Y05I');
INSERT INTO `ts_seat` VALUES ('115', '5', '一等座', '2', '0', 'Y05J');
INSERT INTO `ts_seat` VALUES ('116', '5', '二等座', '3', '0', 'E05A');
INSERT INTO `ts_seat` VALUES ('117', '5', '二等座', '3', '0', 'E05B');
INSERT INTO `ts_seat` VALUES ('118', '5', '二等座', '3', '0', 'E05C');
INSERT INTO `ts_seat` VALUES ('119', '5', '二等座', '3', '0', 'E05D');
INSERT INTO `ts_seat` VALUES ('120', '5', '二等座', '3', '0', 'E05E');
INSERT INTO `ts_seat` VALUES ('121', '5', '二等座', '3', '0', 'E05F');
INSERT INTO `ts_seat` VALUES ('122', '5', '二等座', '3', '0', 'E05G');
INSERT INTO `ts_seat` VALUES ('123', '5', '二等座', '3', '0', 'E05H');
INSERT INTO `ts_seat` VALUES ('124', '5', '二等座', '3', '0', 'E05I');
INSERT INTO `ts_seat` VALUES ('125', '5', '二等座', '3', '0', 'E05J');
INSERT INTO `ts_seat` VALUES ('126', '6', '商务座', '1', '0', 'S06A');
INSERT INTO `ts_seat` VALUES ('127', '6', '商务座', '1', '0', 'S06B');
INSERT INTO `ts_seat` VALUES ('128', '6', '商务座', '1', '0', 'S06C');
INSERT INTO `ts_seat` VALUES ('129', '6', '商务座', '1', '0', 'S06D');
INSERT INTO `ts_seat` VALUES ('130', '6', '商务座', '1', '0', 'S06E');
INSERT INTO `ts_seat` VALUES ('131', '6', '一等座', '2', '0', 'Y06A');
INSERT INTO `ts_seat` VALUES ('132', '6', '一等座', '2', '0', 'Y06B');
INSERT INTO `ts_seat` VALUES ('133', '6', '一等座', '2', '0', 'Y06C');
INSERT INTO `ts_seat` VALUES ('134', '6', '一等座', '2', '0', 'Y06D');
INSERT INTO `ts_seat` VALUES ('135', '6', '一等座', '2', '0', 'Y06E');
INSERT INTO `ts_seat` VALUES ('136', '6', '一等座', '2', '0', 'Y06F');
INSERT INTO `ts_seat` VALUES ('137', '6', '一等座', '2', '0', 'Y06G');
INSERT INTO `ts_seat` VALUES ('138', '6', '一等座', '2', '0', 'Y06H');
INSERT INTO `ts_seat` VALUES ('139', '6', '一等座', '2', '0', 'Y06I');
INSERT INTO `ts_seat` VALUES ('140', '6', '一等座', '2', '0', 'Y06J');
INSERT INTO `ts_seat` VALUES ('141', '6', '二等座', '3', '0', 'E06A');
INSERT INTO `ts_seat` VALUES ('142', '6', '二等座', '3', '0', 'E06B');
INSERT INTO `ts_seat` VALUES ('143', '6', '二等座', '3', '0', 'E06C');
INSERT INTO `ts_seat` VALUES ('144', '6', '二等座', '3', '0', 'E06D');
INSERT INTO `ts_seat` VALUES ('145', '6', '二等座', '3', '0', 'E06E');
INSERT INTO `ts_seat` VALUES ('146', '6', '二等座', '3', '0', 'E06F');
INSERT INTO `ts_seat` VALUES ('147', '6', '二等座', '3', '0', 'E06G');
INSERT INTO `ts_seat` VALUES ('148', '6', '二等座', '3', '0', 'E06H');
INSERT INTO `ts_seat` VALUES ('149', '6', '二等座', '3', '0', 'E06I');
INSERT INTO `ts_seat` VALUES ('150', '6', '二等座', '3', '0', 'E06J');
INSERT INTO `ts_seat` VALUES ('151', '7', '商务座', '1', '0', 'S07A');
INSERT INTO `ts_seat` VALUES ('152', '7', '商务座', '1', '0', 'S07B');
INSERT INTO `ts_seat` VALUES ('153', '7', '商务座', '1', '0', 'S07C');
INSERT INTO `ts_seat` VALUES ('154', '7', '商务座', '1', '0', 'S07D');
INSERT INTO `ts_seat` VALUES ('155', '7', '商务座', '1', '0', 'S07E');
INSERT INTO `ts_seat` VALUES ('156', '7', '一等座', '2', '0', 'Y07A');
INSERT INTO `ts_seat` VALUES ('157', '7', '一等座', '2', '0', 'Y07B');
INSERT INTO `ts_seat` VALUES ('158', '7', '一等座', '2', '0', 'Y07C');
INSERT INTO `ts_seat` VALUES ('159', '7', '一等座', '2', '0', 'Y07D');
INSERT INTO `ts_seat` VALUES ('160', '7', '一等座', '2', '0', 'Y07E');
INSERT INTO `ts_seat` VALUES ('161', '7', '一等座', '2', '0', 'Y07F');
INSERT INTO `ts_seat` VALUES ('162', '7', '一等座', '2', '0', 'Y07G');
INSERT INTO `ts_seat` VALUES ('163', '7', '一等座', '2', '0', 'Y07H');
INSERT INTO `ts_seat` VALUES ('164', '7', '一等座', '2', '0', 'Y07I');
INSERT INTO `ts_seat` VALUES ('165', '7', '一等座', '2', '0', 'Y07J');
INSERT INTO `ts_seat` VALUES ('166', '7', '二等座', '3', '0', 'E07A');
INSERT INTO `ts_seat` VALUES ('167', '7', '二等座', '3', '0', 'E07B');
INSERT INTO `ts_seat` VALUES ('168', '7', '二等座', '3', '0', 'E07C');
INSERT INTO `ts_seat` VALUES ('169', '7', '二等座', '3', '0', 'E07D');
INSERT INTO `ts_seat` VALUES ('170', '7', '二等座', '3', '0', 'E07E');
INSERT INTO `ts_seat` VALUES ('171', '7', '二等座', '3', '0', 'E07F');
INSERT INTO `ts_seat` VALUES ('172', '7', '二等座', '3', '0', 'E07G');
INSERT INTO `ts_seat` VALUES ('173', '7', '二等座', '3', '0', 'E07H');
INSERT INTO `ts_seat` VALUES ('174', '7', '二等座', '3', '0', 'E07I');
INSERT INTO `ts_seat` VALUES ('175', '7', '二等座', '3', '0', 'E07J');
INSERT INTO `ts_seat` VALUES ('176', '8', '商务座', '1', '0', 'S08A');
INSERT INTO `ts_seat` VALUES ('177', '8', '商务座', '1', '0', 'S08B');
INSERT INTO `ts_seat` VALUES ('178', '8', '商务座', '1', '0', 'S08C');
INSERT INTO `ts_seat` VALUES ('179', '8', '商务座', '1', '0', 'S08D');
INSERT INTO `ts_seat` VALUES ('180', '8', '商务座', '1', '0', 'S08E');
INSERT INTO `ts_seat` VALUES ('181', '8', '一等座', '2', '0', 'Y08A');
INSERT INTO `ts_seat` VALUES ('182', '8', '一等座', '2', '0', 'Y08B');
INSERT INTO `ts_seat` VALUES ('183', '8', '一等座', '2', '0', 'Y08C');
INSERT INTO `ts_seat` VALUES ('184', '8', '一等座', '2', '0', 'Y08D');
INSERT INTO `ts_seat` VALUES ('185', '8', '一等座', '2', '0', 'Y08E');
INSERT INTO `ts_seat` VALUES ('186', '8', '一等座', '2', '0', 'Y08F');
INSERT INTO `ts_seat` VALUES ('187', '8', '一等座', '2', '0', 'Y08G');
INSERT INTO `ts_seat` VALUES ('188', '8', '一等座', '2', '0', 'Y08H');
INSERT INTO `ts_seat` VALUES ('189', '8', '一等座', '2', '0', 'Y08I');
INSERT INTO `ts_seat` VALUES ('190', '8', '一等座', '2', '0', 'Y08J');
INSERT INTO `ts_seat` VALUES ('191', '8', '二等座', '3', '0', 'E08A');
INSERT INTO `ts_seat` VALUES ('192', '8', '二等座', '3', '0', 'E08B');
INSERT INTO `ts_seat` VALUES ('193', '8', '二等座', '3', '0', 'E08C');
INSERT INTO `ts_seat` VALUES ('194', '8', '二等座', '3', '0', 'E08D');
INSERT INTO `ts_seat` VALUES ('195', '8', '二等座', '3', '0', 'E08E');
INSERT INTO `ts_seat` VALUES ('196', '8', '二等座', '3', '0', 'E08F');
INSERT INTO `ts_seat` VALUES ('197', '8', '二等座', '3', '0', 'E08G');
INSERT INTO `ts_seat` VALUES ('198', '8', '二等座', '3', '0', 'E08H');
INSERT INTO `ts_seat` VALUES ('199', '8', '二等座', '3', '0', 'E08I');
INSERT INTO `ts_seat` VALUES ('200', '8', '二等座', '3', '0', 'E08J');
INSERT INTO `ts_seat` VALUES ('201', '9', '商务座', '1', '0', 'S09A');
INSERT INTO `ts_seat` VALUES ('202', '9', '商务座', '1', '0', 'S09B');
INSERT INTO `ts_seat` VALUES ('203', '9', '商务座', '1', '0', 'S09C');
INSERT INTO `ts_seat` VALUES ('204', '9', '商务座', '1', '0', 'S09D');
INSERT INTO `ts_seat` VALUES ('205', '9', '商务座', '1', '0', 'S09E');
INSERT INTO `ts_seat` VALUES ('206', '9', '一等座', '2', '0', 'Y09A');
INSERT INTO `ts_seat` VALUES ('207', '9', '一等座', '2', '0', 'Y09B');
INSERT INTO `ts_seat` VALUES ('208', '9', '一等座', '2', '0', 'Y09C');
INSERT INTO `ts_seat` VALUES ('209', '9', '一等座', '2', '0', 'Y09D');
INSERT INTO `ts_seat` VALUES ('210', '9', '一等座', '2', '0', 'Y09E');
INSERT INTO `ts_seat` VALUES ('211', '9', '一等座', '2', '0', 'Y09F');
INSERT INTO `ts_seat` VALUES ('212', '9', '一等座', '2', '0', 'Y09G');
INSERT INTO `ts_seat` VALUES ('213', '9', '一等座', '2', '0', 'Y09H');
INSERT INTO `ts_seat` VALUES ('214', '9', '一等座', '2', '0', 'Y09I');
INSERT INTO `ts_seat` VALUES ('215', '9', '一等座', '2', '0', 'Y09J');
INSERT INTO `ts_seat` VALUES ('216', '9', '二等座', '3', '0', 'E09A');
INSERT INTO `ts_seat` VALUES ('217', '9', '二等座', '3', '0', 'E09B');
INSERT INTO `ts_seat` VALUES ('218', '9', '二等座', '3', '0', 'E09C');
INSERT INTO `ts_seat` VALUES ('219', '9', '二等座', '3', '0', 'E09D');
INSERT INTO `ts_seat` VALUES ('220', '9', '二等座', '3', '0', 'E09E');
INSERT INTO `ts_seat` VALUES ('221', '9', '二等座', '3', '0', 'E09F');
INSERT INTO `ts_seat` VALUES ('222', '9', '二等座', '3', '0', 'E09G');
INSERT INTO `ts_seat` VALUES ('223', '9', '二等座', '3', '0', 'E09H');
INSERT INTO `ts_seat` VALUES ('224', '9', '二等座', '3', '0', 'E09I');
INSERT INTO `ts_seat` VALUES ('225', '9', '二等座', '3', '0', 'E09J');
INSERT INTO `ts_seat` VALUES ('226', '10', '商务座', '1', '0', 'S10A');
INSERT INTO `ts_seat` VALUES ('227', '10', '商务座', '1', '0', 'S10B');
INSERT INTO `ts_seat` VALUES ('228', '10', '商务座', '1', '0', 'S10C');
INSERT INTO `ts_seat` VALUES ('229', '10', '商务座', '1', '0', 'S10D');
INSERT INTO `ts_seat` VALUES ('230', '10', '商务座', '1', '0', 'S10E');
INSERT INTO `ts_seat` VALUES ('231', '10', '一等座', '2', '0', 'Y10A');
INSERT INTO `ts_seat` VALUES ('232', '10', '一等座', '2', '0', 'Y10B');
INSERT INTO `ts_seat` VALUES ('233', '10', '一等座', '2', '0', 'Y10C');
INSERT INTO `ts_seat` VALUES ('234', '10', '一等座', '2', '0', 'Y10D');
INSERT INTO `ts_seat` VALUES ('235', '10', '一等座', '2', '0', 'Y10E');
INSERT INTO `ts_seat` VALUES ('236', '10', '一等座', '2', '0', 'Y10F');
INSERT INTO `ts_seat` VALUES ('237', '10', '一等座', '2', '0', 'Y10G');
INSERT INTO `ts_seat` VALUES ('238', '10', '一等座', '2', '0', 'Y10H');
INSERT INTO `ts_seat` VALUES ('239', '10', '一等座', '2', '0', 'Y10I');
INSERT INTO `ts_seat` VALUES ('240', '10', '一等座', '2', '0', 'Y10J');
INSERT INTO `ts_seat` VALUES ('241', '10', '二等座', '3', '0', 'E10A');
INSERT INTO `ts_seat` VALUES ('242', '10', '二等座', '3', '0', 'E10B');
INSERT INTO `ts_seat` VALUES ('243', '10', '二等座', '3', '0', 'E10C');
INSERT INTO `ts_seat` VALUES ('244', '10', '二等座', '3', '0', 'E10D');
INSERT INTO `ts_seat` VALUES ('245', '10', '二等座', '3', '0', 'E10E');
INSERT INTO `ts_seat` VALUES ('246', '10', '二等座', '3', '0', 'E10F');
INSERT INTO `ts_seat` VALUES ('247', '10', '二等座', '3', '0', 'E10G');
INSERT INTO `ts_seat` VALUES ('248', '10', '二等座', '3', '0', 'E10H');
INSERT INTO `ts_seat` VALUES ('249', '10', '二等座', '3', '0', 'E10I');
INSERT INTO `ts_seat` VALUES ('250', '10', '二等座', '3', '0', 'E10J');
INSERT INTO `ts_seat` VALUES ('251', '11', '商务座', '1', '0', 'S11A');
INSERT INTO `ts_seat` VALUES ('252', '11', '商务座', '1', '0', 'S11B');
INSERT INTO `ts_seat` VALUES ('253', '11', '商务座', '1', '0', 'S11C');
INSERT INTO `ts_seat` VALUES ('254', '11', '商务座', '1', '0', 'S11D');
INSERT INTO `ts_seat` VALUES ('255', '11', '商务座', '1', '0', 'S11E');
INSERT INTO `ts_seat` VALUES ('256', '11', '一等座', '2', '0', 'Y11A');
INSERT INTO `ts_seat` VALUES ('257', '11', '一等座', '2', '0', 'Y11B');
INSERT INTO `ts_seat` VALUES ('258', '11', '一等座', '2', '0', 'Y11C');
INSERT INTO `ts_seat` VALUES ('259', '11', '一等座', '2', '0', 'Y11D');
INSERT INTO `ts_seat` VALUES ('260', '11', '一等座', '2', '0', 'Y11E');
INSERT INTO `ts_seat` VALUES ('261', '11', '一等座', '2', '0', 'Y11F');
INSERT INTO `ts_seat` VALUES ('262', '11', '一等座', '2', '0', 'Y11G');
INSERT INTO `ts_seat` VALUES ('263', '11', '一等座', '2', '0', 'Y11H');
INSERT INTO `ts_seat` VALUES ('264', '11', '一等座', '2', '0', 'Y11I');
INSERT INTO `ts_seat` VALUES ('265', '11', '一等座', '2', '0', 'Y11J');
INSERT INTO `ts_seat` VALUES ('266', '11', '二等座', '3', '0', 'E11A');
INSERT INTO `ts_seat` VALUES ('267', '11', '二等座', '3', '0', 'E11B');
INSERT INTO `ts_seat` VALUES ('268', '11', '二等座', '3', '0', 'E11C');
INSERT INTO `ts_seat` VALUES ('269', '11', '二等座', '3', '0', 'E11D');
INSERT INTO `ts_seat` VALUES ('270', '11', '二等座', '3', '0', 'E11E');
INSERT INTO `ts_seat` VALUES ('271', '11', '二等座', '3', '0', 'E11F');
INSERT INTO `ts_seat` VALUES ('272', '11', '二等座', '3', '0', 'E11G');
INSERT INTO `ts_seat` VALUES ('273', '11', '二等座', '3', '0', 'E11H');
INSERT INTO `ts_seat` VALUES ('274', '11', '二等座', '3', '0', 'E11I');
INSERT INTO `ts_seat` VALUES ('275', '11', '二等座', '3', '0', 'E11J');
INSERT INTO `ts_seat` VALUES ('276', '12', '商务座', '1', '0', 'S12A');
INSERT INTO `ts_seat` VALUES ('277', '12', '商务座', '1', '0', 'S12B');
INSERT INTO `ts_seat` VALUES ('278', '12', '商务座', '1', '0', 'S12C');
INSERT INTO `ts_seat` VALUES ('279', '12', '商务座', '1', '0', 'S12D');
INSERT INTO `ts_seat` VALUES ('280', '12', '商务座', '1', '0', 'S12E');
INSERT INTO `ts_seat` VALUES ('281', '12', '一等座', '2', '0', 'Y12A');
INSERT INTO `ts_seat` VALUES ('282', '12', '一等座', '2', '0', 'Y12B');
INSERT INTO `ts_seat` VALUES ('283', '12', '一等座', '2', '0', 'Y12C');
INSERT INTO `ts_seat` VALUES ('284', '12', '一等座', '2', '0', 'Y12D');
INSERT INTO `ts_seat` VALUES ('285', '12', '一等座', '2', '0', 'Y12E');
INSERT INTO `ts_seat` VALUES ('286', '12', '一等座', '2', '0', 'Y12F');
INSERT INTO `ts_seat` VALUES ('287', '12', '一等座', '2', '0', 'Y12G');
INSERT INTO `ts_seat` VALUES ('288', '12', '一等座', '2', '0', 'Y12H');
INSERT INTO `ts_seat` VALUES ('289', '12', '一等座', '2', '0', 'Y12I');
INSERT INTO `ts_seat` VALUES ('290', '12', '一等座', '2', '0', 'Y12J');
INSERT INTO `ts_seat` VALUES ('291', '12', '二等座', '3', '0', 'E12A');
INSERT INTO `ts_seat` VALUES ('292', '12', '二等座', '3', '0', 'E12B');
INSERT INTO `ts_seat` VALUES ('293', '12', '二等座', '3', '0', 'E12C');
INSERT INTO `ts_seat` VALUES ('294', '12', '二等座', '3', '0', 'E12D');
INSERT INTO `ts_seat` VALUES ('295', '12', '二等座', '3', '0', 'E12E');
INSERT INTO `ts_seat` VALUES ('296', '12', '二等座', '3', '0', 'E12F');
INSERT INTO `ts_seat` VALUES ('297', '12', '二等座', '3', '0', 'E12G');
INSERT INTO `ts_seat` VALUES ('298', '12', '二等座', '3', '0', 'E12H');
INSERT INTO `ts_seat` VALUES ('299', '12', '二等座', '3', '0', 'E12I');
INSERT INTO `ts_seat` VALUES ('300', '12', '二等座', '3', '0', 'E12J');
INSERT INTO `ts_seat` VALUES ('301', '13', '商务座', '1', '0', 'S13A');
INSERT INTO `ts_seat` VALUES ('302', '13', '商务座', '1', '0', 'S13B');
INSERT INTO `ts_seat` VALUES ('303', '13', '商务座', '1', '0', 'S13C');
INSERT INTO `ts_seat` VALUES ('304', '13', '商务座', '1', '0', 'S13D');
INSERT INTO `ts_seat` VALUES ('305', '13', '商务座', '1', '0', 'S13E');
INSERT INTO `ts_seat` VALUES ('306', '13', '一等座', '2', '0', 'Y13A');
INSERT INTO `ts_seat` VALUES ('307', '13', '一等座', '2', '0', 'Y13B');
INSERT INTO `ts_seat` VALUES ('308', '13', '一等座', '2', '0', 'Y13C');
INSERT INTO `ts_seat` VALUES ('309', '13', '一等座', '2', '0', 'Y13D');
INSERT INTO `ts_seat` VALUES ('310', '13', '一等座', '2', '0', 'Y13E');
INSERT INTO `ts_seat` VALUES ('311', '13', '一等座', '2', '0', 'Y13F');
INSERT INTO `ts_seat` VALUES ('312', '13', '一等座', '2', '0', 'Y13G');
INSERT INTO `ts_seat` VALUES ('313', '13', '一等座', '2', '0', 'Y13H');
INSERT INTO `ts_seat` VALUES ('314', '13', '一等座', '2', '0', 'Y13I');
INSERT INTO `ts_seat` VALUES ('315', '13', '一等座', '2', '0', 'Y13J');
INSERT INTO `ts_seat` VALUES ('316', '13', '二等座', '3', '0', 'E13A');
INSERT INTO `ts_seat` VALUES ('317', '13', '二等座', '3', '0', 'E13B');
INSERT INTO `ts_seat` VALUES ('318', '13', '二等座', '3', '0', 'E13C');
INSERT INTO `ts_seat` VALUES ('319', '13', '二等座', '3', '0', 'E13D');
INSERT INTO `ts_seat` VALUES ('320', '13', '二等座', '3', '0', 'E13E');
INSERT INTO `ts_seat` VALUES ('321', '13', '二等座', '3', '0', 'E13F');
INSERT INTO `ts_seat` VALUES ('322', '13', '二等座', '3', '0', 'E13G');
INSERT INTO `ts_seat` VALUES ('323', '13', '二等座', '3', '0', 'E13H');
INSERT INTO `ts_seat` VALUES ('324', '13', '二等座', '3', '0', 'E13I');
INSERT INTO `ts_seat` VALUES ('325', '13', '二等座', '3', '0', 'E13J');
INSERT INTO `ts_seat` VALUES ('326', '14', '商务座', '1', '0', 'S14A');
INSERT INTO `ts_seat` VALUES ('327', '14', '商务座', '1', '0', 'S14B');
INSERT INTO `ts_seat` VALUES ('328', '14', '商务座', '1', '0', 'S14C');
INSERT INTO `ts_seat` VALUES ('329', '14', '商务座', '1', '0', 'S14D');
INSERT INTO `ts_seat` VALUES ('330', '14', '商务座', '1', '0', 'S14E');
INSERT INTO `ts_seat` VALUES ('331', '14', '一等座', '2', '0', 'Y14A');
INSERT INTO `ts_seat` VALUES ('332', '14', '一等座', '2', '0', 'Y14B');
INSERT INTO `ts_seat` VALUES ('333', '14', '一等座', '2', '0', 'Y14C');
INSERT INTO `ts_seat` VALUES ('334', '14', '一等座', '2', '0', 'Y14D');
INSERT INTO `ts_seat` VALUES ('335', '14', '一等座', '2', '0', 'Y14E');
INSERT INTO `ts_seat` VALUES ('336', '14', '一等座', '2', '0', 'Y14F');
INSERT INTO `ts_seat` VALUES ('337', '14', '一等座', '2', '0', 'Y14G');
INSERT INTO `ts_seat` VALUES ('338', '14', '一等座', '2', '0', 'Y14H');
INSERT INTO `ts_seat` VALUES ('339', '14', '一等座', '2', '0', 'Y14I');
INSERT INTO `ts_seat` VALUES ('340', '14', '一等座', '2', '0', 'Y14J');
INSERT INTO `ts_seat` VALUES ('341', '14', '二等座', '3', '0', 'E14A');
INSERT INTO `ts_seat` VALUES ('342', '14', '二等座', '3', '0', 'E14B');
INSERT INTO `ts_seat` VALUES ('343', '14', '二等座', '3', '0', 'E14C');
INSERT INTO `ts_seat` VALUES ('344', '14', '二等座', '3', '0', 'E14D');
INSERT INTO `ts_seat` VALUES ('345', '14', '二等座', '3', '0', 'E14E');
INSERT INTO `ts_seat` VALUES ('346', '14', '二等座', '3', '0', 'E14F');
INSERT INTO `ts_seat` VALUES ('347', '14', '二等座', '3', '0', 'E14G');
INSERT INTO `ts_seat` VALUES ('348', '14', '二等座', '3', '0', 'E14H');
INSERT INTO `ts_seat` VALUES ('349', '14', '二等座', '3', '0', 'E14I');
INSERT INTO `ts_seat` VALUES ('350', '14', '二等座', '3', '0', 'E14J');
INSERT INTO `ts_seat` VALUES ('351', '15', '商务座', '1', '0', 'S15A');
INSERT INTO `ts_seat` VALUES ('352', '15', '商务座', '1', '0', 'S15B');
INSERT INTO `ts_seat` VALUES ('353', '15', '商务座', '1', '0', 'S15C');
INSERT INTO `ts_seat` VALUES ('354', '15', '商务座', '1', '0', 'S15D');
INSERT INTO `ts_seat` VALUES ('355', '15', '商务座', '1', '0', 'S15E');
INSERT INTO `ts_seat` VALUES ('356', '15', '一等座', '2', '0', 'Y15A');
INSERT INTO `ts_seat` VALUES ('357', '15', '一等座', '2', '0', 'Y15B');
INSERT INTO `ts_seat` VALUES ('358', '15', '一等座', '2', '0', 'Y15C');
INSERT INTO `ts_seat` VALUES ('359', '15', '一等座', '2', '0', 'Y15D');
INSERT INTO `ts_seat` VALUES ('360', '15', '一等座', '2', '0', 'Y15E');
INSERT INTO `ts_seat` VALUES ('361', '15', '一等座', '2', '0', 'Y15F');
INSERT INTO `ts_seat` VALUES ('362', '15', '一等座', '2', '0', 'Y15G');
INSERT INTO `ts_seat` VALUES ('363', '15', '一等座', '2', '0', 'Y15H');
INSERT INTO `ts_seat` VALUES ('364', '15', '一等座', '2', '0', 'Y15I');
INSERT INTO `ts_seat` VALUES ('365', '15', '一等座', '2', '0', 'Y15J');
INSERT INTO `ts_seat` VALUES ('366', '15', '二等座', '3', '0', 'E15A');
INSERT INTO `ts_seat` VALUES ('367', '15', '二等座', '3', '0', 'E15B');
INSERT INTO `ts_seat` VALUES ('368', '15', '二等座', '3', '0', 'E15C');
INSERT INTO `ts_seat` VALUES ('369', '15', '二等座', '3', '0', 'E15D');
INSERT INTO `ts_seat` VALUES ('370', '15', '二等座', '3', '0', 'E15E');
INSERT INTO `ts_seat` VALUES ('371', '15', '二等座', '3', '0', 'E15F');
INSERT INTO `ts_seat` VALUES ('372', '15', '二等座', '3', '0', 'E15G');
INSERT INTO `ts_seat` VALUES ('373', '15', '二等座', '3', '0', 'E15H');
INSERT INTO `ts_seat` VALUES ('374', '15', '二等座', '3', '0', 'E15I');
INSERT INTO `ts_seat` VALUES ('375', '15', '二等座', '3', '0', 'E15J');
INSERT INTO `ts_seat` VALUES ('376', '16', '商务座', '1', '0', 'S16A');
INSERT INTO `ts_seat` VALUES ('377', '16', '商务座', '1', '0', 'S16B');
INSERT INTO `ts_seat` VALUES ('378', '16', '商务座', '1', '0', 'S16C');
INSERT INTO `ts_seat` VALUES ('379', '16', '商务座', '1', '0', 'S16D');
INSERT INTO `ts_seat` VALUES ('380', '16', '商务座', '1', '0', 'S16E');
INSERT INTO `ts_seat` VALUES ('381', '16', '一等座', '2', '0', 'Y16A');
INSERT INTO `ts_seat` VALUES ('382', '16', '一等座', '2', '0', 'Y16B');
INSERT INTO `ts_seat` VALUES ('383', '16', '一等座', '2', '0', 'Y16C');
INSERT INTO `ts_seat` VALUES ('384', '16', '一等座', '2', '0', 'Y16D');
INSERT INTO `ts_seat` VALUES ('385', '16', '一等座', '2', '0', 'Y16E');
INSERT INTO `ts_seat` VALUES ('386', '16', '一等座', '2', '0', 'Y16F');
INSERT INTO `ts_seat` VALUES ('387', '16', '一等座', '2', '0', 'Y16G');
INSERT INTO `ts_seat` VALUES ('388', '16', '一等座', '2', '0', 'Y16H');
INSERT INTO `ts_seat` VALUES ('389', '16', '一等座', '2', '0', 'Y16I');
INSERT INTO `ts_seat` VALUES ('390', '16', '一等座', '2', '0', 'Y16J');
INSERT INTO `ts_seat` VALUES ('391', '16', '二等座', '3', '0', 'E16A');
INSERT INTO `ts_seat` VALUES ('392', '16', '二等座', '3', '0', 'E16B');
INSERT INTO `ts_seat` VALUES ('393', '16', '二等座', '3', '0', 'E16C');
INSERT INTO `ts_seat` VALUES ('394', '16', '二等座', '3', '0', 'E16D');
INSERT INTO `ts_seat` VALUES ('395', '16', '二等座', '3', '0', 'E16E');
INSERT INTO `ts_seat` VALUES ('396', '16', '二等座', '3', '0', 'E16F');
INSERT INTO `ts_seat` VALUES ('397', '16', '二等座', '3', '0', 'E16G');
INSERT INTO `ts_seat` VALUES ('398', '16', '二等座', '3', '0', 'E16H');
INSERT INTO `ts_seat` VALUES ('399', '16', '二等座', '3', '0', 'E16I');
INSERT INTO `ts_seat` VALUES ('400', '16', '二等座', '3', '0', 'E16J');
INSERT INTO `ts_seat` VALUES ('401', '17', '商务座', '1', '0', 'S17A');
INSERT INTO `ts_seat` VALUES ('402', '17', '商务座', '1', '0', 'S17B');
INSERT INTO `ts_seat` VALUES ('403', '17', '商务座', '1', '0', 'S17C');
INSERT INTO `ts_seat` VALUES ('404', '17', '商务座', '1', '0', 'S17D');
INSERT INTO `ts_seat` VALUES ('405', '17', '商务座', '1', '0', 'S17E');
INSERT INTO `ts_seat` VALUES ('406', '17', '一等座', '2', '0', 'Y17A');
INSERT INTO `ts_seat` VALUES ('407', '17', '一等座', '2', '0', 'Y17B');
INSERT INTO `ts_seat` VALUES ('408', '17', '一等座', '2', '0', 'Y17C');
INSERT INTO `ts_seat` VALUES ('409', '17', '一等座', '2', '0', 'Y17D');
INSERT INTO `ts_seat` VALUES ('410', '17', '一等座', '2', '0', 'Y17E');
INSERT INTO `ts_seat` VALUES ('411', '17', '一等座', '2', '0', 'Y17F');
INSERT INTO `ts_seat` VALUES ('412', '17', '一等座', '2', '0', 'Y17G');
INSERT INTO `ts_seat` VALUES ('413', '17', '一等座', '2', '0', 'Y17H');
INSERT INTO `ts_seat` VALUES ('414', '17', '一等座', '2', '0', 'Y17I');
INSERT INTO `ts_seat` VALUES ('415', '17', '一等座', '2', '0', 'Y17J');
INSERT INTO `ts_seat` VALUES ('416', '17', '二等座', '3', '0', 'E17A');
INSERT INTO `ts_seat` VALUES ('417', '17', '二等座', '3', '0', 'E17B');
INSERT INTO `ts_seat` VALUES ('418', '17', '二等座', '3', '0', 'E17C');
INSERT INTO `ts_seat` VALUES ('419', '17', '二等座', '3', '0', 'E17D');
INSERT INTO `ts_seat` VALUES ('420', '17', '二等座', '3', '0', 'E17E');
INSERT INTO `ts_seat` VALUES ('421', '17', '二等座', '3', '0', 'E17F');
INSERT INTO `ts_seat` VALUES ('422', '17', '二等座', '3', '0', 'E17G');
INSERT INTO `ts_seat` VALUES ('423', '17', '二等座', '3', '0', 'E17H');
INSERT INTO `ts_seat` VALUES ('424', '17', '二等座', '3', '0', 'E17I');
INSERT INTO `ts_seat` VALUES ('425', '17', '二等座', '3', '0', 'E17J');
INSERT INTO `ts_seat` VALUES ('426', '18', '商务座', '1', '0', 'S18A');
INSERT INTO `ts_seat` VALUES ('427', '18', '商务座', '1', '0', 'S18B');
INSERT INTO `ts_seat` VALUES ('428', '18', '商务座', '1', '0', 'S18C');
INSERT INTO `ts_seat` VALUES ('429', '18', '商务座', '1', '0', 'S18D');
INSERT INTO `ts_seat` VALUES ('430', '18', '商务座', '1', '0', 'S18E');
INSERT INTO `ts_seat` VALUES ('431', '18', '一等座', '2', '0', 'Y18A');
INSERT INTO `ts_seat` VALUES ('432', '18', '一等座', '2', '0', 'Y18B');
INSERT INTO `ts_seat` VALUES ('433', '18', '一等座', '2', '0', 'Y18C');
INSERT INTO `ts_seat` VALUES ('434', '18', '一等座', '2', '0', 'Y18D');
INSERT INTO `ts_seat` VALUES ('435', '18', '一等座', '2', '0', 'Y18E');
INSERT INTO `ts_seat` VALUES ('436', '18', '一等座', '2', '0', 'Y18F');
INSERT INTO `ts_seat` VALUES ('437', '18', '一等座', '2', '0', 'Y18G');
INSERT INTO `ts_seat` VALUES ('438', '18', '一等座', '2', '0', 'Y18H');
INSERT INTO `ts_seat` VALUES ('439', '18', '一等座', '2', '0', 'Y18I');
INSERT INTO `ts_seat` VALUES ('440', '18', '一等座', '2', '0', 'Y18J');
INSERT INTO `ts_seat` VALUES ('441', '18', '二等座', '3', '0', 'E18A');
INSERT INTO `ts_seat` VALUES ('442', '18', '二等座', '3', '0', 'E18B');
INSERT INTO `ts_seat` VALUES ('443', '18', '二等座', '3', '0', 'E18C');
INSERT INTO `ts_seat` VALUES ('444', '18', '二等座', '3', '0', 'E18D');
INSERT INTO `ts_seat` VALUES ('445', '18', '二等座', '3', '0', 'E18E');
INSERT INTO `ts_seat` VALUES ('446', '18', '二等座', '3', '0', 'E18F');
INSERT INTO `ts_seat` VALUES ('447', '18', '二等座', '3', '0', 'E18G');
INSERT INTO `ts_seat` VALUES ('448', '18', '二等座', '3', '0', 'E18H');
INSERT INTO `ts_seat` VALUES ('449', '18', '二等座', '3', '0', 'E18I');
INSERT INTO `ts_seat` VALUES ('450', '18', '二等座', '3', '0', 'E18J');
INSERT INTO `ts_seat` VALUES ('451', '19', '商务座', '1', '0', 'S19A');
INSERT INTO `ts_seat` VALUES ('452', '19', '商务座', '1', '0', 'S19B');
INSERT INTO `ts_seat` VALUES ('453', '19', '商务座', '1', '0', 'S19C');
INSERT INTO `ts_seat` VALUES ('454', '19', '商务座', '1', '0', 'S19D');
INSERT INTO `ts_seat` VALUES ('455', '19', '商务座', '1', '0', 'S19E');
INSERT INTO `ts_seat` VALUES ('456', '19', '一等座', '2', '0', 'Y19A');
INSERT INTO `ts_seat` VALUES ('457', '19', '一等座', '2', '0', 'Y19B');
INSERT INTO `ts_seat` VALUES ('458', '19', '一等座', '2', '0', 'Y19C');
INSERT INTO `ts_seat` VALUES ('459', '19', '一等座', '2', '0', 'Y19D');
INSERT INTO `ts_seat` VALUES ('460', '19', '一等座', '2', '0', 'Y19E');
INSERT INTO `ts_seat` VALUES ('461', '19', '一等座', '2', '0', 'Y19F');
INSERT INTO `ts_seat` VALUES ('462', '19', '一等座', '2', '0', 'Y19G');
INSERT INTO `ts_seat` VALUES ('463', '19', '一等座', '2', '0', 'Y19H');
INSERT INTO `ts_seat` VALUES ('464', '19', '一等座', '2', '0', 'Y19I');
INSERT INTO `ts_seat` VALUES ('465', '19', '一等座', '2', '0', 'Y19J');
INSERT INTO `ts_seat` VALUES ('466', '19', '二等座', '3', '0', 'E19A');
INSERT INTO `ts_seat` VALUES ('467', '19', '二等座', '3', '0', 'E19B');
INSERT INTO `ts_seat` VALUES ('468', '19', '二等座', '3', '0', 'E19C');
INSERT INTO `ts_seat` VALUES ('469', '19', '二等座', '3', '0', 'E19D');
INSERT INTO `ts_seat` VALUES ('470', '19', '二等座', '3', '0', 'E19E');
INSERT INTO `ts_seat` VALUES ('471', '19', '二等座', '3', '0', 'E19F');
INSERT INTO `ts_seat` VALUES ('472', '19', '二等座', '3', '0', 'E19G');
INSERT INTO `ts_seat` VALUES ('473', '19', '二等座', '3', '0', 'E19H');
INSERT INTO `ts_seat` VALUES ('474', '19', '二等座', '3', '0', 'E19I');
INSERT INTO `ts_seat` VALUES ('475', '19', '二等座', '3', '0', 'E19J');
INSERT INTO `ts_seat` VALUES ('476', '20', '商务座', '1', '0', 'S20A');
INSERT INTO `ts_seat` VALUES ('477', '20', '商务座', '1', '0', 'S20B');
INSERT INTO `ts_seat` VALUES ('478', '20', '商务座', '1', '0', 'S20C');
INSERT INTO `ts_seat` VALUES ('479', '20', '商务座', '1', '0', 'S20D');
INSERT INTO `ts_seat` VALUES ('480', '20', '商务座', '1', '0', 'S20E');
INSERT INTO `ts_seat` VALUES ('481', '20', '一等座', '2', '0', 'Y20A');
INSERT INTO `ts_seat` VALUES ('482', '20', '一等座', '2', '0', 'Y20B');
INSERT INTO `ts_seat` VALUES ('483', '20', '一等座', '2', '0', 'Y20C');
INSERT INTO `ts_seat` VALUES ('484', '20', '一等座', '2', '0', 'Y20D');
INSERT INTO `ts_seat` VALUES ('485', '20', '一等座', '2', '0', 'Y20E');
INSERT INTO `ts_seat` VALUES ('486', '20', '一等座', '2', '0', 'Y20F');
INSERT INTO `ts_seat` VALUES ('487', '20', '一等座', '2', '0', 'Y20G');
INSERT INTO `ts_seat` VALUES ('488', '20', '一等座', '2', '0', 'Y20H');
INSERT INTO `ts_seat` VALUES ('489', '20', '一等座', '2', '0', 'Y20I');
INSERT INTO `ts_seat` VALUES ('490', '20', '一等座', '2', '0', 'Y20J');
INSERT INTO `ts_seat` VALUES ('491', '20', '二等座', '3', '0', 'E20A');
INSERT INTO `ts_seat` VALUES ('492', '20', '二等座', '3', '0', 'E20B');
INSERT INTO `ts_seat` VALUES ('493', '20', '二等座', '3', '0', 'E20C');
INSERT INTO `ts_seat` VALUES ('494', '20', '二等座', '3', '0', 'E20D');
INSERT INTO `ts_seat` VALUES ('495', '20', '二等座', '3', '0', 'E20E');
INSERT INTO `ts_seat` VALUES ('496', '20', '二等座', '3', '0', 'E20F');
INSERT INTO `ts_seat` VALUES ('497', '20', '二等座', '3', '0', 'E20G');
INSERT INTO `ts_seat` VALUES ('498', '20', '二等座', '3', '0', 'E20H');
INSERT INTO `ts_seat` VALUES ('499', '20', '二等座', '3', '0', 'E20I');
INSERT INTO `ts_seat` VALUES ('500', '20', '二等座', '3', '0', 'E20J');

-- ----------------------------
-- Table structure for ts_station
-- ----------------------------
DROP TABLE IF EXISTS `ts_station`;
CREATE TABLE `ts_station` (
  `stationid` int(10) NOT NULL AUTO_INCREMENT,
  `startstation` varchar(25) DEFAULT NULL,
  `endstation` varchar(25) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `arrivetime` datetime DEFAULT NULL,
  `usetime` int(10) DEFAULT NULL,
  `distance` int(10) DEFAULT NULL,
  PRIMARY KEY (`stationid`),
  KEY `starttime` (`starttime`),
  KEY `arrivetime` (`arrivetime`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_station
-- ----------------------------
INSERT INTO `ts_station` VALUES ('1', '广州南', '湛江西', '2020-05-02 15:00:00', '2020-05-02 18:00:00', '180', '420');
INSERT INTO `ts_station` VALUES ('2', '湛江西', '广州南', '2020-05-02 15:00:00', '2020-05-02 18:00:00', '180', '420');
INSERT INTO `ts_station` VALUES ('3', '广州南', '深圳北', '2020-05-02 15:00:00', '2020-05-02 15:40:00', '40', '200');
INSERT INTO `ts_station` VALUES ('4', '深圳北', '广州南', '2020-05-02 15:00:00', '2020-05-02 15:40:00', '40', '200');
INSERT INTO `ts_station` VALUES ('5', '北京南', '南京南', '2020-05-02 10:30:00', '2020-05-02 15:00:00', '270', '1200');
INSERT INTO `ts_station` VALUES ('6', '南京南', '北京南', '2020-05-02 11:00:00', '2020-05-02 15:30:00', '270', '1200');
INSERT INTO `ts_station` VALUES ('7', '广州南', '长沙南', '2020-05-02 15:30:00', '2020-05-02 18:30:00', '180', '400');
INSERT INTO `ts_station` VALUES ('8', '长沙南', '广州南', '2020-05-02 15:40:00', '2020-05-02 18:40:00', '180', '400');
INSERT INTO `ts_station` VALUES ('9', '广州南', '北京西', '2020-05-18 01:00:00', '2020-04-18 11:00:00', '600', '3000');
INSERT INTO `ts_station` VALUES ('10', '北京西', '广州南', '2020-05-02 09:00:00', '2020-05-02 19:00:00', '600', '3000');
INSERT INTO `ts_station` VALUES ('11', '北京南', '上海虹桥', '2020-05-02 13:00:00', '2020-05-02 19:00:00', '360', '1800');
INSERT INTO `ts_station` VALUES ('12', '上海虹桥', '北京南', '2020-05-02 15:00:00', '2020-05-02 21:00:00', '360', '1800');
INSERT INTO `ts_station` VALUES ('13', '湛江西', '深圳北', '2020-05-02 12:00:00', '2020-05-02 16:00:00', '240', '500');
INSERT INTO `ts_station` VALUES ('14', '深圳北', '湛江西', '2020-05-02 16:00:00', '2020-05-02 20:00:00', '240', '500');
INSERT INTO `ts_station` VALUES ('15', '成都东', '广州南', '2020-05-02 08:30:00', '2020-05-02 16:30:00', '480', '2500');
INSERT INTO `ts_station` VALUES ('16', '广州南', '成都东', '2020-05-02 09:30:00', '2020-05-02 17:30:00', '480', '2500');
INSERT INTO `ts_station` VALUES ('17', '广州南', '重庆西', '2020-05-02 10:00:00', '2020-05-02 17:00:00', '420', '2100');
INSERT INTO `ts_station` VALUES ('18', '重庆西', '广州南', '2020-05-02 14:00:00', '2020-05-02 21:00:00', '420', '2100');
INSERT INTO `ts_station` VALUES ('19', '广州南', '上海虹桥', '2020-05-02 07:00:00', '2020-05-02 19:00:00', '720', '3600');
INSERT INTO `ts_station` VALUES ('20', '上海虹桥', '广州南', '2020-05-02 07:00:00', '2020-05-02 19:00:00', '720', '3600');

-- ----------------------------
-- Table structure for ts_ticket
-- ----------------------------
DROP TABLE IF EXISTS `ts_ticket`;
CREATE TABLE `ts_ticket` (
  `ticketid` int(10) NOT NULL AUTO_INCREMENT,
  `stationid` int(10) DEFAULT NULL,
  `trainid` int(10) DEFAULT NULL,
  `ticket_startstation` varchar(25) DEFAULT NULL,
  `ticket_endstation` varchar(25) DEFAULT NULL,
  `ticket_starttime` datetime DEFAULT NULL,
  `ticket_arrivetime` datetime DEFAULT NULL,
  `ticket_usetime` int(10) DEFAULT NULL,
  `ticketprice` double(10,1) DEFAULT NULL,
  `ticket_trainname` varchar(25) DEFAULT NULL,
  `ticket_traintype` varchar(25) DEFAULT NULL,
  `special_seat_number` int(10) DEFAULT NULL,
  `first_seat_number` int(10) DEFAULT NULL,
  `second_seat_number` int(10) DEFAULT NULL,
  PRIMARY KEY (`ticketid`),
  KEY `ticket_trainid` (`trainid`),
  KEY `ticket_stationid` (`stationid`),
  CONSTRAINT `ticket_stationid` FOREIGN KEY (`stationid`) REFERENCES `ts_station` (`stationid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ticket_trainid` FOREIGN KEY (`trainid`) REFERENCES `ts_train` (`trainid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_ticket
-- ----------------------------
INSERT INTO `ts_ticket` VALUES ('1', '1', '1', '广州南', '湛江西', '2020-04-26 15:00:00', '2020-04-26 18:00:00', '180', '294.0', 'G1', '高铁', '4', '10', '10');
INSERT INTO `ts_ticket` VALUES ('2', '2', '15', '湛江西', '广州南', '2020-04-27 15:00:00', '2020-04-27 18:00:00', '180', '294.0', 'D5', '动车', '5', '10', '10');
INSERT INTO `ts_ticket` VALUES ('3', '2', '19', '湛江西', '广州南', '2020-05-02 15:00:00', '2020-05-02 18:00:00', '180', '168.0', 'D9', '动车', '5', '10', '10');

-- ----------------------------
-- Table structure for ts_train
-- ----------------------------
DROP TABLE IF EXISTS `ts_train`;
CREATE TABLE `ts_train` (
  `trainid` int(10) NOT NULL AUTO_INCREMENT,
  `trainname` varchar(25) DEFAULT NULL,
  `traintype` varchar(25) DEFAULT NULL,
  `trainlocation` varchar(25) DEFAULT NULL,
  `special_class_seat` int(10) DEFAULT NULL,
  `first_class_seat` int(10) DEFAULT NULL,
  `second_class_seat` int(10) DEFAULT NULL,
  `trainprice` double(10,1) DEFAULT NULL,
  PRIMARY KEY (`trainid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_train
-- ----------------------------
INSERT INTO `ts_train` VALUES ('1', 'G1', '高铁', '广州南', '4', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('2', 'G2', '高铁', '南京南', '5', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('3', 'G3', '高铁', '长沙南', '5', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('4', 'G4', '高铁', '北京西', '5', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('5', 'G5', '高铁', '上海虹桥', '5', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('6', 'G6', '高铁', '广州南', '5', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('7', 'G7', '高铁', '深圳北', '5', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('8', 'G8', '高铁', '成都东', '5', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('9', 'G9', '高铁', '深圳北', '5', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('10', 'G10', '高铁', '重庆西', '5', '10', '10', '0.7');
INSERT INTO `ts_train` VALUES ('11', 'D1', '动车', '广州南', '5', '10', '10', '0.4');
INSERT INTO `ts_train` VALUES ('12', 'D2', '动车', '北京南', '5', '10', '10', '0.4');
INSERT INTO `ts_train` VALUES ('13', 'D3', '动车', '广州南', '5', '10', '10', '0.4');
INSERT INTO `ts_train` VALUES ('14', 'D4', '动车', '广州南', '5', '10', '10', '0.4');
INSERT INTO `ts_train` VALUES ('15', 'D5', '动车', '湛江西', '5', '10', '10', '0.4');
INSERT INTO `ts_train` VALUES ('16', 'D6', '动车', '广州南', '5', '10', '10', '0.4');
INSERT INTO `ts_train` VALUES ('17', 'D7', '动车', '广州南', '5', '10', '10', '0.4');
INSERT INTO `ts_train` VALUES ('18', 'D8', '动车', '上海虹桥', '5', '10', '10', '0.4');
INSERT INTO `ts_train` VALUES ('19', 'D9', '动车', '湛江西', '5', '10', '10', '0.4');
INSERT INTO `ts_train` VALUES ('20', 'D10', '动车', '北京南', '5', '10', '10', '0.4');

-- ----------------------------
-- Table structure for ts_user
-- ----------------------------
DROP TABLE IF EXISTS `ts_user`;
CREATE TABLE `ts_user` (
  `userid` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `admin` int(1) DEFAULT NULL COMMENT '是否管理员',
  `idcardnumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号码',
  `idcardname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证名称',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '乘客类型',
  `logintime` datetime DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_user
-- ----------------------------
INSERT INTO `ts_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '626816858@qq.com', '1', '441203201905321234', '张三', '18620645324', '成人', '2020-05-01 20:02:53');
INSERT INTO `ts_user` VALUES ('2', 'user1', 'e10adc3949ba59abbe56e057f20f883e', 'lisi@126.com', '0', '441203196502114231', '李四', '18630200697', '成人', '2020-04-18 20:15:36');
INSERT INTO `ts_user` VALUES ('3', 'user3', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '钟彬虔', '18630200697', '儿童', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('4', 'user4', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '钟华泽', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('5', 'user5', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '蔺孔文', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('6', 'user6', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '张伟', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('7', 'user7', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '郑士节', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('8', 'test1', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '钟华泽', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('9', 'test2', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '万予楷', '18630200697', '儿童', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('10', 'test3', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '徐治珺', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('11', 'test4', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '家亦玥', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('12', 'test5', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '家凯超', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('13', 'test6', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '万涵光', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('14', 'cc1', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '蔺君婷', '18630200697', '儿童', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('15', 'cc2', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '栾珊瑜', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('16', 'cc3', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '厍姣玲', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('17', 'cc4', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '国弘武', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('18', 'cc5', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '广雨艺', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('19', 'cc7', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '蔺舒新', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('20', 'cc8', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '徐洛仪', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('21', 'cc9', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '栾馨姗', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('22', '路飞', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '海贼王', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('23', '汉库克', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '海贼王', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('24', '佐罗', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '海贼王', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('25', '香吉士', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '海贼王', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('26', '骗人布', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '海贼王', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('27', '娜美', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '海贼王', '18630200697', '军人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('28', '罗宾', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '海贼王', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('29', '弗朗基', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '海贼王', '18630200697', '成人', '2020-03-29 23:52:21');
INSERT INTO `ts_user` VALUES ('30', '特朗普', 'e10adc3949ba59abbe56e057f20f883e', 'testEmail@126.com', '0', '441203196502114231', '自由美利坚', '18630200697', '成人', '2020-03-29 23:52:21');
