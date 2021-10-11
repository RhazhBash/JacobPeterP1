const url = "http://localhost:8090/" //putting our base URL in a variable for cleaner code below
//eventually we'll use this in our fetch requests and make calls to the server by appending endpoints

//add functionality to our buttons using a eventlisteners
//so when these buttons gets clicked, the appropriate function will be called
document.getElementById("getTicketsButton").addEventListener("click", ticketsFunc);
document.getElementById("getOpenTicketsButton").addEventListener("click", statustable = 1, ticketsFunc);
document.getElementById("getDeniedTicketsButton").addEventListener("click", statustable = 2);
document.getElementById("getAcceptedTicketsButton").addEventListener("click", statustable = 3);

document.getElementById("loginButton").addEventListener("click", loginFunc);
document.getElementById("newticketButton").addEventListener("click", newticketFunc);



var statustable;


var uName;
var reimbAmount, Descr, status, type, author;



async function ticketsFunc() { //async returns a promise (which fetch returns)

    //we will send a fetch request to get our avenger data
    //we need to include {credentials: "include"} in order to make use of the user's cookie
        console.log(uName);
        console.log(statustable);
    let response = await fetch(url +  "tickets/active/employee?username=" + uName);

    //console.log(response);

    if(response.status === 200) { //if the request comes back successful...

        let data = await response.json(); //get the JSON data, turn it into a JS object

        //For every Ticket object we get back, put it in the table
        for(let ticket of data){
            console.log(ticket);
            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = ticket.TID; //fill the cell with the appropriate avenger data
            row.appendChild(cell); //add the td element (cell) to the tr element (row)

            //then we do this ^ for every field in the avenger model
            let cell2 = document.createElement("td"); 
            cell2.innerHTML = ticket.Amount; 
            row.appendChild(cell2);

            let cell3 = document.createElement("td"); 
            cell3.innerHTML = ticket.Submitted; 
            row.appendChild(cell3);

            let cell4 = document.createElement("td"); 
            cell4.innerHTML = ticket.Resolved; 
            row.appendChild(cell4);

            let cell5 = document.createElement("td"); 
            cell5.innerHTML = ticket.Description; 
            row.appendChild(cell5);

            let cell6 = document.createElement("td"); 
            cell6.innerHTML = ticket.Author; 
            row.appendChild(cell6);

            let cell7 = document.createElement("td"); 
            cell7.innerHTML = ticket.Resolver; 
            row.appendChild(cell7);

            let cell8 = document.createElement("td"); 
            cell8.innerHTML = ticket.Status; 
            row.appendChild(cell8);

            let cell9 = document.createElement("td"); 
            cell9.innerHTML = ticket.Type; 
            row.appendChild(cell9);

            // let cell7 = document.createElement("td"); 
            // //this would return the entire home object so we look only for the homeName
            // cell7.innerHTML = avenger.home_fk.home_name; 
            // row.appendChild(cell7);

            //the tr called row that we created in the for loop gets appended to the table body
            //a new row will be appended for ever Avenger object that comes in
            document.getElementById("ticketBody").appendChild(row);

        }

    }

}






//login functionality below-----------------

//this function will send the user-inputted login credentials to our server
async function loginFunc(){

    //gather the user input from the login inputs
    let usern = document.getElementById("username").value; 
    let userp = document.getElementById("password").value;

    //we want to send the user/pass as JSON, so we need to make a JS object to send
    let user = {
        username:usern,
        password:userp
    }

    uName= usern;
    console.log(user)

    //Now I'm going to set up my fetch request to the server
    //Remember the second parameter fetch() can take?
    //It's essentially a configuration object! the settings of our fetch request
    //if you don't include it, it'll send a GET request by default
    let response = await fetch(url + "login", {

        method: "POST", //send a POST request
        body: JSON.stringify(user), //turn our Javascript into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured
        //future fetches will also require this "include" value to send the cookie back
    });

    console.log(response.status); //useful for debug :)

    //control flow based on success or failed login
    if(response.status === 200){
        //wipe our login row and welcome the user
        document.getElementById("login-row").innerText="Welcome!";

    } else {
        document.getElementById("login-row").innerText="Login failed! Do better."
    }

}



async function newticketFunc(){

    //gather the user input from the login inputs
   // let usern = document.getElementById("username").value; 
   // let userp = document.getElementById("password").value;
    let reimbAmount = document.getElementById("reimburse").value;
    let desc = document.getElementById("description").value;
    //let status = document.getElementById("status").value;
    //let type = document.getElementById("tickettype").text;


    var ticktypeselect = document.getElementById("ticketType");
    var chosentype = ticktypeselect.options[ticketType.selectedIndex].text;

    console.log(reimbAmount);
    console.log(desc);
    console.log(chosentype)

// var reimbAmount, Descr, status, type, author
//     //we want to send the user/pass as JSON, so we need to make a JS object to send
//     let newtick = {
//         username:usern,
//         password:userp
//     }

//     uName= usern;
//     console.log(user)

//     //Now I'm going to set up my fetch request to the server
//     //Remember the second parameter fetch() can take?
//     //It's essentially a configuration object! the settings of our fetch request
//     //if you don't include it, it'll send a GET request by default
//     let response = await fetch(url + "login", {

//         method: "POST", //send a POST request
//         body: {"Amount":<Money requested>, "Description":"<User inputed message>", "Status":"0", "Type":"<Chosen from 4 options>", "Author":{"id":<Employee ID>}}

//         //body: JSON.stringify(user), //turn our Javascript into JSON
//         //credentials: "include"
//         //this last line will ensure that the cookie is captured
//         //future fetches will also require this "include" value to send the cookie back
//     });

//     console.log(response.status); //useful for debug :)

//     //control flow based on success or failed login
//     if(response.status === 200){
//         //wipe our login row and welcome the user
//         document.getElementById("login-row").innerText="Welcome!";

//     } else {
//         document.getElementById("login-row").innerText="Login failed! Do better."
//     }

}