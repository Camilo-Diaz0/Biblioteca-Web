/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entidades;

/**
 *
 * @author cami-
 */
public class Usuario {
    Long codigo;
    String nombre;
    String apellido;
    String estado;
    String email;
    String password;

    public Usuario() {
    }

    public Usuario(Long codigo, String nombre, String apellido, String estado, String email, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.email = email;
        this.password = password;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCodeRol(){
        return "code";
    }
}
