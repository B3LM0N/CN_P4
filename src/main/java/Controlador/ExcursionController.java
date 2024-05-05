package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

import java.util.Date;
import java.util.List;

/**
 * Clase que actúa como controlador para las operaciones relacionadas con las Excursiones.
 */
public class ExcursionController {

    ExcursionDAO excursionDAO;

    /**
     * Constructor de la clase ExcursionController.
     */
    public ExcursionController(){
        this.excursionDAO = new ExcursionDAO();
    }

    /**
     * Obtiene una Excursion por su identificador.
     * @param id El identificador de la Excursion.
     * @return La Excursion encontrada o null si no se encuentra ninguna con ese identificador.
     */
    public Excursion porId(int id){
        return ExcursionDAO.porId(id);
    }

    /**
     * Crea una nueva Excursion.
     * @param descripcion La descripción de la Excursion.
     * @param fechaExcursion La fecha de la Excursion.
     * @param duracionDias La duración en días de la Excursion.
     * @param precioInscripcion El precio de inscripción de la Excursion.
     */
    public void crear(String descripcion, Date fechaExcursion, int duracionDias, double precioInscripcion) {
        Excursion excursion = new Excursion(0, descripcion,fechaExcursion, duracionDias, precioInscripcion);
        ExcursionDAO.crear(excursion);
    }

    /**
     * Borra una Excursion existente.
     * @param idExcursion El identificador de la Excursion a borrar.
     */
    public void borrar(int idExcursion) {
        Excursion excursion = ExcursionDAO.porId(idExcursion);
        ExcursionDAO.borrar(excursion);
    }

    /**
     * Muestra una lista de Excursiones dentro de un rango de fechas.
     * @param fechaInicio La fecha de inicio del rango.
     * @param fechaFin La fecha de fin del rango.
     * @return Una lista de Excursiones dentro del rango especificado.
     */
    public List<Excursion> mostrar(Date fechaInicio, Date fechaFin) {
        List<Excursion> excursiones = ExcursionDAO.mostrarPorFechas(fechaInicio, fechaFin);
        return excursiones;
    }
}
