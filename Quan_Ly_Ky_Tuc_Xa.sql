create database Quan_Ly_Ky_Tuc_Xa;
use Quan_Ly_Ky_Tuc_Xa;
create table Phong(
MaPhong int auto_increment primary key,
TenPhong varchar(100),
DIenTich int,
SoGiuong int,
GiaThue int
);
create table Lop(
MaLop int auto_increment primary key,
TenLop varchar(100)
);
create table SinhVien(
MaSV int auto_increment primary key,
HoTen varchar(100),
SoDT int,
MaLop int,
foreign key (MaLop) references Lop(MaLop)
);

create table NhanVien(
MaNV int auto_increment primary key,
HoTen varchar(100),
SoDT int,
GhiChu varchar(100));
create table ThuePhong(
MaHD int auto_increment ,
MaSV int ,
MaPhong int,
BatDau date,
KetThuc date,
TienCoc int,
GiaThue int,
primary key (MaHD,MaSV,MaPhong),
foreign key (MaSV) references SinhVien(MaSV),
foreign key (MaPhong) references Phong(MaPhong)
);

CREATE TABLE TT_ThuePhong (
    MaHD INT PRIMARY KEY,
    Thang_Nam DATE,
    SoTien INT,
    NgayThanhToan DATE,
    MaNV INT,
    FOREIGN KEY (MaHD) REFERENCES ThuePhong(MaHD)
);
drop table TT_ThuePhong;
INSERT INTO Phong (TenPhong, DIenTich, SoGiuong, GiaThue) VALUES 
('Phong 1', 20, 2, 500000),
(' Phong 2' ,18 , 1 ,40000),
('Phong 3', 22, 3, 600000),
('Phong 4', 16, 12, 450000),
('Phong 5', 25, 4, 700000),
('Phong 6', 19, 1, 400000),
('Phong 7', 21, 2, 500000),
('Phong 8', 23, 2, 500000),
('Phong 9', 17, 1, 400000),
('Phong 10', 24, 2, 500000);
insert into Lop(TenLop)
 values
  ('Lop 1'),
 ('Lop 2'),
 ('Lop 3'),
 ('Lop 4'),
 ('Lop 5'),
 ('Lop 6'),
 ('Lop 7'),
 ('Lop 8'),
 ('Lop 9'),
 ('Lop 10');
insert into SinhVien(HoTen,SoDT,MaLop) values
('Sinh Vien 1 ', 0987654321,1),
('Sinh Vien 2 ', 0987654322,2),
('Sinh Vien 3 ', 0987654323,3),
('Sinh Vien 4 ', 0987654324,4),
('Sinh Vien 5', 0987654325,5),
('Sinh Vien 6 ', 0987654326,6),
('Sinh Vien 7 ', 0987654327,7),
('Sinh Vien 8 ', 0987654328,8),
('Sinh Vien 9 ', 0987654329,9),
('Sinh Vien 10 ', 0987654320,10);
insert into NhanVien (HoTen,SoDT,GhiChu)
values ('Nhan Vien 1',0987654321,' Ghi chu 1'),
 ('Nhan Vien 2',0987654322,' Ghi chu 2'),
 ('Nhan Vien 3',0987654323,' Ghi chu 3'), 
 ('Nhan Vien 4',0987654324,' Ghi chu 4'), 
 ('Nhan Vien 5',0987654325,' Ghi chu 5'), 
 ('Nhan Vien 6',0987654326,' Ghi chu 6'),
 ('Nhan Vien 7',0987654327,' Ghi chu 7'),
 ('Nhan Vien 8',0987654328,' Ghi chu 8'),
 ('Nhan Vien 9',0987654329,' Ghi chu 9'),
 ('Nhan Vien 10',0987654320,' Ghi chu 10');
 insert into ThuePhong(MaSV,MaPhong,BatDau,KetThuc,TienCoc,GiaThue)
 values
 (1,1, '2023-01-01',' 2023-12-31', 1000000 ,500000),
 (2,2, '2023-01-01',' 2023-12-31', 800000 , 400000),
 (3,3, '2023-01-01',' 2023-12-31', 1200000 , 600000),
 (4,4, '2023-01-01',' 2023-12-31', 900000 ,450000),
 (5,5, '2023-01-01',' 2023-12-31', 1400000 ,700000),
 (6,6, '2023-01-01',' 2023-12-31', 800000 , 400000
),
 (7,7, '2023-01-01',' 2023-12-31',  1000000 , 500000
),
 (8,8, '2023-01-01',' 2023-12-31', 1200000 ,600000
),
 (9,9, '2023-01-01',' 2023-12-31',  800000 , 400000
),
 (10,10, '2023-01-01',' 2023-12-31', 1000000 ,500000);
 insert IGNORE INTO TT_ThuePhong (MaHD,Thang_Nam,SoTien,NgayThanhToan,MaNV)
 values 
 (1,'2023-01-01',500000 , '2023-01-05',  1),
 (1,' 2023-02-01 ', 500000 ,' 2023-02-05',  2),
 (1,'2023-03-01 ', 500000 ,' 2023-03-05',  3),
 (2,'2023-01-01',  400000, ' 2023-01-05',  4),
 (2,'2023-02-01 ', 400000 ,' 2023-02-05 ',  5),
 (2,'2023-03-01 ', 400000 ,' 2023-03-05',  6),
 (3,'2023-01-01 ', 600000 ,' 2023-01-05',  7),
 (3,'2023-02-01 ', 600000 ,' 2023-02-05',  8),
 (3,'2023-03-01 ', 600000 ,' 2023-03-05',  9),
 (4,'2023-01-01 ', 450000 ,'2023-01-05',  10);
 truncate table TT_ThuePhong;
 select * from Phong;
select * from Phong where DienTich<50;
select* from Lop where TenLop like '%10';
select * from SinhVien where MaLop =3;
select * from SinhVien where SoDT like '9%';
select* from ThuePhong where BatDau='2023-01-01';
update  Phong set GiaThue='1500000' where MaPhong=6; 
update Lop set TenLop='5A' where MaLop=5;
update SinhVien set SoDT=0999999999 where MaSV=5;
update NhanVien set GhiChu='Ghi chú mới' where MaNV=1;
update ThuePhong set GiaThue= 450000 where MaHD=5;
delete from Phong  where MaPhong=2;
delete from ThuePhong  where MaPhong=2;
SET FOREIGN_KEY_CHECKS=0;
delete from Lop where MaLop=5;