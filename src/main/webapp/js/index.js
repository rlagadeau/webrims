
//Function that redirects user to the signup page.
function signup(){
	window.location.assign("signup.html");
	
	return false;
}

//The function that handles the authentication.
function authenticate(){
	
	var username = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	
	if(username == "" && password == ""){
		alert("The fields are empty. Please fill them in!");
		return;
	}
	
	if(username == ""){
		alert("The email field is empty. Please fill it in!");
		return;
	}
	
	if(password == ""){
		alert("The password field is empty. Please fill it in!");
		return;
	}
	
	send_login_page_data(username, password);
	
	return false;
}