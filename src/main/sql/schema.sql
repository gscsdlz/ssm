-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 2018-09-25 05:40:44
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `account`
--

INSERT INTO `account` (`account_id`, `username`, `password`, `act`, `created_at`, `updated_at`) VALUES
(1, 'admin', '7c4a8d09ca3762af61e59520943dc26494f8941b', 1, '2018-09-19 20:41:52', '2018-09-19 20:41:52'),
(2, 'root', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 2, '2018-09-19 20:43:19', '2018-09-19 20:43:19');

-- --------------------------------------------------------

--
-- 表的结构 `alarm`
--

DROP TABLE IF EXISTS `alarm`;
CREATE TABLE IF NOT EXISTS `alarm` (
  `alarm_id` int(11) NOT NULL AUTO_INCREMENT,
  `warning_id` int(11) NOT NULL,
  `value` float NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `handle` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`alarm_id`),
  KEY `warning_id` (`warning_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `elder_user`
--

DROP TABLE IF EXISTS `elder_user`;
CREATE TABLE IF NOT EXISTS `elder_user` (
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `main_menu`
--

INSERT INTO `main_menu` (`main_id`, `main_name`, `icon`, `type`) VALUES
(1, '健康监测', '', 1),
(2, '健康监护', '', 1),
(3, '健康档案', '', 1),
(4, '亲人关怀', '', 1),
(5, '家庭医生', '', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `menu`
--

INSERT INTO `menu` (`menu_id`, `name`, `uri`, `main_id`) VALUES
(1, '血压指标', '/health_data/blood_pressure', 1),
(2, '血糖指标', '/health_data/blood_sugar', 1),
(3, '身高体重指标', '/health_data/height_weight', 1),
(4, '地图定位', '/health_monitor/position', 2),
(5, '异常指标', '', 2),
(6, '预警设置', '/health_monitor/warning_set', 2),
(7, '提醒设置', '', 2),
(8, '个人档案', '', 3),
(9, '门诊病历', '', 3),
(10, '检验项目', '', 3),
(11, '用药记录', '', 3),
(12, '健康档案调阅申请', '', 4),
(13, '健康档案调阅授权', '', 4),
(14, '健康档案查询', '', 4),
(15, '医生专家库', '', 5),
(16, '我的咨询', '', 5);

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
-- 表的结构 `warning`
--

DROP TABLE IF EXISTS `warning`;
CREATE TABLE IF NOT EXISTS `warning` (
  `warning_id` int(11) NOT NULL AUTO_INCREMENT,
  `key_name` varchar(10) NOT NULL,
  `min_val` float NOT NULL,
  `max_val` float NOT NULL,
  `account_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`warning_id`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `warning`
--

INSERT INTO `warning` (`warning_id`, `key_name`, `min_val`, `max_val`, `account_id`, `created_at`) VALUES
(3, 'height', 50, 55, 1, '2018-09-24 18:33:14');

--
-- 限制导出的表
--

--
-- 限制表 `alarm`
--
ALTER TABLE `alarm`
  ADD CONSTRAINT `alarm_warning` FOREIGN KEY (`warning_id`) REFERENCES `warning` (`warning_id`);

--
-- 限制表 `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_main_id_FK` FOREIGN KEY (`main_id`) REFERENCES `menu` (`menu_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
