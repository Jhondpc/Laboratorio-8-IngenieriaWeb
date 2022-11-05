package com.example.lab_08.Servlets;

import com.example.lab_08.model.Daos.ClaseDao;
import com.example.lab_08.model.Daos.ElementoDao;
import com.example.lab_08.model.Daos.HechizoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ClaseServlet", value = "/ClaseServlet")
public class ClaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion")==null?"inicio":request.getParameter("accion");
        RequestDispatcher view;
        ElementoDao eleDao = new ElementoDao();
        int idElemneto;

        switch (accion){

            case "inicio": //crear
                view = request.getRequestDispatcher("clase_enemigos.jsp");
                view.forward(request,response);
                break;

            case "habilidad":
                request.setAttribute("listaElementos", eleDao.listarElemento());
                view = request.getRequestDispatcher("debilidades_fortalezas.jsp");
                view.forward(request,response);
                break;
            /*
            case "borrar":  // JobServlet?action=borrar&id=50
                idHechizo = Integer.parseInt(request.getParameter("id_hechizo"));
                hDao.borrarHechizo(idHechizo);

                response.sendRedirect(request.getContextPath() + "/HechizoServlet");
                break;
                *//*
            case "listar":

                request.setAttribute("listaHechizos", hcDao.listarHechizos());
                view = request.getRequestDispatcher("hechizos.jsp");
                view.forward(request,response);
                break;*/
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
