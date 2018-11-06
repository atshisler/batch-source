import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  name: string = 'Brianna';
  email: string = 'Brianna@gmail.com';
  username: string = 'BRoberts';
  birthdate: string = '10/16/1995';

  constructor() { }

  ngOnInit() {
  }

  hideOrShowProfile() {
    if(document.getElementById('info').style.display === "none") {
      document.getElementById('info').style.display = "block";
    }
    else {
      document.getElementById('info').style.display = "none";
    }
  }
}
