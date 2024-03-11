use chandelgavin1;
create table NPV(id int, year int, npv int, primary key(id, year));
create table Queries(id int, year int, primary key(id, year));

insert into npv values(1,2018,100),(7,2020,30),(13,2019,40),(1,2019,113),(2,2008,121),(3,2009,12),(11,2020,99),(7,2019,0);
insert into queries values(1,2019),(2,2008),(3,2009),(7,2018),(7,2019),(7,2020),(13,2019);
SELECT q.id,q.year, COALESCE(n.npv, 0) AS npv FROM Queries q LEFT JOIN NPV n ON n.id = q.id AND q.year = n.year;
