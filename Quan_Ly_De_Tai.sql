create database Quan_Ly_De_Tai;
use Quan_Ly_De_Tai;
create table GIAOVIEN(
Magv varchar(30)  primary key ,
Hoten varchar(100),
Ngaysinh date ,
Quequan varchar(100),
Gioitinh int(1)
);
drop table GIAOVIEN;
INSERT INTO GIAOVIEN (Magv, Hoten, Ngaysinh, Quequan, Gioitinh)
VALUES 
('Gv01', 'Trần Thị Loan', '1978-05-06', 'Nam Định', 0),
('Gv02', 'Lê Viết Thịnh', '1989-03-05', 'Hà Tĩnh', 1),
('Gv03', 'Trần Hữu Thiện', '1991-01-09', 'Hà Nội', 1);
CREATE TABLE DETAI (
    Madt VARCHAR(30) PRIMARY KEY,
    Tendt VARCHAR(100),
    Namthhien INT,
    Magv VARCHAR(30),
    FOREIGN KEY (Magv) REFERENCES GIAOVIEN(Magv)
);
INSERT INTO DETAI (Madt,  Tendt, Namthhien , Magv )
values
("D01",'Công nghệ 4.0',2017,'Gv01'),
("D02",'Công nghệ Blockchain',2018,'Gv03'),
("D03",'Bitcoin',2018,'Gv03');
CREATE TABLE SINHVIEN(
Masv varchar(30)  primary key ,
Hoten varchar(100),
Ngaysinh date ,
Quequan varchar(100),
Diem int,
Madt VARCHAR(30),
FOREIGN KEY (Madt) REFERENCES DETAI(Madt)
);
INSERT INTO SINHVIEN(Masv, Hoten, Ngaysinh, Quequan,Diem ,Madt)
VALUES 
('S001','Lê Quang Tèo','2000-01-01','Hà Nội',7,'D02'),
('S002','Đỗ Mỹ Linh','1998-08-05','Hà Tĩnh',10,'D01'),
('S003','Mai Phương Thúy','1990-09-06','Nghệ An',8,'D02');
SELECT SINHVIEN.Masv, SINHVIEN.Hoten, DETAI.Tendt
FROM GIAOVIEN
JOIN DETAI ON GIAOVIEN.Magv = DETAI.Magv
JOIN SINHVIEN ON SINHVIEN.Madt = DETAI.Madt
WHERE GIAOVIEN.Hoten = 'Trần Thị Loan';
select Magv,Hoten,count(Madt) as soluong
from GIAOVIEN g left join DETAI d on g.Madt=d.Madt
group by g.Magv,Hoten
having count(Madt)>=all(select count(Madt) from DETAI group by Madt



