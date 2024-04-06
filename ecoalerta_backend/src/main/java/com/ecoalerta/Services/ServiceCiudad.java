package com.ecoalerta.Services;

import com.ecoalerta.Model.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ServiceCiudad extends CrudRepository<Ciudad,Integer> {
}
