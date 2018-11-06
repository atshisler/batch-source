import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-people-table',
  templateUrl: './people-table.component.html',
  styleUrls: ['./people-table.component.css']
})
export class PeopleTableComponent implements OnInit {

  peopleTable : Object[] = [{firstName : "donny", lastName: "laPlume", email : "donnylaplume@gmail.com", birthday: "3 30 9999"},{firstName : "Donny", lastName: "laPlume", email : "donnylaplume@gmail.com", birthday: "9/9/9999"},{firstName : "donny", lastName: "LaPlume", email : "donnylaplume@gmail.com", birthday: "9/9/9999"},{firstName : "Donny", lastName: "LaPlume", email : "donnylaplume@gmail.com", birthday: "9/9/9999"}]

  constructor() { }

  ngOnInit() {
  }

}
