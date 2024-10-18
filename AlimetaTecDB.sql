user = "alimentador"
password = "6X6[Q&W6pKsw"

create database AlimetaTecDB;
drop AlimetaTecDB;
use AlimetaTecDB;

/*Creating a Login table*/
CREATE TABLE Login (
    idUser INT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    passwordUser VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
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
    CONSTRAINT PRIMARY KEY idNutritionist_PK (idNutritionist),
    foreign key(iduser) references Login (idUser)
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
	CONSTRAINT PRIMARY KEY userPatientId_PK (userPatientId),
    foreign key(iduser) references Login (idUser)
	);
    
/*Creating a Goals table*/
CREATE TABLE Goals (
    idGoal INT AUTO_INCREMENT PRIMARY KEY,
    descriptionGoal VARCHAR(255),
    startGoal BOOLEAN,
    endGoal BOOLEAN,
    statusGoal VARCHAR(255)
	);
    
/*Creating a saucer table*/
CREATE TABLE Saucers (
    idSaucer INT AUTO_INCREMENT PRIMARY KEY,
    nameSaucer VARCHAR(255),
    category VARCHAR(255),
    preparation VARCHAR(255)
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