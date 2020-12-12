function getAllFormsByEmp() {

 	console.log("form table request");
 		// [1] Create new xhr object 
		var xhr = new XMLHttpRequest();
	
	
		// [3] Open a request
		xhr.open("GET","/TRMS_EmployeeMoon/getAllFormsByEmp.json", true);
		//xhr.open("GET",url, true);
		xhr.setRequestHeader("Content-Type", "application/json");


		// [2] Define onreadystatechange value
		xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let eForms = JSON.parse(xhr.responseText); //context
			console.log("eForms: " + JSON.parse(xhr.responseText));
			loadForms(eForms);
			}
		}
	
	    console.log("status : " + xhr.status);
	
	    // [4] Send request
	    xhr.send();
    }

function loadForms(eForms) {
	
	$("#i_reimburse_info").empty();
	for (var i = 0; i < eForms.length; i++) { 
		
		var currDate = new Date(eForms[i].currDate).toLocaleString('en-US',{hour12:false}).split(", ");
		var eventDate = new Date(eForms[i].eventDate).toLocaleString('en-US',{hour12:false}).split(", ");
		var time = eForms[i].eventTime + ":00";
		const eventTime = new Date('1970-01-01T' + time + 'Z')
  .toLocaleTimeString({},
    {timeZone:'UTC',hour12:true,hour:'numeric',minute:'numeric'}
  );

		console.log(currDate[0]);
		console.log(eventDate[0]);
		console.log(eventTime);
		
		var id = eForms[i].id;
		getStatus(id);


            let div = $("<div>").addClass("column").attr("id", "formbox");
            let h3 = $("<h3>").attr("id", "i_infoHeader").text("Form Information");
            let div2 = $("<div>").addClass("callout");
            let table = $("<table>").addClass("table");
            let tr1 = $("<tr>").attr("id", "i_form_id");
            let th1 = $("<td>").text("Form ID: " + eForms[i].id);
            let tr2 = $("<tr>").attr("id", "i_submit_date");
            let th2 = $("<td>").text("Date Submitted: " + currDate[0]);
			let tr3 = $("<tr>").attr("id", "i_event_date");
            let th3 = $("<td>").text("Event Date: " + eventDate[0]);
            let tr4 = $("<tr>").attr("id", "i_event_time");
            let th4 = $("<td>").text("Event Time: " + eventTime);
            let tr5 = $("<tr>").attr("id", "i_event_loc");
            let th5 = $("<td>").text("Event Location: " + eForms[i].eventLocation);
            let tr6 = $("<tr>").attr("id", "i_event_cost");
            let th6 = $("<td>").text("Event Cost: $" + eForms[i].eventCost);
            let tr7 = $("<tr>").attr("id", "i_event_type");
            let th7 = $("<td>").text("Event Type: " + eForms[i].eventType);
			let tr8 = $("<tr>").attr("id", "i_description");
            let th8 = $("<td>").text("Event Description: " + eForms[i].description);
			let tr9 = $("<tr>").attr("id", "i_grading_format");
            let th9 = $("<td>").text("Grading Format: " + eForms[i].gradingFormat);
			let tr10 = $("<tr>").attr("id", "i_work_rel_just");
            let th10 = $("<td>").text("Work Related Justification: " + eForms[i].workRelJust);
			let tr11 = $("<tr>").attr("id", "i_event_attachment");
            let th11 = $("<td>").text("Event Attachment: " + eForms[i].eventAttachment);
			let tr12 = $("<tr>").attr("id", "i_work_time_missed");
            let th12 = $("<td>").text("Work Time Missed: " + eForms[i].workTimeMissed);
			let tr13 = $("<tr>").attr("id", "i_est_reimburse");
            let th13 = $("<td>").text("Projected Reimbursement: $" + eForms[i].estimatedReimbursement);
			//let button = $("<input>").attr("type", "Submit").attr("value", "View Status");
			//var button = $("<button>").attr("id", "status").attr("value", "submit").click(getStatus(id)).text("View Status").bind('onclick', getStatus, false);
			let br = $("<br>");
			let hr = $("<hr>")
			let div3 = $("<div>").addClass("column");
			
		
		
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
			table.append(tr8);
            table.append(th8);
			table.append(tr9);
            table.append(th9);
			table.append(tr10);
            table.append(th10);
			if(eForms[i].eventAttachment != ""){
				
				table.append(tr11);
				table.append(th11);
			}
			table.append(tr12);
            table.append(th12);
			table.append(tr13);
            table.append(th13);

            $("#i_reimburse_info").append(div);
	}

	function getStatus(id) {
		console.log("comm table request");
 		// [1] Create new xhr object 
		var xhr = new XMLHttpRequest();
	
	
		// [3] Open a request
		xhr.open("GET","/TRMS_EmployeeMoon/getCommuncationTableSession.json", true);
		//xhr.open("GET",url, true);
		xhr.setRequestHeader("Content-Type", "application/json");


		// [2] Define onreadystatechange value
		xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let eStatus = JSON.parse(xhr.responseText); //context
			console.log("eStatus: " + JSON.parse(xhr.responseText));
			selectStatus(eStatus);
			console.log(eStatus[0].formId);
			}
		}
	
	    console.log("status : " + xhr.status);
	
	    // [4] Send request
	    xhr.send();
    }

	function selectStatus(eStatus) {
		for (var i = 0; i < eStatus.length; i++) { 
		}
};


}

   
  	window.addEventListener('load', getAllFormsByEmp, false);