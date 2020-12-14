  
function getEmployees(){	
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
			loadEmployees(ePerson);
		}
	}
	
	console.log("status : " + xhr.status);
	
	// [4] Send request
	xhr.send();
}

function loadEmployees(ePerson){
	document.getElementById("i_employee_info").innerHTML = 
	
	ePerson[1].empId
	+ " " + 
	ePerson[1].firstName
	+ " " + 
	ePerson[1].lastName
	+ " " + 
	ePerson[1].username;
	+ " " + 
	ePerson[1].password;
	+ " " + 
	ePerson[1].address
	+ " " + 
	ePerson[1].email
	
	+ " " + 
	
	ePerson[1].phone;
}

window.addEventListener('load', getEmployees, false);
    // [1] click,load       : event
    // [2] xhr function     : getEmployeeInfo
    // [3] The use capture  : bubble or capture
    //