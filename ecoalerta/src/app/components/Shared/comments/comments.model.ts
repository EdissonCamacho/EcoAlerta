export interface Comment {
    id: number;
    author: string;
    content: string;
    editing: boolean;
    replies: Comment[];
    replying?: boolean; // Propiedad opcional para indicar si se está respondiendo a este comentario

  }