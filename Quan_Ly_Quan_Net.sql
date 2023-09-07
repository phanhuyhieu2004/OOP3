create database Quan_Ly_Quan_Net;
use  Quan_Ly_Quan_Net;

CREATE TABLE NhanVien (
    MaNV INT PRIMARY KEY auto_increment ,
    HoTen VARCHAR(100),
    SoDT int,
    Email NVARCHAR(100)
   
   
);
drop table Nhan_vien;
drop table Thiet_bi;
CREATE TABLE ThietBi (
    MaTB INT PRIMARY KEY,
    TenTB VARCHAR(100),
    DonGia double,
    TinhTrang varchar(200)    
);
alter table ThietBi modify TinhTrang varchar(200);
create table MayTinh(
MaMT int auto_increment primary key,
Ten varchar(100),
MoTaCH varchar(100),
NgaySD date);

CREATE TABLE CTMayTinh (
    MaMT INT,
    MaTB INT,
    NBD DATE,
    Nkt DATE,
    FOREIGN KEY (MaMT) REFERENCES MayTinh(MaMT),
    FOREIGN KEY (MaTB) REFERENCES ThietBi(MaTB)
);
drop table CTMaytinh;
create table KhachHang(
MaKH int auto_increment primary key,
TenKH varchar(100),
SDT int,
GhiChu varchar(100));



-- Tạo bảng Thue với khóa ngoại Ma_khach_hang và Ma_may_tinh tham chiếu đến bảng Khach_hang và May_tinh
CREATE TABLE Thue (
    MaThue INT PRIMARY KEY,
    MaKH INT,
    MaMT INT,
    TGBT DATE,
    TGKT TIME,
    FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
    FOREIGN KEY (MaMT) REFERENCES MayTinh(MaMT)
);

CREATE TABLE ThanhToan (
    MaThue INT auto_increment,
    SoTien Double,
    SoThanhToan int,
    SoConNo double,
    GhiChu VARCHAR(200),
    
    FOREIGN KEY (MaThue) REFERENCES Thue(MaThue)
);
drop table ThanhToan;
-- Thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien(HoTen,SoDT,Email) 
VALUES
    ('Nguyen Van A', 987654321, 'nv.a@example.com'),
    ('Tran Thi B', 123456789, 'tt.b@example.com'),
    ('Le Van C', 912345678, 'lv.c@example.com'),
    ('Pham Thi D', 845678901, 'pt.d@example.com'),
    ('Hoang Van E', 978901234, 'hv.e@example.com'),
    ('Do Thi F', 912345678, 'dt.f@example.com'),
    ('Truong Van G', 987654321, 'tv.g@example.com'),
    ('Le Thi H', 123456789, 'lt.h@example.com'),
    ('Nguyen Van I', 912345678, 'nv.i@example.com'),
    ('Tran Thi K', 845678901, 'tt.k@example.com');

-- Thêm dữ liệu vào bảng ThietBi
INSERT INTO ThietBi (MaTB, TenTB, DonGia, TinhTrang)
VALUES
    (1, 'Chuot', 50.0, 'Moi'),
    (2, 'Ban phim', 100.0, 'Moi'),
    (3, 'Man hinh', 200.0, 'Moi'),
    (4, 'CPU', 500.0, 'Moi'),
    (5, 'RAM', 300.0, 'Moi'),
    (6, 'HDD', 400.0, 'Moi'),
    (7, 'Tai nghe', 150.0, 'Moi'),
    (8, 'Loa', 120.0, 'Moi'),
    (9, 'USB', 20.0, 'Moi'),
    (10, 'Webcam', 80.0, 'Moi');

-- Thêm dữ liệu vào bảng MayTinh
INSERT INTO MayTinh (Ten, MoTaCH, NgaySD)
VALUES
    ('May tinh 1', 'CPU Intel Core i5, RAM 8GB, HDD 1TB', '2023-01-01'),
    ('May tinh 2', 'CPU Intel Core i7, RAM 16GB, HDD 2TB', '2023-01-01'),
    ('May tinh 3', 'CPU AMD Ryzen 5, RAM 8GB, HDD 1TB', '2023-01-01'),
    ('May tinh 4', 'CPU AMD Ryzen 7, RAM 16GB, HDD 2TB', '2023-01-01'),
    ('May tinh 5', 'CPU Intel Core i3, RAM 4GB, HDD 500GB', '2023-01-01'),
    ('May tinh 6', 'CPU Intel Core i5, RAM 8GB, SSD 256GB', '2023-01-01'),
    ('May tinh 7', 'CPU AMD Ryzen 3, RAM 4GB, HDD 500GB', '2023-01-01'),
    ('May tinh 8', 'CPU AMD Ryzen 5, RAM 8GB, SSD 256GB', '2023-01-01'),
    ('May tinh 9', 'CPU Intel Core i7, RAM 16GB, SSD 512GB', '2023-01-01'),
    ('May tinh 10', 'CPU Intel Core i9, RAM 32GB, SSD 1TB', '2023-01-01');

