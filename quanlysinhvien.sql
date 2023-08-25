-- Tạo cơ sở dữ liệu
CREATE DATABASE quanlysinhvien;

-- Sử dụng cơ sở dữ liệu
USE quanlysinhvien;

-- Tạo bảng Khoa
CREATE TABLE Khoa (
  maKhoa INT PRIMARY KEY,
  tenKhoa NVARCHAR(100),
  namThanhLap VARCHAR(10)
);

-- Thêm dữ liệu vào bảng Khoa
INSERT INTO Khoa (maKhoa, tenKhoa, namThanhLap) VALUES
(1, 'Công nghệ thông tin', '1995'),
(2, 'Vật Lý', '1970');
SELECT * FROM Khoa;

-- Tạo bảng KhoaHoc
CREATE TABLE KhoaHoc (
  MaKhoaHoc VARCHAR(10) PRIMARY KEY,
  namBatDau INT,
  namKetThuc INT
);


-- Thêm dữ liệu vào bảng KhoaHoc
INSERT INTO KhoaHoc (MaKhoaHoc, namBatDau, namKetThuc) VALUES
('K2002', 2002, 2006),
('K2003', 2003, 2007),
('K2004', 2004, 2008);
SELECT * FROM KhoaHoc;
CREATE TABLE GiangKhoa (
  maCT INT,
  maKhoa VARCHAR(50),
  maMH VARCHAR(50),
  namHoc INT,
  hocKy INT,
  soTietLyThuyet INT,
  soTietThucHanh INT,
  soTinChi INT
);


-- Tạo bảng SinhVien
CREATE TABLE SinhVien (
  MaSV INT PRIMARY KEY,
  hoTen VARCHAR(100),
  namSinh VARCHAR(10),
  danToc VARCHAR(20),
  maLop INT);

-- Thêm dữ liệu vào bảng SinhVien
INSERT INTO SinhVien (MaSV, hoTen, namSinh, danToc, maLop) VALUES
(212005, 'Trần Thị Mai', '1999', 'Kinh', 1), 
(212006, 'Lê Văn Luân', '2000', 'Kinh', 1), 
(212007, 'Phạm Thị Hương', '1999', 'Kinh', 2), 
(212008, 'Nguyễn Thị Ngọc Anh', '1998', 'Kinh', 2), 
(311007, 'Võ Văn Hùng', '2000', 'Kinh', 3), 
(311008, 'Đỗ Thị Kim Chi', '1999', 'Kinh', 3);
SELECT * FROM SinhVien;
-- Tạo bảng ChuongTrinh
CREATE TABLE ChuongTrinh (
  MaCT VARCHAR(100) PRIMARY KEY,
  tenChuongTrinh VARCHAR(100)
);

-- Thêm dữ liệu vào bảng ChuongTrinh
INSERT INTO ChuongTrinh (MaCT, tenChuongTrinh) VALUES
('TT', 'Chính Qui');
SELECT * FROM ChuongTrinh;

-- Tạo bảng MonHoc
CREATE TABLE MonHoc (
  MaMH VARCHAR(10) PRIMARY KEY,
  tenMonHoc VARCHAR(100),
  maKhoa INT
);

-- Thêm dữ liệu vào bảng MonHoc
INSERT INTO MonHoc (MaMH, tenMonHoc, maKhoa) VALUES
('THT01', 'Toán Cao cấp A1', 1),
('VLT01', 'Toán cao cấp A1', 2),
('THT02', 'Toán rời rạc', 1),
('THCS01', 'Cấu trúc dữ liệu 1', 1),
('THCS02', 'Hệ điều hành', 1);

-- Tạo bảng KetQua
CREATE TABLE KetQua (
  MaSV INT,
  MaMH VARCHAR(10),
  lanThi INT,
  diem FLOAT
);

-- Thêm dữ liệu vào bảng KetQua
INSERT INTO KetQua (MaSV, MaMH, lanThi, diem) VALUES
(212001, 'THT01', 1, 4),
(212001, 'THT01', 2, 7),
(212002, 'THT01', 1, 8),
(212003, 'THT01', 1, 6),
(212004, 'THT01', 1, 9),
(212001, 'THT02', 1, 8),
(212002, 'THT02', 1, 5.5),
(212003, 'THT02', 1, 4);
SELECT  *  FROM KetQua;
-- Sửa thông tin của khoa CNTT
UPDATE Khoa SET tenKhoa = 'Công nghệ thông tin và cơ sở dữ liệu' WHERE maKhoa = 1;

-- Xoá sinh viên có mã số 212001
DELETE FROM SinhVien WHERE MaSV = 212001;

-- Sửa thông tin của môn học Toán cao cấp A1
UPDATE MonHoc SET tenMonHoc = 'Toán cao cấp A2' WHERE MaMH = 'VLT01';
SET SQL_SAFE_UPDATES = 0;
-- Xoá kết quả của sinh viên có mã số 212002 trong môn THCS01
DELETE FROM KetQua WHERE MaSV = 212002 AND MaMH = 'THT01';

-- Sửa thông tin của lớp TH2002/01
UPDATE Lop SET maCT = 'Văn hóa' WHERE MaLop = 1;