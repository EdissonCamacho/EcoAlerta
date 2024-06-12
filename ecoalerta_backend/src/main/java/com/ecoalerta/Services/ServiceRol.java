package com.ecoalerta.Services;

import com.ecoalerta.Model.Departamento;
import com.ecoalerta.Model.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ServiceRol extends CrudRepository<Rol, Integer> {

    @Query(value = "select rol.Id_rol,rol.Nombre_rol from rol  inner join rol_usuario rol_usuario on rol.Id_rol= rol_usuario.Id_rol_FK inner join usuario  on usuario.Id_usuario=rol_usuario.Id_usuario_FK where usuario.usuario=?1",nativeQuery = true)
    Collection<Rol> findRolesByUsuario (String usuario);


}