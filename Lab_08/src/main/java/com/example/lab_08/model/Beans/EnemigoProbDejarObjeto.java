package com.example.lab_08.model.Beans;

public class EnemigoProbDejarObjeto {

    private int idEnemigo;
    private int idObjetoDejato;

    public int getIdEnemigo() {
        return idEnemigo;
    }

    public void setIdEnemigo(int idEnemigo) {
        this.idEnemigo = idEnemigo;
    }

    public int getIdObjetoDejato() {
        return idObjetoDejato;
    }

    public void setIdObjetoDejato(int idObjetoDejato) {
        this.idObjetoDejato = idObjetoDejato;
    }

    private float probDejarObj;

    public float getProbDejarObj() {
        return probDejarObj;
    }

    public void setProbDejarObj(float probDejarObj) {
        this.probDejarObj = probDejarObj;
    }
}
