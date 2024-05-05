package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
        public List<Inscripcion> mostrar(){
                List<Inscripcion> inscripciones = (List<Inscripcion>) InscripcionDAO.mostrar();
                return inscripciones;
        }
        public List<Inscripcion> mostrarPorSocio(int idSocio) {
                List<Inscripcion> inscripciones = (List<Inscripcion>) InscripcionDAO.mostrarPorSocio(idSocio);
                return inscripciones;
        }
        public List<Inscripcion> mostrarPorFecha(Date fechaInicio, Date fechaFin) {
                List<Inscripcion> inscripciones = (List<Inscripcion>) InscripcionDAO.mostrarPorFecha(fechaInicio, fechaFin);
                return inscripciones;
        }
        public List<Inscripcion> mostrarPorSocioYFecha(int idSocio, Date fechaInicio, Date fechaFin) {
                List<Inscripcion> inscripciones = (List<Inscripcion>) InscripcionDAO.mostrarPorSocioYFecha(idSocio, fechaInicio, fechaFin);
            return inscripciones;
        }
}
