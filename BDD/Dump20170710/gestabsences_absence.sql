-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestabsences
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `absence`
--

DROP TABLE IF EXISTS `absence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `absence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_demande` varchar(10) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `commentaire` longtext,
  `id_employe` int(11) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  `id_statut` int(11) DEFAULT NULL,
  `date_relance` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_absences_employe_idx` (`id_employe`),
  KEY `fk_absences_type_idx` (`id_type`),
  KEY `fk_absences_statut_idx` (`id_statut`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absence`
--

LOCK TABLES `absence` WRITE;
/*!40000 ALTER TABLE `absence` DISABLE KEYS */;
INSERT INTO `absence` VALUES (1,'1','2017-05-15','2017-05-19',NULL,26,3,5,NULL),(2,'2','2017-01-30','2017-02-09',NULL,8,4,5,NULL),(3,'4','2017-03-29','2017-03-31',NULL,20,5,3,NULL),(4,'5','2017-05-11','2017-05-24',NULL,10,1,4,NULL),(5,'6','2017-08-17','2017-08-23',NULL,11,6,1,NULL),(6,'7','2017-07-12','2017-07-26',NULL,11,6,1,NULL),(7,'8','2017-01-25','2017-01-25',NULL,18,6,3,NULL),(8,'9','2017-07-13','2017-07-14',NULL,27,6,1,NULL),(9,'10','2017-05-12','2017-05-19',NULL,24,5,4,NULL),(10,'11','2017-02-02','2017-02-20',NULL,30,4,3,NULL),(11,'12','2017-02-06','2017-02-14',NULL,19,2,5,NULL),(12,'13','2017-02-22','2017-03-13',NULL,23,6,3,NULL),(13,'14','2017-04-07','2017-04-11',NULL,1,6,3,NULL),(14,'15','2017-03-13','2017-03-13',NULL,23,5,2,NULL),(15,'16','2017-01-23','2017-01-23',NULL,6,5,4,NULL),(16,'17','2017-10-17','2017-10-19',NULL,3,2,2,NULL),(17,'18','2017-10-02','2017-10-03',NULL,3,2,1,NULL),(18,'19','2017-10-09','2017-10-19',NULL,17,6,2,NULL),(19,'20','2017-04-21','2017-05-01',NULL,7,1,5,NULL),(20,'21','2017-03-24','2017-04-07',NULL,8,2,4,NULL),(21,'22','2017-05-15','2017-05-26',NULL,11,4,3,NULL),(22,'23','2017-10-17','2017-10-19',NULL,21,3,1,NULL),(23,'25','2017-01-10','2017-01-17',NULL,7,6,3,NULL),(24,'26','2017-02-28','2017-03-03',NULL,15,5,5,NULL),(25,'27','2017-05-23','2017-05-26',NULL,11,6,5,NULL),(26,'29','2017-10-09','2017-10-10',NULL,2,3,2,NULL),(27,'30','2017-08-14','2017-08-15',NULL,2,5,2,NULL),(28,'31','2017-07-19','2017-07-21',NULL,17,3,4,NULL),(29,'32','2017-01-30','2017-02-07',NULL,4,4,3,NULL),(30,'33','2017-03-27','2017-04-14',NULL,2,4,3,NULL),(31,'34','2017-03-13','2017-03-17',NULL,21,5,3,NULL),(32,'35','2017-12-20','2017-12-22',NULL,1,6,1,NULL),(33,'36','2017-05-01','2017-05-10',NULL,19,4,3,NULL),(34,'37','2017-04-13','2017-05-05',NULL,2,1,4,NULL),(35,'38','2017-09-08','2017-09-11',NULL,26,3,5,NULL),(36,'40','2017-07-17','2017-08-11',NULL,8,1,4,NULL),(37,'41','2017-03-30','2017-04-10',NULL,14,4,4,NULL),(38,'42','2017-09-18','2017-09-18',NULL,30,6,2,NULL),(39,'43','2017-02-16','2017-02-22',NULL,27,5,3,NULL),(40,'44','2017-02-20','2017-03-10',NULL,28,4,3,NULL),(41,'46','2017-01-27','2017-01-27',NULL,14,5,3,NULL),(42,'47','2017-09-18','2017-09-20',NULL,21,2,3,NULL),(43,'48','2017-01-25','2017-01-27',NULL,6,1,3,NULL),(44,'49','2017-08-25','2017-09-19',NULL,18,6,1,NULL),(45,'50','2017-01-10','2017-01-18',NULL,11,4,3,NULL),(46,'51','2017-04-10','2017-05-01',NULL,4,4,4,NULL),(47,'52','2017-03-06','2017-03-24',NULL,14,6,3,NULL),(48,'53','2017-02-06','2017-02-13',NULL,6,6,4,NULL),(49,'54','2017-05-11','2017-05-12',NULL,8,6,4,NULL),(50,'55','2017-05-22','2017-05-26',NULL,9,3,3,NULL),(51,'56','2017-06-05','2017-06-09',NULL,3,4,2,NULL),(52,'57','2017-05-29','2017-05-29',NULL,30,6,3,NULL),(53,'58','2017-11-09','2017-11-09',NULL,4,5,1,NULL),(54,'59','2017-09-12','2017-09-20',NULL,4,3,3,NULL),(55,'60','2017-04-19','2017-04-27',NULL,30,6,5,NULL),(56,'62','2017-07-10','2017-07-13',NULL,23,3,2,NULL),(57,'63','2017-05-22','2017-05-26',NULL,21,5,4,NULL),(58,'64','2017-01-16','2017-01-18',NULL,17,1,4,NULL),(59,'65','2017-01-17','2017-01-17',NULL,5,4,5,NULL),(60,'66','2017-04-24','2017-04-26',NULL,18,3,3,NULL),(61,'67','2017-05-01','2017-05-05',NULL,5,2,1,NULL),(62,'68','2017-02-24','2017-03-03',NULL,10,1,4,NULL),(63,'69','2017-12-15','2017-12-22',NULL,25,5,2,NULL),(64,'70','2017-08-01','2017-08-25',NULL,7,1,2,NULL),(65,'71','2017-08-07','2017-08-25',NULL,9,1,5,NULL),(66,'72','2017-02-24','2017-03-07',NULL,9,6,3,NULL),(67,'73','2017-01-05','2017-01-09',NULL,27,6,5,NULL),(68,'74','2017-01-16','2017-01-20',NULL,17,5,5,NULL),(69,'75','2017-08-09','2017-08-18',NULL,26,1,1,NULL),(70,'76','2017-06-14','2017-06-29',NULL,7,1,4,NULL),(71,'77','2017-11-20','2017-11-22',NULL,19,3,2,NULL),(72,'78','2017-04-06','2017-04-07',NULL,17,5,4,NULL),(73,'79','2017-01-30','2017-01-31',NULL,24,5,3,NULL),(74,'80','2017-05-10','2017-05-12',NULL,10,4,5,NULL),(75,'81','2017-06-20','2017-06-30',NULL,21,4,2,NULL),(76,'82','2017-07-31','2017-08-04',NULL,24,2,2,NULL),(77,'83','2017-07-17','2017-08-10',NULL,27,1,1,NULL),(78,'84','2017-06-13','2017-06-23',NULL,19,1,5,NULL),(79,'85','2017-06-05','2017-06-07',NULL,29,5,3,NULL),(80,'86','2017-09-25','2017-09-27',NULL,29,3,4,NULL),(81,'87','2017-08-01','2017-08-25',NULL,26,1,1,NULL),(82,'88','2017-02-20','2017-03-17',NULL,12,1,4,NULL),(83,'89','2017-11-20','2017-11-24',NULL,14,5,2,NULL),(84,'90','2017-12-05','2017-12-13',NULL,28,3,1,NULL),(85,'91','2017-05-09','2017-05-12',NULL,13,6,3,NULL),(86,'92','2017-01-02','2017-01-17',NULL,26,1,3,NULL),(87,'93','2017-10-19','2017-10-20',NULL,18,3,4,NULL),(88,'95','2017-04-26','2017-05-02',NULL,17,4,3,NULL),(89,'96','2017-02-10','2017-02-17',NULL,25,4,5,NULL),(90,'97','2017-04-25','2017-04-25',NULL,3,6,3,NULL),(91,'98','2017-07-17','2017-07-21',NULL,15,6,2,NULL),(92,'99','2017-06-05','2017-06-07',NULL,15,2,3,NULL),(93,'100','2017-04-17','2017-05-04',NULL,10,1,3,NULL),(95,'24','2017-04-07','2017-04-19',NULL,29,5,2,NULL),(96,'BLEV005','2017-08-14','2017-08-31',NULL,49,1,4,NULL),(97,'BLEV004','2017-06-12','2017-06-20',NULL,49,6,2,NULL),(98,'45','2017-10-01','2017-10-13',NULL,29,4,2,NULL),(99,'BLEV003','2017-01-10','2017-01-13',NULL,49,4,4,NULL),(100,'52','2017-03-06','2017-03-24',NULL,29,1,3,NULL),(101,'53','2017-02-06','2017-02-13',NULL,29,2,4,NULL),(102,'BLEV002','2016-12-11','2016-12-12',NULL,49,1,2,NULL),(103,'55','2017-05-22','2017-05-26',NULL,29,3,3,NULL),(104,'56','2017-06-05','2017-06-09',NULL,29,4,2,NULL),(105,'57','2017-05-29','2017-05-29',NULL,29,1,3,NULL),(106,'58','2017-11-09','2017-11-09',NULL,29,5,2,NULL),(107,'59','2017-11-12','2017-11-20',NULL,29,3,3,NULL),(108,'60','2017-04-20','2017-04-27',NULL,29,6,5,NULL),(109,'61','2017-07-10','2017-07-12',NULL,29,1,2,NULL),(110,'BLEV001','2016-08-07','2016-08-09',NULL,49,3,2,NULL);
/*!40000 ALTER TABLE `absence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-10 16:48:42
