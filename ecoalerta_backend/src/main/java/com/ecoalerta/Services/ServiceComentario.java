package com.ecoalerta.Services;

import com.ecoalerta.Model.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ServiceComentario extends CrudRepository<Comentario,Integer > {
}
