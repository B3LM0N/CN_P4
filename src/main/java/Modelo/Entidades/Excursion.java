package Modelo.Entidades;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
@Table(name = "excursion")
@Entity
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExcursion;
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fechaExcursion;
    private int duracionDias;
    private double precioInscripcion;

    public Excursion(){}

    // Getters y setters
    public int getIdExcursion() {
        return idExcursion;
    }
    public void setIdExcursion(int idExcursion) {
        this.idExcursion = idExcursion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFechaExcursion() {
        return fechaExcursion;
    }
    public void setFechaExcursion(Date fechaExcursion) {
        this.fechaExcursion = fechaExcursion;
    }
    public int getDuracionDias() {
        return duracionDias;
    }
    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }
    public double getPrecioInscripcion() {
        return precioInscripcion;
    }
    public void setPrecioInscripcion(double precioInscripcion) {
        this.precioInscripcion = precioInscripcion;
    }


    // Método toString para imprimir los detalles de la excursión
    @Override
    public String toString() {
        //Transformar la fecha al formato deseado para que lo imporima
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTransformada = formatoFecha.format(fechaExcursion);
        return "Excursión con id : " + idExcursion + ".\n" +
                "Descripción = " + descripcion + ".\n" +
                "Fecha de la excursión = " + fechaTransformada + ", con una duración de " + duracionDias +" días.\n" +
                "El precio de inscripción es de " + precioInscripcion +" Euros.\n";
    }

}