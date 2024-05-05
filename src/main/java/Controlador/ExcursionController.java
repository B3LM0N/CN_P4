package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

import java.util.Date;

public class ExcursionController {

    ExcursionDAO excursionDAO;

    public ExcursionController(){
        this.excursionDAO = new ExcursionDAO();
    }

    public Excursion porId(int id){
        return this.excursionDAO.porId(id);
    }

    public Excursion crear(String descripcion, Date fechaExcursion,int duracionDias,double precioInscripcion) {
        Excursion excursion = new Excursion(0, descripcion,fechaExcursion, duracionDias, precioInscripcion);
        excursion = ExcursionDAO.crear(excursion);
        return excursion;
    }



}

