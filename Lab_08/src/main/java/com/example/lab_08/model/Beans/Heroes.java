package com.example.lab_08.model.Beans;

public class Heroes {

    private int idHeroes;
    private String nombre;
    private int edad;
    private String genero;
    private int nivelInicial;
    private int ataque;
    private float ptosExperiencia;
    private String clase;
    private int idClase;
    private String pareja;
    private int idPareja;
    public int idSoltero = 0;


    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public String getPareja() {
        return pareja;
    }

    public void setPareja(String pareja) {
        this.pareja = pareja;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    int cantidadObjetos; //duda: falta getter y setter


    public int getIdHeroes() {
        return idHeroes;
    }

    public void setIdHeroes(int idHeroes) {
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

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

//Clase clase;





}
