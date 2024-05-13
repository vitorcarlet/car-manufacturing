CREATE DATABASE  IF NOT EXISTS `carmanufacturing` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carmanufacturing`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carmanufacturing
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `tb_users`
--

DROP TABLE IF EXISTS `tb_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active_user` bit(1) NOT NULL,
  `birth` datetime(6) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_users`
--

LOCK TABLES `tb_users` WRITE;
/*!40000 ALTER TABLE `tb_users` DISABLE KEYS */;
INSERT INTO `tb_users` VALUES (1,_binary '','2000-01-01 00:00:00.000000','123.456.789-00','Male','John Doe'),(2,_binary '','1990-05-10 21:00:00.000000','123.456.789-00','M','João Silva');
/*!40000 ALTER TABLE `tb_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_users_permissions`
--

DROP TABLE IF EXISTS `tb_users_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_users_permissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_admin` bit(1) NOT NULL,
  `is_assistant` bit(1) NOT NULL,
  `is_operator` bit(1) NOT NULL,
  `user_id_fk` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rgmk94nl5rrfl123d6dsf8u9s` (`user_id_fk`),
  CONSTRAINT `FK2gpp4j13dbn4qk7gcqokab68e` FOREIGN KEY (`user_id_fk`) REFERENCES `tb_users` (`id`),
  CONSTRAINT `FKo3fkvfk708hj0vp1kdicwfkqc` FOREIGN KEY (`user_id_fk`) REFERENCES `tb_userscredentials` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_users_permissions`
--

LOCK TABLES `tb_users_permissions` WRITE;
/*!40000 ALTER TABLE `tb_users_permissions` DISABLE KEYS */;
INSERT INTO `tb_users_permissions` VALUES (1,_binary '',_binary '',_binary '',1),(2,_binary '',_binary '',_binary '',2);
/*!40000 ALTER TABLE `tb_users_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_userscredentials`
--

DROP TABLE IF EXISTS `tb_userscredentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_userscredentials` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `user_id_fk` bigint NOT NULL,
  `user_permissions` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gdwkdvphb6e5nguky13la1ep2` (`user_id_fk`),
  CONSTRAINT `FK7bc0hpemubakk5j6k3eq932m6` FOREIGN KEY (`user_id_fk`) REFERENCES `tb_users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_userscredentials`
--

LOCK TABLES `tb_userscredentials` WRITE;
/*!40000 ALTER TABLE `tb_userscredentials` DISABLE KEYS */;
INSERT INTO `tb_userscredentials` VALUES (1,'johndoe','$2a$10$2UM0dvk.IlEckEPzFL1OeuEwJRvDyNKw0Ikdhz4j7n9Y1L/Sj8qXW',1,NULL),(2,'joao123','$2a$10$RW9JRRy0ftiUfS7W0QNoqupyxq8BOlw7DA4EQq7PuTVeecSiZKndG',2,NULL);
/*!40000 ALTER TABLE `tb_userscredentials` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-12 21:38:22
