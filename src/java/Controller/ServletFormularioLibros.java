/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Entidades.Libro;
import Model.Utilidades.ValidarCampos;
import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ModeloFormularioLibros;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Esteb
 */
@WebServlet(name = "ServletFormularioLibros", urlPatterns = {"/ServletFormularioLibros"})
public class ServletFormularioLibros extends HttpServlet {
    
    private final String FORMULARIO_LIBROS = "View/HTML/formulario_libros.jsp";
    private final String MENU_REGISTRAR = "View/HTML/menu_registrar.jsp";
    
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
        boolean enviar = "go".equals(accion);
        boolean volver = "back".equals(accion);
        
        if(enviar) {
            procesarEnvio(request);
            request.getRequestDispatcher(FORMULARIO_LIBROS).forward(request, response);
      
        } else if(volver){
            request.getRequestDispatcher(MENU_REGISTRAR).forward(request, response);
        }
    }
    
    private void procesarEnvio(HttpServletRequest request) {
        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String materia = request.getParameter("materia");
        String fecha = request.getParameter("fecha_publicacion");
        String estado = request.getParameter("estado");
        
        Map<String, String> errores = new HashMap<>(6);
        errores = Libro.validarTodosCampos(id, titulo, autor, materia, fecha, estado);
        boolean isEmpty = errores.isEmpty();
        
        if(isEmpty) {
            llamarModelo(id, titulo, autor, materia, fecha, estado);
        }else {
            StringBuilder errorBuilder = new StringBuilder();

            for (Map.Entry<String, String> entry : errores.entrySet()) {
                String key = entry.getKey();
                String val = entry.getValue();
                errorBuilder.append(key).append(val).append(", "); // o algún otro separador
            }

            // Eliminar el último separador si es necesario
            if (errorBuilder.length() > 0) {
                errorBuilder.setLength(errorBuilder.length() - 2);
            }

            System.out.println(errorBuilder.toString());
        }
    }

    private void llamarModelo(String id, String titulo, String autor, String materia, String fecha, String estado) {
        ArrayList <Object> datos;
        int idLibro = Integer.parseInt(id);
        datos = addData(idLibro, titulo, autor, materia, fecha, estado);
        ModeloFormularioLibros modelo = new ModeloFormularioLibros(datos);
    }
    
    private ArrayList<Object> addData(int id, String titulo, String autor, String materia, String fecha, String estado) {
        ArrayList array = new ArrayList();
        array.add(id);
        array.add(titulo);
        array.add(autor);
        array.add(materia);
        array.add(fecha);
        array.add(estado);
        
        return array;
    }
}
