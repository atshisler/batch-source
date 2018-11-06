import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import User from '../models/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[];

  constructor(private userService: UserServiceService) { }

  ngOnInit() {
    this.fetchUsers();
  }

  fetchUsers(): void {
    this.userService.getUsers()
      .subscribe( users => this.users = users );
  }

  isObject(user) {
    return typeof user === "object";
  }

}
