// [1] click,load       : event
// [2] xhr function     : getEmployeeInfo
// [3] The use capture  : bubble or capture



//window.addEventListener('load', getEmployeesTableOne, false);
window.addEventListener('load', getCommunicationTableForm, false);
window.addEventListener('load', getEmployeesFormTableTwo, false);


// [B] Table 2 : Employee Form Info
function getEmployeesFormTableTwo(){	
	// [1] Create new xhr object 
	var xhr = new XMLHttpRequest();
	
	
	// [3] Open a request
	xhr.open("GET","/TRMS_EmployeeMoon/getEmployeesFormSession.json", true);
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
	
		msg2 += '<hr><b> Employee: Form Id:</b>' + 
		` <span class="c_emp-style"> ${ePerson[i].id} </span>
		  &nbsp   | &nbsp
		 <span class="c_emp-style c_emp-style-${ePerson[i].formId }">
		
		 <span href="#" 
		 
		 onclick="function loadValues()
		 
		 {
		 			//alert('Hi!')
		 			document.getElementById('i_formId').value = ${ePerson[i].id}
		 			document.getElementById('i_employeeId').value = ${ePerson[i].employeeId}
		 			document.getElementById('i_estimReimbursement').value = ${ePerson[i].estimatedReimbursement}
		 };
		 
		 						loadValues()">   
		 					<b>Full Name: </b> ${ePerson[i].firstName} ${ePerson[i].lastName} </span></span>
		
	  						&nbsp  | &nbsp
							<span class="c_emp-style" onclick='loadValues'> 
							 <b>Employee Id:</b> ${ePerson[i].employeeId}   </span>					
							 &nbsp  |  &nbsp 
							<b> Current Date:</b> ${new Date(ePerson[i].currDate).toLocaleString('en-US',{hour12:false}).split(", ")} 
							   &nbsp  |  &nbsp  
							   <b>Event Date:</b> ${new Date(ePerson[i].eventDate).toLocaleString('en-US',{hour12:false}).split(", ")} 
							   &nbsp  |  &nbsp  
							   <b>Event Time:</b> ${ePerson[i].eventTime} 
							   &nbsp  |  &nbsp 
							   Event Location:  ${ePerson[i].eventLocation} &nbsp  |  &nbsp 
							<b>Event Cost:</b> ${ePerson[i].eventCost} &nbsp  |  &nbsp  
							Event Type: ${ePerson[i].eventType} &nbsp  |  &nbsp 
							Description:  ${ePerson[i].description} &nbsp  |  &nbsp  
							<b>Grading Format:</b> ${ePerson[i].gradingFormat}  &nbsp  |  &nbsp 
								Work Related Justification: ${ePerson[i].workRelJust} &nbsp  |  &nbsp | 
								Event Attachments: ${ePerson[i].eventAttachment} &nbsp  |  &nbsp  
								Work Time Missed: ${ePerson[i].workTimeMissed} &nbsp  |  &nbsp  
								<b>Estimated Reimbursement:</b> ${ePerson[i].estimatedReimbursement}` + '<hr> ';
								
								
								
		console.log("emp_table.js : loadEmployeesFormTableTwo() Table 2 Length: i : " + i);
	
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
		
		
			
			//document.getElementById('i_formId').value = `${ePerson[i].formId}`;
			//document.getElementById('i_employeeId').value = `${ePerson[i].employeeId}`;
			//document.getElementById('i_estimReimbursement').value = `${ePerson[i].estimReimbursement}`;


		msg3 += '<p></p> <hr> <b>Employee</b> : ' + 
							   `<a href="#" class="c_blue-link"> <b>Form ID:</b> ${ePerson[i].formId}</a> &nbsp  |  &nbsp 
							    <a href="#" class="c_blue-link"><b>Employee ID:</b> ${ePerson[i].employeeId}</a>  &nbsp  |  &nbsp
							    <a href="#" class="c_blue-link"><b>Estimated Reimbursement:</b> ${ePerson[i].estimReimbursement}</a>  &nbsp  |  &nbsp 
								<a href="#" class="c_blue-link"><b>Need Additional Info</b>: ${ePerson[i].requestorNeedAdditionalInfoFrom}</a>  &nbsp  |  &nbsp 
								<a href="#" class="c_blue-link"><b>Requestee Response:</b> ${ePerson[i].requesteeResponse}</a>  &nbsp  |  &nbsp
								<a href="#" class="c_blue-link"><b>Altered Reimbursement:</b> ${ePerson[i].alterReimbursmentAmount}</a>  &nbsp  |  &nbsp
								<a href="#" class="c_blue-link">Reason For Altered Amount: ${ePerson[i].reasonForLargerAmount}</a>  &nbsp  |  &nbsp
								<a href="#" class="c_blue-link">Exceeding Available Funds: ${ePerson[i].exceedingAvailableFunds}</a>  &nbsp  |  &nbsp
								<a href="#" class="c_blue-link"><b>Pending Amount:</b> ${ePerson[i].pendingAmountVal}</a>  &nbsp  |  &nbsp
								<a href="#" class="c_blue-link">Notified Employee: ${ePerson[i].notifyEmployee}</a>  &nbsp  |  &nbsp
								<a href="#" class="c_blue-link"><b>Employee Option to Cancel:</b> ${ePerson[i].employeeOptionToCancel} &nbsp  |  &nbsp 
								<a href="#" class="c_blue-link"><b>Approval Status:</b> ${ePerson[i].approvalStatus}</a>   &nbsp  |  &nbsp
								<a href="#" class="c_blue-link"><b>Event Grade:</b> ${ePerson[i].eventGrade}</a>  &nbsp  |  &nbsp 
								<a href="#" class="c_blue-link">Event Presentation: ${ePerson[i].eventPresentation}</a>  &nbsp  |  &nbsp 
								<a href="#" class="c_blue-link"><b>Viewed Presentation(Management):</b> ${ePerson[i].mgmtViewPresent}</a>  &nbsp  |  &nbsp
								<a href="#" class="c_blue-link"><b>Approved Presentation(Direct Manager)</b>: ${ePerson[i].dirMgrApprPresent}</a>  &nbsp  |  &nbsp 
								<a href="#" class="c_blue-link">Grade Status(Direct Supervisor): ${ePerson[i].gradeStatusDirectSup}</a>  &nbsp  |  &nbsp 
								<a href="#" class="c_blue-link">Approval (Direct Supervisor): ${ePerson[i].directSupAppr}</a>  &nbsp  |  &nbsp
								<a href="#" class="c_blue-link">Approval (Department Head): ${ePerson[i].deptHeadAppr}</a>  &nbsp  |  &nbsp
								<a href="#" class="c_blue-link">Final Approval (BenCo): ${ePerson[i].bencoFinalAppr} </a> &nbsp  |  &nbsp 
								<a href="#" class="c_blue-link"><b>Marked Urgent:</b> ${ePerson[i].markedUrgent}</a>  
								
								<br><span class="c_trigger-msg"> Automatic Triggers if Delayed: </span> <br>
								<span class="c_red-trigger">
								Automatic Approval(Direct Supervisor): ${ePerson[i].automaticApprovDirectSup}</span> &nbsp  |  &nbsp
								<span class="c_red-trigger">Automatic Approval(Department Head): ${ePerson[i].automaticApprovDeptHead}</span> &nbsp  |  &nbsp 
								<span class="c_red-trigger">Escalation Emailed to Direct Supervisor: ${ePerson[i].escalationEmailDirectSup}</span> 
								</span><br>
								
								<b><a href="#" class="c_green-link">Final Reimbursement Value: $${ePerson[i].finalReimburseValBenco}</a> </b>`  + ' <hr>';
								
		console.log("emp_table.js : loadCommunicationTableForm() Table 3 Length: i : " + i);
	}
	document.getElementById("i_employee-table-three-info").innerHTML =  msg3;
	
	}

	// // [A] Table 1 - Employee Info
