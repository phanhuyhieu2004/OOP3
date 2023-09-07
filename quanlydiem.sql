create database quanlydiem;

create table lop(
malop varchar(10) primary key,
tenlop varchar(100)
);

insert into lop values('PT13301','Ứng dụng phần mềm 1');
insert into  lop values('PT13302','Ứng dụng phần mềm 2');
insert into lop values('PT13303','Ứng dụng phần mềm 3');
insert into  lop values('PT13304','Ứng dụng phần mềm 4');
insert into  lop values('PT13305','Ứng dụng phần mềm 5');
insert into  lop values('PT13306','Ứng dụng phần mềm 6');
insert into lop values('PT13307','Ứng dụng phần mềm 6');
insert into  lop values('PT13308','Ứng dụng phần mềm 7');
insert into  lop values('PT13309','Ứng dụng phần mềm 9');
create table monhoc(
mamh varchar(10) primary key,
tenmh nvarchar(100),
sotiet int
);
INSERT INTO monhoc VALUES('mob1013','lập trình java1',36);
INSERT INTO monhoc VALUES('mob1022','lập trình java2',36);
INSERT INTO monhoc VALUES('sof203','lập trình java3',36);
INSERT INTO monhoc VALUES('com2012','Cơ sở dữ liệu',36);
INSERT INTO monhoc VALUES('com2032','Hệ quản trị CSDL',30);
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
INSERT INTO sinhvien VALUES('ph06230','Trần Lê Huy','2000-06-07','Hà Nội','Nam','PT13302');
INSERT INTO sinhvien VALUES('ph06231','Nguyễn Thị Mỹ Duyên','2001-07-07','Hà Nội','Nữ','PT13302');
INSERT INTO sinhvien VALUES('ph06232','Võ Tá Nhật Anh','2003-09-07','Hà Tĩnh','Nam','PT13302');
INSERT INTO sinhvien VALUES('ph06233','Trần Thị Thùy Trang','2000-06-03','Hải Phòng','Nữ','PT13302');
INSERT INTO sinhvien VALUES('ph06234','Nguyễn Thị Mừng','2000-06-02','Hà Nội','Nữ','PT13305');
INSERT INTO sinhvien VALUES('ph06235','Nguyễn Xuân Trường','2000-06-06','Hà Nội','Nam','PT13305');
INSERT INTO sinhvien VALUES('ph06236','Nguyễn Lê Huy','2005-06-07','Hà Nội','Nam','PT13306');
INSERT INTO sinhvien VALUES('ph06237','Nguyễn An','2003-06-07','Hà Nội','Nam','PT13306');

create table ketqua(
masv varchar(10) ,
mamh varchar(10) ,
lanthi int ,
diemthi double,
primary key(masv,mamh,lanthi),
foreign key(masv) references sinhvien(masv),
foreign key(mamh) references monhoc(mamh)
);

INSERT INTO ketqua VALUES('ph06230','sof203',1,3);
INSERT INTO ketqua VALUES('ph06230','sof203',2,6);
INSERT INTO ketqua VALUES('ph06230','com2012',1,8);
INSERT INTO ketqua VALUES('ph06233','sof203',1,7);
INSERT INTO ketqua VALUES('ph06234','sof203',1,9);
select * from lop;

-- drop table ketqua,sinhvien,lop,monhoc


--c1: sử dụng bí danh cho bảng
select masv,hoten,tenlop
from sinhvien s,lop l
where s.malop=l.malop and quequan=N'Hà Nội'
--c2:sử dụng join
select masv,hoten,tenlop
from sinhvien inner join lop on sinhvien.malop=lop.malop
where quequan=N'Hà Nội'
--c2:sử dụng join : bí danh bảng
select masv,hoten,tenlop
from sinhvien s inner join lop l on s.malop=l.malop
where quequan=N'Hà Nội'


-- 1.đưa ra thông tin sinh viên
select * from sinhvien
-- 2.đưa ra thong tin bảng môn hoc
select * from monhoc
-- 3.đưa ra thông tin sinh viên: Masv,hoten
select masv,hoten
from sinhvien
-- 4đưa ra thông tin sinh viên: Masv,hoten của sv có quê la ha noi
select masv,hoten
from sinhvien
where quequan='Hà Nội'
-- dk:quequan: hanoi, gioitinh:Nam 
select masv,hoten
from sinhvien
where quequan='Hà Nội' and gioitinh='Nam'

-- 5dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv co que ha noi va gioitinh nam
select  masv,hoten
from sinhvien
where quequan='Hà Nội' and gioitinh='Nam'
limit 2
-- 6.dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv co que ha noi va gioitinh nam sắp xêp tăng dân theo hoten
 

-- 7.dưa ra thông tin sinh viên có họ nguyễn
select * from sinhvien
where hoten like 'Nguyễn%'

-- 8.đưa ra thông tin sv có ho dem la van
select * from sinhvien
where hoten like '%Văn%'
-- 9.đưa ra thông tin sv có tên la Duyên
select * from sinhvien
where hoten like '%Duyên'

-- 9a hiển thị thông tin: masv,hoten,tuoi của những sinh viên có tuổi >20 và họ nguyễn
select masv,hoten, year(now()) -year(ngaysinh)
from sinhvien
where year(now()) -year(ngaysinh)>20 and hoten like 'Nguyễn%'

-- 9b. hiển thị thông tin sinh viên ph06230,ph06231,ph06235
select * from sinhvien
where masv='ph06230' or masv='ph06231' 
      or masv='ph06232'
-- cách 2
select * from sinhvien
where masv in('ph06230','ph06231','ph06232')
-- 9c. hiển thị kết quả của sinh viên có điểm từ 7 đến 10
select * from ketqua
where diemthi between 7 and 10
-- 9d.Hiển thị ra những lớp không có sinhvien
select * from lop
where malop not in (
					select malop
                    from sinhvien
                    )
-- đưa ra tt sv của nhưng sv hà noi, gt: nam,sắp xếp giảm dần theo hoten
select * from sinhvien
where quequan='Hà Nội' and gioitinh='Nam'
order by hoten desc

-- 10.thống kê sô lương sv của từng lớp
select malop,count(masv) as soluong
from sinhvien
group by malop




