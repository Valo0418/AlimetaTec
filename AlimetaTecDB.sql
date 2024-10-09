user = "alimentador"
password = "6X6[Q&W6pKsw"

create database AlimetaTecDB;
drop AlimetaTecDB;
use AlimetaTecDB;

/*CREACION DE LA TABLA DE ACTIVIDADES FISICAS*/
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