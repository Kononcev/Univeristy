-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: university
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `lectors`
--

DROP TABLE IF EXISTS `lectors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lectors` (
  `lectors_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `salary` int(11) NOT NULL,
  `degree_id` int(11) NOT NULL,
  PRIMARY KEY (`lectors_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lectors`
--

LOCK TABLES `lectors` WRITE;
/*!40000 ALTER TABLE `lectors` DISABLE KEYS */;
INSERT INTO `lectors` VALUES (1,1,'Ivan','Petrov',300,2),(2,2,'Sergiy','Bogush',450,3),(3,2,'Ivan','Netrebych',250,1),(4,4,'Bogdan','Goroh',300,2),(5,1,'Mykola','Sobko',500,3),(6,2,'Ostap','Fedunets',200,1),(7,3,'Iryna','Voronovska',500,3),(8,6,'Ostap','Noviy',400,2),(9,3,'Taras','Makush',400,2),(10,5,'Petro','Popelyshyn',300,1),(11,4,'Ivan','Shahov',500,3),(12,2,'Natalya','Yakymiv',400,2),(13,1,'Volodymyr','Tysovskiy',200,1),(14,7,'Valerii ','Synenko',500,3),(15,7,'Olya','Ananevych',400,2),(16,7,'Taras','Mysakovych',500,3),(17,2,'John','Doe',300,3);
/*!40000 ALTER TABLE `lectors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-13 17:21:27
