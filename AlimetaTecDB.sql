user = "alimentador"
password = "6X6[Q&W6pKsw"

create database AlimetaTecDB;
drop AlimetaTecDB;
use AlimetaTecDB;

/*creation of the physical activities table*/
create table PhysicalActivity(
	idActivity INT AUTO_INCREMENT,
    nameActivity VARCHAR(100) NOT NULL,
    duration time not null,
    caloriesBurned  int ,
    intensity ENUM('low', 'medium', 'high'),
    primary key idActivity_AF_PK (idActivity)
);
TRUNCATE `alimetatecdb`.`physicalactivity`;
DROP TABLE `alimetatecdb`.`physicalactivity`;
INSERT INTO PhysicalActivity (nameActivity, duration, caloriesBurned, intensity) VALUES ('Run', '00:30:00', 300, 'medium');

/*creating the journal table*/
create table Journal(
	idJournal INT AUTO_INCREMENT,
    nameJournal VARCHAR(100) NOT NULL,
    primary key idJournal_AF_PK (Journal)
);

CREATE TABLE Saucer (
    idSauser INT AUTO_INCREMENT,
    nameSaucer VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    preparation varchar(250) NOT NULL,
    primary key idSauser_S_PK (idSauser)
);


CREATE TABLE Nutriologo(
	nutriologo_id int auto_increment,
	nombre VARCHAR (15) NOT NULL,
	apellidoPaterno VARCHAR (20) NOT NULL,
	apellidoMaterno VARCHAR (20) NOT NULL,
	edad INT NOT NULL,
    genero VARCHAR (20) NOT NULL,
    contrasenia VARCHAR (50) NOT NULL,
	correo VARCHAR (50) NOT NULL,
    matricula VARCHAR (100) NOT NULL,
    CONSTRAINT PRIMARY KEY nutriologo_id_PK (nutriologo_id)
);

INSERT INTO actividadfisica (nombre_actividad, duracion, calorias_quemadas, intensidad)
VALUES ('Correr', '00:30:00', 300, 'media');