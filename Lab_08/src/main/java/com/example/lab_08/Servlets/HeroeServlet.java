package com.example.lab_08.Servlets;

import com.example.lab_08.model.Beans.Heroes;
import com.example.lab_08.model.Daos.HeroeDao;
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
        ArrayList<Heroes> listaHeroes = null;

        switch (accion){

            case "listar":

                request.setAttribute("listaHeroes", hDao.listarHeroes());
                view = request.getRequestDispatcher("/Heroe/listar.jsp");
                view.forward(request,response);
                break;

            case "editar":
                view = request.getRequestDispatcher("/Heroe/editarHeroe.jsp");
                view.forward(request,response);
                break;

            case "crear":

                break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        HeroeDao hDao = new HeroeDao();
        switch (action) {

            case "crear":

                String nombre=request.getParameter("nombre");
                int edad= Integer.parseInt(request.getParameter("edad"));
                String genero=request.getParameter("genero");
                int nivelInicial= Integer.parseInt(request.getParameter("nivel"));
                int ataque = Integer.parseInt(request.getParameter("ataque"));
                String idPareja=request.getParameter("idPareja");


                Heroes heroe = new Heroes();
                heroe.setNombre(nombre);
                heroe.setEdad(edad);
                heroe.setGenero(genero);
                heroe.setNivelInicial(nivelInicial);
                heroe.setAtaque(ataque);
                //para el calculo de nivel experiencia
                float experiencia;
                if (heroe.getNivelInicial()>0 && heroe.getNivelInicial()>15){

                    experiencia= (float) ((Math.pow(heroe.getNivelInicial(),3)*(24+(heroe.getNivelInicial() + 1 ))/3 ) /50);
                    heroe.setPtosExperiencia(experiencia);

                } else if (heroe.getNivelInicial()>16 && heroe.getNivelInicial()>35) {
                    experiencia= (float) ( (Math.pow(heroe.getNivelInicial(),3)*(heroe.getNivelInicial() + 14) ) /50);
                    heroe.setPtosExperiencia(experiencia);
                } else if (heroe.getNivelInicial()>36 && heroe.getNivelInicial()>100) {
                    experiencia= (float) ( (Math.pow(heroe.getNivelInicial(),3)*( 32 +(heroe.getNivelInicial()/2) ) ) /50);
                    heroe.setPtosExperiencia(experiencia);
                }
                hDao.crearHeroe(heroe);

                response.sendRedirect(request.getContextPath() + "/HeroeServlet");
                break;

            case "actualizar":


        }



    }
}