-- Thêm dữ liệu vào bảng CTMayTinh
INSERT INTO CTMayTinh (MaMT, MaTB, NBD, Nkt)
VALUES
    (1, 1, '2023-01-01', '2023-12-31'),
    (2, 2, '2023-01-01', '2023-12-31'),
    (3, 3, '2023-01-01', '2023-12-31'),
    (4, 4, '2023-01-01', '2023-12-31'),
    (5, 5, '2023-01-01', '2023-12-31'),
    (6, 6, '2023-01-01', '2023-12-31'),
    (7, 7, '2023-01-01', '2023-12-31'),
    (8, 8, '2023-01-01', '2023-12-31'),
    (9, 9, '2023-01-01', '2023-12-31'),
    (10, 10, '2023-01-01', '2023-12-31');
    -- Thêm dữ liệu vào bảng CTMayTinh

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (TenKH, SDT, GhiChu)
VALUES
    ('Nguyen Van X', '0987654321', 'Khach hang VIP'),
    ('Tran Thi Y', '0123456789', 'Khach hang than thiet'),
    ('Le Van Z', '0912345678', 'Khach hang moi'),
    ('Pham Thi W', '0845678901', 'Khach hang tiem nang'),
    ('Hoang Van U', '0978901234', 'Khach hang thuong xuyen'),
    ('Do Thi P', '0912345678', 'Khach hang VIP'),
    ('Truong Van Q', '0987654321', 'Khach hang than thiet'),
    ('Le Thi R', '0123456789', 'Khach hang moi'),
    ('Nguyen Van S', '0912345678', 'Khach hang tiem nang'),
    ('Tran Thi T', '0845678901', 'Khach hang thuong xuyen');

-- Thêm dữ liệu vào bảng Thue
INSERT INTO Thue (MaThue,MaKH, MaMT,  TGBT, TGKT)
VALUES
    (1, 1, 1, '2023-01-01 08:00:00', '2023-01-01 10:00:00'),
    (2, 2, 2, '2023-01-02 10:00:00', '2023-01-02 12:00:00'),
    (3, 3, 3, '2023-01-03 12:00:00', '2023-01-03 14:00:00'),
    (4, 4, 4, '2023-01-04 14:00:00', '2023-01-04 16:00:00'),
    (5, 5, 5, '2023-01-05 16:00:00', '2023-01-05 18:00:00'),
    (6, 6, 6, '2023-01-06 18:00:00', '2023-01-06 20:00:00'),
    (7, 7, 7, '2023-01-07 20:00:00', '2023-01-07 22:00:00'),
    (8, 8, 8, '2023-01-08 22:00:00', '2023-01-08 00:00:00'),
    (9, 9, 9, '2023-01-09 00:00:00', '2023-01-09 02:00:00'),
    (10, 10, 10, '2023-01-10 02:00:00', '2023-01-10 04:00:00');

-- Thêm dữ liệu vào bảng ThanhToan
INSERT INTO ThanhToan (MaThue, SoTien, SoThanhToan, SoConNo, GhiChu)
VALUES
    (2, 100.0, 100.0, 0.0, 'Da thanh toan'),
    (3, 150.0, 150.0, 0.0, 'Da thanh toan'),
    (4, 200.0, 200.0, 0.0, 'Da thanh toan'),
    (5, 250.0, 250.0, 0.0, 'Da thanh toan'),
    (6, 300.0, 300.0, 0.0, 'Da thanh toan'),
    (7, 350.0, 350.0, 0.0, 'Da thanh toan'),
    (8, 400.0, 400.0, 0.0, 'Da thanh toan'),
    (9, 450.0, 450.0, 0.0, 'Da thanh toan'),
    (10, 500.0, 500.0, 0.0, 'Da thanh toan');
select * from NhanVien;

select TenTB,DonGia from ThietBi where TinhTrang='Dang su dung';
select Ten,MoTaCH from MayTinh where NgaySD between '2023-01-01' and '2023-06-30';
select TenKH,SDT from KhachHang where GhiChu='Khach hang VIP';
select * from Thue where MaThue=1;
update  NhanVien set SoDT=0987654321 where MaNV=1;
update ThietBi set TinhTrang='Hỏng hóc' where MaTB=1;
update MayTinh set MoTaCH='CPU Intel Core i5, RAM 8GB, SSD 256GB' where MaMT=1;
update KhachHang set GhiChu='KH thân thiết ' where MaKH=1;
update Thue set TGBT ='2023-01-08 08:00:00', TGKT='2023-09-10 12:00:00'where MaThue=1;
delete from NhanVien where MaNV=10;