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
@Table(name = "comentario", schema = "ecoalerta")
public class Comentario {
    @Id
    @Column(name = "Id_comentario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "comentario", length = 50)
    private String comentario;



}