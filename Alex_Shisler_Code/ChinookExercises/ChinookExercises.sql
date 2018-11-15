GRANT connect to chinook;
GRANT resource to chinook;
GRANT create session TO chinook;
GRANT create table TO chinook;
GRANT create view TO chinook;
conn chinook/p4ssw0rd

--2.1 Select
select * from Employee;

select * from Employee where LastName = 'King';

select * from Employee where FirstName = 'Andrew' AND REPORTSTO = null;

-- 2.2 OrderBy

select * from Album ORDER BY TITLE DESC;

select firstname from customer order by city;

--2.3 Insert Into
conn chinook/p4ssw0rd
insert into GENRE (GENREID, Name) values(26, 'Power Metal');
insert into GENRE (GENREID, NAME) values(27, 'Memes');


insert into Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) values (9, 'Numbo', 'Felix', 'ITSTAFF', TO_DATE('1992-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2015-10-24 00:00:00','yyyy-mm-dd hh24:mi:ss'), '7777 Boulevard Road', 'York', 'PA', 'United States', '19382', '+1 (484) 383-7122', '1 (780) 736-9923)', 'numbo@chinookcorp.com');
conn chinook/p4ssw0rd
insert into Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) values (10, 'Numbo', 'Jumbo', 'ITSTAFF', TO_DATE('1992-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2015-10-24 00:00:00','yyyy-mm-dd hh24:mi:ss'), '7777 Boulevard Road', 'York', 'PA', 'United States', '19382', '+1 (484) 383-7122', '1 (780) 736-9923)', 'numbo2@chinookcorp.com');

conn chinook/p4ssw0rd
select * from Customer;
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60, 'Simmons', 'Jean', 'Cities Co', '21 Jump Street', 'San Francisco', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (61, 'Simmons2', 'Jean2', 'Cities Co', '21 Jump Street', 'San Francisco', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);

--2.4 Update        

conn chinook/p4ssw0rd   

UPDATE Customer
SET LastName = 'Walter', FirstName = 'Robert' WHERE LastName = 'Mitchell' and FirstName = 'Aaron';

Update Artist
SET Name = 'CCR' WHERE Name = 'Creedence Clearwater Revival';

select * from Artist;

--2.5

select * from Invoice where BILLINGADDRESS like 'T%';



