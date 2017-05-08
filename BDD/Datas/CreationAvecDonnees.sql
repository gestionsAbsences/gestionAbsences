-- MySQL Script generated by MySQL Workbench
-- Sat May  6 12:24:10 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema GestAbsences
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `GestAbsences` ;

-- -----------------------------------------------------
-- Schema GestAbsences
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `GestAbsences` DEFAULT CHARACTER SET utf8 ;
USE `GestAbsences` ;

-- -----------------------------------------------------
-- Table `GestAbsences`.`equipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestAbsences`.`equipe` ;

CREATE TABLE IF NOT EXISTS `GestAbsences`.`equipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(100) NULL,
  `id_responsable` INT NULL,
  `id_hierarchie` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Equipe_Employe1_idx` (`id_responsable` ASC),
  INDEX `fk_Equipe_Equipe1_idx` (`id_hierarchie` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestAbsences`.`service_rh`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestAbsences`.`service_rh` ;

CREATE TABLE IF NOT EXISTS `GestAbsences`.`service_rh` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestAbsences`.`employe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestAbsences`.`employe` ;

CREATE TABLE IF NOT EXISTS `GestAbsences`.`employe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(100) NULL,
  `prenom` VARCHAR(100) NULL,
  `matricule` VARCHAR(45) NULL,
  `nb_cp` INT NULL,
  `nb_rtt` INT NULL,
  `nb_rc` INT NULL,
  `reliquat_ca` INT NULL,
  `reliquat_rtt` INT NULL,
  `id_equipe` INT NULL,
  `id_service_rh` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Personnel_Equipe1_idx` (`id_equipe` ASC),
  INDEX `fk_Employe_ServiceRH1_idx` (`id_service_rh` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestAbsences`.`type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestAbsences`.`type` ;

CREATE TABLE IF NOT EXISTS `GestAbsences`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestAbsences`.`statut`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestAbsences`.`statut` ;

CREATE TABLE IF NOT EXISTS `GestAbsences`.`statut` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(100) NULL,
  `code` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestAbsences`.`absence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestAbsences`.`absence` ;

CREATE TABLE IF NOT EXISTS `GestAbsences`.`absence` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `debut` DATE NULL,
  `fin` DATE NULL,
  `id_employe` INT NULL,
  `id_type` INT NULL,
  `id_statut` INT NULL,
  `id_service_rh` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Demande_Personnel1_idx` (`id_employe` ASC),
  INDEX `fk_Demande_TypeAbsence1_idx` (`id_type` ASC),
  INDEX `fk_Demande_TypeStatut1_idx` (`id_statut` ASC),
  INDEX `fk_Absence_ServiceRH1_idx` (`id_service_rh` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestAbsences`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestAbsences`.`role` ;

CREATE TABLE IF NOT EXISTS `GestAbsences`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valeur` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GestAbsences`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GestAbsences`.`user` ;

CREATE TABLE IF NOT EXISTS `GestAbsences`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(100) NULL,
  `id_employe` INT NULL,
  `id_role` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_User_Employe1_idx` (`id_employe` ASC),
  INDEX `fk_User_Role1_idx` (`id_role` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


USE GestAbsences;

SET AUTOCOMMIT=0;
INSERT INTO equipe VALUES (1,'Direction',1,1),(2,'RH',2,2),(3,'Moyens g�n�raux',3,3),(4,'Finance',4,4),(5,'Sce technique',5,5),(6,'Production',6,6),(7,'Commerce',7,7),(8,'Communication',8,8),(9,'Secr�tariat',9,1),(10,'Administration',10,1),(11,'Juridique',11,10),(12,'Gouvernance',12,10),(13,'Qualit�',13,12),(14,'Strat�gie',14,12),(15,'Paye',15,2),(16,'Cong�s',16,2),(17,'Social',17,2),(18,'Gestion du personnel',18,2),(19,'Vie au travail',19,2),(20,'Assistance sociale',20,17),(21,'Recrutement',21,18),(22,'Discipline',22,18),(23,'Logistique',23,3),(24,'M�decine du travail',24,3),(25,'Gestion client',25,3),(26,'Courrier',26,3),(27,'Restaurant',27,3),(28,'S�curit�',28,25),(29,'Accueil',29,25),(30,'Conciergerie',30,25),(31,'Chauffeur',31,25),(32,'Comptabilit�',32,4),(33,'Achat',33,4),(34,'Facturation',34,4),(35,'Tr�sorerie',35,4),(36,'Contr�le de gestion',36,32),(37,'Synth�se',37,32),(38,'Analytique',38,32),(39,'Recouvrement',39,34),(40,'Maintenance',40,5),(41,'Ing�nierie',41,5),(42,'SAV',42,40),(43,'T�l�phonie',43,40),(44,'Support informatique',44,40),(45,'Innovation',45,41),(46,'Produit',46,6),(47,'Vente',47,6),(48,'Fabrication',48,46),(49,'Maquette',49,46),(50,'Stock',50,46),(51,'Comptoir',51,47),(52,'Exp�dition',52,47),(53,'Conditionnement',53,52),(54,'Commercial',54,7),(55,'Marketing',55,7),(56,'Developpement',56,54),(57,'Force de vente',57,54),(58,'Portail',58,55),(59,'Evenementiel',59,8),(60,'Publicit�',60,8),(61,'Prospect',61,8);
COMMIT;


SET AUTOCOMMIT=0;
INSERT INTO role VALUES (1,0),(2,1),(3,2),(4,4),(5,8);
COMMIT;


SET AUTOCOMMIT=0;
INSERT INTO service_rh VALUES (1,'sonia.granger@gmail.com','GRANGER'),(2,'tania.suchet@gmail.com','SUCHET'),(3,'yann.lanvin@gmail.com','LANVIN'),(4,'alex.fiston@gmail.com','FISTON');
COMMIT;


SET AUTOCOMMIT=0;
INSERT INTO statut VALUES (1,'Nouvelle demande', 0),(2,'En attente de validation du Responsable', 1),(3,'En attente de d�cision RH', 2),(4,'Valid�', 3),(5,'Refus� par le Responsable', 4),(6,'Refus� par le RH', 5);
COMMIT;


SET AUTOCOMMIT=0;
INSERT INTO type VALUES (1,'Cong� pay�'),(2,'RTT'),(3,'Repos compensateur'),(4,'Cong� maladie'),(5,'Absence irr�guli�re'),(6,'Autres absences');
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2015-05-19","2015-10-05",26,3,5,1),("2016-01-30","2015-01-29",9,4,5,1),("2015-08-23","2017-05-30",16,1,2,2),("2016-06-29","2016-12-22",20,5,6,4),("2016-05-11","2016-11-14",12,1,4,2),("2016-04-17","2016-05-23",13,6,1,2),("2016-03-12","2016-09-12",13,6,1,1),("2016-01-25","2015-03-18",18,6,6,1),("2015-07-13","2017-10-17",27,6,1,3),("2016-05-12","2017-10-02",24,5,4,1);
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2015-09-02","2016-08-29",30,4,3,2),("2017-07-06","2017-08-14",19,2,6,1),("2016-10-22","2015-09-13",23,6,6,3),("2017-04-07","2015-11-26",1,6,6,3),("2016-07-12","2016-08-30",23,5,4,3),("2015-08-04","2017-01-23",8,5,4,4),("2016-10-17","2015-12-14",4,2,2,3),("2017-10-02","2016-10-21",5,2,1,4),("2015-10-09","2016-05-19",17,6,2,1),("2015-04-21","2015-06-01",8,1,5,2);
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2017-03-24","2016-11-08",10,2,4,3),("2017-05-14","2015-02-27",13,4,6,2),("2015-05-17","2017-01-19",21,3,1,2),("2015-04-07","2017-04-19",29,1,1,4),("2017-01-10","2015-05-17",8,6,3,1),("2015-08-28","2015-12-12",15,5,5,3),("2015-06-23","2016-11-07",12,6,5,4),("2017-01-11","2016-06-20",16,6,5,1),("2016-05-08","2016-01-05",2,3,2,4),("2016-04-15","2017-08-07",2,5,2,1);
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2016-07-19","2015-04-29",17,3,6,2),("2015-01-28","2015-03-07",5,4,3,4),("2016-08-25","2015-03-15",2,4,6,3),("2017-10-13","2015-01-18",21,5,3,3),("2017-06-20","2015-10-17",1,6,1,3),("2015-08-31","2016-02-28",19,4,3,1),("2016-04-13","2017-05-27",2,1,4,4),("2017-09-08","2016-05-11",26,3,5,1),("2017-03-13","2016-10-06",29,3,2,2),("2015-02-15","2016-07-13",10,1,1,2);
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2016-03-30","2017-11-10",14,4,4,3),("2015-09-17","2015-03-18",30,6,2,1),("2017-09-16","2016-10-07",27,5,6,2),("2015-02-20","2016-04-10",28,4,6,2),("2015-05-31","2016-03-13",29,4,1,2),("2016-01-27","2015-02-12",14,5,6,4),("2017-09-18","2016-06-20",21,2,3,1),("2017-01-25","2015-11-29",7,1,3,3),("2016-08-25","2017-12-09",18,6,1,3),("2017-12-10","2015-07-08",13,4,6,4);
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2016-04-09","2015-05-01",5,4,4,1),("2016-08-06","2016-04-25",14,6,3,2),("2016-07-06","2016-12-13",7,6,4,1),("2017-05-12","2017-07-13",9,6,5,2),("2015-05-21","2015-06-26",11,3,3,3),("2017-10-05","2015-12-01",4,4,2,4),("2017-08-28","2015-09-28",30,6,6,2),("2015-12-08","2016-12-31",5,5,1,3),("2016-06-12","2017-09-20",6,3,3,1),("2017-04-19","2015-04-07",30,6,5,3);
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2015-07-10","2017-06-22",16,3,2,3),("2017-07-08","2015-11-30",23,3,2,3),("2015-09-20","2017-06-08",21,5,4,4),("2016-01-14","2016-07-18",17,1,4,4),("2015-01-17","2015-12-17",6,4,5,3),("2015-04-24","2015-08-06",18,3,3,3),("2017-04-30","2017-09-06",6,2,1,1),("2017-11-24","2017-03-03",11,1,4,4),("2016-07-15","2016-10-12",25,5,2,2),("2016-08-01","2015-01-27",8,1,2,2);
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2017-09-06","2016-05-26",10,1,5,2),("2015-01-25","2015-07-07",10,6,6,1),("2015-06-05","2017-11-09",27,6,5,4),("2015-01-14","2015-01-20",17,5,5,3),("2015-08-29","2017-08-19",26,1,6,2),("2017-07-14","2015-09-29",8,1,4,2),("2016-03-18","2016-12-27",19,3,2,3),("2016-10-06","2015-02-07",17,5,4,3),("2017-01-29","2015-11-10",24,5,3,2),("2015-06-20","2016-04-06",11,4,5,3);
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2015-01-20","2015-12-31",21,4,2,4),("2015-02-04","2017-11-06",24,2,2,3),("2017-05-16","2017-08-20",27,1,1,4),("2017-06-13","2015-06-03",19,1,5,3),("2017-11-03","2017-09-21",29,5,6,4),("2015-09-23","2015-10-20",29,3,4,3),("2016-02-08","2016-05-15",26,1,1,3),("2016-02-20","2016-06-29",13,1,4,1),("2015-01-23","2016-03-19",14,5,2,4),("2015-02-25","2015-10-13",28,3,1,1);
INSERT INTO `absence` (`debut`,`fin`,`id_employe`,`id_type`,`id_statut`,`id_service_rh`) VALUES ("2015-11-19","2015-08-31",13,6,6,2),("2015-01-02","2017-04-17",26,1,3,2),("2017-10-19","2015-11-12",18,3,4,1),("2016-08-06","2015-12-03",29,3,6,1),("2017-05-26","2015-08-02",17,4,3,3),("2017-12-10","2015-10-25",25,4,5,2),("2017-08-25","2016-01-25",3,6,6,2),("2015-04-07","2015-07-22",15,6,2,2),("2017-12-05","2016-06-07",15,2,3,4),("2017-04-16","2016-08-04",11,1,3,2);
COMMIT;


SET AUTOCOMMIT=0;
INSERT INTO `employe` (`nom`,`prenom`,`matricule`,`nb_cp`,`nb_rtt`,`nb_rc`,`reliquat_ca`,`reliquat_rtt`,`id_equipe`,`id_service_rh`) VALUES ("Knox","Celeste","HEWH06",7,5,18,8,1,36,3),("Bruce","Jenette","GAOC03",9,1,23,0,2,18,1),("Welch","Perry","JAGH43",6,7,2,0,0,25,2),("Rowland","James","JYHB99",12,8,0,8,4,50,2),("Moreno","Elizabeth","FVSZ09",6,3,27,5,2,52,2),("Weiss","Odette","WYNS39",15,0,7,7,2,57,2),("Rodriquez","Cairo","HRDB06",13,4,5,8,1,43,3),("Schultz","Chester","SRPP85",16,2,13,6,0,14,4),("Mcdonald","India","VWWR04",2,8,10,9,1,13,1),("Calderon","Kenneth","SCDN16",11,1,28,5,0,12,2);
INSERT INTO `employe` (`nom`,`prenom`,`matricule`,`nb_cp`,`nb_rtt`,`nb_rc`,`reliquat_ca`,`reliquat_rtt`,`id_equipe`,`id_service_rh`) VALUES ("Robles","Shaeleigh","LSML33",5,7,18,1,3,20,4),("Jensen","Mufutau","JQIJ43",13,10,16,5,1,49,3),("Richards","Mark","PNCB67",14,2,11,0,2,57,2),("Battle","Pandora","WJPY86",20,7,14,3,3,14,4),("Holmes","Genevieve","IKNF25",20,5,26,4,1,4,3),("Marsh","Shelby","WJGT57",18,1,6,9,0,34,2),("Carson","Melvin","RBJS76",16,6,11,4,4,3,2),("Powers","Eleanor","QBWP24",13,2,8,3,2,41,1),("Nielsen","Wayne","UKOQ30",1,1,9,4,1,48,3),("Jennings","Jocelyn","RNWZ36",9,9,15,1,1,33,2);
INSERT INTO `employe` (`nom`,`prenom`,`matricule`,`nb_cp`,`nb_rtt`,`nb_rc`,`reliquat_ca`,`reliquat_rtt`,`id_equipe`,`id_service_rh`) VALUES ("Wells","Keiko","HLUQ29",7,0,3,3,3,37,3),("Miles","Dean","XOJE43",5,9,24,8,3,30,4),("Montgomery","Beatrice","JJDL65",10,10,5,9,1,3,3),("Hopper","Stacy","QOPJ51",10,8,8,2,3,18,3),("Cook","Brenna","BXKO29",5,6,0,6,0,42,2),("Winters","Mariam","TRIL34",14,6,0,2,3,12,2),("Goodman","Maggy","KEBX59",1,1,18,4,1,7,3),("Summers","Palmer","ADAB91",18,2,3,1,3,24,2),("Perry","Hanae","YHND21",11,10,12,9,3,52,1),("Aguirre","Ann","JBPK28",11,2,5,5,4,39,4);
COMMIT;

SET AUTOCOMMIT=0;
INSERT INTO `user` (`email`,`password`,`id_employe`,`id_role`) VALUES ("orci.sem.eget@ridiculusmusProin.net","GXDJX287",2,1),("Integer.urna@urna.ca","GOPKP396",14,1),("dolor.quam.elementum@Curabitursedtortor.org","HDRSA250",5,3),("Aenean@eleifendvitaeerat.edu","SHJFA350",11,3),("mi.lorem.vehicula@sit.com","XYKTS104",21,1),("ipsum.nunc.id@cursus.com","TIAMR214",4,1),("lorem@elitEtiam.co.uk","XJRXT707",26,2),("ipsum.dolor.sit@Curabiturconsequatlectus.net","LMXKV353",11,2),("non.nisi.Aenean@inconsectetuer.com","QQOEZ729",27,5),("Phasellus@atvelit.co.uk","RYTGG473",15,4);
INSERT INTO `user` (`email`,`password`,`id_employe`,`id_role`) VALUES ("elementum@in.ca","UKMVY825",16,5),("sit.amet.ornare@egetdictum.org","MVMFA211",30,5),("a.scelerisque@tellus.co.uk","JZWWU084",19,4),("sit@consequatlectus.net","BDUUE129",9,3),("in.consectetuer@anteVivamus.com","FWXOQ322",20,5),("ut.molestie@Sedeu.com","BKTUY809",24,2),("risus.Donec.egestas@nec.co.uk","UVNZT435",3,4),("tellus.Aenean.egestas@adipiscingenim.net","CLWNI614",16,1),("sagittis@lectus.org","ARUXD105",29,5),("facilisis.facilisis.magna@Sedmalesuadaaugue.co.uk","SKJPT818",12,3);
INSERT INTO `user` (`email`,`password`,`id_employe`,`id_role`) VALUES ("magna@quamquisdiam.ca","XUCDP019",2,2),("at@nec.org","XWKMK818",3,5),("Nullam@at.co.uk","COHSG227",1,3),("Mauris@accumsan.ca","CMUOM187",11,1),("id.ante.dictum@miloremvehicula.org","GOKDY430",19,2),("cursus.purus@suscipitnonummyFusce.net","WQCDV990",21,2),("non.quam@magnisdis.org","ORGZG901",19,5),("consequat.nec.mollis@Vivamussit.net","DIFTW638",1,5),("ac@idmollis.ca","DEABB464",10,3),("ullamcorper@duiCumsociis.org","QKDNB182",16,1);
COMMIT;
