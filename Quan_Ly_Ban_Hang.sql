CREATE DATABASE Quan_Ly_Ban_Hang;
USE Quan_Ly_Ban_Hang;
create table NHANVIEN(
MaNV varchar (100),
HoNV varchar(100),
TenNV varchar (100),
GioiTinh enum('Nam','Nữ'),
NgaySinh Date,
DiaChi varchar (100),
DienThoai varchar (100)
);
alter table  NHANVIEN 
modify GioiTinh enum('Nam','Nữ');
alter table NHANVIEN
add primary key(MaNV);
alter table NHANVIEN
modify MaNV varchar(100);
drop table NHANVIEN;
create table KHACHHANG(
MaKH varchar (100),
HoTenKH varchar (100),
DiaChi varchar (100),
DienThoai varchar (100)

);

alter table KHACHHANG
add primary key (MaKH);
create table HOADON(
MaHD int primary key,
MaKH varchar (100),
MaNV varchar (100),
NgayLapHD date ,
NgayNhanHang date,
foreign key (MaKH) references KHACHHANG(MaKH),
foreign key (MaNV) references NHANVIEN(MaNV)
);
drop table KHACHHANG;
create table SANPHAM(
MaSP varchar(100) primary key,
TenSP varchar(100),
DonViTinh varchar(100),
DonGia int
check(DonGia>0)
);
create table CHITIETHD(
MaHD int ,
MaSP varchar(100),
SoLuong int ,
Check(SoLuong>0),
primary key(MaHD,MaSP),
foreign key (MaSP) references SANPHAM(MaSP),
foreign key (MaHD) references HOADON(MaHD)

);
insert into KHACHHANG values
('B145','Cửa Hàng số 2 Q4','20 Trần Phú Q2',86547893),
('D100','Công Ty Cổ Phần Đầu tư','22 Ngô Quyền Q5',86123564),
('L010','Cửa Hàng Bách Hóa Q1','155 Trần Hưng Đạo',85456123),
('S001','Công Ty XNK Hoa Hồng','123 Trần Phú',8356423),
('S002','Công Ty VHP Tân Bình','10 Lý thường Kiệt',8554545);


insert into NHANVIEN values
('1','Lê văn','Tám','Nam','1965-10-12','45 Trần Phú',86452345),
('2','Trần thị','Lan','Nữ','1970-10-20','15 Nguyễn Trãi Q5',null),
('3','Tạ thành','Tâm','Nam','1965-12-10','20 Võ thị Sáu',85656666),
('4','Ngô Thanh','Sơn','Nam','1965-10-12','122 Trần Phú',null),
('5','Lê thị','Thủy','Nữ','1970-10-10','25 Ngô Quyền',97654123);
insert into HOADON values
('1','S001','1','1999-06-28','1999-07-10'),
('2','L010','2','1999-06-29','1999-07-12'),
('3','S002','1','1999-07-04','1999-07-12'),
('4','B145','4','1999-07-05','1999-07-10'),
('5','D100','3','1999-07-06','1999-07-20'),
('6','S001','2','1999-07-07','1999-07-21');
insert into SANPHAM values
('B01','Bia 33','Lon','4000'),
('B02','Bia Tiger','Lon','5000'),
('B03','Bia 33','Lon','6000'),
('R01','Rượu Bình tây','Chai','20000'),
('R02','Rượu Mơ','Chai','13000');
insert into CHITIETHD values
('1','B01','48'),
('1','R01','10'),
('2','B01','25'),
('2','B02','90'),
('2','B03','25'),
('2','R02','20'),
('3','B01','10'),
('4','B01','15'),
('4','R01','20'),
('4','R02','15'),
('5','B01','10'),
('6','R02','15');













