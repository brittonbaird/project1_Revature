

async function populateEmployeeTable() {
	let tableBody = document.getElementById("tableBody");

	let response = await fetch("http://localhost:7777/requests");
	let info = await response.json();

	for (let index = 0; index < info.length; index++) {
		const element = info[index];
		if (sessionStorage.getItem('id') == element.employeeId) {
			if (element.status == "Approved") {
				tableBody.innerHTML += `
            <tr>
                	<td class="text-center">${element.employeeId}</td>
                	<td class="text-center" style="word-wrap: break-word;">${element.reason}</td>
                	<td class="text-center">${element.amount}</td>
                	<td class="text-center">  
                    	<button style=background-color:green type="button" class="btn btn-primary">
                       	${element.status}
                    	</button>
                	</td>
            	</tr>
        	`;
			} else if (element.status == "Denied") {
				tableBody.innerHTML += `
            <tr>
                	<td class="text-center">${element.employeeId}</td>
                	<td class="text-center" style="word-wrap: break-word;">${element.reason}</td>
                	<td class="text-center">${element.amount}</td>
                	<td class="text-center">  
                    	<button style=background-color:red type="button" class="btn btn-primary">
                       	${element.status}
                    	</button>
                	</td>
            	</tr>
        	`;
			} else {
				tableBody.innerHTML += `
            <tr>
                	<td class="text-center">${element.employeeId}</td>
                	<td class="text-center" style="word-wrap: break-word;">${element.reason}</td>
                	<td class="text-center">${element.amount}</td>
                	<td class="text-center">  
                    	<button style=background-color: type="button" class="btn btn-primary">
                       	${element.status}
                    	</button>
                	</td>
            	</tr>
        	`;
			}
			;
		}
	}
}


async function uploadNewReimbursement() {
	let employee_note = document.getElementById("rComment").value;
	let rAmount = document.getElementById("amount").value;
	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");

	const params = {
		id: 0,
		employeeId: sessionStorage.getItem('id'),
		reason: `${employee_note}`,
		status: "pending",
		amount: rAmount
	};

	const options = {
		method: 'POST',
		body: JSON.stringify(params)
	};

	fetch('http://localhost:7777/requests', options)
	then(response => response.json())
	then(response => {
		// Do something with response.
	});


	location.reload();

}