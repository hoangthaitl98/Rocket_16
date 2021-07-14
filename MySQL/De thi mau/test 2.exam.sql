create database thuc_tap;

use thuc_tap;

drop table if exists GiangVien;
create table GiangVien(
	magv int auto_increment primary key,
    hoten varchar(50),
    luong int
);

drop table if exists SinhVien;
create table SinhVien(
	masv int auto_increment primary key,
    hoten varchar(50),
    namsinh int,
    quequan varchar(50)
);

drop table if exists DeTai;
create table DeTai(
	madt int auto_increment primary key,
    tendt varchar(50),
    kinhphi int,
    noithuctap varchar(50)
);

drop table if exists HuongDan;
create table HuongDan(
	id int auto_increment primary key,
    masv int,
    madt int,
    magv int,
    ketqua int
);

INSERT INTO `thuc_tap`.`detai` (`madt`, `tendt`, `kinhphi`, `noithuctap`) VALUES ('1', 'SQL', '1100', 'Ha noi');
INSERT INTO `thuc_tap`.`detai` (`madt`, `tendt`, `kinhphi`, `noithuctap`) VALUES ('2', 'Java', '1200', 'HCM');
INSERT INTO `thuc_tap`.`detai` (`madt`, `tendt`, `kinhphi`, `noithuctap`) VALUES ('3', 'JS', '1300', 'Da Nang');
INSERT INTO `thuc_tap`.`detai` (`madt`, `tendt`, `kinhphi`, `noithuctap`) VALUES ('4', 'Cong nghe sinh hoc', '1400', 'Ha noi');


INSERT INTO `thuc_tap`.`giangvien` (`magv`, `hoten`, `luong`) VALUES ('1', 'nguyen van a', '1000');
INSERT INTO `thuc_tap`.`giangvien` (`magv`, `hoten`, `luong`) VALUES ('2', 'bui van b', '1100');
INSERT INTO `thuc_tap`.`giangvien` (`magv`, `hoten`, `luong`) VALUES ('3', 'pham van c', '1200');

INSERT INTO `thuc_tap`.`huongdan` (`id`, `masv`, `madt`, `magv`, `ketqua`) VALUES ('1', '1', '1', '1', '10');
INSERT INTO `thuc_tap`.`huongdan` (`id`, `masv`, `madt`, `magv`, `ketqua`) VALUES ('2', '2', '2', '2', '8');
INSERT INTO `thuc_tap`.`huongdan` (`id`, `masv`, `madt`, `magv`, `ketqua`) VALUES ('3', '3', '3', '3', '9');

INSERT INTO `thuc_tap`.`sinhvien` (`masv`, `hoten`, `namsinh`, `quequan`) VALUES ('1', 'bui van a', '1998', 'ha noi');
INSERT INTO `thuc_tap`.`sinhvien` (`masv`, `hoten`, `namsinh`, `quequan`) VALUES ('2', 'nguyen van b', '1999', 'nam dinh');
INSERT INTO `thuc_tap`.`sinhvien` (`masv`, `hoten`, `namsinh`, `quequan`) VALUES ('4', 'duong van d', '1999', 'ha noi');
INSERT INTO `thuc_tap`.`sinhvien` (`masv`, `hoten`, `namsinh`, `quequan`) VALUES ('3', 'pham thi c', '1998', 'hai phong');

select sinhvien.*
from sinhvien
where masv not in(
select S.masv
from sinhvien S
join huongdan H on H.magv = H.magv
join detai D on D.madt = H.madt);

select count(H.madt)
from huongdan as H
join detai as D on D.madt = H.madt
where D.tendt = 'cong nghe sinh hoc'
group by H.madt;

drop view if exists sinhvieninfor;
create view sinhvieninfor as
select S.masv, S.hoten, D.tendt
from sinhvien as S
left join huongdan as H on H.masv = S.masv
left join detai as D on D.madt = H.madt;

drop trigger if exists t_sinhvien;
Delimiter $$
create trigger t_sinhvien
before insert on sinhvien
for each row
begin
	if (new.namsinh <= 1900) then
		signal sqlstate'12345'
        set message_text = 'năm sinh phải > 1900';
    end if;
end$$
Delimiter ;

INSERT INTO `thuc_tap`.`sinhvien` (`masv`, `hoten`, `namsinh`, `quequan`) VALUES ('5', 'nguyen van e', '1800', 'hai duong');


drop trigger if exists config_huongdan;
Delimiter $$
create trigger config_huongdan
before delete on sinhvien
for each row
begin
	delete from huongdan where huongdan.masv = old.masv;
end$$
Delimiter ;

delete from sinhvien where sinhvien.masv = 2;
select * from huongdan;