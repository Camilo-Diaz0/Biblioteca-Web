/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Entidades.Reserva;
import Model.Utilidades.ReservaMetodosSQL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cami-
 */
public class ModeloReserva {
    private ReservaMetodosSQL conexion;
    
    public ModeloReserva(){
        conexion = new ReservaMetodosSQL();
    }
    
    public List<Reserva> listar(){
        return conexion.listarReservas();
    }
    
    public Reserva buscarReserva(String codigo){
        int id = Integer.parseInt(codigo);
        return conexion.buscarReserva(id);
    }
    
    public void crearReserva(String estudianteID, String ejemplarID, String fecha, String estado){
        try {
            Reserva reserva = new Reserva();
            Calendar fechaReserva = Calendar.getInstance();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            Date date = formato.parse(fecha);
            fechaReserva.setTime(date);
            
            reserva.setEstudianteID(Integer.parseInt(estudianteID));
            reserva.setEjemplarID(Integer.parseInt(ejemplarID));
            reserva.setEstado(estado);
            reserva.setFechaReservada(fechaReserva);
            conexion.insertar(reserva);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
    }
    
    public boolean actualizarReserva(String id, String estudianteID, String ejemplarID, String fecha){
        try {
            Reserva reserva = new Reserva();
            Calendar fechaReserva = Calendar.getInstance();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            Date date = formato.parse(fecha);
            fechaReserva.setTime(date);
            
            reserva.setEstudianteID(Integer.parseInt(estudianteID));
            reserva.setEjemplarID(Integer.parseInt(ejemplarID));
            reserva.setId(Integer.parseInt(id));
            reserva.setFechaReservada(fechaReserva);
            return conexion.update(reserva);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
        return false;
    }
    
    public boolean eliminarReserva(String codigo){
        int id = Integer.parseInt(codigo);
        return conexion.delete(id);
    }
}
