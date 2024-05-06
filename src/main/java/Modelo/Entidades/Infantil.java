package Modelo.Entidades;

import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Table(name = "infantil")
public class Infantil {

    @Id
    private int idSocio;

    private int idTutor;
    @OneToOne
    @JoinColumn(name = "idSocio")
    public Socio socio;

    // Constructor vacío
    public Infantil() {
    }
    // Constructor con todos los atributos
    public Infantil(int idSocio, String nombre, int idTutor) {
//        super(idSocio, nombre, "Infantil");
        this.idTutor = idTutor;
    }

    // Getter y setter para el tutor asociado
    public int getIdTutor() {
        return idTutor;
    }
    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

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

    @Override
    public String toString() {
        return "Infantil{" +
                "idSocio=" + idSocio +
                ", idTutor=" + idTutor;
    }
}
