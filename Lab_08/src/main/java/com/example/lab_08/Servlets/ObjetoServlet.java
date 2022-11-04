package com.example.lab_08.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ObjetoServlet", value = "/ObjetoServlet")
public class ObjetoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion")==null?"inicio":request.getParameter("accion");
        RequestDispatcher view;

        switch (accion){

            case "agregarObjeto":
                view = request.getRequestDispatcher("agregar_objeto.jsp");
                view.forward(request,response);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
