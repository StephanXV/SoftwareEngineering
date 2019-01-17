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
-- Table structure for table `valore`
--

DROP TABLE IF EXISTS `valore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `valore` (
  `ID_Sensore` int(10) unsigned NOT NULL,
  `valore_percepito` double(10,2) NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_Sensore`),
  CONSTRAINT `valore_sensore` FOREIGN KEY (`ID_Sensore`) REFERENCES `sensore` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valore`
--

LOCK TABLES `valore` WRITE;
/*!40000 ALTER TABLE `valore` DISABLE KEYS */;
INSERT INTO `valore` VALUES (1,22.00,'2019-01-16 14:29:56'),(2,1100.00,'2019-01-16 14:28:52'),(3,400.00,'2019-01-16 14:25:49'),(4,22.00,'2019-01-16 14:29:56'),(5,60.00,'2019-01-16 14:30:25'),(6,22.00,'2019-01-16 14:29:57'),(7,1200.00,'2019-01-16 14:28:52'),(8,193.18,'2019-01-16 14:25:49'),(9,24.84,'2019-01-16 14:29:57'),(10,10.54,'2019-01-16 14:30:26'),(11,34.46,'2019-01-16 14:29:57'),(12,1788.15,'2019-01-16 14:28:52'),(13,744.72,'2019-01-16 14:25:49'),(14,11.82,'2019-01-16 14:29:57'),(15,45.95,'2019-01-16 14:30:26'),(16,5.64,'2019-01-16 14:29:57'),(17,1295.94,'2019-01-16 14:28:53'),(18,799.77,'2019-01-16 14:25:52'),(19,8.76,'2019-01-16 14:30:01'),(20,12.83,'2019-01-16 14:30:27'),(21,8.58,'2019-01-16 14:30:01'),(22,1109.36,'2019-01-16 14:28:56'),(23,676.72,'2019-01-16 14:25:54'),(24,30.25,'2019-01-16 14:30:01'),(25,17.59,'2019-01-16 14:30:29'),(26,1.23,'2019-01-16 14:30:02'),(27,1565.45,'2019-01-16 14:28:57'),(28,692.83,'2019-01-16 14:25:56'),(29,0.43,'2019-01-16 14:30:03'),(30,25.31,'2019-01-16 14:29:02'),(31,12.81,'2019-01-16 14:30:03'),(32,2511.61,'2019-01-16 14:28:58'),(33,279.12,'2019-01-16 14:25:56'),(34,5.42,'2019-01-16 14:30:03'),(35,94.92,'2019-01-16 14:29:02'),(36,15.36,'2019-01-16 14:30:04'),(37,2753.50,'2019-01-16 14:29:00'),(38,9.68,'2019-01-16 14:25:57'),(39,17.64,'2019-01-16 14:30:04'),(40,36.89,'2019-01-16 14:29:02'),(41,16.59,'2019-01-16 14:30:05'),(42,1575.47,'2019-01-16 14:29:02'),(43,626.51,'2019-01-16 14:25:59'),(44,1.81,'2019-01-16 14:30:09'),(45,56.52,'2019-01-16 14:29:03'),(46,25.89,'2019-01-16 14:30:09'),(47,2592.46,'2019-01-16 14:29:03'),(48,688.47,'2019-01-16 14:26:00'),(49,4.72,'2019-01-16 14:30:10'),(50,94.52,'2019-01-16 14:29:05');
/*!40000 ALTER TABLE `valore` ENABLE KEYS */;
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
