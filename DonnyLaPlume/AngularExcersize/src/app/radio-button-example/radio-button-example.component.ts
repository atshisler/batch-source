import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-radio-button-example',
  templateUrl: './radio-button-example.component.html',
  styleUrls: ['./radio-button-example.component.css']
})
export class RadioButtonExampleComponent implements OnInit {

  whichGroup : number = 0;
  animalList : string[] = [" Platypus", " Another Platypus", " A THIRD PLATYPUS"];
  colorList : string[] = [" Blue", " Green", " Tomato"];
  dayList : string[] = [" Monday", " Christmas", " April 27th"];

  constructor() { }

  ngOnInit() {
  }

  ToggleAnimal()
  {
    this.whichGroup = 1;
  }

  ToggleColor()
  {
    this.whichGroup = 2;
  }
  ToggleDay()
  {
    this.whichGroup = 3;
  }
}
