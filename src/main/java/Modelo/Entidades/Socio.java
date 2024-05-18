package Modelo.Entidades;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSocio;

    private String nombre;

    private String tipoSocio;

    @OneToMany(mappedBy = "socio")
    private List<Inscripcion> inscripciones;


    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Federado federado;

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Estandar estandar;

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Infantil infantil;

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(String tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    public Federado getFederado() {
        return federado;
    }

    public void setFederado(Federado federado) {
        this.federado = federado;
    }

    public Estandar getEstandar() {
        return estandar;
    }

    public void setEstandar(Estandar estandar) {
        this.estandar = estandar;
    }

    public Infantil getInfantil() {
        return infantil;
    }

    public void setInfantil(Infantil infantil) {
        this.infantil = infantil;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }


    @Override
    public String toString() {
        if (Objects.equals(tipoSocio, "Estandar")) {
            return "Socio con id número " + idSocio + ", llamado: " + nombre + ", es un socio " + tipoSocio + ".\n" +
                    "Su nif es: " + estandar.getNif() + ", y tiene contratado un seguro " + estandar.getSeguroContratado().seguroContratado + ".\n";
        } else if (Objects.equals(tipoSocio, "Federado")) {
            return "Socio con id número " + idSocio + ", llamado: " + nombre + ", es un socio " + tipoSocio + ".\n" +
                    "Su nif es: " + federado.getNif() + ", y su federación se llama " + federado.getFederacion().getNombreFederacion() + ".\n";
        } else {
            return "Socio con id número " + idSocio + ", llamado: " + nombre + ", es un socio " + tipoSocio + ".\n" +
                    "El id del tutor es: " + infantil.getIdTutor() + ".\n";

        }
    }
}