-- 1.đưa ra thông tin sinh viên
select * from sinhvien
-- 2.đưa ra thong tin bảng môn hoc
select * from monhoc
-- 3.đưa ra thông tin sinh viên: Masv,hoten
select masv,hoten
from sinhvien

-- Hiển thị thông tin kết quả điểm của sv trong khoang tu 7 đến 10
select * from ketqua
where diemthi between 7 and 10
-- 4đưa ra thông tin 2 sinh viên đầu tiên: Masv,hoten của sv có quê la ha noi
select masv,hoten
from sinhvien
where quequan='Hà Nội'
limit 2
-- 5dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv co 
-- que ha noi va gioitinh nam
select masv,hoten,gioitinh
from sinhvien
where quequan like '%Hà Nội' and gioitinh='Nam'
limit 2
-- 6.dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv 
-- co que ha noi va gioitinh nam sắp xêp tăng dân theo hoten
select masv,hoten,gioitinh
from sinhvien
where quequan like '%Hà Nội' and gioitinh='Nam'
order by hoten ASC
limit 2

-- 7.dưa ra thông tin sinh viên có họ nguyễn
select * from sinhvien
where hoten like 'Nguyễn%'

-- 8.đưa ra thông tin sv có ho dem la van
select * from sinhvien
where hoten like '%Văn%'
-- 9.đưa ra thông tin sv có tên la Duyên
select * from sinhvien
where hoten like '%Duyên'
-- 9a hiển thị thông tin: masv,hoten,tuoi của những sinh viên 
-- có tuổi >20 và họ nguyễn
select masv,hoten,year(now())-year(ngaysinh) as tuoi
from sinhvien
where year(now())-year(ngaysinh)>20 and hoten like 'Nguyễn%'

-- 9b. hiển thị thông tin sinh viên ph06230,ph06231,ph06235
--  cách 1
select * from sinhvien
where masv='ph06230' or masv='ph06231' or masv='ph06232'
-- cách 2:
select * from sinhvien
where masv in ('ph06230','ph06231','ph06232')
-- 9c. hiển thị kết quả của sinh viên có điểm từ 7 đến 10
select * from ketqua
where diemthi between 7 and 10
-- 9d.Hiển thị ra những lớp không có sinhvien
where malop not in
                  (select malop 
                  from sinhvien)
-- 10.thống kê sô lương sv của từng lớp
select malop, count(masv) as soluong
from sinhvien
group by malop
-- 10.ĐƯa ra thông tin số lượng sv của từng lớp 
-- có số lượng >2
select malop, count(masv) as soluong
from sinhvien
group by malop
having count(masv)>2
-- 11. Đưa ra những môn học có số tiết>30 
select * from monhoc
where sotiet>30
-- 12.Đưa ra thông tin : masv,hoten,quequan của sv 
-- có giới tính là nam, tuổi>18 và tuổi <65
select masv,hoten,quequan
from sinhvien
where gioitinh='Nam' and year(now())-year(ngaysinh) between 18 and 65
-- hiển thị thông tin những môn học Lập trình ,có số tiết >40
select * from monhoc
where tenmh like 'Lập trình%' and sotiet>40

-- quanlydiem
-- lop(malop,tenlop)
-- monhoc(mamh,tenmh,sotiet)
-- sinhvien(masv,hoten,ngaysinh,quequan,gioitinh,malop)
-- ketqua(masv,mamh,lanthi,diemthi)

-- 1a.ĐƯA RA THÔNG TIN: MASV, HOTEN, TENLOP CỦA SV CÓ QUÊ HANOI
select masv,hoten,tenlop
from sinhvien inner join lop on sinhvien.malop=lop.malop
where quequan like '%Hà Nội'
-- sử dụng bí danh cho bảng
select masv,hoten,tenlop
from sinhvien s inner join lop l on s.malop=l.malop
where quequan like '%Hà Nội'
-- cách 2
select masv,hoten,tenlop
from sinhvien ,  lop 
where sinhvien.malop=lop.malop and lop.malop=sinhvien.malop


-- 1đưa ra thông tin masv, hoten, quequan

-- cua sv thuoc lop Ứng dụng phần mềm 1
select masv,hoten,quequan
from sinhvien  s inner join lop l on s.malop=l.malop
where tenlop='Ứng dụng phần mềm 1',
SELECT sinhvien.masv, sinhvien.hoten, sinhvien.quequan
FROM sinhvien
INNER JOIN lop ON sinhvien.malop = lop.malop
WHERE lop.tenlop = 'Ứng dụng phần mềm 1';
SELECT sinhvien.masv, sinhvien.hoten, sinhvien.quequan
FROM sinhvien
JOIN lop ON sinhvien.malop = lop.malop
WHERE lop.tenlop = 'Ứng dụng phần mềm 1';


-- cau2: dua ra thông tin:masv,hoten,tenmh,diemthi,lanthi
-- cua những sv có quê quan hà nôi
SELECT sinhvien.masv, sinhvien.hoten, monhoc.tenmh, ketqua.diemthi, ketqua.lanthi
FROM sinhvien
JOIN ketqua ON sinhvien.masv = ketqua.masv
JOIN monhoc ON ketqua.mamh = monhoc.mamh
WHERE sinhvien.quequan = 'Hà Nội';

select s.hoten,tenmh,diemthi,lanthi
from sinhvien s inner join ketqua k on s.masv=k.masv
inner join monhoc m on k.mamh=m.mamh
where quequan like'Hà Nội%';
-- câu 3: đưa ra thông tin masv, hoten học môn lt java3
SELECT sinhvien.masv, sinhvien.hoten
FROM sinhvien

JOIN ketqua ON sinhvien.masv = ketqua.masv
JOIN monhoc ON ketqua.mamh = monhoc.mamh
WHERE monhoc.tenmh = 'lập trình java3';
select s.masv,s.hoten
from sinhvien s
join ketqua k on s.masv=k.masv
join monhoc m on m.mamh=k.mamh
where tenmh='lập trình java3';
-- câu 4a:thống kê số lượng sv của mỗi lớp:malop,tenlop,soluong
SELECT lop.malop, lop.tenlop, COUNT(sinhvien.masv) AS soluong
FROM lop
LEFT JOIN sinhvien ON lop.malop = sinhvien.malop
GROUP BY lop.malop, lop.tenlop;
select l.malop,tenlop,count(masv) as soluong
from lop l left join sinhvien s on s.malop=l.malop
group by l.malop,tenlop;
-- câu 4b:thống kê số lượng sv của mỗi lớp:malop,tenlop,soluong
-- co so luong >3
SELECT l.malop, l.tenlop, COUNT(sinhvien.masv) AS soluong
FROM lop l LEFT JOIN sinhvien ON l.malop = sinhvien.malop
GROUP BY l.malop, l.tenlop
HAVING COUNT(sinhvien.masv) > 3;

