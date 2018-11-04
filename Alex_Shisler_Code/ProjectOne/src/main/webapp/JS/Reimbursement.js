/**
 * Reimbursement.js
 */



window.onload = function(){
	document.getElementById("submitBtn").addEventListener("click", addRows);
}

function addRows(){
	let status = document.getElementById("mstatus");
	let amount = document.getElementById("amount");
	console.log(status + " " + amount );
	if(amount)
		{
		if(amount.trim != ""){
			let row = document.createElement("tr");
			let statcol = document.createElement("td");
			let amountcol = document.createElement("td");
			
			statcol.textContent = 'Pending';
			amountcol.textContent = '$' + amount.value;
			row.appendChild(statcol);
			row.appendChild(amountcol);
			document.getElementById("myTable").appendChild(row);
			
		}
		else
			console.log("No inputs.");
		}
	
}