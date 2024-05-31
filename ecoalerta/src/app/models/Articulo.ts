import { Seccion } from "./Seccion";


export interface Articulo{
    id:number;
    idSeccionFk:Seccion;
    tituloArticulo:string;
    informacionArticulo:string;

}