-- loại bỏ đi những nhóm k thỏa mãn đk
-- câu 5:thống kê số lượng sv của mỗi lớp:malop,tenlop,soluong
-- có sô lượng lớn nhất
SELECT lop.malop, lop.tenlop, COUNT(sinhvien.masv) AS soluong
FROM lop
 JOIN sinhvien ON lop.malop = sinhvien.malop
GROUP BY lop.malop, lop.tenlop
ORDER BY soluong DESC
LIMIT 1;
select l.malop,tenlop,count(masv) as soluong
from lop l left join sinhvien s on s.malop=l.malop
group by l.malop,tenlop
having count(masv)>=all(select count(masv) from sinhvien group by malop);
-- c6 đưa ra thông tin những sinh viên có cùng ngay sinh
SELECT a.masv,a.hoten
FROM sinhvien a, sinhvien b
WHERE a.masv <> b.masv AND a.ngaysinh = b.ngaysinh

-- câu 7: Đưa ra thông tin: masv, hoten, tuổi,teenmon, điemthi của những sinh viên có Họ nguyễn và tuổi <20;
SELECT sinhvien.masv, sinhvien.hoten, YEAR(CURDATE()) - YEAR(sinhvien.ngaysinh) AS tuoi, monhoc.tenmh, ketqua.diemthi
FROM sinhvien
JOIN ketqua ON sinhvien.masv = ketqua.masv
JOIN monhoc ON ketqua.mamh = monhoc.mamh
WHERE sinhvien.hoten LIKE 'Nguyễn%' AND YEAR(CURDATE()) - YEAR(sinhvien.ngaysinh) < 20;

select s.masv,hoten,year(now())-year(ngaysinh) as tuổi,tenmh,diemthi
from sinhvien s inner join ketqua k on s.masv=k.masv
inner join monhoc m on m.mamh=k.mamh
where hoten like 'Nguyễn%' and year(now())-year(ngaysinh)>20;
-- câu 8. Đưa ra thông tin: masv, hoten, điểm thi của những sinh viên có điểm thi trong khoảng 7 đến 10 sắp xếp giảm dần theo điểm thi
SELECT sinhvien.masv, sinhvien.hoten, ketqua.diemthi
FROM sinhvien
JOIN ketqua ON sinhvien.masv = ketqua.masv
WHERE ketqua.diemthi BETWEEN 7 AND 10
ORDER BY ketqua.diemthi DESC;
-- câu 9: đưa ra thông tin: masv, hoten, tuổi của sinh viên học môn com108, com107,com2012
SELECT sinhvien.masv, sinhvien.hoten, YEAR(CURDATE()) - YEAR(sinhvien.ngaysinh) AS tuoi
FROM sinhvien
JOIN ketqua ON sinhvien.masv = ketqua.masv
JOIN monhoc ON ketqua.mamh = monhoc.mamh
WHERE monhoc.tenmh IN ('com2032');
-- cau 10: dưa ra thông tin những lớp không có sinh viên
SELECT lop.malop, lop.tenlop
FROM lop
LEFT JOIN sinhvien ON lop.malop = sinhvien.malop
WHERE sinhvien.masv IS NULL;
select * from lop
where malop not in (select malop from sinhvien);
-- cau 11: đưa ra thông tin masv, hoten có tenlop:ung dung 1
SELECT sinhvien.masv, sinhvien.hoten
FROM sinhvien
JOIN lop ON sinhvien.malop = lop.malop
WHERE lop.tenlop like 'Ứng dụng phần mềm 1';
-- câu 12: đưa ra thông tin: masv, hoten, tuổi của sinhvien có điểm thi <8 
-- môn có tên môn cơ sở dữ liệu
SELECT sinhvien.masv, sinhvien.hoten, YEAR(CURDATE()) - YEAR(sinhvien.ngaysinh) AS tuoi
FROM sinhvien
JOIN ketqua ON sinhvien.masv = ketqua.masv
JOIN monhoc ON ketqua.mamh = monhoc.mamh
WHERE monhoc.tenmh = 'Cơ sở dữ liệu' AND ketqua.diemthi < 10;

-- update
-- 1: sửa đổi quequan của masv ph06230 thành Huế
-- 2: sửa đổi quequan của masv ph06230 thành Huế
-- gioitinh thành nam
-- 3sưả số tiết môn cơ sở dữ liệu thành 60
-- 4.thay đổi malop của Nguyen Huy thành It18301
-- 5.	Cập nhật thông tin của sv có mã ph06238: 
-- quê quán thành Hà Tĩnh, giới tình:nữ
-- 6.	Cập nhật lại môn học Tin Văn Phòng 
-- thành Cơ sở dữ liệu
UPDATE monhoc SET tenmh = 'Cơ sở dữ liệu' WHERE tenmh = 'Tin Văn Phòng';
-- 7.cập nhật sotiet cua của môn học có tên
-- "Tri Tue Nhan Tao" lai 30 tiet
UPDATE monhoc SET sotiet = 30 WHERE tenmh = 'Tri Tue Nhan Tao';
-- 8.cập nhật sinhvien có tên 'Nguyễn Thị Lam' 
-- thành 'Nguyen Thanh Son' và giới tính thành 'Nam'
UPDATE sinhvien SET hoten="Nguyễn Thanh Sơn" ,gioitinh='Nam' where hoten="Nguyễn Thị Mừng";
-- 9.Chuyen sinh vien 'Lê Thị Lan Anh' sang lớp It18302
UPDATE sinhvien SET malop = 'PT13304' WHERE hoten = 'Nguyễn Thị Mỹ Duyên';

-- delete from : xóa dữ liệu trong bảng
-- 1.Xóa thông tin kết quả học tập của sv có mã ph1234
DELETE FROM ketqua WHERE masv = 'ph1234' 
on delete cascade on update cascade;
-- 2. Xóa những lớp không có sinhvien
DELETE FROM lop WHERE malop NOT IN (SELECT malop FROM sinhvien);

