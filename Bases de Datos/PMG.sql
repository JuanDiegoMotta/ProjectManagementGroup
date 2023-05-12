DROP TABLE IF EXISTS ProyectoIntegrador_Alumno;
DROP TABLE IF EXISTS ProyectoIntegrador;
DROP TABLE IF EXISTS Alumno;
DROP TABLE IF EXISTS Area;

create table Alumno (
	num_expediente varchar(7),
    nombre_ape varchar(200),
    cod_alumno varchar(6),
    constraint cod_alumno_pk PRIMARY KEY (cod_alumno)
);

create table Area (
	nombre_corto varchar(40),
    cod_area varchar(6),
    descripcion varchar (300),
    constraint cod_area_pk primary key (cod_area)
);

create table ProyectoIntegrador (
	año varchar (40),
    curso varchar(2),
    nota varchar(4),
    grupo varchar(30),
    cod_proyecto varchar(6),
    nombre varchar(50),
    url varchar(100),
    cod_area varchar(6),
	CONSTRAINT cod_proyecto_PK PRIMARY KEY (cod_proyecto),
	CONSTRAINT area_FK FOREIGN KEY (cod_area) REFERENCES Area (cod_area) ON DELETE SET NULL
);

create table ProyectoIntegrador_Alumno (
    cod_alumno varchar(6),
	cod_proyecto varchar(6),
    constraint cod_proyecto_PK2 primary key (cod_proyecto, cod_alumno),
    constraint cod_proyecto_FK2 foreign key (cod_proyecto) references ProyectoIntegrador(cod_proyecto),
    constraint cod_alumno_FK2 foreign key (cod_alumno) references Alumno(cod_alumno)
);

insert into Alumno (num_expediente, nombre_ape, cod_alumno) values
(1222222, 'Pablo Naranjo', 999999),
(1322222, 'Juan Plaza', 199999),
(1422222, 'Jose Mera', 299999),
(1522222, 'Gloria Trillo', 399999),
(1622222, 'Marina Vaquero', 499999),
(1722222, 'Dario Giner', 599999),
(1822222, 'Ana Pereira', 699999),
(1922222, 'Bernabe Fidalgo', 799999),
(1122222, 'Eneko Cristobal', 899999),
(1112222, 'Antonio Ferrando', 109999),
(1122222, 'Luis Vela', 119999),
(1132222, 'Oscar Solis', 129999),
(1142222, 'Ferran Sales', 139999),
(1152222, 'Juan Motta', 149999),
(1162222, 'Jorge Burgos', 159999),
(1172222, 'Alvaro Serrano', 169999),
(1182222, 'Ismael Bodas', 179999),
(1192222, 'Lucca Manfredotti', 189999),
(1202222, 'Margarita Vico', 209999),
(1212222, 'Ander Arjona', 219999),
(1232222, 'Ernesto Sanmartin', 229999),
(1242222, 'Aurora Herrero', 239999),
(1252222, 'Benito Jurado', 249999),
(1252222, 'Claudio Garrido', 259999),
(1252222, 'Virgilio Amaya', 269999),
(1252222, 'Teo Gordo', 279999),
(1252222, 'Victoria Garces', 289999),
(1252222, 'Valeria Corral', 309999),
(1252222, 'Jaime Perez', 319999),
(1252222, 'Ana Huerta', 329999),
(1252222, 'Lucía Arroyo', 339999),
(1252222, 'Juan Palomino', 349999),
(1252222, 'Adriana Correa', 359999);

insert into Area (nombre_corto, cod_area, descripcion) values 
('DAM', 121212, 'Desarrollo de aplicaciones multiplataforma'),
('ASIR', 232323, 'Administración de sistemas informáticos en red'),
('DAW', 343434, 'Desarrollo de aplicaciones web'),
('Animaciones 3D', 454545, 'Animación en 3D'),
('Videojuegos', 565656, 'Diseño y creación de videojuegos');

insert into ProyectoIntegrador (año, curso, nota, grupo, cod_proyecto, nombre, url, cod_area) values
(2023, 1, 10, 'M11', 000001, 'PMG', 'https://github.com/JuanDiegoMotta', 121212),
(2023, 1, 5, 'M22', 000002, 'Los Mejores', 'https://github.com/Pedro', 121212),
(2023, 1, 7, 'M22', 000003, 'Topanga', 'https://github.com/Fernando', 565656),
(2023, 1, 6, 'M11', 000004, 'Carne', 'https://github.com/Cristian', 232323),
(2023, 1, 4, 'M11', 000005, 'Sin piedad', 'https://github.com/Jorge', 232323),
(2023, 1, 3, 'M22', 000006, 'Espartanos', 'https://github.com/Miguel', 232323),
(2023, 1, 6, 'T1', 000007, 'Marcianos', 'https://github.com/Pablo', 343434),
(2023, 1, 5, 'T1', 000008, 'Perlas', 'https://github.com/Victor', 343434),
(2023, 1, 2, 'M22', 000009, 'Cristales', 'https://github.com/Marcos', 454545),
(2023, 1, 8, 'M11', 000010, 'Ganadores', 'https://github.com/Adrian', 454545),
(2023, 1, 9, 'T1', 000011, 'Felices', 'https://github.com/Alvaro', 565656);

insert into ProyectoIntegrador_Alumno (cod_alumno, cod_proyecto) values
(999999, 000001),
(199999, 000001),
(299999, 000001),
(399999, 000002),
(499999, 000002),
(599999, 000002),
(699999, 000003),
(799999, 000003),
(899999, 000003),
(109999, 000004),
(119999, 000004),
(129999, 000004),
(139999, 000005),
(149999, 000005),
(159999, 000005),
(169999, 000006),
(179999, 000006),
(189999, 000006),
(209999, 000007),
(219999, 000007),
(229999, 000007),
(239999, 000008),
(249999, 000008),
(259999, 000008),
(269999, 000009),
(279999, 000009),
(289999, 00009),
(309999, 000010),
(319999, 000010),
(329999, 000010),
(339999, 000011),
(349999, 000011),
(359999, 000011);
