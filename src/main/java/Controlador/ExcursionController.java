package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;

public class ExcursionController {

    ExcursionDAO excursionDAO;

    public ExcursionController(){
        this.excursionDAO = new ExcursionDAO();
    }

    public Excursion porId(int id){
        return this.excursionDAO.porId(id);
    }
}
