package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Hechizos;
import com.example.lab_08.model.Beans.InventarioObjetos;
import com.example.lab_08.model.Daos.HechizoDao;
import com.example.lab_08.model.Daos.ObjetoDao;
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

            case "inicio": //crear
                view = request.getRequestDispatcher("catalogo.jsp");
                view.forward(request,response);
                break;

            case "agregarObjeto":
                view = request.getRequestDispatcher("agregar_objeto.jsp");
                view.forward(request,response);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        ObjetoDao oDao = new ObjetoDao();
        switch (accion) {

            case "guardar":

                String nombre = request.getParameter("Nombre");
                String uso = request.getParameter("Uso");
                String Pesostr = request.getParameter("Peso");
                int peso = Integer.parseInt(Pesostr);


                InventarioObjetos inventarioObjetos = new InventarioObjetos();
                inventarioObjetos.setNombre(nombre);
                inventarioObjetos.setUso(uso);
                inventarioObjetos.setPeso(peso);


                oDao.crearObjeto(inventarioObjetos);

                response.sendRedirect(request.getContextPath() + "/index?action=catalogo");
                break;



        }

    }
}
