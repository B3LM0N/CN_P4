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
    private int idInscripcion;
    private int idSocio;
    private int idExcursion;
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;


    public Inscripcion() {}

    public Inscripcion(int idInscripcion, int idSocio, int idExcursion, LocalDate fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.idSocio = idSocio;
        this.idExcursion = idExcursion;
        this.fechaInscripcion = Date.from(fechaInscripcion.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    // Getters y setters
    public int getIdInscripcion() {
        return idInscripcion;
    }
    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }
    public int getIdSocio() {
        return idSocio;
    }
    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
    public int getIdExcursion() {
        return idExcursion;
    }
    public void setIdExcursion(int idExcursion) {
        this.idExcursion = idExcursion;
    }
    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }
    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    // Método toString para imprimir los detalles de la inscripción
    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTransformada = formatoFecha.format(fechaInscripcion);
        return "Inscripcion con id número " + idInscripcion + ", realizada el " + fechaTransformada +
                ".\nAsociada a la excursión número " + idExcursion +" y al socio número " + idSocio + ".";
    }
}

