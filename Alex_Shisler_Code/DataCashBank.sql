drop table accountInfo;
drop table userInfo;


--login info username, first name, last name, password, isAccessible role?
--bank transactions balance, deposits, withdrawals 

create table userInfo
(
U_ID NUMBER NOT NULL,
B_USERNAME VARCHAR2(20) NOT NULL,
B_PASSWORD VARCHAR2(20) NOT NULL,
B_FIRSTNAME VARCHAR(20) NOT NULL,
B_LASTNAME VARCHAR(20) NOT NULL,
B_ROLE VARCHAR2(5) NOT NULL,
isAccessible varchar2(1) NOT NULL, 
CONSTRAINT PK_BCUSTOMER PRIMARY KEY (U_ID)
);

create table accountInfo
(
B_ID NUMBER PRIMARY KEY NOT NULL,
U_ID NUMBER NOT NULL,
B_BALANCE DECIMAL(10, 2) NOT NULL,
B_WITHDRAWAL DECIMAL (10, 2),
B_DEPOSIT DECIMAL (10, 2)
);
--B_USERNAME FOREIGN KEY REFERENCES bankcustomer(B_USERNAME)
alter table accountInfo 
add constraint U_ID 
FOREIGN KEY (U_ID) REFERENCES userInfo(U_ID);
commit;
--Testing

insert into userInfo(U_ID, B_USERNAME, B_PASSWORD, B_FIRSTNAME, B_LASTNAME, B_ROLE, isAccessible) values(0, 'Anon', 'password', 'Todd', 'Howard', 'user', 'y'); 
insert into accountInfo(B_ID, U_ID, B_BALANCE, B_WITHDRAWAL, B_DEPOSIT) values (0, 0, 500000.00, 0.00, 0.00);

--(B_ID, B_FIRSTNAME, B_LASTNAME, B_USERNAME, B_PASSWORD, B_BALANCE,)
insert into userInfo(U_ID, B_USERNAME, B_PASSWORD, B_FIRSTNAME, B_LASTNAME, B_ROLE, isAccessible) values(1, 'Dante', 'lightscameraction', 'Hideki', 'Kamiya', 'admin', 'y'); 
insert into accountInfo(B_ID, U_ID, B_BALANCE, B_WITHDRAWAL, B_DEPOSIT) values (1, 1, 250000.00, 0.00, 0.00);

insert into userInfo(U_ID, B_USERNAME, B_PASSWORD, B_FIRSTNAME, B_LASTNAME, B_ROLE, isAccessible) values(2, 'Shinji', 'getintheeva', 'Hideaki', 'Anno', 'admin', 'y'); 
insert into accountInfo(B_ID, U_ID, B_BALANCE, B_WITHDRAWAL, B_DEPOSIT) values (2, 2, 650000.00, 0.00, 0.00);


insert into userInfo(U_ID, B_USERNAME, B_PASSWORD, B_FIRSTNAME, B_LASTNAME, B_ROLE, isAccessible) values(3, 'Yusuke', 'hiatus7', 'Yoshihiro', 'Togashi', 'admin', 'y'); 
insert into accountInfo(B_ID, U_ID, B_BALANCE, B_WITHDRAWAL, B_DEPOSIT) values (3, 3, 9000000.00, 0.00, 0.00);

insert into userInfo(U_ID, B_USERNAME, B_PASSWORD, B_FIRSTNAME, B_LASTNAME, B_ROLE, isAccessible) values(4, 'Fabletastic', 'bees', 'David', 'Cage', 'admin', 'y'); 
insert into accountInfo(B_ID, U_ID, B_BALANCE, B_WITHDRAWAL, B_DEPOSIT) values (4, 4, 7500000.00, 0.00, 0.00);


drop sequence sequence_1;
CREATE SEQUENCE sequence_1
start with 5
increment by 1
minvalue 0
maxvalue 600
cycle;

select * from userInfo;
select * from accountInfo;
select * from userInfo ORDER BY U_ID;
select * from accountInfo ORDER BY U_ID;
select * from userInfo  JOIN accountInfo on userInfo.U_ID = accountInfo.U_ID;


commit;