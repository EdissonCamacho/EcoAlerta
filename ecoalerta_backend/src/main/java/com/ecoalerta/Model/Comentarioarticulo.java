package com.ecoalerta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comentarioarticulo", schema = "ecoalerta")
public class Comentarioarticulo {
    @Id
    @Column(name = "Id_comentario_articulo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_articulo_FK", nullable = false)
    private Articulo idArticuloFk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_comentario_FK", nullable = false)
    private Comentario idComentarioFk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_usuario_FK", nullable = false)
    private Usuario idUsuarioFk;

}