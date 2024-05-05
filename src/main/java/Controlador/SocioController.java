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
        return socioDAO.porId(id);
    }



    public Socio crear(String nombre, int tipoSocio, String nif, int opcionSeguro, String nombreFederacion, int idTutor){
        Seguro seguroElegido = null;
        Socio socio = new Socio();
        switch (tipoSocio) {
            case 1:
                seguroElegido = segurosDAO.porId(opcionSeguro);
                socio = new Socio(0, nombre, "Estandar");
                int idSocio = socio.getIdSocio();
                System.out.println(socio);
                socio = socioDAO.crear(socio);
                Estandar estandar = new Estandar(nombre,"Estandar", nif, seguroElegido, idSocio);
                estandar = socioDAO.crearEstandar(estandar);
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
