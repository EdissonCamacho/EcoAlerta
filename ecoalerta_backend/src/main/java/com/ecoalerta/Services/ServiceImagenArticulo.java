package com.ecoalerta.Services;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Imagenarticulo;
import com.ecoalerta.Model.Seccion;
import com.ecoalerta.Operaciones.ImagenArticulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ServiceImagenArticulo extends CrudRepository<Imagenarticulo,Integer> {

    Iterable<Imagenarticulo> findByIdArticuloFk(Articulo a);

}
