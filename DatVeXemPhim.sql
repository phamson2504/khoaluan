-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: khoaluan
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `chi_tiet_hoa_don`
--

DROP TABLE IF EXISTS `chi_tiet_hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_tiet_hoa_don` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gia` double NOT NULL,
  `ghe_ngoi_id` int DEFAULT NULL,
  `hoa_don_id` int DEFAULT NULL,
  `suat_chieu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmttso47r8uriygmc6fljmvjyt` (`ghe_ngoi_id`),
  KEY `FK8u22ain8he9p3mgvuhkw82jkq` (`hoa_don_id`),
  KEY `FKkq8785vlysbl36ljh2ebs3ng2` (`suat_chieu_id`),
  CONSTRAINT `FK8u22ain8he9p3mgvuhkw82jkq` FOREIGN KEY (`hoa_don_id`) REFERENCES `hoa_don` (`id`),
  CONSTRAINT `FKkq8785vlysbl36ljh2ebs3ng2` FOREIGN KEY (`suat_chieu_id`) REFERENCES `suat_chieu` (`id`),
  CONSTRAINT `FKmttso47r8uriygmc6fljmvjyt` FOREIGN KEY (`ghe_ngoi_id`) REFERENCES `ghe_ngoi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=376 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_hoa_don`
--

LOCK TABLES `chi_tiet_hoa_don` WRITE;
/*!40000 ALTER TABLE `chi_tiet_hoa_don` DISABLE KEYS */;
INSERT INTO `chi_tiet_hoa_don` VALUES (219,150000,28,65,45),(220,150000,29,65,45),(227,150000,228,69,18),(228,150000,229,69,18),(282,120000,226,86,69),(283,120000,227,86,69),(284,120000,228,86,69),(293,120000,26,91,30),(294,120000,27,91,30),(295,120000,28,91,30),(296,200000,26,92,34),(297,200000,27,92,34),(298,200000,28,92,34),(299,150000,48,93,14),(300,150000,49,93,14),(301,150000,50,93,14),(302,120000,48,94,30),(303,120000,49,94,30),(304,120000,50,94,30),(320,200000,29,100,34),(321,200000,30,100,34),(322,200000,31,101,34),(323,200000,32,101,34),(324,200000,33,101,34),(325,200000,34,101,34),(326,200000,35,101,34),(346,150000,226,108,18),(347,150000,227,108,18),(348,150000,230,108,18),(366,150000,38,113,14),(367,150000,39,113,14),(368,150000,40,113,14),(369,150000,43,114,14),(370,150000,44,114,14),(371,150000,45,114,14),(372,180000,226,115,24),(373,180000,227,115,24),(374,180000,228,115,24),(375,180000,229,115,24);
/*!40000 ALTER TABLE `chi_tiet_hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danh_gia_phim`
--

DROP TABLE IF EXISTS `danh_gia_phim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danh_gia_phim` (
  `id` int NOT NULL AUTO_INCREMENT,
  `so_sao` int NOT NULL,
  `nguoi_dung_id` int DEFAULT NULL,
  `phim_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlkbfggcgthbjpmbcijvfvgdj7` (`nguoi_dung_id`),
  KEY `FKdqgw65b04c804kw6xl70eg0o2` (`phim_id`),
  CONSTRAINT `FKdqgw65b04c804kw6xl70eg0o2` FOREIGN KEY (`phim_id`) REFERENCES `phim` (`id`),
  CONSTRAINT `FKlkbfggcgthbjpmbcijvfvgdj7` FOREIGN KEY (`nguoi_dung_id`) REFERENCES `nguoi_dung` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danh_gia_phim`
--

