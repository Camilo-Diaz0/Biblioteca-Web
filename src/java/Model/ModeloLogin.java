/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Entidades.Admin;
import Model.Entidades.Bibliotecario;
import Model.Entidades.Estudiante;
import Model.Entidades.Usuario;
import Model.Utilidades.MetodosSQL;
import Model.Utilidades.UserRole;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class ModeloLogin {
    boolean found;
    MetodosSQL sql;
    
    public ModeloLogin() {
        found = false;
        sql = new MetodosSQL();
    }
    
    public boolean buscarUsuario(ArrayList<Object> datos, String rol) {
        
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
    
    public Usuario obtenerUsuario(long id, String tabla){
        Usuario usuario = sql.obtenerUsuario(id, tabla);
        return usuario;
    }
}
