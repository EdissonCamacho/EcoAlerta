import { Component, inject } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { CommentsComponent } from '../Shared/comments/comments.component';
import { ArticuloService } from '../../Services/articulo.service';
import { Articulo } from '../../Models/Articulo';

@Component({
  selector: 'app-article',
  standalone: true,
  imports: [ReactiveFormsModule,RouterOutlet,RouterLink,RouterLinkActive, CommentsComponent ],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})
export class ArticleComponent {

  noticia = {
    titulo: 'Muerte de Akira Toriyama',
    texto: 'Akira Toriyama, el renombrado creador del icónico manga y anime "Dragon Ball", dejó un legado perdurable en el mundo del entretenimiento. Su genio creativo dio vida a personajes inolvidables y a historias llenas de acción y emoción. Su fallecimiento marca el fin de una era, pero su influencia perdurará en las generaciones venideras, inspirando a nuevos talentos y cautivando a fans de todo el mundo. Su obra sigue siendo un faro de creatividad y un tributo eterno a su brillantez.',
    imagenUrl: 'https://elcomercio.pe/resizer/nAuPrNU0Gin2RiKglJB52Ng4Bdg=/1200x1200/smart/filters:format(jpeg):quality(90)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/PTGU6VFE3BFWZPYW7IBQJCPCBI.jpg'
  };

  constructor(private route: ActivatedRoute){}
  
    ngOnInit(): void {
      
      this.obtenerParamsUrl();
      this.obtenerArticuloById(this.id);
     
    }
  
    private sub: any;
    id:number=0;
    private serviceArticulo=inject(ArticuloService);
    listaArticulos: any;
  
    obtenerParamsUrl(){
      this.sub=this.route.params.subscribe(params=>{
        this.id=+params['id']
        console.log(this.id);
      });
    }

    obtenerArticuloById(id: number){

      this.serviceArticulo.getArticulo(id).subscribe((
        data:any)=>{
        console.log(data);
        this.listaArticulos = data;
      }, (error:any) =>{ 
        console.log('El error es: '+error);
         }
      
    ) 


    }



}
