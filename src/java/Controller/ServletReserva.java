/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entidades.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ModeloReserva;
import java.util.List;

/**
 *
 * @author cami-
 */
@WebServlet(urlPatterns = {"/ServCrearReserva", "/ServUpdateReserva", "/ServBuscarReserva", "/ServListarReserva", "/ServDeleteReserva"})
public class ServletReserva extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        log(path);
        switch(path){
            case "/ServCrearReserva": crearReserva(req, resp); break;
            case "/ServUpdateReserva": actualizarReserva(req, resp); break;
            case "/ServBuscarReserva": buscarReserva(req, resp); break;
            default:
                String referer = req.getHeader("referer");
                if(referer != null) resp.sendRedirect(referer);
                else req.getRequestDispatcher("/View/HTML/menu_admin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        log(path);
        switch(path){
            case "/ServListarReserva": listarReserva(req, resp); break;
            case "/ServDeleteReserva": eliminarReserva(req, resp); break;
            case "/ServCrearReserva": getFormCrear(req, resp); break;
            case "/ServUpdateReserva": getFormUpdate(req, resp); break;
            default:
                String referer = req.getHeader("referer");
                if(referer != null) resp.sendRedirect(referer);
                else req.getRequestDispatcher("/View/HTML/menu_admin.jsp").forward(req, resp);
        }
    }
    

    private void crearReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloReserva modelo = new ModeloReserva();
        String idEstudiante = request.getParameter("estudiante_id");
        String idEjemplar = request.getParameter("id_ejemplar");
        String fecha = request.getParameter("fecha");
        
        boolean success = modelo.crearReserva(idEstudiante, idEjemplar, fecha, "Activo");
        String url;
        if(success) url = "/View/HTML/menu_admin.jsp";
        else url = "/View/HTML/FormReservas.jsp";
        
        request.getRequestDispatcher(url).forward(request, response);
    }
    
    private void actualizarReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloReserva modelo = new ModeloReserva();
        String id = request.getParameter("id");
        String idEstudiante = request.getParameter("estudiante_id");
        String idEjemplar = request.getParameter("id_ejemplar");
        String fecha = request.getParameter("fecha");
        
        boolean success = modelo.actualizarReserva(id, idEstudiante, idEjemplar, fecha);
        String url;
        if(success) url = "/View/HTML/menu_admin.jsp";
        else url = "/View/HTML/UpdateFormReservas.jsp";
        
        request.getRequestDispatcher(url).forward(request, response);
    }
    
    private void buscarReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloReserva modelo = new ModeloReserva();
        String id = request.getParameter("id");
        Reserva reserva = modelo.buscarReserva(id);
        request.setAttribute("reserva", reserva);
        request.getRequestDispatcher("/View/HTML/ConsReservas.jsp").forward(request, response);
    }
    private void listarReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloReserva modelo = new ModeloReserva();
        List<Reserva> lista = modelo.listar();
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("/View/HTML/ListReservas.jsp").forward(request, response);
    }
    
    private void eliminarReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloReserva modelo = new ModeloReserva();
        String id = request.getParameter("id");
        boolean success = modelo.eliminarReserva(id);
        String url;
        if(success) url = "View/HTML/menu_admin.jsp";
        else url = "View/HTML/errores.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }
    
    private void getFormCrear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        request.setAttribute("ejemplar_id", id);
        request.getRequestDispatcher("View/HTML/FormReservas.jsp").forward(request, response);
        
    }
    
    private void getFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloReserva modelo = new ModeloReserva();
        String id = request.getParameter("id");
        Reserva reserva = modelo.buscarReserva(id);
        if(reserva != null) request.setAttribute("reserva", reserva);
        request.getRequestDispatcher("View/HTML/UpdateFormReservas.jsp").forward(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletReserva</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletReserva at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
