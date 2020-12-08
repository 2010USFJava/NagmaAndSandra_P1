--Create Table employee
create table employee_table
(
	employee_id serial primary key,
	email varchar(40) not null unique,
	e_password varchar(40) not null,
	fname varchar(40) not null, 
	lName varchar (40) not null,
	deparment int,
	employee_role int not null
);

--insert values
insert into employee_table values(default,'pmaurer@bpt.net', 'password', 'Petra', 'Maurer', 1, 1);
insert into employee_table values(default,'bolayiwola@bpt.net', 'password', 'Busayomi', 'Olayiwola', 1, 1);
insert into employee_table values(default,'kMatt@bpt.net', 'password', 'Matt', 'Knighten', 2, 1);
insert into employee_table values(default,'amaurer@bpt.net', 'password', 'Arwen', 'Maurer', 2, 2);
insert into employee_table values(default,'molayiwola@bpt.net', 'password', 'Michelle', 'Olayiwola', 1, 2);
insert into employee_table values (default,'nmaurer@bpt.net', 'password', 'Nicholas', 'Maurer', 1, 3);
insert into employee_table values (default,'solayiwola@bpt.net', 'password', 'Solomon', 'Olayiwola', 2, 3);
insert into employee_table values (default, 'tmaurer@bpt.net', 'password', 'Tyler', 'Maurer', 3, 3);
insert into employee_table values (default,'smaurer@bpt.net', 'password', 'Scarlett', 'Maurer', null, 4);
insert into employee_table values (default,'polayiwola@bpt.net', 'password', 'Precious', 'Olayiwola', null, 5);

--Create Table department look up
create table departments
(
	dept_id serial primary key,
	department varchar(30) not null
);

--insert department values
insert into departments values(default,'technology');
insert into departments values(default,'administrative');
insert into deparments values(default, 'maintenance');

--Create Table job type look up
create table roles
(
	job_id serial primary key,
	role_name varchar(30) not null
);

--insert role values
insert into roles values(default,'Employee');
insert into roles values(default,'Department Supervisor');
insert into roles values(default,'Department Head');
insert into roles values(default, 'Benefit Coordinator');
insert into roles values(default, 'Benefit Coordinator Supervisor');

---------------------------------------------------------------------

--Create Table approval
create table approval
(
	approval_id serial primary key,
	status varchar(30) not null
);

--insert approval values
insert into approval values(default,'pending');
insert into approval values(default,'approved');
insert into approval values(default,'denied');


--Create Table event_type
--eac- employee amount coverage
create table event_type
(
	e_id serial primary key,
	event_name varchar(40) not null,
	eac numeric	
);

insert into event_type values (default,'University Course', .80);
insert into event_type values (default,'Seminars', .60);
insert into event_type values (default,'Certification Preparation Classes', .75);
insert into event_type values (default,'Certification', 1);
insert into event_type values (default,'Techical Training', .90);
insert into event_type values (default,'Other', .30);

--Create Table event_form
--event start date esdate
--event type id etid
--work related justification wrjust
--type of approval??????
--current date c_date
create table event_form
(
	form_id serial primary key,
	employee_id int not null,
	dept_id int not null,
	c_date date not null,
	c_time time not null,
	e_date date nut noll,
	eventlocation varchar(40) not null,
	description varchar(40) not null,
	event_cost numeric not null,
	grading_format varchar(40) not null,
	et_id int not null,
	wrjust text,
	event_attachments bytea,
	work_time_missed text,
	estim_reimbursement numeric,
	status_type text,
	sup_approval text,
	head_approval text,
	benco_approval text
	foreign key (employee_id) references employee_table on delete cascade
);

select username,  
from app_user 
join study_set 
on app_user.user_id =  study_set.owner_id
where app_user.user_id = 5;

create table employees (
employee_id SERIAL,
first_name varchar,
last_name varchar,
supervisor_id integer,
department_id integer,
PRIMARY KEY(employee_id)
);

create view supervisors
    as
    select distinct super.*
    from employees super, employees sub
    where sub.supervisor_id=super.employee_id;


create view supervisor_sub_relations
    as
    select supervisors.employee_id sup_id, employees.employee_id sub_id
    from employees
    inner join supervisors
    on supervisors.employee_id=employees.supervisor_id;



