package com.example.myapplication.Temas;

public class Tematicas {
    private int id_tematica;
    private String nombreTematica;

    public Tematicas(int id_tematica, String nombreTematica) {
        this.id_tematica = id_tematica;
        this.nombreTematica = nombreTematica;
    }

    public Tematicas() {

    }

    public int getId_tematica() {
        return id_tematica;
    }

    public void setId_tematica(int id_tematica) {
        this.id_tematica = id_tematica;
    }

    public String getNombreTematica() {
        return nombreTematica;
    }

    public void setNombreTematica(String nombreTematica) {
        this.nombreTematica = nombreTematica;
    }

    @Override
    public String toString() {
        return "Tematicas{" +
                "id_tematica=" + id_tematica +
                ", nombreTematica='" + nombreTematica + '\'' +
                '}';
    }
}
