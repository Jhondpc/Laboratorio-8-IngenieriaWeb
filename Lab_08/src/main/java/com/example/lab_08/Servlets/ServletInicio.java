package com.example.lab_08.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletInicio", value = "/index")
public class ServletInicio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        action = (action == null) ? "home" : action;
        RequestDispatcher requestDispatcher;

        switch (action) {
            case "home":
                requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "heroes":
                requestDispatcher = request.getRequestDispatcher("heroes.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "enemigos":
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
