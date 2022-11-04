package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Enemigos;
import com.example.lab_08.model.Beans.Heroes;

import java.sql.*;
import java.util.ArrayList;

public class EnemigoDao extends DaoBase{

    public ArrayList<Enemigos> listarHeroes(){

        ArrayList<Enemigos> listaEnemigos = new ArrayList<>();

        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery("select * from enemigos")) {

            Enemigos enemigo = new Enemigos();
            while(rs.next()){
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


    public void editarHeroe(String nombreUpdate, int edadUpdate, String generoUpdate, int nivelUpdate, int id_parejaUpdate, int ataqueUpdate){

        String sql = "update enemigos set nombre=?,edad=?,genero=?,nivel_inicial=?,ataque=?,id_pareja=? where id_heroe=?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            //pstmt.setInt(1,heroe.getIdHeroes());
            pstmt.setString(1,nombreUpdate);
            pstmt.setInt(2,edadUpdate);
            pstmt.setString(3,generoUpdate);
            pstmt.setInt(4,nivelUpdate);
            pstmt.setInt(5,id_parejaUpdate);
            //pstmt.setInt(7,heroe.getIdPareja());


            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void borrarheroe(int idHeroe){
        String sql = "DELETE FROM heroes WHERE idHeroe = ?"; //sentencia de sql para eliminar un registro a partir del id que ingresa el usuario

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idHeroe);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public Heroes buscarporIdHeroe(int idHeroe){

        Heroes heroe = null;

        String sql = "select * from heroes where idHeroe=?";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idHeroe);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    heroe = new Heroes(); //instanciando al heroe
                    heroe.setIdHeroes(rs.getInt(1));
                    heroe.setEdad(rs.getInt(2));
                    heroe.setGenero(rs.getString(3));
                    heroe.setNivelInicial(rs.getInt(4));
                    heroe.setAtaque(rs.getInt(5));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return heroe;

    }


    public ArrayList<Heroes> buscarporNombreHeroe(String nombreHeroe){

        ArrayList<Heroes> listaHeroes = null;

        String sql = "select * from heroes where nombre=?";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, nombreHeroe);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {

                    Heroes heroe = new Heroes();
                    heroe.setIdHeroes(rs.getInt(1));
                    heroe.setEdad(rs.getInt(2));
                    heroe.setGenero(rs.getString(3));
                    heroe.setNivelInicial(rs.getInt(4));
                    heroe.setAtaque(rs.getInt(5));

                    listaHeroes.add(heroe);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaHeroes;

    }
}
