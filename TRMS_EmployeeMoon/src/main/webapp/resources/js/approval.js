function getApproval(){	
	// [1] Create new xhr object 
	var xhr = new XMLHttpRequest();
	
	
	// [3] Open a request
	xhr.open("GET","/TRMS_EmployeeMoon/getApproverSession.json", true);
	//xhr.open("GET",url, true);
	xhr.setRequestHeader("Content-Type", "application/json");


	// [2] Define onreadystatechange value
	xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let aPerson = JSON.parse(xhr.responseText); //context
			console.log("aPerson: " + JSON.parse(xhr.responseText));
			loadApprover(aPerson);
		}
	}
	
	console.log("status : " + xhr.status);
	
	// [4] Send request
	xhr.send();
}

function loadApprover(aPerson){
    document.getElementById("i_approver").innerHTML = aPerson.username;
   
}

window.addEventListener('load', getApproval, false);
    // [1] click,load       : event
     // [2] xhr function     : getApproval
    // [3] The use capture  : bubble or capture
    //






