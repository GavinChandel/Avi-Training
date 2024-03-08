CREATE TABLE Person (
    PersonId INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50)
);

CREATE TABLE Address (
    AddressId INT PRIMARY KEY,
    PersonId INT,
    City VARCHAR(50),
    State VARCHAR(50),
    FOREIGN KEY (PersonId) REFERENCES Person(PersonId)
);

INSERT INTO Person VALUES (1, 'John', 'Doe'),(2,'Jane', 'Smith'),(3,'Michael', 'Johnson'),(4,'Daniel','Flores');
INSERT INTO address VALUES(100, 1, 'New Delhi','Delhi'),(101,2,'Chandigarh','Haryana'),(103,4,'Jaipur','Rajasthan');

SELECT p.FirstName, p.LastName, a.City, a.State FROM Person p LEFT JOIN Address a ON p.PersonId = a.PersonId;