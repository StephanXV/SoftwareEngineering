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
-- Table structure for table `stanza`
--

DROP TABLE IF EXISTS `stanza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stanza` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(16) NOT NULL,
  `piano` int(10) unsigned NOT NULL,
  `ID_ValoriAssociati` int(10) unsigned NOT NULL,
  `priorita` enum('low','medium','high') NOT NULL,
  `allerta` int(1) unsigned NOT NULL DEFAULT '0',
  `ID_edificio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Stanza_Valori` (`ID_ValoriAssociati`),
  KEY `Stanza_Edificio` (`ID_edificio`),
  CONSTRAINT `Stanza_Edificio` FOREIGN KEY (`ID_edificio`) REFERENCES `edificio` (`id`),
  CONSTRAINT `Stanza_Valori` FOREIGN KEY (`ID_ValoriAssociati`) REFERENCES `valori_associati` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stanza`
--

LOCK TABLES `stanza` WRITE;
/*!40000 ALTER TABLE `stanza` DISABLE KEYS */;
INSERT INTO `stanza` VALUES (1,'a1.6',1,1,'low',0,1),(2,'a1.7',1,2,'low',0,1),(3,'a1.8',1,3,'low',0,1),(4,'a1.9',1,4,'low',0,1),(5,'a1.10',1,5,'low',0,1),(6,'a2.0',2,6,'low',0,1),(7,'a2.1',2,7,'low',0,1),(8,'a2.2',2,8,'low',0,1),(9,'a2.3',2,9,'low',0,1),(10,'a2.4',2,10,'low',0,1);
/*!40000 ALTER TABLE `stanza` ENABLE KEYS */;
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
