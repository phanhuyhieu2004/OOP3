CREATE DATABASE chat_db;

USE chat_db;

CREATE TABLE  DataMessage (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  messages VARCHAR(255)
);