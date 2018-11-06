import { Component, OnInit, ElementRef } from '@angular/core';
import { element } from '@angular/core/src/render3';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  highlight(color: string){
    document.getElementById('paragraph').style.backgroundColor = color;
  }

  onMouseEnter() {
    this.highlight('violet');
  }

  onMouseLeave() {
    this.highlight('white');
  }

}
