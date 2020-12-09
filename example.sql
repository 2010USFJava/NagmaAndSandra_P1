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
values (default, 'empuser', 'emppass', 'Empfirst', 'Emplast', 'afnesdk', 'srlfnksr', 'srgf');

create table event_form --table 2
(
	form_id serial primary key,
	employee_id int, --foreign key
	event_id int,
	curr_date date, --system or local date
	curr_time time, --system or local date
	event_date date,
	event_location varchar(40),
	event_id int,
	event_cost numeric,
	description varchar(40),
	grading_format varchar(40),	
	wrjust varchar(40),
	event_attachments bytea,
	work_time_missed varchar(40),
	estim_reimbursement numeric,
	foreign key (employee_id) references employee_table
);

--approval for tution reimbursment
--request addtitional information from 2 approvers/ employees
--change the amount of tution reimbursment
--notify employee of tution change or any approvals etc


--(NAGMA)
---------
--cancel request after notification of tution reimbursment amount and notify approver


--third table|
-------------|
--benco

--form id (foreign key)
--employee id (foreign key)
-- estim_reimbursement --> from event_form (calculated estimated reimbursement value)


-- requestor_need_additional_info_from [employee, dirsup, depthead] [3.1 good] (OPTIONAL)
-- requestee_response [3.2 good] (OPTIONAL)


-- [1] Department Head
-- [2] Direct Supervisor
-- [3] Benco 


-- PROCESS 1(benco)
-- alter_reimbursment amount [4.1 good]
-- reason_for_larger amount (varchar --- reason for approval) [5.3 good]
-- exceeding available funds (yes/no) [5.2 good]
-- pending_amount_val (until i get a grade/presentation)
-- notify_employee [4.2 good]


-- employee_option_to_cancel [4.3 good]
-- approval_status (pending/denied/awaiting response)

-- (nagma) event_grade(varchar) --> value no upload
-- (nagma) event_presentation(opt. upload)

--(mgmt & dirmgmt)
-- mgmt_view_present [yes or no]
-- dirmgr_appr_present [yes or no)


-- PROCESS 2
-- grade_status_deptsup(pass/fail) 
-- deptsup_appr (denied/approved)
-- depthead_appr (denied/approved)
-- benco_final_appr (denied/approved)
-- final_reimburse_val_benco [amount]


-- TRIGGERS 1
-- escalation_email_dirsup [6.1]  (if benco does approve on time)
-- automatic_approv_direct_sup [yes/no]
-- automatic_approv_direct_head [yes/no]


--fourth table
-- employee id
-- available balance