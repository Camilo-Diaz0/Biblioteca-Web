/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Utilidades;

import Model.Entidades.Multa;
import static Model.Utilidades.Conexion.conectarMySQL;
import static Model.Utilidades.Conexion.connection;
import static Model.Utilidades.Conexion.desconexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cami-
 */
public class MultasMetodosSQL extends Conexion{
    
    public void insertar(Multa multa){
        boolean succesfull = conectarMySQL();
        if(succesfull){
            try{
                String sql = "INSERT INTO multa values(null, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setInt(0, multa.getMonto());
                    pstmt.setString(1, multa.getMotivo());
                    pstmt.setInt(2, multa.getPrestamoID());
                    pstmt.setString(3, multa.getEstado());
                    pstmt.executeQuery();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
    }
  
    public List<Multa> listarMultas(){
        String sql = "SELECT * FROM multa where estado=activo";
        List<Multa> multas = new ArrayList<>();
        boolean succesfull = conectarMySQL();
        if(succesfull){
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Multa multa = new Multa();
                    multa.setId(rs.getInt("id"));
                    multa.setMonto(rs.getInt("monto"));
                    multa.setMotivo(rs.getString("motivo"));
                    multa.setPrestamoID(rs.getInt("prestamo_id"));
                    multa.setEstado(rs.getString("estado"));
                    multas.add(multa);
                }
                
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return multas;
    }
    
    public Multa buscarMulta(int id){
        Multa multa = null;
        String sql = "SELECT * FROM reserva where id=?";
        boolean succesfull = conectarMySQL();
        if(succesfull){
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(0, id);
                ResultSet rs = ps.executeQuery();
                multa = new Multa();
                multa.setId(rs.getInt("id"));
                multa.setMonto(rs.getInt("monto"));
                multa.setMotivo(rs.getString("motivo"));
                multa.setPrestamoID(rs.getInt("prestamo_id"));
                multa.setEstado(rs.getString("estado"));
                
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return multa;
    }
    
    public boolean update(Multa multa){
        boolean succesfull = conectarMySQL();
        String sql = "UPDATE multa Set monto=?, motivo=?, prestamo_id=? WHERE id=?";
        if(succesfull){
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(3, multa.getId());
                ps.setInt(0, multa.getMonto());
                ps.setString(1, multa.getMotivo());
                ps.setInt(2, multa.getPrestamoID());
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
        String sql = "UPDATE multa set estado=inactivo where id=?";
        
        if(succesfull){
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(0, id);
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
