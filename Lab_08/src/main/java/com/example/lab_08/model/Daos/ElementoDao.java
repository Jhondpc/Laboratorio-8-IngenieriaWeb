package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Clase;
import com.example.lab_08.model.Beans.Elemento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ElementoDao extends DaoBase{

    public ArrayList<Elemento> listarElemento(){

        ArrayList<Elemento> listarElemento = new ArrayList<>();

        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();

             ResultSet rs = stm.executeQuery("select * from elementos")) {

            while(rs.next()){

                Elemento elemento = new Elemento();
                elemento.setIdElemento(rs.getInt(1));
                elemento.setNombre(rs.getString(2));


                listarElemento.add(elemento);
            }


        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return listarElemento;
    }


}
