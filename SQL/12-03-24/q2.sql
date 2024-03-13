use chandelgavin1;
create table Employees(empId int primary key, name varchar(20), supervisor int, salary int);
drop table bonus;
create table Bonus(empId int primary key, bonus int);

insert into Employees values(1,'John',3,1000),(2,'Dan',3,2000),(3,'Brad',null,4000),(4,'Thomas',3,4000);
insert into Bonus values(2,500),(4,2000);

select e.name, b.bonus from employees e left join bonus b on e.empId=b.empId where b.bonus<1000 or b.bonus is null;
