import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Comment } from './comments.model';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-comments',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './comments.component.html',
  styleUrl: './comments.component.css'
})
export class CommentsComponent implements OnInit {

  comments: Comment[] = [];  
  replyContent: string = '';

  constructor() { }

  ngOnInit(): void {
    // Cargar comentarios desde servicio o API
    this.loadComments();
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
  deleteComment(comment: Comment) {
    const index = this.comments.indexOf(comment);
    if (index !== -1) {
      this.comments.splice(index, 1);
    }
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

}
