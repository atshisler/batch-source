import { Component, OnInit, HostBinding, Input } from '@angular/core';
import { TableDisplay } from './table-display.model';

@Component({
  selector: 'app-table-display',
  templateUrl: './table-display.component.html',
  styleUrls: ['./table-display.component.css']
})
export class TableDisplayComponent implements OnInit {

  @HostBinding('attr.class') cssClass = 'row';
  @Input() display: TableDisplay;

  constructor() {

   }

  ngOnInit() {
  }

}
