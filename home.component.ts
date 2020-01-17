import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  employees;
  message;
  constructor(public route:Router,public service: DataService)
  {
    this.getData();  
  }

  getData()
  {

    let stateofresult =this.service.GetData();

    stateofresult.subscribe((result)=>{
      this.employees=result;

    });
  }
  ngOnInit()
  {
    
  }
    // this.employees =[
    //   {no:1,name:"Virat",address:"Delhi"},
    //   {no:2,name:"Rohit",address:"Delhi"},
    //   {no:7,name:"Dhoni",address:"Ranchi"}
    // ];
  

  GoToRegister()
  {
    // this.route.navigate(['register']);
    this.route.navigate(['register']);
  }

  Delete(empNo)
  {
    // alert(empNo);

    let deletestatus = this.service.DeleteData(empNo);
    deletestatus.subscribe((result:any)=>{
      if(result.affectedRows> 0)
      {
        this.route.navigate["/home"];
      }
      else
      {
        this.message = "Something Went Wrong!!!!!!";
      }
    })
  }

}
