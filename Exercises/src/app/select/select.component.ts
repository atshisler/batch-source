import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals: boolean;
  colors: boolean;
  days: boolean;
  message: string;

  constructor() {
  }

  onAnimalCheck() {
    this.animals = true;
    this.colors = false;
    this.days = false;
  }

  onColorCheck() {
    this.colors = true;
    this.animals = false;
    this.days = false;
  }

  onDayCheck() {
    this.days = true;
    this.animals = false;
    this.colors = false;
  }

  isAnimal() {
    return this.animals;
  }

  isDay() {
    return this.days;
  }

  isColor() {
    return this.colors;
  }

  ngOnInit() {
  }

}
