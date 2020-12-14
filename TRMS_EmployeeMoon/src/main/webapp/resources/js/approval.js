// RETURNS THE TYPE OF APPROVER

window.addEventListener('load', getApproval, false)

function getApproval(){	
	// [1] Create new xhr object 
	var xhr = new XMLHttpRequest();
	
	
	// [3] Open a request
	xhr.open("GET","/TRMS_EmployeeMoon/getApproverSession.json", true);
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

			// Read role out to the screen update2]
			
			if(document.getElementById('i_benco')){
				document.getElementById('i_benco').innerHTML = 'Benefits Coordinator';
			}
			if(document.getElementById('i_dirsup')){
				document.getElementById('i_dirsup').innerHTML = 'Direct Supervisor';
			}
			if(document.getElementById('i_dirhead')){
				document.getElementById('i_dirhead').innerHTML = 'Direct Head';
			}
			if(document.getElementById('i_dirmgmt')){
				document.getElementById('i_dirmgmt').innerHTML = 'Direct Manager';
			}
			if(document.getElementById('i_mgmt')){
				document.getElementById('i_mgmt').innerHTML = 'Management';
			}
		}	


//window.addEventListener('load', getApproval, false);
    // [1] click,load       : event
     // [2] xhr function     : getApproval
    // [3] The use capture  : bubble or capture
    //







