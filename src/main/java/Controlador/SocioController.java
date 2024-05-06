package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

import java.util.List;

/**
 * Clase que actúa como controlador para las operaciones relacionadas con los socios.
 */
public class SocioController {

    SocioDAO socioDAO;
    SegurosDAO segurosDAO;
    FederacionDAO federacionDAO;

    /**
     * Constructor de la clase SocioController.
     */
    public SocioController(){
        this.socioDAO = new SocioDAO();
        this.segurosDAO = new SegurosDAO();
        this.federacionDAO = new FederacionDAO();
    }

    /**
     * Obtiene un socio por su identificador.
     * @param id El identificador del socio.
     * @return El socio encontrado o null si no se encuentra ninguno con ese identificador.
     */
    public Socio porId(int id){
        return socioDAO.porId(id);
    }

    /**
     * Crea un nuevo socio.
     * @param nombre El nombre del socio.
     * @param tipoSocio El tipo de socio (1 para estándar, 2 para federado, 3 para infantil).
     * @param nif El NIF del socio.
     * @param opcionSeguro La opción seleccionada para el seguro.
     * @param nombreFederacion El nombre de la federación para los socios federados.
     * @param idTutor El identificador del tutor para los socios infantiles.
     * @return El socio creado.
     */
    public Socio crear(String nombre, int tipoSocio, String nif, int opcionSeguro, String nombreFederacion, int idTutor) {
        Socio socio = null;

        switch (tipoSocio) {
            case 1:
                socio = crearEstandar(nombre, nif, opcionSeguro);
                break;
            case 2:
//                 socio = crearFederado(nombre, nif, nombreFederacion);
                break;
            case 3:
                 socio = crearInfantil(nombre, idTutor);
                break;
            default:
                System.out.println("Opción no válida. Por favor, intentalo de nuevo.");
        }

        return socio;
    }

    /**
     * Crea un nuevo socio de tipo estándar.
     * @param nombre El nombre del socio.
     * @param nif El NIF del socio.
     * @param opcionSeguro La opción seleccionada para el seguro.
     * @return El socio estándar creado.
     */
    private Socio crearEstandar(String nombre, String nif, int opcionSeguro) {
        Seguro seguroElegido = new Seguro(); // Supongo que aquí obtendrías el seguro seleccionado de alguna manera

        Socio socio = new Socio();
        socio.setNombre(nombre);
        socio.setTipoSocio("Estandar");

        Estandar estandar = new Estandar();
        estandar.setNif(nif);
        //estandar.setSeguroContratado(seguroElegido);
        Socio nuevo = socioDAO.crear(socio);
        estandar.setIdSocio(nuevo.getIdSocio());
        socioDAO.crearEstandar(estandar);
        return nuevo;
    }

//    private Socio crearFederado(String nombre, String nif, String nombreFederacion){
//        Federacion federacion = new Federacion();
//
//        Socio socio = new Socio();
//        socio.setNombre(nombre);
//        socio.setTipoSocio("Federado");
//
//        Federado federado = new Federado();
//        federado.setNif(nif);
//        federado.setFederacion(federacion);
//        Socio nuevo = socioDAO.crear(socio);
//        federado.setIdSocio(nuevo.getIdSocio());
//        socioDAO.crearFederado(federado);
//        return nuevo;
//    }
    public Socio crearInfantil(String nombre, int idTutor){
        Socio socio = new Socio();
        socio.setNombre(nombre);
        socio.setTipoSocio("Infantil");

        Infantil infantil = new Infantil();
        infantil.setIdTutor(idTutor);
        Socio nuevo = socioDAO.crear(socio);
        infantil.setIdSocio(nuevo.getIdSocio());
        socioDAO.crearInfantil(infantil);
        return nuevo;
    }

    /**
     * Obtiene una lista de todos los socios.
     * @return Una lista de todos los socios en la base de datos.
     */
    public List<Socio> mostrar(){
        return socioDAO.mostrar();
    }

    /**
     * Obtiene una lista de socios por tipo.
     * @param tipoSocio El tipo de socio a filtrar.
     * @return Una lista de socios del tipo especificado.
     */
    public List<Socio> mostrarPorTipo(String tipoSocio){
        return socioDAO.mostrarPorTipo(tipoSocio);
    }

    /**
     * Borra un socio existente.
     * @param idSocio El identificador del socio a borrar.
     * @return El socio borrado.
     */
    public Socio borrar(int idSocio){
        Socio socio = socioDAO.porId(idSocio);
        socioDAO.borrar(socio);
        return socio;
    }
}
