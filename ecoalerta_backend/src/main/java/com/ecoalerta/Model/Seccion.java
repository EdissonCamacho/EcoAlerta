package com.ecoalerta.Model;

import com.ecoalerta.Model.Articulo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "seccion", schema = "ecoalerta")
public class Seccion {
    @Id
    @Column(name = "Id_seccion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Nombre_seccion", length = 50)
    private String nombreSeccion;



}