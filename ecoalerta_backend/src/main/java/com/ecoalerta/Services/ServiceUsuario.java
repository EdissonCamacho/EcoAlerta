package com.ecoalerta.Services;

import com.ecoalerta.Model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface ServiceUsuario extends CrudRepository <Usuario, Integer> {

   @Query("SELECT u FROM Usuario u WHERE u.usuario = :username")
   Optional<Usuario> findByUsuario(@Param("username") String username);


}
