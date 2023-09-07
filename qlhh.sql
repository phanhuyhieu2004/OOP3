Create database qlhh;
use qlhh;

create table MATHANG(
	MAHANG varchar(5) primary key,
    TENHANG varchar(100),
    DONGIA int
);create table KHACHHANG(
	MAKH varchar(5) primary key,
    TENKH varchar(100),
    GIOITINH varchar(10),
    QUEQUAN varchar(100)
);create table HOADON(
	SOPHIEU varchar(5) primary key,
    NGAYLAP DATETIME,
    MAKH varchar(5)
);create table CTHOADON(
	SOPHIEU varchar(5) ,
    MAHANG varchar(5),
    primary key(SOPHIEU,MAHANG),
    SOLUONG int
);
ALTER TABLE HOADON ADD constraint foreign key (MAKH) references KHACHHANG(MAKH);
ALTER TABLE CTHOADON ADD constraint foreign key (SOPHIEU) references HOADON(SOPHIEU);
ALTER TABLE CTHOADON ADD constraint foreign key (MAHANG) references MATHANG(MAHANG);
INSERT INTO MATHANG(MAHANG, TENHANG, DONGIA) VALUES ("M1", "Duong moi", 200000);
INSERT INTO MATHANG(MAHANG, TENHANG, DONGIA) VALUES ("M2", "Tinh chat", 1000000);
INSERT INTO MATHANG(MAHANG, TENHANG, DONGIA) VALUES ("M3", "Kem duong", 550000);INSERT INTO KHACHHANG(MAKH, TENKH, GIOITINH, QUEQUAN) VALUES ("K1", "Trần Triệu Vy", "Nữ", "Hà Nội");
INSERT INTO KHACHHANG(MAKH, TENKH, GIOITINH, QUEQUAN) VALUES ("K2", "Trần Đình Trọng", "Nam", "Thái Bình");
INSERT INTO KHACHHANG(MAKH, TENKH, GIOITINH, QUEQUAN) VALUES ("K3", "Minh Hà", "Nữ", "Sài Gòn");INSERT INTO HOADON(SOPHIEU, NGAYLAP, MAKH) VALUES ("P1", "2019-03-03", "K1");
INSERT INTO HOADON(SOPHIEU, NGAYLAP, MAKH) VALUES ("P2", "2019-03-08", "K1");
INSERT INTO HOADON(SOPHIEU, NGAYLAP, MAKH) VALUES ("P3", "2019-04-08", "K3");INSERT INTO CTHOADON(SOPHIEU, MAHANG, SOLUONG) VALUES ("P1", "M1", 2);
INSERT INTO CTHOADON(SOPHIEU, MAHANG, SOLUONG) VALUES ("P1", "M2", 3);
INSERT INTO CTHOADON(SOPHIEU, MAHANG, SOLUONG) VALUES ("P2", "M2", 1);
INSERT INTO CTHOADON(SOPHIEU, MAHANG, SOLUONG) VALUES ("P3", "M3", 1);
-- Câu 2: Đưa ra thông tin: Makh, Tenkh, Gioitinh của những khách hàng có Họ Nguyễn và Quequan là ‘Hà Nội’. 
select * from KHACHHANG where TENKH like'Nguyễn%' and QUEQUAN='Hà Nội';
-- Câu 3: Đưa ra thông tin danh sách các khách hàng (Makh, Tenkh, tổng tiền) có tổng thành tiền của các hóa đơn từ 1.000.000 trở lên. Trong đó tổng tiền=số lượng*Đơn giá
select KHACHHANG.MAKH,KHACHHANG.TENKH,SUM(SOLUONG*DONGIA) AS TONGTIEN 
from KHACHHANG inner join HOADON ON HOADON.MAKH=KHACHHANG.MAKH 
join CTHOADON ON HOADON.SOPHIEU=CTHOADON.SOPHIEU
join MATHANG ON MATHANG.MAHANG=CTHOADON.MAHANG
group by KHACHHANG.MAKH 
HAVING TONGTIEN >= 1000000;
-- Câu 4: Cho biết thông tin khách hàng chưa đặt đơn hàng nào. Thông tin gồm: Makh, Tenkh 
select KHACHHANG.MAKH,TENKH from KHACHHANG left join HOADON on KHACHHANG.MAKH=HOADON.MAKH where SOPHIEU IS NULL;
-- Câu 5: Liệt kê thông tin: Makh, Tenkh, Mahang, Tenhang, Dongia, Soluong của khách hàng có tên khách hàng là Trần Triệu Vy .
select KHACHHANG.MAKH,KHACHHANG.TENKH,MATHANG.MAHANG,MATHANG.TENHANG,MATHANG.DONGIA,CTHOADON.SOLUONG 
from KHACHHANG inner join HOADON ON HOADON.MAKH=KHACHHANG.MAKH 
join CTHOADON ON HOADON.SOPHIEU=CTHOADON.SOPHIEU
join MATHANG ON MATHANG.MAHANG=CTHOADON.MAHANG
where KHACHHANG.TENKH= 'Trần Triệu Vy';
select KHACHHANG.MAKH, KHACHHANG.TENKH, MATHANG.MAHANG,MATHANG.TENHANG, MATHANG.DONGIA, CTHOADON.SOLUONG
from KHACHHANG inner join HOADON on KHACHHANG.MAKH = HOADON.MAKH
inner join CTHOADON on HOADON.SOPHIEU = CTHOADON.SOPHIEU
inner join MATHANG on CTHOADON.MAHANG = MATHANG.MAHANG
WHERE KHACHHANG.TENKH = "Trần Triệu Vy";

-- Câu 6: Thêm một bản ghi mới vào chitiethoadon,dữ liệu phù hợp( không được nhập giá trị null). 
INSERT INTO  CTHOADON VALUES
("P3", "M3", 4);
-- Câu 7: Thay đổi quê quán của khách hàng Minh Hà thành ‘Miền Tây’ 
update KHACHHANG set QUEQUAN='Miền Tây' Where TENKH='Minh Hà';
-- Câu 8: Xóa mặt hàng có tên hàng ‘Kem dưỡng Ohui’ 
SET foreign_key_checks=0;
DELETE FROM MATHANG where TENHANG='Kem dưỡng';