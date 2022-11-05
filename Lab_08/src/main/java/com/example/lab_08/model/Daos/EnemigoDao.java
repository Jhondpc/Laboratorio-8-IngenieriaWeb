package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Enemigos;
import com.example.lab_08.model.Beans.Heroes;

import java.sql.*;
import java.util.ArrayList;

public class EnemigoDao extends DaoBase{

    public ArrayList<Enemigos> listarEnemigos(){

        ArrayList<Enemigos> listaEnemigos = new ArrayList<>();

        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM enemigos")) {


            while(rs.next()){
                Enemigos enemigo = new Enemigos();
                enemigo.setIdEnemigos(rs.getInt(1));
                enemigo.setNombre(rs.getString(2));
                enemigo.setGenero(rs.getString(3));
                enemigo.setExperienciaPorDerrota(rs.getInt(4));
                enemigo.setAtaque(rs.getInt(5));

                listaEnemigos.add(enemigo);
            }


        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return listaEnemigos;
    }


    public void crearEnemigo(Enemigos enemigo){


        String sql = "insert into enemigos (nombre,genero,experiencia_x_derrota,ataque) values (?,?,?,?,?)";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1,enemigo.getIdEnemigos());
            pstmt.setString(2,enemigo.getNombre());
            pstmt.setString(4,enemigo.getGenero());
            pstmt.setInt(5,enemigo.getExperienciaPorDerrota());
            pstmt.setInt(6,enemigo.getAtaque());
            //pstmt.setInt(7,heroe.getIdPareja());
            //pstmt.setInt(8,heroe.getPtosExperiencia());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void editarEnemigo(String nombreUpdate, String generoUpdate, int nivelUpdate, int ataqueUpdate){

        String sql = "update enemigos set nombre=?,genero=?,nivel_inicial=?,ataque=?,id_pareja=? where id_heroe=?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            //pstmt.setInt(1,heroe.getIdHeroes());
            pstmt.setString(1,nombreUpdate);
            //pstmt.setInt(2,edadUpdate);
            pstmt.setString(2,generoUpdate);
            pstmt.setInt(3,nivelUpdate);
            pstmt.setInt(4,ataqueUpdate);
            //pstmt.setInt(7,heroe.getIdPareja());


            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void borrarEnemigo(int idEnemigo){
        String sql = "DELETE FROM enemigos WHERE idEnemigo = ?"; //sentencia de sql para eliminar un registro a partir del id que ingresa el usuario

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idEnemigo);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public Enemigos buscarporIdEnemigo(int idEnemigo){

        Enemigos enemigo = null;

        String sql = "select * from enemigos where idEnemigos=?";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idEnemigo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    enemigo = new Enemigos(); //instanciando al heroe
                    enemigo.setIdEnemigos(rs.getInt(1));
                    enemigo.setNombre(rs.getString(2));
                    enemigo.setGenero(rs.getString(3));
                    enemigo.setExperienciaPorDerrota(rs.getInt(4));
                    enemigo.setAtaque(rs.getInt(5));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return enemigo;

    }


    public ArrayList<Enemigos> buscarporNombreEnemigo(String nombreEnemigo){

        ArrayList<Enemigos> listaEnemigos = null;

        String sql = "select * from enemigos where nombre=?";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, nombreEnemigo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {

                    Enemigos enemigo = new Enemigos(); //instanciando al enemigo
                    enemigo.setIdEnemigos(rs.getInt(1));
                    enemigo.setNombre(rs.getString(2));
                    enemigo.setGenero(rs.getString(3));
                    enemigo.setExperienciaPorDerrota(rs.getInt(4));
                    enemigo.setAtaque(rs.getInt(5));
                    listaEnemigos.add(enemigo);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaEnemigos;

    }
}
