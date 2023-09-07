create database QuanLyDonHang;
use QuanLyDonHang;
create table KhachHang(
MaKH int auto_increment primary key,
Hoten varchar(100),
Ngaysinh date,
Quequan varchar(100),
Gioitinh enum('Nam','Nữ')
);
create table NhanVien(
MaNV int auto_increment primary key,
Hoten varchar(100),
Namlv int,
Luong int);
create table DonDatHang(
SoHD int,
MaKH int,
MaNV int,
primary Key(MaKH,MaNV,SoHD),
TenSP varchar(100),
Soluong int,
foreign key (MaKH) references  KhachHang(MaKH),
foreign key (MaNV) references  NhanVien(MaNV)

);
insert into KhachHang (Hoten,Ngaysinh,Quequan,Gioitinh) values
('Phan Huy Hiệu','2003-05-06','Hà Nội','Nam'),
('Nguyễn Thị Linh','2004-07-08','Phú Thọ','Nữ'),
('Nguyễn Văn Sơn','2003-09-08','Hà Nội','Nam'),
('Nguyễn Ngọc Lan','2002-07-06','HCM','Nữ');

insert into NhanVien(Hoten,Namlv,Luong) values
('Nguyễn Văn An',2023,10000),
('Nguyễn Như Quỳnh',2023,20000),
('Nguyễn Văn Giáp',2023,60000),
('Nguyễn Văn Minh',2023,70000);
insert into DonDatHang(SoHD,MaKH,MaNV,TenSP,Soluong) values
(1,1,1,'Mỹ phẩm thiên nhiên',200000),
(2,2,2,'Máy cắt cỏ',100000),
(3,3,3,'Máy sấy tóc',200000),
(4,4,4,'Máy xay thịt',300000);

select KhachHang.MaKH,KhachHang.Hoten,year(now())-year(Ngaysinh) as Tuoi,Quequan
from KhachHang where year(now())-year(Ngaysinh)>18 and Quequan='Hà Nội';

select NhanVien.MaNV,NhanVien.Hoten,NhanVien.Luong,Namlv from NhanVien where Namlv>2020 and Hoten like'%An';

select KhachHang.MaKH,KhachHang.Hoten,KhachHang.Gioitinh,DonDatHang.TenSP
 from KhachHang join DonDatHang on KhachHang.MaKH=DonDatHang.MaKH 
 where TenSP like 'Mỹ phẩm%';
 
--  select NhanVien.MaNV,NhanVien.Hoten,DonDatHang.TenSP,COUNT(Soluong) from NhanVien
--  join DonDatHang on NhanVien.MaNV=DonDatHang.MaNV where NhanVien.MaNV=(select * from DonDatHang)
select NhanVien.MaNV,NhanVien.Hoten,COUNT(Soluong) from NhanVien join DonDatHang on NhanVien.MaNV=DonDatHang.MaNV group by NhanVien.MaNV,NhanVien.Hoten order by COUNT(Soluong) DESC limit 1 ; 

update NhanVien set Namlv=2021 where Hoten='Phan Huy An';

delete from NhanVien where MaNV not in (SELECT MaNV from DonDatHang  );

DELIMITER $$
CREATE PROCEDURE Hienthidondathang()
BEGIN
   select * from DonDatHang where Soluong>100000;
END; $$
call QuanLyDonHang.Hienthidondathang();

DELIMITER $$
CREATE PROCEDURE Hienthithongtinkh(in ques varchar(100))
BEGIN
   select KhachHang.MaKH,KhachHang.Hoten,year(now())-year(Ngaysinh) as Tuoi,KhachHang.Quequan,DonDatHang.TenSP 
   from KhachHang join DonDatHang on KhachHang.MaKH=DonDatHang.MaKH where Quequan=ques;
END; $$
call QuanLyDonHang.Hienthithongtinkh('Hà Nội');










