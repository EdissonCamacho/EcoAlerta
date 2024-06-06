import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { ImagenArticulo } from '../Models/imagen-articulo';

@Injectable({
  providedIn: 'root'
})
export class ImagenArticuloService {

  private http=inject(HttpClient)
  public url:string="http://localhost:8080/api/imagenArticulo/"
  constructor() { }
  public getImagenesArticulo():Observable<ImagenArticulo[]>{
    return this.http.get<ImagenArticulo[]>(this.url+"getAll");
  }
}
