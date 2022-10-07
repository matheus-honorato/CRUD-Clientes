create database loja;

create table clientes (
	id int not null auto_increment primary key,
	nome varchar(40),
	sobrenome varchar(40),
	senha varchar(40),
	email varchar(40),
	dataCadastro (date)
)