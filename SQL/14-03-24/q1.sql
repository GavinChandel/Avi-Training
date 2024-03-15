use chandelgavin;

create table locations(location_id int primary key, street_address varchar(60), postal_code varchar(30), city varchar(30), state_province varchar(30), country_id varchar(5));
create table countries(country_id varchar(5), country_name varchar(30), region_id int);

INSERT INTO locations VALUES
    (1000, '1297 Via Cola di Rie', '989', 'Roma', NULL, 'IT'),
    (1100, '93091 Calle della Te', '10934', 'Venice', NULL, 'IT'),
    (1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP'),
    (1300, '9450 Kamiya-cho', '6823', 'Hiroshima', NULL, 'JP'),
    (1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'),
    (1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US'),
    (1600, '2007 Zagora St', '50090', 'South Brunswick', 'New Jersey', 'US'),
    (1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US'),
    (1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA'),
    (1900, '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA'),
    (2000, '40-5-12 Laogianggen', '190518', 'Beijing', NULL, 'CN'),
    (2100, '1298 Vileparle (E)', '490231', 'Bombay', 'Maharashtra', 'IN'),
    (2200, '12-98 Victoria Stree', '2901', 'Sydney', 'New South Wales', 'AU'),
    (2300, '198 Clementi North', '540198', 'Singapore', NULL, 'SG'),
    (2400, '8204 Arthur St', NULL, 'London', NULL, 'UK'),
    (2500, 'Magdalen Centre, The', 'OX9 9ZB', 'Oxford', 'Oxford', 'UK'),
    (2600, '9702 Chester Road', '9629850293', 'Stretford', 'Manchester', 'UK'),
    (2700, 'Schwanthalerstr. 703', '80925', 'Munich', 'Bavaria', 'DE'),
    (2800, 'Rua Frei Caneca 1360', '01307-002', 'Sao Paulo', 'Sao Paulo', 'BR'),
    (2900, '20 Rue des Corps-Sai', '1730', 'Geneva', 'Geneve', 'CH'),
    (3000, 'Murtenstrasse 921', '3095', 'Bern', 'BE', 'CH'),
    (3100, 'Pieter Breughelstraa', '3029SK', 'Utrecht', 'Utrecht', 'NL');
    
    INSERT INTO countries VALUES
    ('IT', 'Italy', 1),
    ('JP', 'Japan', 3),
    ('US', 'United States of America', 2),
    ('CA', 'Canada', 2),
    ('CN', 'China', 3),
    ('IN', 'India', 3),
    ('AU', 'Australia', 3),
    ('SG', 'Singapore', 3),
    ('UK', 'United Kingdom', 1),
    ('DE', 'Germany', 1),
    ('BR', 'Brazil', 2),
    ('CH', 'Switzerland', 1),
    ('NL', 'Netherlands', 1);
    
    SELECT 
    l.location_id,
    l.street_address,
    l.city,
    l.state_province,
    c.country_name
FROM 
    locations l
JOIN 
    countries c ON l.country_id = c.country_id;


