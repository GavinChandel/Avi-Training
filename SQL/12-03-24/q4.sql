use chandelgavin1;
create table Customers(customer_id int primary key, name varchar(30));
create table Orders1(order_id int primary key, order_date date, customer_id int, product_id int);
create table products1(product_id int primary key, product_name varchar(30), price int);

insert into customers values(1, 'Alice'),(2,'Bob'),(3,'Tom'),(4,'Jerry'),(5,'John');
INSERT INTO orders1 VALUES
  (1, '2020-07-31', 1, 1),
  (2, '2020-07-30', 2, 2),
  (3, '2020-08-29', 3, 3),
  (4, '2020-07-29', 4, 1),
  (5, '2020-06-10', 1, 2),
  (6, '2020-08-01', 2, 1),
  (7, '2020-08-01', 3, 3),
  (8, '2020-08-03', 1, 2),
  (9, '2020-08-07', 2, 3),
  (10, '2020-07-15', 1, 2);

INSERT INTO products1 VALUES(1,'keyboard',120),(2,'mouse',80),(3,'screen',600),(4,'hard disk',450);


SELECT o.customer_id, o.product_id, p.product_name
FROM (
    SELECT customer_id, product_id, COUNT(*) AS freq
    FROM Orders1
    GROUP BY customer_id, product_id
) AS o
JOIN (
    SELECT customer_id, MAX(freq) AS max_freq
    FROM (
        SELECT customer_id, product_id, COUNT(*) AS freq
        FROM Orders1
        GROUP BY customer_id, product_id
    ) AS temp
    GROUP BY customer_id
) AS m ON o.customer_id = m.customer_id AND o.freq = m.max_freq
JOIN Products1 p ON o.product_id = p.product_id
order by customer_id asc





  

