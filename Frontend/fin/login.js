const url = "http://localhost:8090/" 


//document.getElementById("getTicketsButton").addEventListener("click", ticketsFunc);
//document.getElementById("loginButton").addEventListener("click", employeeLogin);
document.getElementById("mLoginButton").addEventListener("click", managerLogin);
//document.getElementById("getTicketsButton").addEventListener("click", ticketsFunc);


var uName;
var reimbAmount, Descr, status, type, author;
var checkbox=document.getElementById("showactive");


async function ticketsFunc(tablechoice) {

        console.log("test");
        console.log(tablechoice);
  
    if (tablechoice == 1) {
        response = await fetch(url +  "tickets", {credentials: "include"});
    }
    
    if (tablechoice == 2) {
        response = await fetch(url +  "tickets/active", {credentials: "include"});
    }

    if(response.status === 200) { 

        let data = await response.json(); 

        for(let ticket of data){
            console.log(ticket);
            let row = document.createElement("tr");

            let cell = document.createElement("td"); 
            cell.innerHTML = ticket.TID; 
            row.appendChild(cell); 


            let cell2 = document.createElement("td"); 
            cell2.innerHTML = ticket.Amount; 
            row.appendChild(cell2);

            let cell3 = document.createElement("td"); 
            cell3.innerHTML = ticket.Submitted; 
            row.appendChild(cell3);

            if(ticket.Status!=0) {
                let cell4 = document.createElement("td"); 
                cell4.innerHTML = ticket.Resolved; 
                row.appendChild(cell4);
            }
            else {
                let cell4 = document.createElement("td"); 
                cell4.innerHTML = "Pending"; 
                row.appendChild(cell4);
            }

            let cell5 = document.createElement("td"); 
            cell5.innerHTML = ticket.Description; 
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = ((ticket.Author).fName + " " + (ticket.Author).lName);
            row.appendChild(cell6);

            if(ticket.Status!=0) {
                let cell7 = document.createElement("td");
                cell7.innerHTML = ((ticket.Resolver).fName + " " + (ticket.Resolver).lName);
                row.appendChild(cell7);
            }
            else {
                let cell7 = document.createElement("td");
                cell7.innerHTML = "Pending";
                row.appendChild(cell7);
            }

            if (ticket.Status == 0) {
                let cell8 = document.createElement("td");
                cell8.innerHTML = "Pending review";
                row.appendChild(cell8);
            }
            else if(ticket.Status == 1) {
                let cell8 = document.createElement("td");
                cell8.innerHTML = "Approved";
                row.appendChild(cell8);
            }
            else if(ticket.Status == -1) {
                let cell8 = document.createElement("td");
                cell8.innerHTML = "Denied";
                row.appendChild(cell8);
            }
        
            let cell9 = document.createElement("td");
            cell9.innerHTML = ticket.Type;
            row.appendChild(cell9);

            let button = document.createElement("td");
            button.innerHTML = "approve";
            row.appendChild(button);
            button.id ="approvalButton";
            button.onclick=function(){
                approveButton(ticket.TID);};


            let button2 = document.createElement("td");
            button2.innerHTML = "Reject";
            row.appendChild(button2);
            button2.id ="rejectionButton";
            button2.onclick=function(){
                rejectButton(ticket.TID);};            


            document.getElementById("ticketBody").appendChild(row);

        }

    }

}    

async function approveButton(ID){
    console.log("The accepted  TID is: " + ID);
      let request = {
          username:uName,
          TID:ID
      }
      let response = await fetch(url + "tickets/approve?username=" + uName +"&TID=" + ID, {

        method: "POST",
        credentials: "include"
        
    });
    console.log(response);
    alert("Ticket #" + ID + " approved!");
}

async function rejectButton(ID){
    console.log("The rejected TID is: " + ID);

    let request = {
        username:uName,
        TID:ID
    }
    let response = await fetch(url + "tickets/deny?username=" + uName +"&TID=" + ID, {

      method: "POST",
      credentials: "include"
      
  });
  console.log(response);
  alert("Ticket #" + ID + " rejected!");

}

async function managerLogin(){

    let usern = document.getElementById("username").value; 
    let userp = document.getElementById("password").value;
    let user = {
        username:usern,
        password:userp
    }

    uName= usern;
    console.log(user)

    //mlogin endpoint only allows managers to login
    let response = await fetch(url + "mlogin", {

        method: "POST", 
        body: JSON.stringify(user), 
        credentials: "include"
    });

    if(response.status === 200){
        document.getElementById("login-row").innerText="Welcome!";
    } else {
        document.getElementById("login-row").innerText="Login failed! Do better."
    }

}