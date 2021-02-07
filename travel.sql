-- MySQL dump 10.15  Distrib 10.0.38-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: travel
-- ------------------------------------------------------
-- Server version	10.0.38-MariaDB-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attention`
--

DROP TABLE IF EXISTS `attention`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attention` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `adata` datetime NOT NULL COMMENT '关注时间',
  `aattractions_id` int(11) NOT NULL COMMENT '景点编号',
  `abusertable_id` int(11) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`aid`) USING BTREE,
  KEY `attention_attractions_id` (`aattractions_id`) USING BTREE,
  KEY `attention_busertable_id` (`abusertable_id`) USING BTREE,
  CONSTRAINT `attention_attractions_id` FOREIGN KEY (`aattractions_id`) REFERENCES `attractions` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attention_busertable_id` FOREIGN KEY (`abusertable_id`) REFERENCES `busertable` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attention`
--

LOCK TABLES `attention` WRITE;
/*!40000 ALTER TABLE `attention` DISABLE KEYS */;
INSERT INTO `attention` VALUES (2,'2020-02-11 00:00:00',181,182);
/*!40000 ALTER TABLE `attention` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attractions`
--

DROP TABLE IF EXISTS `attractions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attractions` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(50) NOT NULL COMMENT '景区名字',
  `apicture` varchar(255) NOT NULL COMMENT '景区图片',
  `abstract` varchar(255) NOT NULL COMMENT '景区简介',
  `aunitprice` decimal(11,2) NOT NULL COMMENT '单价',
  `acostcontent` varchar(255) NOT NULL COMMENT '费用包含',
  `ascore` varchar(50) NOT NULL COMMENT '点评分数',
  `alabel_id` int(11) DEFAULT NULL COMMENT '外键：标签',
  `acity_id` int(11) NOT NULL COMMENT '外键：所处地点',
  PRIMARY KEY (`aid`) USING BTREE,
  KEY `attractions_city_id` (`acity_id`) USING BTREE,
  KEY `attractions_label_id` (`alabel_id`) USING BTREE,
  CONSTRAINT `attractions_city_id` FOREIGN KEY (`acity_id`) REFERENCES `city` (`cityID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attractions_label_id` FOREIGN KEY (`alabel_id`) REFERENCES `label` (`lid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attractions`
--

LOCK TABLES `attractions` WRITE;
/*!40000 ALTER TABLE `attractions` DISABLE KEYS */;
INSERT INTO `attractions` VALUES (181,'丹霞山','1.jpg','美丽的丹霞山！',100.00,'景点游览、景区公交','8.8',181,33);
/*!40000 ALTER TABLE `attractions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busertable`
--

DROP TABLE IF EXISTS `busertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busertable` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bnumber` varchar(50) NOT NULL COMMENT '账户',
  `bpwd` varchar(50) NOT NULL COMMENT '密码',
  `bname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `bemail` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `rname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `bsex` varchar(50) NOT NULL COMMENT '性别',
  `birthday` datetime NOT NULL COMMENT '出生日期',
  `bphone` varchar(11) NOT NULL COMMENT '手机号码',
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busertable`
--

LOCK TABLES `busertable` WRITE;
/*!40000 ALTER TABLE `busertable` DISABLE KEYS */;
INSERT INTO `busertable` VALUES (182,'YongKJ','1314520','勇往直前kj','dxj1718874198@gmail.com','小军君','男','1998-06-10 00:00:00','15218480260');
/*!40000 ALTER TABLE `busertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `cityID` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(50) NOT NULL,
  `proID` int(11) NOT NULL,
  PRIMARY KEY (`cityName`) USING BTREE,
  KEY `proID` (`proID`) USING BTREE,
  KEY `cityID` (`cityID`) USING BTREE,
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`proID`) REFERENCES `promary` (`proID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (33,'韶关市',2);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label`
--

DROP TABLE IF EXISTS `label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `label` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lname` varchar(10) NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`lid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label`
--

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
INSERT INTO `label` VALUES (181,'热门');
/*!40000 ALTER TABLE `label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membership` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) NOT NULL COMMENT '团费类型名称',
  `mprice` decimal(10,2) NOT NULL COMMENT '不同类型价格',
  `mattractions_id` int(11) NOT NULL COMMENT '景区编号',
  PRIMARY KEY (`mid`) USING BTREE,
  KEY `membership_attractions_id` (`mattractions_id`) USING BTREE,
  CONSTRAINT `membership_attractions_id` FOREIGN KEY (`mattractions_id`) REFERENCES `attractions` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership`
--

LOCK TABLES `membership` WRITE;
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
INSERT INTO `membership` VALUES (180,'学生优惠',30.00,181);
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `oprice` decimal(10,2) NOT NULL COMMENT '订单金额',
  `ostate` varchar(50) NOT NULL COMMENT '订单状态',
  `odata` datetime NOT NULL COMMENT '下单时间',
  `obusertable_id` int(11) NOT NULL COMMENT '外键：用户id',
  PRIMARY KEY (`oid`) USING BTREE,
  KEY `order_attractions_id` (`obusertable_id`) USING BTREE,
  CONSTRAINT `order_attractions_id` FOREIGN KEY (`obusertable_id`) REFERENCES `busertable` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (181,30.00,'已付款','2020-02-11 00:00:00',182);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetails` (
  `number` int(11) NOT NULL COMMENT '购买数量',
  `dattractions_id` int(11) NOT NULL,
  `dorder_id` int(11) NOT NULL,
  KEY `orderdetails_order_id` (`dorder_id`) USING BTREE,
  KEY `orderdetails_attractions_id` (`dattractions_id`) USING BTREE,
  CONSTRAINT `orderdetails_attractions_id` FOREIGN KEY (`dattractions_id`) REFERENCES `attractions` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderdetails_order_id` FOREIGN KEY (`dorder_id`) REFERENCES `order` (`oid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES (5,181,181);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promary`
--

DROP TABLE IF EXISTS `promary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promary` (
  `proID` int(11) NOT NULL AUTO_INCREMENT,
  `proName` varchar(50) NOT NULL,
  PRIMARY KEY (`proID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promary`
--

LOCK TABLES `promary` WRITE;
/*!40000 ALTER TABLE `promary` DISABLE KEYS */;
INSERT INTO `promary` VALUES (2,'广东省');
/*!40000 ALTER TABLE `promary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strategy`
--

DROP TABLE IF EXISTS `strategy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strategy` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `stitle` varchar(50) NOT NULL COMMENT '博客标题',
  `stext` varchar(1000) NOT NULL COMMENT '博客内容',
  `sdatatime` datetime NOT NULL COMMENT '博客发布时间',
  `splace` varchar(255) NOT NULL COMMENT '博客发布地点',
  `sreading` varchar(255) NOT NULL COMMENT '博客阅读量',
  `sbusertable_id` int(11) NOT NULL COMMENT '外键：用户id',
  PRIMARY KEY (`sid`) USING BTREE,
  KEY `strategy_busertable_id` (`sbusertable_id`) USING BTREE,
  CONSTRAINT `strategy_busertable_id` FOREIGN KEY (`sbusertable_id`) REFERENCES `busertable` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strategy`
--

LOCK TABLES `strategy` WRITE;
/*!40000 ALTER TABLE `strategy` DISABLE KEYS */;
INSERT INTO `strategy` VALUES (2,'丹霞山','美丽的丹霞山！','2020-02-11 00:00:00','韶关','10',182);
/*!40000 ALTER TABLE `strategy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userevaluation`
--

DROP TABLE IF EXISTS `userevaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userevaluation` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uevaluationtext` varchar(255) NOT NULL COMMENT '评价的内容文本',
  `upictuer` varchar(255) DEFAULT NULL COMMENT '上传的图片',
  `udata` datetime NOT NULL COMMENT '发表日期',
  `uattractions_id` int(11) NOT NULL COMMENT '景点编号',
  `ubusertable_id` int(11) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`uid`) USING BTREE,
  KEY `userevaluation_attractions_id` (`uattractions_id`) USING BTREE,
  KEY `userevaluation_busertable_id` (`ubusertable_id`) USING BTREE,
  CONSTRAINT `userevaluation_attractions_id` FOREIGN KEY (`uattractions_id`) REFERENCES `attractions` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userevaluation_busertable_id` FOREIGN KEY (`ubusertable_id`) REFERENCES `busertable` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userevaluation`
--

LOCK TABLES `userevaluation` WRITE;
/*!40000 ALTER TABLE `userevaluation` DISABLE KEYS */;
INSERT INTO `userevaluation` VALUES (181,'风景秀丽！','丹霞山.jpg','2020-02-11 00:00:00',181,182);
/*!40000 ALTER TABLE `userevaluation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-04 12:01:12
