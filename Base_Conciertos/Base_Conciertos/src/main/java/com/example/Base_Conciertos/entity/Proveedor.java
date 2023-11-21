package com.example.Base_Conciertos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="proveedores")
public class Proveedor {
    @Id
    @Column(nullable = false)
    private int idProveedores;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Telefono")
    private int telefono;
    @Column(name = "Elemento")
    private String elemento;
}
