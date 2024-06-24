import { HttpClient } from '@angular/common/http';
import { Inject, Injectable, inject } from '@angular/core';
import { LoginModel } from '../models/loginModel';
import { Usuario } from '../models/Usuario';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private http=inject(HttpClient)
  IsLoggedIn=false;
  username=localStorage.getItem("username");
 
  
  public url:string="http://localhost:8080/auth/"


  constructor() {
    if(this.username!=null){
      this.IsLoggedIn=true;
    }
   }
  public login(login:LoginModel):any{
    return this.http.post(this.url+"login",login).pipe(
      tap(response=>{
        this.IsLoggedIn=true;
        this.username=login.username;

      })
    );

  }

  logout(){
    this.IsLoggedIn=false;
    this.username=null;
    localStorage.clear();
  }

  public register(usuario:Usuario):any{
    return this.http.post(this.url+"register",usuario)
  }

}
