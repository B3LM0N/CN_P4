package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Clase que actúa como controlador para las operaciones relacionadas con las inscripciones.
 */
public class InscripcionController {

        InscripcionDAO inscripcionDAO;
        SocioDAO socioDAO;
        ExcursionDAO excursionDAO;

        /**
         * Constructor de la clase InscripcionController.
         */
        public InscripcionController(){
                this.inscripcionDAO = new InscripcionDAO();
                this.socioDAO = new SocioDAO();
                this.excursionDAO = new ExcursionDAO();
        }

        /**
         * Obtiene una inscripción por su identificador.
         * @param id El identificador de la inscripción.
         * @return La inscripción encontrada o null si no se encuentra ninguna con ese identificador.
         */
        public Inscripcion porId(int id){
                return this.inscripcionDAO.porId(id);
        }

        /**
         * Crea una nueva inscripción.
         * @param idSocio El identificador del socio que se inscribe.
         * @param idExcursion El identificador de la excursión a la que se inscribe.
         * @param fechaInscripcion La fecha de inscripción.
         */
        public void crear(int idSocio, int idExcursion, LocalDate fechaInscripcion) {
                Socio socio = socioDAO.porId(idSocio);
                Excursion excursion = excursionDAO.porId(idExcursion);
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(0);
                inscripcion.setSocio(socio);
                inscripcion.setExcursion(excursion);
                inscripcion.setFechaInscripcion(Date.from(fechaInscripcion.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                inscripcionDAO.crear(inscripcion);
        }

        /**
         * Borra una inscripción existente.
         * @param idInscripcion El identificador de la inscripción a borrar.
         */
        public void borrar(int idInscripcion){
                Inscripcion inscripcion = inscripcionDAO.porId(idInscripcion);
                inscripcionDAO.borrar(inscripcion);
        }

        /**
         * Obtiene una lista de todas las inscripciones.
         * @return Una lista de todas las inscripciones en la base de datos.
         */
        public List<Inscripcion> mostrar(){
                return inscripcionDAO.mostrar();
        }

        /**
         * Obtiene una lista de inscripciones de un socio específico.
         * @param idSocio El identificador del socio.
         * @return Una lista de inscripciones del socio especificado.
         */
        public List<Inscripcion> mostrarPorSocio(int idSocio) {
                return inscripcionDAO.mostrarPorSocio(idSocio);
        }

        /**
         * Obtiene una lista de inscripciones dentro de un rango de fechas.
         * @param fechaInicio La fecha de inicio del rango.
         * @param fechaFin La fecha de fin del rango.
         * @return Una lista de inscripciones dentro del rango especificado.
         */
        public List<Inscripcion> mostrarPorFecha(Date fechaInicio, Date fechaFin) {
                return inscripcionDAO.mostrarPorFecha(fechaInicio, fechaFin);
        }

        /**
         * Obtiene una lista de inscripciones de un socio específico dentro de un rango de fechas.
         * @param idSocio El identificador del socio.
         * @param fechaInicio La fecha de inicio del rango.
         * @param fechaFin La fecha de fin del rango.
         * @return Una lista de inscripciones del socio especificado dentro del rango especificado.
         */
        public List<Inscripcion> mostrarPorSocioYFecha(int idSocio, Date fechaInicio, Date fechaFin) {
                return  inscripcionDAO.mostrarPorSocioYFecha(idSocio, fechaInicio, fechaFin);
        }
}
