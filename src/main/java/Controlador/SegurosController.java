package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

public class SegurosController {

    SegurosDAO segurosDAO;

    public SegurosController(){
        this.segurosDAO = new SegurosDAO();
    }

    public Seguro porId(int id){
        return this.segurosDAO.porId(id);
    }
}
