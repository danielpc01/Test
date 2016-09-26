-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: tracking
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `constants`
--

DROP TABLE IF EXISTS `constants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `constants` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FATHER_ID` int(11) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `VALUE1` varchar(255) DEFAULT NULL,
  `VALUE2` varchar(255) DEFAULT NULL,
  `VALUE3` varchar(255) DEFAULT NULL,
  `CREATED_BY` int(11) NOT NULL,
  `DATE_CREATED` datetime DEFAULT NULL,
  `UPDATED_BY` int(11) DEFAULT NULL,
  `DATE_UPDATED` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `constants`
--

LOCK TABLES `constants` WRITE;
/*!40000 ALTER TABLE `constants` DISABLE KEYS */;
INSERT INTO `constants` VALUES (1,0,'LOG TYPE','1',NULL,NULL,1,'2016-09-23 00:00:00',NULL,NULL),(2,1,'INFO','1','message',NULL,1,'2016-09-23 00:00:00',NULL,NULL),(3,1,'ERROR','2','error',NULL,1,'2016-09-23 00:00:00',NULL,NULL),(4,1,'WARNING','3','warning',NULL,1,'2016-09-23 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `constants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_tracking`
--

DROP TABLE IF EXISTS `log_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_tracking` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MESSAGE` text,
  `MESSAGE_TYPE` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) NOT NULL,
  `DATE_CREATED` datetime DEFAULT NULL,
  `UPDATED_BY` int(11) DEFAULT NULL,
  `DATE_UPDATED` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MESSAGE_TYPE_idx` (`MESSAGE_TYPE`),
  CONSTRAINT `FK_MESSAGE_TYPE` FOREIGN KEY (`MESSAGE_TYPE`) REFERENCES `constants` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_tracking`
--

LOCK TABLES `log_tracking` WRITE;
/*!40000 ALTER TABLE `log_tracking` DISABLE KEYS */;
INSERT INTO `log_tracking` VALUES (1,'1aaaa',3,1,'2016-09-26 11:07:22',NULL,NULL),(2,'message 26 de septiembre de 2016 1aaaa',3,1,'2016-09-26 11:26:42',NULL,NULL),(3,'error 26 de septiembre de 2016 1aaaa',3,1,'2016-09-26 11:28:51',NULL,NULL);
/*!40000 ALTER TABLE `log_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tracking'
--

--
-- Dumping routines for database 'tracking'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-26 12:27:02
