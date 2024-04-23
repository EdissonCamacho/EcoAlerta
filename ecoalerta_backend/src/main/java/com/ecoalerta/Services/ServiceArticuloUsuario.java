package com.ecoalerta.Services;


import com.ecoalerta.Model.ArticuloUsuario;
import com.ecoalerta.Model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ServiceArticuloUsuario extends CrudRepository<ArticuloUsuario,Integer> {

    Iterable<ArticuloUsuario> findArticuloUsuarioByIdUsuarioFk(Usuario usuario);
}
