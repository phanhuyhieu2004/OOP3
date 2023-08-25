CREATE DATABASE Quan_Ly_Sinh_Vien;
USE Quan_Ly_Sinh_Vien;
CREATE TABLE Khoa (
    Ma_Khoa VARCHAR(10) PRIMARY KEY,
    Ten_Khoa NVARCHAR(100),
    Nam_Thanh_Lap INT
);
INSERT INTO Khoa (Ma_Khoa, Ten_Khoa, Nam_Thanh_Lap)
VALUES 
    ('K1', 'Khoa Công nghệ thông tin', 1998),
    ('K2', 'Khoa Kinh tế', 1995),
    ('K3', 'Khoa Ngôn ngữ học', 2002),
    ('K4', 'Khoa Luật', 1990),
    ('K5', 'Khoa Ngoại ngữ', 1985),
    ('K6', 'Khoa Quản trị kinh doanh', 2000),
    ('K7', 'Khoa Khoa học xã hội', 1997),
    ('K8', 'Khoa Mỹ thuật', 1988),
    ('K9', 'Khoa Kỹ thuật công trình', 1993),
    ('K10', 'Khoa Y học', 1975);
         SELECT * FROM Khoa;
          SELECT * FROM Khoa WHERE Ma_Khoa = 'K2';

CREATE TABLE Khoa_Hoc (
    Ma_Khoa_Hoc VARCHAR(10) PRIMARY KEY,
    Nam_Bat_Dau INT,
    Nam_Ket_Thuc INT
);
INSERT INTO Khoa_Hoc (Ma_Khoa_Hoc, Nam_Bat_Dau, Nam_Ket_Thuc)
VALUES 
    ('KH1', 2010, 2014),
    ('KH2', 2015, 2019),
    ('KH3', 2020, 2024),
    ('KH4', 2005, 2009),
    ('KH5', 2000, 2004),
    ('KH6', 1995, 1999),
    ('KH7', 1990, 1994),
    ('KH8', 1985, 1989),
    ('KH9', 1980, 1984),
    ('KH10', 1975, 1979);

CREATE TABLE Chuong_Trinh_Hoc (
    Ma_CT VARCHAR(10) PRIMARY KEY,
    Ten_CT NVARCHAR(100)
);
INSERT INTO Chuong_Trinh_Hoc (Ma_CT, Ten_CT)
VALUES 
    ('CTH1', 'Chương trình học 1'),
    ('CTH2', 'Chương trình học 2'),
    ('CTH3', 'Chương trình học 3'),
    ('CTH4', 'Chương trình học 4'),
    ('CTH5', 'Chương trình học 5'),
    ('CTH6', 'Chương trình học 6'),
    ('CTH7', 'Chương trình học 7'),
    ('CTH8', 'Chương trình học 8'),
    ('CTH9', 'Chương trình học 9'),
    ('CTH10', 'Chương trình học 10');
CREATE TABLE Lop (
    Ma_Lop VARCHAR(10) PRIMARY KEY,
    Ma_Khoa VARCHAR(10) NOT NULL,
    Ma_Khoa_Hoc VARCHAR(10) NOT NULL,
    Ma_CT VARCHAR(10) NOT NULL,
    STT INT,
    FOREIGN KEY (Ma_Khoa) REFERENCES Khoa (Ma_Khoa),
    FOREIGN KEY (Ma_Khoa_Hoc) REFERENCES Khoa_Hoc (Ma_Khoa_Hoc),
    FOREIGN KEY (Ma_CT) REFERENCES Chuong_Trinh_Hoc (Ma_CT)
);
INSERT INTO Lop (Ma_Lop, Ma_Khoa, Ma_Khoa_Hoc, Ma_CT, STT)
VALUES 
    ('L1', 'K1','KH1', 'CTH1', 1),
    ('L2', 'K2', 'KH2', 'CTH2', 2),
    ('L3', 'K3', 'KH3', 'CTH3', 3),
    ('L4', 'K4', 'KH4', 'CTH4', 4),
    ('L5', 'K5', 'KH5', 'CTH5', 5),
    ('L6', 'K6', 'KH6', 'CTH6', 6),
    ('L7', 'K7', 'KH7', 'CTH7', 7),
    ('L8', 'K8', 'KH8', 'CTH8', 8),
    ('L9', 'K9', 'KH9', 'CTH9', 9),
    ('L10', 'K10', 'KH10', 'CTH10', 10);
     SELECT * FROM Lop;
        SELECT * FROM Lop WHERE STT > 1;
