package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Enemigos;
import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Daos.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EnemigoServlet", value = "/EnemigoServlet")
public class EnemigoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion")==null?"inicio":request.getParameter("accion");
        RequestDispatcher view;
        EnemigoDao eDao = new EnemigoDao();
        ArrayList<Enemigos> listaEnemigos;
        Enemigos enemigo;
        ClaseDao cDao = new ClaseDao();
        ElementoDao eleDao= new ElementoDao();

        int idEnemigo;
        switch (accion){

            case "inicio": //crear
                request.setAttribute("listaEnemigos", eDao.listarEnemigos());
                view = request.getRequestDispatcher("enemigo.jsp");
                view.forward(request,response);
                break;

            case "elements":

                request.setAttribute("listaElementos", eleDao.listarElemento());
                view = request.getRequestDispatcher("debilidades_fortalezas.jsp");
                view.forward(request,response);
                break;
            /*
            case "editar":
                idEnemigo = Integer.parseInt(request.getParameter("id_heroe"));
                enemigo = eDao.buscarporIdEnemigo(idEnemigo);

                if (enemigo != null){
                    request.setAttribute("enemigo", enemigo);
                    view = request.getRequestDispatcher("editarEnemigo.jsp");
                    view.forward(request,response);
                } else {
                    //id no encontrado
                    response.sendRedirect(request.getContextPath() + "/EnemigoServlet");
                }
                break;*/

            case "crear":

                view = request.getRequestDispatcher("agregar_enemigo.jsp");
                view.forward(request,response);
                break;
            case "clase":

                request.setAttribute("listaClase", cDao.listarClases());
                view = request.getRequestDispatcher("clase_enemigos.jsp");
                view.forward(request,response);
                break;

            case "borrar":  // JobServlet?action=borrar&id=50
                idEnemigo = Integer.parseInt(request.getParameter("id_heroe"));
                eDao.borrarEnemigo(idEnemigo);

                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("action");
        EnemigoDao eDao = new EnemigoDao();

        switch (accion) {
            case "guardar":

                String nombre = request.getParameter("Nombre");
                int idClase = Integer.parseInt(request.getParameter("Clase")); //en la tabla va idclase
                int ataque = Integer.parseInt(request.getParameter("Ataque"));
                int experienciaPorDerrota = Integer.parseInt(request.getParameter("ExperienciaPorDerrota"));
                String objetoDejado = request.getParameter("ObjetoDejado");
                String probaDejarDbjetoStr = request.getParameter("ProbabilidaDeDejarObjetos");
                float probDejarObjeto = Float.parseFloat(probaDejarDbjetoStr);
                String genero = request.getParameter("Genero");

                /*
                switch (clase){
                    case "Dragon": idClase = 1; break;
                    case "Fantasma": idClase = 2; break;
                    case "Demonio": idClase = 3; break;
                    case "Pez": idClase = 4; break;
                    case "Humano": idClase = 5; break;
                    case "Bestia": idClase = 6; break;
                    case "Ave": idClase = 7; break;
                    case "Otros": idClase = 8; break;
                }
                */

                Enemigos enemigo = new Enemigos();
                enemigo.setNombre(nombre);
                enemigo.setIdClase(idClase);
                enemigo.setAtaque(ataque);
                enemigo.setExperienciaPorDerrota(experienciaPorDerrota);
                enemigo.setObejtoDejado(objetoDejado);
                enemigo.setProbaDejarObjetos(probDejarObjeto);
                enemigo.setGenero(genero);
                eDao.crearEnemigo(enemigo);

                response.sendRedirect(request.getContextPath() + "/EnemigoServlet");

                break;

            case "actualizar":


                break;

            case "buscar":
                String searchText = request.getParameter("searchText");

                ArrayList<Enemigos> listaEnemigos = eDao.buscarEnemigos(searchText);
                request.setAttribute("listaEnemigos", listaEnemigos);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("enemigo.jsp");
                requestDispatcher.forward(request, response);
                break;


        }
    }
}
