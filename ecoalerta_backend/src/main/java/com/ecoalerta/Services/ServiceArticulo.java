package com.ecoalerta.Services;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Seccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ServiceArticulo extends CrudRepository<Articulo,Integer> {

    Iterable<Articulo> findByidSeccionFk(Seccion seccion);
}
