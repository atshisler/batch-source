import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-display-user',
  templateUrl: './display-user.component.html',
  styleUrls: ['./display-user.component.css']
})
export class DisplayUserComponent implements OnInit {

  userObject : Object = {firstName : "Donny", lastName : "LaPlume"};
  toggle : boolean = true;

  constructor() { }

  ngOnInit() {
  }

  ToggleOnOff()
  {
    this.toggle = !this.toggle;
  }

}
