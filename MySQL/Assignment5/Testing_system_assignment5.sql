use testing_system;

-- 1 --
drop view if exists nhanvien_sale;
create view nhanvien_sale as
select A.Fullname
from account A
join department D on A.DepartmentID = D.DepartmentID
where D.DepartmentName = 'Phòng Sale';

-- 2 --
drop view if exists max_group_account;
create view max_group_account as
select A.*, count(GAC.AccountID) as maxCount
from `account` as A
join groupaccount as GAC on A.AccountID = GAC.AccountID
group by GAC.AccountID
having count(GAC.AccountID) = (select MAX(`TEMP`.countGroup) FROM
									(select count(GA.AccountID) as countGroup
									from groupaccount GA
									group by GA.AccountId) as `TEMP`);
                                    
-- 3 --
drop view if exists long_question;
create view long_question as
select Q.*
from question as Q
where character_length(Q.content) > 10;

-- 4 --
drop view if exists most_user_department;
create view most_user_department as
select D.*, count(D.DepartmentID)
from department as D
join `account` as AC on D.DepartmentID = AC.DepartmentID
group by D.DepartmentID
having count(D.DepartmentID) = (select MAX(`TEMP`.countAccount) from
									(select count(A.DepartmentID) as countAccount
									from `account` as A
									group by DepartmentID) as `TEMP`);

-- 5 --
drop view if exists nguyen_creator;
create view nguyen_creator as
select Q.*, A.Fullname
from question as Q
join `account` as A on Q.CreatorID = A.AccountID
where A.Fullname like 'Nguyễn%';