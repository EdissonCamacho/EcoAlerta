package com.ecoalerta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "departamento", schema = "ecoalerta")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_departamento", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Nombre_departamento", length = 50)
    private String nombreDepartamento;

    //@OneToMany(mappedBy = "idDepartamentoFk")
    //private Set<Ciudad> ciudads = new LinkedHashSet<>();

}