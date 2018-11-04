/**
 * Programmer: Alex Shisler
 * EmployeeLogin.js
 */

/*//time intervals
console.log(4);
setTimeout (() => console.log(5),500);
//syntax below means same as the above line
setTimeout (function (){
	console.log(6);
}, 500);*/

//simple ajax call /request

/*var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function(){
	console.log("response text: "+ xhr.responseText+
			"http status: "+ xhr.status + 
			"http status text: "+ xhr.statusText + 
			"readyState: "+ xhr.readyState
	);
}
xhr.open("GET", "file:///D:/my_git_repos/1810_oct8_jta/Alex_Shisler_Code/ProjectOne/src/main/webapp/HTML/EmployeeLoginPage.html");
xhr.send();
*/


/*
 * http status codes 100 - information 200 - success 300 - redirect 400 - client
 * error 500 - server error
 */
window.onload = () =>{
	let btn = document.getElementById("loggin");
	
	btn.addEventListener("click", ()=> {
		// for every readystate, onreadystatechange will be executed
		var xhr = new XMLHttpRequest();// create instance of xmlhttprequest
										// first step of ajax
		xhr.onreadystatechange = function(){
			if((xhr.readyState == 4) && (xhr.status == 300)){
			let newEmail = document.getElementById("email");
			let newPassword = document.getElementById("password");
			newEmail.innerHTML = xhr.responseText;
			newPassword.innerHTML = xhr.status;
			console.log("THIS STUFF " + newEmail);
			rh.innerHTML = xhr.getAllResponseHeaders();
		}
		};
		xhr.open("get", "file:///D:/my_git_repos/1810_oct8_jta/Alex_Shisler_Code/ProjectOne/src/main/webapp/HTML/EmployeeLoginPage.html");
		xhr.send();
	});
	
	/*let giftedBtn = document.getElementById("gifted");
	
	giftedBtn.addEventListener("click", ()=> {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if((xhr.readyState == 4) && (xhr.status == 200)){
				let original = document.getElementById("original");
				original.innerHTML = xhr.responseText;
			}//if
			};
			xhr.open("get", "file:///D:/my_git_repos/1810_oct8_jta/Alex_Shisler_Code/ProjectOne/src/main/webapp/HTML/EmployeeLoginPage.html");
			xhr.send();
			
		});*/
	};
// onload

