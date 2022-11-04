package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Heroes;
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

        switch (accion){

            case "agregarHechizo":
                view = request.getRequestDispatcher("agregar_hechizo.jsp");
                view.forward(request,response);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
