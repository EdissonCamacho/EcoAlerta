package com.ecoalerta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "imagenarticulo", schema = "ecoalerta")
public class Imagenarticulo {
    @Id
    @Column(name = "Id_imagen_articulo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "Id_articulo_FK", nullable = false)
    private Articulo idArticuloFk;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "Id_imagen_FK", nullable = false)
    private Imagen idImagenFk;

}