-- Tao Database
create database quanlydiemtest;

-- Tao bang lop
create table lop(
malop varchar(10) primary key,
tenlop varchar(100)
);

-- Them du lieu vao lop
insert into lop values('PT13301','Ứng dụng phần mềm 1');
insert into lop values('PT13302','Ứng dụng phần mềm 2');
insert into lop values('PT13303','Ứng dụng phần mềm 3');
insert into lop values('PT13304','Ứng dụng phần mềm 4');
insert into lop values('PT13305','Ứng dụng phần mềm 5');
insert into lop values('PT13306','Ứng dụng phần mềm 6');
insert into lop values('PT13307','Ứng dụng phần mềm 6');
insert into lop values('PT13308','Ứng dụng phần mềm 7');
insert into lop values('PT13309','Ứng dụng phần mềm 9');

-- Tao bang mon hoc
create table monhoc(
mamh varchar(10) primary key,
tenmh nvarchar(100),
sotiet int
);

-- Them du lieu vao bang

insert into monhoc values('mob1013','lập trình java1',36);
insert into monhoc values('mob1022','lập trình java2',36);
insert into monhoc values('sof203','lập trình java3',36);
insert into monhoc values('com2012','Cơ sở dữ liệu',36);
insert into monhoc values('com2032','Hệ quản trị CSDL',30);

-- Tao bang sinh vien
create table sinhvien
(
masv varchar(10) primary key,
hoten nvarchar(100),
ngaysinh date,
quequan nvarchar(100),
Gioitinh varchar(5),
malop varchar(10),
foreign key(malop) references lop(malop)
);

-- Them du lieu vao bang
Insert into sinhvien values('ph06230','Trần Lê Huy','2000-06-07','Hà Nội','Nam','PT13302');
Insert into sinhvien values('ph06231','Nguyễn Thị Mỹ Duyên','2001-07-07','Hà Nội','Nữ','PT13302');
Insert into sinhvien values('ph06232','Võ Tá Nhật Anh','2003-09-07','Hà Tĩnh','Nam','PT13302');
Insert into sinhvien values('ph06233','Trần Thị Thùy Trang','2000-06-03','Hải Phòng','Nữ','PT13302');
Insert into sinhvien values('ph06234','Nguyễn Thị Mừng','2000-06-02','Hà Nội','Nữ','PT13305');
Insert into sinhvien values('ph06235','Nguyễn Xuân Trường','2000-06-06','Hà Nội','Nam','PT13305');
Insert into sinhvien values('ph06236','Nguyễn Lê Huy','2005-06-07','Hà Nội','Nam','PT13306');
Insert into sinhvien values('ph06237','Nguyễn An','2003-06-07','Hà Nội','Nam','PT13306');
Insert into sinhvien values('ph06238','Nguyễn An','2003-06-07','Hà Nội','Nam','PT13301');

-- Tao bang ketqua

create table ketqua(
masv varchar(10) ,
mamh varchar(10) ,
lanthi int ,
diemthi double,
primary key(masv,mamh,lanthi),
foreign key(masv) references sinhvien(masv),
foreign key(mamh) references monhoc(mamh)
);

-- Them du lieu vao bang ket qua
insert into ketqua values('ph06230','sof203',1,3);
insert into ketqua values('ph06230','sof203',2,6);
insert into ketqua values('ph06230','com2012',1,8);
insert into ketqua values('ph06233','sof203',1,7);
insert into ketqua values('ph06234','sof203',1,9);
select * from lop
-- Câu 1:  
-- Đưa ra toàn bộ thông tin của bảng sinhvien
SELECT * FROM sinhvien;
-- Đưa ra thông tin bảng môn học
SELECT * FROM monhoc;

-- Đưa ra mã sinh viên và năm sinh của sinh viên có quê là Hải phòng
SELECT * FROM sinhvien WHERE quequan="Hải Phòng";
-- Đưa ra thông tin sinh viên có giới tính là Nam, sinh năm 2000
SELECT * FROM sinhvien WHERE gioitinh="Nam" AND YEAR(ngaysinh)="2000";

-- Đưa ra thông tin của 2 sinh viên đầu tiên có giới tính là Nam, sinh năm 2000 
SELECT * FROM sinhvien WHERE gioitinh="Nam" AND YEAR(ngaysinh)="2000" LIMIT 2;

-- Đưa ra thông tin sinh viên có họ Trần
SELECT * FROM sinhvien WHERE hoten LIKE"Trần%";
-- Đưa ra thông tin sinh viên có tên đệm là Thị
SELECT * FROM sinhvien WHERE hoten LIKE"%Thị%";

-- Đưa ra thông tin sinh viên có tên là An
SELECT * FROM sinhvien WHERE hoten LIKE"%%An"

-- Đưa ra thông tin của sinh viên có họ là Nguyễn sắp xếp theo thứ tự giảm dần dựa theo mã sinh viên
SELECT * FROM sinhvien WHERE hoten LIKE"Nguyễn%%" ORDER BY masv DESC;

