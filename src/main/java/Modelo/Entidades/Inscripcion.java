package Modelo.Entidades;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
@Table(name="inscripcion")
@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInscripcion;
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;
    @ManyToOne
    @JoinColumn(name = "idSocio")
    private Socio socio;
    @ManyToOne
    @JoinColumn(name = "idExcursion")
    private Excursion excursion;
    public Inscripcion() {}


    // Getters y setters


    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    // Método toString para imprimir los detalles de la inscripción
    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTransformada = formatoFecha.format(fechaInscripcion);
        return "Inscripcion con id número " + idInscripcion + ", realizada el " + fechaTransformada +
                ".\nAsociada a la excursión número " + excursion.getIdExcursion() +" y al socio número " + socio.getIdSocio() + ".";
    }
}

