package com.ecoalerta.Services;

import com.ecoalerta.Model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface ServiceSeccion extends JpaRepository<Seccion,Integer> {
}
