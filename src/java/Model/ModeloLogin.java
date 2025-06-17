/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Utilidades.MetodosSQL;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class ModeloLogin {
    boolean found;
    
    public ModeloLogin() {
        found = false;
    }
    
    public boolean buscarUsuario(ArrayList<Object> datos, String rol) {
        MetodosSQL sql = new MetodosSQL();
        
        switch(rol) {
            case "007": found = sql.usuarioLogin("administrador", datos); 
                        break;
            case "010": found = sql.usuarioLogin("bibliotecario", datos); 
                        break;
            case "stu": found = sql.usuarioLogin("estudiante", datos);
                        break;
            default: 
                return false;
        }
        return found;
    }
    
    
}
