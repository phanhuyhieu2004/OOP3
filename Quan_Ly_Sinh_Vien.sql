create database Quan_Ly_Sinh_Vien;
use Quan_Ly_Sinh_Vien;
create table Khoa(
Ten_Khoa varchar(255),
Ma_Khoa varchar(255),
Năm_Thanh_Lap int
);
Alter table Khoa
add primary key (Ma_Khoa);
Alter table Khoa
modify Ten_Khoa varchar(255) after Ma_Khoa;

create table Khoa_Hoc(
Ma_Khoa_Hoc varchar(10) primary key,
Nam_Bat_Dau int,
Nam_Ket_Thuc int

);
create table Chuong_Trinh_Hoc(
Ma_CT varchar(45) primary key,
Ten_CT nvarchar(100)
);
create table Lop(
Ma_Lop varchar(10) primary key,
Ma_Khoa varchar(255) not null,
Ma_Khoa_Hoc varchar(10) not null,
Ma_CT varchar(45) not null,
STT int,
foreign key (Ma_Khoa) references Khoa(Ma_Khoa),
foreign key (Ma_Khoa_Hoc) references Khoa_Hoc(Ma_Khoa_Hoc),
foreign key (Ma_CT) references Chuong_Trinh_Hoc(Ma_CT)
);
create table Sinh_Vien(
MaSV varchar(45) primary key,
Ho_Ten nvarchar(100),
Nam_Sinh int,
Dan_Toc nvarchar(45),
Ma_Lop varchar(10) not null,
foreign key (Ma_Lop) references Lop(Ma_Lop)
);
create table Mon_Hoc(
MaMH varchar (10) primary key,
Ma_Khoa varchar(255) not null,
TenMH nvarchar(100),
foreign key (Ma_Khoa) references Khoa(Ma_Khoa)
);
create table Ket_Qua(
MaSV varchar(45) not null,
MaMH varchar (10) not null,
Lan_Thi int not null,
Diem_Thi float,
primary key (MaSV,MaMH,Lan_Thi),
foreign key (MaSV) references Sinh_Vien(MaSV),
foreign key (MaMH) references Mon_Hoc (MaMH)
);
create table Giang_Khoa(
Ma_CT varchar(45) NOT NULL,
Ma_Khoa varchar(255) not null,
MaMH varchar (10) not null,
Nam_Hoc INT NOT NULL,
Hoc_Ky int,
STLT int,
STTH int,
So_Tin_Chi INT,
primary key (Ma_CT,Ma_Khoa,MaMH,Nam_Hoc),
foreign key (Ma_CT) references Chuong_Trinh_Hoc(Ma_CT),
foreign key (Ma_Khoa) references Khoa(Ma_Khoa),
foreign key (MaMH) references Mon_Hoc(MaMH)
);


INSERT INTO Khoa VALUES
('K1', 'Khoa Công nghệ thông tin', 1998),
('K2', 'Khoa Kinh tế', 1995),
('K3', 'Khoa Ngôn ngữ học', 2002),
('K4', 'Khoa Luật', 1990),
('K5', 'Khoa Ngoại ngữ', 1985),
('K6', 'Khoa Quản trị kinh doanh', 2000),
('K7', 'Khoa Khoa học xã hội', 1997),
('K8', 'Khoa Mỹ thuật', 1988),
('K9', 'Khoa thiết kế', 1993),
('K10', 'Khoa Y học', 1975);
insert into Khoa_Hoc values
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
    insert into Chuong_Trinh_Hoc values
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
    insert into Lop values
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
    insert into Sinh_Vien values
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
    insert into Mon_Hoc values 
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
    insert into Ket_Qua values
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
    insert into Giang_Khoa values
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
delete from Giang_Khoa where Ma_CT='CTH8';

update Khoa set Ten_Khoa='Yêu' where Ma_Khoa = 'K1';
select * from Sinh_Vien;
select * from Sinh_Vien where Dan_Toc='Kinh';
select Ho_Ten,Nam_Sinh from Sinh_Vien where MaSV='SV8';
select * from Khoa where Năm_Thanh_Lap<1998;
