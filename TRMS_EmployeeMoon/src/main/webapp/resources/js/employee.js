	function getEmployee() {
 	 
 	$("h1").hide();

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
			loadEmployee(ePerson);
			}
		}
	
	    console.log("status : " + xhr.status);
	
	    // [4] Send request
	    xhr.send();
    }

    function loadEmployee(ePerson) {
    	console.log(ePerson.empId);
    	
        $("#empinfo").empty();


            let div = $("<div>").addClass("column");
            let h3 = $("<h3>").attr("id", "infoHeader").text("Welcome, " + ePerson.firstName);
            let div2 = $("<div>").addClass("column");
            let table = $("<table>").addClass("table");
            let tr1 = $("<tr>").attr("id", "empFName");
            let th1 = $("<td>").text("First Name: " + ePerson.firstName);
            let tr2 = $("<tr>").attr("id", "empLName");
            let th2 = $("<td>").text("Last Name: " + ePerson.lastName);
            let tr3 = $("<tr>").attr("id", "empID");
            let th3 = $("<td>").text("Employee ID: " + ePerson.empId);
            let tr4 = $("<tr>").attr("id", "address");
            let th4 = $("<td>").text("Address: " + ePerson.address);
            let tr5 = $("<tr>").attr("id", "email");
            let th5 = $("<td>").text("Email Address: " + ePerson.email);
            let tr6 = $("<tr>").attr("id", "phone");
            let th6 = $("<td>").text("Phone Number: " + ePerson.phone);
			let tr7 = $("<tr>").attr("id", "balance");
			let th7 = $("<td>").attr("id", "ebal");

            div.append(h3);
            div.append(div2);
            div2.append(table);
            table.append(tr1);
            table.append(th1);
            table.append(tr2);
            table.append(th2);
            table.append(tr3);
            table.append(th3);
            table.append(tr4);
            table.append(th4);
            table.append(tr5);
            table.append(th5);
            table.append(tr6);
            table.append(th6);
			table.append(tr7);
			table.append(th7);

            $("#empinfo").append(div);

        };

function getBal() {
 	 
 	$("h1").hide();

 	console.log("employee.html ready");
 		// [1] Create new xhr object 
		var xhr = new XMLHttpRequest();
	
	
		// [3] Open a request
		xhr.open("GET","/TRMS_EmployeeMoon/getBalById.json", true);
		//xhr.open("GET",url, true);
		xhr.setRequestHeader("Content-Type", "application/json");


		// [2] Define onreadystatechange value
		xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let eBal = JSON.parse(xhr.responseText); //context
			console.log("eBal: " + JSON.parse(xhr.responseText));
			loadEmployeeBal(eBal);
			}
		}
	
	    console.log("status : " + xhr.status);
	
	    // [4] Send request
	    xhr.send();
    }
function loadEmployeeBal(eBal){
	console.log(eBal);
		$("#ebal").text("Available Tuition Reimbursement: $" + eBal.availBal);
}
    
    window.addEventListener('load', getEmployee, false);
	window.addEventListener('load', getBal, false);