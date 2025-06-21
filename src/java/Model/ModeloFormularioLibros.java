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
public class ModeloFormularioLibros {
    
    public ModeloFormularioLibros(ArrayList datos) { 
        MetodosSQL sql = new MetodosSQL();
        sql.insertar("libro", datos);
    }
   
}
