package com.ecoalerta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "rol_usuario", schema = "ecoalerta")
public class RolUsuario {

    @Id
    @Column(name = "Id_rol_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "Id_usuario_FK", nullable = false)
    private Usuario idUsuarioFk;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "Id_rol_FK", nullable = false)
    private Rol idRolFk;

}