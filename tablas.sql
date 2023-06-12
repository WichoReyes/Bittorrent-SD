create database peers;
use peers;

create table peers(
IP text(15) not null,
Host_name text not null,
PRIMARY KEY (IP(15)));

create table registros(
no_registro int(5) not null,
IP text not null,
Archivo text not null,
Porcentaje int not null,
PRIMARY KEY (no_registro))
ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

drop database peers;



insert into registros (no_registro, IP, Archivo, Porcentaje)
	values('1','127.0.0.1', 'z', 100);
insert into registros (no_registro, IP, Archivo, Porcentaje)
	values('2','127.0.0.2', 'z', 100);
insert into registros (no_registro, IP, Archivo, Porcentaje)
	values('3','127.0.1.2', 'z', 100);
insert into registros (no_registro, IP, Archivo, Porcentaje)values('4','127.0.1.3', 'x', 100);

select * from peers;    
select Archivo from registros group by Archivo;
select IP from registros where Archivo = 'z';
select IP from peers;
