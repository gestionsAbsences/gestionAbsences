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
-- Table structure for table `employe`
--

DROP TABLE IF EXISTS `employe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `matricule` varchar(45) DEFAULT NULL,
  `nb_ca` int(11) DEFAULT NULL,
  `nb_rtt` int(11) DEFAULT NULL,
  `nb_rc` int(11) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `id_service_rh` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employes_equipe_idx` (`id_equipe`),
  KEY `fk_employes_service_rh_idx` (`id_service_rh`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employe`
--

LOCK TABLES `employe` WRITE;
/*!40000 ALTER TABLE `employe` DISABLE KEYS */;
INSERT INTO `employe` VALUES (1,'HUMPHREY','Damian','TYDM21',25,12,1,1,1),(2,'NICHOLS','Keely','UXCL65',25,10,7,2,1),(3,'STEVENS','Jacob','VXQT96',25,3,2,3,1),(4,'POTTS','Mikayla','VGDU81',25,3,19,4,1),(5,'MCINTOSH','Chantale','DHBR96',25,3,21,5,1),(6,'MELENDEZ','Virginia','RKJQ89',25,15,19,6,1),(7,'WEAVER','Ivan','QYSH74',25,11,18,1,1),(8,'VELAZQUEZ','Paloma','FEGU92',25,7,10,1,1),(9,'FIELDS','MacKensie','FCMA25',25,14,3,2,2),(10,'FLORES','Katelyn','WCAM97',25,7,24,2,2),(11,'BERRY','Lee','WVNK86',25,8,2,2,2),(12,'WALLS','Ishmael','FZRV62',25,7,26,3,6),(13,'BLEVINS','Irene','KJTW95',25,15,18,3,6),(14,'WALTER','Lisandra','YLTV74',25,11,23,4,3),(15,'SCHWARTZ','Rae','DJZQ40',25,5,1,4,3),(16,'PEREZ','Ferdinand','WBKF15',25,15,28,5,4),(17,'OWENS','Jessamine','ZBCK68',25,11,4,5,4),(18,'KEITH','Riley','DJKY58',25,8,21,6,5),(19,'WOOTEN','Marvin','THBK14',25,4,25,6,5),(20,'GLENN','Ocean','UCKP17',25,15,28,7,4),(21,'WALLACE','Anika','SQCF97',25,14,19,8,4),(22,'ORTIZ','Hope','MVJX92',25,14,27,9,4),(23,'DICKSON','Jacob','RMAY17',25,11,15,10,5),(24,'YORK','Alyssa','STNQ38',25,10,2,11,5),(25,'LEBLANC','Brooke','PMTC43',25,8,7,12,5),(26,'AGUIRRE','Veronica','GDWZ47',25,13,2,13,3),(27,'RIVAS','Madison','AUTB50',25,6,12,14,6),(28,'DICKERSON','Henry','LRDB47',25,1,13,15,6),(29,'PETERSEN','Doris','WRJG28',25,9,23,16,2),(30,'BURCH','Hadassah','WMPU23',25,6,1,7,4),(31,'BRAY','Montana','LNMH10',25,14,4,7,4),(32,'FREDERICK','Julie','VQTR86',25,8,22,7,4),(33,'COPELAND','Sydnee','RGMY61',25,12,28,7,4),(34,'VANG','Christian','WBUJ17',25,6,28,7,4),(35,'PRINCE','Sonia','SZKL23',25,4,20,8,4),(36,'TRUJILLO','Adele','TGBQ12',25,6,7,8,4),(37,'WEEKS','Cody','NATL23',25,13,17,8,4),(38,'TRUJILLO','Joan','BYZA32',25,2,24,8,4),(39,'BEARD','Regina','MRDX41',25,8,25,8,4),(40,'ESTES','Rashad','CXGN51',25,6,5,9,4),(41,'HURLEY','Lacy','UZBC87',25,5,14,9,4),(42,'WALLER','Sacha','QEZC98',25,4,20,9,4),(43,'WARNER','Kareem','PRZG98',25,9,18,9,4),(44,'STEWART','Brynn','ESRQ92',25,6,27,9,4),(45,'BENTLEY','Keely','MWLZ28',25,3,13,10,5),(46,'FREDERICK','Autumn','CJLQ98',25,2,7,10,5),(47,'NORMAN','Howard','EWRC35',25,15,5,10,5),(48,'WINTER','Bryan','QSHK36',25,6,1,10,5),(49,'BLEVINS','Irene','RKMT95',25,6,22,10,5),(50,'NGUYEN','Ulysses','DGWR39',25,9,25,11,5),(51,'CONWAY','Shoshana','QHSW59',25,4,5,11,5),(52,'CARVER','Kasimir','DUFZ35',25,11,22,11,5),(53,'DIAZ','Fulton','SRNT46',25,15,27,11,5),(54,'HALEY','Quyn','WEBG41',25,14,24,11,5),(55,'WEISS','Meghan','UCSD36',25,2,25,12,5),(56,'WILLIAMSON','Anjolie','ULJF38',25,2,20,12,5),(57,'AYERS','Lars','FQYS75',25,5,24,12,5),(58,'MARQUEZ','Skyler','QPRM87',25,6,26,12,5),(59,'ONEAL','Carissa','LJWD98',25,8,26,12,5),(60,'FROST','Nigel','RLKA23',25,11,12,13,3),(61,'ROSALES','Holmes','UYQC67',25,10,9,13,3),(62,'HOUSE','Ivana','GPLZ96',25,8,20,13,3),(63,'SCOTT','Ira','NDJY15',25,6,7,13,3),(64,'CASE','Ian','JLPV28',25,3,1,13,3),(65,'ROBBINS','Peter','CJVW19',25,10,22,14,6),(66,'FRANCO','Harriet','YPDC73',25,14,20,14,6),(67,'MOON','Sharon','NBQA74',25,2,1,14,6),(68,'ELLIOTT','Virginia','DWVX45',25,6,21,14,6),(69,'WHITNEY','Simone','GQNP42',25,3,8,14,6),(70,'AGUIRRE','Alexander','HVJL50',25,14,27,15,6),(71,'PETERSON','Paula','KEXY60',25,4,3,15,6),(72,'CRANE','Guinevere','QYFS83',25,12,5,15,6),(73,'CLAYTON','Boris','CRLE93',25,13,6,15,6),(74,'SHEPARD','Thor','YWCG49',25,6,2,15,6),(75,'BURT','Eagan','TQJK34',25,7,9,16,2),(76,'CONNER','Dillon','RVMA23',25,15,15,16,2),(77,'LUNA','Jaden','KZLV14',25,12,20,16,2),(78,'MCMILLAN','Nathan','VBXH94',25,15,9,16,2),(79,'BECK','Colleen','TLJA23',25,5,22,16,2),(80,'LEFRANCOIS','Jean','YLF246',15,1,18,16,2),(81,'Service RH','Direction','RH001',0,0,0,1,1),(82,'Service RH','Administratif','RH002',0,0,0,1,1),(83,'Service RH','Technicien','RH003',0,0,0,1,1),(84,'Service RH','Production1','RH004',0,0,0,1,1),(85,'Service RH','Production2','RH005',0,0,0,1,1),(86,'Service RH','Communication','RH006',0,0,0,1,1);
/*!40000 ALTER TABLE `employe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-10 16:48:41
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
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `id_responsable` int(11) DEFAULT NULL,
  `id_hierarchie` int(11) DEFAULT NULL,
  `id_backup` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_equipes_equipe_idx` (`id_hierarchie`),
  KEY `fk_equipes_employe_idx` (`id_responsable`),
  KEY `fk_equipe_employe2_idx` (`id_backup`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (1,'Direction',1,1,NULL),(2,'Service adminstratif',2,1,NULL),(3,'Service marketing',3,1,NULL),(4,'Services techniques',4,1,NULL),(5,'Production 1',5,1,NULL),(6,'Production 2',6,1,NULL),(7,'Equipe 1',20,5,NULL),(8,'Equipe 2',21,5,NULL),(9,'Equipe 3',22,5,NULL),(10,'Equipe 4',23,6,NULL),(11,'Equipe 5',24,6,NULL),(12,'Equipe 6',25,6,NULL),(13,'Techniciens',26,4,NULL),(14,'Communication',27,3,NULL),(15,'Vente',28,3,NULL),(16,'Administration',29,2,NULL);
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
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
-- Table structure for table `num_demande`
--

DROP TABLE IF EXISTS `num_demande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `num_demande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `num_demande`
--

LOCK TABLES `num_demande` WRITE;
/*!40000 ALTER TABLE `num_demande` DISABLE KEYS */;
INSERT INTO `num_demande` VALUES (1,'DEM000000');
/*!40000 ALTER TABLE `num_demande` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-10 16:48:41
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
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valeur` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,0),(2,1),(3,2),(4,3),(5,4);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
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
-- Table structure for table `service_rh`
--

