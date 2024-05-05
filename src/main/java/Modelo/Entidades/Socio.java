package Modelo.Entidades;

import javax.persistence.*;

@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSocio;

    private String nombre;

    private String tipoSocio;

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
}