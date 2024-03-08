CREATE TABLE scorecard(Id int, Score float);
desc scorecard;
INSERT INTO scorecard values (1,3.50),(2,3.65),(3,4.00),(4,3.85),(5,4.00),(6,3.65);
SELECT Score, RANK() OVER (ORDER BY Score DESC) AS Rankings FROM scorecard;
