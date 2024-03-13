use chandelgavin1;
create table my_numbers(num int);
insert into my_numbers values(8),(8),(3),(3),(1),(4),(5),(6);

select max(num) as num from(select num from my_numbers group by num having count(*)=1) as unique_numbers;