use chandelgavin1;
create table views(article_id int, author_id int, viewer_id int, view_date date);

insert into views values(1,3,5,'2019-08-01'),(3,4,5,'2019-08-01'),(1,3,6,'2019-08-02'),(2,7,7,'2019-08-01'),(2,7,6,'2019-08-02'),(4,7,1,'2019-07-22'),(3,4,4,'2019-07-21'),(3,4,4,'2019-07-21');
select distinct viewer_id as id from Views group by viewer_id, view_date having count(distinct article_id) > 1 order by id;