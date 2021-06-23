use mydb;
select * from account;

create table account (
accno int not null primary key, lastname varchar(20), firstname varchar(20), bal int
);

drop table account;

