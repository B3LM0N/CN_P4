package Controlador;
import Modelo.Entidades.DAO.*;
import Modelo.Entidades.*;
import Util.Teclado;

import java.util.List;

public class SocioController {
    SocioDAO socioDAO;
    SegurosDAO segurosDAO;
    FederacionDAO federacionDAO;
    EstandarDAO estandarDAO;

    public SocioController(){
        this.socioDAO = new SocioDAO();
        this.segurosDAO = new SegurosDAO();
        this.federacionDAO = new FederacionDAO();
        this.estandarDAO = new EstandarDAO();
    }
    public Socio porId(int id){
        return socioDAO.porId(id);
    }
    public Socio crear(String nombre, int tipoSocio, String nif, int opcionSeguro, String nombreFederacion, int idTutor) {
        Socio socio = null;

        switch (tipoSocio) {
            case 1:
                socio = crearEstandar(nombre, nif, opcionSeguro);
                break;
            case 2:
                // Crear socio federado
                break;
            case 3:
                // Crear socio infantil
                break;
            default:
                System.out.println("Opción no válida. Por favor, reintente.");
        }

        return socio;
    }

    private Socio crearEstandar(String nombre, String nif, int opcionSeguro) {
        Seguro seguroElegido = new Seguro(); // Supongo que aquí obtendrías el seguro seleccionado de alguna manera

        Socio socio = new Socio();
        socio.setNombre(nombre);

        Estandar estandar = new Estandar();
        estandar.setNif(nif);
//        estandar.setSeguroContratado(seguroElegido);
        Socio nuevo = socioDAO.crear(socio);
        estandar.setIdSocio(nuevo.getIdSocio());
        estandarDAO.crear(estandar);
        return nuevo;
    }

    public List<Socio> mostrar(){
        List<Socio> socios = (List<Socio>) socioDAO.mostrar();
        return socios;
    }
    public List<Socio> mostrarPorTipo(String tipoSocio){
        List<Socio> socios = (List<Socio>) socioDAO.mostrarPorTipo(tipoSocio);
        return socios;
    }
    public Socio borrar(int idSocio){
        Socio socio = socioDAO.porId(idSocio);
        socioDAO.borrar(socio);
        return socio;
    }
}
