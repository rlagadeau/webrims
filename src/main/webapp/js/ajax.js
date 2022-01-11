
//Variables that will be used in the page.
var method_post = "POST";
var method_get = "GET";
var method_put = "PUT";
var method_delete = "DELETE";
var url_signup = "http://localhost:8080/webrims/api/signup/add";
var url_login = "http://localhost:8080/webrims/api/login/authentication";
var asynchronous = true;
var label = "Content-Type";
var label_value = "application/json";


//Function that sends login data to backend.
function send_login_page_data(email, password){
	
	let credentials = {"userEmail": email, "userPassword": password};
	
	let ajaxRequest;

	ajaxRequest = new XMLHttpRequest();
	ajaxRequest.onreadystatechange = function() {
	   if (this.readyState == 4 && this.status == 200) {
			let response = this.responseText;
			
			if(response == "true"){
			    localStorage.clear();
			    localStorage.setItem('email', email);
				window.location.assign("home.html");
			}else{
			    alert("Authentication failure. Please try again later or contact administrator!");
			}
		}
	  };

	ajaxRequest.open(method_post, url_login , asynchronous);
	ajaxRequest.setRequestHeader(label, label_value);
	ajaxRequest.send(JSON.stringify(credentials));
}


//Function that sends signup data to backend.
function send_signup_page_data(firstname, lastname, email, password){
	
	let user = {"userFirstName": firstname, "userLastName": lastname, "userEmail": email, "userPassword": password};
	
	let ajaxRequest;

	ajaxRequest = new XMLHttpRequest();
	ajaxRequest.onreadystatechange = function() {
	   if (this.readyState == 4 && this.status == 200) {
			var response = this.responseText;

			if(response == "User insertion succeeded"){
				alert("User added successfully!");
				window.location.assign("index.html");
			}else if(response == "User insertion failed"){
			    alert("User not added. Please try again!");
			}
	   }
	};

	ajaxRequest.open(method_post, url_signup, asynchronous);
	ajaxRequest.setRequestHeader(label, label_value);
	ajaxRequest.send(JSON.stringify(user));
}

function loadItemList() {
    let ajaxRequest;

    ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let itemDataList = JSON.parse(this.responseText);
            let itemList = ' <ul class="w3-ul w3-card-4"> ';

            itemDataList.reverse();

            for (let index = 0; index < itemDataList.length; index++) {
                itemList +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + itemDataList[index].itemId + ' onclick="editItem(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + itemDataList[index].itemId + ' onclick="removeItem(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Delete</button> ' +

                    ' <div class="w3-bar-item"> ' +
                    ' <span> ItemBrand: ' +  itemDataList[index].itemBrand  + ' </span><br> ' +
                    ' <span> ItemCode: ' +  itemDataList[index].itemCode  + ' </span> <br>' +

                    ' <span> ItemDescription: ' +  itemDataList[index].itemDescription  + ' </span> ' +
                    ' </div> ';
            }
            itemList += "</ul>";
            document.getElementById("itemData").innerHTML = itemList;
        }
    };
    ajaxRequest.open("GET", "http://localhost:8080/webrims/api/item/getItems", true);
    ajaxRequest.send();
}

function getItem(itemId){

    let item = {"itemId" : itemId, "itemCode" : document.getElementById("code").value, "itemDescription" : document.getElementById("description").value, "itemBrand" : document.getElementById("brand").value}

    let ajaxRequest;

    ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {

            let response = JSON.parse(this.responseText);

            document.getElementById("itemId").value = response.itemId;
            document.getElementById("brand").value = response.itemBrand;
            document.getElementById("code").value = response.itemCode;
            document.getElementById("description").value = response.itemDescription;

            document.getElementById("btnSaveItem").innerHTML = "Update Item";
       }
    };

    ajaxRequest.open("POST", "http://localhost:8080/webrims/api/item/getItem", true);
    ajaxRequest.setRequestHeader("Content-Type", "application/json");
    ajaxRequest.send(JSON.stringify(item));
}

function addItem() {
    let item = {"itemBrand" : document.getElementById("brand").value, "itemCode" : document.getElementById("code").value, "itemDescription" : document.getElementById("description").value}

    let ajaxRequest;

    ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            loadItemList();
            clearInputFields();
        }
    };

    ajaxRequest.open("POST", "http://localhost:8080/webrims/api/item/add", true);
    ajaxRequest.setRequestHeader("Content-Type", "application/json");
    ajaxRequest.send(JSON.stringify(item));
}


function updateItem(){
    let item = {"itemId" : document.getElementById("itemId").value, "itemBrand" : document.getElementById("brand").value, "itemCode" : document.getElementById("code").value, "itemDescription" : document.getElementById("description").value}

    let ajaxRequest;

    ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
            loadItemList();
            clearInputFields();
            document.getElementById("btnSaveItem").innerHTML = "Add Item";
        }
    };

    ajaxRequest.open("PUT", "http://localhost:8080/webrims/api/item/update", true);
    ajaxRequest.setRequestHeader("Content-Type", "application/json");
    ajaxRequest.send(JSON.stringify(item));
}

function clearInputFields(){
    document.getElementById("itemId").value = "";
    document.getElementById("brand").value = "";
    document.getElementById("code").value = "";
    document.getElementById("description").value = "";
    document.getElementById("btnSaveItem").innerHTML = "Add Item";
}

function removeItem(itemId){
    if ( confirm("Are you sure you want to delete this item?") ) {
        deleteItem(itemId);
    }
}

function deleteItem(itemId){
    let item = {  "itemId" : itemId }

    let ajaxRequest;

    ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) { loadItemList(); }
    };

    ajaxRequest.open("DELETE", "http://localhost:8080/webrims/api/item/delete", true);
    ajaxRequest.setRequestHeader("Content-Type", "application/json");
    ajaxRequest.send(JSON.stringify(item));
}

function editItem(itemId){
    getItem(itemId);
}

function saveItem(){
    if(validateForm()){
        if(document.getElementById("btnSaveItem").innerHTML == 'Add Item'){
            addItem();
        }else{
            updateItem();
        }
    }
}

function validateForm(){
    let pass = true;
    let brand = document.getElementById("brand").value;
    let code = document.getElementById("code").value;
    let description = document.getElementById("description").value;

    if (code == null || code == "", description == null || description == "", brand == null || brand == ""){
        alert("Please fill in all the fields.");
        pass = false;
    }

    return pass;
}
