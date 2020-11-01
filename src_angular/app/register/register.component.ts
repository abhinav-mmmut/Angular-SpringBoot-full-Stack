import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  user: User=new  User("","","",0,"");
  message:any;
  constructor(private service : UserServiceService) { }

  ngOnInit(): void {
  }

  public registerNow(){
    let response=this.service.doRegistration(this.user);
    response.subscribe(data => {
      this.message=data;
    })
  }

}
