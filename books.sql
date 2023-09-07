CREATE DATABASE library;
USE library;

CREATE TABLE book (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    author VARCHAR(255),
    year INT,
    pages INT
);