import { Component, OnInit, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RouterLink } from '@angular/router';
import { RouterLinkActive } from '@angular/router';
import { Seccion } from '../../models/Seccion';
import { SeccionService } from './seccion.service';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [RouterOutlet,RouterLink,RouterLinkActive],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css',
  
})
export class NavComponent implements OnInit {

  
  public secciones: Seccion[] = [];
  
  constructor(private serviceSeccion: SeccionService) {

  }

 
  ngOnInit(): void {
    this.loadSecciones();
  }

  //Carga las sercciones 
  private loadSecciones(): void {
    // Lógica para cargar todas las secciones
    this.serviceSeccion.getSecciones().subscribe(
      (data: Seccion[]) => {
        this.secciones = data;
        // console.log(data);
      },
      (error) => {
        console.error('Error al obtener las secciones:', error);
      }
    );
  }
 


}
