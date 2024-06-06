import { Seccion } from "./Seccion";
import { ImagenArticulo } from "./imagen-articulo";


export interface Articulo{
    id:number;
    idSeccionFk:Seccion;
    tituloArticulo:string;
    informacionArticulo:string;
    imagenArticulo:ImagenArticulo

}