package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Heroes;
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
        HeroeDao hDao = new HeroeDao();
        ArrayList<Heroes> listaHeroes = null;
        Heroes heroe;
        int idHeroe;
        switch (accion){

            case "listar":

                request.setAttribute("listaHeroes", hDao.listarHeroes());
                view = request.getRequestDispatcher("/Heroe/heroes.jsp");
                view.forward(request,response);
                break;

            case "editar":
                idHeroe = Integer.parseInt(request.getParameter("id_heroe"));
                heroe = hDao.buscarporIdHeroe(idHeroe);

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
                view = request.getRequestDispatcher("agregar_heroe.jsp");
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
