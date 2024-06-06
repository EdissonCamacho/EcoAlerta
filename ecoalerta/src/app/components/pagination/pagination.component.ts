import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaginationService } from './pagination.service';
import { Observable } from 'rxjs';
import { Seccion } from '../../models/Seccion';
import { Articulo } from '../../models/Articulo';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pagination',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './pagination.component.html',
  styleUrl: './pagination.component.css'
})
export class PaginationComponent implements OnInit ,OnDestroy {
  id:number=0;
  private sub: any;
  //Contiene todos los articulos de la BD
  articulos:Articulo[]=[];
  //Rompimiento de articulos 
  pagArticulos:any=[];

  numPaginas:number=0;
  //Mostrar por Seleccion
  articulo:Articulo[]=[];


  
  constructor( private route: ActivatedRoute,private servicePagination:PaginationService){

  }
  ngOnInit(): void {
    //obtencion del parametros de la url
    this.obtenerParamsUrl();
    //Carga de los articulos
    this.loadArticulos();
    //divisionPag
    this.mostrarPag(0);
  
  }

  mostrarPag(item:number){
    this.articulo=this.pagArticulos[item];
  }
  
  divisionPagina(){
    let tamanoPag:number=4;
    for (let i = 0; i < this.articulos.length; i += tamanoPag) {
      this.pagArticulos.push(this.articulos.slice(i, i + tamanoPag));
  }
  console.log(this.pagArticulos);


  }


  obtenerParamsUrl(){
    this.sub=this.route.params.subscribe(params=>{
      this.id=+params['id']
    });
  }


  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  loadArticulos(){
    this.servicePagination.getArticulo(this.id).subscribe(
      (data:Articulo[])=>{
       this.articulos=data;
       this.divisionPagina();
       this.mostrarPag(0);
      
      },
      (error:any)=>{
        console.error('No se pueden cargar articulos')
      }
    );
     

  }


}
