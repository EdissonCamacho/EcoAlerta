import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms'; 
import { LoginService } from '../../Services/login.service';
import { LoginModel } from '../../models/loginModel';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  constructor(private serviceLogin:LoginService,private router:Router){

  }
  formLogin= new FormGroup({
    username:new FormControl('',Validators.required),
    password:new FormControl('',Validators.required)
  })
  
  

  ngOnInit(): void {
    
  }

  onSubmit():void{
    if(this.formLogin.valid){
      console.log(this.formLogin.value);
      let datos:LoginModel=this.formLogin.value as LoginModel;

      this.serviceLogin.login(datos).subscribe(
        (data:any)=>{
          localStorage.setItem("token",data.jwt)
          localStorage.setItem("username",data.username)
          this.router.navigate(["/"])
         
        })
      
    }
    
  }




}
