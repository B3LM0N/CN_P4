package Modelo.Entidades;

import javax.persistence.*;

@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSocio;

    private String nombre;

    private String tipoSocio;

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
}