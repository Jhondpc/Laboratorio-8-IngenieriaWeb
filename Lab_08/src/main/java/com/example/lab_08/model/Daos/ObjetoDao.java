package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Hechizos;
import com.example.lab_08.model.Beans.InventarioObjetos;

import java.sql.*;
import java.util.ArrayList;

public class ObjetoDao extends DaoBase{


    //listar objeto
    public ArrayList<InventarioObjetos> listarObjetos(){

        ArrayList<InventarioObjetos> listaObjetos = new ArrayList<>();

        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();

             ResultSet rs = stm.executeQuery("select * from inventarioobjetos")) {

            while(rs.next()){

                InventarioObjetos objeto = new InventarioObjetos();
                objeto.setIdInventarioObjetos(rs.getInt(1));
                objeto.setNombre(rs.getString(2));
                objeto.setUso(rs.getString(3));
                objeto.setPeso(rs.getInt(4));

                listaObjetos.add(objeto);
            }


        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return listaObjetos;
    }

        //borrar objeto
    public void borrarObjeto(int idObjeto){
        String sql = "DELETE FROM inventarioobjetos WHERE idInventarioObjetos = ?"; //sentencia de sql para eliminar un registro a partir del id que ingresa el usuario

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idObjeto);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public ArrayList<InventarioObjetos> buscarporNombreObjeto(String nombreObjeto){

        ArrayList<InventarioObjetos> listaObjetos = null;

        String sql = "select * from inventarioobjetos where nombre=?";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, nombreObjeto);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {

                    InventarioObjetos objeto = new InventarioObjetos();
                    objeto.setIdInventarioObjetos(rs.getInt(1));
                    objeto.setNombre(rs.getString(2));
                    objeto.setUso(rs.getString(3));
                    objeto.setPeso(rs.getInt(4));
                    listaObjetos.add(objeto);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaObjetos;


    }

    public void editarObjeto(String idInventarioObjeto, String nombre, int uso, int peso) {

        String url = "jdbc:mysql://localhost:3306/hr";
        String sql = "UPDATE inventarioobjetos SET nombre = ?, uso = ?, peso = ? WHERE idInventarioObjetos = ?";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            //en el orden en que se llama con respecto a la sentencia sql
            pstmt.setString(4, idInventarioObjeto); //ultimo
            pstmt.setString(1, nombre); //primero
            pstmt.setInt(2, uso); //segundo
            pstmt.setInt(3, peso); //tercero

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearObjeto(InventarioObjetos objeto){


        String sql = "INSERT INTO `mydb`.`inventarioobjetos` (`nombre`, `uso`, `peso`) VALUES (?, ?, ?)";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {


            pstmt.setString(1,objeto.getNombre());
            pstmt.setString(2,objeto.getUso());
            pstmt.setInt(3,objeto.getPeso());


            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
