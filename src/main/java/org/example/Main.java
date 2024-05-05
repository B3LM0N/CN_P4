package org.example;

import Controlador.FederacionController;
import Controlador.*;
import Modelo.Entidades.*;
import Modelo.Entidades.DAO.ExcursionDAO;
import Util.Teclado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    static SocioController socioController = new SocioController();
    static ExcursionController excursionController = new ExcursionController();
    public static void main(String[] args) {

        crearExcursion();

//        Federacion fede = federacionController.porId(1);
//        System.out.println(fede.getNombreFederacion());

    }

    public static void crearSocio(){

        String nombre = Teclado.pedirString("Ingrese el nombre del nuevo socio: ");
        System.out.println("Seleccione el tipo de socio:");
        System.out.println("1. Socio Estandar\n2. Socio Federado\n3. Socio Infantil");
        int tipoSocio = Teclado.pedirInt("Ingrese la opción deseada: ");
        String nif = null, nombreFederacion = null;
        int idTutor = 0;
        int opcionSeguro = 0;

        switch (tipoSocio) {
            case 1:
                nif = Teclado.pedirString("Ingrese el NIF del socio: ");
                opcionSeguro = Teclado.pedirInt("Seleccione el tipo de seguro:\n1. Básico - $10\n2. Completo - $20\nIngrese la opción deseada: ");
                break;
            case 2:
                nif = Teclado.pedirString("Ingrese el NIF del socio: ");
                nombreFederacion = Teclado.pedirString("Ingrese el nombre de la federación: ");
                break;
            case 3:
                idTutor = Teclado.pedirInt("Elige el ID del tutor: ");

                // TODO: para luego jeje
//                if (tutor != null && Teclado.pedirInt("El tutor seleccionado es: " + tutor.getNombre() + " (ID: " + tutor.getIdSocio() + ")\n1. Confirmar tutor\n2. Cancelar\nIngrese la opción deseada: ") == 1) {
//                    nuevoSocio = new Infantil(0, nombre, tutor.getIdSocio());
//                } else {
//                    System.out.println("Creación de socio infantil cancelada o no se encontró un tutor con el ID proporcionado.");
//                }
                break;
            default:
                System.out.println("Opción no válida. Por favor, reintente.");

        }

        socioController.crear(nombre, tipoSocio, nif, opcionSeguro, nombreFederacion, idTutor);
    }

    public static void crearExcursion() {
        String descripcion = Teclado.pedirString("Descripción de la Excursión: ");
        Date fechaExcursion = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (fechaExcursion == null) {
            try {
                 fechaExcursion = dateFormat.parse(Teclado.pedirString("Ingrese la fecha de la excursión (formato: dd/MM/yyyy): "));
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
            }
        }
        int duracionDias = Teclado.pedirInt("Ingrese la duración en días de la excursión: ");
        double precioInscripcion = Teclado.pedirDouble("Ingrese el precio de inscripción: ");
        System.out.println("\n");

        excursionController.crear(descripcion, fechaExcursion, duracionDias, precioInscripcion);
    }
}