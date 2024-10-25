user = "alimentador"
password = "6X6[Q&W6pKsw"

create database AlimetaTecDB;
drop AlimetaTecDB;
use AlimetaTecDB;

/*Creating a Login table*/
CREATE TABLE Login (
    idUser INT auto_increment,
    username VARCHAR(255) UNIQUE,
    passwordUser VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PRIMARY KEY idUser_PK (idUser)
	);
    
/*Creating a Nutritionist table*/
    CREATE TABLE Nutritionist(
	idNutritionist int auto_increment,
	nutritionistName VARCHAR (15) NOT NULL,
	paternalSurnameN VARCHAR (20) NOT NULL,
	maternalSurnameN VARCHAR (20) NOT NULL,
	ageN INT NOT NULL,
    genderN VARCHAR (20) NOT NULL,
    passwordNutritionist VARCHAR (50) NOT NULL,
	mailNutritionist VARCHAR (50) NOT NULL,
    nutritionistRegistration VARCHAR (100) NOT NULL,
    idUser INT,
    CONSTRAINT PRIMARY KEY idNutritionist_PK (idNutritionist)
    );
    
/*Creating a Patient table*/
    CREATE TABLE UserPatient(
	userPatientId int auto_increment,
    UserName VARCHAR (15) NOT NULL,
	paternalSurname VARCHAR (20) NOT NULL,
	maternalSurname VARCHAR (20) NOT NULL,
	age INT NOT NULL,
	gender VARCHAR (20) NOT NULL,
	height FLOAT NOT NULL,
	weight float (50) NOT NULL,
	suffering VARCHAR (50) NOT NULL,
    idUser INT,
	CONSTRAINT PRIMARY KEY userPatientId_PK (userPatientId)
    /*foreign key(iduser) references Login (idUser) descomentar*/
	);
    
/*Creating a Goals table*/
CREATE TABLE Goal (
    idGoal INT auto_increment,
    descriptionGoal VARCHAR(255),
    startGoal BOOLEAN,
    endGoal BOOLEAN,
    statusGoal VARCHAR(255),
    CONSTRAINT PRIMARY KEY idGoal_PK(idGoal)
	);
    
/*Creating a saucer table*/
CREATE TABLE Saucer (
    idSaucer INT AUTO_INCREMENT,
    nameSaucer VARCHAR(255),
    category VARCHAR(255),
    preparation VARCHAR(255),
    CONSTRAINT PRIMARY KEY idSaucer_PK (idSaucer)
	);

/*Creating a Activity table*/
create table PhysicalActivity(
	idActivity INT AUTO_INCREMENT,
    nameActivity VARCHAR(100) NOT NULL,
    duration time not null,
    caloriesBurned  int ,
    intensity ENUM('low', 'medium', 'high'),
    primary key idActivity_AF_PK (idActivity)
	);

CREATE TABLE Journal(
	idJournal INT AUTO_INCREMENT,
    idSaucer int,
	idActivity int,
	idGoal int, 
	idUser int,
    CONSTRAINT idJournal_PK primary key(idJournal),
    constraint idActivity_J_FK foreign key (idActivity) references PhysicalActivity(idActivity)
);