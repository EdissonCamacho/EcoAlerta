package com.ecoalerta.Services;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Comentarioarticulo;
import org.springframework.data.repository.CrudRepository;

public interface ServiceComentarioArticulo extends CrudRepository<Comentarioarticulo,Integer> {

 Iterable<Comentarioarticulo> findByidArticuloFk(Articulo articulo);

}
