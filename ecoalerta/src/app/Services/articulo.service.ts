import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Articulo } from '../Models/Articulo';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

  private http=inject(HttpClient)
  public url:string="http://localhost:8080/api/articulo/"
  constructor() { }




  public getArticulo(idArticulo: number):any{
    return this.http.get(this.url+"getByIdArticulo/"+idArticulo);
  }

}
