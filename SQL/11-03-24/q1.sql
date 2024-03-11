use chandelgavin1;
show tables;

create table Playback(session_id int primary key, customer_id int, start_time int, end_time int);
create table Ads(ad_id int primary key, customer_id int, timestamp int);

insert into playback values(1,1,1,5),(2,1,15,23),(3,2,10,12),(4,2,17,28),(5,2,2,8);
insert into ads values(1,1,5),(2,2,17),(3,2,20);

select session_id from playback where session_id not in (select distinct p.session_id from playback p join ads a on p.customer_id=a.customer_id and a.timestamp
between p.start_time and p.end_time);
