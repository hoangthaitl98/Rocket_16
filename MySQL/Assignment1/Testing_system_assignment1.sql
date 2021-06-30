drop database if exists Testing_System_Assignment_1;
create database if not exists Testing_System_Assignment_1;

use Testing_System_Assignment_1;

drop table if exists Department;
create table if not exists Department(
	DepartmentID tinyint auto_increment primary key,
    DepartmentName varchar(50) not null
);

drop table if exists Positions;
create table if not exists Positions (
	PositionID tinyint auto_increment primary key,
    PositionName enum('Dev', 'Test', 'Scrum Master', 'PM')
);

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

drop table if exists Groupp;
create table if not exists Groupp(
	GroupID tinyint auto_increment primary key,
    GroupName varchar(30) not null,
    CreatorID tinyint not null,
    CreateDate datetime not null
);

drop table if exists GroupAccount;
create table if not exists GroupAccount(
	GroupID tinyint not null,
	foreign key (GroupID) references Groupp(GroupID), 
    AccountID tinyint not null,
    foreign key (AccountID) references Accountt(AccountID),
    JoinDate datetime not null
);

drop table if exists TypeQuestion;
create table if not exists TypeQuestion(
	TypeID tinyint auto_increment primary key,
    TypeName enum('Essay', 'Multiple-Choice') not null
);

drop table if exists CategoryQuestion;
create table if not exists CategoryQuestion(
	CategoryID tinyint auto_increment primary key,
    CategoryName varchar(50) not null
);

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

drop table if exists Answer;
create table if not exists Answer(
	AnswerID tinyint auto_increment primary key,
    Content varchar(255) not null,
    QuestionID tinyint not null,
    foreign key(QuestionID) references Question(QuestionID),
    isCorrect tinyint(1) not null
);

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

drop table if exists ExamQuetion;
create table if not exists ExamQuetion(
	ExamID tinyint not null,
	foreign key(ExamID) references Exam(ExamID),
    QuestionID tinyint not null,
    foreign key(QuestionID) references Question(QuestionID)
);