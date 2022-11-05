package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Enemigos;
import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Daos.EnemigoDao;
import com.example.lab_08.model.Daos.HeroeDao;
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
        int idEnemigo;
        switch (accion){

            case "inicio": //crear
                view = request.getRequestDispatcher("enemigos.jsp");
                view.forward(request,response);
                break;

            case "listar":

                request.setAttribute("listaEnemigos", eDao.listarEnemigos());
                view = request.getRequestDispatcher("enemigos.jsp");
                view.forward(request,response);
                break;

            case "editar":
                idEnemigo = Integer.parseInt(request.getParameter("id_heroe"));
                enemigo = eDao.buscarporIdHeroe(idEnemigo);

                if (heroe != null){
                    request.setAttribute("heroe", heroe);
                    view = request.getRequestDispatcher("/Heroe/editarHeroe.jsp");
                    view.forward(request,response);
                } else {
                    //id no encontrado
                    response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                }
                break;

            case "crear":
                view = request.getRequestDispatcher("agregar_enemigo.jsp");
                view.forward(request,response);
                break;
            case "clase":
                view = request.getRequestDispatcher("clase_enemigos.jsp");
                view.forward(request,response);
                break;

            case "borrar":  // JobServlet?action=borrar&id=50
                idHeroe = Integer.parseInt(request.getParameter("id_heroe"));
                hDao.borrarheroe(idHeroe);

                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
