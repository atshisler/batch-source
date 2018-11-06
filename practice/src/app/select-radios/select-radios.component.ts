import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-select-radios',
  templateUrl: './select-radios.component.html',
  styleUrls: ['./select-radios.component.css']
})
export class SelectRadiosComponent implements OnInit {

  myFood = 'lamb';

  props: Object = {
    'animals' : ['Hippo', 'Main Coon', 'Shetland Pony'],
    'days' : ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
    'colors' : ['Red', 'Orange', 'Green', 'Blue', 'Indigo', 'Violet'],
  }

  constructor() { }

  ngOnInit() {
  }

}
