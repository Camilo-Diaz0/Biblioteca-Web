 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ModeloConsulta;
import Model.ModeloUpdate;
import Model.Utilidades.UserRole;
import static Model.Utilidades.ValidarCampos.validarTodosCampos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cami-
 */
@WebServlet(name = "ServletUpdate", urlPatterns = {"/ServletUpdate"})
public class ServletUpdate extends HttpServlet{

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
        String rol = request.getParameter("role");
        String id = request.getParameter("codigo");
        String nombre = request.getParameter("name");
        String email = request.getParameter("email");
        String estado = request.getParameter("estado");
        String apellido = request.getParameter("lastname");
        String password = request.getParameter("password");
      
        Map<String, String> errores = validarTodosCampos(nombre, apellido, id, email, password);
        
        boolean flag = errores.isEmpty();
        if(flag){
            String path = "View/HTML/menu_admin.jsp";
            long userId = Long.parseLong(id);
            ArrayList<Object> datos = ingresarDatos(userId, nombre, apellido, email, password, estado);
            ModeloUpdate modelo = new ModeloUpdate(rol);
            modelo.updateData(datos);
            response.sendRedirect(path);
        } else {
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("/View/HTML/formulario_update.jsp").forward(request, response);
        }            
        
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
    
    private  ArrayList<Object> ingresarDatos(long userId, String nombre, String apellido, String email, String password, String estado) {
       ArrayList<Object> datos = new ArrayList<>();     
       datos.add(nombre);
       datos.add(apellido);
       datos.add(email);
       datos.add(password);
       datos.add(estado);
       datos.add(userId);
       return datos;
    }    
}
