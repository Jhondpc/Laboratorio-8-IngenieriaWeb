package com.example.lab_08.Servlets;

import com.example.lab_08.model.Daos.EnemigoDao;
import com.example.lab_08.model.Daos.HeroeDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletInicio", value = "/index")
public class ServletInicio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        action = (action == null) ? "inicio" : action;
        RequestDispatcher requestDispatcher;
        HeroeDao hDao = new HeroeDao();
        EnemigoDao eDao = new EnemigoDao();


        switch (action) {
            case "inicio":
                requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "heroes":

                request.setAttribute("listaHeroes", hDao.listarHeroes());
                requestDispatcher = request.getRequestDispatcher("heroes.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "enemigos":

                request.setAttribute("listaHeroes", eDao.listarEnemigos());
                requestDispatcher = request.getRequestDispatcher("enemigo.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "hechizos":
                requestDispatcher = request.getRequestDispatcher("hechizos.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "catalogo":
                requestDispatcher = request.getRequestDispatcher("catalogo.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
