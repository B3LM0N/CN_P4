package Modelo.Entidades;

import javax.persistence.*;
import java.util.Objects;

@Table(name="seguro")
@Entity
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSeguro;
    @Column
    public String seguroContratado;
    public double precio;

    // Constructor vacío
    public Seguro() {
    }
    public Seguro(int idSeguro, String seguroContratado, double precio) {
        this.idSeguro = idSeguro;
        this.seguroContratado = seguroContratado;
        this.precio = precio;
    }
    public int getIdSeguro() {
        return idSeguro;
    }
    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }
    public Seguro(String seguroContratado, double precio) {
        this.seguroContratado = seguroContratado;
        this.precio = precio;
    }
    public String getSeguroContratado() {
        return seguroContratado;
    }
    public void setSeguroContratado(String seguroContratado) {
        this.seguroContratado = seguroContratado;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Seguro{" +
                "idSeguro=" + idSeguro +
                ", seguroContratado='" + seguroContratado + '\'' +
                ", precio=" + precio +
                '}';
    }
}
