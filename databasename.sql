
CREATE DATABASE databasename;
CREATE TABLE Persons(
PersonsID INT ,
LastName VARCHAR(255),
FirstName VARCHAR(255),
Address VARCHAR(255),
City VARCHAR(255)

);
-- Chèn dữ liệu
INSERT INTO Persons(PersonsID,LastName,FirstName,Address,City) VALUES
(1, 'Tom B', 'Erichsen', 'Stavanger', 'Norway');
SELECT * FROM Persons;
INSERT INTO Persons(PersonsID,LastName,FirstName,Address,City) VALUES
(3, 'Tom C', 'Erichsen', 'Stavanger');
INSERT INTO Persons(PersonsID,LastName,FirstName,Address,City) VALUES
(3, 'Tom C', 'Erichsen', 'Stavanger');
-- Xóa dữ liệu trong bảng
TRUNCATE TABLE Persons;
-- DROP DATABASE databasename;
-- Thay đổi bảng
-- Thêm cột
ALTER TABLE Persons
ADD Email VARCHAR(255);
-- xóa email
ALTER TABLE Persons
DROP Email ;
ALTER TABLE Persons
MODIFY  PersonsID INT;

ALTER TABLE Persons
ADD Age INT;
ALTER TABLE Persons
MODIFY Age INT NOT NULL;
DROP TABLE Persons;
CREATE TABLE Persons(
PersonsID INT PRIMARY KEY,
LastName VARCHAR(255),
FirstName VARCHAR(255),
Address VARCHAR(255),
City VARCHAR(255)

);
ALTER TABLE Persons
DROP INDEX City;
ALTER TABLE Persons
DROP PRIMARY KEY;
ALTER TABLE Persons
ADD PRIMARY KEY(City);
CREATE TABLE Orders(
OrderID INT NOT NULL,
OderNumber INT NOT NULL,
PersonsID INT,
PRIMARY KEY(OrderID),
FOREIGN KEY(PersonsID) REFERENCES Persons(PersonsID)

);
-- ALTER TABLE Orders
-- DROP FOREIGN KEY Orders_ibfk_1 ; 
-- Tên khóa ngoại
DROP TABLE Persons;
CREATE TABLE Persons(
PersonsID INT PRIMARY KEY,
LastName VARCHAR(255),
FirstName VARCHAR(255),
Address VARCHAR(255),
City VARCHAR(255) DEFAULT "HaNoi",
Age INT
);
ALTER TABLE Persons
ALTER City SET DEFAULT "Myyy";
ALTER TABLE Persons
ADD CHECK(Age>18);
INSERT INTO Persons(PersonsID,LastName,FirstName,Address,Age) VALUES
(5, 'Tom B', 'Erichsen', 'Stavanger', 19);

