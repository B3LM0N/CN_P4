package org.example;

import Controlador.FederacionController;
import Controlador.*;
import Modelo.Entidades.*;
import Modelo.Entidades.DAO.ExcursionDAO;
import Util.Teclado;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Main {
    static SocioController socioController = new SocioController();
    static ExcursionController excursionController = new ExcursionController();
    static InscripcionController inscripcionController = new InscripcionController();
    static FederacionController federacionController = new FederacionController();
    static SegurosController segurosController = new SegurosController();

    public static void main(String[] args) throws ParseException {
        boolean finalizarPrograma = false;
        System.out.println("Bienvenido: ");
        while (!finalizarPrograma) {
            System.out.println("\n1. Gestion de Excursiones");
            System.out.println("\n2. Gestion de Socios");
            System.out.println("\n3. Gestion de Inscripciones");
            System.out.println("\n0. Salir del programa");

            int opcion = Teclado.pedirInt("\nElige una opcion: ");
            switch (opcion) {
                case 1:
                    menuExcursiones();
                    break;
                case 2:
                    menuSocios();
                    break;
                case 3:
                    menuInscripciones();
                    break;
                case 4:
                    finalizarPrograma = true;
                    break;
                default:
                    System.out.println("\nElige una opcion valida");
                    break;
            }
        }
    }
    public static void menuExcursiones() throws ParseException {
            boolean salirMenuExcursiones = false;
            System.out.println("\n-------------------------------------------------------");
            System.out.println("\n     Entrando al menú de la gestión de excursiones");
            System.out.println("\n-------------------------------------------------------");

            while (!salirMenuExcursiones) {
                System.out.println("\n1. Añadir excursión");
                System.out.println("\n2. Mostrar excursiones");
                System.out.println("\n3. Volver al menú principal");
                int opcion = Teclado.pedirInt("\nElige una opcion: ");
                switch (opcion) {
                    case 1:
                        crearExcursion();
                        break;
                    case 2:
                        mostrarExcursionesPorFechas();
                        break;
                    case 3:
                        salirMenuExcursiones = true;
                        System.out.println("\n-------------------------------------------------------");
                        System.out.println("\n               Saliendo al Menu Principal");
                        System.out.println("\n-------------------------------------------------------");
                        break;
                    default:
                        System.out.println("\nElige una opcion Valida");
                        break;
                }
            }

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
            public static void mostrarExcursionesPorFechas() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = dateFormat.parse(Teclado.pedirString("Ingrese la fecha de inicio (dd/MM/yyyy): "));
        Date fechaFin = dateFormat.parse(Teclado.pedirString("Ingrese la fecha de fin (dd/MM/yyyy): "));
        if (fechaInicio.after(fechaFin)) {
            System.out.println("La fecha de inicio no puede ser posterior a la fecha de fin.");
            return;
        }
        List<Excursion> excursiones = excursionController.mostrar(fechaInicio, fechaFin);
        System.out.println(excursiones);

    }
            public static void borrarExcursion() {
        int idExcursion = Teclado.pedirInt("Inserta el ID de la Excursion que quieres eliminar:\n");
        if (excursionController.porId(idExcursion) != null) {
            excursionController.borrar(idExcursion);
            System.out.println("La excursión ha sido eliminada exitosamente.");
        } else {
            System.out.println("Hubo un error al eliminar la excursión.");
        }
    }
    public static void menuSocios() {
        boolean salirMenuSocios = false;
        System.out.println("\n--------------------------------------------------");
        System.out.println("\n     Entrando al menú de la gestión de socios");
        System.out.println("\n--------------------------------------------------");
        while(!salirMenuSocios) {
            System.out.println("\n1. Añadir un nuevo socio");
            System.out.println("\n2. Modificar el tipo de seguro de socio Estándar existente");
            System.out.println("\n3. Eliminar un socio");
            System.out.println("\n4. Mostrar los socios");
            System.out.println("\n5. Mostrar la factura mensual de un socio");
            System.out.println("\n0. Volver al menú principal");
            int opcion = Teclado.pedirInt("\nElige lo que quieres hacer: ");
            switch (opcion) {
                case 1:
                    crearSocio();
                    System.out.println("Socio Agregado Correctamente");
                    break;
                case 2:
                    int idSocio = Teclado.pedirInt("Ingrese el ID del socio cuyo seguro quieres modificar: ");
//                    Datos.modificarSeguro(idSocio);
                    break;
                case 3:
//                    Datos.borrarSocio();
                    break;
                case 4:
                    System.out.println("1. Mostrar todos los socios");
                    System.out.println("2. Mostrar socios por tipo");
                    System.out.println("3. Volver al menú anterior");
                    int opcion2 = Teclado.pedirInt("Cual listado de socios quieres elegir: ");
                    switch (opcion2){
                        case 1:
//                            Datos.mostrarSocios();
                            break;
                        case 2:
//                            Datos.mostrarSociosPorTipo();
                            break;
                        case 3:
                            System.out.println("\n-------------------------------------------------------");
                            System.out.println("               Volviendo al Menu de Socios");
                            System.out.println("-------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Elige una opcion Valida");
                            break;
                    }
                    break;
                case 5:
//                    Datos.mostrarFacturaTotal();
                    break;
                case 0:
                    salirMenuSocios = true;
                    System.out.println("\n-------------------------------------------------------");
                    System.out.println("               Saliendo al Menu Principal");
                    System.out.println("-------------------------------------------------------");
                    break;
                default:
                    System.out.println("Elige una opcion Valida");
                    break;

            }
        }

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
    public static void menuInscripciones() throws ParseException {
        boolean salirMenuInscripciones = false;
        System.out.println("\n--------------------------------------------------");
        System.out.println("\n   Entrando al menú de la gestión de Inscripciones");
        System.out.println("\n--------------------------------------------------");
        while (!salirMenuInscripciones) {
            System.out.println("\n1. Añadir una inscripción");
            System.out.println("\n2. Eliminar una inscripción");
            System.out.println("\n3. Mostrar las inscripciones");
            System.out.println("\n0. Volver al menú principal");
            int opcion = Teclado.pedirInt("\nElige lo que quieres hacer: ");
            switch (opcion){
                case 1:
//                    Datos.crearInscripcion();
                    break;
                case 2:
//                    Datos.eliminarInscripcion();
                    break;
                case 3:
                    System.out.println("\n1. No aplicar filtros");
                    System.out.println("\n2. Aplicar filtro por socio");
                    System.out.println("\n3. Aplicar filtro por fecha");
                    System.out.println("\n4. Aplicar ambos filtros");
                    System.out.println("\n0. Volver al menú anterior");
                    int opcion2 = Teclado.pedirInt("\nElige como quieres mostrar las Inscripciones o vuelve al Menu de Inscripciones: ");
                    switch (opcion2){
                        case 1:
//                            Datos.mostrarTodasLasInscripciones();
                            break;
                        case 2:
//                            Datos.mostrarInscripcionPorSocio();
                            break;
                        case 3:
//                            Datos.mostrarInscripcionPorFecha();
                            break;
                        case 4:
//                            Datos.mostrarInscripcionPorSocioYFecha();
                            break;
                        case 0:
                            System.out.println("\n-------------------------------------------------------");
                            System.out.println("\n           Volviendo al Menu de Inscripciones");
                            System.out.println("\n-------------------------------------------------------");
                            break;
                        default:
                            System.out.println("\nElige una opcion Valida");
                            break;
                    }
                    break;
                case 0:
                    salirMenuInscripciones = true;
                    System.out.println("\n-------------------------------------------------------");
                    System.out.println("\n               Saliendo al Menu Principal");
                    System.out.println("\n-------------------------------------------------------");
                    break;
                default:
                    System.out.println("\nElige una opcion Valida");
                    break;

            }
        }


    }

//        Federacion fede = federacionController.porId(1);
//        System.out.println(fede.getNombreFederacion());
}