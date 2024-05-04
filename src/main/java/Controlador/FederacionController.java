package Controlador;

import Modelo.Entidades.DAO.FederacionDAO;
import Modelo.Entidades.Federacion;

public class FederacionController {

    FederacionDAO federacionDAO;

    public FederacionController(){
        this.federacionDAO = new FederacionDAO();
    }

    public Federacion porId(int id){
        return this.federacionDAO.porId(id);
    }
}
