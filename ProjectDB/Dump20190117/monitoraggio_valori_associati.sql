-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: monitoraggio
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `valori_associati`
--

DROP TABLE IF EXISTS `valori_associati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `valori_associati` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Min_ValueTemperatura` double unsigned NOT NULL,
  `Max_ValueTemperatura` double unsigned NOT NULL,
  `Min_ValuePressione` double unsigned NOT NULL,
  `Max_ValuePressione` double unsigned NOT NULL,
  `Min_ValueUmidita` double unsigned NOT NULL,
  `Max_ValueUmidita` double unsigned NOT NULL,
  `Min_ValueLuminosita` double unsigned NOT NULL,
  `Max_ValueLuminosita` double unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valori_associati`
--

LOCK TABLES `valori_associati` WRITE;
/*!40000 ALTER TABLE `valori_associati` DISABLE KEYS */;
INSERT INTO `valori_associati` VALUES (1,4000,23,1000,1500,30,70,300,300),(2,22,23,1000,1500,30,70,300,800),(3,15,23,1000,1500,30,70,300,800),(4,22,44,1000,1500,30,70,300,800),(5,15,23.5,1000,1500,30,70,300,800),(6,15,23,1000,1500,30,70,300,800),(7,15,23,1000,1500,30,70,300,800),(8,15,23,1000,1500,30,70,300,800),(9,8,23,1000,1500,30,70,300,800),(10,44,23,1000,1500,30,70,300,800);
/*!40000 ALTER TABLE `valori_associati` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-17 19:13:04
