drop table reimbursementTable;
drop table employeeTable;


create table employeeTable
(
E_ID NUMBER PRIMARY KEY NOT NULL,
E_USERNAME VARCHAR2(20) NOT NULL,
E_PASSWORD VARCHAR2(20) NOT NULL,
E_FIRSTNAME VARCHAR2(20) NOT NULL,
E_LASTNAME VARCHAR2(20) NOT NULL,
E_EMAIL VARCHAR2(20) NOT NULL,
E_TITLE VARCHAR2(20) NOT NULL
);

create table reimbursementTable(
E_ID NUMBER NOT NULL,
R_ID NUMBER NOT NULL PRIMARY KEY,
R_AMOUNT DECIMAL (10, 2),
R_STATUS VARCHAR2(20)
);
alter table reimbursementTable
add constraint E_ID
FOREIGN KEY(E_ID) REFERENCES employeeTable(E_ID);

drop sequence sequence_R;   
CREATE SEQUENCE sequence_R
start with 0
increment by 1
minvalue 0
maxvalue 1000
cycle;

commit;

insert into employeeTable(E_ID, E_USERNAME, E_PASSWORD, E_FIRSTNAME, E_LASTNAME, E_EMAIL, E_TITLE) values(0, 'TestEmployee', 'password', 'Test', 'Tester', 'test@testmail.com', 'Employee'); 
insert into employeeTable(E_ID, E_USERNAME, E_PASSWORD, E_FIRSTNAME, E_LASTNAME, E_EMAIL, E_TITLE) values(1, 'Superman', 'Cans', 'Clark', 'Kent', 'kryptonite@gmail.com', 'Employee'); 
insert into employeeTable(E_ID, E_USERNAME, E_PASSWORD, E_FIRSTNAME, E_LASTNAME, E_EMAIL, E_TITLE) values(2, 'G-Man', 'Freeman', 'Michael', 'Shapiro', 'halflife@gmail.com', 'Manager'); 
insert into employeeTable(E_ID, E_USERNAME, E_PASSWORD, E_FIRSTNAME, E_LASTNAME, E_EMAIL, E_TITLE) values(3, 'Freeman', 'Ravenholm', 'Gordon', 'Freeman', 'freeman@gmail.com', 'Physicist'); 
insert into employeeTable(E_ID, E_USERNAME, E_PASSWORD, E_FIRSTNAME, E_LASTNAME, E_EMAIL, E_TITLE) values(4, 'zz', 'Ravenholm', 'Gordon', 'Freeman', 'freeman@gmail.com', 'Physicist'); 

insert into employeeTable(E_ID, E_USERNAME, E_PASSWORD, E_FIRSTNAME, E_LASTNAME, E_EMAIL, E_TITLE, E_DESCRP) values(5, 'TheWall', 'shield', 'Havel', 'Junior', 'wall@gmail.com', 'Knight', 'Will protect you'); 
insert into employeeTable(E_ID, E_USERNAME, E_PASSWORD, E_FIRSTNAME, E_LASTNAME, E_EMAIL, E_TITLE, E_DESCRP) values(6, 'TheWall2', 'shield', 'Havel2', 'Junior', 'wall2@gmail.com', 'Manager', 'Will protect you'); 

update employeeTable set E_TITLE = 'Reporter' where E_ID = 1;

alter Table employeeTable add E_DESCRP varchar2(60);

update employeeTable set E_DESCRP = 'Likes dogs.';  

update employeeTable set E_USERNAME = 'ComplexFlips.' where E_ID = 0;

commit;
select * from employeeTable;

select * from reimbursementTable;
