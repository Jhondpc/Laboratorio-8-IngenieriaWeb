package com.example.lab_08.model.Beans;

public class Heroes {

    private Integer idHeroes;
    private String nombre;
    private int edad;
    private String genero;
    private int nivelInicial;
    private int ataque;
    private float ptosExperiencia; //puede salir decimal

    //private int idPareja;
    Clase clase; //duda

    int cantidadObjetos; //duda: falta getter y setter


    public Integer getIdHeroes() {
        return idHeroes;
    }

    public void setIdHeroes(Integer idHeroes) {
        this.idHeroes = idHeroes;
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

    public int getNivelInicial() {
        return nivelInicial;
    }

    public void setNivelInicial(int nivelInicial) {
        this.nivelInicial = nivelInicial;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public float getPtosExperiencia() {
        return ptosExperiencia;
    }

    public void setPtosExperiencia(float ptosExperiencia) {
        this.ptosExperiencia = ptosExperiencia;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    //Clase clase;





}