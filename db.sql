-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: calculator
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `fooditem`
--

DROP TABLE IF EXISTS `fooditem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fooditem` (
  `foodname` varchar(50) NOT NULL,
  `calorie` float DEFAULT NULL,
  `fat` float DEFAULT NULL,
  `carbs` float DEFAULT NULL,
  `protien` float DEFAULT NULL,
  PRIMARY KEY (`foodname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fooditem`
--

LOCK TABLES `fooditem` WRITE;
/*!40000 ALTER TABLE `fooditem` DISABLE KEYS */;
INSERT INTO `fooditem` VALUES ('aloo sabji',96,2.89,17.52,2.34),('boiled rice',129,0.28,28,2.67),('cabbage poriyal',71,3.9,9.8,2.5),('carrot beans poriyal',100,9,3,2),('channa dal',160,2.14,26.49,9.98),('chappathi',282,6.5,48,8),('chicken 65',88,3,5,11),('chicken briyani',123,1.4,36.4,27),('chicken gravy',381,9.73,62.9,11.27),('coconut chutney',349,33.2,13.58,3.58),('coconut milk',218.5,22.1,1.7,2.1),('curd rice',130,3.84,18.07,5.73),('dosa',212,2.07,42.48,5.03),('fish curry',100,4.59,1.9,2.4),('fish fry',210,11.36,7.81,18.29),('idiyappam',225,1.35,48.42,3.6),('idly',135,0.62,26.31,6.36),('kichadi',116,1.19,22.85,4.08),('lemon rice',146,0.55,31.48,3),('mango pickle',202,10.6,23.7,2.7),('mutton briyani',141,4.34,19.26,5.84),('mutton gravy',131,5.4,2.09,17.62),('naan',259,7,50,8),('panner butter masala',229,19.4,9,8.8),('papad',31,0.3,5.4,1.9),('paratha',325,11.4,48.67,6.45),('pongal',70,1.71,11.9,1.88),('poori',296,9.43,46.73,7.55),('potato fry',125,3.3,22.1,2.4),('prawn gravy',101,3.46,2.43,14.4),('pulikuzhambu',77,6,5,1),('rasam',19,0.88,2.82,0.39),('sambhar',170,5,13.5,5),('sambhar rice',65,1,12,2),('sweet pongal',131,2.43,25.17,2.75),('tamarind rice',150,3.4,27.15,2.85),('tomato rice',150,3.81,18.56,1.98),('uppma',209,3.15,38.06,6.76),('vada',309,10.02,42.17,13.75),('veg fried rice',162,4.9,24.4,5),('veg noodles',373,1,81.2,11.7),('veg pulao',155,6.5,21,3);
/*!40000 ALTER TABLE `fooditem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('abc','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'calculator'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-13 19:57:41
