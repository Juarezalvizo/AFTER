drop database if exists AFTER;
create database AFTER;

use AFTER;

create table usuario(
idUsuario int auto_increment primary key not null,
nombre varchar(129) unique not null,
contrasennia varchar(129) not null,
lastToken varchar(65) not null default '',
dateLastToken datetime not null default current_timestamp
);

create table alumno(
idAlumno int auto_increment primary key not null,
nombre varchar(50) not null,
apePaterno varchar(50) not null,
apeMaterno varchar(50) not null default '',
genero varchar(2) not null default 'o',
nivelEstudio varchar(50) not null default "Otro",
ganancias float not null,
telMovil varchar(20) not null default '',
email varchar(69) not null 
);

create table agenda(
idAgenda int auto_increment primary key not null,
materia varchar(80) not null,
actiTitulo varchar (50) not null,
actiDes LONGTEXT,
fechaHoraReg datetime not null default current_timestamp,
fechaHoraVenci datetime not null default current_timestamp
);

create table finanza (
idFinanza int auto_increment primary key not null,
cantidadCoste float not null,
costeTitulo varchar(60) not null,
costeDes LONGTEXT,
fechaHoraCoste datetime not null default current_timestamp
);



create table aviso(
idAviso int auto_increment primary key not null,
nombre varchar(69) not null,
hora varchar(15) not null,
dia varchar(70) not null,
idAgenda int not null,
idFinanza int not null,
constraint fk_aviso_finanza foreign key(idFinanza)
references finanza(idFinanza),
constraint fk_aviso_agenda foreign key(idAgenda)
references agenda(idAgenda)
);

create table calendario (
idcalendatio int auto_increment primary key not null,
idFinanza int not null,
idAgenda int not null,
idAviso int not null,
constraint fk_calendario_finanza foreign key(idFinanza)
references finanza(idFinanza),
constraint fk_calendario_agenda foreign key(idAgenda)
references agenda(idAgenda),
constraint fk_calendario_aviso foreign key(idAviso)
references aviso(idAviso)
);
