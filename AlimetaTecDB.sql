user = "alimentador"
password = "6X6[Q&W6pKsw"

create database mapachebigoton;
create database AlimetaTecDB;
drop AlimetaTecDB;
use AlimetaTecDB;

create table actividadfisica(
	id_actividad INT AUTO_INCREMENT,
    nombre_actividad VARCHAR(100) NOT NULL,
    duracion time not null,
    calorias_quemadas  int ,
    intensidad ENUM('baja', 'media', 'alta'),
    primary key idActividad_AF_PK (id_actividad)
);

INSERT INTO actividad_fisica (nombre_actividad, duracion, calorias_quemadas, intensidad, fecha) VALUES ('Correr', '00:30:00', 250, 'media', '2023-11-20');
USE alimetatecdb; -- Selecciona la base de datos
INSERT INTO actividad_fisica (nombre_actividad, duracion, calorias_quemadas, intensidad, fecha) VALUES ('Correr', '00:30:00', 250, 'media', '2023-11-20');

INSERT INTO actividadfisica (nombre_actividad, duracion, calorias_quemadas, intensidad)
VALUES ('Correr', '00:30:00', 300, 'media');