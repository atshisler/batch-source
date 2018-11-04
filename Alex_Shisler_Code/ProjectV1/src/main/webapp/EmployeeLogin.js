/**
 * Programmer: Alex Shisler EmployeeLogin.js
 */

/*
 * //time intervals console.log(4); setTimeout (() => console.log(5),500);
 * //syntax below means same as the above line setTimeout (function (){
 * console.log(6); }, 500);
 */

// simple ajax call /request

/*
 * var xhr = new XMLHttpRequest(); xhr.onreadystatechange = function(){
 * console.log("response text: "+ xhr.responseText+ "http status: "+ xhr.status +
 * "http status text: "+ xhr.statusText + "readyState: "+ xhr.readyState ); }
 * xhr.open("GET",
 * "file:///D:/my_git_repos/1810_oct8_jta/Alex_Shisler_Code/ProjectOne/src/main/webapp/HTML/EmployeeLoginPage.html");
 * xhr.send();
 */


/*
 * http status codes 100 - information 200 - success 300 - redirect 400 - client
 * error 500 - server error
 */
window.onload = () =>{
	let btn = document.getElementById("loggin");
	console.log("Testo");
	
	btn.addEventListener("click", ()=> {
		// for every readystate, onreadystatechange will be executed
		var xhr = new XMLHttpRequest();// create instance of xmlhttprequest
										// first step of ajax
		xhr.onreadystatechange = function(){
			if((xhr.readyState == 4) && xhr.status >= 200 && xhr.status < 300){
				console.log("test2");
				let formData = document.getElementById("logginForm");
				if(formData != null){
					console.log("yay");
				let user = {
					email : formData[0].value,
					password : formData[1].value					
				};// new user
				
				user.email = formData[0].value;
				user.password = formData[1].value;
				let  loginfo = JSON.stringify(user);
				console.log("EMAIL " + user.email);
				// console.log(loginfo);
				xhr.open("POST", "http://localhost:6016/ProjectV1/api?email=" + user.email + "&password=" + user.password, true);
				xhr.setRequestHeader("Content-Type", "application/json");
				// console.log(loginfo.toString());
				xhr.send(loginfo.toString());
				// console.log(xhr.responseText);
			}// fill in formdata
				else
					console.log("Uh oh");
		}// response received.
		
		};
		xhr.open("POST", "http://localhost:6016/ProjectV1/");
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send();
	});
	
	/*
	 * let giftedBtn = document.getElementById("gifted");
	 * 
	 * giftedBtn.addEventListener("click", ()=> { var xhr = new
	 * XMLHttpRequest(); xhr.onreadystatechange = function(){ if((xhr.readyState ==
	 * 4) && (xhr.status == 200)){ let original =
	 * document.getElementById("original"); original.innerHTML =
	 * xhr.responseText; }//if }; xhr.open("get",
	 * "file:///D:/my_git_repos/1810_oct8_jta/Alex_Shisler_Code/ProjectOne/src/main/webapp/HTML/EmployeeLoginPage.html");
	 * xhr.send();
	 * 
	 * });
	 */
	};
// onload

