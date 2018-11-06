import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  display: boolean = false;

  user: Object = {
    firstName: "Ron",
    lastName: "Perlcat",
    age: "55",
    hobbies: ["Long walks on the beach", "acting", "italian cuisine"],
  }

  constructor() { }

  ngOnInit() {
  }

  toggleProfile() {
    this.display = !this.display;
  }
  
  toggleButtonText(): string {
    return this.display ? "Hide" : "Show";
  }
}
