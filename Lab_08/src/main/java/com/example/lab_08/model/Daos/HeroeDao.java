package com.example.lab_08.model.Daos;

import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Beans.InventarioHeroe;
import com.example.lab_08.model.Beans.InventarioObjetos;

import java.sql.*;
import java.util.ArrayList;

public class HeroeDao extends DaoBase{

    public ArrayList<Heroes> listarHeroes(){
        ArrayList<Heroes> listaHeroes = new ArrayList<>();
        String sqlHeroe = "SELECT h.idheroes, h.nombre,  h.edad, case when h.genero='M' then 'Masculino'\n" +
                "                when h.genero='F' then 'Femenino' when h.genero='O' then 'Otros' end,\n" +
                "                c.nombre, h.nivel_inicial, h.ataque, p.idheroes, h.pts_x_experiencia FROM heroes h\n" +
                "                left join heroes p on (h.id_pareja = p.idheroes) \n" +
                "                inner join clase c on (h.clase_idClase = c.idClase)";
        try (Connection connection = this.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlHeroe)) {


            while(rs.next()){
                Heroes heroe = new Heroes();
                heroe.setIdHeroes(rs.getInt(1));
                heroe.setNombre(rs.getString(2));
                heroe.setEdad(rs.getInt(3));
                heroe.setGenero(rs.getString(4));
                heroe.setClase(rs.getString(5));
                heroe.setNivelInicial(rs.getInt(6));
                heroe.setAtaque(rs.getInt(7));
                heroe.setIdPareja(rs.getInt(8));
                heroe.setPtosExperiencia(rs.getInt(9));
                listaHeroes.add(heroe);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return listaHeroes;

    }


    public void crearHeroe(Heroes heroe){

        System.out.println(heroe.getIdClase());
        String sql = "INSERT INTO `mydb`.`heroes` (`nombre`, `edad`, `genero`, `nivel_inicial`, `ataque`, `id_pareja`, `pts_x_experiencia`, `clase_idClase`) VALUES (?, ?, ?, ?,?, ?, ?, ?);";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1,heroe.getNombre());
            pstmt.setInt(2,heroe.getEdad());
            pstmt.setString(3,heroe.getGenero());
            pstmt.setInt(4,heroe.getNivelInicial());
            pstmt.setInt(5,heroe.getAtaque());
            pstmt.setInt(6,heroe.getIdPareja());
            pstmt.setFloat(7,heroe.getPtosExperiencia());
            pstmt.setInt(8, heroe.getIdClase());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void editarHeroe(int id,String nombreUpdate, int edadUpdate, String generoUpdate, int nivelUpdate, int id_parejaUpdate, int ataqueUpdate,float experienciaUpdate, int idClase1){

        String sql = "update heroes set nombre=?,edad=?,genero=?,nivel_inicial=?,ataque=?,id_pareja=?,pts_x_experiencia=?,clase_idClase=? where idheroes=?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(9,id);
            pstmt.setString(1,nombreUpdate);
            pstmt.setInt(2,edadUpdate);
            pstmt.setString(3,generoUpdate);
            pstmt.setInt(4,nivelUpdate);
            pstmt.setInt(5,ataqueUpdate);
            pstmt.setInt(6,id_parejaUpdate);
            pstmt.setFloat(7,experienciaUpdate);
            pstmt.setInt(8,idClase1);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void borrarheroe(int idHeroe){
        String sql = "DELETE FROM heroes WHERE idheroes = ?"; //sentencia de sql para eliminar un registro a partir del id que ingresa el usuario

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idHeroe);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public Heroes buscarporIdHeroe(int idHeroe){

        String idHeroeStr = String.valueOf(idHeroe);
        Heroes heroeEdit = null;

        String sql = "select * from heroes WHERE idheroes = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, idHeroeStr);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    heroeEdit = new Heroes();
                    heroeEdit.setIdHeroes(rs.getInt(1));
                    heroeEdit.setNombre(rs.getString(2));
                    heroeEdit.setEdad(rs.getInt(3));
                    heroeEdit.setGenero(rs.getString(4));
                    heroeEdit.setNivelInicial(rs.getInt(5));
                    heroeEdit.setAtaque(rs.getInt(6));
                    heroeEdit.setIdPareja(rs.getInt(7));
                    heroeEdit.setPtosExperiencia(rs.getInt(8));
                    heroeEdit.setIdClase(rs.getInt(9));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return heroeEdit;

    }


    public ArrayList<Heroes> buscarporNombreHeroe(String nombreHeroe){

        ArrayList<Heroes> listaHeroes = new ArrayList<>();
        String sql = "SELECT h.idheroes, h.nombre,  h.edad, case when h.genero='M' then 'Masculino'\n" +
                "        when h.genero='F' then 'Femenino' when h.genero='O' then 'Otros' end,\n" +
                "         c.nombre, h.nivel_inicial, h.ataque, p.idheroes, h.pts_x_experiencia FROM heroes h\n" +
                "         left join heroes p on (h.id_pareja = p.idheroes)\n" +
                "         inner join clase c on (h.clase_idClase = c.idClase) WHERE lower(h.nombre) like ? ";


        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%"+nombreHeroe+"%");

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Heroes HeroeBuscar = new Heroes();
                HeroeBuscar.setIdHeroes(rs.getInt(1));
                HeroeBuscar.setNombre(rs.getString(2));
                HeroeBuscar.setEdad(rs.getInt(3));
                HeroeBuscar.setGenero(rs.getString(4));
                HeroeBuscar.setClase(rs.getString(5));
                HeroeBuscar.setNivelInicial(rs.getInt(6));
                HeroeBuscar.setAtaque(rs.getInt(7));
                HeroeBuscar.setIdPareja(rs.getInt(8));
                HeroeBuscar.setPtosExperiencia(rs.getInt(9));
                listaHeroes.add(HeroeBuscar);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return listaHeroes;


    }

   public ArrayList<InventarioHeroe> listarInvObjetos(String nomHeroe){
        ArrayList<InventarioHeroe> listaObj = new ArrayList<>();

        String sql = "SELECT  he.nombre, inv.nombre, inv.uso, inv.peso, hi.cantidad_objetos FROM heroes_has_inventarioobjetos hi, heroes he, inventarioobjetos inv \n" +
                " where inv.idInventarioObjetos = hi.inventarioobjetos_idInventarioObjetos \n" +
                " and he.idheroes = hi.heroes_idheroes and he.nombre = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, nomHeroe);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                InventarioHeroe invHeroe = new InventarioHeroe();
                invHeroe.setNombreHeroe(rs.getString(1));
                invHeroe.setNombreObjeto(rs.getString(2));
                invHeroe.setUso(rs.getString(3));
                invHeroe.setPeso(rs.getInt(4));
                invHeroe.setCantObjetos(rs.getInt(5));

                listaObj.add(invHeroe);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return listaObj;

    }

}
