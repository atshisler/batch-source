import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals: string[] = [
    'dog',
    'cat',
    'tiger',
    'elephant',
    'pig',
    'zebra'
  ];
  colors: string[] = [
    'red',
    'yellow',
    'blue',
    'green',
    'pink',
    'purple'
  ];
  days: string[] = [
    'Monday',
    'Tuesday',
    'Wednesday',
    'Thursday',
    'Friday',
    'Saturday',
    'Sunday'
  ];

  constructor() {  }

  ngOnInit() {
    
  }

  hideLists() {
  }

  displayAnimals() {
    for(var a in this.animals){
      document.writeln(this.animals[a]);
    }
  }

  displayColors() {
    for(var a in this.colors){
      document.writeln(this.animals[a]);
    }
  }

  displayDays() {
    for(var a in this.days){
      document.writeln(this.animals[a]);
    }
  }
}
