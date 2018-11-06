import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-grab-list-ofusers',
  templateUrl: './grab-list-ofusers.component.html',
  styleUrls: ['./grab-list-ofusers.component.css']
})
export class GrabListOfusersComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  loadUsers()
  {
    var httpReq = new XMLHttpRequest();
    //var f = { userName : 'Donny', user_Pass : 'LaPlume', userID : 999, is_Admin : false};
    
    httpReq.onreadystatechange = function()
    {
      
    } 
    
    httpReq.onload = function()
    {
      document.getElementById("login").innerHTML = httpReq.response;
      console.log(httpReq.response);
    }
  
    httpReq.open("POST", "https://jsonplaceholder.typicode.com/users");
    httpReq.send();
  }

}
