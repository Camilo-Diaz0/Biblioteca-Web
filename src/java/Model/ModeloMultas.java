/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Entidades.Multa;
import Model.Utilidades.MultasMetodosSQL;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cami-
 */
public class ModeloMultas {
    private MultasMetodosSQL metodos;
    
    public ModeloMultas(){
        metodos = new MultasMetodosSQL();
    }
    
    public List<Multa> listar(){
        return metodos.listarMultas();
    }
    
    public Multa buscarMulta(String codigo){
        int id = Integer.parseInt(codigo);
        return metodos.buscarMulta(id);
    }
    
    public boolean crearMulta(String monto, String motivo, String estado, String prestamoID){
        Multa multa = new Multa();
        try{
            multa.setMonto(Integer.parseInt(monto));
            multa.setMotivo(motivo);
            multa.setEstado(estado);
            multa.setPrestamoID(Integer.parseInt(prestamoID));
            return metodos.insertar(multa);
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
        return false;
    }
    
    public boolean actualizarMulta(String id, String monto, String motivo, String prestamoID){
        Multa multa = new Multa();
        try{
            multa.setMonto(Integer.parseInt(monto));
            multa.setMotivo(motivo);
            multa.setId(Integer.parseInt(id));
            multa.setPrestamoID(Integer.parseInt(prestamoID));
            return metodos.update(multa);
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        }
        return false;
    }
    
    public boolean eliminarMulta(String codigo){
        int id = Integer.parseInt(codigo);
        return metodos.delete(id);
    }
}
