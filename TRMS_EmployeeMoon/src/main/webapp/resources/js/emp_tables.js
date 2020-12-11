// [1] click,load       : event
// [2] xhr function     : getEmployeeInfo
// [3] The use capture  : bubble or capture



window.addEventListener('load', getEmployeesTableOne, false);
window.addEventListener('load', getEmployeesFormTableTwo, false);
window.addEventListener('load', getCommunicationTableForm, false);


// [A] Table 1 - Employee Info
function getEmployeesTableOne(){	
	// [1] Create new xhr object 
	var xhr = new XMLHttpRequest();
	
	
	// [3] Open a request
	xhr.open("GET","/TRMS_EmployeeMoon/getEmployeesSession.json", true);
	//xhr.open("GET",url, true);
	xhr.setRequestHeader("Content-Type", "application/json");


	// [2] Define onreadystatechange value
	xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let ePerson = JSON.parse(xhr.responseText); //context
			console.log("ePerson: " + JSON.parse(xhr.responseText));
			loadEmployeesTableOne(ePerson);
		}
	}
	
	// [4] Send request
	xhr.send();
}
function loadEmployeesTableOne(ePerson){
	let tableLength = ePerson.length;
	let msg1 = '';
	console.log("emp_table.js : loadEmployeesTableOne(): " + ePerson.length);
	for(let i = 0; i < tableLength; i++){
		
		
		msg1 += 'Employee :' + `${ePerson[i].empId} | ${ePerson[i].firstName} ${ePerson[i].lastName} | ${ePerson[i].username} | ${ePerson[i].password} | ${ePerson[i].address} | ${ePerson[i].email} | ${ePerson[i].phone}` + '<br />';
		console.log("emp_table.js : loadEmployeesTableOne() Table 1 : i : " + i);
	}
	document.getElementById("i_employee-table-one-info").innerHTML = msg1;
	

}


// [B] Table 2 : Employee Form Info
function getEmployeesFormTableTwo(){	
	// [1] Create new xhr object 
	var xhr = new XMLHttpRequest();
	
	
	// [3] Open a request
	xhr.open("GET","/TRMS_EmployeeMoon/getEmployeesFormSession.json", true);
	//xhr.open("GET",url, true);
	xhr.setRequestHeader("Content-Type", "application/json");


	// [2] Define onreadystatechange value
	xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let ePerson = JSON.parse(xhr.responseText); //context
			console.log("ePerson: " + JSON.parse(xhr.responseText));
			loadEmployeesFormTableTwo(ePerson);
		}
	}
	
	// [4] Send request
	xhr.send();
}
function loadEmployeesFormTableTwo(ePerson){
	let tableLength = ePerson.length;
	let msg2 = '';
	console.log("emp_table.js : loadEmployeesFormTableTwo(): " + ePerson.length);
	for(let i = 0; i < tableLength; i++){
		
		
		msg2 += ' Employee : ' + '<a href="#">' + 
								`${ePerson[i].id} | ${ePerson[i].firstName} ${ePerson[i].lastName} | ${ePerson[i].employeeId} | 
								${ePerson[i].currDate} | ${ePerson[i].eventDate} | ${ePerson[i].eventTime} | ${ePerson[i].eventLocation} |
								${ePerson[i].eventCost} | ${ePerson[i].eventType} | ${ePerson[i].description} | ${ePerson[i].gradingFormat}  |
								${ePerson[i].workRelJust} | ${ePerson[i].eventAttachment} | ${ePerson[i].workTimeMissed} | ${ePerson[i].estimatedReimbursement}` +  '</a>' + '<br />';
		console.log("emp_table.js : loadEmployeesFormTableTwo() Table 2 Lenght: i : " + i);
	}
	document.getElementById("i_employee-table-two-info").innerHTML =  msg2;
	
}
	
	// [C] Table 3 : Communication Table
function getCommunicationTableForm(){	
	// [1] Create new xhr object 
	var xhr = new XMLHttpRequest();
	
	
	// [3] Open a request
	xhr.open("GET", "/TRMS_EmployeeMoon/getCommuncationTableSession.json", true);
	xhr.setRequestHeader("Content-Type", "application/json");


	// [2] Define onreadystatechange value
	xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let ePerson = JSON.parse(xhr.responseText); //context
			console.log("ePerson: " + JSON.parse(xhr.responseText));
			loadCommunicationTableForm(ePerson);
		}
	}
	
	// [4] Send request
	xhr.send();
}

function loadCommunicationTableForm(ePerson){
	let tableLength = ePerson.length;
	let msg3 = '';
	console.log("emp_table.js : loadCommunicationTableForm()  Table 3 Length: " + ePerson.length);
	for(let i = 0; i < tableLength; i++){
		
		msg3 += ' Employee : ' + '<a href="#">' + 
							   `${ePerson[i].formId} | 
							    ${ePerson[i].employeeId} 
							    ${ePerson[i].estimReimbursement} | 
								${ePerson[i].requestorNeedAdditionalInfoFrom} | 
								${ePerson[i].requesteeResponse} | 
								${ePerson[i].alterReimbursmentAmount} | 
								${ePerson[i].reasonForLargerAmount} | 
								${ePerson[i].exceedingAvailableFunds} |
								${ePerson[i].pendingAmountVal} | 
								${ePerson[i].notifyEmployee} | 
								${ePerson[i].employeeOptionToCancel} | 
								${ePerson[i].approvalStatus}  |
								${ePerson[i].eventGrade} | 
								${ePerson[i].eventPresentation} | 
								${ePerson[i].mgmtViewPresent} | 
								${ePerson[i].dirMgrApprPresent} | 
								${ePerson[i].gradeStatusDirectSup} | 
								${ePerson[i].directSupAppr} | 
								${ePerson[i].deptHeadAppr} | 
								${ePerson[i].bencoFinalAppr} | 
								${ePerson[i].finalReimburseValBenco} |
								${ePerson[i].escalationEmailDirectSup} | 
								${ePerson[i].automaticApprovDirectSup} | 
								${ePerson[i].automaticApprovDeptHead} | 
								${ePerson[i].markedUrgent}` +  '</a>' + '<br />';
								
		console.log("emp_table.js : loadCommunicationTableForm() Table 3 Length: i : " + i);
	}
	document.getElementById("i_employee-table-three-info").innerHTML =  msg3;
	
	}

