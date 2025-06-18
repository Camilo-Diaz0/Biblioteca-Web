/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entidades;

/**
 *
 * @author Esteb
 */
public class Bibliotecario extends Usuario{
   
    public Bibliotecario(){ 
        
    }

    public Bibliotecario(Long codigo, String nombre, String apellido, String estado, String email, String password) {
        super(codigo, nombre, apellido, estado, email, password);
    }

    @Override
    public String getCodeRol() {
        return "010";
    }    

    public boolean formatoCodigo(String codigo) {
        String parte = codigo.substring(3);      
        return parte.equals("010");
    }
   
    @Override
    public String toString() {
        return "Bibliotecario{" + "codigo=010" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", estado=" + estado + ", email=" + email + ", password=" + password + '}';
    }
    
    
}
