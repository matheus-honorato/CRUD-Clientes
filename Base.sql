create database loja;

create table clientes(
 
id int not null auto_increment primary key,
nome varchar(40),
idade int,
dataCadastro date)