-- 3.xóa môn học không có sinhvien hoc
DELETE FROM monhoc WHERE mamh NOT IN (SELECT mamh FROM ketqua);

-- 4.xóa kết quả của sinhvien có hoten là Nguyễn Văn Huy
DELETE FROM ketqua WHERE masv IN (SELECT masv FROM sinhvien WHERE hoten = 'Nguyễn Văn Huy');
-- on delete cascade on update cascade

-- 5.xóa sinhvien học môn có tên monhoc là Cơ sỡ dữ liệu
-- tang 10% số tiết của các môn học

-- tăng 15% số tiết của môn cơ sở dữ liệu

-- tạo khung nhìn -- 
create view DSSV
as 
select masv,hoten,year(now())-year(ngaysinh)as tuoi  from sinhvien where quequan='Hà Nội';
create view DSSV1(ma,hotensv,tuoisv)
as 
select masv,hoten,year(now())-year(ngaysinh)as tuoi  from sinhvien where quequan='Hà Nội';
create view dsdiem
as
select sinhvien.masv,hoten,year(now())-year(ngaysinh)as tuoi,tenlop,diemthi from sinhvien,lop,ketqua where quequan='Hà Nội';
create view dsdiem1
as
select s.masv,hoten,year(now())-year(ngaysinh)as tuoi,tenlop,diemthi 
from lop l inner join sinhvien s on l.malop=s.malop
inner join ketqua k on k.masv=s.masv
where quequan='Hà Nội';
select * from dsdiem;

-- tạo khung nhìn có tên số lượng lớp,đếm số lượng sinh viên của mỗi lớp ma lop,ten lop,so luong lop
create view soluonglop AS
select lop.malop, lop.tenlop, COUNT(sinhvien.masv) as soluongsinhvien
from lop
left join  sinhvien on lop.malop = sinhvien.malop
group by lop.malop, lop.tenlop;
select* from soluonglop;
-- cập nhật bổ sung xóa dữ liệu qua khung nhìn.viết khung nhìn hiển thị :masv,hoten,malop
CREATE VIEW thongTinSV AS
SELECT masv, hoten, malop
FROM sinhvien;
-- chèn dữ liệu
insert into thongTinSV values('s2','kk','PT13302');
-- update thông qua khung nhing
update thongTinSV 
set malop='PT13302'
where masv='s2';
-- xóa thông qua khung nhìn
delete from thongTinSV 
where masv='s2';
-- tạo khung nhìn dssv2 gồm masv,hoten,tenlop,tenmon,diemthi của sv có điểm trong 7-10
create view dssv2 as
select sv.masv, sv.hoten, lop.tenlop, mon.tenmh, ketqua.diemthi
from sinhvien sv
inner join lop on sv.malop = lop.malop
inner join ketqua on sv.masv = ketqua.masv
inner join monhoc mon on ketqua.mamh = mon.mamh
where  ketqua.diemthi between 7 and 10;
select  s.masv,hoten,tenlop,tenmh,diemthi
from lop l join sinhvien s on s.malop=l.malop
join ketqua k on k.masv=s.masv
join monhoc m on k.mamh=m.mamh
where diemthi between 7 and 10;
-- Tạo thủ tục
  DELIMITER $$
CREATE PROCEDURE tên_thủ_tục ([danh_sách_tham_số])
BEGIN
   /*Xu ly*/
END; $$
DELIMITER ;

Trong đó:
Dòng đầu tiên DELIMITER $$ dùng để phân cách bộ nhớ lưu trữ thủ tục Cache và mở ra một ô lưu trữ mới. Đây là cú pháp nên bắt buộc bạn phải nhập như vậy
Dòng CREATE PROCEDURE procedureName() dùng để khai báo tạo một Procedure mới, trong đó procedureName chính là tên thủ tục còn hai từ đầu là từ khóa.
BEGIN và END; $$ dùng để khai báo bắt đầu của Procedure và kết thúc Procedure
Cuối cùng là đóng lại ô lưu trữ DELIMITER ;
-- GỌI THỦ TỤC
call tên_thủ_tục [(danh_sách_các_đối_số)]
-- XÓA THỦ TỤC
DROP PROCEDURE tên_thủ_tục
DELIMITER //
 DELIMITER $$
CREATE PROCEDURE GetAllSinhVien()
BEGIN
    SELECT * FROM sinhvien;
END; $$
call  GetAllSinhVien()
drop procedure  if exists GetAllSinhVien
DELIMITER ;
DELIMITER //
 DELIMITER $$
CREATE PROCEDURE TimSinhVienCungQueQuan(IN que VARCHAR(255))
BEGIN
    SELECT * FROM sinhvien WHERE quequan = que;
END $$;


 
 
 DELIMITER $$

create procedure  TimSinhVienByQueQuanVaGioiTinh(in que varchar(100), in gt varchar(10))
begin
    select * from sinhvien where quequan = que and gioitinh = gt;
end $$ 
DELIMITER //
 DELIMITER $$
CREATE PROCEDURE GetThongTinByMaMH(IN mamon VARCHAR(255))
BEGIN
    SELECT sv.masv, sv.hoten, lop.tenlop, ketqua.diemthi
    FROM sinhvien sv
    JOIN lop ON sv.malop = lop.malop
    JOIN ketqua ON sv.masv = ketqua.masv
    WHERE ketqua.mamh = mamon;
END  $$ 

DELIMITER ;
drop database quanlydiem;
create database quanlydiem;

create table lop(
malop varchar(10) primary key,
tenlop varchar(100)
);

insert into   lop values('PT13301','Ứng dụng phần mềm 1');
insert into lop values('PT13302','Ứng dụng phần mềm 2');
insert into lop values('PT13303','Ứng dụng phần mềm 3');
insert into lop values('PT13304','Ứng dụng phần mềm 4');
insert into lop values('PT13305','Ứng dụng phần mềm 5');
insert into lop values('PT13306','Ứng dụng phần mềm 6');
insert into lop values('PT13307','Ứng dụng phần mềm 6');
insert into lop values('PT13308','Ứng dụng phần mềm 7');

create table monhoc(
mamh varchar(10) primary key,
tenmh nvarchar(100),
sotiet int
);

