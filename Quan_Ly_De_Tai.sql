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
-- SELECT SINHVIEN.Masv, SINHVIEN.Hoten, DETAI.Tendt
-- FROM GIAOVIEN
-- JOIN DETAI ON GIAOVIEN.Magv = DETAI.Magv
-- JOIN SINHVIEN ON SINHVIEN.Madt = DETAI.Madt
-- WHERE GIAOVIEN.Hoten = 'Trần Thị Loan';
select g.Magv,g.Hoten,count(Madt) as soluong
from GIAOVIEN g left join DETAI d on g.Madt=d.Madt
group by g.Magv,Hoten
having count(Madt)>=all(select count(Madt) from DETAI group by Madt);


-- Câu 2: Đưa ra thông tin: mã sinh viên, họ tên, tên đề tài của các đề tài được giáo viên ‘Trần Thị Loan’  hướng dẫn
select SINHVIEN.Masv,SINHVIEN.Hoten,DETAI.Tendt from SINHVIEN
JOIN DETAI ON SINHVIEN.Madt=DETAI.Madt 
join GIAOVIEN ON GIAOVIEN.Magv=DETAI.Magv
where GIAOVIEN.Hoten='Trần Thị Loan';
-- Câu 3: Đưa ra thông tin: Masv, Hoten, Tuoi của những sinh viên có tuổi>18 và Quequan là ‘Hà Nội’ 
select Masv,Hoten,year(now())-year(Ngaysinh) as Tuoi from SINHVIEN where year(now())-year(Ngaysinh)>18 and Quequan='Hà Nội';
-- Câu 4: Đưa ra thông tin giáo viên hướng dẫn nhiều đề tài nhất.Thông tin hiển thị gồm có: Magv, Hoten, số đề tài hướng dẫn 
select GIAOVIEN.Magv,GIAOVIEN.Hoten,COUNT(Madt) from GIAOVIEN join DETAI on GIAOVIEN.Magv=DETAI.Magv group by GIAOVIEN.Magv,GIAOVIEN.Hoten order by COUNT(Madt) DESC limit 1 ; 
-- Câu 5: Đưa ra danh sách các đề tài và điểm trung bình của từng đề tài (điểm trung bình của từng đề tài = trung bình cộng điểm của các sinh viên tham gia vào đề tài đó).thông tin gồm: Madt, Tendt, Điểm TB

-- Câu 6: Thêm một bản ghi mới vào bảng,dữ liệu phù hợp( không được nhập giá trị null). 
-- Câu 7: Thay đổi quê quán của giáo viên Trần thị Loan  thành ‘Hà Nội’. 
-- Câu 8: Xóa đề tài không có sinh viên chọn. 
delete from DETAI where Madt not in (SELECT MaDT from SINHVIEN  )
