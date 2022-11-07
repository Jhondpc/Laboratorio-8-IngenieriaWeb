package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Hechizos;
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

            case "inicio": //crear
                view = request.getRequestDispatcher("hechizos.jsp");
                view.forward(request,response);
                break;

            case "agregarHechizo": //crear
                view = request.getRequestDispatcher("agregar_hechizo.jsp");
                view.forward(request,response);
                break;

            case "borrar":  // JobServlet?action=borrar&id=50
                idHechizo = Integer.parseInt(request.getParameter("id_hechizo"));
                hDao.borrarHechizo(idHechizo);

                response.sendRedirect(request.getContextPath() + "/HechizoServlet");
                break;
            case "listar":

                request.setAttribute("listaHechizos", hDao.listarHechizos());
                view = request.getRequestDispatcher("hechizos.jsp");
                view.forward(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        HechizoDao hechizoDao = new HechizoDao();
        switch (accion) {

            case "guardar":

                String nombre = request.getParameter("Nombre");
                String elemento = request.getParameter("Elemento");
                String potenciastr = request.getParameter("Potencia");
                int potencia = Integer.parseInt(potenciastr);
                String precisionstr = request.getParameter("Precisión");
                int precision = Integer.parseInt(precisionstr);
                String hechizo_Basestr = request.getParameter("Hechizo_Base");


                String niveldeAprendizajestr = request.getParameter("NiveldeAprendizaje");
                int niveldeAprendizaje = Integer.parseInt(niveldeAprendizajestr);

                Hechizos hechizo = new Hechizos();
                hechizo.setNombre(nombre);
                hechizo.setElemento(elemento);
                hechizo.setPotencia(potencia);
                hechizo.setPrecision(precision);
                hechizo.setHechizoBase(hechizo_Basestr);
                hechizo.setNivelAprendizaje(niveldeAprendizaje);

                hechizoDao.crearHechizo(hechizo);

                response.sendRedirect(request.getContextPath()+"/HechizoServlet");
                break;
/*
            case "actualizar":

                int id_heroe = Integer.parseInt(request.getParameter("IdHeroe"));
                String nombre1=request.getParameter("Nombre");
                int edad1= Integer.parseInt(request.getParameter("Edad"));
                String genero1=request.getParameter("Genero");
                int nivelInicial1= Integer.parseInt(request.getParameter("Nivel"));
                int ataque1 = Integer.parseInt(request.getParameter("Ataque"));
                int idPareja1= Integer.parseInt(request.getParameter("IdPareja"));
                hDao.editarHeroe(nombre1,edad1 ,genero1 , nivelInicial1, idPareja1, ataque1 );
                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                /*
                try {
                    //int minSalary1 = Integer.parseInt(minSalaryStr1);
                    //int maxSalary1 = Integer.parseInt(maxSalaryStr1);
                    hDao.editarHeroe(nombre1,edad1 ,genero1 , nivelInicial1, idPareja1, ataque1 );

                    response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                } catch (NumberFormatException e) {
                    response.sendRedirect(request.getContextPath() + "/JobServlet?action=editar&id=" + id_heroe);
                }
                */
                /*break;

            case "buscar":
                String searchText = request.getParameter("searchText");

                ArrayList<Heroes> listaHeroes = hDao.buscarporNombreHeroe(searchText);
                request.setAttribute("listaHeroes", listaHeroes);


                RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroes.jsp");
                requestDispatcher.forward(request, response);
                break;*/

        }







    }
}
