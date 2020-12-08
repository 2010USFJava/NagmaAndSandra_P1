var btn = document.getElementById("login");


btn.addEventListener("click",function(){
    // AJAX call...if it worked

    //step 1
    var xhr = new XMLHttpRequest();

    //step 3
    xhr.open('GET', 
    'java2010usf.cjf5o99zxvgi.us-east-2.rds.amazonaws.com:5432/postgres');

    myRequest.onload = function(){
        var ourData = JSON.parse(myRequest.responseText);
    };

//step 4
xhr.send();
})

 //Step 2
 //xhr.onreadystatechange= function(){
   // console.log("in ORSC");
    //if(xhr.readyState==4&&xhr.status==200){
      //  console.log(xhr.responseText);
        //var pokemon = JSON.parse(xhr.responseText);

        //loadPokemon(pokemon);
    //}
//}
//Step 3
//xhr.open("GET","https://pokeapi.co/api/v2/pokemon/"+pokemonID,true);
//Step 4
//xhr.send();
