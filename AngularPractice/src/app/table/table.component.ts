import { Component, OnInit } from '@angular/core';
import { Users } from '../users'

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  users: Users[] = [
    { name: 'brianna roberts', email: 'Bnroberts1016@yahoo.com', birthday: '10/16/1995' },
    { name: 'john smith', email: 'jsmith@gmail.com', birthday: '1/1/1990'},
    { name: 'jane doe', email: 'JDoe@gmail.com', birthday: '2/2/1980'}
  ];

  constructor() { }

  ngOnInit() {
  }

}
