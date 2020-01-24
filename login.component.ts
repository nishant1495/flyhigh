import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { EmitterService } from '../emitter.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService:UserService,private router:Router,private emSerive:EmitterService) { }

  ngOnInit() {
  }

  login(myLoginForm)
  {
    let data = myLoginForm.form.value;
    this.emSerive.logInBtwSwitch(true);

    this.userService.login(data).subscribe((res)=>{
      // console.log(data);

      if(res['role']=='ADMIN')
      {
        
        sessionStorage['email']=res['email'];
        this.router.navigate(['admin/admindashboard']);
      }
      else
      {
        sessionStorage['email']=res['email'];
        this.router.navigate(['passenger/passdashboard']);
      }
    },
    (error)=>{
      alert("Something Wrong");
    })

  }

}
