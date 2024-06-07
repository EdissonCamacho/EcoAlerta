import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaginationService } from '../../Services/pagination.service';
import { Observable } from 'rxjs';
import { Seccion } from '../../Models/Seccion';
import { Articulo } from '../../Models/Articulo';
import { ReactiveFormsModule } from '@angular/forms';
import { ImagenArticuloService } from '../../Services/imagen-articulo.service';
import { ImagenArticulo } from '../../Models/imagen-articulo';

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

  //imagen individual
  imagenes:any[]=[];


  
  constructor( private route: ActivatedRoute,private servicePagination:PaginationService,private serviceImagenArticulo:ImagenArticuloService){

  }
  ngOnInit(): void {
    //obtencion del parametros de la url
    this.obtenerParamsUrl();
    //Carga de los articulos
    this.loadArticulos();
    //divisionPag
    this.mostrarPag(0);
    //Cargar Imagenes
    this.cargarImagen()
    
  
  }

  mostrarPag(item:number){
    this.articulo=this.pagArticulos[item];
  }
  
  divisionPagina(){
    


    let tamanoPag:number=4;
    for (let i = 0; i < this.articulos.length; i += tamanoPag) {
      console.log(this.articulos[i].id);

      this.pagArticulos.push(this.articulos.slice(i, i + tamanoPag));
  }
  


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
  cargarImagen(){
    this.serviceImagenArticulo.getImagenesArticulo().subscribe(
      (data:ImagenArticulo[])=>{
        this.imagenes=data;
        
        
      }
    )
  }

  buscarImagen(id:number){
    let url:string="";
   for (let index = 0; index < this.imagenes.length; index++) {
    if(id==this.imagenes[index].idArticuloFk.id){
      url=this.imagenes[index].idImagenFk.url;
      break;
      
      
    }
    
   }
   if(url!=""){
    return url;
    
   }
   return "assets/images/default.jpg"
   

  }

  


}
