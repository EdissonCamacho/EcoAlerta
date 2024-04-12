package com.ecoalerta.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ciudad", schema = "ecoalerta")
public class Ciudad {
    @Id
    @Column(name = "Id_ciudad", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Nombre_ciudad", length = 50)
    private String nombreCiudad;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "Id_departamento_FK", nullable = false)
    private Departamento idDepartamentoFk;



}