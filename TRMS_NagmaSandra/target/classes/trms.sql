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

create table approvers( --customer object table
aid serial primary key, --Sets primary key
a_role int,  --role [1-5]
a_username varchar(30),
a_password varchar(30)
);

select * from approvers;

insert into approvers (aid, a_role, a_username, a_password) values
(1,1, 'benco', 'password'),
(2,2, 'dirsup', 'password'),
(3,3, 'dirhead', 'password'),
(4,4, 'mgmt', 'password'),
(5,5, 'dirmgmt', 'password');

select * from approvers;

--update approvers
--set a_usernmame='admin',
--a_password='benco', 
--where aid=1;



