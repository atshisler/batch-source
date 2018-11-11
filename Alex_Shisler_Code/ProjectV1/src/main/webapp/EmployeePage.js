/*
 * Programmer: Alex Shisler
 * EmployeeLogin.js
 */


	var jsonResponse;
	let welcomeTxt = document.getElementById("Welcome").innerHTML = "Welcome back " + getCookie("username");
	// document.getElementById("crP").innerHTML = "Invalid Credentials, please
	// try again.";
	
	
// --------------------------AJAX Info
// Retrieval-------------------------------------//
	var xhr2 = new XMLHttpRequest();
	console.log("Test" + xhr2.responseText);
	xhr2.onreadystatechange = function(){
		if((xhr2.readyState == 4) && xhr2.status >= 200 && xhr2.status < 300){
			request = "";
			jsonResponse = JSON.parse(xhr2.responseText);
			 console.log("JSON " + jsonResponse.email + " " +  jsonResponse.username);

		}// response received.
			
	
	
	};
		// console.log(loginfo);
		 xhr2.open("GET", "api?request=retrieveEmp");
		// xhr2.open("POST", "http://localhost:6016/ProjectV1/?email=" +
		// user.email + "&password=" + user.password + "&request=" +
		// request, true);
		xhr2.setRequestHeader("Content-Type", "application/json");

		xhr2.send();
	
	
// -------------------AJAX Info Retrieval-----------------------------//
	

	
	
	
// --------------------------------Display Info---------------------//
		let btn = document.getElementById("display");
		isShowing = false;
	btn.addEventListener("click", ()=> {
		console.log("Cookies");
		console.log("Cookies yo " + getCookie("email"));
		console.log("Cookies yo " + getCookie("username"));
	
		 displayInfo();
	});
	

// ------------------Get Cookie--------------------//
	function getCookie(cname){
		 var name = cname + "=";
		    var decodedCookie = decodeURIComponent(document.cookie);
		    var ca = decodedCookie.split(';');
		    for(var i = 0; i <ca.length; i++) {
		        var c = ca[i];
		        while (c.charAt(0) == ' ') {
		            c = c.substring(1);
		        }
		        if (c.indexOf(name) == 0) {
		            return c.substring(name.length, c.length);
		        }
		    }
		    return "";
	};
	
	
	// ----------------------Display Info-------------------------//
	function displayInfo(){
		let infoList = document.getElementById("employeeInfoList");
		if(!isShowing){
		let list = document.createElement("li");
		list.className= "list-group-item";
		let node = document.createTextNode("Email: " + jsonResponse.email);
		list.appendChild(node);
		infoList.appendChild(list);
		list = document.createElement("li");
		list.className= "list-group-item";
		node = document.createTextNode("Username: " + jsonResponse.username);
		list.appendChild(node);
		infoList.appendChild(list);
		list = document.createElement("li");
		list.className= "list-group-item";
		node = document.createTextNode("First Name: " + jsonResponse.firstName);
		list.appendChild(node);
		infoList.appendChild(list);
		list = document.createElement("li");
		list.className= "list-group-item";
		node = document.createTextNode("Last Name: " + jsonResponse.lastName);
		list.appendChild(node);
		infoList.appendChild(list);
		list = document.createElement("li");
		list.className= "list-group-item";
		node = document.createTextNode("Title: " + jsonResponse.title);
		list.appendChild(node);
		infoList.appendChild(list);
		isShowing = true;
	}// addInfo
		else{
			while (infoList.firstChild) {
			    infoList.removeChild(infoList.firstChild);
			}
			isShowing = false;
		}
	}// displayInfo
	
	
	//--------------------------Update Info-------------------------------//
	// --------------------------Logout-----------------------------------
	
	let logoutBtn = document.getElementById("Logout");
	logoutBtn.addEventListener("click", ()=> {
		var lgoutReq = new XMLHttpRequest();
		console.log("Test" + lgoutReq.responseText);
		lgoutReq.onreadystatechange = function(){
			if((lgoutReq.readyState == 4) && lgoutReq.status >= 200 && lgoutReq.status < 300){
				request = "";
				console.log(lgoutReq.responseText);
				document.write(lgoutReq.responseText);
			}// response received.
		};
			
			lgoutReq.open("GET", "api?request=logout");
			lgoutReq.setRequestHeader("Content-Type", "application/json");
			lgoutReq.send();
			
			console.log("Cookies Logout");
			deleteCookie("email");
			deleteCookie("username");
			console.log("Cookies yo " + getCookie("email"));
			console.log("Cookies yo " + getCookie("username"));

	});
	
	// ------------------------------deleteCookies--------------------------//
	function deleteCookie(cName) {
	    document.cookie = cName + '=; Max-Age=0'
	}
