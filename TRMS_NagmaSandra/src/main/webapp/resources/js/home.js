/**
 * 
 */

  
window.onload=function(){
	console.log("window");
	getEmployee();
}

function getEmployee(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		console.log("the ready state has changed");
		if(xhttp.readyState==4 && xhttp.status==200){
			let e1 = JSON.parse(xhttp.responseText);
			console.log(e1);
		}
	}
	xhttp.open("GET","http://localhost:8080/TRMS_NagmaSandra/getsession.json");
	
	xhttp.send();
}