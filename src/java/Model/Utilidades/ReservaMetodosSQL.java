/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Utilidades;

import Model.Entidades.Reserva;
import static Model.Utilidades.Conexion.connection;
import static Model.Utilidades.Conexion.desconexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cami-
 */
public class ReservaMetodosSQL extends Conexion{
    public boolean insertar(Reserva reserva){
        boolean succesfull = conectarMySQL();
        if(succesfull){
            try{
                String sql = "INSERT INTO reserva values(null, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setDate(1, new Date(reserva.getFechaReservada().getTimeInMillis()));
                    pstmt.setString(2, reserva.getEstado());
                    pstmt.setLong(3, reserva.getEstudianteID());
                    pstmt.setInt(4, reserva.getEjemplarID());
                    int executeUpdate = pstmt.executeUpdate();
                    return executeUpdate>0;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error metodoSQl " + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return false;
    }
    
    public List<Reserva> listarReservas(){
        String sql = "SELECT * FROM reserva where estado='Activo'";
        List<Reserva> reservas = new ArrayList<>();
        boolean succesfull = conectarMySQL();
        if(succesfull){
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Reserva reserva = new Reserva();
                    Calendar calendar = Calendar.getInstance();
                    reserva.setId(rs.getInt("id"));
                    reserva.setEstudianteID(rs.getLong("estudiante_id"));
                    reserva.setEjemplarID(rs.getInt("ejemplar_id"));
                    calendar.setTime(rs.getDate("fecha_reserva"));
                    reserva.setFechaReservada(calendar);
                    reserva.setEstado(rs.getString("estado"));
                    reservas.add(reserva);
                }
                
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return reservas;
    }
    
    public Reserva buscarReserva(int id){
        Reserva reserva = null;
        String sql = "SELECT * FROM reserva where id=?";
        boolean succesfull = conectarMySQL();
        if(succesfull){
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                reserva = new Reserva();
                Calendar calendar = Calendar.getInstance();
                if(rs.next()){
                    reserva.setId(rs.getInt("id"));
                    reserva.setEstudianteID(rs.getLong("estudiante_id"));
                    reserva.setEjemplarID(rs.getInt("ejemplar_id"));
                    calendar.setTime(rs.getDate("fecha_reserva"));
                    reserva.setFechaReservada(calendar);
                    reserva.setEstado(rs.getString("estado"));
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return reserva;
    }
    
    public boolean update(Reserva reserva){
        boolean succesfull = conectarMySQL();
        String sql = "UPDATE reserva Set estudiante_id=?, ejemplar_id=?, fecha_reserva=? WHERE id=?";
        if(succesfull){
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(4, reserva.getId());
                ps.setLong(1, reserva.getEstudianteID());
                ps.setInt(2, reserva.getEjemplarID());
                ps.setDate(3, new Date(reserva.getFechaReservada().getTimeInMillis()));
                int updated = ps.executeUpdate();
                return updated >0;
                
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return false;
    }
    
    public boolean delete(int id){
        boolean succesfull = conectarMySQL();
        String sql = "UPDATE reserva set estado='Inactivo' where id=?";
        
        if(succesfull){
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id);
                int updated = ps.executeUpdate();
                return updated > 0;
                
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return false;
    }
}
