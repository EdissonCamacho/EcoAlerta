package com.ecoalerta.Services;

import com.ecoalerta.Model.Departamento;
import com.ecoalerta.Model.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ServiceRol extends CrudRepository<Rol, Integer> {


}