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

insert into communication_table values 
(1, 2, 200.0, 
'employee', 'n/a', 200.0, 'n/a', 'no',
200.0, 'yes', 'n/a', 'pending', 'n/a', 
'n/a', 'yes', 'yes', 'pass', 'approved', 
'approved', 'approved', 200.0,
'no', 'no', 'no', 'no'
);
--(default, 'sandy', 'password', 'sandra', 'omoruyi', '555 moon blvd', 'somoruyi@icloud.com', '555-555-5555');


select * from communication_table;

create table communication_table( --customer object table
form_id int, --comes from table 2 position 1 --[1]
employee_id int,  --comes from table 2 position 4 --[2]
estim_reimbursement double precision, --comes from table 2 position 16 --[3]
-- BENCO JOB
requestor_need_additional_info_from varchar(50), --(employee/dirsup/directhead) (OPTIONAL) --[4]
requestee_response varchar(50), --(OPTIONAL), --NAGMA replies --[5]
alter_reimbursment_amount double precision, --NAGMA pulls --[6]
reason_for_larger_amount varchar(50), --[7]
exceeding_available_funds varchar(10), --(yes/no) --[8]
pending_amount_val double precision, --NAGMA pulls --[9]
notify_employee varchar(10), --(yes/no) --[10]
employee_option_to_cancel varchar(10), --(yes/no) --NAGMA replies --[11]
approval_status varchar(10), --(pending/denied/awaiting_response) --NAGMA pulls --[12]
event_grade varchar(10), --(A/B/C/D/F) --NAGMA replies --[13]
event_presentation varchar(50), --(opt. upload) --NAGMA replies --[14]
-- (mgmt & dirmgmt) JOB
mgmt_view_present varchar(10), --(yes/no)  --[15]
dir_mgr_appr_present varchar(10),  --(yes/no)  --[16]
-- PROCESS 2 (All 3 Approvals)
grade_status_direct_sup varchar(10),   --(pass/fail)  --[17]
direct_sup_appr varchar(10), --(denied/approved) --[18]
dept_head_appr varchar(10),  --(denied/approved) --[19]
benco_final_appr varchar(10),  --(denied/approved) --NAGMA pulls --[20]
final_reimburse_val_benco double precision, -- Store in 4th table position 2 --NAGMA pulls from here --[21]
-- TRIGGERS 1 (READ ONLY VALUE)
escalation_email_direct_sup varchar(10), --(yes/no) (if benco does not approve in 2 weeks) --[22]
automatic_approv_direct_sup varchar(10), --(yes/no) --[23]
automatic_approv_dept_head  varchar(10), --(yes/no) --[24]
marked_urgent varchar(10),--(yes/no) --[25]
foreign key (employee_id) references employees(empId),
foreign key (form_id ) references event_form(form_id)
);




