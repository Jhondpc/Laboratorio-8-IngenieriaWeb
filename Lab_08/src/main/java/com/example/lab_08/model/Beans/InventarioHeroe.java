package com.example.lab_08.model.Beans;

public class InventarioHeroe {

    private String nombreHeroe;
    private String nombreObjeto;
    private String uso;
    private int peso;
    private int cantObjetos;

    public String getNombreHeroe() {
        return nombreHeroe;
    }

    public void setNombreHeroe(String nombreHeroe) {
        this.nombreHeroe = nombreHeroe;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
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

    public int getCantObjetos() {
        return cantObjetos;
    }

    public void setCantObjetos(int cantObjetos) {
        this.cantObjetos = cantObjetos;
    }
}
