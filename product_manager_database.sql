CREATE TABLE products (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  price DECIMAL(10, 2),
  detail TEXT,
  manufacturer VARCHAR(255),
  number INT,
  status INT(1)
);
drop table products;