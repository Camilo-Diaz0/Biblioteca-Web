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
public class Admin {
    
    public Admin() {
        
    }
    
    public boolean formatoCodigo(String rol, String cedula) {
        return rol.equals("007") && validarFormatoCodigo(cedula);
    }
}
