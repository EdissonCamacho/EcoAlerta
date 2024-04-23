package com.ecoalerta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`like`", schema = "ecoalerta")
public class Like {
    @Id
    @Column(name = "Id_like", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "Id_articulo_FK", nullable = false)
    private Articulo idArticuloFk;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "Id_usuario_FK", nullable = false)
    private Usuario idUsuarioFk;


}