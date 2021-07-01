use Testing_System_Assignment_2;

-- 2 --
select * from department;

-- 3 --
select DepartmentID from department where DepartmentName = 'Sale';

-- 4 --
select *
from accountt 
where character_length(Fullname) = (select max(character_length(Fullname)) 
									from accountt);

-- 5 --
select *
from accountt
where 	character_length(Fullname) = (select max(character_length(Fullname)) 
									from accountt
                                    where accountt.DepartmentID = 3);
                                    
-- 6 --
select GroupName
from Groupp
where CreateDate < '2019-12-20';

-- 7 --
select count(AnswerID) as 'so cau tra loi', QuestionID
from Answer 
group by QuestionID
having 'so cau tra loi'> 4;

-- 8 --
select Codee
from Exam 
where Duration >= 60 and CreateDate > '2019-12-20';

-- 9 --
select *
from groupp
order by CreateDate desc
limit 5;

-- 10 --
select count(AccountID) as 'nhan vien department 2'
from accountt
where DepartmentID = 2;

-- 11 --
select *
from accountt
where Fullname = 'D&o';

-- 12 --
delete from exam 
where CreateDate < '2019-12-20';

-- 13 -- 
delete from question
where Content = 'câu hỏi';

-- 14 -- 
update accountt
set Fullname = 'Nguyễn Bá Lộc', Email = 'loc.nguyenba@vti.com.vn'
where AccountID = 5;

-- 15 -- 
update groupaccount
set AccountID = 5 
where GroupID = 4