package Controller;

import Model.ModeloFormulario;
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

/**
 *
 * @author Esteb
 */
@WebServlet(name = "ServletFormulario", urlPatterns = {"/ServletFormulario"})
public class ServletFormulario extends HttpServlet {

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
            out.println("<title>Servlet servletFormulario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletFormulario at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String nombre = request.getParameter("name");
        String email = request.getParameter("email");
        String codigo = request.getParameter("codigo");
        String estado = request.getParameter("estado");
        String apellido = request.getParameter("lastname");
        String password = request.getParameter("password");
  
        Map<String, String> errores = validarTodosCampos(nombre, apellido, codigo, email, password);
        boolean flag = errores.isEmpty();
        
        if (flag) {
            long id = Long.parseLong(codigo);
            ArrayList<Object> datos = new ArrayList<>();
            datos = ingresarDatos(id, nombre, apellido, email, password, estado);
            ModeloFormulario modelo = new ModeloFormulario(datos, rol);
        } else {
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("/View/registro.jsp").forward(request, response);
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
    }
    
    private  ArrayList<Object> ingresarDatos(long codigo, String nombre, String apellido, String email, String password, String estado) {
       ArrayList<Object> datos = new ArrayList<>();
       datos.add(codigo);
       datos.add(nombre);
       datos.add(apellido);
       datos.add(email);
       datos.add(password);
       datos.add(estado);
       return datos;
    }

}
