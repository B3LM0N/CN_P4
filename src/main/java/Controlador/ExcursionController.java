package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

import java.util.Date;
import java.util.List;

public class ExcursionController {

    ExcursionDAO excursionDAO;

    public ExcursionController(){
        this.excursionDAO = new ExcursionDAO();
    }

    public Excursion porId(int id){
        return ExcursionDAO.porId(id);
    }

    public void crear(String descripcion, Date fechaExcursion, int duracionDias, double precioInscripcion) {
        Excursion excursion = new Excursion(0, descripcion,fechaExcursion, duracionDias, precioInscripcion);
        ExcursionDAO.crear(excursion);
    }

    public void borrar(int idExcursion) {
        Excursion excursion = ExcursionDAO.porId(idExcursion);
        ExcursionDAO.borrar(excursion);
    }
    public List<Excursion> mostrar(Date fechaInicio, Date fechaFin) {
       List<Excursion> excursiones = ExcursionDAO.mostrarPorFechas(fechaInicio, fechaFin);
        return excursiones;
    }
}

