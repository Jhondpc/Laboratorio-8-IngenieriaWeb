package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Hechizos;
import com.example.lab_08.model.Beans.Heroes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HechizoDao extends DaoBase {

    public ArrayList<Hechizos> listarHechizos(){

        ArrayList<Hechizos> listaHechizos = new ArrayList<>();

        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery("select * from hechizos")) {

            while(rs.next()){
                Hechizos hechizo = new Hechizos();
                hechizo.setIdHechizos(rs.getInt(1));
                hechizo.setNombre(rs.getString(2));
                hechizo.setPotencia(rs.getInt(3));
                hechizo.setPrecision(rs.getInt(4));
                hechizo.setNivelAprendizaje(rs.getInt(5));
                hechizo.setHechizoBase(rs.getInt(6));
                listaHechizos.add(hechizo);
            }


        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return listaHechizos;
    }



}
