-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ecoalerta
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo` (
  `Id_articulo` int NOT NULL AUTO_INCREMENT,
  `Id_seccion_FK` int NOT NULL,
  `titulo_articulo` varchar(255) DEFAULT NULL,
  `informacion_articulo` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Id_articulo`),
  KEY `Id_seccion_idx` (`Id_seccion_FK`),
  CONSTRAINT `Id_seccion` FOREIGN KEY (`Id_seccion_FK`) REFERENCES `seccion` (`Id_seccion`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES (17,3,'Declarada calamidad pública en Cundinamarca ante el fenómeno del Niño','La declaratoria ayudará a dirigir recursos para atender las emergencias. En el 2024 han aumentado en un 3.000% los incendios forestales, afectando alrededor de 325 hectáreas de vegetación.'),(18,3,'Parque Nacional Natural Pisba','El Parque Nacional Natural Pisba tiene una localización estratégica ya que es el punto de nacimiento de importantes ríos, quebradas y Lagunas. Constituye un área representativa de los ecosistemas de páramo, subpáramo y bosque altoandino del nororiente de Boyacá conformando el llamado corredor Biológico Tota-Pisba-Cocuy. Posee elementos únicos y de gran relevancia que realzan su importancia en el contexto de la conservación de la biodiversidad de la Cordillera '),(19,3,'Se alista la primera Ruta del Frailejón en bicicleta de Sogamoso','Será una rodada por el medio ambiente sobre una ruta que abarca 25 kilómetros y tendrá altitud máxima de 2,988 msnm, teniendo como punto de partida la calle 17 #10-61 y punto de llegada La Capilla de Santa Barbara, el próximo 10 de septiembre a partir de las 7:00 am.'),(20,3,'Una rana endémica de Boyacá está en peligro por la reducción de su hábitat','conocida en algunas regiones de Boyacá como ‘ranita de agua’, es una especie de anfibio propio de zonas de páramo y bosque alto andino en ecosistemas entre los 2.950 y los 3.800 metros sobre el nivel del mar, pero sobre todo de la región comprendida entre Ciénega, Ramiriquí y Zetaquira.'),(21,1,'El Dorado Radio','https://eldoradoradio.cundinamarca.gov.co/inicio/'),(22,1,'City Tv','https://citytv.eltiempo.com/'),(23,1,'Gobernacion de Boyacá','https://www.boyaca.gov.co/secretariaambientedesarrollosostenible/');
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulo_seq`
--

DROP TABLE IF EXISTS `articulo_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo_seq`
--

LOCK TABLES `articulo_seq` WRITE;
/*!40000 ALTER TABLE `articulo_seq` DISABLE KEYS */;
INSERT INTO `articulo_seq` VALUES (1);
/*!40000 ALTER TABLE `articulo_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulo_usuario`
--

DROP TABLE IF EXISTS `articulo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo_usuario` (
  `Id_Articulo_Usuario` int NOT NULL AUTO_INCREMENT,
  `Id_usuario_FK` int NOT NULL,
  `Id_articulo_FK` int NOT NULL,
  PRIMARY KEY (`Id_Articulo_Usuario`),
  KEY `Id_articulo_idx` (`Id_articulo_FK`),
  KEY `Id_usuario_idx` (`Id_usuario_FK`),
  CONSTRAINT `FK_Articulo_Articulo_Usuario` FOREIGN KEY (`Id_articulo_FK`) REFERENCES `articulo` (`Id_articulo`),
  CONSTRAINT `FK_Usuario_Articulo_Usuario` FOREIGN KEY (`Id_usuario_FK`) REFERENCES `usuario` (`Id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo_usuario`
--

LOCK TABLES `articulo_usuario` WRITE;
/*!40000 ALTER TABLE `articulo_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `articulo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `Id_ciudad` int NOT NULL AUTO_INCREMENT,
  `Nombre_ciudad` varchar(50) DEFAULT NULL,
  `Id_departamento_FK` int NOT NULL,
  PRIMARY KEY (`Id_ciudad`),
  KEY `idDepartamento_idx` (`Id_departamento_FK`),
  CONSTRAINT `Id_departamento` FOREIGN KEY (`Id_departamento_FK`) REFERENCES `departamento` (`Id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Paipa',1);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad_seq`
--

DROP TABLE IF EXISTS `ciudad_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad_seq`
--

LOCK TABLES `ciudad_seq` WRITE;
/*!40000 ALTER TABLE `ciudad_seq` DISABLE KEYS */;
INSERT INTO `ciudad_seq` VALUES (1);
/*!40000 ALTER TABLE `ciudad_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentario` (
  `Id_comentario` int NOT NULL AUTO_INCREMENT,
  `comentario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id_comentario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` VALUES (9,'Este es un nuevo comentario');
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarioarticulo`
--

DROP TABLE IF EXISTS `comentarioarticulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentarioarticulo` (
  `Id_comentario_articulo` int NOT NULL AUTO_INCREMENT,
  `Id_articulo_FK` int NOT NULL,
  `Id_comentario_FK` int NOT NULL,
  `Id_usuario_FK` int NOT NULL,
  PRIMARY KEY (`Id_comentario_articulo`),
  KEY `Id_comentario_idx` (`Id_comentario_FK`),
  KEY `Id_articulo_idx` (`Id_articulo_FK`),
  KEY `Id_usuario_idx` (`Id_usuario_FK`),
  CONSTRAINT `FK_Articulo` FOREIGN KEY (`Id_articulo_FK`) REFERENCES `articulo` (`Id_articulo`),
  CONSTRAINT `FK_Comentario` FOREIGN KEY (`Id_comentario_FK`) REFERENCES `comentario` (`Id_comentario`),
  CONSTRAINT `FK_Usuario` FOREIGN KEY (`Id_usuario_FK`) REFERENCES `usuario` (`Id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarioarticulo`
--

LOCK TABLES `comentarioarticulo` WRITE;
/*!40000 ALTER TABLE `comentarioarticulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentarioarticulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `Id_departamento` int NOT NULL AUTO_INCREMENT,
  `Nombre_departamento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Boyacá');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento_seq`
--

DROP TABLE IF EXISTS `departamento_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento_seq`
--

LOCK TABLES `departamento_seq` WRITE;
/*!40000 ALTER TABLE `departamento_seq` DISABLE KEYS */;
INSERT INTO `departamento_seq` VALUES (1);
/*!40000 ALTER TABLE `departamento_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
  `Id_imagen` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(50) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Id_imagen`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen`
--

LOCK TABLES `imagen` WRITE;
/*!40000 ALTER TABLE `imagen` DISABLE KEYS */;
INSERT INTO `imagen` VALUES (3,'deforestacion','https://caracoltv.brightspotcdn.com/dims4/default/a542248/2147483647/strip/true/crop/1280x720+0+0/resize/1000x563!/quality/90/?url=http%3A%2F%2Fcaracol-brightspot.s3.us-west-2.amazonaws.com%2Ff3%2F8e%2F0b0a548c49c6959d56eb2a900ba8%2Fincendio-cundinamarca.jpg'),(4,'pisba','https://www.dejusticia.org/wp-content/uploads/2019/04/1200px-Panorama_Playa_de_los_Frailejones_-_Pa%CC%81ramo_de_Oceta%CC%81.jpg'),(5,'rutaFrailejon','https://www.forbes.com.mx/2016/04/mtb-1169959_1280-e1460995679769.jpg'),(6,'jpe','https://956fm.boyaca.gov.co/wp-content/uploads/2023/08/Foto_Felipe-Villegas-Instituto-Humboldt.jpg'),(7,'citytv','https://cdn.worldvectorlogo.com/logos/citytv.svg'),(8,'eldorado','https://eldoradoradio.cundinamarca.gov.co/contenthandler/dav/fs-type1/themes/ElDoradoRadioGovCo/images/logo-eldorado-derecha.png'),(9,'boyaca','https://www.boyaca.gov.co/secretariaambientedesarrollosostenible/wp-content/uploads/sites/89/2021/03/Gobernacion-de-Boyaca%CC%81_Horizontal-300x141.png');
/*!40000 ALTER TABLE `imagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagenarticulo`
--

DROP TABLE IF EXISTS `imagenarticulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagenarticulo` (
  `Id_imagen_articulo` int NOT NULL AUTO_INCREMENT,
  `Id_articulo_FK` int NOT NULL,
  `Id_imagen_FK` int NOT NULL,
  PRIMARY KEY (`Id_imagen_articulo`),
  KEY `idImagen_idx` (`Id_imagen_FK`),
  KEY `Id_articulo_idx` (`Id_articulo_FK`),
  CONSTRAINT `Id_articulo` FOREIGN KEY (`Id_articulo_FK`) REFERENCES `articulo` (`Id_articulo`),
  CONSTRAINT `Id_imagen` FOREIGN KEY (`Id_imagen_FK`) REFERENCES `imagen` (`Id_imagen`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenarticulo`
--

LOCK TABLES `imagenarticulo` WRITE;
/*!40000 ALTER TABLE `imagenarticulo` DISABLE KEYS */;
INSERT INTO `imagenarticulo` VALUES (50,17,3),(51,18,4),(52,19,5),(53,20,6),(54,22,7),(55,21,8),(56,23,9);
/*!40000 ALTER TABLE `imagenarticulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like`
--

DROP TABLE IF EXISTS `like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like` (
  `Id_like` int NOT NULL AUTO_INCREMENT,
  `Id_articulo_FK` int NOT NULL,
  `Id_usuario_FK` int NOT NULL,
  PRIMARY KEY (`Id_like`),
  KEY `Id_articulo_idx` (`Id_articulo_FK`),
  KEY `Id_usuario_idx` (`Id_usuario_FK`),
  CONSTRAINT `FK_Articulo_Like` FOREIGN KEY (`Id_articulo_FK`) REFERENCES `articulo` (`Id_articulo`),
  CONSTRAINT `FK_Usuario_Like` FOREIGN KEY (`Id_usuario_FK`) REFERENCES `usuario` (`Id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like`
--

LOCK TABLES `like` WRITE;
/*!40000 ALTER TABLE `like` DISABLE KEYS */;
/*!40000 ALTER TABLE `like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `Id_rol` int NOT NULL AUTO_INCREMENT,
  `Nombre_rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'admin'),(2,'visitante');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_seq`
--

DROP TABLE IF EXISTS `rol_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_seq`
--

LOCK TABLES `rol_seq` WRITE;
/*!40000 ALTER TABLE `rol_seq` DISABLE KEYS */;
INSERT INTO `rol_seq` VALUES (1);
/*!40000 ALTER TABLE `rol_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_usuario`
--

DROP TABLE IF EXISTS `rol_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_usuario` (
  `Id_rol_usuario` int NOT NULL AUTO_INCREMENT,
  `Id_usuario_FK` int NOT NULL,
  `Id_rol_FK` int NOT NULL,
  PRIMARY KEY (`Id_rol_usuario`),
  KEY `Id_rol_idx` (`Id_rol_FK`),
  KEY `Id_usuario_idx` (`Id_usuario_FK`),
  CONSTRAINT `Id_rol` FOREIGN KEY (`Id_rol_FK`) REFERENCES `rol` (`Id_rol`),
  CONSTRAINT `Id_usuario` FOREIGN KEY (`Id_usuario_FK`) REFERENCES `usuario` (`Id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_usuario`
--

LOCK TABLES `rol_usuario` WRITE;
/*!40000 ALTER TABLE `rol_usuario` DISABLE KEYS */;
INSERT INTO `rol_usuario` VALUES (1,1,1),(3,1,2),(4,4,1),(5,7,1),(6,8,1),(7,9,1),(8,10,1),(9,11,1),(10,12,1);
/*!40000 ALTER TABLE `rol_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seccion` (
  `Id_seccion` int NOT NULL AUTO_INCREMENT,
  `Nombre_seccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id_seccion`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion`
--

LOCK TABLES `seccion` WRITE;
/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` VALUES (1,'Referencias Bibliograficas'),(3,'Impactos Ambientales');
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion_seq`
--

DROP TABLE IF EXISTS `seccion_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seccion_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion_seq`
--

LOCK TABLES `seccion_seq` WRITE;
/*!40000 ALTER TABLE `seccion_seq` DISABLE KEYS */;
INSERT INTO `seccion_seq` VALUES (1);
/*!40000 ALTER TABLE `seccion_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `Id_usuario` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `Id_ciudad_FK` int NOT NULL,
  `account_no_expired` bit(1) DEFAULT NULL,
  `account_no_locked` bit(1) DEFAULT NULL,
  `credential_no_expired` bit(1) DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`Id_usuario`),
  KEY `Id_ciudad_idx` (`Id_ciudad_FK`),
  CONSTRAINT `Id_ciudad` FOREIGN KEY (`Id_ciudad_FK`) REFERENCES `ciudad` (`Id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'ecamacho','sadad','sadasd','3323','sadsad','$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6',1,NULL,NULL,NULL,NULL),(4,'camacho','edisson','camacho','454','asdsa','$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6',1,_binary '',_binary '',_binary '',_binary ''),(5,'carlos','Carlos Antonio ','Camacho Robles','3186306150','edisupermanes45@gmail.com','1234',1,_binary '',_binary '',_binary '',_binary ''),(6,'carlos','Carlos Antonio ','Camacho Robles','3186306150','edisupermanes45@gmail.com','1234',1,_binary '',_binary '',_binary '',_binary ''),(7,'carlos','Carlos Antonio ','Camacho Robles','3186306150','edisupermanes45@gmail.com','1234',1,_binary '',_binary '',_binary '',_binary ''),(8,'antonio','Carlos Antonio ','Camacho Robles','3186306150','edisupermanes45@gmail.com','1234',1,_binary '',_binary '',_binary '',_binary ''),(9,'arturo','Carlos Antonio ','Camacho Robles','3186306150','edisupermanes45@gmail.com','$2a$10$ZLUY3WUROs4Wy4OULWy6zOVclj8w.jh04GbMMMhebp8/57EMqkmVy',1,_binary '',_binary '',_binary '',_binary ''),(10,'carmenza','Carlos Antonio ','Camacho Robles','3186306150','edisupermanes45@gmail.com','$2a$10$QWOYAbqFf7DGQap3FF9zv.2t.jjwlilvVY.7BRiP/0iMTuNvEuR12',1,_binary '',_binary '',_binary '',_binary ''),(11,'papito','Pedro ','aguilar','545454544','edisupermanes45@gmail.com','$2a$10$gmh2bcpqvCQE4ufP6P3rQONBby6Zv/c06Mtk5IRyolGPYaBNuA7cS',1,_binary '',_binary '',_binary '',_binary '\0'),(12,'carla','Carla','Camacho','3212354','edisupermanes45@gmail.com','$2a$10$cALC325RCPoWmX825Iag8.i06mklMhnHtrYYJtcPJbEEh0/BBsZXG',1,_binary '',_binary '',_binary '',_binary '');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-24 19:43:38
