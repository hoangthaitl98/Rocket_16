create database final_exam;

use final_exam;

-- Questions 1--
-- tạo table --
drop table if exists Student;
create table Student(
	id int auto_increment primary key,
    `name` varchar(50) not null,
    age int not null,
    gender enum('male', 'female', 'unknow')
);

drop table if exists `Subject`;
create table `Subject`(
	id int auto_increment primary key ,
    `name` varchar(50) not null
);

drop table if exists StudentSubject;
create table StudentSubject(
	StudentID int not null,
    SubjectID  int not null,
    Mark int,
    `Date` date,
    constraint pk_StudentSubject primary key (StudentID, SubjectID)
);

-- insert data --
-- table student --
INSERT INTO `final_exam`.`student` (`id`, `name`, `age`, `gender`) VALUES ('1', 'Nguyễn Nguyên Lộc', '19', 'male');
INSERT INTO `final_exam`.`student` (`id`, `name`, `age`, `gender`) VALUES ('2', 'Phùng Minh Thắng', '20', 'male');
INSERT INTO `final_exam`.`student` (`id`, `name`, `age`, `gender`) VALUES ('3', 'Đỗ Đức Hưng', '21', 'male');
INSERT INTO `final_exam`.`student` (`id`, `name`, `age`, `gender`) VALUES ('4', 'Nguyễn Trung Kiên', '18', null);


-- table subject --
INSERT INTO `final_exam`.`subject` (`id`, `name`) VALUES ('1', 'Java');
INSERT INTO `final_exam`.`subject` (`id`, `name`) VALUES ('2', 'SQL');
INSERT INTO `final_exam`.`subject` (`id`, `name`) VALUES ('3', 'JS');

-- tabel studentsubject --
INSERT INTO `final_exam`.`studentsubject` (`StudentID`, `SubjectID`, `Mark`, `Date`) VALUES ('1', '1', '10', '2021-07-14');
INSERT INTO `final_exam`.`studentsubject` (`StudentID`, `SubjectID`, `Mark`, `Date`) VALUES ('2', '2', '9', '2021-07-13');
INSERT INTO `final_exam`.`studentsubject` (`StudentID`, `SubjectID`, `Mark`, `Date`) VALUES ('3', '2', '8', '2021-07-12');
INSERT INTO `final_exam`.`studentsubject` (`StudentID`, `SubjectID`, `Mark`, `Date`) VALUES ('4', '2', null, null);

-- Question 2 --
-- Lấy tất cả các môn học không có bất kì điểm nào --
select `subject`.*
from `subject`
where `subject`.id not in( select distinct sub.id
							from `Subject` as sub
							join studentsubject as ss on ss.subjectid = sub.id);

-- Lấy danh sách các môn học có ít nhất 2 điểm --
select sub.*, count(ss.subjectid)
from `subject` as sub
join studentsubject as ss on ss.subjectid = sub.id
group by ss.subjectid
having count(ss.subjectid) >= 2;

-- Question 3 --
drop view if exists StudentInfo;
create view StudentInfo as
select ST.id, ST.`name` as 'StudentName', ST.age, sub.`name`, SS.mark, SS.`date`, ST.gender
from student as ST
join studentsubject as SS on ss.studentid = ST.id
join `subject` as sub on sub.id = ss.subjectid;

-- Question 4 --
-- a --
drop trigger if exists SubjectUpdateID;
Delimiter $$
create trigger SubjectUpdateID
before update on `Subject`
for each row
begin
	update studentsubject set studentsubject.subjectid = new.id where studentsubject.subjectid = old.id;
end$$
Delimiter ;

begin work;
update `Subject` as Sub set Sub.id = 4 where Sub.`name` = 'SQL';
select studentsubject.* from studentsubject;
rollback;

-- b --
drop trigger if exists StudentDeleteID
Delimiter $$
create trigger StudentDeleteID
before delete on student
for each row
begin
	delete from StudentSubject where StudentSubject.studentid = old.id;
end$$
Delimiter ;

begin work;
delete from Student where Student.id = 2;
select StudentSubject.* from StudentSubject;
rollback;

-- Question 5 --
drop procedure if exists p_deleteStudent;
Delimiter $$
create procedure p_deleteStudent(in student_name varchar(50))
begin
	delete from student where student.`name` = student_name;
    if(student_name = '*') then delete from student; 
    end if;
end$$
Delimiter ;
call p_deleteStudent('Đỗ Đức Hưng');
select student.* from student;