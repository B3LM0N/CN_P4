package Modelo.Entidades;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "federado")
@Entity
public class Federado extends Socio {

    private String nif;

    @ManyToOne
    public Federacion federacion;


    // Constructor vacío
    public Federado() {
    }

    // Constructor con todos los atributos
    public Federado(int idSocio, String nif,Federacion federacion) {
        super(idSocio, nif, String.valueOf(federacion));
        this.federacion = federacion;
        this.nif = nif;

    }

    // Getter y setter para el NIF
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    // Getter y setter para la federación
    public Federacion getFederacion() {
        return federacion;
    }

    public void setFederacion(Federacion federacion) {
        this.federacion = federacion;
    }

    // Método toString para imprimir los detalles del socio federado
    @Override
    public String toString() {
        return "Socio Federado con id número: " +getIdSocio() + ", llamado: " +  getNombre() + ", con NIF: " + nif + ".\n" +
                "Pertenece a la federación: " +  federacion.getNombreFederacion() + ".";

    }
}
