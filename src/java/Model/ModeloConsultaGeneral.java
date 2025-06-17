/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.Utilidades.MetodosSQL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Esteb
 */
public class ModeloConsultaGeneral {
    MetodosSQL metodos = new MetodosSQL();
    
    public ModeloConsultaGeneral() {
        
    }
    
    
    public List<Object> lista(String tabla) throws SQLException {
        List <Object> data;
        
        switch(tabla){
            case "administrador" -> data = metodos.seleccionarTodoUsers(tabla);
            case "bibliotecario" -> data = metodos.seleccionarTodoUsers(tabla);
            case"estudiante" -> data = metodos.seleccionarTodoUsers(tabla);
            default -> data = metodos.seleccionarTodo(tabla);
        }
        return data;
    }
}
