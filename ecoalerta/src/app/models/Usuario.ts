export interface Usuario{
    id:number,
    usuario:string,
    nombre:string,
    apellido:string,
    telefono:string,
    email:string,
    password:string,
    isEnabled:boolean,
    accountNoExpired:boolean,
    accountNoLocked:boolean,
    credentialNoExpired:boolean,
}