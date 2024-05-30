import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pagination',
  standalone: true,
  imports: [],
  templateUrl: './pagination.component.html',
  styleUrl: './pagination.component.css'
})
export class PaginationComponent implements OnInit ,OnDestroy {
  id:number=0;
  private sub: any;
  constructor( private route: ActivatedRoute){

  }
  ngOnInit(): void {
    //obtencion del path
    this.sub=this.route.params.subscribe(params=>{
      this.id=+params['id']
    });
   

  }
  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }


}
