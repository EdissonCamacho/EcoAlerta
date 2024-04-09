package com.ecoalerta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "rol", schema = "ecoalerta")
public class Rol {

    @Id
    @Column(name = "Id_rol", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(max = 45)
    @Column(name = "Nombre_rol", length = 45)
    private String nombreRol;



}