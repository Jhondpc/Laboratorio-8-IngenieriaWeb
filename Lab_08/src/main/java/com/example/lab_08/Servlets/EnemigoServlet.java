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
        String action = request.getParameter("action");
        EnemigoDao eDao = new EnemigoDao();

        switch (action) {
            case "guardar":

                String NombreEne = request.getParameter("Nombre");
                String Clase = request.getParameter("Clase");
                String Ataquestr = request.getParameter("Ataque");
                int Ataque = Integer.parseInt(Ataquestr);
                String expstr = request.getParameter("ExperienciaporDerrota");
                int ExperienciaporDerrota = Integer.parseInt(expstr);
                String objetoDejado = request.getParameter("Obejtodejado");
                String probadejarobjetoStr = request.getParameter("ProbabildiaddedejarObjetos");
                float probDejarObjeto = Float.parseFloat(probadejarobjetoStr);

                Enemigos enemigo = new Enemigos();


                enemigo.setNombre(NombreEne);
                enemigo.setClase(Clase);
                enemigo.setAtaque(Ataque);
                enemigo.setExperienciaPorDerrota(ExperienciaporDerrota);
                enemigo.setObejtoDejado(objetoDejado);
                enemigo.setProbaDejarObjetos(probDejarObjeto);



                eDao.crearEnemigo(enemigo);


                break;

            case "actualizar":


                break;
            /*
            case "buscar":
                String searchText = request.getParameter("searchText");

                request.setAttribute("listaEnemigos", eDao.buscarEnemigos(searchText));
                requestDispatcher = request.getRequestDispatcher("enemigo.jsp");
                requestDispatcher.forward(request, response);
                break;*/


        }
    }
}