insert into monhoc values('mob1013','lập trình java1',36);
insert into monhoc values('mob1022','lập trình java2',36);
insert into monhoc values('sof203','lập trình java3',36);
insert into monhoc values('com2012','Cơ sở dữ liệu',36);
insert into monhoc values('com2032','Hệ quản trị CSDL',30);
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
Insert into sinhvien values('ph06230','Trần Lê Huy','2000-06-07','Hà Nội','Nam','PT13302');
Insert into sinhvien values('ph06231','Nguyễn Thị Mỹ Duyên','2001-07-07','Hà Nội','Nữ','PT13302');
Insert into sinhvien values('ph06232','Võ Tá Nhật Anh','2003-09-07','Hà Tĩnh','Nam','PT13302');
Insert into sinhvien values('ph06233','Trần Thị Thùy Trang','2000-06-03','Hải Phòng','Nữ','PT13302');
Insert into sinhvien values('ph06234','Nguyễn Thị Mừng','2000-06-02','Hà Nội','Nữ','PT13305');
Insert into sinhvien values('ph06235','Nguyễn Xuân Trường','2000-06-06','Hà Nội','Nam','PT13305');
Insert into sinhvien values('ph06236','Nguyễn Lê Huy','2005-06-07','Hà Nội','Nam','PT13306');
Insert into sinhvien values('ph06237','Nguyễn An','2003-06-07','Hà Nội','Nam','PT13306');

create table ketqua(
masv varchar(10) ,
mamh varchar(10) ,
lanthi int ,
diemthi double,
primary key(masv,mamh,lanthi),
foreign key(masv) references sinhvien(masv),
foreign key(mamh) references monhoc(mamh)
);
insert into ketqua values('ph06230','sof203',1,3);
insert into ketqua values('ph06230','sof203',2,6);
insert into ketqua values('ph06230','com2012',1,8);
insert into ketqua values('ph06233','sof203',1,7);
insert into ketqua values('ph06234','sof203',1,9);
select * from lop;

-- 1.đưa ra thông tin sinh viên
select * from sinhvien;

-- 2.đưa ra thong tin bảng môn hoc

-- 3.đưa ra thông tin sinh viên: Masv,hoten
select masv,hoten from sinhvien;

-- 4đưa ra thông tin sinh viên: Masv,hoten của sv có quê la ha noi
select masv,hoten from sinhvien where quequan='Hà Nội';

-- 5dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv co que ha noi va gioitinh nam
select masv,hoten,Gioitinh from sinhvien where quequan='Hà Nội' and Gioitinh='Nam' limit 2;
-- 6.dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv co que ha noi va gioitinh nam sắp xêp tăng dân theo hoten
 select masv,hoten,Gioitinh from sinhvien where quequan='Hà Nội' and Gioitinh='Nam'   order by hoten ASC limit 2 ;

-- 7.dưa ra thông tin sinh viên có họ nguyễn
select * from sinhvien where hoten like 'Nguyễn%';

-- 8.đưa ra thông tin sv có ho dem la van
select * from sinhvien where hoten like'%Văn%';

-- 9.đưa ra thông tin sv có tên la Duyên
select * from sinhvien where hoten like'%Duyên';
-- 9a hiển thị thông tin: masv,hoten,tuoi của những sinh viên có tuổi >20 và họ nguyễn

select masv,hoten, year(now()) -year(ngaysinh) as tuoi
from sinhvien
where year(now()) -year(ngaysinh)  >20 and hoten like 'Nguyễn%';


-- 9b. hiển thị thông tin sinh viên ph06230,ph06231,ph06235
select * from sinhvien where masv in('ph06230','ph06231','ph06235');
-- 9c. hiển thị kết quả của sinh viên có điểm từ 7 đến 10
select * from ketqua where diemthi between 7 and 10;
-- 9d.Hiển thị ra những lớp không có sinhvien
select malop from lop where malop not in (select malop from sinhvien);
select lop.malop,lop.tenlop from lop left join sinhvien on lop.malop=sinhvien.malop where sinhvien.malop is null;
-- 10.thống kê sô lương sv của từng lớp
select malop,count(masv) as soluong
from sinhvien
group by malop
create database quanlydiem

create table lop(
malop varchar(10) primary key,
tenlop varchar(100)
);

insert into LOP values('PT13301','Ứng dụng phần mềm 1');
insert into LOP values('PT13302','Ứng dụng phần mềm 2');
insert into LOP values('PT13303','Ứng dụng phần mềm 3');
insert into LOP values('PT13304','Ứng dụng phần mềm 4');
insert into LOP values('PT13305','Ứng dụng phần mềm 5');
insert into LOP values('PT13306','Ứng dụng phần mềm 6');
insert into LOP values('PT13307','Ứng dụng phần mềm 6');
insert into LOP values('PT13308','Ứng dụng phần mềm 7');
insert into LOP values('PT13309','Ứng dụng phần mềm 9');
create table monhoc(
mamh varchar(10) primary key,
tenmh nvarchar(100),
sotiet int
);

insert into MONHOC values('mob1013','lập trình java1',36);
insert into MONHOC values('mob1022','lập trình java2',36);
insert into MONHOC values('sof203','lập trình java3',36);
insert into MONHOC values('com2012','Cơ sở dữ liệu',36);
insert into MONHOC values('com2032','Hệ quản trị CSDL',30);
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
Insert into SINHVIEN values('ph06230','Trần Lê Huy','2000-06-07','Hà Nội','Nam','PT13302');
Insert into SINHVIEN values('ph06231','Nguyễn Thị Mỹ Duyên','2001-07-07','Hà Nội','Nữ','PT13302');
Insert into SINHVIEN values('ph06232','Võ Tá Nhật Anh','2003-09-07','Hà Tĩnh','Nam','PT13302');
Insert into SINHVIEN values('ph06233','Trần Thị Thùy Trang','2000-06-03','Hải Phòng','Nữ','PT13302');
Insert into SINHVIEN values('ph06234','Nguyễn Thị Mừng','2000-06-02','Hà Nội','Nữ','PT13305');
Insert into SINHVIEN values('ph06235','Nguyễn Xuân Trường','2000-06-06','Hà Nội','Nam','PT13305');
Insert into SINHVIEN values('ph06236','Nguyễn Lê Huy','2005-06-07','Hà Nội','Nam','PT13306');
Insert into SINHVIEN values('ph06237','Nguyễn An','2003-06-07','Hà Nội','Nam','PT13306');
Insert into SINHVIEN values('ph06238','Nguyễn An','2003-06-07','Hà Nội','Nam','PT13301');
create table ketqua(
masv varchar(10) ,
mamh varchar(10) ,
lanthi int ,
diemthi double,
primary key(masv,mamh,lanthi),
foreign key(masv) references sinhvien(masv),
foreign key(mamh) references monhoc(mamh)
);
insert into KETQUA values('ph06230','sof203',1,3);
insert into KETQUA values('ph06230','sof203',2,6);
insert into KETQUA values('ph06230','com2012',1,8);
insert into KETQUA values('ph06233','sof203',1,7);
insert into KETQUA values('ph06234','sof203',1,9);
select * from lop

