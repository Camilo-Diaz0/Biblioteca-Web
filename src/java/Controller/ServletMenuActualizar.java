/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Esteb
 */
@WebServlet(name = "ServletMenuActualizar", urlPatterns = {"/ServletMenuActualizar"})
public class ServletMenuActualizar extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String entidad = request.getParameter("entidad");
        
        switch(entidad) {
            case "usuario" -> response.sendRedirect("View/HTML/formulario_update.jsp");
            case"libro" -> response.sendRedirect("View/HTML/");
            case "prestamo" -> response.sendRedirect("View/HTML/"); 
            default -> request.getRequestDispatcher("View/HTML/menu_actualizar").forward(request, response);
        }
        
    }
    
}