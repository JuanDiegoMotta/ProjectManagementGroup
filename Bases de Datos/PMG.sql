
DROP TABLE IF EXISTS ProyectoIntegrador_Alumno;
DROP TABLE IF EXISTS ProyectoIntegrador;
DROP TABLE IF EXISTS Alumno;
DROP TABLE IF EXISTS Area;

create table Area (
    nombre_corto varchar(40) unique,
    cod_area varchar(6),
    descripcion varchar (300),
    constraint cod_area_pk primary key (cod_area)
);
create table Alumno (
    num_expediente varchar(7) unique,
    nombre_ape varchar(200),
    cod_alumno varchar(6) unique,
    area varchar(6),
    constraint cod_alumno_pk PRIMARY KEY (cod_alumno),
    constraint area_alumno_fk FOREIGN KEY (area) REFERENCES Area(nombre_corto) ON DELETE SET NULL ON UPDATE CASCADE
);

create table ProyectoIntegrador (
    ano varchar (40),
    curso varchar(2),
    nota varchar(4),
    cod_proyecto varchar(6),
    nombre varchar(50) unique,
    url varchar(100),
    nc_area varchar(6),
    CONSTRAINT cod_proyecto_PK PRIMARY KEY (cod_proyecto),
    CONSTRAINT area_FK FOREIGN KEY (nc_area) REFERENCES Area (nombre_corto) ON DELETE SET NULL ON UPDATE CASCADE
);

create table ProyectoIntegrador_Alumno (
    cod_alumno varchar(6),
    cod_proyecto varchar(6),
    constraint cod_proyecto_PK2 primary key (cod_proyecto, cod_alumno),
    constraint cod_proyecto_FK2 foreign key (cod_proyecto) references ProyectoIntegrador(cod_proyecto) ON DELETE CASCADE,
    constraint cod_alumno_FK2 foreign key (cod_alumno) references Alumno(cod_alumno) ON DELETE CASCADE
);

insert into Area (nombre_corto, cod_area, descripcion) values 
('DAM', 121212, 'Desarrollo de aplicaciones multiplataforma'),
('ASIR', 232323, 'Administración de sistemas informáticos en red'),
('DAW', 343434, 'Desarrollo de aplicaciones web'),
('A3DV', 454545, 'Animación en 3D y Videojuegos');
INSERT INTO Alumno (num_expediente, nombre_ape, cod_alumno, area) VALUES
(1222222, 'Pablo Naranjo', 999999, 'DAM'),
(1322222, 'Juan Plaza', 199999, 'DAM'),
(1422222, 'Jose Mera', 299999, 'DAM'),
(1522222, 'Gloria Trillo', 399999, 'DAM'),
(1622222, 'Marina Vaquero', 499999, 'DAM'),
(1722222, 'Dario Giner', 599999, 'DAM'),
(1822222, 'Ana Pereira', 699999, 'A3DV'),
(1922222, 'Bernabe Fidalgo', 799999, 'A3DV'),
(1120222, 'Eneko Cristobal', 899999, 'A3DV'),
(1112222, 'Antonio Ferrando', 109999, 'ASIR'),
(1122222, 'Luis Vela', 119999, 'ASIR'),
(1132222, 'Oscar Solis', 129999, 'ASIR'),
(1142222, 'Ferran Sales', 139999, 'ASIR'),
(1152222, 'Juan Motta', 149999, 'ASIR'),
(1162222, 'Jorge Burgos', 159999, 'ASIR'),
(1172222, 'Alvaro Serr', 169999, 'ASIR'),
(1182222, 'Ismael Bodas', 179999, 'ASIR'),
(1192222, 'Lucca Manfredotti', 189999, 'ASIR'),
(1202222, 'Margarita Vico', 209999, 'DAW'),
(1212222, 'Ander Arjona', 219999, 'DAW'),
(1232222, 'Ernesto Sanmartin', 229999, 'DAW'),
(1242222, 'Aurora Herrero', 239999, 'DAW'),
(1250222, 'Benito Jurado', 249999, 'DAW'),
(1252223, 'Claudio Garrido', 259999, 'DAW'),
(1253222, 'Virgilio Amaya', 269999, 'A3DV'),
(1254222, 'Teo Gordo', 279999, 'A3DV'),
(1255222, 'Victoria Garces', 289999, 'A3DV'),
(1256222, 'Valeria Corral', 309999, 'A3DV'),
(1257222, 'Jaime Perez', 319999, 'A3DV'),
(1258222, 'Ana Huerta', 329999, 'A3DV'),
(1259222, 'Lucía Arroyo', 339999, 'A3DV'),
(1260222, 'Juan Palomino', 349999, 'A3DV'),
(1261222, 'Adriana Correa', 359999, 'A3DV');


insert into ProyectoIntegrador (ano, curso, nota, cod_proyecto, nombre, url, nc_area) values
(2023, 1, 10, 000001, 'PMG', 'https://github.com/JuanDiegoMotta', 'DAM'),
(2023, 1, 5, 000002, 'Los Mejores', 'https://github.com/Pedro', 'DAM'),
(2023, 1, 7, 000003, 'Topanga', 'https://github.com/Fernando', 'A3DV'),
(2023, 1, 6, 000004, 'Carne', 'https://github.com/Cristian', 'ASIR'),
(2023, 1, 4, 000005, 'Sin piedad', 'https://github.com/Jorge', 'ASIR'),
(2023, 1, 3, 000006, 'Esparts', 'https://github.com/Miguel', 'ASIR'),
(2023, 1, 6, 000007, 'Marcis', 'https://github.com/Pablo', 'DAW'),
(2023, 1, 5, 000008, 'Perlas', 'https://github.com/Victor', 'DAW'),
(2023, 1, 2, 000009, 'Cristales', 'https://github.com/Marcos', 'A3DV'),
(2023, 1, 8, 000010, 'Ganadores', 'https://github.com/Adrian', 'A3DV'),
(2023, 1, 9, 000011, 'Felices', 'https://github.com/Alvaro', 'A3DV'),
-- Se agregan sin proyecto también
("", "", "", "SDAW", 'Sin proyecto (daw)', '', 'DAW'),
("", "", "", "SDAM", 'Sin proyecto (dam)', '', 'DAM'),
("", "", "", "SASIR", 'Sin proyecto (asir)', '', 'ASIR'),
("", "", "", "SA3DV", 'Sin proyecto (a3dv)', '', 'A3DV');



INSERT INTO ProyectoIntegrador_Alumno (cod_alumno, cod_proyecto) VALUES
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
(289999, 000009),
(309999, 000010),
(319999, 000010),
(329999, 000010),
(339999, 000011),
(349999, 000011),
(359999, 000011);
