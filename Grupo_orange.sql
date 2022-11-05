CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clase` (
  `idClase` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idClase`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase`
--

LOCK TABLES `clase` WRITE;
/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
INSERT INTO `clase` VALUES (1,'Dragon'),(2,'Fantasma'),(3,'Demonio'),(4,'Pez'),(5,'Humano'),(6,'Bestia'),(7,'Ave'),(8,'Otros');
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elementos`
--

DROP TABLE IF EXISTS `elementos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elementos` (
  `idelementos` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idelementos`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementos`
--

LOCK TABLES `elementos` WRITE;
/*!40000 ALTER TABLE `elementos` DISABLE KEYS */;
INSERT INTO `elementos` VALUES (1,'Fuego'),(2,'Tierra'),(3,'Agua '),(4,'Viento');
/*!40000 ALTER TABLE `elementos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elementos_has_clase`
--

DROP TABLE IF EXISTS `elementos_has_clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elementos_has_clase` (
  `elementos_idelementos` int NOT NULL,
  `clase_idClase` int NOT NULL,
  `debil_fortaleza` varchar(45) DEFAULT NULL,
  `porcentaje_dano_recib` float NOT NULL,
  PRIMARY KEY (`elementos_idelementos`,`clase_idClase`),
  KEY `fk_elementos_has_clase_clase1_idx` (`clase_idClase`),
  KEY `fk_elementos_has_clase_elementos1_idx` (`elementos_idelementos`),
  CONSTRAINT `fk_elementos_has_clase_clase1` FOREIGN KEY (`clase_idClase`) REFERENCES `clase` (`idClase`),
  CONSTRAINT `fk_elementos_has_clase_elementos1` FOREIGN KEY (`elementos_idelementos`) REFERENCES `elementos` (`idelementos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementos_has_clase`
--

LOCK TABLES `elementos_has_clase` WRITE;
/*!40000 ALTER TABLE `elementos_has_clase` DISABLE KEYS */;
INSERT INTO `elementos_has_clase` VALUES (1,1,NULL,0.6),(1,3,NULL,0.7),(1,4,NULL,0.9),(2,5,NULL,0.7),(2,6,NULL,0.5),(3,2,NULL,0.4),(3,7,NULL,0.6),(4,3,NULL,0.3);
/*!40000 ALTER TABLE `elementos_has_clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enemigos`
--

DROP TABLE IF EXISTS `enemigos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enemigos` (
  `idEnemigos` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `genero` char(1) DEFAULT NULL,
  `experiencia_x_derrota` int NOT NULL,
  `ataque` int NOT NULL,
  `clase_idClase1` int NOT NULL,
  PRIMARY KEY (`idEnemigos`),
  KEY `fk_enemigos_clase1_idx` (`clase_idClase1`),
  CONSTRAINT `fk_enemigos_clase1` FOREIGN KEY (`clase_idClase1`) REFERENCES `clase` (`idClase`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enemigos`
--

LOCK TABLES `enemigos` WRITE;
/*!40000 ALTER TABLE `enemigos` DISABLE KEYS */;
INSERT INTO `enemigos` VALUES (1,'Akuma','M',30,10,1),(2,'Robin','M',20,15,3),(3,'Harley','F',10,20,7),(4,'Wilkes','M',30,5,6),(5,'Anakin','F',25,30,5),(6,'Alpha','M',30,25,2),(7,'Almeida','F',15,10,1),(8,'Allan','F',10,10,3),(9,'Smith','M',30,40,6),(10,'Skywalker','M',25,30,4),(11,'Beaumont','M',20,15,2),(12,'Wilkes','F',12,30,4);
/*!40000 ALTER TABLE `enemigos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enemigos_has_objeto_dejado_x_derrota`
--

DROP TABLE IF EXISTS `enemigos_has_objeto_dejado_x_derrota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enemigos_has_objeto_dejado_x_derrota` (
  `enemigos_idEnemigos` int NOT NULL,
  `objeto_dejado_x_derrota_idobjeto_dejado_x_derrota` int NOT NULL,
  `probabilidad_dejar_objeto` float NOT NULL,
  PRIMARY KEY (`enemigos_idEnemigos`,`objeto_dejado_x_derrota_idobjeto_dejado_x_derrota`),
  KEY `fk_enemigos_has_objeto_dejado_x_derrota_objeto_dejado_x_der_idx` (`objeto_dejado_x_derrota_idobjeto_dejado_x_derrota`),
  KEY `fk_enemigos_has_objeto_dejado_x_derrota_enemigos1_idx` (`enemigos_idEnemigos`),
  CONSTRAINT `fk_enemigos_has_objeto_dejado_x_derrota_enemigos1` FOREIGN KEY (`enemigos_idEnemigos`) REFERENCES `enemigos` (`idEnemigos`),
  CONSTRAINT `fk_enemigos_has_objeto_dejado_x_derrota_objeto_dejado_x_derro1` FOREIGN KEY (`objeto_dejado_x_derrota_idobjeto_dejado_x_derrota`) REFERENCES `objeto_dejado_x_derrota` (`idobjeto_dejado_x_derrota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enemigos_has_objeto_dejado_x_derrota`
--

LOCK TABLES `enemigos_has_objeto_dejado_x_derrota` WRITE;
/*!40000 ALTER TABLE `enemigos_has_objeto_dejado_x_derrota` DISABLE KEYS */;
INSERT INTO `enemigos_has_objeto_dejado_x_derrota` VALUES (1,2,0.6),(2,1,0.3),(3,1,0.4),(4,2,0.8),(5,4,0.5),(6,6,0.4),(7,8,0.9),(8,10,0.4),(9,12,0.5),(10,6,0.2),(11,5,0.7),(12,2,0.9);
/*!40000 ALTER TABLE `enemigos_has_objeto_dejado_x_derrota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hechizo_magicos`
--

DROP TABLE IF EXISTS `hechizo_magicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hechizo_magicos` (
  `idHechizoMagicos` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) NOT NULL,
  `potencia` int NOT NULL,
  `precision` int NOT NULL,
  `nivel_aprendizaje` int DEFAULT NULL,
  `elementos_idelementos` int NOT NULL,
  `hechizo_base` int DEFAULT NULL,
  PRIMARY KEY (`idHechizoMagicos`),
  KEY `fk_hechizo_magicos_elementos1_idx` (`elementos_idelementos`),
  KEY `fk_hechizo_magicos_hechizo_magicos1_idx` (`hechizo_base`),
  CONSTRAINT `fk_hechizo_magicos_elementos1` FOREIGN KEY (`elementos_idelementos`) REFERENCES `elementos` (`idelementos`),
  CONSTRAINT `fk_hechizo_magicos_hechizo_magicos1` FOREIGN KEY (`hechizo_base`) REFERENCES `hechizo_magicos` (`idHechizoMagicos`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hechizo_magicos`
--

LOCK TABLES `hechizo_magicos` WRITE;
/*!40000 ALTER TABLE `hechizo_magicos` DISABLE KEYS */;
INSERT INTO `hechizo_magicos` VALUES (1,'Infierno',10,3,5,1,2),(2,'Combustion',3,2,1,1,NULL),(3,'Confundo',5,6,4,3,5),(4,'Engorgio',4,8,2,2,NULL),(5,'Colloprtus',6,6,6,4,NULL),(6,'ExpectroPatrnum',8,5,7,3,NULL),(7,'Alohomora',5,10,4,2,NULL),(8,'Caterwauling',10,5,3,1,11),(9,'Imperio',8,7,2,2,NULL),(10,'Impervius',9,4,1,2,9),(11,'Levicorpus',4,8,5,4,NULL),(12,'Muffliato',5,6,6,3,NULL);
/*!40000 ALTER TABLE `hechizo_magicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `heroes`
--

DROP TABLE IF EXISTS `heroes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `heroes` (
  `idheroes` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(10) NOT NULL,
  `edad` int NOT NULL,
  `genero` char(1) NOT NULL,
  `nivel_inicial` int NOT NULL,
  `ataque` int NOT NULL,
  `id_pareja` int DEFAULT NULL,
  `pts_x_experiencia` int NOT NULL,
  `clase_idClase` int NOT NULL,
  PRIMARY KEY (`idheroes`),
  KEY `fk_heroes_heroes1_idx` (`id_pareja`),
  KEY `fk_heroes_clase1_idx` (`clase_idClase`),
  CONSTRAINT `fk_heroes_clase1` FOREIGN KEY (`clase_idClase`) REFERENCES `clase` (`idClase`),
  CONSTRAINT `fk_heroes_heroes1` FOREIGN KEY (`id_pareja`) REFERENCES `heroes` (`idheroes`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `heroes`
--

LOCK TABLES `heroes` WRITE;
/*!40000 ALTER TABLE `heroes` DISABLE KEYS */;
INSERT INTO `heroes` VALUES (1,'Jorge',19,'M',10,20,8,50,5),(2,'Luis ',20,'M',54,30,7,40,2),(3,'Jhon ',25,'M',12,20,NULL,60,3),(4,'Maria',19,'F',8,10,NULL,35,1),(5,'Alvaro',24,'M',23,100,NULL,60,6),(7,'Sofia',25,'F',16,40,2,34,1),(8,'Alexa',24,'F',24,25,1,55,2),(9,'Gabi',18,'F',10,15,NULL,15,7),(10,'Andre',21,'F',14,28,NULL,22,3),(11,'Jaimito',23,'M',20,55,12,40,4),(12,'Alessia',22,'F',21,30,11,30,6),(13,'Pepito',28,'M',5,15,12,20,2);
/*!40000 ALTER TABLE `heroes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `heroes_has_inventarioobjetos`
--

DROP TABLE IF EXISTS `heroes_has_inventarioobjetos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `heroes_has_inventarioobjetos` (
  `heroes_idheroes` int NOT NULL,
  `inventarioobjetos_idInventarioObjetos` int NOT NULL,
  `cantidad_objetos` int NOT NULL,
  PRIMARY KEY (`heroes_idheroes`,`inventarioobjetos_idInventarioObjetos`),
  KEY `fk_heroes_has_inventarioobjetos_inventarioobjetos1_idx` (`inventarioobjetos_idInventarioObjetos`),
  KEY `fk_heroes_has_inventarioobjetos_heroes1_idx` (`heroes_idheroes`),
  CONSTRAINT `fk_heroes_has_inventarioobjetos_heroes1` FOREIGN KEY (`heroes_idheroes`) REFERENCES `heroes` (`idheroes`),
  CONSTRAINT `fk_heroes_has_inventarioobjetos_inventarioobjetos1` FOREIGN KEY (`inventarioobjetos_idInventarioObjetos`) REFERENCES `inventarioobjetos` (`idInventarioObjetos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `heroes_has_inventarioobjetos`
--

LOCK TABLES `heroes_has_inventarioobjetos` WRITE;
/*!40000 ALTER TABLE `heroes_has_inventarioobjetos` DISABLE KEYS */;
INSERT INTO `heroes_has_inventarioobjetos` VALUES (1,1,2),(2,5,1),(3,6,1),(4,4,1),(5,2,2),(7,8,1),(8,7,2),(9,1,2),(10,2,1),(11,4,1),(12,5,1);
/*!40000 ALTER TABLE `heroes_has_inventarioobjetos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventarioobjetos`
--

DROP TABLE IF EXISTS `inventarioobjetos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventarioobjetos` (
  `idInventarioObjetos` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `uso` varchar(45) NOT NULL,
  `peso` int NOT NULL,
  PRIMARY KEY (`idInventarioObjetos`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventarioobjetos`
--

LOCK TABLES `inventarioobjetos` WRITE;
/*!40000 ALTER TABLE `inventarioobjetos` DISABLE KEYS */;
INSERT INTO `inventarioobjetos` VALUES (1,'Espada de la Muerte','Contiene energías mágicas',2),(2,'Espada Aullante','Grita y vocifera emitiendo terribles sonidos',1),(3,'Espada de Destrucción ','Poderosos hechizos de defensa',2),(4,'Escudo Hechizado','Protege gracias a una poderosa magia',3),(5,'Armadura de la Suerte','Suministrar buena suerte a su portador',5),(6,'Armadura de Sombras','Permite atravesar bosques y muros ',4),(7,'Talismán de Protección ','Es un amuleto protector',1),(8,'Capa de Niebla y Sombras','Envuelve en sombras a su poseedor',2),(9,'Amuleto Ámbar','Posee el poder de sanar las heridas',1),(10,'Collar de Zorga','Permite a su portador dominar la mente',1),(11,'Matademonios ','Para hacer frente a demonios',5),(12,'Pergamino de Dispersión','Poderosa fórmula de dispersión mágica',2);
/*!40000 ALTER TABLE `inventarioobjetos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objeto_dejado_x_derrota`
--

DROP TABLE IF EXISTS `objeto_dejado_x_derrota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `objeto_dejado_x_derrota` (
  `idobjeto_dejado_x_derrota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idobjeto_dejado_x_derrota`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objeto_dejado_x_derrota`
--

LOCK TABLES `objeto_dejado_x_derrota` WRITE;
/*!40000 ALTER TABLE `objeto_dejado_x_derrota` DISABLE KEYS */;
INSERT INTO `objeto_dejado_x_derrota` VALUES (1,'Espada de la Muerte'),(2,'Amuleto Ámbar'),(3,'Matademonios '),(4,'Espada Veloz'),(5,'Espada Mordedora'),(6,'Espada de Hueso'),(7,'Espada Bendita'),(8,'Yelmo de Dragón'),(9,'Báculo Prohibido '),(10,'Poción de la Sabiduría'),(11,'Esfera de Malfleur'),(12,'Corona del Poder');
/*!40000 ALTER TABLE `objeto_dejado_x_derrota` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-04 17:55:27
