
import { Component, OnInit } from '@angular/core';
import { SeccionComponent } from '../seccion/seccion.component';
@Component({
  selector: 'app-carrusel',
  standalone: true,
  imports: [SeccionComponent],
  templateUrl: './carrusel.component.html',
  styleUrl: './carrusel.component.css'
})
export class CarruselComponent implements OnInit {

  

 
  items:string[]=["assets/images/paramo1.jpg","assets/images/paramo2.jpeg","assets/images/paramo3.jpeg"];
  elementos:number=this.items.length
  index:number=0;
  ruta:string=this.items[0];

  ngOnInit(): void {
    setInterval(() => {
      this.siguiente();
    }, 2000);

   
    
    
  }
  
  anterior(){
    
    if(this.index==0){
      this.ruta=this.items[0]
      
    }else{
      this.ruta=this.items[--this.index]

    }

   


 }
 siguiente(){
  if(this.index==this.elementos-1){
    this.index=0;
    this.ruta=this.items[0];
  
  }else{
    this.ruta=this.items[++this.index]

  }
  

   
  
 }

}
