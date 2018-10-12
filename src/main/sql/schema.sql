-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 2018-10-12 15:20:09
-- 服务器版本： 5.7.19
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- 表的结构 `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(40) NOT NULL,
  `act` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `account`
--

INSERT INTO `account` (`account_id`, `username`, `password`, `act`, `created_at`, `updated_at`) VALUES
                                                                                                       (1, 'admin', '7c4a8d09ca3762af61e59520943dc26494f8941b', 1, '2018-09-19 20:41:52', '2018-09-19 20:41:52'),
                                                                                                       (2, 'root', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 2, '2018-09-19 20:43:19', '2018-09-19 20:43:19'),
                                                                                                       (3, 'doctor', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 2, '2018-09-27 20:03:42', '2018-09-27 20:03:42');

-- --------------------------------------------------------

--
-- 表的结构 `alarm`
--

DROP TABLE IF EXISTS `alarm`;
CREATE TABLE IF NOT EXISTS `alarm` (
  `alarm_id` int(11) NOT NULL AUTO_INCREMENT,
  `warning_id` int(11) NOT NULL,
  `health_value` float NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `handle` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`alarm_id`),
  KEY `warning_id` (`warning_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `alarm`
--

INSERT INTO `alarm` (`alarm_id`, `warning_id`, `health_value`, `created_at`, `handle`) VALUES
                                                                                              (3, 5, 123, '2018-09-25 20:47:04', 1),
                                                                                              (6, 3, 177.3, '2018-09-27 21:58:04', 0);

-- --------------------------------------------------------

--
-- 表的结构 `check_history`
--

