import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RouterLink } from '@angular/router';
import { RouterLinkActive } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-articule',
  standalone: true,
  imports: [ReactiveFormsModule,RouterOutlet,RouterLink,RouterLinkActive],
  templateUrl: './articule.component.html',
  styleUrl: './articule.component.css'
})
export class ArticuleComponent implements OnInit {
constructor(private route: ActivatedRoute){

}

  ngOnInit(): void {
    
    this.obtenerParamsUrl();
  }

  private sub: any;
  id:number=0;

  obtenerParamsUrl(){
    this.sub=this.route.params.subscribe(params=>{
      this.id=+params['id']
      console.log(this.id);
    });
  }

}
