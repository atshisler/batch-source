import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-profile',
  template: `<h1>{{title}}</h1>
  <p>Employee List</p>
  <ul>
    <li *ngFor="let emoloyee of employees">
    {{employee.name}}
    </li>
  </ul>
  <p *ngIf="employees.length >3"></p>`
})
export class ProfileComponent implements OnInit {
  title = 'Employee List';
  employees = [
    new Employee(1, 'Mary', 'Manager'),
    new Employee(2, 'Bob', 'As. Manager'),
    new Employee(3, 'Jack', 'Associate'),
    new Employee(4, 'Sue', 'Associate')
  ];
  myEmployee = this.employees[0];
  constructor() { }

  ngOnInit() {
  }

}
