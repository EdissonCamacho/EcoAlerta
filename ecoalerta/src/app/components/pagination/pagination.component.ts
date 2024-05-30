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
  articulos:Articulo[]=[];
  constructor( private route: ActivatedRoute,private servicePagination:PaginationService){

  }
  ngOnInit(): void {
    //obtencion del path
    this.sub=this.route.params.subscribe(params=>{
      this.id=+params['id']
    });
    this.loadArticulos();
    
    

  }


  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  loadArticulos(){
    this.servicePagination.getArticulo(this.id).subscribe(
      (data:Articulo[])=>{
       this.articulos=data;
      
      },
      (error:any)=>{
        console.error('No se pueden cargar articulos')
      }
    );
     

  }


}