DROP TABLE IF EXISTS `service_rh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_rh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_rh`
--

LOCK TABLES `service_rh` WRITE;
/*!40000 ALTER TABLE `service_rh` DISABLE KEYS */;
INSERT INTO `service_rh` VALUES (1,'serviceRhDirection@gmail.com','Service RH Direction'),(2,'serviceRhAdministratif@gmail.com','Service RH Administratif'),(3,'serviceRhTechnicien@gmail.com','Service RH Technicien'),(4,'serviceRhProduction1@gmail.com','Service Rh Production 1'),(5,'serviceRhProduction2@gmail.com','Service RH Production 2'),(6,'serviceRhComminucation@gmail.com','Serivce RH Communication');
/*!40000 ALTER TABLE `service_rh` ENABLE KEYS */;
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
-- Table structure for table `statut`
--

DROP TABLE IF EXISTS `statut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statut` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statut`
--

LOCK TABLES `statut` WRITE;
/*!40000 ALTER TABLE `statut` DISABLE KEYS */;
INSERT INTO `statut` VALUES (1,'Nouvelle demande',0),(2,'En attente de validation du Responsable',1),(3,'En attente de validation RH',2),(4,'Validé',3),(5,'Refusé par le responsable',4),(6,'Refusé par le service Rh',5);
/*!40000 ALTER TABLE `statut` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-10 16:48:41
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
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Congé payé'),(2,'RTT'),(3,'Repos compensateur'),(4,'Congé maladie'),(5,'Absence irrégulière'),(6,'Autre absence'),(7,'Accident de travail');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `id_employe` int(11) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_employe_idx` (`id_employe`),
  KEY `fk_users_role_idx` (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'damian.humphrey@entreprise.com','BJK36ELZ',1,2),(2,'keely.nichols@entreprise.com','HBU72WZM',2,1),(3,'jacob.stevens@entreprise.com','XNW54VSD',3,1),(4,'mikayla.potts@entreprise.com','URX87MTE',4,1),(5,'chantale.mcintosh@entreprise.com','MXW39NZL',5,1),(6,'virginia.melendez@entreprise.com','UCW58VTY',6,1),(7,'ivan.weaver@entreprise.com','BVF20XZG',7,1),(8,'paloma.velazquez@entreprise.com','FDP58CQL',8,1),(9,'mackensie.fields@entreprise.com','HVZ37UPJ',9,1),(10,'katelyn.flores@entreprise.com','PRB80DLW',10,1),(11,'lee.berry@entreprise.com','BXG70DRV',11,1),(12,'ishmael.walls@entreprise.com','FNQ61YJB',12,1),(13,'irene.blevins@entreprise.com','XMK92BVJ',13,1),(14,'lisandra.walter@entreprise.com','DTF23LVH',14,1),(15,'rae.schwartz@entreprise.com','BQN63EXJ',15,1),(16,'ferdinand.perez@entreprise.com','VEM78HKN',16,1),(17,'jessamine.owens@entreprise.com','ARZ70ESX',17,1),(18,'riley.keith@entreprise.com','DHA39GSV',18,1),(19,'marvin.wooten@entreprise.com','CVF16BQM',19,1),(20,'ocean.glenn@entreprise.com','YFH62CAT',20,2),(21,'anika.wallace@entreprise.com','LWK73GFB',21,2),(22,'hope.ortiz@entreprise.com','UVK96MDX',22,2),(23,'jacob.dickson@entreprise.com','NUP39JHF',23,2),(24,'alyssa.york@entreprise.com','UXC96TNV',24,2),(25,'brooke.leblanc@entreprise.com','DUL50BVZ',25,2),(26,'veronica.aguirre@entreprise.com','ARY13MXE',26,2),(27,'madison.rivas@entreprise.com','VQF94RBA',27,2),(28,'henry.dickerson@entreprise.com','YFX41HTW',28,2),(29,'jean.lefrancois@laposte.net','GJW84PEY',29,2),(30,'hadassah.burch@entreprise.com','GAP36TSE',30,1),(31,'montana.bray@entreprise.com','BGF91RXH',31,1),(32,'julie.frederick@entreprise.com','GUT31DHW',32,1),(33,'sydnee.copeland@entreprise.com','RMG29BWC',33,1),(34,'christian.vang@entreprise.com','SGX54WLV',34,1),(35,'sonia.prince@entreprise.com','VBP57LZD',35,1),(36,'adele.trujillo@entreprise.com','RST49WEH',36,1),(37,'cody.weeks@entreprise.com','WTK61RCQ',37,1),(38,'joan.trujillo@entreprise.com','PVY21SWU',38,1),(39,'regina.beard@entreprise.com','JPN45UGW',39,1),(40,'rashad.estes@entreprise.com','GEN93HRS',40,1),(41,'lacy.hurley@entreprise.com','BYH69JLS',41,1),(42,'sacha.waller@entreprise.com','GWU41FZA',42,1),(43,'kareem.warner@entreprise.com','SHD34YBT',43,1),(44,'brynn.stewart@entreprise.com','BQR74TEY',44,1),(45,'keely.bentley@entreprise.com','BHQ18ELY',45,1),(46,'autumn.frederick@entreprise.com','MZL72ERU',46,1),(47,'howard.norman@entreprise.com','JHT26PEY',47,1),(48,'bryan.winter@entreprise.com','VRB40ULA',48,1),(49,'steven.merrill@entreprise.com','NPW32JQR',49,1),(50,'ulysses.nguyen@entreprise.com','DRY79HSG',50,1),(51,'shoshana.conway@entreprise.com','YWX19CUS',51,1),(52,'kasimir.carver@entreprise.com','YLX14JPA',52,1),(53,'fulton.diaz@entreprise.com','JSC20VFU',53,1),(54,'quyn.haley@entreprise.com','ZUM62CGL',54,1),(55,'meghan.weiss@entreprise.com','QLV46RZA',55,1),(56,'anjolie.williamson@entreprise.com','BPE49THX',56,1),(57,'lars.ayers@entreprise.com','WNF84ZAH',57,1),(58,'skyler.marquez@entreprise.com','FLR29EBW',58,1),(59,'carissa.oneal@entreprise.com','BMC30ZAQ',59,1),(60,'nigel.frost@entreprise.com','TKE62PWZ',60,1),(61,'holmes.rosales@entreprise.com','JQD78VRH',61,1),(62,'ivana.house@entreprise.com','LPB19GWF',62,1),(63,'ira.scott@entreprise.com','WFB43QJY',63,1),(64,'ian.case@entreprise.com','TBJ52YKH',64,1),(65,'peter.robbins@entreprise.com','YSM38BCF',65,1),(66,'harriet.franco@entreprise.com','JUF32MZR',66,1),(67,'sharon.moon@entreprise.com','VMW53ALE',67,1),(68,'virginia.elliott@entreprise.com','EPB98WYJ',68,1),(69,'simone.whitney@entreprise.com','VJL86KDR',69,1),(70,'alexander.aguirre@entreprise.com','DAH53RFL',70,1),(71,'paula.peterson@entreprise.com','LJZ39HGR',71,1),(72,'guinevere.crane@entreprise.com','NYL53ECV',72,1),(73,'boris.clayton@entreprise.com','MLJ95HVS',73,1),(74,'thor.shepard@entreprise.com','WFC41EMV',74,1),(75,'eagan.burt@entreprise.com','RUB25ZEP',75,1),(76,'dillon.conner@entreprise.com','RYN53MVX',76,1),(77,'jaden.luna@entreprise.com','QZD89JKR',77,1),(78,'nathan.mcmillan@entreprise.com','JMT65AQX',78,1),(79,'colleen.beck@entreprise.com','LXN41GTB',79,1),(80,'jeanlefrancois.simplon@gmail.com','ABCD1234',80,2),(81,'serviceRhDirection@gmail.com','IDRH0001',81,3),(82,'serviceRhAdministratif@gmail.com','IDRH0002',82,3),(83,'serviceRhTechnicien@gmail.com','IDRH0003',83,3),(84,'serviceRhProduction1@gmail.com','IDRH0004',84,3),(85,'serviceRhProduction2@gmail.com','IDRH0005',85,3),(86,'serviceRhComminucation@gmail.com','IDRH0006',86,3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
