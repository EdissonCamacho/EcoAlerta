package com.ecoalerta.Services;

import com.ecoalerta.Model.Imagen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Component
@Repository
public interface ServImagen extends CrudRepository<Imagen, Integer> {



}