-- drop table ketqua,sinhvien,lop,monhoc


--c1: sử dụng bí danh cho bảng
select masv,hoten,tenlop
from sinhvien s,lop l
where s.malop=l.malop and quequan=N'Hà Nội'
--c2:sử dụng join
select masv,hoten,tenlop
from sinhvien inner join lop on sinhvien.malop=lop.malop
where quequan=N'Hà Nội'
--c2:sử dụng join : bí danh bảng
select masv,hoten,tenlop
from sinhvien s inner join lop l on s.malop=l.malop
where quequan=N'Hà Nội'


-- 1.đưa ra thông tin sinh viên
select * from sinhvien
-- 2.đưa ra thong tin bảng môn hoc
select * from monhoc
-- 3.đưa ra thông tin sinh viên: Masv,hoten
select masv,hoten
from sinhvien
-- 4đưa ra thông tin sinh viên: Masv,hoten của sv có quê la ha noi
select masv,hoten
from sinhvien
where quequan='Hà Nội'
-- dk:quequan: hanoi, gioitinh:Nam 
select masv,hoten
from sinhvien
where quequan='Hà Nội' and gioitinh='Nam'

-- 5dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv co que ha noi va gioitinh nam
select  masv,hoten
from sinhvien
where quequan='Hà Nội' and gioitinh='Nam'
limit 2
-- 6.dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv co que ha noi va gioitinh nam sắp xêp tăng dân theo hoten
 

-- 7.dưa ra thông tin sinh viên có họ nguyễn
select * from sinhvien
where hoten like 'Nguyễn%'

-- 8.đưa ra thông tin sv có ho dem la van
select * from sinhvien
where hoten like '%Văn%'
-- 9.đưa ra thông tin sv có tên la Duyên
select * from sinhvien
where hoten like '%Duyên'

-- 9a hiển thị thông tin: masv,hoten,tuoi của những sinh viên có tuổi >20 và họ nguyễn
select masv,hoten, year(now()) -year(ngaysinh)
from sinhvien
where year(now()) -year(ngaysinh)>20 and hoten like 'Nguyễn%'

-- 9b. hiển thị thông tin sinh viên ph06230,ph06231,ph06235
select * from sinhvien
where masv='ph06230' or masv='ph06231' 
      or masv='ph06232'
-- cách 2
select * from sinhvien
where masv in('ph06230','ph06231','ph06232')
-- 9c. hiển thị kết quả của sinh viên có điểm từ 7 đến 10
select * from ketqua
where diemthi between 7 and 10
-- 9d.Hiển thị ra những lớp không có sinhvien
select * from lop
where malop not in (
					select malop
                    from sinhvien
                    )
-- đưa ra tt sv của nhưng sv hà noi, gt: nam,sắp xếp giảm dần theo hoten
select * from sinhvien
where quequan='Hà Nội' and gioitinh='Nam'
order by hoten desc

-- 10.thống kê sô lương sv của từng lớp
select malop,count(masv) as soluong
from sinhvien
group by malop




-- 1.đưa ra thông tin sinh viên
select * from sinhvien
-- 2.đưa ra thong tin bảng môn hoc
select * from monhoc
-- 3.đưa ra thông tin sinh viên: Masv,hoten
select masv,hoten
from sinhvien

-- Hiển thị thông tin kết quả điểm của sv trong khoang tu 7 đến 10
select * from ketqua
where diemthi between 7 and 10
-- 4đưa ra thông tin 2 sinh viên đầu tiên: Masv,hoten của sv có quê la ha noi
select masv,hoten
from sinhvien
where quequan='Hà Nội'
limit 2
-- 5dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv co 
-- que ha noi va gioitinh nam
select masv,hoten,gioitinh
from sinhvien
where quequan like '%Hà Nội' and gioitinh='Nam'
limit 2
-- 6.dua ra thong tin 2 sv dau tien: masv, Hoten,gt cua sv 
-- co que ha noi va gioitinh nam sắp xêp tăng dân theo hoten
select masv,hoten,gioitinh
from sinhvien
where quequan like '%Hà Nội' and gioitinh='Nam'
order by hoten ASC
limit 2

-- 7.dưa ra thông tin sinh viên có họ nguyễn
select * from sinhvien
where hoten like 'Nguyễn%'

-- 8.đưa ra thông tin sv có ho dem la van
select * from sinhvien
where hoten like '%Văn%'
-- 9.đưa ra thông tin sv có tên la Duyên
select * from sinhvien
where hoten like '%Duyên'
-- 9a hiển thị thông tin: masv,hoten,tuoi của những sinh viên 
-- có tuổi >20 và họ nguyễn
select masv,hoten,year(now())-year(ngaysinh) as tuoi
from sinhvien
where year(now())-year(ngaysinh)>20 and hoten like 'Nguyễn%'

-- 9b. hiển thị thông tin sinh viên ph06230,ph06231,ph06235
--  cách 1
select * from sinhvien
where masv='ph06230' or masv='ph06231' or masv='ph06232'
-- cách 2:
select * from sinhvien
where masv in ('ph06230','ph06231','ph06232')
-- 9c. hiển thị kết quả của sinh viên có điểm từ 7 đến 10
select * from ketqua
where diemthi between 7 and 10
-- 9d.Hiển thị ra những lớp không có sinhvien
where malop not in
                  (select malop 
                  from sinhvien)