DROP TABLE IF EXISTS `check_history`;
CREATE TABLE IF NOT EXISTS `check_history` (
  `ch_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `hospital_name` varchar(100) NOT NULL,
  `section` varchar(100) NOT NULL,
  `check_name` varchar(100) NOT NULL,
  `check_reason` varchar(100) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ch_id`),
  KEY `doctor_id` (`doctor_id`),
  KEY `account_id` (`account_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `check_history`
--

INSERT INTO `check_history` (`ch_id`, `account_id`, `hospital_name`, `section`, `check_name`, `check_reason`, `doctor_id`, `created_at`) VALUES
                                                                                                                                                (1, 1, '郫县人民医院', '骨科', '骨质疏松', '诊断骨质', 3, '2018-09-27 20:36:00');

-- --------------------------------------------------------

--
-- 表的结构 `doctor_user`
--

DROP TABLE IF EXISTS `doctor_user`;
CREATE TABLE IF NOT EXISTS `doctor_user` (
  `account_id` int(11) NOT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `icon` varchar(30) DEFAULT NULL,
  `gender` int(11) DEFAULT '0',
  `birth` date DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `doctor_user`
--

INSERT INTO `doctor_user` (`account_id`, `realname`, `phone`, `address`, `icon`, `gender`, `birth`, `created_at`, `updated_at`) VALUES
                                                                                                                                       (3, '胡康玲', '18181818181', '四川省成都市', NULL, 0, '1968-09-10', '2018-09-27 20:04:35', '2018-09-27 20:04:35');

-- --------------------------------------------------------

--
-- 表的结构 `drug_history`
--

DROP TABLE IF EXISTS `drug_history`;
CREATE TABLE IF NOT EXISTS `drug_history` (
  `dh_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `hospital_name` varchar(100) NOT NULL,
  `drug_name` varchar(100) NOT NULL,
  `total_size` varchar(100) NOT NULL,
  `once_size` varchar(100) NOT NULL,
  `unit` varchar(100) NOT NULL,
  `status` int(11) NOT NULL,
  `drug_type` varchar(100) NOT NULL,
  `type_detail` varchar(100) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`dh_id`),
  KEY `doctor_id` (`doctor_id`),
  KEY `account_id` (`account_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `drug_history`
--

INSERT INTO `drug_history` (`dh_id`, `account_id`, `hospital_name`, `drug_name`, `total_size`, `once_size`, `unit`, `status`, `drug_type`, `type_detail`, `doctor_id`, `created_at`) VALUES
                                                                                                                                                                                            (1, 1, '四川省肿瘤医院', '益赛普', '10只/每盒', '每次25毫克，皮下注射', '25毫克/每只', 1, '西药', '败血症', 3, '2018-09-27 20:52:17');

-- --------------------------------------------------------

--
-- 表的结构 `elder_user`
--

DROP TABLE IF EXISTS `elder_user`;
CREATE TABLE IF NOT EXISTS `elder_user` (
  `account_id` int(11) NOT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `gender` int(11) DEFAULT '0',
  `age` int(11) DEFAULT '60',
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `id_card` varchar(30) DEFAULT NULL,
  `ss_id` varchar(30) DEFAULT NULL,
  `has_allergy` tinyint(1) NOT NULL DEFAULT '0',
  `has_trauma` tinyint(1) NOT NULL DEFAULT '0',
  `has_operation` tinyint(1) NOT NULL DEFAULT '0',
  `has_inheritance` tinyint(1) NOT NULL DEFAULT '0',
  `icon` varchar(30) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `elder_user`
--

INSERT INTO `elder_user` (`account_id`, `realname`, `gender`, `age`, `address`, `phone`, `id_card`, `ss_id`, `has_allergy`, `has_trauma`, `has_operation`, `has_inheritance`, `icon`, `created_at`, `updated_at`) VALUES
                                                                                                                                                                                                                         (1, '测试1', 1, 70, '北京市·朝阳区·哒哒哒哒哒?', '12345678920', '12345678998765432', '12345678998765432', 0, 0, 1, 0, NULL, '2018-10-08 19:52:11', '2018-10-08 19:52:11'),
                                                                                                                                                                                                                         (2, '测试2', 1, 70, '四川·成都', '12345678920', '12345678998765432', '12345678998765432', 1, 0, 1, 0, NULL, '2018-10-08 19:52:11', '2018-10-08 19:52:11');

-- --------------------------------------------------------

--
-- 表的结构 `health_data`
--

DROP TABLE IF EXISTS `health_data`;
CREATE TABLE IF NOT EXISTS `health_data` (
  `data_id` int(11) NOT NULL AUTO_INCREMENT,
  `data` varchar(1000) NOT NULL,
  `account_id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`data_id`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `health_data`
--

INSERT INTO `health_data` (`data_id`, `data`, `account_id`, `type`, `created_at`) VALUES
                                                                                         (1, '{\"systolic\": 123,\"diastolic\": 67,\"pulse\": 80}', 1, 1, '2018-09-24'),
                                                                                         (2, '{\"value\":3.5,\"duration\":8}', 1, 2, '2018-09-23'),
                                                                                         (3, '{\"value\":3.6,\"duration\":8}', 1, 2, '2018-09-24'),
                                                                                         (4, '{\"height\":177.3,\"weight\":45, \"bmi\":23}', 1, 3, '2018-09-24');

-- --------------------------------------------------------

--
-- 表的结构 `main_menu`
--

DROP TABLE IF EXISTS `main_menu`;
CREATE TABLE IF NOT EXISTS `main_menu` (
  `main_id` int(11) NOT NULL AUTO_INCREMENT,
  `main_name` varchar(20) NOT NULL,
  `icon` varchar(20) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`main_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `main_menu`
--

INSERT INTO `main_menu` (`main_id`, `main_name`, `icon`, `type`) VALUES
                                                                        (1, '健康监测', '', 1),
                                                                        (2, '健康监护', '', 1),
                                                                        (3, '健康档案', '', 1),
                                                                        (4, '亲人关怀', '', 1),
                                                                        (5, '家庭医生', '', 1),
                                                                        (6, '咨询问题', '', 2),
                                                                        (7, '医生评估', '', 2),
                                                                        (8, '老人信息', '', 3),
                                                                        (9, '告警信息', '', 3),
                                                                        (10, '地图定位', '', 3),
                                                                        (11, '档案管理', '', 4),
                                                                        (12, '工单管理', '', 4),
                                                                        (13, '投诉管理', '', 4),
                                                                        (14, '预警管理', '', 4),
                                                                        (15, '基础数据', '', 5),
                                                                        (16, '调度过程', '', 5),
                                                                        (17, '决策分析', '', 5),
                                                                        (18, '个体预警', '', 5);

-- --------------------------------------------------------

--
-- 表的结构 `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `uri` varchar(100) NOT NULL,
  `main_id` int(11) NOT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `main_id` (`main_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `menu`
--

INSERT INTO `menu` (`menu_id`, `name`, `uri`, `main_id`) VALUES
                                                                (1, '血压指标', '/health_data/blood_pressure', 1),
                                                                (2, '血糖指标', '/health_data/blood_sugar', 1),
                                                                (3, '身高体重指标', '/health_data/height_weight', 1),
                                                                (4, '地图定位', '/health_monitor/position', 2),
                                                                (5, '异常指标', '/health_monitor/alarm_show', 2),
                                                                (6, '预警设置', '/health_monitor/warning_set', 2),
                                                                (7, '提醒设置', '/health_monitor/notice_show', 2),
                                                                (8, '个人档案', '/health_history/me', 3),
                                                                (9, '门诊病历', '/health_history/sick_history', 3),
                                                                (10, '检验项目', '/health_history/check_history', 3),
                                                                (11, '用药记录', '/health_history/drug_history', 3),
                                                                (12, '健康档案调阅申请', '/record_auth/apply', 4),
                                                                (13, '健康档案调阅授权', '/record_auth/invoke', 4),
                                                                (14, '健康档案查询', '/record_auth/show', 4),
                                                                (15, '医生专家库', '', 5),
                                                                (16, '我的咨询', '', 5),
                                                                (17, '查看详情', '', 6),
                                                                (18, '查看详情', '', 7),
                                                                (19, '亲人档案', '', 8),
                                                                (20, '异常指标信息', '', 9),
                                                                (21, '老人定位', '', 10),
                                                                (22, '老人档案', '', 11),
                                                                (23, '家庭医生', '', 11),
                                                                (24, '老人定位', '', 11),
                                                                (25, '工单信息', '', 12),
                                                                (26, '工单处理', '', 12),
                                                                (27, '待处投诉', '', 13),
                                                                (28, '已处理投诉', '', 13),
                                                                (29, '总投诉量', '', 13),
                                                                (30, '基础数据统计', '', 15),
                                                                (31, '老人档案', '', 15),
                                                                (32, '医生档案', '', 15),
                                                                (33, '养老院档案', '', 15),
                                                                (34, '查看详情', '', 16),
                                                                (35, '查看详情', '', 17),
                                                                (36, '查看详情', '', 18);

-- --------------------------------------------------------

--
-- 表的结构 `notice`
--

DROP TABLE IF EXISTS `notice`;
CREATE TABLE IF NOT EXISTS `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_type` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `frequency` varchar(10) NOT NULL,
  `last` datetime NOT NULL,
  PRIMARY KEY (`notice_id`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `notice`
--

INSERT INTO `notice` (`notice_id`, `notice_type`, `account_id`, `start`, `end`, `frequency`, `last`) VALUES
                                                                                                            (1, 2, 1, '2018-09-27 00:00:00', '2018-09-29 13:30:00', '2:2', '2018-09-18 00:00:00'),
                                                                                                            (3, 1, 1, '2018-09-18 00:00:00', '2018-09-29 13:30:00', '2:5', '2018-09-18 00:00:00');

-- --------------------------------------------------------

--
-- 表的结构 `position`
--

DROP TABLE IF EXISTS `position`;
CREATE TABLE IF NOT EXISTS `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `gps_data` varchar(1000) NOT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `position`
--

INSERT INTO `position` (`id`, `account_id`, `gps_data`, `created_at`) VALUES
                                                                             (1, 1, '[{\"longitude\":113.56,\"latitude\":34.5666},{\"longitude\":113.86,\"latitude\":34.5666},{\"longitude\":113.57,\"latitude\":35.5666}]', '2018-09-24');

-- --------------------------------------------------------

--
-- 表的结构 `record_authorization`
--

DROP TABLE IF EXISTS `record_authorization`;
CREATE TABLE IF NOT EXISTS `record_authorization` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` int(11) NOT NULL,
  `to_id` int(11) NOT NULL,
  `stat` int(11) NOT NULL DEFAULT '0',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`record_id`),
  UNIQUE KEY `from_id_2` (`from_id`,`to_id`),
  KEY `from_id` (`from_id`),
  KEY `to_id` (`to_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `record_authorization`
--

INSERT INTO `record_authorization` (`record_id`, `from_id`, `to_id`, `stat`, `updated_at`, `created_at`) VALUES
                                                                                                                (1, 1, 2, 1, '2018-10-12 20:37:55', '2018-10-12 20:37:55'),
                                                                                                                (2, 2, 1, 1, '2018-10-12 20:37:55', '2018-10-12 20:37:55');

-- --------------------------------------------------------

--
-- 表的结构 `sick_history`
--

DROP TABLE IF EXISTS `sick_history`;
CREATE TABLE IF NOT EXISTS `sick_history` (
  `sh_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `hospital_name` varchar(100) NOT NULL,
  `section` varchar(100) NOT NULL,
  `result` varchar(100) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `method` varchar(100) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sh_id`),
  KEY `account_id` (`account_id`),
  KEY `doctor_id` (`doctor_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `sick_history`
--

INSERT INTO `sick_history` (`sh_id`, `account_id`, `hospital_name`, `section`, `result`, `doctor_id`, `method`, `created_at`) VALUES
                                                                                                                                     (1, 1, '成都军区机关医院', '口腔科', '口腔溃疡', 3, '镇痛防感染', '2018-09-27 20:03:10');

-- --------------------------------------------------------

--
-- 表的结构 `warning`
--

DROP TABLE IF EXISTS `warning`;
CREATE TABLE IF NOT EXISTS `warning` (
  `warning_id` int(11) NOT NULL AUTO_INCREMENT,
  `key_name` varchar(10) NOT NULL,
  `min_val` float NOT NULL,
  `max_val` float NOT NULL,
  `used` int(11) NOT NULL DEFAULT '0',
  `account_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`warning_id`),
  UNIQUE KEY `uni_account_type` (`account_id`,`key_name`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `warning`
--

INSERT INTO `warning` (`warning_id`, `key_name`, `min_val`, `max_val`, `used`, `account_id`, `created_at`) VALUES
                                                                                                                  (3, 'height', 165, 175, 1, 1, '2018-09-24 18:33:14'),
                                                                                                                  (5, 'systolic', 100, 120, 1, 1, '2018-09-25 20:47:03'),
                                                                                                                  (8, 'diastolic', 60, 70, 0, 1, '2018-09-25 20:56:02');

--
-- 限制导出的表
--

--
-- 限制表 `alarm`
--
ALTER TABLE `alarm`
  ADD CONSTRAINT `alarm_warning` FOREIGN KEY (`warning_id`) REFERENCES `warning` (`warning_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_main_id_FK` FOREIGN KEY (`main_id`) REFERENCES `main_menu` (`main_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
