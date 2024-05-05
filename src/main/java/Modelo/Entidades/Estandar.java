package Modelo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "estandar")
public class Estandar extends Socio {

    @Column(name = "nif") // Aquí se mapea el atributo nif en la tabla Estandar
    public String nif;

    @OneToOne
    @JoinColumn(name = "idSocio")
    public Socio socio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seguroContratado_idSeguro")
    public Seguro seguroContratado;



    // Constructor vacío
    public Estandar() {
        super();
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
        return "Socio Estandar con id número: " + getIdSocio() + ", llamado: " + getNombre() + ", con NIF: " + nif + ".\n" +
                "Ha elegido el tipo de seguro: " + seguroContratado.getSeguroContratado() + ".";
    }
}