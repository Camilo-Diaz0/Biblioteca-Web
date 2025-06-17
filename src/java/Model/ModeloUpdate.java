/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import Model.Utilidades.MetodosSQL;
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
        table = getNameTable();
        MetodosSQL sql = new MetodosSQL();
        mostrar(datos);
        boolean flag = sql.update(table, datos);
        
        if(!flag) {
            JOptionPane.showMessageDialog(null, "NO se actualizo");
        }
    }
    
    private String getNameTable() {
        
        switch(rol) {
            case "admin" -> {
                return "administrador";
            }
            case "bibl" -> {
                return "bibliotecario";
            }
            case "student" -> {
                return "estudiante";
            }
            default -> {
                return "None";
            }
        }      
    }
    
    public void mostrar(ArrayList<Object> datos) {
        JOptionPane.showMessageDialog(null, rol);
    }
}
