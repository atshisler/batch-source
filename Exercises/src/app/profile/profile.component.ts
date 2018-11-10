import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @Input()
  email: string;
  password: string;
  address: string;
  address2: string;
  city: string;
  zip: number;
  message: string;

  hidden = false;

  constructor() { }

  editProfile(em: string, pass: string, add: string, add2: string, cty: string, zp: number) {
    if (!em || !pass || !add || !add2 || !cty || !zp) {
      this.message = 'All Fields Are Required';
      setTimeout(function() {
        this.message = '';
      }.bind(this), 5000);
    } else {
      this.message = 'Your profile has been updated';
       setTimeout(function() {
         this.message = '';
       }.bind(this), 2500);
    }
  }

  hide() {
    this.hidden = true;
  }

  show() {
    this.hidden = false;
  }

  isHidden(): boolean {
    return this.hidden;
  }

  ngOnInit() {
  }

}
