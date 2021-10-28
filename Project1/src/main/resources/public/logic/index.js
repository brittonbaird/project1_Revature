
var url = "http://localhost:7777";

async function validate() {
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;

	fetch(url + "/login/" + email)
		.then(function(res) {
			res.json()
				.then(function(data) {
					if (email == data.email && password == data.password) {
						alert("Login Successfull");
						sessionStorage.setItem('email', data.email);
						sessionStorage.setItem('password', data.password);
						sessionStorage.setItem('id', data.id);
						sessionStorage.setItem('firstName', data.firstName);
						sessionStorage.setItem('lastName', data.lastName);
						sessionStorage.setItem('isManager', data.isManager)
						if (data.isManager == true) {
							window.location.href = "manager.html";
						} else {
							window.location.href = "employee.html";
						}
					} else {
						alert("Incorrect email or password");
					}

				}).catch((error) => {
					alert("Incorrect email or password");
				});

		}).catch((error) => {
			alert("Incorrect email or password");
		});

	//alert("Incorrect email or password");

}