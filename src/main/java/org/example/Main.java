package org.example;

import Controlador.FederacionController;
import Controlador.*;
import Modelo.Entidades.*;
import Util.Teclado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class Main {

    static SocioController socioController = new SocioController();
    static ExcursionController excursionController = new ExcursionController();
    static InscripcionController inscripcionController = new InscripcionController();
    static SegurosController segurosController = new SegurosController();
    static FederacionController federacionController = new FederacionController();

    public static void main(String[] args) throws ParseException {
        menuPrincipal();
    }

    public static void menuPrincipal() throws ParseException{
        boolean finalizarPrograma = false;
        System.out.println("Bienvenido");
        while (!finalizarPrograma) {
            System.out.println("1. Gestión de excursiones");
            System.out.println("2. Gestión de socios");
            System.out.println("3. Gestión de inscripciones");
            System.out.println("0. Salir del programa");
            int opcion = Teclado.pedirInt("Elige una opcion: ");
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
                case 0:
                    finalizarPrograma = true;
                    break;
                default:
                    System.out.println("Elige una opcion Valida");
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
            System.out.println("\n0. Volver al menú principal");

            int opcion = Teclado.pedirInt("\nElige una opcion: ");

            switch (opcion) {
                case 1:
                    crearExcursion();
                    break;
                case 2:
                    mostrarExcursionesPorFechas();
                    break;
                case 0:
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
        int idExcursion = Teclado.pedirInt("\nInserta el ID de la Excursion que quieres eliminar: ");
        if (excursionController.porId(idExcursion) != null) {
            excursionController.borrar(idExcursion);
            System.out.println("La excursión ha sido eliminada con exito.");
        } else {
            System.out.println("Hubo un error al eliminar la excursión.");
        }
    }

    private static void menuSocios(){
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
            int opcion = Teclado.pedirInt("\nElige una opcion: ");
            switch (opcion) {
                case 1:
                    crearSocio();
                    System.out.println("\nSocio Agregado Correctamente");
                    break;
                case 2:
                    modificarSeguro();
                    break;
                case 3:
                    borrarSocio();
                    break;
                case 4:
                    System.out.println("\n1. Mostrar todos los socios");
                    System.out.println("\n2. Mostrar socios por tipo");
                    System.out.println("\n3. Volver al menú anterior");
                    int opcion2 = Teclado.pedirInt("\nCual listado de socios quieres elegir: ");
                    switch (opcion2){
                        case 1:
                            mostrarSocio();
                            break;
                        case 2:
                            mostrarSocioPorTipo();
                            break;
                        case 3:
                            System.out.println("\n-------------------------------------------------------");
                            System.out.println("\n               Volviendo al Menu de Socios");
                            System.out.println("\n-------------------------------------------------------");
                            break;
                        default:
                            System.out.println("\nElige una opcion Valida");
                            break;
                    }
                    break;
                case 5:
                    Double precioFactura = mostrarFacturaMensual();
                    System.out.println("Precio de la factura: " + precioFactura);
                    break;
                case 0:
                    salirMenuSocios = true;
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


                break;
            default:
                System.out.println("Opción no válida. Por favor, reintente.");

        }
        Socio socio = socioController.crear(nombre, tipoSocio, nif, opcionSeguro, nombreFederacion, idTutor);

    }
    // TODO: para luego jeje
//                if (tutor != null && Teclado.pedirInt("El tutor seleccionado es: " + tutor.getNombre() + " (ID: " + tutor.getIdSocio() + ")\n1. Confirmar tutor\n2. Cancelar\nIngrese la opción deseada: ") == 1) {
//                    nuevoSocio = new Infantil(0, nombre, tutor.getIdSocio());
//                } else {
//                    System.out.println("Creación de socio infantil cancelada o no se encontró un tutor con el ID proporcionado.");
//                }
    public static void modificarSeguro(){
        int idSocio = Teclado.pedirInt("Ingrese el id del socio: ");
        int nuevoSeguroContratado = Teclado.pedirInt("Id del nuevo seguro: ");
        socioController.modificarSeguroSocio(idSocio,nuevoSeguroContratado);
        System.out.println(socioController.modificarSeguroSocio(idSocio,nuevoSeguroContratado));

    }

    public static void borrarSocio(){
        int idSocio = Teclado.pedirInt("\nInserta el ID del socio que quieres eliminar: ");
        if (socioController.porId(idSocio) != null) {
            socioController.borrar(idSocio);
            System.out.println("\nEl socio ha sido eliminado con exito.");
        } else {
            System.out.println("\nHubo un error al eliminar el socio.");
        }
    }

    public static void mostrarSocio(){
        List<Socio> socios = socioController.mostrar();
        System.out.println(socios);
        System.out.println("-------- LISTA DE SOCIOS ---------");
        for(Socio socio: socios){
            System.out.println(socio.toString());
        }
        System.out.println("----------------------------------");
    }

    public static void mostrarSocioPorTipo(){
                System.out.println("\nIndica que tipo de socio deseas filtrar: ");
                System.out.println("\n1. Socio Estandar");
                System.out.println("\n2. Socio Federado");
                System.out.println("\n3. Socio Infantil");
                int opcion = Teclado.pedirInt("\nIntroduce el tipo de socio: ");
                String tipoSocio = null;

                switch(opcion) {
                    case 1:
                        tipoSocio = "Estandar";

                        break;
                    case 2:
                        tipoSocio = "Federado";

                        break;
                    case 3:
                        tipoSocio = "Infantil";
                        break;
                    default:
                }
                List<Socio> socios = socioController.mostrarPorTipo(tipoSocio);
                System.out.println(socios);
            }

    public static Double mostrarFacturaMensual(){
        int idSocio = Teclado.pedirInt(("Ingrese el ID del socio: "));
        return socioController.mostrarFacturaTotal(idSocio);

    }

    private static void menuInscripciones() throws ParseException {
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
                    crearInscripcion();
                    break;
                case 2:
                    borrarInscripcion();
                    break;
                case 3:
                    System.out.println("\n1. No aplicar filtros");
                    System.out.println("\n2. Aplicar filtro por socio");
                    System.out.println("\n3. Aplicar filtro por fecha");
                    System.out.println("\n4. Aplicar ambos filtros");
                    System.out.println("\n0. Volver al menú anterior");
                    int opcion2 = Teclado.pedirInt("\nElige una opcion: ");
                    switch (opcion2){
                        case 1:
                            mostrarInscripcion();
                            break;
                        case 2:
                            mostrarInscripcionPorSocio();
                            break;
                        case 3:
                            mostrarInscripcionPorFecha();
                            break;
                        case 4:
                            mostrarInscripcionPorSocioYFecha();
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

    public static void crearInscripcion() throws ParseException {
        int idSocio = Teclado.pedirInt("\nIntroduce el ID sel Socio que va a realizar la inscripcion: ");
        socioController.porId(idSocio);
        if (socioController.porId(idSocio) != null) {
            int idExcursion = Teclado.pedirInt("\nIntroduce la ID de la Excursion que desea realizar: ");
            LocalDate fechaInscripcion = LocalDate.now();
             inscripcionController.crear(idSocio, idExcursion, fechaInscripcion);
        } else {
            System.out.println("\nNo se ha encontrado el ID del socio");
            String opcion = Teclado.pedirString("\n ¿Desea añadir un nuevo socio? (s/n) ");
            switch (opcion){
                case "s":
                    crearSocio();
                    crearInscripcion();
                    break;
                case "n":
                    menuInscripciones();
                    break;
                default:
                    System.out.println("\nVolviendo al menu principal...");
                    menuPrincipal();
            }

        }
    }

    public static void mostrarInscripcion(){
        List<Inscripcion> inscripciones = inscripcionController.mostrar();
        System.out.println(inscripciones);
    }

    public static void mostrarInscripcionPorSocio(){
        int idSocio = Teclado.pedirInt("\nIntroduce el ID del socio: ");
        List<Inscripcion> inscripciones = inscripcionController.mostrarPorSocio(idSocio);
        System.out.println(inscripciones);
    }

    public static void mostrarInscripcionPorFecha() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = dateFormat.parse(Teclado.pedirString("Ingrese la fecha de inicio (dd/MM/yyyy): "));
        Date fechaFin = dateFormat.parse(Teclado.pedirString("Ingrese la fecha de fin (dd/MM/yyyy): "));
        if (fechaInicio.after(fechaFin)) {
            System.out.println("La fecha de inicio no puede ser posterior a la fecha de fin.");
            return;
        }
        List<Inscripcion> inscripciones = inscripcionController.mostrarPorFecha(fechaInicio, fechaFin);
        System.out.println(inscripciones);
    }

    public static void mostrarInscripcionPorSocioYFecha() throws ParseException {
        int idSocio = Teclado.pedirInt("\nIntroduce el ID del socio para encontrar inscripciones: ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = dateFormat.parse(Teclado.pedirString("Ingrese la fecha de inicio (dd/MM/yyyy): "));
        Date fechaFin = dateFormat.parse(Teclado.pedirString("Ingrese la fecha de fin (dd/MM/yyyy): "));
        if (fechaInicio.after(fechaFin)) {
            System.out.println("La fecha de inicio no puede ser posterior a la fecha de fin.");
            return;
        }
        List<Inscripcion> inscripciones = inscripcionController.mostrarPorSocioYFecha(idSocio, fechaInicio, fechaFin);
        System.out.println(inscripciones);
    }

    public static void borrarInscripcion() {
        int idInscripcion = Teclado.pedirInt("\nIntroduce el ID de la Inscripcion que desea eliminar: ");
        if (inscripcionController.porId(idInscripcion) != null) {
            inscripcionController.borrar(idInscripcion);
            System.out.println("\nLa inscripcion ha sido eliminada con exito.");
        } else {
            System.out.println("\nHa habido un error al eliminar la inscripcion.");
        }
    }
}