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
@Table(name = "concierto")
public class Concierto {
    @Id
    @Column(name = "idConcierto", nullable = false)
    private int id;
    @Column(name = "Fecha_evento", length = 45)
    private String fecha;
    @Column(name = "proveedores_idProveedores")
    private int idProveedor;
    @Column(name = "artistas_idArtistas")
    private int idArtista;
}
