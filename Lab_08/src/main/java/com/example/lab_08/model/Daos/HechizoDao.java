package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Hechizos;
import com.example.lab_08.model.Beans.Heroes;

import java.sql.*;
import java.util.ArrayList;

public class HechizoDao extends DaoBase {

    public ArrayList<Hechizos> listarHechizos(){

        ArrayList<Hechizos> listaHechizos = new ArrayList<>();

        try (Connection connection = this.getConnection();
             Statement stm = connection.createStatement();
             ResultSet rs = stm.executeQuery("SELECT h.idHechizoMagicos, h.nombre,  ele.nombre, h.potencia, h.precision, hb.nombre, h.nivel_aprendizaje\n" +
                     "FROM hechizo_magicos h\n" +
                     "left join elementos ele on (h.elementos_idelementos = ele.idelementos)\n" +
                     "left join hechizo_magicos hb on (h.hechizo_base = hb.idHechizoMagicos)")) {


            while(rs.next()){
                Hechizos hechizo = new Hechizos();
                hechizo.setIdHechizos(rs.getInt(1));
                hechizo.setNombre(rs.getString(2));
                hechizo.setElemento(rs.getString(3));
                hechizo.setPotencia(rs.getInt(4));
                hechizo.setPrecision(rs.getInt(5));
                hechizo.setHechizoBase(rs.getInt(6));
                hechizo.setNivelAprendizaje(rs.getInt(7));
                listaHechizos.add(hechizo);
            }


        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


        return listaHechizos;
    }

    public void crearHechizo(Hechizos hechizo){


        String sql = "insert into hechizos_magicos (nombre,potencia,precision,nivel_aprendizaje,id_pareja) values (?,?,?,?,?,?,?)";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1,hechizo.getIdHechizos());
            pstmt.setString(2,hechizo.getNombre());
            pstmt.setInt(3,hechizo.getPotencia());
            pstmt.setInt(4,hechizo.getPrecision());
            pstmt.setInt(5,hechizo.getNivelAprendizaje());
            //pstmt.setInt(6,hechizo.getAtaque());
            //pstmt.setInt(7,heroe.getIdPareja());
            //pstmt.setInt(8,heroe.getPtosExperiencia());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public void borrarHechizo(int idHechizo){
        String sql = "DELETE FROM hechizos_magicos WHERE idHechizosMagicos = ?"; //sentencia de sql para eliminar un registro a partir del id que ingresa el usuario

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idHechizo);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public ArrayList<Hechizos> buscarporNombreHechizo(String nombreHechizo){

        ArrayList<Hechizos> listaHechizos = null;

        String sql = "select * from hechizos_magicos where nombre=?";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, nombreHechizo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {

                    Hechizos hechizo = new Hechizos();
                    hechizo.setIdHechizos(rs.getInt(1));
                    hechizo.setNombre(rs.getString(2));
                    hechizo.setPotencia(rs.getInt(3));
                    hechizo.setPrecision(rs.getInt(4));
                    hechizo.setNivelAprendizaje(rs.getInt(5));
                    hechizo.setHechizoBase(rs.getInt(6));

                    listaHechizos.add(hechizo);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaHechizos;

    }


    //metodo para actualizar(update en el CRUD)
    public void editarHechizo(String jobId, String nombre, int potencia, int precision, int hechizo_base) {

        String url = "jdbc:mysql://localhost:3306/hr";
        String sql = "UPDATE hechizos_magicos SET nombre = ?, potencia = ?, precision = ?, nivel_aprendizaje=?, hechizo_base=? WHERE idHechizosMagicos = ?";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            //en el orden en que se llama con respecto a la sentencia sql
            pstmt.setString(4, jobId); //ultimo
            pstmt.setString(1, nombre); //primero
            pstmt.setInt(2, potencia); //segundo
            pstmt.setInt(3, precision); //tercero


            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }







}
