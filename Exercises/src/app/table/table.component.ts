import { Component, OnInit } from '@angular/core';
import { TableDisplay } from '../table-display/table-display.model';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  display: TableDisplay[];

  constructor() {
    this.display = [new TableDisplay('Andrew', 'Angular', 'Andrew@email.com', '1/11/01')];

  }

   addBirthday(first: HTMLInputElement, last: HTMLInputElement, email: HTMLInputElement, birthday: HTMLInputElement): boolean {
    console.log(`Adding birthday: ${first.value}, ${last.value}, ${email.value}, ${birthday.value}`);
    this.display.push(new TableDisplay(first.value, last.value, email.value, birthday.value));
    first.value = '';
    last.value = '';
    email.value = '';
    birthday.value = '';
    return false;
  }

  displayBirthdays(): TableDisplay[] {
    console.log(this.display);
    return this.display;
  }

  ngOnInit() {
  }

}
