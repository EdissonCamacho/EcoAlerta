package com.ecoalerta.Services;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceLike extends CrudRepository<Like,Integer> {

    Iterable<Like>  findByIdArticuloFk(Articulo a);
}
