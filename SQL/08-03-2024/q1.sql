use chandelgavin1;
create table world(name varchar(30), continent varchar(30), area int, population int, gdp int);
insert into world values("Afghanistan", "Asia", 652230, 25500100, 20343000);
insert into world values("Albania","Europe",28748,2831741,12960000);
insert into world values("Algeria","Africa",2381741,37100000,188681000),("Andorra","Europe",468,78115,3712000),("Angola","Africa",1246700,20609294,100990000);
insert into world value("Albania","Europe",28748,2831741,12960000);
select name,population,area from world where population>25000000 or area>3000000;