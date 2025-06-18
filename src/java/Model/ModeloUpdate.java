/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import Model.Utilidades.MetodosSQL;
import Model.Utilidades.UserRole;
import javax.swing.JOptionPane;

/**
 *
 * @author cami-
 */
public class ModeloUpdate {
    String table;
    String rol;
    
    public ModeloUpdate(String rol) {
        table = "";
        this.rol = rol;
    }
    
    public void updateData(ArrayList<Object> datos) {
        table = UserRole.getTableNameByCode(rol);
        MetodosSQL sql = new MetodosSQL();
        mostrar(datos);
        boolean flag = sql.update(table, datos);
        
        if(!flag) {
            JOptionPane.showMessageDialog(null, "NO se actualizo");
        }
    }
    
    public void mostrar(ArrayList<Object> datos) {
        JOptionPane.showMessageDialog(null, rol);
    }
}
