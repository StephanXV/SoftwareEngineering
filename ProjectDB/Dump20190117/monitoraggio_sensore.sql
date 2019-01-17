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
-- Table structure for table `sensore`
--

DROP TABLE IF EXISTS `sensore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sensore` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codice` varchar(16) NOT NULL DEFAULT 'T4',
  `tipo` enum('umidita','pressione','luminosita','temperatura') NOT NULL,
  `stato` int(1) unsigned NOT NULL,
  `ID_Stanza` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `codice` (`codice`),
  KEY `Stanza_sensore` (`ID_Stanza`),
  CONSTRAINT `Stanza_sensore` FOREIGN KEY (`ID_Stanza`) REFERENCES `stanza` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensore`
--

LOCK TABLES `sensore` WRITE;
/*!40000 ALTER TABLE `sensore` DISABLE KEYS */;
INSERT INTO `sensore` VALUES (1,'T1','temperatura',1,1),(2,'P1','pressione',1,1),(3,'L1','luminosita',1,1),(4,'T2','temperatura',1,1),(5,'U2','umidita',1,1),(6,'T12','temperatura',1,2),(7,'P12','pressione',1,2),(8,'L12','luminosita',1,2),(9,'T22','temperatura',1,2),(10,'U22','umidita',1,2),(11,'T13','temperatura',1,3),(12,'P13','pressione',1,3),(13,'L13','luminosita',1,3),(14,'T23','temperatura',1,3),(15,'U23','umidita',1,3),(16,'T14','temperatura',1,4),(17,'P14','pressione',1,4),(18,'L14','luminosita',1,4),(19,'T24','temperatura',1,4),(20,'U24','umidita',1,4),(21,'T15','temperatura',1,5),(22,'P15','pressione',1,5),(23,'L15','luminosita',1,5),(24,'T25','temperatura',1,5),(25,'U25','umidita',1,5),(26,'T16','temperatura',1,6),(27,'P16','pressione',1,6),(28,'L16','luminosita',1,6),(29,'T26','temperatura',1,6),(30,'U26','umidita',1,6),(31,'T17','temperatura',1,7),(32,'P17','pressione',1,7),(33,'L17','luminosita',1,7),(34,'T27','temperatura',1,7),(35,'U27','umidita',1,7),(36,'T18','temperatura',1,8),(37,'P18','pressione',1,8),(38,'L18','luminosita',1,8),(39,'T28','temperatura',1,8),(40,'U28','umidita',1,8),(41,'T19','temperatura',1,9),(42,'P19','pressione',1,9),(43,'L19','luminosita',1,9),(44,'T29','temperatura',1,9),(45,'U29','umidita',1,9),(46,'T110','temperatura',1,10),(47,'P110','pressione',1,10),(48,'L110','luminosita',1,10),(49,'T210','temperatura',1,10),(50,'U210','umidita',1,10);
/*!40000 ALTER TABLE `sensore` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-17 19:13:03
