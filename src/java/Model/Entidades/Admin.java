/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entidades;

import static Model.Utilidades.ValidarCampos.validarFormatoCodigo;
/**
 *
 * @author Esteb
 */
public class Admin extends Usuario{

    public Admin() {
        super();
    }

    public Admin(Long codigo, String nombre, String apellido, String estado, String email, String password) {
        super(codigo, nombre, apellido, estado, email, password);
    }

    @Override
    public String getCodeRol() {
        return "007";
    }

    
    public boolean formatoCodigo(String rol, String cedula) {
        return rol.equals("007") && validarFormatoCodigo(cedula);
    }

    @Override
    public String toString() {
        return "Admin{" + "codigo=007" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", estado=" + estado + ", email=" + email + ", password=" + password + '}';
    }
}
