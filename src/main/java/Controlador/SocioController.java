package Controlador;

import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;
import Util.Teclado;

public class SocioController {

    SocioDAO socioDAO;
    SegurosDAO segurosDAO;
    FederacionDAO federacionDAO;

    public SocioController(){
        this.socioDAO = new SocioDAO();
        this.segurosDAO = new SegurosDAO();
        this.federacionDAO = new FederacionDAO();
    }

    public Socio porId(int id){
        return this.socioDAO.porId(id);
    }



    public Socio crear(String nombreSocio, int tipoSocio, String nif, int opcionSeguro, String nombreFederacion, int idTutor){
        Socio socio = new Socio(0, nombreSocio, "Estandar");
        Seguro seguroElegido = null;

        switch (tipoSocio) {
            case 1:
                seguroElegido = segurosDAO.porId(opcionSeguro);
                Estandar estandar = new Estandar(0, nombreSocio, nif, seguroElegido);
                socio = socioDAO.crear(estandar);

                break;
            case 2:
//                Federacion federacion = federacionDAO.obtenerFederacionPorNombre(nombreFederacion);
//                nuevoSocio = new Federado(0, nombre, federacion, nif);
                break;
            case 3:
//                Socio tutor = socioDAO.buscarSocioPorId(idTutor);

                break;
            default:
                System.out.println("Opción no válida. Por favor, reintente.");

        }

        return socio;

    }
}
