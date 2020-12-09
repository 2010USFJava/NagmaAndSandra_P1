/*
 * TRMS Employee Database Creation Script
 * Schemas : trms 
 * Tables  : employee, employee_form, & approvers
 *
 */
--create sequence mySeq;

create schema if not exists trms authorization root; --creates scheme trms
set search_path to trms;

--drop table approvers;
drop table employees;



  
create table employees (
	empId serial primary key,
	username varchar(30) unique not null,
	password varchar(30) not null,
	firstName varchar(30) not null,
	lastName varchar(30) not null,
	address varchar(50) not null,
	email varchar(30) not null,
	phone varchar(20) not null
);

create table approvers( --customer object table
aid serial primary key, --Sets primary key
a_role int,  --role [1-5]
a_username varchar(30),
a_password varchar(30)
);

select * from employees;
select * from approvers;

insert into approvers (aid, a_role, a_username, a_password) values
(1,1, 'benco', 'password'),
(2,2, 'dirsup', 'password'),
(3,3, 'dirhead', 'password'),
(4,4, 'mgmt', 'password'),
(5,5, 'dirmgmt', 'password');


insert into employees values 
(default, 'empuser', 'emppass', 'Empfirst', 'Emplast', 'afnesdk', 'srlfnksr', 'srgf'),
(default, 'sandy', 'password', 'sandra', 'omoruyi', '555 moon blvd', 'somoruyi@icloud.com', '555-555-5555');


select * from employees;
select * from approvers;


--update approvers
--set a_usernmame='admin',
--a_password='benco', 
--where aid=1;

--select * from approvers where a_username='benco';
--select * from approvers;



