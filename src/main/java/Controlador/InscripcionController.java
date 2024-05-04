package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;
public class InscripcionController {

        InscripcionDAO inscripcionDAO;

        public InscripcionController(){
            this.inscripcionDAO = new InscripcionDAO();
        }

        public Inscripcion porId(int id){
            return this.inscripcionDAO.porId(id);
        }
    }