-- Hiển thị tên, mã sv, của những sinh viên có tuổi < 20
SELECT sinhvien.hoten,sinhvien.masv FROM sinhvien WHERE year(now())-year(ngaysinh)<20;
-- Hiển thị thông tin sinh viên có mã sinh viên là ph06235,ph06238,ph06231,ph06230
SELECT * FROM sinhvien WHERE masv IN ('ph06235', 'ph06238', 'ph06231', 'ph06230');

-- Hiển thị kết quả sinh viên có điểm từ 3 đến 7.
SELECT * FROM ketqua WHERE diemthi BETWEEN 3 AND 7;
-- Câu 2.
-- Đưa ra thông tin sinh viên có quê là Hà Nội sắp xếp theo họ tên
SELECT * FROM sinhvien WHERE quequan="Hà Nội" ORDER BY hoten;
-- Đưa ra số lượng sinh viên hiện tại của toàn khối
SELECT COUNT(*) AS soluong FROM sinhvien;
-- Đưa số lượng sinh viên của các lớp có số lượng sinh viên > 2
SELECT  COUNT(*)>2 AS soluong FROM sinhvien;


-- Đưa ra những môn học có số tiết < 36
SELECT * FROM monhoc WHERE sotiet < 36;
-- Thống kê số lượng sinh viên của các lớp
SELECT lop.malop, lop.tenlop, COUNT(sinhvien.masv) AS soluong
FROM lop
JOIN sinhvien ON lop.malop = sinhvien.malop
GROUP BY lop.malop, lop.tenlop;
-- Đưa ra số lượng sinh viên có tuổi từ 18 đến 65
SELECT COUNT(*) AS soluong
FROM sinhvien
WHERE year(now())-year(ngaysinh) BETWEEN 18 AND 65;
-- Hiển thị những lớp không có sinh viên
SELECT lop.malop, lop.tenlop
FROM lop
LEFT JOIN sinhvien ON lop.malop = sinhvien.malop
WHERE sinhvien.masv IS NULL;
-- Câu 3. 
-- Đưa ra mã sinhvien, ho tên, tên lớp của sinh viên có quê là Hà Tĩnh.
SELECT sinhvien.masv, sinhvien.hoten, lop.tenlop
FROM sinhvien
JOIN lop ON sinhvien.malop = lop.malop
WHERE sinhvien.quequan = 'Hà Tĩnh';
-- Cũng như câu 1 nhưng dùng bí danh
SELECT s.masv, s.hoten, l.tenlop
FROM sinhvien s
JOIN lop l ON s.malop = l.malop
WHERE s.quequan = 'Hà Tĩnh';
-- Đưa ra thông tin masv	, hoten, giới tính của sv thuộc lớp Ứng dụng phần mềm 2
SELECT  sinhvien.masv, sinhvien.hoten, sinhvien.Gioitinh
FROM sinhvien
JOIN lop ON sinhvien.malop = lop.malop
WHERE lop.tenlop = 'Ứng dụng phần mềm 2';

-- Đưa ra masv,hoten,tenmh,diem thi,lanthi của những sinh viên có quê là Hà Nội
SELECT  sinhvien.masv, sinhvien.hoten, monhoc.tenmh,ketqua.lanthi
FROM sinhvien
JOIN lop ON sinhvien.malop = lop.malop
JOIN ketqua ON sinhvien.masv = ketqua.masv
WHERE sinhvien.quequan= 'Hà Nội';
SELECT sinhvien.masv, sinhvien.hoten, monhoc.tenmh, ketqua.diemthi, ketqua.lanthi
FROM sinhvien
JOIN ketqua ON sinhvien.masv = ketqua.masv
JOIN monhoc ON ketqua.mamh = monhoc.mamh
WHERE sinhvien.quequan = 'Hà Nội';
-- Thống kê số lượng sinh viên của lớp có số lượng sinh viên là thấp nhất
--  Đưa ra thông tin những sinh viên có cùng ngày sinh
SELECT s1.masv, s1.hoten, s1.ngaysinh, s2.masv, s2.hoten, s2.ngaysinh
FROM sinhvien AS s1, sinhvien AS s2
WHERE s1.masv != s2.masv
    AND s1.ngaysinh = s2.ngaysinh;
SELECT lop.malop, lop.tenlop, COUNT(sinhvien.masv) AS student_count
FROM lop
LEFT JOIN sinhvien ON lop.malop = sinhvien.malop
GROUP BY lop.malop, lop.tenlop
HAVING COUNT(sinhvien.masv) = (
SELECT MIN(student_count)
FROM (
SELECT COUNT(sinhvien.masv) AS soluongsinhvien
FROM lop
LEFT JOIN sinhvien ON lop.malop = sinhvien.malop
GROUP BY lop.malop,lop.tenlop
) AS subquery
);
