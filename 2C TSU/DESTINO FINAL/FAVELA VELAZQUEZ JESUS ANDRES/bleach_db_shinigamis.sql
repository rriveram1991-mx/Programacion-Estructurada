-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: bleach_db
-- ------------------------------------------------------
-- Server version	8.0.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `shinigamis`
--

DROP TABLE IF EXISTS `shinigamis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shinigamis` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `division` int DEFAULT NULL,
  `rango` varchar(50) DEFAULT NULL,
  `reiatsu` int DEFAULT NULL,
  `zanpakuto` varchar(100) DEFAULT NULL,
  `shikai` varchar(100) DEFAULT NULL,
  `bankai` varchar(100) DEFAULT NULL,
  `tecnicas` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shinigamis`
--

LOCK TABLES `shinigamis` WRITE;
/*!40000 ALTER TABLE `shinigamis` DISABLE KEYS */;
INSERT INTO `shinigamis` VALUES (1,'Ichigo Kurosaki',15,'Sustituto',9500,'Zangetsu','Zangetsu doble','Tensa Zangetsu','Getsuga Tensho'),(2,'Rukia Kuchiki',14,'Teniente',8900,'Sode no Shirayuki','Sode no Shirayuki','Haka no Togame','Tsukishiro'),(3,'Isshin Kurosaki',10,'Excapitán',87000,'Engetsu','Engetsu','No alcanzado',NULL),(4,'Sosuke Aizen',5,'Capitán',999999,'Kyoka Suigetsu','Kyoka Suigetsu',NULL,'Hado 90');
/*!40000 ALTER TABLE `shinigamis` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-16 20:59:47
