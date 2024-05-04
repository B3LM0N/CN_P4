package Modelo.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="federacion")
public class Federacion {
    @Id
    private int idFederacion;
    private String nombreFederacion;


    // Constructor vacío
    public Federacion() {
    }

    // Constructor con todos los atributos
    public Federacion(int idFederacion, String nombre) {
        this.idFederacion = idFederacion;
        this.nombreFederacion = nombre;
    }

    // Getters y setters
    public int getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(int idFederacion) {
        this.idFederacion = idFederacion;
    }

    public String getNombreFederacion() {
        return nombreFederacion;
    }

    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }
}
