import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  hovered: boolean = false;

  constructor() { }

  ngOnInit() {
  }

  mouseEnter(): void {
    console.log('entered.')
    this.hovered = true;
  }

  mouseLeave(): void {
    console.log("left")
    this.hovered = false;
  }

  highlight() {

    return this.hovered ? '#'+Math.floor(Math.random()*16777215).toString(16) : 'transparent';
  }
}
