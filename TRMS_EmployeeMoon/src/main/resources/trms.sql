create schema if not exists trms authorization root; --creates scheme trms
set search_path to trms;

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


insert into employees 
values (default, 'ljames', '23hart', 'Lebron', 'James', '1992 Hart Country Lane, Atlanta, GA, 30308', 'lebronjames@gmail.com', '404-906-8775');

create table event_form
(
	form_id serial primary key not null,
	firstName varchar(40) not null,
	lastName varchar(40) not null,
	empId int not null,
	curr_date date not null,
	event_date date not null,
	event_time varchar(10) not null,
	event_location varchar(40) not null,
	event_cost numeric(100,2) not null,
	event_type varchar(40) not null,
	description varchar(40) not null,
	grading_format varchar(40) not null,	
	wrjust varchar(40),
	event_attachments varchar(40),
	work_time_missed varchar(40) not null,
	estim_reimbursement numeric not null,
	foreign key (empId) references employees(empId) on delete cascade
);

create table approvers( --customer object table
aid serial primary key, --Sets primary key
a_role int,  --role [1-5]
a_username varchar(30),
a_password varchar(30)
);

select * from communication_table;

create table communication_table( --customer object table
form_id int unique, --comes from table 2 position 1
employee_id int,  --comes from table 2 position 4
estim_reimbursement double precision, --comes from table 2 position 16
-- BENCO JOB
requestor_need_additional_info_from varchar(50), --(employee/dirsup/directhead) (OPTIONAL)
requestee_response varchar(50), --(OPTIONAL), --NAGMA replies
alter_reimbursment_amount double precision, --NAGMA pulls
reason_for_larger_amount varchar(50),
exceeding_available_funds varchar(20), 
pending_amount_val double precision, --NAGMA pulls
notify_employee varchar(20), --(yes/no) 
employee_option_to_cancel varchar(20), --(yes/no) --NAGMA replies
approval_status varchar(20), --(pending/denied/awaiting_response) --NAGMA pulls
event_grade varchar(20), --(A/B/C/D/F) --NAGMA replies
event_presentation varchar(50), --(opt. upload) --NAGMA replies
-- (mgmt & dirmgmt) JOB
mgmt_view_present varchar(20), --(yes/no) 
dir_mgr_appr_present varchar(20),  --(yes/no) 
-- PROCESS 2 (All 3 Approvals)
grade_status_direct_sup varchar(20),   --(pass/fail) 
direct_sup_appr varchar(20), --(denied/approved)
dept_head_appr varchar(20),  --(denied/approved)
benco_final_appr varchar(20),  --(denied/approved) --NAGMA pulls
final_reimburse_val_benco double precision, -- Store in 4th table position 2 --NAGMA pulls from here
-- TRIGGERS 1 (READ ONLY VALUE)
escalation_email_direct_sup varchar(20), --(yes/no) (if benco does not approve in 2 weeks)
automatic_approv_direct_sup varchar(20), --(yes/no)
automatic_approv_dept_head  varchar(20), --(yes/no)
marked_urgent varchar(20),--(yes/no)
foreign key (employee_id) references employees(empId),
foreign key (form_id ) references event_form(form_id)
);

insert into approvers (aid, a_role, a_username, a_password) values
(1,1, 'benco', 'password'),
(2,2, 'dirsup', 'password'),
(3,3, 'dirhead', 'password'),
(4,4, 'mgmt', 'password'),
(5,5, 'dirmgmt', 'password');

create table balanceinfo(
	empId int not null,
	initalBal numeric(100,2) not null,
	availBal numeric(100,2) not null,
	foreign key (empId) references employees(empId)
);

insert into balanceinfo
values (8, 1000, 1000);