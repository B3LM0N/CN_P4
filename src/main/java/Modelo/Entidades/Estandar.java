package Modelo.Entidades;

import javax.persistence.*;

@Table(name = "Estandar")
@Entity
public class Estandar extends Socio {
    private String nif;

    @ManyToOne
    private Seguro seguroContratado;

    // Constructor vacío
    public Estandar(String nombre, String estandar, String nif, Seguro seguroElegido, int idSocio) {
    }

    // Constructor con todos los atributos
    public Estandar(int idSocio, String nombre, String tipoSocio, String nif, Seguro seguroContratado) {
        super(idSocio, nombre, tipoSocio);
        this.nif = nif;
        this.seguroContratado = seguroContratado;
    }

    // Getter y setter para el NIF

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Seguro getSeguroContratado() {
        return seguroContratado;
    }

    public void setSeguroContratado(Seguro seguroContratado) {
        this.seguroContratado = seguroContratado;
    }


    @Override
    public String toString() {
        return "Socio Estandar con id número: " + getIdSocio() + ", llamado: " +  getNombre() + ", con NIF: " + nif + ".\n" +
                "Ha elegido el tipo de seguro: " +  seguroContratado.getSeguroContratado() + ".";
    }
}
