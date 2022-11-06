package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Enemigos;
import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Daos.*;
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

@WebServlet(name = "HeroeServlet", value = "/HeroeServlet")
public class HeroeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion")==null?"inicio":request.getParameter("accion");
        RequestDispatcher view;
        HeroeDao hDao = new HeroeDao();
        //ArrayList<Heroes> listaHeroes;
        Heroes heroe;
        int idHeroe;
        switch (accion){

            case "inicio":

                request.setAttribute("listaHeroes", hDao.listarHeroes());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("heroes.jsp");
                requestDispatcher.forward(request, response);
                break;
                
            case "listar":

                //istaHeroes =
                request.setAttribute("listaHeroes", hDao.listarHeroes());
                view = request.getRequestDispatcher("heroes.jsp");
                view.forward(request,response);
                break;
            case "editar":
                idHeroe = Integer.parseInt(request.getParameter("id_heroe"));
                heroe = hDao.buscarporIdHeroe(idHeroe);

                if (heroe != null){
                    request.setAttribute("heroe", heroe);
                    view = request.getRequestDispatcher("editarHeroe.jsp");
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

            case "borrar":  // JobServlet?action=borrar&id=50
                idHeroe = Integer.parseInt(request.getParameter("id_heroe"));
                hDao.borrarheroe(idHeroe);

                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        HeroeDao hDao = new HeroeDao();
        switch (action) {

            case "guardar":

                String nombre = request.getParameter("Nombre");
                int edad = Integer.parseInt(request.getParameter("Edad"));
                String genero = request.getParameter("Genero");
                String clase = request.getParameter("Clase"); //en la tabla va idclase
                int idClase = 0;
                int nivelInicial = Integer.parseInt(request.getParameter("NivelInicial"));
                int ataque = Integer.parseInt(request.getParameter("Ataque"));
                int idPareja = Integer.parseInt(request.getParameter("IDPareja"));

                switch (clase){
                    case "Dragon": idClase = 1; break;
                    case "Fantasma": idClase = 2; break;
                    case "Demonio": idClase = 3; break;
                    case "Pez": idClase = 4; break;
                    case "Humano": idClase = 5; break;
                    case "Bestia": idClase = 6; break;
                    case "Ave": idClase = 7; break;
                    case "Otros": idClase = 8; break;
                }
                
                Heroes heroe = new Heroes();
                heroe.setNombre(nombre);
                heroe.setEdad(edad);
                heroe.setGenero(genero);
                heroe.setIdClase(idClase);
                heroe.setNivelInicial(nivelInicial);
                heroe.setAtaque(ataque);
                heroe.setIdPareja(idPareja);


                float experiencia;
                if (heroe.getNivelInicial()>0 && heroe.getNivelInicial()<=15){

                    experiencia= (float) ((Math.pow(heroe.getNivelInicial(),3)*(24+(heroe.getNivelInicial() + 1 ))/3 ) /50);
                    heroe.setPtosExperiencia(experiencia);

                } else if (heroe.getNivelInicial()>=16 && heroe.getNivelInicial()<=35) {
                    experiencia= (float) ( (Math.pow(heroe.getNivelInicial(),3)*(heroe.getNivelInicial() + 14) ) /50);
                    heroe.setPtosExperiencia(experiencia);
                } else if (heroe.getNivelInicial()>=36 && heroe.getNivelInicial()<=100) {
                    experiencia= (float) ( (Math.pow(heroe.getNivelInicial(),3)*( 32 +(heroe.getNivelInicial()/2) ) ) /50);
                    heroe.setPtosExperiencia(experiencia);
                }
                hDao.crearHeroe(heroe);

                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;

            case "actualizar":

                int id_heroe = Integer.parseInt(request.getParameter("idHeroe"));

                String nombre1=request.getParameter("nombre");
                int edad1= Integer.parseInt(request.getParameter("edad"));
                String genero1=request.getParameter("genero");
                int nivelInicial1= Integer.parseInt(request.getParameter("nivel"));
                int ataque1 = Integer.parseInt(request.getParameter("ataque"));
                int idPareja1= Integer.parseInt(request.getParameter("idPareja"));

                try {
                    //int minSalary1 = Integer.parseInt(minSalaryStr1);
                    //int maxSalary1 = Integer.parseInt(maxSalaryStr1);
                    hDao.editarHeroe(nombre1,edad1 ,genero1 , nivelInicial1, idPareja1, ataque1 );

                    response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                } catch (NumberFormatException e) {
                    response.sendRedirect(request.getContextPath() + "/JobServlet?action=editar&id=" + id_heroe);
                }

                break;

        }



    }
}
