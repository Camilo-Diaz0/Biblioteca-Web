/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import Model.Entidades.Admin;
import Model.Entidades.Usuario;
import Model.ModeloLogin;
import Model.Utilidades.UserRole;
import Model.Utilidades.ValidarCampos;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Esteb
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"}) public class ServletLogin extends HttpServlet {
    
    Admin admin = new Admin();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/View/HTML/login.jsp");
        
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
        String id = request.getParameter("codigo");
        Usuario usuario = null;
        int n = id.length();
        String rol = "";
        String cc = "";
        boolean found = false;
        boolean valido = ValidarCampos.validarFormatoCodigo(id);
        
        if(valido) {
            rol = id.substring(0,3);
            cc = id.substring(3, n);
        }
        
        if(valido) {
            long cedula = Long.parseLong(cc);
            String password = request.getParameter("password");
           
            ArrayList <Object> datos = new ArrayList<>();
            datos.add(cedula);
            datos.add(password);  
            
            ModeloLogin login = new ModeloLogin();
            found = login.buscarUsuario(datos, rol);
            if(found){
                usuario =login.obtenerUsuario(cedula, UserRole.getTableNameByCode(rol));
            }
        }  
        
        if(usuario != null) {
            
            redireccion(usuario, request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=2");
        }
    }
    
    private void redireccion(Usuario usuario, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario);
        response.sendRedirect(request.getContextPath() + "/View/HTML/menu_admin.jsp");
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

    private boolean ValidarCampos(String cc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
