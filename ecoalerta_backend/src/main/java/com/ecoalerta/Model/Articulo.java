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
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_seccion_FK", nullable = false)
    private Seccion idSeccionFk;

    @Size(max = 50)
    @Column(name = "Titulo_articulo", length = 50)
    private String tituloArticulo;

    @Size(max = 45)
    @Column(name = "Informacion_articulo", length = 45)
    private String informacionArticulo;

    @OneToMany(mappedBy = "idArticuloFk")
    private Set<ArticuloUsuario> articuloUsuarios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idArticuloFk")
    private Set<Comentarioarticulo> comentarioarticulos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idArticuloFk")
    private Set<Imagenarticulo> imagenarticulos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idArticuloFk")
    private Set<Like> likes = new LinkedHashSet<>();

}