package com.example.Base_Conciertos.Beans;

public class Artistas {
    private int idArtistas;
    private String Nombre_Grupo;
    private String Fecha_creacion;
    private String Tipo_musica;

    public int getIdArtistas() {
        return idArtistas;
    }

    public void setIdArtistas(int idArtistas) {
        this.idArtistas = idArtistas;
    }

    public String getNombre_Grupo() {
        return Nombre_Grupo;
    }

    public void setNombre_Grupo(String nombre_Grupo) {
        Nombre_Grupo = nombre_Grupo;
    }

    public String getFecha_creacion() {
        return Fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        Fecha_creacion = fecha_creacion;
    }

    public String getTipo_musica() {
        return Tipo_musica;
    }

    public void setTipo_musica(String tipo_musica) {
        Tipo_musica = tipo_musica;
    }
}
