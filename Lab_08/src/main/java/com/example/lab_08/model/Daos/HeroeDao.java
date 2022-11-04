package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Beans.Heroes;

import java.sql.*;
import java.util.ArrayList;

public class HeroeDao extends DaoBase{

    public ArrayList<Heroes> listarHeroes(){

        ArrayList<Heroes> listaHeroes = new ArrayList<>();

        try (Connection connection = this.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select * from heroes")) {


            while(rs.next()){
                Heroes heroe = new Heroes();
                heroe.setIdHeroes(rs.getInt(1));
                heroe.setNombre(rs.getString(2));
                heroe.setEdad(rs.getInt(3));
                heroe.setGenero(rs.getString(4));
                heroe.setNivelInicial(rs.getInt(5));
                heroe.setAtaque(rs.getInt(6));
                heroe.setPtosExperiencia(rs.getInt(8));
                listaHeroes.add(heroe);
            }


        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return listaHeroes;
    }


    public void crearHeroe(Heroes heroe){


        String sql = "insert into heroes (nombre,edad,genero,nivel_inicial,ataque,id_pareja) values (?,?,?,?,?,?,?)";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1,heroe.getIdHeroes());
            pstmt.setString(2,heroe.getNombre());
            pstmt.setInt(3,heroe.getEdad());
            pstmt.setString(4,heroe.getGenero());
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


    }


}
