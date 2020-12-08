create table employees (
	empId int primary key,
	username varchar(30) unique not null,
	password varchar(30) not null,
	firstName varchar(30) not null,
	lastName varchar(30) not null,
	address varchar(50) not null,
	email varchar(30) not null,
	phone varchar(20) not null,
	balance numeric(100,2) not null
);

insert into employees 
values (1, 'empuser', 'emppass', 'Empfirst', 'Emplast', 'afnesdk', 'srlfnksr', 'srgf', 1000.00);