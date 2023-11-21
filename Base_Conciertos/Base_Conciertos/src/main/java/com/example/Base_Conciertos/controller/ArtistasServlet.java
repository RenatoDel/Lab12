package com.example.Base_Conciertos.controller;

import com.example.Base_Conciertos.Daos.ArtistasDao;
import com.example.Base_Conciertos.Beans.Artistas;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ArtistasServlet", value = "/ArtistasServlet")
public class ArtistasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        RequestDispatcher view;
        ArtistasDao artistasDao = new ArtistasDao();
        switch (action){
            case "lista":
                request.setAttribute("listaArtistas", artistasDao.listaArtistas());
                view = request.getRequestDispatcher("employees/lista.jsp");
                view.forward(request, response);
                break;
            case "editar":
                if (request.getParameter("idArtistas") != null) {
                    String idArtistaString = request.getParameter("idArtistas");
                    int idArtista = 0;
                    try {
                        idArtista = Integer.parseInt(idArtistaString);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("ArtistasServlet");

                    }
                    Artistas art = artistasDao.obtenerArtistas(idArtista);

                    if (art != null) {
                        request.setAttribute("artistas", art);
                        request.setAttribute("listaArtistas",artistasDao.obtenerArtistas(idArtista));
                        view = request.getRequestDispatcher("employees/formularioEditar.jsp");
                        view.forward(request, response);
                    } else {
                        response.sendRedirect("ArtistasServlet");
                    }

                } else {
                    response.sendRedirect("ArtistasServlet");
                }

                break;
            case "borrar":
                if (request.getParameter("id") != null) {
                    String idArtistaString  = request.getParameter("idArtistas");
                    int idArtista = 0;
                    try {
                        idArtista = Integer.parseInt(idArtistaString);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("ArtistasServlet");
                    }

                    Artistas art = artistasDao.obtenerArtistas(idArtista);

                    if (art != null) {
                        artistasDao.borrarArtistas(idArtista);
                    }
                }

                response.sendRedirect("EmployeeServlet");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
