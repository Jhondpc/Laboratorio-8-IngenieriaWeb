package com.example.lab_08.Servlets;

import com.example.lab_08.model.Daos.EnemigoDao;
import com.example.lab_08.model.Daos.HechizoDao;
import com.example.lab_08.model.Daos.HeroeDao;
import com.example.lab_08.model.Daos.ObjetoDao;
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
        HechizoDao hechizoDao = new HechizoDao();
        ObjetoDao oDao = new ObjetoDao();

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
            case "inventario":
                String nomHeroe = request.getParameter("nombreHeroe");
                request.setAttribute("listaInventario", hDao.listarInvObjetos(nomHeroe));
                requestDispatcher = request.getRequestDispatcher("inventarioObjetos.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "enemigos":

                request.setAttribute("listaEnemigos", eDao.listarEnemigos());
                requestDispatcher = request.getRequestDispatcher("enemigo.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "hechizos":
                request.setAttribute("listaHechizos", hechizoDao.listarHechizos());
                requestDispatcher = request.getRequestDispatcher("hechizos.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "catalogo":
                request.setAttribute("listaObjetos", oDao.listarObjetos());
                requestDispatcher = request.getRequestDispatcher("catalogo.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
