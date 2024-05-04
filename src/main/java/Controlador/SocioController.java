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

    public Socio crear(){
        Socio nuevoSocio = null;
        Seguro seguroElegido;

        String nombre = Teclado.pedirString("Ingrese el nombre del nuevo socio: ");
        System.out.println("Seleccione el tipo de socio:");
        System.out.println("1. Socio Estandar\n2. Socio Federado\n3. Socio Infantil");
        int tipoSocio = Teclado.pedirInt("Ingrese la opción deseada: ");
        String nif;

        switch (tipoSocio) {
            case 1:
                nif = Teclado.pedirString("Ingrese el NIF del socio: ");
                int opcionSeguro = Teclado.pedirInt("Seleccione el tipo de seguro:\n1. Básico - $10\n2. Completo - $20\nIngrese la opción deseada: ");
                seguroElegido = segurosDAO.obtenerSeguro(opcionSeguro == 1 ? 1 : 2);  // Asumiendo que los ID de seguros son 1 y 2 en la DB
                nuevoSocio = new Estandar(0, nombre, nif, seguroElegido);
                break;
            case 2:
                nif = Teclado.pedirString("Ingrese el NIF del socio: ");
                String nombreFederacion = Teclado.pedirString("Ingrese el nombre de la federación: ");
                Federacion federacion = federacionDAO.obtenerFederacionPorNombre(nombreFederacion);
                nuevoSocio = new Federado(0, nombre, federacion, nif);
                break;
            case 3:
                int idTutor = Teclado.pedirInt("Elige el ID del tutor: ");
                Socio tutor = socioDAO.buscarSocioPorId(idTutor);
                if (tutor != null && Teclado.pedirInt("El tutor seleccionado es: " + tutor.getNombre() + " (ID: " + tutor.getIdSocio() + ")\n1. Confirmar tutor\n2. Cancelar\nIngrese la opción deseada: ") == 1) {
                    nuevoSocio = new Infantil(0, nombre, tutor.getIdSocio());
                } else {
                    System.out.println("Creación de socio infantil cancelada o no se encontró un tutor con el ID proporcionado.");
                }
                break;
            default:
                System.out.println("Opción no válida. Por favor, reintente.");
        }
        if (nuevoSocio != null) {
            socioDAO.agregarSocio(nuevoSocio);

        } else {
            System.out.println("No se ha podido agregar el Socio");
        }
    }
}
