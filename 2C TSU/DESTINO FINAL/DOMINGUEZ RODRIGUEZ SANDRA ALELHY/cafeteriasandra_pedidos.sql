CREATE DATABASE  IF NOT EXISTS `cafeteriasandra` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cafeteriasandra`;
-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: cafeteriasandra
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
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `idpedidos` int NOT NULL AUTO_INCREMENT,
  `cliente` varchar(50) NOT NULL,
  `producto_id` int NOT NULL,
  `cantidad` int NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idpedidos`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'Sandra',1,2,'2026-04-16'),(2,'Eduardo',3,1,'2026-04-16'),(3,'Alelhy',5,4,'2026-04-16'),(4,'Sandra',1,2,'2026-04-16'),(5,'Eduardo',3,1,'2026-04-16'),(6,'Alelhy',5,4,'2026-04-16'),(7,'Sandra',1,2,'2026-04-16'),(8,'Eduardo',3,1,'2026-04-16'),(9,'Alelhy',5,4,'2026-04-16'),(10,'Sandra',1,2,'2026-04-16'),(11,'Eduardo',3,1,'2026-04-16'),(12,'Alelhy',5,4,'2026-04-16'),(13,'Sandra',1,2,'2026-04-16'),(14,'Eduardo',3,1,'2026-04-16'),(15,'Alelhy',5,4,'2026-04-16'),(16,'Sandra',1,2,'2026-04-16'),(17,'Eduardo',3,1,'2026-04-16'),(18,'Alelhy',5,4,'2026-04-16'),(19,'Sandra',1,2,'2026-04-16'),(20,'Eduardo',3,1,'2026-04-16'),(21,'Alelhy',5,4,'2026-04-16'),(22,'Sandra',1,2,'2026-04-16'),(23,'Eduardo',3,1,'2026-04-16'),(24,'Alelhy',5,4,'2026-04-16'),(25,'Sandra',1,2,'2026-04-16'),(26,'Eduardo',3,1,'2026-04-16'),(27,'Alelhy',5,4,'2026-04-16');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-17  4:00:38
