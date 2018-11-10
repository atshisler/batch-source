--2.0 SQL Queries
--2.1 SELECT
--returns all entries from employee table
select * from employee;
--return employess with a specified last name
select * from employee where LASTNAME = 'King';
--more specified select statement
select * from employee where firstname = 'Andrew' and reportsto is null;

--2.2 ORDER BY
--select album and order by title in descending order
select * from album order by title desc;
--selecting firstname and city from table and put rows in ascending order by city
select firstname, city from customer order by city asc;

--2.3 INSERT INTO
--simple insertion queries with proper respective data values
insert into genre values(26, 'Slow Rock');
insert into genre values(27, 'Spanish Guitar');

insert into employee values(9, 'Tran', 'Jonathan', 'IT Staff', 6, 
TO_DATE('3/9/1993', 'DD/MM/YYYY'), TO_DATE('8/10/2018', 'DD/MM/YYYY'), 
'777 Lucky Avenue', 'Houston', 'TX', 'USA', '77077', '+1 (832) 909-1234', 
'+1 (832) 909-1234', 'jhtran@uh.edu');
insert into employee values(10, 'Tran', 'Richard', 'IT Staff', 6, 
TO_DATE('3/11/1997', 'DD/MM/YYYY'), TO_DATE('12/12/2018', 'DD/MM/YYYY'), 
'777 Lucky Avenue', 'Houston', 'TX', 'USA', '77077', '+1 (832) 732-9345', 
'+1 (832) 909-1234', 'rhtran@uh.edu');

insert into customer values(60, 'Jonathan', 'Tran', 'Revature LLC.', '11730 America Plaza',
'Reston', 'VA', 'USA', '77777', '+1 (444) 444-4444', '+1 (111) 111-1111', 'jhtran@uh.edu', 3);
insert into customer values(61, 'Richard', 'Tran', 'Revature LLC.', '11730 America Plaza',
'Reston', 'VA', 'USA', '77777', '+1 (444) 444-4444', '+1 (111) 111-1111', 'rhtran@uh.edu', 3);

--2.4 UPDATE
--update query for names in customer table
update customer set firstname = 'Robert', lastname = 'Walter' 
where firstname = 'Aaron' and lastname = 'Mitchell';
--update query for artist name
update artist set name = 'CCR'
where name = 'Creedence Clearwater Revival';

--2.5 LIKE
--specify a query where billingaddress matches a pattern that starts with a T and anything after
select billingaddress from invoice where billingaddress like 'T%';

--3. SQL Functions
--3.1 System Defined Functions
--gets the length of each name by row in the name column
select length(name) from mediatype;

--3.2 System Defined Aggregate Functions
--gets the avg of the total column
select avg(total) from invoice;
--gets the highest unitprice 
select max(unitprice) from track;

--4.0 Stored Procedures
--4.1 Basic Store Procedure
--drops temp table
drop table temp_table; 
--create temp table for stored procedure
create table temp_table( 
    f_name varchar2(20), l_name varchar2(20)
);
--returns result set from select query into temp table
create or replace procedure get_employee_names 
as
begin
    insert into temp_table(f_name, l_name) select firstname, lastname from employee;
    commit;
end;
/
--invokes the stored procedure
begin
    get_employee_names();
end;
/
--return result set from stored procedure in temp table
select * from temp_table;

--4.2 Stored Procedure Input Parameters
--create a new procedure to update personal info
create or replace procedure update_employee_info(
ue_addr varchar2, ue_city varchar2, ue_state varchar2, ue_country varchar2, 
ue_postalcode varchar2, ue_phone varchar2, ue_email varchar2)
as
begin
    update employee 
    set address = ue_addr, city = ue_city, state = ue_state, country = ue_country,
    postalcode = ue_postalcode, phone = ue_phone, email = ue_email
    where employeeid = 3;
end;
/
--invoke the procedure with required params
begin
    update_employee_info('123 innovation ave', 'Inspire City', 'MyState', 'MyCountry',
    '77777', '123 456 7890', 'creative@email.com');
end;
/
--return result set of update to personal employee info
select * from employee where employeeid = 3;


--5.0 Transactions, nested within a stored procedure
--create new stored procedure for inserting a new employee into the employee table
create or replace procedure new_employee_entry(
e_id number, e_lname varchar2, e_fname varchar2, e_title varchar2, e_reportsto number,
e_birthdate date, e_hiredate date, e_addr varchar2, e_city varchar2, e_state varchar2,
e_country varchar2, e_zipcode varchar2, e_phone varchar2, e_fax varchar2, e_email varchar2)
as
begin
    insert into employee values(
    e_id, e_lname, e_fname, e_title, e_reportsto,
    e_birthdate, e_hiredate, e_addr, e_city, e_state,
    e_country, e_zipcode, e_phone, e_fax, e_email
    );
    commit;
end;
/
--invoke the stored procedure, change employeeid to (id + 1) to insert a new employee
begin
    new_employee_entry(
    9, 'Doe', 'John', 'IT Staff', 6,
    TO_DATE('3/11/1997', 'DD/MM/YYYY'), TO_DATE('12/12/2018', 'DD/MM/YYYY'), 
    '123 Innovation ave', 'Star City', 'Star State',
    'Star Country', '5T4R C0D3', '123 456 7890', '098 765 4321', 'star@email.com');
end;
/
--see newly inserted employee, change employeeid to (id + 1)
select * from employee where employeeid = 9;

--6.0 Triggers
--6.1 AFTER
--create new genre history table for trigger
create table genre_name_history (
    g_id number,
    g_name varchar2(20)
);
drop table genre_name_history;
--create trigger to happen before an update to the genre table
create or replace trigger genre_history_trigger 
after update of name 
on genre 
for each row 
begin 
insert into genre_name_history 
values(
    :old.genreid, 
    :old.name); 
END; 
/ 
--update genre table by setting new name on a genre id
update genre set name = 'Eminem' where genreid = 10;
--view genre name history
select * from genre_name_history;
--view changes to original genre table
select * from genre;

--7.0 Joins
--7.1 INNER
select firstname, lastname, invoiceid from customer
inner join invoice on customer.customerid = invoice.customerid;

--7.2 OUTER
select ct.customerid, ct.firstname, ct.lastname, 
it.invoiceid, it.total from customer ct
full outer join invoice it on ct.customerid = it.customerid;
