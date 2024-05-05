package Modelo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "socio")
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSocio")
    private int idSocio;
    private String nombre;
    private String tipoSocio;

    @OneToOne(mappedBy = "Estandar", cascade = CascadeType.ALL)
    private Estandar estandar;
    @OneToOne(mappedBy = "Federado", cascade = CascadeType.ALL)
    private Federado federado;
    @OneToOne(mappedBy = "Infantil", cascade = CascadeType.ALL)
    private Infantil infantil;

    // Constructor vacío
    public Socio() {
    }

    // Constructor con todos los atributos
    public Socio(int idSocio, String nombre, String tipoSocio) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.tipoSocio = tipoSocio;
    }

    // Getters y setters
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

    // Método toString para imprimir los detalles del socio
    @Override
    public String toString() {
        return "Socio " + tipoSocio + " creado.\n" +
                "Su id es el número " + idSocio +
                " y se llama " + nombre + ".";
    }
}