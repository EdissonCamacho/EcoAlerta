package com.ecoalerta.Services;

import com.ecoalerta.Model.Articulo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ServiceArticulo extends CrudRepository<Articulo,Integer> {
}
