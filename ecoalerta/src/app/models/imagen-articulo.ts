import { Articulo } from "./Articulo";
import { Imagen } from "./imagen";

export interface ImagenArticulo {
    idImagenArticulo:number,
    articulo:Articulo,
    imagen:Imagen
}
