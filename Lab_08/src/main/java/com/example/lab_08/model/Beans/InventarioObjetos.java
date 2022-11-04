package com.example.lab_08.model.Beans;

public class InventarioObjetos {

    private int idInventarioObjetos;
    private String nombre;
    private String uso;
    private int peso;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getIdInventarioObjetos() {
        return idInventarioObjetos;
    }

    public void setIdInventarioObjetos(int idInventarioObjetos) {
        this.idInventarioObjetos = idInventarioObjetos;
    }
}
