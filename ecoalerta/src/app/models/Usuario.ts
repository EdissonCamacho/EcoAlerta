export interface Departamento{
    id:1,
    nombreDepartamento:"Boyacá"
}

export interface Ciudad{
    id:1,
    nombreCiudad:"Paipa",
    idDepartamentoFk:Departamento


}

export interface Usuario{
    id:number,
    usuario:string,
    nombre:string,
    apellido:string,
    telefono:string,
    email:string,
    password:string,
    isEnabled:true,
    accountNoExpired:true,
    accountNoLocked:true,
    credentialNoExpired:true,
    idCiudadFk:Ciudad
    enabled:true

}

