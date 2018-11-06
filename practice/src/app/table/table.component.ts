import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  users: Array<Object> = [
    {'firstName': 'ron', 'lastName': 'Perlman', 'birthday': '04-13-1950', 'email': 'ilooklikeacat@perlman.edu'},
    {'firstName': "Demarco", 'lastName': "Parker", 'birthday': "Thu Feb 08 2018 05:40:15 GMT-0500 (Eastern Standard Time)", 'email': 'Pat58@hotmail.com'},
    {'firstName': 'Pansy', 'lastName': 'Koch', 'birthday': 'Tue Jun 12 2018 08:34:40 GMT-0400 (Eastern Daylight Time)', 'email': 'Otilia.Pfannerstill37@hotmail.com'},
    {'firstName': 'Cayla', 'lastName': 'Ward', 'birthday': 'Mon Oct 01 2018 15:08:46 GMT-0400 (Eastern Daylight Time)', 'email': 'Ned_Rowe@hotmail.com'},
    {'firstName': 'Lea', 'lastName': 'Weber', 'birthday': 'Sat Jul 28 2018 16:58:21 GMT-0400 (Eastern Daylight Time)', 'email': 'Earline_Langosh@hotmail.com'},
    {'firstName': 'Lilyan', 'lastName': 'Abbott', 'birthday': 'Sun Jan 21 2018 03:11:32 GMT-0500 (Eastern Standard Time)', 'email': 'Tito.Bergnaum@yahoo.com'},

  ]

  formatted: boolean = false;

  constructor() { }

  ngOnInit() {
  }

  toggleFormat(): void {
    this.formatted = !this.formatted;
  }
}