TRUNCATE TABLE Persons;
DELETE FROM Persons WHERE PersonsID = 1;
INSERT INTO Persons(PersonsID,LastName,FirstName,Address,City) VALUES
(3, 'Tom C', 'Erichsen', 'Stavanger');
CREATE INDEX idx_lastname
ON Persons (LastName);
DROP TABLE Orders,Persons;
CREATE TABLE customers(
CustomerID INT,
CustomerName NVARCHAR(100),
ContactName NVARCHAR(100),
Address NVARCHAR(100),
City VARCHAR(100),
PostalCode VARCHAR(100),
Country VARCHAR(100)
);
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (1,'Alfreds Futterkiste','Maria Anders','Obere Str. 57','Berlin','12209','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (2,'Ana Trujillo Emparedados y helados','Ana Trujillo','Avda. de la ConstituciÃ³n 2222','MÃ©xico D.F.','05021','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (3,'Antonio Moreno TaquerÃ-a','Antonio Moreno','Mataderos 2312','MÃ©xico D.F.','05023','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (4,'Around the Horn','Thomas Hardy','120 Hanover Sq.','London','WA1 1DP','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (5,'Berglunds snabbkÃ¶p','Christina Berglund','BerguvsvÃ¤gen 8','LuleÃ¥','S-958 22','Sweden') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (6,'Blauer See Delikatessen','Hanna Moos','Forsterstr. 57','Mannheim','68306','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (7,'Blondel pÃ¨re et fils','FrÃ©dÃ©rique Citeaux','24, place KlÃ©ber','Strasbourg','67000','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (8,'BÃ³lido Comidas preparadas','MartÃ-n Sommer','C/ Araquil, 67','Madrid','28023','Spain') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (9,'Bon app\'','Laurence Lebihans','12, rue des Bouchers','Marseille','13008','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (10,'Bottom-Dollar Marketse','Elizabeth Lincoln','23 Tsawassen Blvd.','Tsawassen','T2F 8M4','Canada') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (11,'B\'s Beverages','Victoria Ashworth','Fauntleroy Circus','London','EC2 5NT','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (12,'Cactus Comidas para llevar','Patricio Simpson','Cerrito 333','Buenos Aires','1010','Argentina') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (13,'Centro comercial Moctezuma','Francisco Chang','Sierras de Granada 9993','MÃ©xico D.F.','05022','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (14,'Chop-suey Chinese','Yang Wang','Hauptstr. 29','Bern','3012','Switzerland') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (15,'ComÃ©rcio Mineiro','Pedro Afonso','Av. dos LusÃ-adas, 23','SÃ£o Paulo','05432-043','Brazil') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (16,'Consolidated Holdings','Elizabeth Brown','Berkeley Gardens 12 Brewery','London','WX1 6LT','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (17,'Drachenblut Delikatessend','Sven Ottlieb','Walserweg 21','Aachen','52066','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (18,'Du monde entier','Janine Labrune','67, rue des Cinquante Otages','Nantes','44000','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (19,'Eastern Connection','Ann Devon','35 King George','London','WX3 6FW','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`City`,`PostalCode`,`Country`)
values (20,'Ernst Handel','Roland Mendel','Graz','8010','Austria') ;
truncate table customers;

SELECT  distinct City FROM customers;
select count(distinct Country) from customers;
select * from customers Where NOT Country='Brazil';
SELECT * FROM customers
WHERE Country = 'Germany' AND (City
= 'Berlin' OR City = 'Stuttgart');

select * from customers
order by Country ASC;
select * from customers
order by Country DESC;
select * from customers
order by Country ASC,CustomerName DESC;
insert into customers
values (25,'ComÃ©rcio Mineiro','Pedro Afonso','Av. dos LusÃ-adas, 23','SÃ£o Paulo','05432-043','Brazil') ;]
SET SQL_SAFE_UPDATES = 0;
update customers set Country="VietNam" where CustomerID=1;

update customers set Address="VietNam" where CustomerID=20;
select * from customers order by CustomerID DESC;
drop table customers;
CREATE TABLE customers(
CustomerID INT,
CustomerName NVARCHAR(100),
ContactName NVARCHAR(100),
Address NVARCHAR(100),
City VARCHAR(100),
PostalCode VARCHAR(100),
Country VARCHAR(100)
);
SELECT * FROM customers;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (1,'Alfreds Futterkiste','Maria Anders','Obere Str. 57','Berlin','12209','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (2,'Ana Trujillo Emparedados y helados','Ana Trujillo','Avda. de la ConstituciÃ³n 2222','MÃ©xico D.F.','05021','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (3,'Antonio Moreno TaquerÃ-a','Antonio Moreno','Mataderos 2312','MÃ©xico D.F.','05023','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (4,'Around the Horn','Thomas Hardy','120 Hanover Sq.','London','WA1 1DP','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (5,'Berglunds snabbkÃ¶p','Christina Berglund','BerguvsvÃ¤gen 8','LuleÃ¥','S-958 22','Sweden') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (6,'Blauer See Delikatessen','Hanna Moos','Forsterstr. 57','Mannheim','68306','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (7,'Blondel pÃ¨re et fils','FrÃ©dÃ©rique Citeaux','24, place KlÃ©ber','Strasbourg','67000','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (8,'BÃ³lido Comidas preparadas','MartÃ-n Sommer','C/ Araquil, 67','Madrid','28023','Spain') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (9,'Bon app\'','Laurence Lebihans','12, rue des Bouchers','Marseille','13008','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (10,'Bottom-Dollar Marketse','Elizabeth Lincoln','23 Tsawassen Blvd.','Tsawassen','T2F 8M4','Canada') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (11,'B\'s Beverages','Victoria Ashworth','Fauntleroy Circus','London','EC2 5NT','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (12,'Cactus Comidas para llevar','Patricio Simpson','Cerrito 333','Buenos Aires','1010','Argentina') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (13,'Centro comercial Moctezuma','Francisco Chang','Sierras de Granada 9993','MÃ©xico D.F.','05022','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)

values (14,'Chop-suey Chinese','Yang Wang','Hauptstr. 29','Bern','3012','Switzerland') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (15,'ComÃ©rcio Mineiro','Pedro Afonso','Av. dos LusÃ-adas, 23','SÃ£o Paulo','05432-043','Brazil') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (16,'Consolidated Holdings','Elizabeth Brown','Berkeley Gardens 12 Brewery','London','WX1 6LT','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (17,'Drachenblut Delikatessend','Sven Ottlieb','Walserweg 21','Aachen','52066','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (18,'Du monde entier','Janine Labrune','67, rue des Cinquante Otages','Nantes','44000','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (19,'Eastern Connection','Ann Devon','35 King George','London','WX3 6FW','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`City`,`PostalCode`,`Country`)
values (20,'Ernst Handel','Roland Mendel','Graz','8010','Austria') ;

SELECT MIN(CustomerID) as GTNN  from customers ;
SELECT MIN(ContactName) as KTNN  from customers ;
SELECT MAX(ContactName) as KTLN  from customers ;
SELECT MAX(CustomerID) as GTLN  from customers ;
SELECT AVG(CustomerID) as Soluong from customers;
SELECT SUM(CustomerID) as Soluong from customers;

SELECT* from customers Where CustomerName like 'a%';
SELECT* from customers Where CustomerName like '_h%';
SELECT* from customers Where City like 'L_n_on';
SELECT * FROM customers
WHERE City LIKE '%es%';
select * from customers where Country in ('Germany', 'France', 'UK');
select * from customers where CustomerID between 5 and 10;
select * from customers Where ContactName between 'Christina Berglund' AND 'Elizabeth
Lincoln';
SELECT CustomerName AS Customer, ContactName AS
"Contact Person"
FROM customers;
SELECT CustomerName, CONCAT_WS(', ', Address,
PostalCode, City, Country) AS Address
FROM customers;
drop table customers;
CREATE TABLE customers(
CustomerID INT,
CustomerName NVARCHAR(100),
ContactName NVARCHAR(100),
Address NVARCHAR(100),
City VARCHAR(100),
PostalCode VARCHAR(100),
Country VARCHAR(100)
);
SELECT * FROM customers;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (1,'Alfreds Futterkiste','Maria Anders','Obere Str. 57','Berlin','12209','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (2,'Ana Trujillo Emparedados y helados','Ana Trujillo','Avda. de la ConstituciÃ³n 2222','MÃ©xico D.F.','05021','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (3,'Antonio Moreno TaquerÃ-a','Antonio Moreno','Mataderos 2312','MÃ©xico D.F.','05023','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (4,'Around the Horn','Thomas Hardy','120 Hanover Sq.','London','WA1 1DP','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (5,'Berglunds snabbkÃ¶p','Christina Berglund','BerguvsvÃ¤gen 8','LuleÃ¥','S-958 22','Sweden') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (6,'Blauer See Delikatessen','Hanna Moos','Forsterstr. 57','Mannheim','68306','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (7,'Blondel pÃ¨re et fils','FrÃ©dÃ©rique Citeaux','24, place KlÃ©ber','Strasbourg','67000','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (8,'BÃ³lido Comidas preparadas','MartÃ-n Sommer','C/ Araquil, 67','Madrid','28023','Spain') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (9,'Bon app\'','Laurence Lebihans','12, rue des Bouchers','Marseille','13008','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (10,'Bottom-Dollar Marketse','Elizabeth Lincoln','23 Tsawassen Blvd.','Tsawassen','T2F 8M4','Canada') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (11,'B\'s Beverages','Victoria Ashworth','Fauntleroy Circus','London','EC2 5NT','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (12,'Cactus Comidas para llevar','Patricio Simpson','Cerrito 333','Buenos Aires','1010','Argentina') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (13,'Centro comercial Moctezuma','Francisco Chang','Sierras de Granada 9993','MÃ©xico D.F.','05022','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (14,'Chop-suey Chinese','Yang Wang','Hauptstr. 29','Bern','3012','Switzerland') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (15,'ComÃ©rcio Mineiro','Pedro Afonso','Av. dos LusÃ-adas, 23','SÃ£o Paulo','05432-043','Brazil') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (16,'Consolidated Holdings','Elizabeth Brown','Berkeley Gardens 12 Brewery','London','WX1 6LT','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (17,'Drachenblut Delikatessend','Sven Ottlieb','Walserweg 21','Aachen','52066','Germany') ;

insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (18,'Du monde entier','Janine Labrune','67, rue des Cinquante Otages','Nantes','44000','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (19,'Eastern Connection','Ann Devon','35 King George','London','WX3 6FW','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`City`,`PostalCode`,`Country`)
values (20,'Ernst Handel','Roland Mendel','Graz','8010','Austria');
CREATE TABLE Orders(
OrderID INT,
CustomerID INT,
EmployeeID INT,
OrderDate VARCHAR(100) ,
ShipperID INT
);
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10248,5,5,'1996-07-04',3) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10249,8,6,'1996-07-05',1) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10250,9,4,'1996-07-08',2) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10251,10,3,'1996-07-08',1) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10252,11,4,'1996-07-09',2) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10253,12,3,'1996-07-10',2) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10254,13,5,'1996-07-11',2) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10255,100,9,'1996-07-12',3) ;
SELECT Orders.OrderID, customers.CustomerName, Orders.EmployeeID
FROM Orders
INNER JOIN customers ON Orders.CustomerID=customers.CustomerID;
select customers.CustomerName,Orders.OrderID
from customers
left join Orders on Orders.CustomerID=customers.CustomerID
order by customers.CustomerName ASC;
select customers.CustomerName,Orders.OrderID
from customers right join Orders on customers.CustomerID=Orders.CustomerID
order by customers.CustomerName;


UPDATE customers
set Country ="VN" Where CustomerID=1;
select count(CustomerID),Country
from customers
group by Country
order by COUNT(CustomerID) DESC;
select A.CustomerName as CustomerName1 , B.CustomerName as CustomerName2,A.City
from customers A,customers B
where A.CustomerID <> B.CustomerID
and A.City=B.City
order by A.City DESC;
select CustomerID from customers
Union all
select CustomerID from Orders
order by CustomerID;
select CustomerID from customers
Union all
-- hợp nhất tất cả
select CustomerID from Orders
order by CustomerID;
select CustomerID from customers 
Where Country='Germany'
union 
select CustomerID from Orders
where ShipperID>2
order by CustomerID;
drop table customers,Orders;

CREATE TABLE customers(
CustomerID INT,
CustomerName NVARCHAR(100),
ContactName NVARCHAR(100),
Address NVARCHAR(100),
City VARCHAR(100),
PostalCode VARCHAR(100),
Country VARCHAR(100)
);
SELECT * FROM customers;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (1,'Alfreds Futterkiste','Maria Anders','Obere Str. 57',null,'12209','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (2,'Ana Trujillo Emparedados y helados','Ana Trujillo','Avda. de la ConstituciÃ³n 2222','MÃ©xico D.F.','05021','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (3,'Antonio Moreno TaquerÃ-a','Antonio Moreno','Mataderos 2312','MÃ©xico D.F.','05023','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (4,'Around the Horn','Thomas Hardy','120 Hanover Sq.','London','WA1 1DP','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (5,'Berglunds snabbkÃ¶p','Christina Berglund','BerguvsvÃ¤gen 8','LuleÃ¥','S-958 22','Sweden') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (6,'Blauer See Delikatessen','Hanna Moos','Forsterstr. 57','Mannheim','68306','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (7,'Blondel pÃ¨re et fils','FrÃ©dÃ©rique Citeaux','24, place KlÃ©ber','Strasbourg','67000','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (8,'BÃ³lido Comidas preparadas','MartÃ-n Sommer','C/ Araquil, 67','Madrid','28023','Spain') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (9,'Bon app\'','Laurence Lebihans','12, rue des Bouchers','Marseille','13008','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (10,'Bottom-Dollar Marketse','Elizabeth Lincoln','23 Tsawassen Blvd.','Tsawassen','T2F 8M4','Canada') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (11,'B\'s Beverages','Victoria Ashworth','Fauntleroy Circus','London','EC2 5NT','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (12,'Cactus Comidas para llevar','Patricio Simpson','Cerrito 333','Buenos Aires','1010','Argentina') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (13,'Centro comercial Moctezuma','Francisco Chang','Sierras de Granada 9993','MÃ©xico D.F.','05022','Mexico') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (14,'Chop-suey Chinese','Yang Wang','Hauptstr. 29','Bern','3012','Switzerland') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (15,'ComÃ©rcio Mineiro','Pedro Afonso','Av. dos LusÃ-adas, 23','SÃ£o Paulo','05432-043','Brazil') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (16,'Consolidated Holdings','Elizabeth Brown','Berkeley Gardens 12 Brewery','London','WX1 6LT','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (17,'Drachenblut Delikatessend','Sven Ottlieb','Walserweg 21','Aachen','52066','Germany') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (18,'Du monde entier','Janine Labrune','67, rue des Cinquante Otages','Nantes','44000','France') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`Address`,`City`,`PostalCode`,`Country`)
values (null,'Eastern Connection','Ann Devon','35 King George','London','WX3 6FW','UK') ;
insert into customers(`CustomerID`,`CustomerName`,`ContactName`,`City`,`PostalCode`,`Country`)
values (null,'Ernst Handel','Roland Mendel','Graz','8010','Austria') ;
CREATE TABLE Orders(
OrderID INT,
CustomerID INT,
EmployeeID INT,
OrderDate VARCHAR(100) ,
ShipperID INT
);
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10248,5,5,'1996-07-04',3) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10249,8,6,'1996-07-05',1) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10250,9,4,'1996-07-08',2) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10251,10,3,'1996-07-08',1) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10252,11,4,'1996-07-09',2) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10253,12,3,'1996-07-10',2) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10254,13,5,'1996-07-11',2) ;
insert into `Orders` (`OrderID`,`CustomerID`,`EmployeeID`,`OrderDate`,`ShipperID`)
values (10255,14,9,'1996-07-12',3) ;
select count(CustomerID),Country from customers group by Country
order by count(CustomerID) DESC;
SELECT COUNT(CustomerID), Country
FROM customers
GROUP BY Country
HAVING COUNT(CustomerID) > 2;
select CustomerID from customers where  not exists (select * from Orders where ShipperID = 6);
select * from customers where exists
( select * from Orders where (Orders.CustomerID=customers.CustomerID) and (ShipperID=1));
-- sử dụng điều kiện đã tồn tại bên trong là lấy hết bản ghi trong orders để tham chiếu id với customer và shipperid =1,nếu đúng sẽ chạy bên ngoài là lấy ra khách hàng đặt hàng
select CustomerID,Address from customers where CustomerID=any (select EmployeeID from Orders where ShipperID=3);
select distinct CustomerID,CustomerName from customers where Country='UK';
delete  from customers where CustomerName like 'E%%';
CREATE TABLE employees (
    employee_id INT,
    name VARCHAR(255),
    department_id INT
);
INSERT INTO employees (employee_id, name, department_id)
VALUES (1, 'John Smith', 1),
       (2, 'Jane Doe', 2),
       (3, 'Bob Johnson', 1);
CREATE TABLE departments (
    department_id INT,
    department_name VARCHAR(255)
);

INSERT INTO departments (department_id, department_name)
VALUES (1, 'IT'),
       (2, 'HR'),
       (3, 'Marketing');
       SELECT employees.name, department_name
FROM employees JOIN departments ON employees.department_id = departments.department_id;
CREATE TABLE employees (
    employee_id INT,
    name VARCHAR(255),
    department_id INT
);
INSERT INTO employees (employee_id, name, department_id)
VALUES (1, 'John Smith', 1),
       (2, 'Jane Doe', 2),
       (3, 'Bob Johnson', 1),
       (4, 'Marry', NULL);
       CREATE TABLE departments (
    department_id INT,
    department_name VARCHAR(255)
);
INSERT INTO departments (department_id, department_name)
VALUES (1, 'IT'),
       (2, 'HR');
         SELECT employees.name, department_name
FROM employees  LEFT JOIN departments ON employees.department_id = departments.department_id;
CREATE TABLE orders (
    order_id INT,
    customer_id INT,
    product_id INT
);

INSERT INTO orders (order_id, customer_id, product_id)
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 1, 2);

-- Sample data for the "customers" table
CREATE TABLE customers (
    customer_id INT,
    name VARCHAR(255)
);

INSERT INTO customers (customer_id, name)
VALUES (1, 'John Smith'),
       (2, 'Jane Doe'),
       (3, 'Bob Johnson');
       
-- Sample data for the "products" table
CREATE TABLE products (
    product_id INT,
    name VARCHAR(255)
);

INSERT INTO products (product_id, name)
VALUES (1, 'Product 1'),
       (2, 'Product 2'),
       (3, 'Product 3');

-- Right join the "orders" , "customers" and "products" tables
SELECT orders.order_id, products.name, customers.name
FROM orders
RIGHT JOIN products ON orders.product_id = products.product_id
RIGHT JOIN customers ON orders.customer_id = customers.customer_id;

drop table customers;