-- 10.thống kê sô lương sv của từng lớp
select malop, count(masv) as soluong
from sinhvien
group by malop
-- 10.ĐƯa ra thông tin số lượng sv của từng lớp 
-- có số lượng >2

select malop,count(masv) as soluong from sinhvien group by malop having count(masv)>2;




select malop, count(masv) as soluong
from sinhvien
group by malop
having count(masv)>2
-- 11. Đưa ra những môn học có số tiết>30 
select * from monhoc where sotiet>30;




select * from monhoc
where sotiet>30
-- 12.Đưa ra thông tin : masv,hoten,quequan của sv 
-- có giới tính là nam, tuổi>18 và tuổi <65

select masv,hoten,quequan,year(now())-year(ngaysinh) as tuoi from sinhvien where Gioitinh='Nam' and year(now())-year(ngaysinh) between 18 and 65;





select masv,hoten,quequan
from sinhvien
where gioitinh='Nam' and year(now())-year(ngaysinh) between 18 and 65
-- hiển thị thông tin những môn học Lập trình ,có số tiết >40

drop database quanlydiem;












select * from monhoc

where tenmh like 'Lập trình%' and sotiet>40;
create database quanlydiem;
create table lop(
malop varchar(10) primary key,
tenlop varchar(100)
);

insert into lop values('PT13301','Ứng dụng phần mềm 1');
insert into lop values('PT13302','Ứng dụng phần mềm 2');
insert into lop values('PT13303','Ứng dụng phần mềm 3');
insert into lop values('PT13304','Ứng dụng phần mềm 4');
insert into lop values('PT13305','Ứng dụng phần mềm 5');
insert into lop values('PT13306','Ứng dụng phần mềm 6');
insert into lop values('PT13307','Ứng dụng phần mềm 6');
insert into lop values('PT13308','Ứng dụng phần mềm 7');
insert into lop values('PT13309','Ứng dụng phần mềm 9');
create table monhoc(
mamh varchar(10) primary key,
tenmh nvarchar(100),
sotiet int
);

insert into monhoc values('mob1013','lập trình java1',36);
insert into monhoc values('mob1022','lập trình java2',36);
insert into monhoc values('sof203','lập trình java3',36);
insert into monhoc values('com2012','Cơ sở dữ liệu',36);
insert into monhoc values('com2032','Hệ quản trị CSDL',30);
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
Insert into sinhvien values('ph06230','Trần Lê Huy','2000-06-07','Hà Nội','Nam','PT13302');
Insert into sinhvien values('ph06231','Nguyễn Thị Mỹ Duyên','2001-07-07','Hà Nội','Nữ','PT13302');
Insert into sinhvien values('ph06232','Võ Tá Nhật Anh','2003-09-07','Hà Tĩnh','Nam','PT13302');
Insert into sinhvien values('ph06233','Trần Thị Thùy Trang','2000-06-03','Hải Phòng','Nữ','PT13302');
Insert into sinhvien values('ph06234','Nguyễn Thị Mừng','2000-06-02','Hà Nội','Nữ','PT13305');
Insert into sinhvien values('ph06235','Nguyễn Xuân Trường','2000-06-06','Hà Nội','Nam','PT13305');
Insert into sinhvien values('ph06236','Nguyễn Lê Huy','2005-06-07','Hà Nội','Nam','PT13306');
Insert into sinhvien values('ph06237','Nguyễn An','2003-06-07','Hà Nội','Nam','PT13306');
Insert into sinhvien values('ph06238','Nguyễn An','2003-06-07','Hà Nội','Nam','PT13301');
create table ketqua(
masv varchar(10) ,
mamh varchar(10) ,
lanthi int ,
diemthi double,
primary key(masv,mamh,lanthi),
foreign key(masv) references sinhvien(masv),
foreign key(mamh) references monhoc(mamh)
);
insert into ketqua values('ph06230','sof203',1,3);
insert into ketqua values('ph06230','sof203',2,6);
insert into ketqua values('ph06230','com2012',1,8);
insert into ketqua values('ph06233','sof203',1,7);
insert into ketqua values('ph06234','sof203',1,9);
-- quanlydiem
-- lop(malop,tenlop)
-- monhoc(mamh,tenmh,sotiet)
-- sinhvien(masv,hoten,ngaysinh,quequan,gioitinh,malop)
-- ketqua(masv,mamh,lanthi,diemthi)

-- 1a.ĐƯA RA THÔNG TIN: MASV, HOTEN, TENLOP CỦA SV CÓ QUÊ HANOI

select sinhvien.masv,sinhvien.hoten,lop.tenlop,sinhvien.quequan from sinhvien inner join lop on sinhvien.malop=lop.malop where  quequan='Hà Nội';
-- 1đưa ra thông tin masv, hoten, quequan

-- cua sv thuoc lop Ứng dụng phần mềm 1
select sinhvien.masv,sinhvien.hoten,sinhvien.quequan,lop.tenlop from  sinhvien inner join lop on sinhvien.malop=lop.malop where tenlop='Ứng dụng phần mềm 1';

-- cau2: dua ra thông tin:masv,hoten,tenmh,diemthi,lanthi
-- cua những sv có quê quan hà nôi
select sinhvien.masv,sinhvien.hoten,monhoc.tenmh,ketqua.diemthi,ketqua.lanthi 
from ketqua
inner join sinhvien on sinhvien.masv=ketqua.masv
inner join monhoc on monhoc.mamh=ketqua.mamh
where quequan='Hà Nội';
select s.hoten,tenmh,diemthi,lanthi
from sinhvien s inner join ketqua k on s.masv=k.masv
inner join monhoc m on k.mamh=m.mamh
where quequan like'Hà Nội%';
-- câu 3: đưa ra thông tin masv, hoten học môn lt java3
select sinhvien.masv,sinhvien.hoten,monhoc.tenmh 
from sinhvien inner join ketqua on sinhvien.masv=ketqua.masv
inner join monhoc on ketqua.mamh=monhoc.mamh where tenmh='lập trình java3';
-- câu 4a:thống kê số lượng sv của mỗi lớp:malop,tenlop,soluong
select lop.malop,lop.tenlop,count(sinhvien.masv) as sl from lop left join sinhvien on lop.malop=sinhvien.malop group by lop.malop,lop.tenlop;
-- câu 4b:thống kê số lượng sv của mỗi lớp:malop,tenlop,soluong
-- co so luong >30
select lop.malop,lop.tenlop,count(sinhvien.masv) as sl from lop left join sinhvien on lop.malop=sinhvien.malop group by lop.malop,lop.tenlop having count(sinhvien.masv)>3;

