package com.example.lab_08.model.Beans;

public class Enemigos {

    private Integer idEnemigos;
    private String nombre;
    private int edad;
    private String genero;
    private int experienciaPorDerrota;

    private int ataque;
    private Clase clase;

    int idObjetoDejaDerrota; //duda: falta getter y setter



    public Integer getIdEnemigos() {
        return idEnemigos;
    }

    public void setIdEnemigos(Integer idEnemigos) {
        this.idEnemigos = idEnemigos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getExperienciaPorDerrota() {
        return experienciaPorDerrota;
    }

    public void setExperienciaPorDerrota(int experienciaPorDerrota) {
        this.experienciaPorDerrota = experienciaPorDerrota;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getIdObjetoDejaDerrota() {
        return idObjetoDejaDerrota;
    }

    public void setIdObjetoDejaDerrota(int idObjetoDejaDerrota) {
        this.idObjetoDejaDerrota = idObjetoDejaDerrota;
    }
}
