import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { Comment } from './comments.model';
import { FormsModule } from '@angular/forms';
import { LoginService } from '../../../Services/login.service';
import { Router, RouterOutlet } from '@angular/router';
import { RouterLink } from '@angular/router';
import { RouterLinkActive } from '@angular/router';
import { ComentarioArticulo } from '../../../models/ComentarioArticulo';
import { ComentarioarticuloService } from '../../../Services/comentarioarticulo.service';
import { Articulo } from '../../../Models/Articulo';


@Component({
  selector: 'app-comments',
  standalone: true,
  imports: [CommonModule, FormsModule,RouterOutlet,RouterLink,RouterLinkActive],
  templateUrl: './comments.component.html',
  styleUrl: './comments.component.css'
})
export class CommentsComponent implements OnInit {

  comments: Comment[] = [];  
  replyContent: string = '';
  newCommentContent: string = ''; // Declaración de newCommentContent

  constructor(private router:Router,public loginService:LoginService,private serviceComentarioArticulo:ComentarioarticuloService) {  }
  @Input() articulo:any;
  listaComentarios:ComentarioArticulo[]=[]

  ngOnInit(): void {
    // Cargar comentarios desde servicio o API
  //  this.loadComments();
   // console.log(this.articulo);
   this.cargarComentarios();


  }
  

  cargarComentarios(){
    this.serviceComentarioArticulo.getAllByArticulo(this.articulo).subscribe(
      (data:ComentarioArticulo[])=>{
        this.listaComentarios=data;

       
      },
      (error:any)=>{
        console.log(error)
      }
    )
  }



   // Metodo para cargar comentarios (quemado por ahora)
  loadComments() {
    this.comments = [
      { id: 1, author: 'Usuario1', content: '¡Gran publicación!', editing: false, replies: [] },
      { id: 2, author: 'Usuario2', content: 'Gracias por compartir', editing: false, replies: [] },
      { id: 3, author: 'Usuario3', content: 'Me encanta este contenido', editing: false, replies: [] }
    ];
  }

  // Metodo para alternar entre editar y guardar un comentario
  toggleEdit(comment: Comment) {
    comment.editing = !comment.editing;
  }

  // Metodo para eliminar un comentario
  deleteComment(com:any) {

    this.serviceComentarioArticulo.delete(com).subscribe(
      (data)=>{
        console.log(data)
        this.cargarComentarios();
        
      }
      ,(error:any)=>{
        console.log(error)
        this.cargarComentarios();
      })

      

    /*
    const index = this.comments.indexOf(comment);
    if (index !== -1) {
      this.comments.splice(index, 1);
    }*/
  }

  // Metodo para alternar la visibilidad del area de respuesta a un comentario
  toggleReply(comment: Comment) {
    comment.replying = !comment.replying;
  }
  // Metodo para añadir la respuesta a un comentario
  addReply(comment: Comment) {
    comment.replies.push({ id: comment.replies.length + 1, author: 'Usuario', content: this.replyContent, editing: false, replies: [] });
    this.replyContent = '';
    comment.replying = false;
  }

  // Crear un nuevo comentario y agregarlo a la lista de comentarios
  createComment() {

    let comentarioar:any={
      idArticuloFk:{
        id:Number= this.articulo
      },
      idUsuarioFk:{
        usuario:this.loginService.username
      },
      idComentarioFk:{
        comentario:this.newCommentContent
      }
    }
    // Llamar al servicio para crear el comentario
    this.serviceComentarioArticulo.crear(comentarioar as ComentarioArticulo).subscribe(
      (data: any) => {
        console.log(data);
        this.cargarComentarios();
      },
      (error: any) => {
        console.log(error);
        this.cargarComentarios();
      }
      
    );

    this.newCommentContent="";

    /*
    const newComment: Comment = {
      id: this.comments.length + 1,
      author: 'Nuevo Usuario',
      content: this.newCommentContent, // Utilizamos el valor de newCommentContent
      editing: false,
      replies: []
    };
    this.comments.push(newComment);
    this.newCommentContent = ''; // Limpiamos el área de texto después de agregar el comentario*/
  }

}
