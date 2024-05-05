package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

/**
 * Clase que actúa como controlador para las operaciones relacionadas con los seguros.
 */
public class SegurosController {

    SegurosDAO segurosDAO;

    /**
     * Constructor de la clase SegurosController.
     */
    public SegurosController(){
        this.segurosDAO = new SegurosDAO();
    }

    /**
     * Obtiene un seguro por su identificador.
     * @param id El identificador del seguro.
     * @return El seguro encontrado o null si no se encuentra ninguno con ese identificador.
     */
    public Seguro porId(int id){
        return this.segurosDAO.porId(id);
    }
}
