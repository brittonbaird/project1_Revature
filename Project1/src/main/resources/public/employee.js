
var url = "http://localhost:7777";

async function getInfo() {
	var currentUrl = window.location.search;
	var params = new URLSearchParams(currentUrl);
	var email = params.get('email');
	alert(email);
}
