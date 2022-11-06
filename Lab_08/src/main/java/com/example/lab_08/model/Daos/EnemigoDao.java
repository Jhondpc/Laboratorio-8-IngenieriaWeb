package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Enemigos;
import com.example.lab_08.model.Beans.Heroes;

import java.sql.*;
import java.util.ArrayList;

public class EnemigoDao extends DaoBase{

    public ArrayList<Enemigos> listarEnemigos(){

        ArrayList<Enemigos> listaEnemigos = new ArrayList<>();
        String sql1 = "SELECT e.idEnemigos, e.nombres, c.nombre, e.ataque, e.experiencia_x_derrota , o.nombre, eo.probabilidad_dejar_objeto " +
                "FROM enemigos e, clase c , enemigos_has_objeto_dejado_x_derrota eo, objeto_dejado_x_derrota o " +
                "Where e.clase_idClase1 = c.idClase " +
                "and   e.idEnemigos=eo.enemigos_idEnemigos " +
                "and   eo.objeto_dejado_x_derrota_idobjeto_dejado_x_derrota =o.idobjeto_dejado_x_derrota";
        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery(sql1) ) {


            while(rs.next()){
                Enemigos enemigo = new Enemigos();
                enemigo.setIdEnemigos(rs.getInt(1));
                enemigo.setNombre(rs.getString(2));
                enemigo.setClase(rs.getString(3));
                enemigo.setAtaque(rs.getInt(4));
                enemigo.setExperienciaPorDerrota(rs.getInt(5));
                enemigo.setObejtoDejado(rs.getString(6));
                enemigo.setProbaDejarObjetos(rs.getFloat(7));

                listaEnemigos.add(enemigo);
            }


        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return listaEnemigos;
    }


    public void crearEnemigo(Enemigos enemigo){


        String sql = "insert into enemigos (nombre,clase,experiencia_x_derrota,ataque) values (?,?,?,?,?)";
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


    public ArrayList<Enemigos> buscarEnemigos(String nombreEnemigo){
        ArrayList<Enemigos> listaEnemigos = new ArrayList<>();
        String sql1 = "SELECT e.idEnemigos, e.nombres, c.nombre, e.ataque, e.experiencia_x_derrota , o.nombre, eo.probabilidad_dejar_objeto " +
                "FROM enemigos e, clase c , enemigos_has_objeto_dejado_x_derrota eo, objeto_dejado_x_derrota o " +
                "Where lower(e.nombres) like ? and e.clase_idClase1 = c.idClase " +
                "and   e.idEnemigos=eo.enemigos_idEnemigos " +
                "and   eo.objeto_dejado_x_derrota_idobjeto_dejado_x_derrota =o.idobjeto_dejado_x_derrota ";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql1)) {

            pstmt.setString(1, "%"+nombreEnemigo+"%");

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Enemigos enemigo = new Enemigos();
                enemigo.setIdEnemigos(rs.getInt(1));
                enemigo.setNombre(rs.getString(2));
                enemigo.setClase(rs.getString(3));
                enemigo.setAtaque(rs.getInt(4));
                enemigo.setExperienciaPorDerrota(rs.getInt(5));
                enemigo.setObejtoDejado(rs.getString(6));
                enemigo.setProbaDejarObjetos(rs.getFloat(7));

                listaEnemigos.add(enemigo);
            }


        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return listaEnemigos;

    }



}
