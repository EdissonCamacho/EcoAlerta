import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms'; 
import { Usuario } from '../../models/Usuario';
import { LoginService } from '../../Services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  constructor(private serviceRegister:LoginService,private router:Router){

  }
  formRegister= new FormGroup({
  usuario:new FormControl('',Validators.required),
  nombre:new FormControl('',Validators.required),
  apellido:new FormControl('',Validators.required),
  telefono:new FormControl('',Validators.required),
  email:new FormControl('',Validators.required),
  password:new FormControl('',Validators.required),
  })

  onSubmit(){
    if(this.formRegister.valid){
      console.log(this.formRegister.value)
      let datos:Usuario=this.formRegister.value as Usuario;
      datos.idCiudadFk={
        id:1,
        nombreCiudad:"Paipa",
        idDepartamentoFk:{
          id:1,
          nombreDepartamento:"Boyacá",


        }


      }
      datos.isEnabled=true;
      datos.enabled=true;

      datos.accountNoExpired=true;
      datos.accountNoLocked=true;
      datos.credentialNoExpired=true;

      this.serviceRegister.register(datos).subscribe(
        (data:any)=>{
          console.log(data);
          this.router.navigate(["/login"])

        },
      (error:any)=>{
        console.log(error);
      })


    }
    

  }

}
