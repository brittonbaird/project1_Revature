async function populateStatisticsTable() {
	let tableBody = document.getElementById("tableBody");

	let response = await fetch("http://localhost:7777/employees");
	let info = await response.json();
	var total = 0;
	var totalApproved = 0;
	
	for (let index = 0; index < info.length; index++) {
		const element = info[index];
		let res = await fetch("http://localhost:7777/requests/employee/" + element.id);
		let requestInfo = await res.json();
		for (let i = 0; i < requestInfo.length; i++) {
			const requestElement = requestInfo[i];
			if (requestElement.status == "Approved") {
				totalApproved += requestElement.amount;
				console.log(totalApproved);
			}
			total += requestElement.amount;
			console.log(total);
		}
			tableBody.innerHTML += `
            <tr>
                	<td class="text-center">${element.firstName} ${element.lastName}</td>
                	<td class="text-center" style="word-wrap: break-word;">${total}</td>
                	<td class="text-center">${totalApproved}</td>
                	<td class="text-center">  
                  
            	</tr>
        	`;
		total = 0;
		totalApproved = 0;
	}
}

