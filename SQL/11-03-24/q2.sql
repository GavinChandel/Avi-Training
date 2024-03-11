use chandelgavin1;
create table warehouse(name varchar(30), product_id int, units int, primary key(name, product_id));
create table products(product_id int primary key, product_name varchar(30), width int, length int, height int);

insert into warehouse values("LCHouse1",1,1),("LCHouse1",2,10),("LCHouse1",3,5),("LCHouse2",1,2),("LCHouse2",2,2),("LCHouse3",4,1);
insert into products values(1,"LC-TV",5,50,40),(2,"LC-KeyChain",5,5,5),(3,"LC-Phone",2,10,10),(4,"LC-T-Shirt",4,10,20);

select w.name as warehouse_name, sum(p.width * p.length * p.height * w.units) as volume from warehouse w join products p on w.product_id = p.product_id group by w.name;