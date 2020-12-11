
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

const form = document.querySelector('#reimbursementForm');


// listen for submit even
form.addEventListener('submit', () => {
    // TODO: submit post request here
   /* var x = document.getElementById("reimbursementForm");
    var text = "";
    var i;
    for (i = 0; i < x.length ;i++) {
      text += x.elements[i].value + "<br>";
    }
    document.getElementById("demo").innerHTML = text;*/
});

form.addEventListener('submit', (event) => {

    // disable default action
    event.preventDefault();

    // configure a request Step 1
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/TRMS_EmployeeMoon/employeeform');

    // prepare form data
    let data = new FormData(form);

    // set headers
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');

    // send request step 4
    xhr.send(data);

    // listen for `load` event
    xhr.onload = () => {
        console.log(xhr.responseText);
    }
    
});

   /*function submitForm()
   {
    var x = document.getElementById("reimbursementForm");
    var text = "";
    var i;
    for (i = 0; i < x.length ;i++) {
      text += x.elements[i].value + "<br>";
    }
    document.getElementById("demo").innerHTML = text;
   }*/

   //other example
   const getBtn = document.getElementById('get-btn');
   const postBtn = document.getElementById('post-btn');

   const getData = () => {
       const xhr = new XMLHttpRequest();

       xhr.open('GET', 'https://reqres.in/api/users');

       //set response type to to already parse the resonse below
       xhr.responseType = 'json'

       //regular function or arrow
       xhr.onload = () =>{
           
        //parse json data to raw javascript data
          // const data = JSON.parse();

          //instead use this as refernced above to have 
          //already parsed data
          const data = xhr.response;

           console.log(xhr.response);
       }


       xhr.send();
   };

   const sendData = () => {};

   getBtn.addEventListener('click', getData);
   postBtn.addEventListener('click', sendData)
   