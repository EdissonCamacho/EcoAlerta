package com.ecoalerta.Services;

import com.ecoalerta.Model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service

public interface ServiceUsuario extends CrudRepository <Usuario, Integer> {

}
