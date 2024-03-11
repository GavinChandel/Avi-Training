use chandelgavin1;
create table Orders(order_number int primary key, customer_number int);
insert into Orders value(1,1),(2,2),(3,3),(4,3);
select customer_number from orders order by customer_number desc limit 1;
