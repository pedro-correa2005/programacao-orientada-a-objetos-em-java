create database aula;

show databases;

use aula;

show tables;

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `cpf` double NOT NULL,
  `nome` varchar(45) default NULL,
  `endRua` varchar(45) default NULL,
  `endNum` int(10) unsigned default NULL,
  `endBairro` varchar(45) default NULL,
  `endCidade` varchar(45) default NULL,
  `endUF` varchar(2) default NULL,
  `sexo` longtext,
  `endComplemento` varchar(45) default NULL,
  PRIMARY KEY  (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SHOW TABLES;

SELECT * FROM clientes;

UPDATE clientes  SET nome = "Paulo Barreto" where cpf="123456789";