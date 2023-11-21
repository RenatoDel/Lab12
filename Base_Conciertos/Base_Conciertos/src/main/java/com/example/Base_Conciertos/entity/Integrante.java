package com.example.Base_Conciertos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "integrantes")
public class Integrante {
    @Id
    @Column(name = "idIntegrantes", nullable = false)
    private int id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Edad")
    private int edad;
    @Column(name = "Anhios_exp")
    private int anhios;
    @Column(name = "rol")
    private String rol;
    @Column(name = "artistas_idArtistas", nullable = false)
    private int artistasId;
}
