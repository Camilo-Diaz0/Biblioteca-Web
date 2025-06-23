/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entidades;

import java.util.Calendar;

/**
 *
 * @author cami-
 */
public class Reserva {
    int id;
    long estudianteID;
    int ejemplarID;
    Calendar FechaReservada;
    String estado;

    public Reserva() {
    }

    public Reserva(int id, long estudianteID, int ejemplarID, Calendar FechaReservada, String estado) {
        this.id = id;
        this.estudianteID = estudianteID;
        this.FechaReservada = FechaReservada;
        this.estado = estado;
        this.ejemplarID = ejemplarID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(long estudianteID) {
        this.estudianteID = estudianteID;
    }

    public Calendar getFechaReservada() {
        return FechaReservada;
    }

    public void setFechaReservada(Calendar FechaReservada) {
        this.FechaReservada = FechaReservada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEjemplarID() {
        return ejemplarID;
    }

    public void setEjemplarID(int ejemplarID) {
        this.ejemplarID = ejemplarID;
    }

    @Override
    public String toString() {
        return "Reservas{" + "id=" + id + ", estudianteID=" + estudianteID + ", ejemplarID=" + ejemplarID + ", FechaReservada=" + FechaReservada + ", estado=" + estado + '}';
    }

    
    
    
}
