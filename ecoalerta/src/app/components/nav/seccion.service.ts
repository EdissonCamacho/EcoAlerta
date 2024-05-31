import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Seccion } from '../../models/Seccion'; 


@Injectable({
  providedIn: 'root'
})
export class SeccionService {
  
  private http=inject(HttpClient);
  public url:string="http://localhost:8080/api/seccion"
  
  constructor() {}

  public getSecciones():Observable<Seccion[]>{
    return this.http.get<Seccion[]>(this.url+"/getAll");
    

  }


}
