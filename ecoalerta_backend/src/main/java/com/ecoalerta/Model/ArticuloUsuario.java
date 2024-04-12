package com.ecoalerta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "articulo_usuario", schema = "ecoalerta")
public class ArticuloUsuario {
    @Id
    @Column(name = "Id_Articulo_Usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_usuario_FK", nullable = false)
    private Usuario idUsuarioFk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_articulo_FK", nullable = false)
    private Articulo idArticuloFk;

}