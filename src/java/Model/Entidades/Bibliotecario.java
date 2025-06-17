/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entidades;

/**
 *
 * @author Esteb
 */
public class Bibliotecario {
    
    public Bibliotecario(){ 
        
    }
    
    public boolean formatoCodigo(String codigo) {
        String parte = codigo.substring(3);      
        return parte.equals("010");
    }
}
