/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entidades.Multa;
import Model.Entidades.Reserva;
import Model.ModeloMultas;
import Model.ModeloReserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cami-
 */
@WebServlet(urlPatterns = {"/ServCrearMulta", "/ServUpdateMulta", "/ServBuscarMulta", "/ServListarMulta", "/ServDeleteMulta"})
public class ServletMulta extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        log(path);
        switch(path){
            case "/ServCrearMulta": crearMulta(req, resp); break;
            case "/ServUpdateMulta": actualizarMulta(req, resp); break;
            case "/ServBuscarMulta": buscarMulta(req, resp); break;
            default:
                String referer = req.getHeader("referer");
                if(referer != null) resp.sendRedirect(referer);
                else req.getRequestDispatcher("/View/HTML/menu_admin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
//        log(path);
        switch(path){
            case "/ServListarMulta": listarMulta(req, resp); break;
            case "/ServDeleteMulta": eliminarMulta(req, resp); break;
//            case "/ServCrearMulta": getFormCrear(req, resp); break;
            case "/ServUpdateMulta": getFormUpdate(req, resp); break;
            default:
                String referer = req.getHeader("referer");
                if(referer != null) resp.sendRedirect(referer);
                else req.getRequestDispatcher("/View/HTML/menu_admin.jsp").forward(req, resp);
        }
    }
    
    
    private void crearMulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloMultas modelo = new ModeloMultas();
        String idPrestamo = request.getParameter("prestamo_id");
        String monto = request.getParameter("monto");
        String motivo = request.getParameter("motivo");
        
        boolean success = modelo.crearMulta(monto, motivo, "Activo", idPrestamo);
        String url;
        if(success) url = "/View/HTML/menu_admin.jsp";
        else url = "/View/HTML/FormMultas.jsp";
        
        request.getRequestDispatcher(url).forward(request, response);
    }
    
    private void actualizarMulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloMultas modelo = new ModeloMultas();
        String idPrestamo = request.getParameter("prestamo_id");
        String monto = request.getParameter("monto");
        String motivo = request.getParameter("motivo");
        String id = request.getParameter("id");
        
        boolean success = modelo.actualizarMulta(id, monto, motivo, idPrestamo);
        String url;
        if(success) url = "/View/HTML/menu_admin.jsp";
        else url = "/View/HTML/UpdateFormMultas.jsp";
        
        request.getRequestDispatcher(url).forward(request, response);
    }
    
    private void buscarMulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloMultas modelo = new ModeloMultas();
        String id = request.getParameter("id");
        Multa multa = modelo.buscarMulta(id);
        log("no esta");
        if(multa != null)log("si esta");
        request.setAttribute("multa", multa);
        request.getRequestDispatcher("/View/HTML/ConsMultas.jsp").forward(request, response);
    }
    
    private void listarMulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloMultas modelo = new ModeloMultas();
        List<Multa> lista = modelo.listar();
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("/View/HTML/ListMultas.jsp").forward(request, response);
    }
    
    private void eliminarMulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloMultas modelo = new ModeloMultas();
        String id = request.getParameter("id");
        boolean success = modelo.eliminarMulta(id);
        String url;
        if(success) url = "View/HTML/menu_admin.jsp";
        else url = "View/HTML/errores.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }
    
//    private void getFormCrear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        String id = request.getParameter("id");
//        request.setAttribute("ejemplar_id", id);
//        request.getRequestDispatcher("View/HTML/FormReservas.jsp").forward(request, response);
//        
//    }
    
    private void getFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ModeloMultas modelo = new ModeloMultas();
        String id = request.getParameter("id");
        Multa multa = modelo.buscarMulta(id);
        if(multa != null) request.setAttribute("multa", multa);
        request.getRequestDispatcher("View/HTML/UpdateFormMultas.jsp").forward(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMulta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletMulta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
