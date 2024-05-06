package Modelo.Entidades;

import javax.persistence.*;

@Entity
@Table(name="federacion")
public class Federacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFederacion;
    private String nombreFederacion;


    // Constructor vacío
    public Federacion() {
    }

    // Constructor con todos los atributos
    public Federacion(int idFederacion, String nombreFederacion) {
        this.idFederacion = idFederacion;
        this.nombreFederacion = nombreFederacion;
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
