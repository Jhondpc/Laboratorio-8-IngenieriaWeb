package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Beans.Heroes;

import java.sql.*;
import java.util.ArrayList;

public class HeroeDao extends DaoBase{

    public ArrayList<Heroes> listarHeroes(){
        ArrayList<Heroes> listaHeroes = new ArrayList<>();
        String sqlHeroe = "SELECT h.idheroes, h.nombre,  h.edad, h.genero, c.nombre, h.nivel_inicial, h.ataque, p.nombre, h.pts_x_experiencia\n" +
                "                FROM heroes h \n" +
                "                left join heroes p on (h.id_pareja = p.idheroes) \n" +
                "                inner join clase c on (h.clase_idClase = c.idClase )";
        try (Connection connection = this.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlHeroe)) {


            while(rs.next()){
                Heroes heroe = new Heroes();
                heroe.setIdHeroes(rs.getInt(1));
                heroe.setNombre(rs.getString(2));
                heroe.setEdad(rs.getInt(3));
                heroe.setGenero(rs.getString(4));
                heroe.setClase(rs.getInt(5));
                heroe.setNivelInicial(rs.getInt(6));
                heroe.setAtaque(rs.getInt(7));
                heroe.setIdPareja(rs.getString(8));
                heroe.setPtosExperiencia(rs.getInt(9));
                listaHeroes.add(heroe);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return listaHeroes;
    }


    public void crearHeroe(Heroes heroe){


        String sql = "insert into heroes (nombre,edad,genero,clase,nivel_inicial,ataque) values (?,?,?,?,?,?)";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            //pstmt.setInt(1,heroe.getIdHeroes());
            pstmt.setString(1,heroe.getNombre());
            pstmt.setInt(2,heroe.getEdad());
            pstmt.setString(3,heroe.getGenero());
            pstmt.setInt(4, heroe.getClase());
            pstmt.setInt(5,heroe.getNivelInicial());
            pstmt.setInt(6,heroe.getAtaque());
            //pstmt.setInt(7,heroe.getIdPareja());
            //pstmt.setInt(8,heroe.getPtosExperiencia());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void editarHeroe(String nombreUpdate, int edadUpdate, String generoUpdate, int nivelUpdate, int id_parejaUpdate, int ataqueUpdate){

        String sql = "update heroes set nombre=?,edad=?,genero=?,nivel_inicial=?,ataque=?,id_pareja=? where id_heroe=?";
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
