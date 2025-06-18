/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entidades;

/**
 *
 * @author Esteb
 */
public class Estudiante extends Usuario{

    public Estudiante() {
    }

    public Estudiante(Long codigo, String nombre, String apellido, String estado, String email, String password) {
        super(codigo, nombre, apellido, estado, email, password);
    }

    @Override
    public String getCodeRol() {
        return "stu";
    }

    @Override
    public String toString() {
        return "Estudiante{" + "codigo=stu" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", estado=" + estado + ", email=" + email + ", password=" + password + '}';
    }
    
}
