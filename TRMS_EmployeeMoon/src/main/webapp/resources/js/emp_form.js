function getEmployee() {

 	console.log("employee.html ready");
 		// [1] Create new xhr object 
		var xhr = new XMLHttpRequest();
	
	
		// [3] Open a request
		xhr.open("GET","/TRMS_EmployeeMoon/getOneEmployee.json", true);
		//xhr.open("GET",url, true);
		xhr.setRequestHeader("Content-Type", "application/json");


		// [2] Define onreadystatechange value
		xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let ePerson = JSON.parse(xhr.responseText); //context
			console.log("ePerson: " + JSON.parse(xhr.responseText));
			alterForm(ePerson);
			}
		}
	
	    console.log("status : " + xhr.status);
	
	    // [4] Send request
	    xhr.send();
    }

function alterForm(ePerson) {

	document.getElementById("firstName").value = ePerson.firstName;
	document.getElementById("lastName").value = ePerson.lastName;
	document.getElementById("employeeId").value = ePerson.empId;
};

function eventFunction(){
  
    var e = document.getElementById("eventType").value;
    var eCost = document.getElementById("eventCost").value; //event cost --user input
    var reimburs;
   
     switch (e) {
       case "200":
           reimburs = parseFloat((eCost * .80)).toFixed(2);   
           document.getElementById("estimatedReimbursement").value = reimburs;
            break;
       case "201":
        reimburs = parseFloat((eCost * .60)).toFixed(2);   
        document.getElementById("estimatedReimbursement").value = reimburs;          
           break;
       case "202":
        reimburs = parseFloat((eCost * .75)).toFixed(2);   
        document.getElementById("estimatedReimbursement").value = reimburs;
           break;
       case "203":
        reimburs = parseFloat((eCost)).toFixed(2);   
        document.getElementById("estimatedReimbursement").value = reimburs;   
           break;
       case "204":
        reimburs = parseFloat((eCost * .90)).toFixed(2);   
        document.getElementById("estimatedReimbursement").value = reimburs;
           break;
       case "205":
        reimburs = parseFloat((eCost * .30)).toFixed(2);   
        document.getElementById("estimatedReimbursement").value = reimburs;
           break;
       default:
        document.getElementById("estimatedReimbursement").value = "choose an event type";
        console.log("Error caught calculating reimbursement amount in form.js");
     }   
   }
   
   window.addEventListener('load', getEmployee, false);