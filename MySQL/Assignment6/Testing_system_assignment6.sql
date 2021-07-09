-- 1 --
drop procedure if exists printAc;
Delimiter $$
create procedure printAc (IN departmentN varchar(50))
begin
	declare idD int;
    select DepartmentID into idD from department where DepartmentName like departmentN;
    select * from `account` where DepartmentID = idD;
end$$
Delimiter ;

call printAc ('dev');

-- 2 --
drop procedure if exists printGrAc;
Delimiter $$
create procedure printGrAc ()
begin
    select count(GroupID) from groupaccount group by GroupID;
end$$
Delimiter $$;

call printGrAc();

-- 3 --

-- 4 --
drop procedure if exists printIDTypeQuestion;
Delimiter $$
create procedure printIDTypeQuestion(out type_id int)
begin
    select Q.TypeID into type_id
    from question as Q 
    group by Q.TypeID
    order by count(Q.TypeID) desc
    limit 1;
end$$
Delimiter ;

set @type_idd = 0;
call printIDTypeQuestion(@type_idd);
select @type_idd;

-- 5 --
set @type_idd = 0;
call printIDTypeQuestion(@type_idd);
select @type_idd;

select typequestion.TypeName
from typequestion 
where TypeID = @type_idd;

-- 6 --
drop procedure if exists printGroup;
Delimiter $$;
create procedure printGroup(in name_input varchar(50))
begin
	select GroupID
	from `group`
	where GroupName like name_input
    union
    select AccountID
    from `account` as A
    where UserName like name_input;
end$$
Delimiter ;

call printGroup('a');