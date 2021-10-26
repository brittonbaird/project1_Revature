
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
						if (data.isManager == true) {
							window.location.href = "manager.html?email=" + email; 
						} else {
							window.location.href = "employee.html?email=" + email;
						}
					} else {
						alert("Incorrect email or password")
					}

				})

		}).catch ((error) => {
			alert("Incorrect email or password")
		});
		
		

}