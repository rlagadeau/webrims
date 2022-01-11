
//Function that redirects user to the home page.
function redirect_home(){
	window.location.assign("home.html");

	return false;
}

function redirect_items(){
	window.location.assign("items.html");

	return false;
}

//Function that makes the user logout.
function logout(){
	window.location.assign("index.html");

	return false;
}