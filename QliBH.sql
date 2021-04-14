create database teamwork1_qlbh
go
use teamwork1_qlbh
go

create table tblSanPham 
(
	idSP	char(4) primary key,
	tenSP	varchar(50),
	namSX	int,
	donGia	money,
	soLuong	int
)

insert into tblSanPham values
	('0001', 'Banh A', 2021, 20000, 231),
	('0002', 'Banh B', 2021, 15000, 31)