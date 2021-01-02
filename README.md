# EmployeeMoon Tuition Reimbursement Management System

### Overview
The purpose of the Tuition Reimbursement Management System(TRMS) is to provide a system that encourages quality knowledge growth relevant to an individual’s expertise. The
new TRMS design will incorporate:
- Back-End: Java, PostgreSQL, and Servlet, etc
- Front-End: HTML, CSS, JavaScript, AJAX, and etc

This project also incorporates cookies, which was not one of the required technologies.

### Project Setup
- Clone this repository to your machine.
- Set up your database in Amazon RDS through the AWS website.
- Save the endpoint connection(url), the username, and the password used to set up your database.
- Add these values into the database.properties file.
- Set up a connection in DBeaver using the url to establish a connection.
- Make sure you have Apache Tomcat version 9.0 installed.
- Run the trms.sql file to create a new schema and create new tables.
- Run the TRMS_EmployeeMoon project in Spring Tool Suite and the console application is ready for you to use. Make sure to add the project to the server.
- Start the server.
- Go to http://localhost:8080/TRMS_EmployeeMoon/home
- Login with the credentials below or create your own employee credentials in the database.

### Login
    
- You can add employee's to the system by adding them to the database.
- Example employee login credentials:
```sh
username: dtdeal
password: burke
```
- Approver Login creditionals:
```sh
benco/password
dirsup/password
dirhead/password
mgmt/password
dirmgmt/password
```

### Business Requirements
- Each employee is allowed to claim up to $1000.00 in tuition reimbursement per
year.
- The amount available to an employee is reset on the new year.
- Event types have different standard reimbursement coverage.
- After a BenCo has approved a reimbursement, the reimbursement is "pending"
until a passing grade or presentation over the event is provided.
- Employees must complete the Tuition Reimbursement form and the form must collect required information: basic employee information, date, time, location, description, cost, grading format (grade or presentation), event type, work-related justification, work time that will be missed, projected reimbursement, and optionally event-related attachments.

### Technologies

- Java 1.8
- Servlets
- JDBC
- PL/SQL
- HTML
- CSS
- Javascript
- Bootstrap (optional)
- AJAX
- JUnit
- log4j 
- Tomcat Server
- PostgreSQL 12
- Eclipse/Spring Tools Suite
- DBeaver
- [Trello](https://trello.com/invite/b/o0HT6j4K/e746baecb5c84d154bf12b81bef08b1c/agile-sprint-board)
