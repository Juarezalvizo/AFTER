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
idUsuario int not null,
nombre varchar(50) not null,
apePaterno varchar(50) not null,
apeMaterno varchar(50) not null default '',
genero varchar(2) not null default 'o',
nivelEstudio varchar(50) not null default "Otro",
ganancias float not null,
telMovil varchar(20) not null default '',
email varchar(69) not null ,
estatus  INT NOT NULL DEFAULT 1,
constraint fk_alumno_usuario foreign key(idUsuario)
references usuario(idUsuario)
);

create table agenda(
idAgenda int auto_increment primary key not null,
idUsuario int not null,
materia varchar(80) not null,
actiTitulo varchar (50) not null,
actiDes LONGTEXT,
fechaHoraReg datetime not null default current_timestamp,
estatus  INT NOT NULL DEFAULT 1,
fechaHoraVenci datetime not null default current_timestamp,
constraint fk_agenda_usuario foreign key(idUsuario)
references usuario(idUsuario)
);

create table finanza (
idFinanza int auto_increment primary key not null,
idAlumno int not null,
costeTitulo varchar(60) not null,
cantidadCoste float not null,
fechaHoraCoste datetime not null default current_timestamp,
costeDes LONGTEXT,
estatus  INT NOT NULL DEFAULT 1,
constraint fk_finanza_alumno foreign key(idAlumno)
references alumno(idAlumno)
);



create table aviso(
idAviso int auto_increment primary key not null,
idUsuario int not null,
nombre varchar(69) not null,
hora varchar(15) not null,
dia varchar(70) not null,
estatus  INT NOT NULL DEFAULT 1,
constraint fk_aviso_usuario foreign key(idUsuario)
references usuario(idUsuario)
);

create table calendario (
idUsuario int not null,
idcalendatio int auto_increment primary key not null,
idFinanza int not null,
idAgenda int not null,
idAviso int not null,
constraint fk_calendario_usuario foreign key(idUsuario)
references usuario(idUsuario),
constraint fk_calendario_finanza foreign key(idFinanza)
references finanza(idFinanza),
constraint fk_calendario_agenda foreign key(idAgenda)
references agenda(idAgenda),
constraint fk_calendario_aviso foreign key(idAviso)
references aviso(idAviso)
);

