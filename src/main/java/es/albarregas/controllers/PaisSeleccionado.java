/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import DAO.DAOPaisSeleccionado;
import beans.Pais;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dcc_s
 */
@WebServlet(name = "PaisSeleccionado", urlPatterns = {"/PaisSeleccionado"})
public class PaisSeleccionado extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "JSP/vistaTraduccion.jsp";
        String enviar = (String) request.getParameter("enviar");
        DAOPaisSeleccionado dao = new DAOPaisSeleccionado();

        if (request.getParameter("paisElegido").equals("-1")) {
            url = "Paises";
        } else {
            String localePais = (String) request.getParameter("paisElegido");
            String[] atributosLocale = localePais.split("=");
            //atributosLocale[0]= nombre país en español (Ej. Noruega)
            //atributosLocale[1]= lenguaje país (Ej. de_De)
            Pais pais = dao.getByName(atributosLocale[1]);
            if (enviar.length() != 0 && pais != null) {
                request.setAttribute("pais", pais);
            } else {
                request.setAttribute("paisDefault", atributosLocale[0]);
            }
        }

        request.getRequestDispatcher(url).forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

