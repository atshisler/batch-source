import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  color: boolean;

  constructor() { }

  fireEvent(e) {
     setTimeout(function() {
     }.bind(this), 1000);
     console.log(e);
      this.changeColor();

  }

  changeColor(): void {
    this.color = false;
  }

  changeEvent(e): void {
     setTimeout(function() {
     }.bind(this), 1000);
     console.log(e);
     this.color = true;
  }

  isColorful(): boolean {
    return this.color;
  }

  ngOnInit() {
  }

}
