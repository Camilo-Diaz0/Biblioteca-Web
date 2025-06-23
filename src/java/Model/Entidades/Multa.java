/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entidades;

/**
 *
 * @author cami-
 */
public class Multa {
    int id;
    int monto;
    String motivo;
    String estado;
    int prestamoID;

    public Multa() {
    }

    public Multa(int id, int monto, String motivo, String estado, int prestamoID) {
        this.id = id;
        this.monto = monto;
        this.motivo = motivo;
        this.estado = estado;
        this.prestamoID = prestamoID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrestamoID() {
        return prestamoID;
    }

    public void setPrestamoID(int prestamoID) {
        this.prestamoID = prestamoID;
    }

    @Override
    public String toString() {
        return "Multa{" + "id=" + id + ", monto=" + monto + ", motivo=" + motivo + ", estado=" + estado + ", prestamoID=" + prestamoID + '}';
    }
    
}
