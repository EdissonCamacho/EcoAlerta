package com.ecoalerta.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "usuario", schema = "ecoalerta")
public class Usuario {
    @Id
    @Column(name = "Id_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Size(max = 45)
    @Column(name = "usuario", length = 45,unique = true)
    private String usuario;

    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;

    @Size(max = 45)
    @Column(name = "apellido", length = 45)
    private String apellido;

    @Size(max = 45)
    @Column(name = "telefono", length = 45)
    private String telefono;

    @Size(max = 45)
    @Column(name = "email", length = 45)
    private String email;


    @Column(name = "password")
    private String password;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "account_No_Expired")
    private boolean accountNoExpired;

    @Column(name = "account_No_Locked")
    private boolean accountNoLocked;

    @Column(name = "credential_No_Expired")
    private boolean credentialNoExpired;


    @NotNull
    @ManyToOne()
    @JoinColumn(name = "Id_ciudad_FK", nullable = false)
    private Ciudad idCiudadFk;






}