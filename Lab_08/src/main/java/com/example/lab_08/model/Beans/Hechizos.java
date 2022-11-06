package com.example.lab_08.model.Beans;

public class Hechizos {

    private Integer idHechizos;
    private String nombre;
    private int potencia;
    private int precision;
    private Integer nivelAprendizaje;
    private String hechizoBase;
    private String elemento;



    public Integer getIdHechizos() {
        return idHechizos;
    }

    public void setIdHechizos(Integer idHechizos) {
        this.idHechizos = idHechizos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public Integer getNivelAprendizaje() {
        return nivelAprendizaje;
    }

    public void setNivelAprendizaje(Integer nivelAprendizaje) {
        this.nivelAprendizaje = nivelAprendizaje;
    }

    public String getHechizoBase() {
        return hechizoBase;
    }

    public void setHechizoBase(String hechizoBase) {
        this.hechizoBase = hechizoBase;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }
}
