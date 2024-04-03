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
@Table(name = "rol", schema = "ecoalerta")
public class Rol {
    @Id
    @Column(name = "Id_rol", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "Nombre_rol", length = 45)
    private String nombreRol;

    @OneToMany(mappedBy = "idRolFk")
    private Set<RolUsuario> rolUsuarios = new LinkedHashSet<>();

}