import { Injectable,inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ComentarioArticulo } from '../models/ComentarioArticulo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComentarioarticuloService {

  private http=inject(HttpClient)
  public url:string="http://localhost:8080/API/ComentarioArticulo/"
  constructor() { }
public crear(comentario:ComentarioArticulo){
   return this.http.post(this.url+"create",comentario);

}
public getAllByArticulo(id:number):Observable<ComentarioArticulo[]>{
  return this.http.get<ComentarioArticulo[]>(this.url+"getByArticulo/"+id)
}

public delete(comentario:any){
  console.log(comentario)
  return this.http.delete(this.url+"delete/"+comentario)
}

}
