import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import { TestObject } from 'protractor/built/driverProviders';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.scss']
})
export class AllUsersComponent implements OnInit {

  users : any;

  constructor(private service : UserServiceService) { }

  ngOnInit() {
    let response = this.service.getUsers();
    response.subscribe(data => this.users = data);
  }

  public removeUser(username : string){
    let response = this.service.deleteUser(username);
    response.subscribe(data => this.users = data);
  }

}
