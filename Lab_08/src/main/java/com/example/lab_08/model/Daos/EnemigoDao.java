package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.EnemigoDejaObjeto;
import com.example.lab_08.model.Beans.EnemigoProbDejarObjeto;
import com.example.lab_08.model.Beans.Enemigos;
import com.example.lab_08.model.Beans.Heroes;

import java.sql.*;
import java.util.ArrayList;

public class EnemigoDao extends DaoBase{

    public ArrayList<Enemigos> listarEnemigos(){

        ArrayList<Enemigos> listaEnemigos = new ArrayList<>();
        String sql1 = "select e.idEnemigos, e.nombres, c.nombre, e.ataque, e.experiencia_x_derrota , o.nombre, eo.probabilidad_dejar_objeto\n" +
                "from enemigos e left join clase c on (e.clase_idClase1 = c.idClase)\n" +
                "left join enemigos_has_objeto_dejado_x_derrota eo on (e.idEnemigos=eo.enemigos_idEnemigos)\n" +
                "left join objeto_dejado_x_derrota o on (eo.objeto_dejado_x_derrota_idobjeto_dejado_x_derrota =o.idobjeto_dejado_x_derrota)";
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

        String sql = "INSERT INTO `mydb`.`enemigos` (`nombres`, `genero`, `experiencia_x_derrota`, `ataque`, `clase_idClase1`) VALUES (?, ?, ?, ?,?);";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1,enemigo.getNombre());
            pstmt.setString(2,enemigo.getGenero());
            pstmt.setInt(3,enemigo.getExperienciaPorDerrota());
            pstmt.setInt(4,enemigo.getAtaque());
            pstmt.setInt(5,enemigo.getIdClase());
            //pstmt.setFloat(6,enemigo.getProbaDejarObjetos());
            //pstmt.setString(7,enemigo.getObejtoDejado());


            //pstmt.setInt(6,enemigo.getIdEnemigos());
            //pstmt.setInt(5,enemigo.getIdClase());
            //pstmt.setInt(8,heroe.getPtosExperiencia());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int buscarIdEnemigoCreado(){

        int idCreado = 0;
        String sql1 = "select max(idEnemigos) from mydb.enemigos";
        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery(sql1) ) {


            while(rs.next()){
                idCreado = (rs.getInt(1));
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return idCreado;
    }

    public void crearObjeto(EnemigoDejaObjeto objeto){

        String sql = "INSERT INTO `mydb`.`objeto_dejado_x_derrota` (`nombre`) VALUES (?);";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1,objeto.getNombreObjetoDejado());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int buscarIdObjetoCreado(){

        int idCreado = 0;
        String sql1 = "select max(idobjeto_dejado_x_derrota) from mydb.objeto_dejado_x_derrota;";
        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery(sql1) ) {


            while(rs.next()){
                idCreado = (rs.getInt(1));
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return idCreado;
    }

    public Enemigos buscarporIdEnemigo(int idEnemigo){

        String idEnemigoStr = String.valueOf(idEnemigo);
        Enemigos enemigoEdit = null;

        String sql = "select * from enemigos WHERE idEnemigos = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, idEnemigoStr);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    enemigoEdit = new Enemigos();
                    enemigoEdit.setIdEnemigos(rs.getInt(1));
                    enemigoEdit.setNombre(rs.getString(2));
                    enemigoEdit.setGenero(rs.getString(3));
                    enemigoEdit.setExperienciaPorDerrota(rs.getInt(4));
                    enemigoEdit.setAtaque(rs.getInt(5));
                    enemigoEdit.setIdClase(rs.getInt(6));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enemigoEdit;

    }

    public void crearProbDejarObjeto(EnemigoProbDejarObjeto enemigoProbDejarObjeto){

        String sql = "INSERT INTO `mydb`.`enemigos_has_objeto_dejado_x_derrota` (`enemigos_idEnemigos`, `objeto_dejado_x_derrota_idobjeto_dejado_x_derrota`, `probabilidad_dejar_objeto`) VALUES (?,?,?);";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1,enemigoProbDejarObjeto.getIdEnemigo());
            pstmt.setInt(2,enemigoProbDejarObjeto.getIdObjetoDejato());
            pstmt.setFloat(3,enemigoProbDejarObjeto.getProbDejarObj());

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
        String sql1 = "SELECT e.idEnemigos, e.nombres, c.nombre, e.ataque, e.experiencia_x_derrota , o.nombre, eo.probabilidad_dejar_objeto\n" +
                "from enemigos e left join clase c on (lower(e.nombres) like ? and e.clase_idClase1 = c.idClase) \n" +
                "left join enemigos_has_objeto_dejado_x_derrota eo on (e.idEnemigos=eo.enemigos_idEnemigos) \n" +
                "left join objeto_dejado_x_derrota o on (eo.objeto_dejado_x_derrota_idobjeto_dejado_x_derrota =o.idobjeto_dejado_x_derrota);";
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
