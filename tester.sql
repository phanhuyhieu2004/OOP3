create database tester;
use tester;
CREATE TABLE Persons (

person_id int NOT NULL AUTO_INCREMENT,

last_name varchar(20) NOT NULL,

first_name varchar(20) NOT NULL,

gender varchar(1),

dob date,

income double,

PRIMARY KEY (person_id)

);
INSERT INTO Persons(last_name, first_name, gender, dob, income)

VALUES 
("Nguyen", "Van B", "M", "1996-05-10", 15000000),  

("Le", "Thi ANh", "F", "200-07-10", 20000000);
