
//Function that redirects user to the signin page.
function signin(){
	window.location.assign("index.html");
	
	return false;
}


//Function that creates a user.
function create_user(){
	
	var firstname = document.getElementById("firstname").value;
	var lastname = document.getElementById("lastname").value;
	var email = document.getElementById("emailaddress").value;
	var password = document.getElementById("password").value;
	
	if(firstname == "" && lastname == "" && email == "" && password == ""){
		alert("The fields are empty. Please fill them in!");
		return;
	}
	
	if(firstname == ""){
		alert("The firstname field is empty. Please fill it in!");
		return;
	}
	
	if(lastname == ""){
		alert("The lastname field is empty. Please fill it in!");
		return;
	}
	
	if(email == ""){
		alert("The email field is empty. Please fill it in!");
		return;
	}
	
	if(password == ""){
		alert("The password field is empty. Please fill it in!");
		return;
	}

	send_signup_page_data(firstname, lastname, email, password);
	
	return false;
}

