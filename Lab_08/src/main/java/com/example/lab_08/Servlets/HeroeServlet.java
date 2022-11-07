package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Enemigos;
import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Daos.*;
import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Daos.HeroeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HeroeServlet", value = "/HeroeServlet")
public class HeroeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion")==null?"inicio":request.getParameter("accion");
        RequestDispatcher view;
        HeroeDao hDao = new HeroeDao();
        //ArrayList<Heroes> listaHeroes;
        Heroes heroe;
        int idHeroe;
        switch (accion){

            case "inicio":

                request.setAttribute("listaHeroes", hDao.listarHeroes());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroes.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "inventario":
                String nombreHeroe = request.getParameter("nombreHeroe");
                request.setAttribute("listaInventario", hDao.listarInvObjetos(nombreHeroe));
                RequestDispatcher vista = request.getRequestDispatcher("inventarioObjetos.jsp");
                vista.forward(request, response);
                break;
            case "listar":

                //istaHeroes =
                request.setAttribute("listaHeroes", hDao.listarHeroes());
                view = request.getRequestDispatcher("heroes.jsp");
                view.forward(request,response);
                break;
            case "editar":

                int HeroeId = Integer.parseInt(request.getParameter("id"));
                Heroes heroeEdit = hDao.buscarporIdHeroe(HeroeId);

                if (heroeEdit != null) { //abro el form para editar
                    request.setAttribute("heroeEdit", heroeEdit);
                    requestDispatcher = request.getRequestDispatcher("formEditarHeroe.jsp");
                    requestDispatcher.forward(request, response);
                } else { //id no encontrado
                    response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                }
                break;
            case "crear":
                view = request.getRequestDispatcher("agregar_heroe.jsp");
                view.forward(request,response);
                break;

            case "borrar":  // JobServlet?action=borrar&id=50
                idHeroe = Integer.parseInt(request.getParameter("id"));
                hDao.borrarheroe(idHeroe);

                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        HeroeDao hDao = new HeroeDao();
        switch (accion) {

            case "guardar":

                String nombre = request.getParameter("Nombre");
                int edad = Integer.parseInt(request.getParameter("Edad"));
                String genero = request.getParameter("Genero");
                String clase = request.getParameter("Clase"); //en la tabla va idclase
                int idClase = 0;
                int nivelInicial = Integer.parseInt(request.getParameter("NivelInicial"));
                int ataque = Integer.parseInt(request.getParameter("Ataque"));
                int idPareja = Integer.parseInt(request.getParameter("IDPareja"));

                switch (clase.toLowerCase()){
                    case "dragon": idClase = 1; break;
                    case "fantasma": idClase = 2; break;
                    case "demonio": idClase = 3; break;
                    case "pez": idClase = 4; break;
                    case "humano": idClase = 5; break;
                    case "bestia": idClase = 6; break;
                    case "ave": idClase = 7; break;
                    case "otros": idClase = 8; break;
                }
                
                Heroes heroe = new Heroes();
                heroe.setNombre(nombre);
                heroe.setEdad(edad);
                heroe.setGenero(genero);
                heroe.setIdClase(idClase);
                heroe.setNivelInicial(nivelInicial);
                heroe.setAtaque(ataque);
                heroe.setIdPareja(idPareja);


                float experiencia;
                if (heroe.getNivelInicial()>0 && heroe.getNivelInicial()<=15){

                    experiencia= (float) ((Math.pow(heroe.getNivelInicial(),3)*(24+(heroe.getNivelInicial() + 1 ))/3 ) /50);
                    heroe.setPtosExperiencia(experiencia);

                } else if (heroe.getNivelInicial()>=16 && heroe.getNivelInicial()<=35) {
                    experiencia= (float) ( (Math.pow(heroe.getNivelInicial(),3)*(heroe.getNivelInicial() + 14) ) /50);
                    heroe.setPtosExperiencia(experiencia);
                } else if (heroe.getNivelInicial()>=36 && heroe.getNivelInicial()<=100) {
                    experiencia= (float) ( (Math.pow(heroe.getNivelInicial(),3)*( 32 +(heroe.getNivelInicial()/2) ) ) /50);
                    heroe.setPtosExperiencia(experiencia);
                }
                hDao.crearHeroe(heroe);

                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;

            case "actualizar":

                int id_heroe = Integer.parseInt(request.getParameter("IdHeroe"));
                String nombre1=request.getParameter("Nombre");
                int edad1= Integer.parseInt(request.getParameter("Edad"));
                String genero1=request.getParameter("Genero");
                int nivelInicial1= Integer.parseInt(request.getParameter("NivelInicial"));
                int ataque1 = Integer.parseInt(request.getParameter("Ataque"));
                int idPareja1 = Integer.parseInt(request.getParameter("IdPareja"));
                String clase1 = request.getParameter("Clase");
                int idClase1 = 0;
                switch (clase1.toLowerCase()){
                    case "dragon": idClase1 = 1; break;
                    case "fantasma": idClase1 = 2; break;
                    case "demonio": idClase1 = 3; break;
                    case "pez": idClase1 = 4; break;
                    case "humano": idClase1 = 5; break;
                    case "bestia": idClase1 = 6; break;
                    case "ave": idClase1 = 7; break;
                    case "otros": idClase1 = 8; break;
                }
                float experiencia1 = 0;
                if (nivelInicial1>0 && nivelInicial1<=15){

                    experiencia1 = (float) ((Math.pow(nivelInicial1,3)*(24+(nivelInicial1 + 1 ))/3 ) /50);

                } else if (nivelInicial1>=16 && nivelInicial1<=35) {
                    experiencia1= (float) ( (Math.pow(nivelInicial1,3)*(nivelInicial1 + 14) ) /50);
                } else if (nivelInicial1>=36 && nivelInicial1<=100) {
                    experiencia1= (float) ( (Math.pow(nivelInicial1,3)*( 32 +(nivelInicial1/2) ) ) /50);
                }
                hDao.editarHeroe(id_heroe,nombre1,edad1 ,genero1 , nivelInicial1, idPareja1, ataque1,experiencia1,idClase1);
                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                /*
                try {
                    //int minSalary1 = Integer.parseInt(minSalaryStr1);
                    //int maxSalary1 = Integer.parseInt(maxSalaryStr1);
                    hDao.editarHeroe(nombre1,edad1 ,genero1 , nivelInicial1, idPareja1, ataque1 );

                    response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                } catch (NumberFormatException e) {
                    response.sendRedirect(request.getContextPath() + "/JobServlet?action=editar&id=" + id_heroe);
                }
                */
                break;

            case "buscar":
                String searchText = request.getParameter("searchText");

                ArrayList<Heroes> listaHeroes = hDao.buscarporNombreHeroe(searchText);
                request.setAttribute("listaHeroes", listaHeroes);


                RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroes.jsp");
                requestDispatcher.forward(request, response);
                break;

        }



    }
}
