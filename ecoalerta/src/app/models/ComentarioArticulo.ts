import { Articulo } from "./Articulo";
import { Comentario } from "./Comentario";
import { Usuario } from "./Usuario";

export interface ComentarioArticulo{
    id:number,
    idArticuloFk:Articulo,
    idComentarioFk:Comentario,
    idUsuarioFk:Usuario
}