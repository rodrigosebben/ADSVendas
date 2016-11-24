-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.36-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema adsvendas
--

CREATE DATABASE IF NOT EXISTS adsvendas;
USE adsvendas;

--
-- Definition of table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NomeCliente` varchar(255) NOT NULL,
  `TipoCliente` varchar(45) DEFAULT NULL,
  `CPFCNPJ` varchar(16) DEFAULT NULL,
  `DataNasc` date DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Compl` varchar(145) DEFAULT NULL,
  `Bairro` varchar(145) DEFAULT NULL,
  `Cidade` varchar(145) DEFAULT NULL,
  `UF` varchar(2) DEFAULT NULL,
  `CEP` varchar(9) DEFAULT NULL,
  `TelefoneResidencial` varchar(20) DEFAULT NULL,
  `TelefoneCelular` varchar(20) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_EmpresaCliente_idx` (`Empresa_id`),
  CONSTRAINT `FK_EmpresaCliente` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NomeEmpresa` varchar(255) DEFAULT NULL,
  `CNPJ` varchar(30) DEFAULT NULL,
  `IncricaoEstadual` varchar(45) DEFAULT NULL,
  `Responsavel` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Site` varchar(255) DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Compl` varchar(155) DEFAULT NULL,
  `Bairro` varchar(150) DEFAULT NULL,
  `Cidade` varchar(150) DEFAULT NULL,
  `UF` varchar(45) DEFAULT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Celular` varchar(20) DEFAULT NULL,
  `inscricaoEstadual` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `empresa`
--

/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`id`,`NomeEmpresa`,`CNPJ`,`IncricaoEstadual`,`Responsavel`,`Email`,`Site`,`Endereco`,`Compl`,`Bairro`,`Cidade`,`UF`,`Telefone`,`Celular`,`inscricaoEstadual`) VALUES 
 (1,'RS Sistemas',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (3,'Teste2','',NULL,'','','','','','','','','','',''),
 (4,'teste novo','22.222.222/2222-22',NULL,'','','','','','','','','','',''),
 (5,'Teste4','',NULL,'','','','','','','','','','',''),
 (7,'Express Systems','',NULL,'','','','','','','','','','',''),
 (8,'teste 10','',NULL,'','','','','','','','','','',''),
 (9,'teste a','',NULL,'','','','','','','','','','',''),
 (10,'teste a','',NULL,'','','','','','','','','','',''),
 (11,'teste a','',NULL,'','','','','','','','','','',''),
 (12,'Teste3 a','',NULL,'','','','','','','','','','',''),
 (13,'outro teste','44.444.444/4444-44',NULL,'','','','','','','','','','','');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;


--
-- Definition of table `frentecaixa`
--

DROP TABLE IF EXISTS `frentecaixa`;
CREATE TABLE `frentecaixa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Cliente_id` int(11) DEFAULT NULL,
  `Usuario_id` int(11) NOT NULL,
  `DataVenda` datetime NOT NULL,
  `ValorTotal` double NOT NULL,
  `ValorPago` double NOT NULL,
  `Troco` double NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Cliente_idx` (`Cliente_id`),
  KEY `FK_Usuario_idx` (`Usuario_id`),
  KEY `FK_EmpresaFrenteCaixa_idx` (`Empresa_id`),
  CONSTRAINT `FK_Cliente` FOREIGN KEY (`Cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_EmpresaFrenteCaixa` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Usuario` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `frentecaixa`
--

/*!40000 ALTER TABLE `frentecaixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `frentecaixa` ENABLE KEYS */;


--
-- Definition of table `frentecaixa_lancamentos`
--

DROP TABLE IF EXISTS `frentecaixa_lancamentos`;
CREATE TABLE `frentecaixa_lancamentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FrenteCaixa_id` int(11) NOT NULL,
  `TipoLancamento` varchar(45) NOT NULL,
  `Produto_Id` int(11) DEFAULT NULL,
  `Servico_id` int(11) DEFAULT NULL,
  `Qtd` int(11) NOT NULL,
  `Valor` double NOT NULL,
  `TotalItem` double NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Produto_idx` (`Produto_Id`),
  KEY `FK_Servico_idx` (`Servico_id`),
  KEY `FK_FrenteCaixa_idx` (`FrenteCaixa_id`),
  KEY `FK_EmpresaFreLan_idx` (`Empresa_id`),
  CONSTRAINT `FK_EmpresaFreLan` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_FrenteCaixa` FOREIGN KEY (`FrenteCaixa_id`) REFERENCES `frentecaixa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Produto` FOREIGN KEY (`Produto_Id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Servico` FOREIGN KEY (`Servico_id`) REFERENCES `servico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `frentecaixa_lancamentos`
--

/*!40000 ALTER TABLE `frentecaixa_lancamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `frentecaixa_lancamentos` ENABLE KEYS */;


--
-- Definition of table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES 
 (14);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;


--
-- Definition of table `modulos`
--

DROP TABLE IF EXISTS `modulos`;
CREATE TABLE `modulos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NomeModulo` varchar(145) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `modulos`
--

/*!40000 ALTER TABLE `modulos` DISABLE KEYS */;
/*!40000 ALTER TABLE `modulos` ENABLE KEYS */;


--
-- Definition of table `produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `NomeProduto` varchar(255) NOT NULL,
  `Produto_Tipo_ID` int(11) NOT NULL,
  `Produto_Fornecedor_ID` int(11) NOT NULL,
  `ValorCompra` double NOT NULL,
  `ValorLucro` double NOT NULL,
  `ValorVenda` double NOT NULL,
  `QtdAtual` int(11) NOT NULL,
  `QtdMinima` int(11) NOT NULL,
  `Validade` datetime DEFAULT NULL,
  `Descricao` text,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Produto_Tipo_idx` (`Produto_Tipo_ID`),
  KEY `FK_Produto_Fornecedor_idx` (`Produto_Fornecedor_ID`),
  KEY `FK_EmpresaProduto_idx` (`Empresa_id`),
  CONSTRAINT `FK_EmpresaProduto` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Produto_Fornecedor` FOREIGN KEY (`Produto_Fornecedor_ID`) REFERENCES `produto_fornecedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Produto_Tipo` FOREIGN KEY (`Produto_Tipo_ID`) REFERENCES `produto_tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produto`
--

/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;


--
-- Definition of table `produto_fornecedor`
--

DROP TABLE IF EXISTS `produto_fornecedor`;
CREATE TABLE `produto_fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NomeFornecedor` varchar(255) NOT NULL,
  `Contato` varchar(145) NOT NULL,
  `CNPJ` varchar(16) NOT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Compl` varchar(145) DEFAULT NULL,
  `Bairro` varchar(145) DEFAULT NULL,
  `Cidade` varchar(145) DEFAULT NULL,
  `UF` varchar(2) DEFAULT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  `Telefone` varchar(20) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Site` varchar(255) DEFAULT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_EmpresaFornecedor_idx` (`Empresa_id`),
  CONSTRAINT `FK_EmpresaFornecedor` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produto_fornecedor`
--

/*!40000 ALTER TABLE `produto_fornecedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto_fornecedor` ENABLE KEYS */;


--
-- Definition of table `produto_tipo`
--

DROP TABLE IF EXISTS `produto_tipo`;
CREATE TABLE `produto_tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NomeTipo_Produto` varchar(100) NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_EmpresaPTipo_idx` (`Empresa_id`),
  CONSTRAINT `FK_EmpresaPTipo` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produto_tipo`
--

/*!40000 ALTER TABLE `produto_tipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto_tipo` ENABLE KEYS */;


--
-- Definition of table `servico`
--

DROP TABLE IF EXISTS `servico`;
CREATE TABLE `servico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Sevico_tipo_id` int(11) NOT NULL,
  `NomeServico` varchar(255) NOT NULL,
  `ValorServico` double NOT NULL,
  `Descricao` text,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Servico_tipo_idx` (`Sevico_tipo_id`),
  KEY `FK_EmpresaServico_idx` (`Empresa_id`),
  CONSTRAINT `FK_EmpresaServico` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Servico_tipo` FOREIGN KEY (`Sevico_tipo_id`) REFERENCES `servico_tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `servico`
--

/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;


--
-- Definition of table `servico_tipo`
--

DROP TABLE IF EXISTS `servico_tipo`;
CREATE TABLE `servico_tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NomeServico_tipo` varchar(150) NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_EmpresaSerTipo_idx` (`Empresa_id`),
  CONSTRAINT `FK_EmpresaSerTipo` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `servico_tipo`
--

/*!40000 ALTER TABLE `servico_tipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico_tipo` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario_Tipo_ID` int(11) NOT NULL,
  `NomeUsuario` varchar(200) NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  `Senha` varchar(20) NOT NULL,
  `DataCadastro` datetime NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Usuario_Tipo_idx` (`Usuario_Tipo_ID`),
  KEY `FK_EmpresaUsuario_idx` (`Empresa_id`),
  CONSTRAINT `FK_EmpresaUsuario` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Usuario_Tipo` FOREIGN KEY (`Usuario_Tipo_ID`) REFERENCES `usuario_tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`,`Usuario_Tipo_ID`,`NomeUsuario`,`Usuario`,`Senha`,`DataCadastro`,`Empresa_id`) VALUES 
 (1,1,'Rodrigo Sebben','rodrigo','rodrigo','2016-10-06 09:25:01',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


--
-- Definition of table `usuario_acessa_modulo`
--

DROP TABLE IF EXISTS `usuario_acessa_modulo`;
CREATE TABLE `usuario_acessa_modulo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Modulo_ID` int(11) NOT NULL,
  `Usuario_ID` int(11) NOT NULL,
  `Inserir` tinyint(1) NOT NULL,
  `Editar` tinyint(1) NOT NULL,
  `Consultar` tinyint(1) NOT NULL,
  `Excluir` tinyint(1) NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Modulos_idx` (`Modulo_ID`),
  KEY `FK_Usuarios_idx` (`Usuario_ID`),
  KEY `FK_EmpresaAcesso_idx` (`Empresa_id`),
  CONSTRAINT `FK_EmpresaAcesso` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Modulos` FOREIGN KEY (`Modulo_ID`) REFERENCES `modulos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Usuarios` FOREIGN KEY (`Usuario_ID`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario_acessa_modulo`
--

/*!40000 ALTER TABLE `usuario_acessa_modulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_acessa_modulo` ENABLE KEYS */;


--
-- Definition of table `usuario_tipo`
--

DROP TABLE IF EXISTS `usuario_tipo`;
CREATE TABLE `usuario_tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario_Tipo` varchar(45) NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_empresa_idx` (`Empresa_id`),
  CONSTRAINT `fk_empresa` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario_tipo`
--

/*!40000 ALTER TABLE `usuario_tipo` DISABLE KEYS */;
INSERT INTO `usuario_tipo` (`id`,`Usuario_Tipo`,`Empresa_id`) VALUES 
 (1,'Administrador',1);
/*!40000 ALTER TABLE `usuario_tipo` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

