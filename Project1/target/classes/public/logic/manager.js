// Table row template
/* <tr>
	<td class="text-center">CATEGORY</td>
	<td class="text-center">Employee Notes</td>
	<td class="text-center">Amount</td>
	<td class="text-center">  
	<!-- Button to Open the Modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
		Open modal
	</button>
</td>
</tr> */
var employeeId;
var reimbursementId;
async function populateManagerTable() {
	let tableBody = document.getElementById("tableBody");

	let response = await fetch(`http://localhost:7777/requests`);
	let info = await response.json();

	for (let index = 0; index < info.length; index++) {
		const element = info[index];
		if (element.status == "Approved") {
			tableBody.innerHTML += `
            <tr>
                <td class="text-center">${element.employeeId}</td>
                <td class="text-center" style="word-wrap: break-word;">${element.reason}</td>
                <td class="text-center">${element.amount}</td>
                <td class="text-center">  
                    <!-- Button to Open the Modal -->
                    <button id="button" style="background-color:green" type="button" onclick=populateModalReimbursementDetails(${element.id}) class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                        ${element.status}
                    </button>
                </td>
            </tr>
        `} else if (element.status == "Denied") {
			tableBody.innerHTML += `
            <tr>
                <td class="text-center">${element.employeeId}</td>
                <td class="text-center" style="word-wrap: break-word;">${element.reason}</td>
                <td class="text-center">${element.amount}</td>
                <td class="text-center">  
                    <!-- Button to Open the Modal -->
                    <button id="button" style="background-color:red" type="button" onclick=populateModalReimbursementDetails(${element.id}) class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                        ${element.status}
                    </button>
                </td>
            </tr>
        `
		} else {
			tableBody.innerHTML += `
            <tr>
                <td class="text-center">${element.employeeId}</td>
                <td class="text-center" style="word-wrap: break-word;">${element.reason}</td>
                <td class="text-center">${element.amount}</td>
                <td class="text-center">  
                    <!-- Button to Open the Modal -->
                    <button id="button" style="background-color:" type="button" onclick=populateModalReimbursementDetails(${element.id}) class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                        ${element.status}
                    </button>
                </td>
            </tr>
        `
		};
	}
}




async function fetchReimbursementById(rid) {
	let response = await fetch(`http://localhost:7777/requests/${rid}`);
	let info = await response.json();
	return info;
}

async function populateModalReimbursementDetails(rid) {
	reimbursementId = rid;
	let modalAmount = document.getElementById("modalAmount");
	let modalCategory = document.getElementById("modalCategory");
	let modalNotes = document.getElementById("modalNotes");
	let thumbsUp = document.getElementById("thumbsUp");
	let thumbsDown = document.getElementById("thumbsDown");
	let modalComment = document.getElementById("modalCommentManager");

	let response = await fetch(`http://localhost:7777/requests/${rid}`);
	let info = await response.json();

	console.log(info.reason);
	modalAmount.innerHTML = `$ ${info.amount}`;
	modalReason.innerHTML = ` ${info.reason}`;


	if (rData.status === 0) {
		thumbsUp.style.color = "gray"
		thumbsDown.style.color = "red"
	}
	else {
		thumbsUp.style.color = "green"
		thumbsDown.style.color = "gray"
	}


	return;
}

async function statusUpdate(status) {
	console.log(status);
	let managerNote = document.getElementById("modalCommentManager").value;
	let myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");

	let rData = await fetchReimbursementById(reimbursementId);
	if (status === "approved")
		rData.status = "Approved";
	else
		rData.status = "Denied";
	let raw = JSON.stringify(rData);

	let requestOptions =
	{
		method: 'PUT',
		headers: myHeaders,
		body: raw,
	};

	await fetch("http://localhost:7777/requests", requestOptions)

	location.reload();
}

function cleanTable() {
	let tableBody = document.getElementById("tableBody");

	tableBody.innerHTML = "";
}