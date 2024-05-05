package Controlador;

import Modelo.Entidades.DAO.FederacionDAO;
import Modelo.Entidades.Federacion;

/**
 * Clase que actúa como controlador para las operaciones relacionadas con las federaciones.
 */
public class FederacionController {

    FederacionDAO federacionDAO;

    /**
     * Constructor de la clase FederacionController.
     */
    public FederacionController(){
        this.federacionDAO = new FederacionDAO();
    }

    /**
     * Obtiene una federación por su identificador.
     * @param id El identificador de la federación.
     * @return La federación encontrada o null si no se encuentra ninguna con ese identificador.
     */
    public Federacion porId(int id){
        return this.federacionDAO.porId(id);
    }
}
