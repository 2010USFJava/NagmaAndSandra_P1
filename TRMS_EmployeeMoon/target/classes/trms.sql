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
--drop table employees;
  
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

insert into approvers (aid, a_role, a_username, a_password) values
(1,1, 'benco', 'password'),
(2,2, 'dirsup', 'password'),
(3,3, 'dirhead', 'password'),
(4,4, 'mgmt', 'password'),
(5,5, 'dirmgmt', 'password');


select * from employees;
select * from approvers;

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


create table communication_table( --customer object table
form_id int, --comes from table 2 position 1
employee_id int,  --comes from table 2 position 4
estim_reimbursement double precision, --comes from table 2 position 16
-- BENCO JOB
requestor_need_additional_info_from varchar(50), --(employee/dirsup/directhead) (OPTIONAL)
requestee_response varchar(50), --(OPTIONAL), --NAGMA replies
alter_reimbursment_amount double precision, --NAGMA pulls
reason_for_larger_amount varchar(50),
exceeding_available_funds varchar(10), 
pending_amount_val double precision, --NAGMA pulls
notify_employee varchar(10), --(yes/no) 
employee_option_to_cancel varchar(10), --(yes/no) --NAGMA replies
approval_status varchar(10), --(pending/denied/awaiting_response) --NAGMA pulls
event_grade varchar(10), --(A/B/C/D/F) --NAGMA replies
event_presentation varchar(50), --(opt. upload) --NAGMA replies
-- (mgmt & dirmgmt) JOB
mgmt_view_present varchar(10), --(yes/no) 
dir_mgr_appr_present varchar(10),  --(yes/no) 
-- PROCESS 2 (All 3 Approvals)
grade_status_direct_sup varchar(10),   --(pass/fail) 
direct_sup_appr varchar(10), --(denied/approved)
dept_head_appr varchar(10),  --(denied/approved)
benco_final_appr varchar(10),  --(denied/approved) --NAGMA pulls
final_reimburse_val_benco double precision, -- Store in 4th table position 2 --NAGMA pulls from here
-- TRIGGERS 1 (READ ONLY VALUE)
escalation_email_direct_sup varchar(10), --(yes/no) (if benco does not approve in 2 weeks)
automatic_approv_direct_sup varchar(10), --(yes/no)
automatic_approv_dept_head  varchar(10), --(yes/no)
marked_urgent varchar(10),--(yes/no)
foreign key (employee_id) references employees(empId),
foreign key (form_id ) references event_form(form_id)
);