// function getEmployeesTableOne(){	
// 	// [1] Create new xhr object 
// 	var xhr = new XMLHttpRequest();
	
	
// 	// [3] Open a request
// 	xhr.open("GET","/TRMS_EmployeeMoon/getEmployeesSession.json", true);
// 	//xhr.open("GET",url, true);
// 	xhr.setRequestHeader("Content-Type", "application/json");


// 	// [2] Define onreadystatechange value
// 	xhr.onreadystatechange = function(){
// 		console.log("inside onreadystate");
// 		if(xhr.readyState == 4 && xhr.status == 200){
// 			let ePerson = JSON.parse(xhr.responseText); //context
// 			console.log("ePerson: " + JSON.parse(xhr.responseText));
// 			loadEmployeesTableOne(ePerson);
// 		}
// 	}
	
// 	// [4] Send request
// 	xhr.send();
// }
// function loadEmployeesTableOne(ePerson){
// 	let tableLength = ePerson.length;
// 	let msg1 = '';
// 	console.log("emp_table.js : loadEmployeesTableOne(): " + ePerson.length);
// 	for(let i = 0; i < tableLength; i++){
		
		
// 		msg1 += 'Employee :' + `${ePerson[i].empId} | ${ePerson[i].firstName} ${ePerson[i].lastName} | ${ePerson[i].username} | ${ePerson[i].password} | ${ePerson[i].address} | ${ePerson[i].email} | ${ePerson[i].phone}` + '<br />';
// 		console.log("emp_table.js : loadEmployeesTableOne() Table 1 : i : " + i);
// 	}
// 	document.getElementById("i_employee-table-one-info").innerHTML = msg1;
// }
