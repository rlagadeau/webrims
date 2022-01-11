
//Function that makes the user logout.
function logout(){
	window.location.assign("index.html");
	
	return false;
}

//Function that redirects user to the items view page.
function redirect_items(){
	window.location.assign("items.html");

	return false;
}

//Function that lets you see which user is logged in.
function home_page(){
    let user_text = document.getElementById("user_text");
    user_text.innerHTML = "Hi " + localStorage.getItem('email');

    return false;
}