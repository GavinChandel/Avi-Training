use march14;
create table departments1(department_id int, department_name varchar(30), manager_id int, location_id int);
create table locations(location_id int, street_address varchar(30), postal_code int, city varchar(20), state_province varchar(30), country_id varchar(5));
alter table locations modify column postal_code varchar(30);

INSERT INTO departments1 VALUES
(10, 'Administration', 200, 1700),
(20, 'Marketing', 201, 1800),
(30, 'Purchasing', 114, 1700),
(40, 'Human Resources', 203, 2400),
(50, 'Shipping', 121, 1500),
(60, 'IT', 103, 1400),
(70, 'Public Relations', 204, 2700),
(80, 'Sales', 145, 2500),
(90, 'Executive', 100, 1700),
(100, 'Finance', 108, 1700),
(110, 'Accounting', 205, 1700),
(120, 'Treasury', 0, 1700),
(130, 'Corporate Tax', 0, 1700),
(140, 'Control And Credit', 0, 1700),
(150, 'Shareholder Services', 0, 1700),
(160, 'Benefits', 0, 1700),
(170, 'Manufacturing', 0, 1700),
(180, 'Construction', 0, 1700),
(190, 'Contracting', 0, 1700),
(200, 'Operations', 0, 1700),
(210, 'IT Support', 0, 1700),
(220, 'NOC', 0, 1700),
(230, 'IT Helpdesk', 0, 1700),
(240, 'Government Sales', 0, 1700),
(250, 'Retail Sales', 0, 1700),
(260, 'Recruiting', 0, 1700),
(270, 'Payroll', 0, 1700);

insert into locations values 
(1000, '1297 Via Cola di Rie', '989', 'Roma', NULL, 'IT'),
(1100, '93091 Calle della Te', '10934', 'Venice', NULL, 'IT'),
(1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefectu', 'JP'),
(1300, '9450 Kamiya-cho', '6823', 'Hiroshima', NULL, 'JP'),
(1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'),
(1500, '2011 Interiors Blvd', '99236', 'South San', 'California', 'US'),
(1600, '2007 Zagora St', '50090', 'South Brun', 'New Jersey', 'US'),
(1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US'),
(1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA'),
(1900, '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA'),
(2000, '40-5-12 Laogianggen', '190518', 'Beijing', NULL, 'CN'),
(2100, '1298 Vileparle (E)', '490231', 'Bombay', 'Maharashtra', 'IN'),
(2200, '12-98 Victoria Stree', '2901', 'Sydney', 'New South Wale', 'AU'),
(2300, '198 Clementi North', '540198', 'Singapore', NULL, 'SG'),
(2400, '8204 Arthur St', NULL, 'London', NULL, 'UK'),
(2500, 'Magdalen Centre, The', 'OX9 9ZB', 'Oxford', 'Oxford', 'UK'),
(2600, '9702 Chester Road', '9629850293', 'Stretford', 'Manchester', 'UK'),
(2700, 'Schwanthalerstr. 703', '80925', 'Munich', 'Bavaria', 'DE'),
(2800, 'Rua Frei Caneca 1360', '01307-002', 'Sao Paulo', 'Sao Paulo', 'BR'),
(2900, '20 Rue des Corps-Sai', '1730', 'Geneva', 'Geneve', 'CH'),
(3000, 'Murtenstrasse 921', '3095', 'Bern', 'BE', 'CH'),
(3100, 'Pieter Breughelstraa', '3029SK', 'Utrecht', 'Utrecht', 'NL'),
(3200, 'Mariano Escobedo 999', '11932', 'Mexico Cit', 'Distrito Feder', 'MX');


select e.first_name, e.last_name, e.job_id, e.department_id, d.department_name from employees e
join departments1 d on d.department_id = e.department_id
join locations l on d.location_id = l.location_id
where l.city = 'London';


