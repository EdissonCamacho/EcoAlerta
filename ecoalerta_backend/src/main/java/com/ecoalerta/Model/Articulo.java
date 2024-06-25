package com.ecoalerta.Model;

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
@Table(name = "articulo", schema = "ecoalerta")
public class Articulo {
    @Id
    @Column(name = "Id_articulo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "Id_seccion_FK", nullable = false)
    private Seccion idSeccionFk;


    @Column(name = "Titulo_articulo")
    private String tituloArticulo;

    @Size(max = 10000)
    @Column(name = "Informacion_articulo")
    private String informacionArticulo;



}