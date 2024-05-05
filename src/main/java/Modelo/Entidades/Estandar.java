package Modelo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "estandar")
public class Estandar {

    @Id
    public int idSocio;

    @Column(name = "nif") // Aquí se mapea el atributo nif en la tabla Estandar
    public String nif;

    @OneToOne
    @JoinColumn(name = "idSocio")
    public Socio socio;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "seguroContratado_idSeguro")
//    public Seguro seguroContratado;


    // Constructor vacío
    public Estandar() {
        super();
    }
    // Constructor con todos los atributos
    public Estandar(String nif, Seguro seguroContratado) {
//        super(idSocio, nombre, tipoSocio);
        this.nif = nif;
//        this.seguroContratado = seguroContratado;
    }

    // Getter y setter para el NIF
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

//    public Seguro getSeguroContratado() {
//        return seguroContratado;
//    }
//
//    public void setSeguroContratado(Seguro seguroContratado) {
//        this.seguroContratado = seguroContratado;
//    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
}