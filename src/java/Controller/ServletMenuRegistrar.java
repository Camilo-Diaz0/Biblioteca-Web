/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Esteb
 */
@WebServlet(name = "MenuRegistrar", urlPatterns = {"/ServletMenuRegistrar"})
public class ServletMenuRegistrar extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        String accion = request.getParameter("accion");
        
        boolean accionIr = "go".equals(accion);
        if(accionIr) {
            redireccion(request, response);
        }else {
            response.sendRedirect("View/HTML/menu_admin.jsp");
        }
        
    }
    
    private void redireccion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String comboBox = request.getParameter("options-formulario"); 
           
        switch (comboBox) {
            case "usuarios" -> response.sendRedirect("View/HTML/formulario.jsp");
            case "libros" -> response.sendRedirect("View/HTML/formulario_libros.jsp");
            case "ejemplares" -> response.sendRedirect("View/HTML/formulario_ejemplares.jsp");
            default -> {}
        }
        
    }

}
