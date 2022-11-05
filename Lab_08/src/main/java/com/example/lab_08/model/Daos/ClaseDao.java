package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Clase;
import com.example.lab_08.model.Beans.InventarioObjetos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClaseDao extends DaoBase {

    //listar objeto
    public ArrayList<Clase> listarClases(){

        ArrayList<Clase> listaClases = new ArrayList<>();

        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();

             ResultSet rs = stm.executeQuery("select * from clase")) {

            while(rs.next()){

                Clase clase = new Clase();
                clase.setIdClase(rs.getInt(1));
                clase.setNombre(rs.getString(2));


                listaClases.add(clase);
            }


        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return listaClases;
    }
}
