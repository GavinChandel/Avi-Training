CREATE TABLE ActorDirector(actor_id int, director_id int, timestamp int PRIMARY KEY NOT NULL);
INSERT INTO actordirector values (1,1,0),(1,1,1),(1,1,2),(1,2,3),(1,2,4),(2,1,5),(2,1,6);

SELECT actor_id, director_id FROM ActorDirector GROUP BY actor_id, director_id HAVING COUNT(*) >= 3;


