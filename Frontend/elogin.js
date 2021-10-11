const url = "http://localhost:8090/" 
document.getElementById("newticketButton").addEventListener("click", newticketFunc);
document.getElementById("LoginButton").addEventListener("click", Login);
document.getElementById("getTicketsButton").addEventListener("click", employeeTickets);


var uName;
var reimbAmount, Descr, status, type, author;


async function employeeTickets(tablechoice) {
 
        response = await fetch(url +  "tickets/employee?username=" + uName, {credentials: "include"});
        
    
        console.log(response);
    
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
    
               
                document.getElementById("ticketBody").appendChild(row);
    
            }
    
        }
    
    }
    


async function Login(){

    let usern = document.getElementById("username").value; 
    let userp = document.getElementById("password").value;

    let user = {
        username:usern,
        password:userp
    }

    uName= usern;
    console.log(user)

    let response = await fetch(url + "login", {

        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    });

    console.log(response.status); 
    if(response.status === 200){
        document.getElementById("login-row").innerText="Welcome!";
    } else {
        document.getElementById("login-row").innerText="Login failed! Do better."
    }

}


async function newticketFunc(){

    let reimbAmount = document.getElementById("reimburse").value;
    let desc = document.getElementById("description").value;
    var ticktypeselect = document.getElementById("ticketType");
    var chosentype = ticktypeselect.options[ticketType.selectedIndex].text;

    let response = await fetch(url +  "tickets/new?username=" + uName + 
                                        "&amount=" + reimbAmount +
                                         "&type=" + chosentype + 
                                         "&description=" + desc, 
                                         {credentials: "include",
                                         method: "POST"});
    
    
    document.getElementById("reimburse").value = "";
    document.getElementById("description").value = "";
    console.log(response.status);

}