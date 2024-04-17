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
@Table(name = "imagen", schema = "ecoalerta")
public class Imagen {
    @Id
    @Column(name = "Id_imagen", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Descripcion", length = 50)
    private String descripcion;

    @Size(max = 100)
    @Column(name = "Url", length = 100)
    private String url;


}