package Controller;

import Model.ModeloConsulta;
import Model.Utilidades.UserRole;
import Model.Utilidades.ValidarCampos;
import java.io.IOException;
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
@WebServlet(name = "ServletConsulta", urlPatterns = {"/ServletConsulta"})

public class ServletConsulta extends HttpServlet {

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
        String id = request.getParameter("search-input");
        String accion = request.getParameter("accion");
        String action = "";
        boolean buscar = "buscar".equals(accion); 
        boolean cerrar = "cerrar".equals(accion);        
        boolean esNull = isNull(id);
        boolean valido = false;
        String codigo = "";
        String rol = "";  
        
        if(!esNull) {
            rol = id.substring(0, 3);
            codigo = id.substring(3);
            valido = ValidarCampos.validarFormatoCodigo(codigo);
        }
        
        if (buscar && valido) {
            getData(request, response, rol, id);
        } else if(cerrar) {
            //request.getSession().removeAttribute("search-input");
            request.setAttribute("mostrarPanelBusqueda", false); // Forzar a mostrar el panel
            request.getRequestDispatcher("View/HTML/menu_admin.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Formato de ID inválido. Ejemplo: ABC1234567");
            request.setAttribute("mostrarPanelBusqueda", true); // Forzar a mostrar el panel
            request.getRequestDispatcher("View/HTML/menu_admin.jsp").forward(request, response);
        }
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
    
    private void getData(HttpServletRequest request, HttpServletResponse response, String rol, String id) throws ServletException, IOException {
        long userId = ValidarCampos.getCodigo();
        
        ModeloConsulta modelo = new ModeloConsulta(userId, rol);
        Object[] userData = modelo.consulta();

        if (userData != null) {
            HttpSession miSession = request.getSession();
            miSession.setAttribute("id", id);
            miSession.setAttribute("userData", userData);
            response.sendRedirect("View/HTML/resultado_busqueda.jsp");
        } else {
            request.setAttribute("error", "Usuario no encontrado");
            request.setAttribute("mostrarPanelBusqueda", true); // Forzar a mostrar el panel
            request.getRequestDispatcher("View/HTML/menu_admin.jsp").forward(request, response);
        }
    }
    
    private boolean isNull(String id) {
        boolean esNull = false;
        if(id == null || id.isBlank() || id.length() < 4) {
            esNull = true;
        }
        return esNull;
    }
}
