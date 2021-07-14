create database test_exam;

use test_exam;

drop table if exists country;
create table country(
	country_id int auto_increment primary key,
    country_name varchar(50)
);

drop table if exists location;
create table location(
	location_id int auto_increment primary key,
    street_address varchar(50),
    postal_code varchar(50),
    country_id int
);

drop table if exists employee;
create table employee(
	employee_id int auto_increment primary key,
    full_name varchar(50),
    email varchar(50),
    location_id int
);

insert into country(country_name)
values ('Việt Nam'), ('Mỹ'), ('Trung Quốc');

INSERT INTO `test_exam`.`location` (`location_id`, `street_address`, `postal_code`, `country_id`) VALUES ('1', 'hà nội', '1000', '1');
INSERT INTO `test_exam`.`location` (`location_id`, `street_address`, `postal_code`, `country_id`) VALUES ('2', 'new york', '2000', '2');
INSERT INTO `test_exam`.`location` (`location_id`, `street_address`, `postal_code`, `country_id`) VALUES ('3', 'bắc kinh', '3000', '3');

INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('1', 'nguyen van a', 'nn01@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('2', 'bill gates', 'nn02@gmail.com', '2');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('3', 'tập cận bình', 'nn03@gmail.com', '3');

select E.full_name, C.country_name
from employee as E
join location as L on L.location_id = E.location_id
join country as C on C.country_id = L.country_id
where C.country_name = 'Việt Nam';

select C.country_name, E.email
from country as C
join location as L on L.country_id = C.country_id
join employee as E on E.location_id = L.location_id
where email = 'nn03@gmail.com';

select count(E.location_id) as 'location', count(L.country_id) as 'country'
from employee as E 
join location as L on L.location_id = E.location_id
group by E.location_id, L.country_id;

drop trigger if exists insert_10employee;
Delimiter $$
create trigger insert_10employee 
before insert on employee
for each row 
begin 
	declare v_countEmployeeInCountry int;
    select count(*) into v_countEmployeeInCountry
    from employee as E
    join location as L on L.location_id = E.location_id
    join country as C on C.country_id = L.country_id
    where L.location_id = new.location_id
    group by L.country_id; 
    if (v_countEmployeeInCountry > 10) then
		signal sqlstate'12345'
        set message_text = 'Cannot add more than 10 employee';
	end if;
end$$
Delimiter ;

INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('5', 'bui van b', 'nn05@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('6', 'bui van b', 'nn05@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('7', 'bui van b', 'nn05@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('8', 'bui van b', 'nn05@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('9', 'bui van b', 'nn05@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('10', 'bui van b', 'nn05@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('11', 'bui van b', 'nn05@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('12', 'bui van b', 'nn05@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('13', 'bui van b', 'nn05@gmail.com', '1');
INSERT INTO `test_exam`.`employee` (`employee_id`, `full_name`, `email`, `location_id`) VALUES ('14', 'bui van b', 'nn05@gmail.com', '1');

drop trigger if exists configDeleteLocation;
Delimiter $$
create trigger configDeleteLocation
after delete on location
for each row
begin
	update employee set location_id = null where location_id = old.location_id;
end$$
Delimiter ;

begin work ;
-- employee truoc khi xoa location
select * from employee;
delete from location where location_id =1;
-- employee sau khi xoa location
select * from employee;
rollback ;