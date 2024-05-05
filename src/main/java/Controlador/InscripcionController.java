package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

import java.util.Date;

public class InscripcionController {

        InscripcionDAO inscripcionDAO;

        public InscripcionController(){
            this.inscripcionDAO = new InscripcionDAO();
        }

        public Inscripcion porId(int id){
            return this.inscripcionDAO.porId(id);
        }
        public void crear(int idSocio, int idExcursion, Date fechaExcursion) {
        Inscripcion inscripcion = new Inscripcion(0, idSocio, idExcursion, fechaExcursion);
        InscripcionDAO.crear(inscripcion);
        }
}
