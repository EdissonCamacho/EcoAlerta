import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Seccion } from '../../models/Seccion';
import { Articulo } from '../../models/Articulo';

@Injectable({
  providedIn: 'root'
})
export class PaginationService {

  private http=inject(HttpClient)
  public url:string="http://localhost:8080/api/articulo/"

  constructor() { }
  
  public getArticulo(id:number):Observable<Articulo[]>{
    return this.http.get<Articulo[]>(this.url+"getByIdSeccion/"+id);    

  }

}