-- câu 5:thống kê số lượng sv của mỗi lớp:malop,tenlop,soluong
-- có sô lượng lớn nhất
select lop.malop,lop.tenlop,count(sinhvien.masv) as sl from lop left join sinhvien on lop.malop=sinhvien.malop group by lop.malop,lop.tenlop order by sl DESC limit 1;

-- c6 đưa ra thông tin những sinh viên có cùng ngay sinh
SELECT a.masv,a.hoten,a.ngaysinh
FROM sinhvien a, sinhvien b
WHERE a.masv <> b.masv AND a.ngaysinh = b.ngaysinh;

-- câu 7: Đưa ra thông tin: masv, hoten, tuổi,teenmon, điemthi của những sinh viên có Họ nguyễn và tuổi <20
select sinhvien.masv,sinhvien.hoten,year(now())-year(ngaysinh) as tuoi ,monhoc.tenmh,ketqua.diemthi 
from sinhvien inner join ketqua on sinhvien.masv=ketqua.masv
inner join monhoc on ketqua.mamh=monhoc.mamh where sinhvien.hoten like 'Nguyễn%' and year(now())-year(ngaysinh) < 20;
-- câu 8. Đưa ra thông tin: masv, hoten, điểm thi của những sinh viên có điểm thi trong khoảng 7 đến 10 sắp xếp giảm dần theo điểm thi
select sinhvien.masv,sinhvien.hoten,ketqua.diemthi from sinhvien inner join ketqua on sinhvien.masv=ketqua.masv
where diemthi between 7 and 10
order by diemthi DESC;
-- câu 9: đưa ra thông tin: masv, hoten, tổi của sinh viên học môn com108, com107,com2012
select sinhvien.masv,sinhvien.hoten,year(now())-year(ngaysinh) as tuoi
 from sinhvien join ketqua on sinhvien.masv=ketqua.masv 
 join monhoc on ketqua.mamh=monhoc.mamh
 where monhoc.mamh in ('mob1013','mob1022');
 SELECT sinhvien.masv, sinhvien.hoten, YEAR(CURDATE()) - YEAR(sinhvien.ngaysinh) AS tuoi
FROM sinhvien
JOIN ketqua ON sinhvien.masv = ketqua.masv
JOIN monhoc ON ketqua.mamh = monhoc.mamh
WHERE monhoc.tenmh IN ('com2032');

-- cau 10: dưa ra thông tin những lớp không có sinh viên
select lop.malop,lop.tenlop from lop left join sinhvien on lop.malop=sinhvien.malop where sinhvien.masv is null;
-- cau 11: đưa ra thông tin masv, hoten có tenlop:ung dung 1
select sinhvien.masv ,sinhvien.hoten ,lop.tenlop from sinhvien join lop on lop.malop=sinhvien.malop where tenlop='Ứng dụng phần mềm 1';
-- câu 12: đưa ra thông tin: masv, hoten, tuổi của sinhvien có điểm thi <8 
-- môn có tên môn cơ sở dữ liệu
select sinhvien.masv,sinhvien.hoten,year(now())-year(ngaysinh) as tuoi,ketqua.diemthi from sinhvien join ketqua on sinhvien.masv=ketqua.masv where diemthi<8;

-- update
-- 1: sửa đổi quequan của masv ph06230 thành Huế
update sinhvien set quequan='Huế' where masv='ph06230';
-- 2: sửa đổi quequan của masv ph06230 thành Huế
-- gioitinh thành nam
update sinhvien set quequan='Huế' where masv='ph06230' and gioitinh ='Nam';
-- 3sưả số tiết môn cơ sở dữ liệu thành 60

-- 4.thay đổi malop của Nguyen Huy thành It18301
-- 5.	Cập nhật thông tin của sv có mã ph06238: 
-- quê quán thành Hà Tĩnh, giới tình:nữ
-- 6.	Cập nhật lại môn học Tin Văn Phòng 
-- thành Cơ sở dữ liệu
-- 7.cập nhật sotiet cua của môn học có tên
-- "Tri Tue Nhan Tao" lai 30 tiet
-- 8.cập nhật sinhvien có tên 'Nguyễn Thị Lam' 
-- thành 'Nguyen Thanh Son' và giới tính thành 'Nam'
-- 9.Chuyen sinh vien 'Lê Thị Lan Anh' sang lớp It18302

-- delete from : xóa dữ liệu trong bảng
-- 1.Xóa thông tin kết quả học tập của sv có mã ph1234
-- 2. Xóa những lớp không có sinhvien
delete from lop where malop not in(select malop from sinhvien );

-- 3.xóa môn học không có sinhvien hoc
delete from monhoc where mamh not in(select mamh from ketqua);
DELETE FROM monhoc WHERE mamh NOT IN (SELECT mamh FROM ketqua);
-- 4.xóa kết quả của sinhvien có hoten là Nguyễn Văn Huy
delete from ketqua where masv=(select masv from sinhvien where hoten='Nguyễn Văn Huy');

-- 5.xóa sinhvien học môn có tên monhoc là Cơ sỡ dữ liệu
DELETE ketqua
FROM ketqua
JOIN monhoc ON ketqua.mamh = monhoc.mamh
WHERE monhoc.tenmh = 'Cơ sở dữ liệu';-- tang 10% số tiết của các môn học

-- tăng 15% số tiết của môn cơ sở dữ liệu
delimiter $$;
DELIMITER $$
CREATE PROCEDURE GetAllSinhVien()
BEGIN 
select* from sinhvien ;
END; $$
DELIMITER $$
CREATE PROCEDURE TimSinhVienCungQueQuan(IN que VARCHAR(255))
BEGIN
    SELECT * FROM sinhvien WHERE quequan = que;
END; $$
DELIMITER $$
CREATE PROCEDURE TimSinhVienCungQueGioiTinh(IN que varchar(100) ,in gts varchar(100))
BEGIN 
select* from sinhvien where quequan=que and Gioitinh=gts;
END;$$
drop procedure TimSinhVienCungQueGioiTinh;