package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Daos.EnemigoDao;
import com.example.lab_08.model.Daos.HechizoDao;
import com.example.lab_08.model.Daos.HeroeDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HechizoServlet", value = "/HechizoServlet")
public class HechizoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion")==null?"inicio":request.getParameter("accion");
        RequestDispatcher view;
        HechizoDao hDao = new HechizoDao();
        int idHechizo;

        switch (accion){

            case "agregarHechizo": //crear
                view = request.getRequestDispatcher("agregar_hechizo.jsp");
                view.forward(request,response);
                break;
            /*
            case "borrar":  // JobServlet?action=borrar&id=50
                idHechizo = Integer.parseInt(request.getParameter("id_enemigo"));
                hDao.borrarhechizo(idHechizo);

                response.sendRedirect(request.getContextPath() + "/EnemigoServlet");
                break;
                */
            case "listar":

                request.setAttribute("listaEnemigos", hDao.listarHechizos());
                view = request.getRequestDispatcher("enemigos.jsp");
                view.forward(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");




    }
}