CREATE TABLE Sinh_Vien (
    MaSV VARCHAR(10) PRIMARY KEY,
    Ho_Ten NVARCHAR(100),
    Nam_Sinh INT,
    Dan_Toc NVARCHAR(20),
    Ma_Lop VARCHAR(10) NOT NULL,
    FOREIGN KEY (Ma_Lop) REFERENCES Lop (Ma_Lop)
);
INSERT INTO Sinh_Vien (MaSV, Ho_Ten, Nam_Sinh, Dan_Toc, Ma_Lop)
VALUES 
    ('SV1', 'Nguyễn Văn A', 1995, 'Kinh', 'L1'),
    ('SV2', 'Trần Thị B', 1996, 'Tày', 'L2'),
    ('SV3', 'Lê Văn C', 1997, 'Mường', 'L3'),
    ('SV4', 'Phạm Thị D', 1998, 'Hoa', 'L4'),
    ('SV5', 'Hoàng Văn E', 1999, 'Kinh', 'L5'),
    ('SV6', 'Vũ Thị F', 2000, 'Chăm', 'L6'),
    ('SV7', 'Đặng Văn G', 2001, 'Tày', 'L7'),
    ('SV8', 'Nguyễn Thị H', 2002, 'Hoa', 'L8'),
    ('SV9', 'Trần Văn I', 2003, 'Kinh', 'L9'),
    ('SV10', 'Lê Thị K', 2004, 'Mường', 'L10');
    SELECT * FROM Sinh_Vien WHERE Dan_Toc = 'Kinh';
     SELECT * FROM Sinh_Vien;
CREATE TABLE Mon_Hoc (
    MaMH VARCHAR(10) PRIMARY KEY,
    Ma_Khoa VARCHAR(10) NOT NULL,
    TenMH NVARCHAR(100),
    FOREIGN KEY (Ma_Khoa) REFERENCES Khoa (Ma_Khoa)
);
INSERT INTO Mon_Hoc (MaMH, Ma_Khoa, TenMH)
VALUES 
    ('MH1', 'K1', 'Môn học 1'),
    ('MH2', 'K2', 'Môn học 2'),
    ('MH3', 'K3', 'Môn học 3'),
    ('MH4', 'K4', 'Môn học 4'),
    ('MH5', 'K5', 'Môn học 5'),
    ('MH6', 'K6', 'Môn học 6'),
    ('MH7', 'K7', 'Môn học 7'),
    ('MH8', 'K8', 'Môn học 8'),
    ('MH9', 'K9', 'Môn học 9'),
    ('MH10', 'K10', 'Môn học 10');
CREATE TABLE Ket_Qua (
    MaSV VARCHAR(10) NOT NULL,
    MaMH VARCHAR(10) NOT NULL,
    Lan_Thi INT NOT NULL,
    Diem_Thi FLOAT,
    PRIMARY KEY (MaSV, MaMH, Lan_Thi),
    FOREIGN KEY (MaSV) REFERENCES Sinh_Vien (MaSV),
    FOREIGN KEY (MaMH) REFERENCES Mon_Hoc (MaMH)
);
INSERT INTO Ket_Qua (MaSV, MaMH, Lan_Thi, Diem_Thi)
VALUES
('SV1', 'MH1', 1, 8.5),
    ('SV2', 'MH2', 1, 7.2),
    ('SV3', 'MH3', 1, 9.0),
    ('SV4', 'MH4', 1, 6.8),
    ('SV5', 'MH5', 1, 8.0),
    ('SV6', 'MH6', 1, 7.5),
    ('SV7', 'MH7', 1, 9.5),
    ('SV8', 'MH8', 1, 6.0),
    ('SV9', 'MH9', 1, 8.2),
    ('SV10', 'MH10', 1, 7.9);
CREATE TABLE Giang_Khoa (
    Ma_CT VARCHAR(10) NOT NULL,
    Ma_Khoa VARCHAR(10) NOT NULL,
    MaMH VARCHAR(10) NOT NULL,
    Nam_Hoc INT NOT NULL,
    Hoc_Ky INT,
    STLT INT,
    STTH INT,
    So_Tin_Chi INT,
    PRIMARY KEY (Ma_CT, Ma_Khoa, MaMH, Nam_Hoc),
    FOREIGN KEY (Ma_CT) REFERENCES Chuong_Trinh_Hoc (Ma_CT),
    FOREIGN KEY (Ma_Khoa) REFERENCES Khoa (Ma_Khoa),
    FOREIGN KEY (MaMH) REFERENCES Mon_Hoc (MaMH)
);
INSERT INTO Giang_Khoa (Ma_CT, Ma_Khoa, MaMH, Nam_Hoc, Hoc_Ky, STLT, STTH, So_Tin_Chi)
VALUES 
    ('CTH1', 'K1', 'MH1', 2020, 1, 30, 60, 3),
    ('CTH2', 'K2', 'MH2', 2020, 1, 45, 90, 4),
    ('CTH3', 'K3', 'MH3', 2020, 1, 60, 120, 5),
    ('CTH4', 'K4', 'MH4', 2020, 1, 30, 60, 3),
    ('CTH5', 'K5', 'MH5', 2020, 1, 45, 90, 4),
    ('CTH6', 'K6', 'MH6', 2020, 1, 60, 120, 5),
    ('CTH7', 'K7', 'MH7', 2020, 1, 30, 60, 3),
    ('CTH8', 'K8', 'MH8', 2020, 1, 45, 90, 4),
    ('CTH9', 'K9', 'MH9', 2020, 1, 60, 120, 5),
    ('CTH10', 'K10', 'MH10', 2020, 1, 30, 60, 3);
    DELETE FROM Giang_Khoa 
WHERE MaMH = 'MH10';
 UPDATE Khoa
     SET Ten_Khoa = 'Khoa Công nghệ thông tin mới'
     WHERE Ma_Khoa = 'K1';

UPDATE Sinh_Vien
SET Nam_Sinh = 1997
WHERE MaSV = 'SV10';
