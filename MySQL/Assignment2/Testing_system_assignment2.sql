drop database if exists Testing_System_Assignment_2;
create database if not exists Testing_System_Assignment_2;

use Testing_System_Assignment_2;

drop table if exists Department;
create table if not exists Department(
	DepartmentID tinyint auto_increment primary key,
    DepartmentName varchar(50) not null
);

-- Add data Department--
insert into department(DepartmentName)
values 	('Marketing'),
		('Sale'),
		('Bảo vệ'),
        ('Nhân sự'),
        ('Kỹ thuật');
        
drop table if exists Positions;
create table if not exists Positions (
	PositionID tinyint auto_increment primary key,
    PositionName enum('Dev', 'Test', 'Scrum Master', 'PM')
);

-- Add data Positions--
insert into Positions(PositionName)
values 	('Dev'),
		('Test'),
		('Scrum Master'),
        ('PM'),
        ('Dev');

drop table if exists Accountt;
create table if not exists Accountt(
	AccountID tinyint auto_increment primary key,
    Email varchar(255) not null,
    Username varchar(255) not null,
    Fullname varchar(50) not null,
    DepartmentID tinyint not null,
    foreign key (DepartmentID) references Department(DepartmentID),
    PositionID tinyint not null,
    foreign key (PositionID) references Positions (PositionID),
    CreateDate datetime not null
); 

-- Add data Accountt--
insert into Accountt(Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
values 	('abc@gmail.com', 'qweqwr', 'nguyen van a', 1, 1, '2021-02-01 01:00:01'),
		('abc@gmail.com', 'trytry', 'doan van b', 2, 2, '2021-02-01 01:00:02'),
        ('abc@gmail.com', 'yuiyii', 'bui van c', 3, 3, '2021-02-01 01:00:03'),
        ('abc@gmail.com', 'asdasd', 'duong van d', 4, 4, '2021-02-01 01:00:04'),
        ('abc@gmail.com', 'hfghdh', 'nguyen van e', 5, 5, '2021-02-01 01:00:05');

drop table if exists Groupp;
create table if not exists Groupp(
	GroupID tinyint auto_increment primary key,
    GroupName varchar(30) not null,
    CreatorID tinyint not null,
    CreateDate datetime not null
);

-- Add data Groupp--
insert into Groupp(GroupName, CreatorID, CreateDate)
values 	('nhom 1', 1, '2021-02-01 00:00:01'),
		('nhom 2', 2, '2021-02-01 00:00:02'),
        ('nhom 3', 3, '2021-02-02 00:00:03'),
        ('nhom 4', 4, '2021-02-03 00:00:04'),
        ('nhom 5', 5, '2021-02-04 00:00:05');

drop table if exists GroupAccount;
create table if not exists GroupAccount(
	GroupID tinyint not null,
	foreign key (GroupID) references Groupp(GroupID), 
    AccountID tinyint not null,
    foreign key (AccountID) references Accountt(AccountID),
    JoinDate datetime not null
);

-- Add data GroupAccount--
insert into GroupAccount(GroupID, AccountID, JoinDate)
values 	(1, 1, '2021-02-01 09:00:01'),
		(2, 2, '2021-02-01 09:00:02'),
        (3, 3, '2021-02-02 09:00:03'),
        (4, 4, '2021-02-03 09:00:04'),
        (5, 5, '2021-02-04 09:00:05');

drop table if exists TypeQuestion;
create table if not exists TypeQuestion(
	TypeID tinyint auto_increment primary key,
    TypeName enum('Essay', 'Multiple-Choice') not null
);

-- Add data TypeQuestion--
insert into TypeQuestion(TypeName)
values 	(1),
		(2),
        (1),
        (2),
        (2);

drop table if exists CategoryQuestion;
create table if not exists CategoryQuestion(
	CategoryID tinyint auto_increment primary key,
    CategoryName enum('JAVA', '.NET', 'SQL', 'Postman', 'Ruby') not null
);

-- Add data CategoryQuestion--
insert into CategoryQuestion(CategoryName)
values 	(1),
		(2),
        (3),
        (4),
        (5);

drop table if exists Question;
create table if not exists Question(
	QuestionID tinyint auto_increment primary key,
    Content varchar(255) not null,
    CategoryID tinyint not null,
    foreign key(CategoryID) references CategoryQuestion(CategoryID),
    TypeID tinyint not null,
    foreign key(TypeID) references TypeQuestion(TypeID),
    CreatorID tinyint not null,
    CreateDate datetime not null
);

-- Add data Question --
insert into Question(Content, CategoryID, TypeID, CreatorID, CreateDate)
values ('JVM là gì?', 1, 1, 1, '2021-02-01 11:00:00'),
		('JDK là gì?', 2, 2, 2, '2021-02-01 11:00:01'),
        ('JRE là gì?', 3, 3, 3, '2021-02-01 11:00:02'),
        ('Static là gì?', 4, 4, 4, '2021-02-01 11:00:03'),
        ('Constructor là gì?', 5, 5, 5, '2021-02-01 11:00:04');

drop table if exists Answer;
create table if not exists Answer(
	AnswerID tinyint auto_increment primary key,
    Content varchar(255) not null,
    QuestionID tinyint not null,
    foreign key(QuestionID) references Question(QuestionID),
    isCorrect tinyint(1) not null
);

-- Add data Answer --
insert into Answer(Content, QuestionID, isCorrect)
values ('Java Virtual Machine', 1, 1),
		('Java Development Kit', 2, 1),
        ('Java Runtime Environment?', 3, 1),
        ('static được sử dụng chính để quản lý bộ nhớ', 4, 1),
        ('Hàm tạo', 5, 1);

drop table if exists Exam;
create table if not exists Exam(
	ExamID tinyint auto_increment primary key,
    Codee varchar(10) not null,
    Title varchar(30) not null,
    CategoryID tinyint not null,
    Duration smallint not null,
    CreatorID tinyint not null,
    CreateDate datetime not null
);

-- Add data Exam--
insert into Exam(Codee, Title, CategoryID, Duration, CreatorID, CreateDate)
values 	('0001', 'abc', 1, 60, 1, '2021-02-01 10:00:00'),
		('0002', 'bca', 2, 60, 2, '2021-02-01 10:00:01'),
        ('0003', 'bac', 3, 60, 3, '2021-02-01 10:00:02'),
        ('0004', 'acb', 4, 60, 4, '2021-02-01 10:00:03'),
        ('0005', 'cba', 5, 60, 5, '2021-02-01 10:00:04');

drop table if exists ExamQuetion;
create table if not exists ExamQuetion(
	ExamID tinyint not null,
	foreign key(ExamID) references Exam(ExamID),
    QuestionID tinyint not null,
    foreign key(QuestionID) references Question(QuestionID)
);

-- Add data ExamQuetion--
insert into ExamQuetion(ExamID, QuestionID)
values 	(1, 1),
		(2, 2),
		(3, 3),
		(4, 4),
		(5, 5);