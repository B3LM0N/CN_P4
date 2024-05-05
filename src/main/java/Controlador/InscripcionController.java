package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

import java.time.LocalDate;

public class InscripcionController {

        InscripcionDAO inscripcionDAO;

        public InscripcionController(){
            this.inscripcionDAO = new InscripcionDAO();
        }

        public Inscripcion porId(int id){
            return this.inscripcionDAO.porId(id);
        }
        public void crear(int idSocio, int idExcursion, LocalDate fechaInscripcion) {
        Inscripcion inscripcion = new Inscripcion(0, idSocio, idExcursion, fechaInscripcion);
        InscripcionDAO.crear(inscripcion);
        }
        public void borrar(int idInscripcion){
                Inscripcion inscripcion = InscripcionDAO.porId(idInscripcion);
                InscripcionDAO.borrar(inscripcion);
        }
}
