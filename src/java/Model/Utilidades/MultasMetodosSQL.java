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
    
    public boolean insertar(Multa multa){
        boolean succesfull = conectarMySQL();
        if(succesfull){
            try{
                String sql = "INSERT INTO multa values(null, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setInt(1, multa.getMonto());
                    pstmt.setString(2, multa.getMotivo());
                    pstmt.setInt(4, multa.getPrestamoID());
                    pstmt.setString(3, multa.getEstado());
                    int executeUpdate = pstmt.executeUpdate();
                    return executeUpdate > 0;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            } finally {
                desconexion();
            }
        }
        return false;
    }
  
    public List<Multa> listarMultas(){
        String sql = "SELECT * FROM multa where estado='Activo'";
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
        String sql = "SELECT * FROM multa where id=?";
        boolean succesfull = conectarMySQL();
        if(succesfull){
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    multa = new Multa();
                    multa.setId(rs.getInt("id"));
                    multa.setMonto(rs.getInt("monto"));
                    multa.setMotivo(rs.getString("motivo"));
                    multa.setPrestamoID(rs.getInt("prestamo_id"));
                    multa.setEstado(rs.getString("estado"));
                }
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
                ps.setInt(4, multa.getId());
                ps.setInt(1, multa.getMonto());
                ps.setString(2, multa.getMotivo());
                ps.setInt(3, multa.getPrestamoID());
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
        String sql = "UPDATE multa set estado='Inactivo' where id=?";
        
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
