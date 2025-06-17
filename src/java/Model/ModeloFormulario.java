package Model;

import Model.Utilidades.MetodosSQL;
import java.util.ArrayList;

public class ModeloFormulario {
   
    public ModeloFormulario(ArrayList<Object> datos, String rol) {  
        MetodosSQL sql = new MetodosSQL();
        String mensaje = "";
        
        switch(rol) {
            case "admin" -> sql.insertar("Administrador", datos);
            case "bibl" -> sql.insertar("Bibliotecario", datos);
            case "student" -> sql.insertar("Estudiante", datos);
            default -> {
                mensaje = "Debe seleccionar un rol";
            }
        }   
    }
    
}
