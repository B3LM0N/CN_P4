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
        inscripcionDAO.crear(inscripcion);
        }
        public void borrar(int idInscripcion){
                Inscripcion inscripcion = inscripcionDAO.porId(idInscripcion);
                inscripcionDAO.borrar(inscripcion);
        }
        public List<Inscripcion> mostrar(){
                return inscripcionDAO.mostrar();
        }
        public List<Inscripcion> mostrarPorSocio(int idSocio) {
                return inscripcionDAO.mostrarPorSocio(idSocio);
        }
        public List<Inscripcion> mostrarPorFecha(Date fechaInicio, Date fechaFin) {
                return inscripcionDAO.mostrarPorFecha(fechaInicio, fechaFin);
        }
        public List<Inscripcion> mostrarPorSocioYFecha(int idSocio, Date fechaInicio, Date fechaFin) {
                return  inscripcionDAO.mostrarPorSocioYFecha(idSocio, fechaInicio, fechaFin);   
        }
}
