package com.ecoalerta.Services;

import com.ecoalerta.Model.RolUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
@Service

public interface ServiceRolUsuario extends CrudRepository <RolUsuario, Integer> {

}