LOCK TABLES `danh_gia_phim` WRITE;
/*!40000 ALTER TABLE `danh_gia_phim` DISABLE KEYS */;
INSERT INTO `danh_gia_phim` VALUES (1,5,4,2),(2,4,1,2),(3,5,5,9),(4,5,4,4),(5,3,1,4),(6,4,4,9),(7,1,5,2),(10,5,4,10),(12,3,4,5),(13,4,5,4);
/*!40000 ALTER TABLE `danh_gia_phim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ghe_ngoi`
--

DROP TABLE IF EXISTS `ghe_ngoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ghe_ngoi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vi_tri_cot` varchar(255) DEFAULT NULL,
  `vi_tri_hang` varchar(255) DEFAULT NULL,
  `phong_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK55v1d3eweg804fme4oqghkup` (`phong_id`),
  CONSTRAINT `FK55v1d3eweg804fme4oqghkup` FOREIGN KEY (`phong_id`) REFERENCES `phong` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1058 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ghe_ngoi`
--

LOCK TABLES `ghe_ngoi` WRITE;
/*!40000 ALTER TABLE `ghe_ngoi` DISABLE KEYS */;
INSERT INTO `ghe_ngoi` VALUES (26,'0','A',18),(27,'1','A',18),(28,'2','A',18),(29,'3','A',18),(30,'4','A',18),(31,'0','B',18),(32,'1','B',18),(33,'2','B',18),(34,'3','B',18),(35,'4','B',18),(36,'0','C',18),(37,'1','C',18),(38,'2','C',18),(39,'3','C',18),(40,'4','C',18),(41,'0','D',18),(42,'1','D',18),(43,'2','D',18),(44,'3','D',18),(45,'4','D',18),(46,'0','F',18),(47,'1','F',18),(48,'2','F',18),(49,'3','F',18),(50,'4','F',18),(176,'0','A',21),(177,'1','A',21),(178,'2','A',21),(179,'3','A',21),(180,'4','A',21),(181,'5','A',21),(182,'6','A',21),(183,'7','A',21),(184,'8','A',21),(185,'9','A',21),(186,'0','B',21),(187,'1','B',21),(188,'2','B',21),(189,'3','B',21),(190,'4','B',21),(191,'5','B',21),(192,'6','B',21),(193,'7','B',21),(194,'8','B',21),(195,'9','B',21),(196,'0','C',21),(197,'1','C',21),(198,'2','C',21),(199,'3','C',21),(200,'4','C',21),(201,'5','C',21),(202,'6','C',21),(203,'7','C',21),(204,'8','C',21),(205,'9','C',21),(206,'0','D',21),(207,'1','D',21),(208,'2','D',21),(209,'3','D',21),(210,'4','D',21),(211,'5','D',21),(212,'6','D',21),(213,'7','D',21),(214,'8','D',21),(215,'9','D',21),(216,'0','F',21),(217,'1','F',21),(218,'2','F',21),(219,'3','F',21),(220,'4','F',21),(221,'5','F',21),(222,'6','F',21),(223,'7','F',21),(224,'8','F',21),(225,'9','F',21),(226,'0','A',22),(227,'1','A',22),(228,'2','A',22),(229,'3','A',22),(230,'4','A',22),(231,'0','B',22),(232,'1','B',22),(233,'2','B',22),(234,'3','B',22),(235,'4','B',22),(236,'0','C',22),(237,'1','C',22),(238,'2','C',22),(239,'3','C',22),(240,'4','C',22),(241,'0','D',22),(242,'1','D',22),(243,'2','D',22),(244,'3','D',22),(245,'4','D',22),(246,'0','F',22),(247,'1','F',22),(248,'2','F',22),(249,'3','F',22),(250,'4','F',22),(251,'0','A',23),(252,'1','A',23),(253,'2','A',23),(254,'3','A',23),(255,'4','A',23),(256,'0','B',23),(257,'1','B',23),(258,'2','B',23),(259,'3','B',23),(260,'4','B',23),(261,'0','C',23),(262,'1','C',23),(263,'2','C',23),(264,'3','C',23),(265,'4','C',23),(266,'0','D',23),(267,'1','D',23),(268,'2','D',23),(269,'3','D',23),(270,'4','D',23),(271,'0','F',23),(272,'1','F',23),(273,'2','F',23),(274,'3','F',23),(275,'4','F',23),(301,'0','A',25),(302,'1','A',25),(303,'2','A',25),(304,'3','A',25),(305,'4','A',25),(306,'5','A',25),(307,'6','A',25),(308,'7','A',25),(309,'8','A',25),(310,'9','A',25),(311,'0','B',25),(312,'1','B',25),(313,'2','B',25),(314,'3','B',25),(315,'4','B',25),(316,'5','B',25),(317,'6','B',25),(318,'7','B',25),(319,'8','B',25),(320,'9','B',25),(321,'0','C',25),(322,'1','C',25),(323,'2','C',25),(324,'3','C',25),(325,'4','C',25),(326,'5','C',25),(327,'6','C',25),(328,'7','C',25),(329,'8','C',25),(330,'9','C',25),(331,'0','D',25),(332,'1','D',25),(333,'2','D',25),(334,'3','D',25),(335,'4','D',25),(336,'5','D',25),(337,'6','D',25),(338,'7','D',25),(339,'8','D',25),(340,'9','D',25),(341,'0','F',25),(342,'1','F',25),(343,'2','F',25),(344,'3','F',25),(345,'4','F',25),(346,'5','F',25),(347,'6','F',25),(348,'7','F',25),(349,'8','F',25),(350,'9','F',25),(351,'0','G',25),(352,'1','G',25),(353,'2','G',25),(354,'3','G',25),(355,'4','G',25),(356,'5','G',25),(357,'6','G',25),(358,'7','G',25),(359,'8','G',25),(360,'9','G',25),(361,'0','H',25),(362,'1','H',25),(363,'2','H',25),(364,'3','H',25),(365,'4','H',25),(366,'5','H',25),(367,'6','H',25),(368,'7','H',25),(369,'8','H',25),(370,'9','H',25),(371,'0','I',25),(372,'1','I',25),(373,'2','I',25),(374,'3','I',25),(375,'4','I',25),(376,'5','I',25),(377,'6','I',25),(378,'7','I',25),(379,'8','I',25),(380,'9','I',25),(381,'0','J',25),(382,'1','J',25),(383,'2','J',25),(384,'3','J',25),(385,'4','J',25),(386,'5','J',25),(387,'6','J',25),(388,'7','J',25),(389,'8','J',25),(390,'9','J',25),(391,'0','K',25),(392,'1','K',25),(393,'2','K',25),(394,'3','K',25),(395,'4','K',25),(396,'5','K',25),(397,'6','K',25),(398,'7','K',25),(399,'8','K',25),(400,'9','K',25),(401,'0','A',26),(402,'1','A',26),(403,'2','A',26),(404,'3','A',26),(405,'4','A',26),(406,'0','B',26),(407,'1','B',26),(408,'2','B',26),(409,'3','B',26),(410,'4','B',26),(411,'0','C',26),(412,'1','C',26),(413,'2','C',26),(414,'3','C',26),(415,'4','C',26),(416,'0','D',26),(417,'1','D',26),(418,'2','D',26),(419,'3','D',26),(420,'4','D',26),(421,'0','F',26),(422,'1','F',26),(423,'2','F',26),(424,'3','F',26),(425,'4','F',26),(426,'0','A',27),(427,'1','A',27),(428,'2','A',27),(429,'3','A',27),(430,'4','A',27),(431,'0','B',27),(432,'1','B',27),(433,'2','B',27),(434,'3','B',27),(435,'4','B',27),(436,'0','C',27),(437,'1','C',27),(438,'2','C',27),(439,'3','C',27),(440,'4','C',27),(441,'0','D',27),(442,'1','D',27),(443,'2','D',27),(444,'3','D',27),(445,'4','D',27),(446,'0','F',27),(447,'1','F',27),(448,'2','F',27),(449,'3','F',27),(450,'4','F',27),(451,'0','G',27),(452,'1','G',27),(453,'2','G',27),(454,'3','G',27),(455,'4','G',27),(456,'0','H',27),(457,'1','H',27),(458,'2','H',27),(459,'3','H',27),(460,'4','H',27),(461,'0','I',27),(462,'1','I',27),(463,'2','I',27),(464,'3','I',27),(465,'4','I',27),(466,'0','J',27),(467,'1','J',27),(468,'2','J',27),(469,'3','J',27),(470,'4','J',27),(471,'0','K',27),(472,'1','K',27),(473,'2','K',27),(474,'3','K',27),(475,'4','K',27),(476,'0','A',28),(477,'1','A',28),(478,'2','A',28),(479,'3','A',28),(480,'4','A',28),(481,'0','B',28),(482,'1','B',28),(483,'2','B',28),(484,'3','B',28),(485,'4','B',28),(486,'0','C',28),(487,'1','C',28),(488,'2','C',28),(489,'3','C',28),(490,'4','C',28),(491,'0','D',28),(492,'1','D',28),(493,'2','D',28),(494,'3','D',28),(495,'4','D',28),(496,'0','F',28),(497,'1','F',28),(498,'2','F',28),(499,'3','F',28),(500,'4','F',28),(501,'0','A',29),(502,'1','A',29),(503,'2','A',29),(504,'3','A',29),(505,'4','A',29),(506,'0','B',29),(507,'1','B',29),(508,'2','B',29),(509,'3','B',29),(510,'4','B',29),(511,'0','C',29),(512,'1','C',29),(513,'2','C',29),(514,'3','C',29),(515,'4','C',29),(516,'0','D',29),(517,'1','D',29),(518,'2','D',29),(519,'3','D',29),(520,'4','D',29),(521,'0','F',29),(522,'1','F',29),(523,'2','F',29),(524,'3','F',29),(525,'4','F',29),(552,'0','A',32),(553,'1','A',32),(554,'2','A',32),(555,'3','A',32),(556,'4','A',32),(557,'0','B',32),(558,'1','B',32),(559,'2','B',32),(560,'3','B',32),(561,'4','B',32),(562,'0','C',32),(563,'1','C',32),(564,'2','C',32),(565,'3','C',32),(566,'4','C',32),(567,'0','D',32),(568,'1','D',32),(569,'2','D',32),(570,'3','D',32),(571,'4','D',32),(572,'0','F',32),(573,'1','F',32),(574,'2','F',32),(575,'3','F',32),(576,'4','F',32),(577,'0','A',33),(578,'1','A',33),(579,'2','A',33),(580,'3','A',33),(581,'4','A',33),(582,'5','A',33),(583,'6','A',33),(584,'7','A',33),(585,'8','A',33),(586,'9','A',33),(587,'0','B',33),(588,'1','B',33),(589,'2','B',33),(590,'3','B',33),(591,'4','B',33),(592,'5','B',33),(593,'6','B',33),(594,'7','B',33),(595,'8','B',33),(596,'9','B',33),(597,'0','C',33),(598,'1','C',33),(599,'2','C',33),(600,'3','C',33),(601,'4','C',33),(602,'5','C',33),(603,'6','C',33),(604,'7','C',33),(605,'8','C',33),(606,'9','C',33),(607,'0','D',33),(608,'1','D',33),(609,'2','D',33),(610,'3','D',33),(611,'4','D',33),(612,'5','D',33),(613,'6','D',33),(614,'7','D',33),(615,'8','D',33),(616,'9','D',33),(617,'0','F',33),(618,'1','F',33),(619,'2','F',33),(620,'3','F',33),(621,'4','F',33),(622,'5','F',33),(623,'6','F',33),(624,'7','F',33),(625,'8','F',33),(626,'9','F',33),(627,'0','G',33),(628,'1','G',33),(629,'2','G',33),(630,'3','G',33),(631,'4','G',33),(632,'5','G',33),(633,'6','G',33),(634,'7','G',33),(635,'8','G',33),(636,'9','G',33),(637,'0','H',33),(638,'1','H',33),(639,'2','H',33),(640,'3','H',33),(641,'4','H',33),(642,'5','H',33),(643,'6','H',33),(644,'7','H',33),(645,'8','H',33),(646,'9','H',33),(647,'0','I',33),(648,'1','I',33),(649,'2','I',33),(650,'3','I',33),(651,'4','I',33),(652,'5','I',33),(653,'6','I',33),(654,'7','I',33),(655,'8','I',33),(656,'9','I',33),(657,'0','J',33),(658,'1','J',33),(659,'2','J',33),(660,'3','J',33),(661,'4','J',33),(662,'5','J',33),(663,'6','J',33),(664,'7','J',33),(665,'8','J',33),(666,'9','J',33),(667,'0','K',33),(668,'1','K',33),(669,'2','K',33),(670,'3','K',33),(671,'4','K',33),(672,'5','K',33),(673,'6','K',33),(674,'7','K',33),(675,'8','K',33),(676,'9','K',33),(777,'0','A',35),(778,'1','A',35),(779,'2','A',35),(780,'3','A',35),(781,'4','A',35),(782,'0','B',35),(783,'1','B',35),(784,'2','B',35),(785,'3','B',35),(786,'4','B',35),(787,'0','C',35),(788,'1','C',35),(789,'2','C',35),(790,'3','C',35),(791,'4','C',35),(792,'0','D',35),(793,'1','D',35),(794,'2','D',35),(795,'3','D',35),(796,'4','D',35),(797,'0','F',35),(798,'1','F',35),(799,'2','F',35),(800,'3','F',35),(801,'4','F',35),(802,'0','G',35),(803,'1','G',35),(804,'2','G',35),(805,'3','G',35),(806,'4','G',35),(807,'0','H',35),(808,'1','H',35),(809,'2','H',35),(810,'3','H',35),(811,'4','H',35),(812,'0','I',35),(813,'1','I',35),(814,'2','I',35),(815,'3','I',35),(816,'4','I',35),(829,'0','A',39),(830,'1','A',39),(831,'2','A',39),(832,'3','A',39),(833,'4','A',39),(834,'0','B',39),(835,'1','B',39),(836,'2','B',39),(837,'3','B',39),(838,'4','B',39),(839,'0','C',39),(840,'1','C',39),(841,'2','C',39),(842,'3','C',39),(843,'4','C',39),(844,'0','D',39),(845,'1','D',39),(846,'2','D',39),(847,'3','D',39),(848,'4','D',39),(849,'0','F',39),(850,'1','F',39),(851,'2','F',39),(852,'3','F',39),(853,'4','F',39),(854,'0','G',39),(855,'1','G',39),(856,'2','G',39),(857,'3','G',39),(858,'4','G',39),(859,'0','H',39),(860,'1','H',39),(861,'2','H',39),(862,'3','H',39),(863,'4','H',39),(864,'0','I',39),(865,'1','I',39),(866,'2','I',39),(867,'3','I',39),(868,'4','I',39),(869,'0','J',39),(870,'1','J',39),(871,'2','J',39),(872,'3','J',39),(873,'4','J',39),(874,'0','K',39),(875,'1','K',39),(876,'2','K',39),(877,'3','K',39),(878,'4','K',39),(879,'0','L',39),(880,'1','L',39),(881,'2','L',39),(882,'3','L',39),(883,'4','L',39),(884,'0','11',39),(885,'1','11',39),(886,'2','11',39),(887,'3','11',39),(888,'4','11',39);
/*!40000 ALTER TABLE `ghe_ngoi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ngay_lap` date DEFAULT NULL,
  `nguoi_dung_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdyrp3siy2ej5m684r8jyqn08c` (`nguoi_dung_id`),
  CONSTRAINT `FKdyrp3siy2ej5m684r8jyqn08c` FOREIGN KEY (`nguoi_dung_id`) REFERENCES `nguoi_dung` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
INSERT INTO `hoa_don` VALUES (47,'2022-03-20',4),(48,'2022-03-20',4),(49,'2022-03-20',4),(50,'2022-03-20',4),(51,'2022-03-20',4),(52,'2022-03-20',4),(53,'2022-03-20',4),(54,'2022-03-20',4),(55,'2022-03-20',4),(65,'2022-03-23',5),(69,'2022-03-25',5),(85,'2022-04-03',4),(86,'2022-04-05',4),(91,'2022-04-13',4),(92,'2022-04-13',4),(93,'2022-04-13',4),(94,'2022-04-13',4),(100,'2022-05-14',4),(101,'2022-05-14',4),(108,'2022-05-14',4),(113,'2022-06-11',4),(114,'2022-06-11',1),(115,'2022-06-14',4);
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khu_vuc`
--

DROP TABLE IF EXISTS `khu_vuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khu_vuc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_khu_vuc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khu_vuc`
--

LOCK TABLES `khu_vuc` WRITE;
/*!40000 ALTER TABLE `khu_vuc` DISABLE KEYS */;
INSERT INTO `khu_vuc` VALUES (4,'Tp.Hồ Chí Minh'),(5,'Vũng Tàu'),(6,'Bình Dương'),(7,'Hà Nội'),(8,'Hải Phòng');
/*!40000 ALTER TABLE `khu_vuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoi_dung`
--

DROP TABLE IF EXISTS `nguoi_dung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoi_dung` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  `mat_khau` varchar(255) NOT NULL,
  `ngay_sinh` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `gioi_tinh` varchar(255) DEFAULT NULL,
  `token_quen_mat_khau` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_majqh5g4djy2tp3p9dvr64brp` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi_dung`
--

LOCK TABLES `nguoi_dung` WRITE;
/*!40000 ALTER TABLE `nguoi_dung` DISABLE KEYS */;
INSERT INTO `nguoi_dung` VALUES (1,'member1@gmail.com','son pham','$2a$10$RZ9wQ.4kRYacr0Qwp/b87.PKJ7xFhcvQol2ZRpHlwJewPk9HtToEG','11/05/2000','0965603392','Nam','c07717e9-e340-4156-96a9-8ed131da1612'),(3,'member3@gmail.com','van anh','$2a$10$T7EWssVL1FoJ6nvEEBiHDOT9UkOrvZMfOT6.GgqmUBZ2ifLR4Iceq','09/05/2000','0965603300','Nam',NULL),(4,'admin@gmail.com','son pham','$2a$10$F35wdfIj3sIGoiAYd2l8nObZBo8os4gFZkhCbfpluSINp8dHwY4Yq','25/04/2000','0965603387','Nam',NULL),(5,'sonktk1@gmail.com','thai son 1','$2a$10$RFCwQGAzDbOAALC5lTwZgO0/AlmhsHVnSmuXhmgj2QQ503FVUUuGW','25/04/2000','0965603394','Nam','e1692804-71e3-4d6a-be08-3258692ce50b');
/*!40000 ALTER TABLE `nguoi_dung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung_vaitro`
--

DROP TABLE IF EXISTS `nguoidung_vaitro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung_vaitro` (
  `nguoidung_id` int NOT NULL,
  `vaitro_id` int NOT NULL,
  PRIMARY KEY (`nguoidung_id`,`vaitro_id`),
  KEY `FKjx0c5d875frfyw09nb4ajxs03` (`vaitro_id`),
  CONSTRAINT `FKjx0c5d875frfyw09nb4ajxs03` FOREIGN KEY (`vaitro_id`) REFERENCES `vai_tro` (`id`),
  CONSTRAINT `FKpaklpuw2w0trk3j8a6gi5mr8s` FOREIGN KEY (`nguoidung_id`) REFERENCES `nguoi_dung` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung_vaitro`
--

LOCK TABLES `nguoidung_vaitro` WRITE;
/*!40000 ALTER TABLE `nguoidung_vaitro` DISABLE KEYS */;
INSERT INTO `nguoidung_vaitro` VALUES (4,1),(1,2),(3,2),(4,2),(5,2);
/*!40000 ALTER TABLE `nguoidung_vaitro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phim`
--

DROP TABLE IF EXISTS `phim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phim` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dao_dien` varchar(255) DEFAULT NULL,
  `dien_vien` varchar(255) DEFAULT NULL,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten_phim` varchar(255) DEFAULT NULL,
  `the_loai` varchar(255) DEFAULT NULL,
  `thoi_luong` int NOT NULL,
  `trailer` varchar(255) DEFAULT NULL,
  `ngay_cong_chieu` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phim`
--

LOCK TABLES `phim` WRITE;
/*!40000 ALTER TABLE `phim` DISABLE KEYS */;
INSERT INTO `phim` VALUES (2,'Lý Hải','Võ Thành Tâm, Mạc Văn Khoa, Huỳnh Đông.','https://baitap.gg.s3.ap-southeast-1.amazonaws.com/f00e2853-abad-4f3a-a7f2-545a298f1696.jfif','Lý Hải trở lại với dòng phim hành động sở trường của mình. Bối cảnh hoành tráng với sự đầu tư nghiêm túc, siêu phẩm hành động Việt Lật Mặt 48h sẽ kể về một hành trình trốn chạy đầy kịch tính, nghẹt thở đến phút cuối cùng.','LẬT MẶT: 48H','Hành Động',110,'https://www.youtube.com/embed/RY30ngiSJHA','2022-03-07'),(4,'Jon Watts','Tom Holland, Zendaya, Benedict Cumberbatch, Jacob Batalon, Jon Favreau','https://baitap.gg.s3.ap-southeast-1.amazonaws.com/b41e6961-a2a0-4950-85b9-9ae7d145775d.jpg','Lần đầu tiên trong lịch sử điện ảnh của Người Nhện, thân phận người hàng xóm thân thiện bị lật mở, khiến trách nhiệm làm một Siêu Anh Hùng xung đột với cuộc sống bình thường và đặt người anh quan tâm nhất vào tình thế nguy hiểm.','NO WAY HOME','Hành Động ',150,'https://www.youtube.com/embed/OB3g37GTALc','2022-03-02'),(5,'Matt Reeves','Robert Pattinson, Colin Farrell, Zoe Kravitz, Andy Serkis  ','https://baitap.gg.s3.ap-southeast-1.amazonaws.com/15348159-82bc-4525-8717-64649d249750.jpg','Bộ phim đưa khán giả dõi theo hành trình phá án và diệt trừ tội phạm của chàng Hiệp sĩ Bóng đêm Batman, với một câu chuyện hoàn toàn khác biệt với những phần phim đã ra mắt trước đây. ','THE BATMAN ','Hành Động ',150,'https://www.youtube.com/embed/mqqft2x_Aa4','2022-03-24'),(8,'James Cameron','Sam Worthington, Zoe Saldana, Stephen Lang, Giovanni Ribisi, Vin Diesel, Edie Falco, Michelle Yeoh, Jemaine Clement, Cliff Curtis, Kate Winslet, Sigourney Weaver.','https://baitap.gg.s3.ap-southeast-1.amazonaws.com/1a563d48-be01-4d98-9c85-93bb16192899.jfif','Avatar 2 là bộ phim thuộc thể loại khoa học viễn tưởng của Mỹ được ra mắt vào năm 2018. Với sự góp mặt của hàng loạt diễn viên nổi tiếng bậc nhất thế giới và cũng từng đóng trong Avatar 1 như Sam Worthington, Zoe Saldana, Stephen Lang và Sigourney Weaver.','AVATAR 2','Phim Viễn tưởng',121,'https://www.youtube.com/embed/AxLH0lXEGAY','2022-03-09'),(9,' Khoa Nguyễn','Quang Sự, Oanh Kiều, Phạm Quỳnh Anh, Quốc Cường, Lý Hồng Ân','https://baitap.gg.s3.ap-southeast-1.amazonaws.com/257de2ae-b852-4813-94a0-69183c240aed.jpg','Một nữ nhà văn, một chuyên gia tâm lý, một bác sĩ tâm thần và một nữ doanh nhân cùng nhau bị cuốn vào những ám ảnh không hồi kết của người phụ nữ với gương mặt mờ ảo','NGƯỜI LẮNG NGHE','Hồi hộp, Tâm Lý',119,'https://www.youtube.com/embed/L47YK5MSPhU','2022-03-07'),(10,'Gunhild Enger, Rune Spaans','Hermann Sabado, Per Inge Torkelsen, Anne Grete Preus','https://baitap.gg.s3.ap-southeast-1.amazonaws.com/108a79e8-8592-4fbd-8e33-b28c756e85c3.jpg','Cuộc sống bình yên của Tootson và Ludiwood đột nhiên đảo lộn vì họ bị đuổi ra khỏi đường hầm mà mình đang sinh sống. Đứng trước mênh mông trời núi, hai cậu bạn thân quyết tâm lên đường tìm người ông đáng kính.','CHUYẾN PHIÊU LƯU','Hoạt Hình, Phiêu Lưu',76,'https://www.youtube.com/embed/4q8S0DAbYxA','2022-03-10'),(13,'Michael Bay','Jake Gyllenhaal, Elza González, Yahya Abdul-Mateen II','https://baitap.gg.s3.ap-southeast-1.amazonaws.com/a82464ee-8b1b-4c34-871b-4dbb520ab750.jpg','2 anh em tham gia một vụ cướp ngân hàng và chạy trốn trên chiếc xe cứu thương. Và từ đây, cuộc truy đuổi nghẹt thở và gay cấn nhất trên khắp đường phố LA bắt đầu.','XE CẤP CỨU','Hành Động',137,'https://www.youtube.com/embed/iVJCALQAOyU','2022-03-20'),(15,'Daniel Espinosa','Jared Leto, Michael Keaton, Adria Arjona','https://baitap.gg.s3.ap-southeast-1.amazonaws.com/2b1605e3-bf57-4ee0-b5c8-d5029ebf381b.jpg','Một huyền thoại Marvel mới sắp lộ diện. Là ác nhân hay anh hùng? Sẽ phá hủy hay chữa lành thế giới này? Morbius khởi chiếu tại CGV 01.04.2022','MORBIUS','Hành Động, Phiêu Lưu',104,'https://www.youtube.com/embed/oZ6iiRrz1SY&t=2s','2022-04-03');
/*!40000 ALTER TABLE `phim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phong`
--

DROP TABLE IF EXISTS `phong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phong` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cot` int NOT NULL,
  `hang` int NOT NULL,
  `ten_phong` varchar(255) DEFAULT NULL,
  `rap_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKalgyqukqt63we7q8x9gdvtdvv` (`rap_id`),
  CONSTRAINT `FKalgyqukqt63we7q8x9gdvtdvv` FOREIGN KEY (`rap_id`) REFERENCES `rap` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phong`
--

LOCK TABLES `phong` WRITE;
/*!40000 ALTER TABLE `phong` DISABLE KEYS */;
INSERT INTO `phong` VALUES (18,5,5,'phòng 1',4),(21,10,5,'phòng 1',5),(22,5,5,'phòng 1',7),(23,5,5,'phòng 1',6),(25,10,10,'phòng 1',8),(26,5,5,'phòng 2',4),(27,5,10,'phòng 1',9),(28,5,5,'phòng 2',10),(29,5,5,'phòng 1',10),(32,5,5,'phòng 1',11),(33,10,10,'phòng 2',8),(35,5,8,'phòng 1',13),(39,5,12,'phòng 3',4);
/*!40000 ALTER TABLE `phong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rap`
--

DROP TABLE IF EXISTS `rap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dia_chi` varchar(255) DEFAULT NULL,
  `ten_rap` varchar(255) DEFAULT NULL,
  `khuvuc_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnl62ch17kxxdnykt7xmlsyajs` (`khuvuc_id`),
  CONSTRAINT `FKnl62ch17kxxdnykt7xmlsyajs` FOREIGN KEY (`khuvuc_id`) REFERENCES `khu_vuc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rap`
--

LOCK TABLES `rap` WRITE;
/*!40000 ALTER TABLE `rap` DISABLE KEYS */;
INSERT INTO `rap` VALUES (4,'12-Nguyễn Văn Quá -Q12','GLX Nguyễn Văn Quá',4),(5,'12-Võ Thị Sau-TP. Vũng Tàu','GLX Vũng Tàu',5),(6,'le thi rieng Ha Noi','GLX Indochina Plaza Hà Nội',7),(7,'12 - Hoàng Văn Thụ - TP.Thủ Dầu Một','GLX Bình Dương',6),(8,'12-Hoàng văn thụ - TP.Hải Phòng','GLX Hải Phòng',8),(9,'12- Le Thi Rieng - Q.Tân Bình','GLX Tân Bình',4),(10,'13-Hoàng Hoa Thám - Q.Gò Vấp','GLX Gò Vấp',4),(11,'Vũng Tàu','GLX Vũng Tàu 1',5),(13,'Quận 1','GLX Quận 1',4);
/*!40000 ALTER TABLE `rap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suat_chieu`
--

DROP TABLE IF EXISTS `suat_chieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suat_chieu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gia_ve` double NOT NULL,
  `gio_bat_dau` varchar(255) DEFAULT NULL,
  `ngay_chieu` date DEFAULT NULL,
  `phim_id` int DEFAULT NULL,
  `the_loai_id` int DEFAULT NULL,
  `phong_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe9440vde3vmquhwxjaxbjr77a` (`phim_id`),
  KEY `FKo39lhfv86a2dnkekfbtgqjfcf` (`the_loai_id`),
  KEY `FKreocw1ncmybf5buj3oo7vqu1e` (`phong_id`),
  CONSTRAINT `FKe9440vde3vmquhwxjaxbjr77a` FOREIGN KEY (`phim_id`) REFERENCES `phim` (`id`),
  CONSTRAINT `FKo39lhfv86a2dnkekfbtgqjfcf` FOREIGN KEY (`the_loai_id`) REFERENCES `the_loai` (`id`),
  CONSTRAINT `FKreocw1ncmybf5buj3oo7vqu1e` FOREIGN KEY (`phong_id`) REFERENCES `phong` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suat_chieu`
--

LOCK TABLES `suat_chieu` WRITE;
/*!40000 ALTER TABLE `suat_chieu` DISABLE KEYS */;
INSERT INTO `suat_chieu` VALUES (14,150000,'23:30','2022-06-11',2,2,18),(16,150000,'21:30','2022-06-11',2,2,21),(18,150000,'15:36','2022-06-11',4,2,22),(24,180000,'21:00','2022-06-21',2,2,22),(26,150000,'18:30','2022-06-11',2,2,27),(29,150000,'19:20','2022-06-11',4,2,18),(30,120000,'08:35','2022-06-11',5,2,18),(34,200000,'20:00','2022-06-11',2,2,18),(35,120000,'01:17','2022-06-11',4,2,18),(39,150000,'10:05','2022-06-11',2,3,18),(41,120000,'02:06','2022-06-11',5,2,18),(45,150000,'22:30','2022-06-11',9,2,18),(49,120000,'22:00','2022-06-11',2,3,32),(57,120000,'10:20','2022-06-11',4,2,18),(58,123000,'20:23','2022-06-11',2,2,18),(59,120000,'19:25','2022-06-11',8,2,18),(60,150000,'18:30','2022-06-11',9,2,21),(61,120000,'21:30','2022-06-11',9,2,22),(63,120000,'18:45','2022-06-11',10,2,18),(65,120000,'14:50','2022-06-11',9,2,21),(66,120000,'15:50','2022-06-11',10,2,21),(67,190000,'20:30','2022-06-11',10,2,33),(68,120000,'09:20','2022-06-11',10,2,18),(69,120000,'22:00','2022-06-11',2,2,22),(70,120000,'21:30','2022-05-23',2,2,26),(71,120000,'17:50','2022-03-25',10,2,33),(72,120000,'18:00','2022-05-14',2,3,21),(73,120000,'20:00','2022-03-25',13,3,35),(74,120000,'22:40','2022-03-25',13,2,18),(75,120000,'23:00','2022-03-25',13,3,18),(77,120000,'05:20','2022-04-04',2,2,18),(83,120000,'21:25','2022-05-23',2,2,39);
/*!40000 ALTER TABLE `suat_chieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `the_loai`
--

DROP TABLE IF EXISTS `the_loai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `the_loai` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `the_loai`
--

LOCK TABLES `the_loai` WRITE;
/*!40000 ALTER TABLE `the_loai` DISABLE KEYS */;
INSERT INTO `the_loai` VALUES (2,'2D'),(3,'3D');
/*!40000 ALTER TABLE `the_loai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vai_tro`
--

DROP TABLE IF EXISTS `vai_tro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vai_tro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vai_tro`
--

LOCK TABLES `vai_tro` WRITE;
/*!40000 ALTER TABLE `vai_tro` DISABLE KEYS */;
INSERT INTO `vai_tro` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_MEMBER');
/*!40000 ALTER TABLE `vai_tro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-23 12:09:55
