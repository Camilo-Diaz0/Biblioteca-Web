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
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Servlet for handling user consultation requests.
 * Supports searching and closing operations based on user input.
 */
@WebServlet(name = "ServletConsulta", urlPatterns = {"/ServletConsulta"})
public class ServletConsulta extends HttpServlet {
    
    private static final Logger LOGGER = Logger.getLogger(ServletConsulta.class.getName());
    private static final String MENU_ADMIN_JSP = "View/HTML/menu_admin.jsp";
    private static final String RESULTADO_BUSQUEDA_JSP = "View/HTML/resultado_busqueda.jsp";
    private static final String ACCION_BUSCAR = "buscar";
    private static final String ACCION_CERRAR = "cerrar";
    private static final String ERROR_INVALID_ID = "Formato de ID inválido. Ejemplo: ABC1234567";
    private static final String ERROR_USER_NOT_FOUND = "Usuario no encontrado";
    private static final String ATTR_MOSTRAR_PANEL = "mostrarPanelBusqueda";
    private static final String ATTR_ERROR = "error";
    private static final String ATTR_ID = "id";
    private static final String ATTR_USER_DATA = "userData";
    private static final int MIN_ID_LENGTH = 4;

    /**
     * Handles HTTP GET requests for user consultation or session cleanup.
     *
     * @param request  The servlet request
     * @param response The servlet response
     * @throws ServletException If a servlet-specific error occurs
     * @throws IOException      If an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("search-input");
        String accion = request.getParameter("accion");

        try {
            if (ACCION_BUSCAR.equals(accion) && isValidId(id)) {
                processSearchRequest(request, response, id);
            } else if (ACCION_CERRAR.equals(accion)) {
                processCloseRequest(request, response);
            } else {
                setErrorAndForward(request, response, ERROR_INVALID_ID);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error processing GET request", e);
            setErrorAndForward(request, response, "Error interno del servidor");
        }
    }

    /**
     * Handles HTTP POST requests. Currently not implemented.
     *
     * @param request  The servlet request
     * @param response The servlet response
     * @throws ServletException If a servlet-specific error occurs
     * @throws IOException      If an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("POST request received, but not implemented");
        response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "POST method not supported");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return A string containing the servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for handling user consultation and session management";
    }

    /**
     * Processes a search request by validating the ID and retrieving user data.
     *
     * @param request  The servlet request
     * @param response The servlet response
     * @param id       The user ID to search for
     * @throws ServletException If a servlet-specific error occurs
     * @throws IOException      If an I/O error occurs
     */
    private void processSearchRequest(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        String rol = id.substring(0, 3);
        String codigo = id.substring(3);

        if (!ValidarCampos.validarFormatoCodigo(codigo)) {
            setErrorAndForward(request, response, ERROR_INVALID_ID);
            return;
        }

        long userId = ValidarCampos.getCodigo();
        ModeloConsulta modelo = new ModeloConsulta(userId, rol);
        Object[] userData = modelo.consulta();

        if (userData != null) {
            HttpSession session = request.getSession();
            session.setAttribute(ATTR_ID, id);
            session.setAttribute(ATTR_USER_DATA, userData);
            LOGGER.info("User data found for ID: " + id);
            response.sendRedirect(RESULTADO_BUSQUEDA_JSP);
        } else {
            setErrorAndForward(request, response, ERROR_USER_NOT_FOUND);
        }
    }

    /**
     * Processes a close request by clearing session attributes and redirecting to the admin menu.
     *
     * @param request  The servlet request
     * @param response The servlet response
     * @throws ServletException If a servlet-specific error occurs
     * @throws IOException      If an I/O error occurs
     */
    private void processCloseRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute(ATTR_ID);
        session.removeAttribute(ATTR_USER_DATA);
        request.setAttribute(ATTR_MOSTRAR_PANEL, false);
        LOGGER.info("Session attributes cleared for close action");
        request.getRequestDispatcher(MENU_ADMIN_JSP).forward(request, response);
    }

    /**
     * Validates if the provided ID is not null, blank, or too short.
     *
     * @param id The ID to validate
     * @return True if the ID is valid, false otherwise
     */
    private boolean isValidId(String id) {
        return id != null && !id.isBlank() && id.length() >= MIN_ID_LENGTH;
    }

    /**
     * Sets an error message and forwards the request to the admin menu.
     *
     * @param request  The servlet request
     * @param response The servlet response
     * @param errorMsg The error message to set
     * @throws ServletException If a servlet-specific error occurs
     * @throws IOException      If an I/O error occurs
     */
    private void setErrorAndForward(HttpServletRequest request, HttpServletResponse response, String errorMsg) throws ServletException, IOException {
        request.setAttribute(ATTR_ERROR, errorMsg);
        request.setAttribute(ATTR_MOSTRAR_PANEL, true);
        LOGGER.warning("Error: " + errorMsg);
        request.getRequestDispatcher(MENU_ADMIN_JSP).forward(request, response);
    }
}