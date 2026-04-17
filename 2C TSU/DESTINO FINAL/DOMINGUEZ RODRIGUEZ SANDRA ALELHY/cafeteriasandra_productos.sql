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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idproductos` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `categoria` varchar(30) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`idproductos`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (2,'Té Verde','Bebida',20.00,40),(3,'Sandwich de Pollo','Comida',45.00,30),(4,'Pastel de Chocolate','Postre',60.00,20),(5,'Jugo de Naranja','Bebida',22.00,35),(6,'Café Americano','Bebida',25.00,50),(7,'Té Verde','Bebida',20.00,40),(8,'Sandwich de Pollo','Comida',45.00,30),(9,'Pastel de Chocolate','Postre',60.00,20),(10,'Jugo de Naranja','Bebida',22.00,35),(11,'Café Americano','Bebida',25.00,50),(12,'Té Verde','Bebida',20.00,40),(13,'Sandwich de Pollo','Comida',45.00,30),(14,'Pastel de Chocolate','Postre',60.00,20),(15,'Jugo de Naranja','Bebida',22.00,35),(16,'Café Americano','Bebida',25.00,50),(17,'Té Verde','Bebida',20.00,40),(18,'Sandwich de Pollo','Comida',45.00,30),(19,'Pastel de Chocolate','Postre',60.00,20),(20,'Jugo de Naranja','Bebida',22.00,35),(21,'Café Americano','Bebida',25.00,50),(22,'Té Verde','Bebida',20.00,40),(23,'Sandwich de Pollo','Comida',45.00,30),(24,'Pastel de Chocolate','Postre',60.00,20),(25,'Jugo de Naranja','Bebida',22.00,35),(26,'Capuchino','Bebida',45.00,20),(27,'Capuchino','Bebida',45.00,20),(28,'Café Americano','Bebida',25.00,50),(29,'Té Verde','Bebida',20.00,40),(30,'Sandwich de Pollo','Comida',45.00,30),(31,'Pastel de Chocolate','Postre',60.00,20),(32,'Jugo de Naranja','Bebida',22.00,35),(33,'Café Americano','Bebida',25.00,50),(34,'Té Verde','Bebida',20.00,40),(35,'Sandwich de Pollo','Comida',45.00,30),(36,'Pastel de Chocolate','Postre',60.00,20),(37,'Jugo de Naranja','Bebida',22.00,35),(38,'Café Americano','Bebida',25.00,50),(39,'Té Verde','Bebida',20.00,40),(40,'Sandwich de Pollo','Comida',45.00,30),(41,'Pastel de Chocolate','Postre',60.00,20),(42,'Jugo de Naranja','Bebida',22.00,35),(43,'Capuchino','Bebida',45.00,20),(44,'Café Americano','Bebida',25.00,50),(45,'Té Verde','Bebida',20.00,40),(46,'Sandwich de Pollo','Comida',45.00,30),(47,'Pastel de Chocolate','Postre',60.00,20),(48,'Jugo de Naranja','Bebida',22.00,35),(49,'Café Americano','Bebida',25.00,50),(50,'Té Verde','Bebida',20.00,40),(51,'Sandwich de Pollo','Comida',45.00,30),(52,'Pastel de Chocolate','Postre',60.00,20),(53,'Jugo de Naranja','Bebida',22.00,35),(54,'Capuchino','Bebida',45.00,20),(55,'Café Americano','Bebida',25.00,50),(56,'Té Verde','Bebida',20.00,40),(57,'Sandwich de Pollo','Comida',45.00,30),(58,'Pastel de Chocolate','Postre',60.00,20),(59,'Jugo de Naranja','Bebida',22.00,35),(60,'Capuchino','Bebida',45.00,20),(61,'Capuchino','Bebida',45.00,20);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
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
