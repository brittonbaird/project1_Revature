
var url = "http://localhost:7777";

async function validate() {
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;

	fetch(url + "/login/" + email)
		.then(function(res) {
			res.json()
				.then(function(data) {
					if (email == data.email && password == data.password) {
						alert("Login successfully");
						if (data.ismanager == true) {
							window.location.href = "manager.html"; 
						} else {
							window.location.href = "employee.html";
						}
					} else {
						alert("Incorrect username or password")
					}

				})

		})

	return false;
}