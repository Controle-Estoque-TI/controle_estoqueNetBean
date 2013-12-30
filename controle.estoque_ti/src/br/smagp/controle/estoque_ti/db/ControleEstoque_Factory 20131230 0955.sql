-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.85-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema controle_estoque
--

CREATE DATABASE IF NOT EXISTS controle_estoque;
USE controle_estoque;

--
-- Definition of table `chefias`
--

DROP TABLE IF EXISTS `chefias`;
CREATE TABLE `chefias` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(256) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `cod_orgao` int(10) unsigned NOT NULL,
  `setor` varchar(256) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_chefia_orgao` (`cod_orgao`),
  CONSTRAINT `FK_chefia_orgao` FOREIGN KEY (`cod_orgao`) REFERENCES `orgaos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chefias`
--

/*!40000 ALTER TABLE `chefias` DISABLE KEYS */;
/*!40000 ALTER TABLE `chefias` ENABLE KEYS */;


--
-- Definition of table `controle`
--

DROP TABLE IF EXISTS `controle`;
CREATE TABLE `controle` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `cod_equipamento` int(10) unsigned NOT NULL,
  `cod_tecnico` int(10) unsigned NOT NULL,
  `cod_orgao` int(10) unsigned NOT NULL,
  `setor_orgao` varchar(45) NOT NULL,
  `cod_chefia` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_controle_equipamento` (`cod_equipamento`),
  KEY `FK_controle_tecnico` (`cod_tecnico`),
  KEY `FK_controle_orgao` (`cod_orgao`),
  KEY `FK_controle_chefia` (`cod_chefia`),
  CONSTRAINT `FK_controle_chefia` FOREIGN KEY (`cod_chefia`) REFERENCES `chefias` (`id`),
  CONSTRAINT `FK_controle_orgao` FOREIGN KEY (`cod_orgao`) REFERENCES `orgaos` (`id`),
  CONSTRAINT `FK_controle_tecnico` FOREIGN KEY (`cod_tecnico`) REFERENCES `tecnicos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `controle`
--

/*!40000 ALTER TABLE `controle` DISABLE KEYS */;
/*!40000 ALTER TABLE `controle` ENABLE KEYS */;


--
-- Definition of table `equipamentos`
--

DROP TABLE IF EXISTS `equipamentos`;
CREATE TABLE `equipamentos` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `n_serie` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `patrimonio` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipamentos`
--

/*!40000 ALTER TABLE `equipamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamentos` ENABLE KEYS */;


--
-- Definition of table `orgaos`
--

DROP TABLE IF EXISTS `orgaos`;
CREATE TABLE `orgaos` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome_orgao` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orgaos`
--

/*!40000 ALTER TABLE `orgaos` DISABLE KEYS */;
/*!40000 ALTER TABLE `orgaos` ENABLE KEYS */;


--
-- Definition of table `tecnicos`
--

DROP TABLE IF EXISTS `tecnicos`;
CREATE TABLE `tecnicos` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `setor` varchar(45) NOT NULL,
  `password` varchar(256) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tecnicos`
--

/*!40000 ALTER TABLE `tecnicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tecnicos` ENABLE KEYS */;


--
-- Definition of table `tipo_equipamentos`
--

DROP TABLE IF EXISTS `tipo_equipamentos`;
CREATE TABLE `tipo_equipamentos` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_equipamentos`
--

/*!40000 ALTER TABLE `tipo_equipamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_equipamentos` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
