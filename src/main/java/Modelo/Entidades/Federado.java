package Modelo.Entidades;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Federado {
    @Id
    private int idSocio;

    private String nif;

    @OneToOne
    @JoinColumn(name = "idSocio")
    public Socio socio;

//    @ManyToOne
//    public Federacion federacion;

    // Constructor vacío
    public Federado() {
    }

    // Constructor con todos los atributos
    public Federado(int idSocio, String nif,Federacion federacion) {
        super();
        this.nif = nif;
//        this.federacion = federacion;
    }

    // Getter y setter para el NIF
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }

    // Getter y setter para la federación
//    public Federacion getFederacion() {
//        return federacion;
//    }
//    public void setFederacion(Federacion federacion) {
//        this.federacion = federacion;
//    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
