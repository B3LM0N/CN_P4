package Vista.FX.Controlador;

import Controlador.ExcursionController;
import Controlador.InscripcionController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Modelo.Entidades.*;
import Controlador.SocioController;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class ControladorFX {

    static SocioController socioController = new SocioController();
    static ExcursionController excursionController = new ExcursionController();
    static InscripcionController inscripcionController = new InscripcionController();

    @FXML
    private TextField nombreField;
    @FXML
    private TextField nifFieldEstandar;
    @FXML
    private TextField nifFieldFederado;
    @FXML
    private TextField nombreFederacionField;
    @FXML
    private TextField idTutorField;
    @FXML
    private ChoiceBox<String> tipoSocio;
    @FXML
    private ChoiceBox<String> tipoSeguro;
    @FXML
    private TextField idSocioField;
    @FXML
    private TextField descripcionField;
    @FXML
    private DatePicker fechaExcursionDate;
    @FXML
    private TextField duracionDiasField;
    @FXML
    private TextField precioInscripcionField;
    @FXML
    private TextField idExcursionField;
    @FXML
    private TextField idInscripcionField;
    @FXML
    private DatePicker fechaInicial;
    @FXML
    private DatePicker fechaFinal;
    @FXML
    private ListView<Excursion> listaExcursiones;
    @FXML
    private ListView<Socio> listaSocios;
    @FXML
    private ChoiceBox<String> choiceBoxTipoSocio;


    @FXML
    private void cerrarVentana(ActionEvent event) {
        // Obtener el Stage actual
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cerrar el Stage
        stage.close();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void setListaExcursiones(ObservableList<Excursion> excursiones) {
        listaExcursiones.setItems(excursiones);
    }
    public void setListaSocios(ObservableList<Socio> socios) {
        listaSocios.setItems(socios);
    }

    @FXML
    protected void menuGestionExcursiones() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Menus/menuGestionExcursiones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Menu Excursiones");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void crearExcursionForm() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Excursiones/crearExcursionForm.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Crear Excursion");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    private void crearExcursion(){
    String descripcion = descripcionField.getText();
        Date fechaExcursion = Date.from(fechaExcursionDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        int duracionDias = Integer.parseInt(duracionDiasField.getText());
        double precioInscripcion = Double.parseDouble(precioInscripcionField.getText());
        // Llamar al método de negocio
        Excursion excursion = excursionController.crear(descripcion, fechaExcursion, duracionDias, precioInscripcion);

        // Muestra un mensaje de éxito
        showAlert("Éxito", "Excursión creada exitosamente.");
    }
    @FXML
    protected void mostrarExcursionesPorFechas() throws IOException {
        Date fechaInicio = Date.from(fechaInicial.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(fechaFinal.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (fechaInicio.after(fechaFin)) {
            showAlert("Error", "No es ha sido posible seleccionar las fechas.");
            return;
        }
        // Filtra las excursiones por fechas
        List<Excursion> excursionesFiltradas = excursionController.mostrar(fechaInicio, fechaFin);
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Excursiones/mostrarExcursion.fxml"));
        AnchorPane root = loader.load();
        // Obtén el controlador y establece la lista de excursiones filtradas
        ControladorFX controlador = loader.getController();
        controlador.setListaExcursiones(FXCollections.observableArrayList(excursionesFiltradas));
        // Configura y muestra la ventana
        Stage stage = new Stage();
        stage.setTitle("Mostrar Excursiones");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    protected void menuGestionSocios() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Menus/menuGestionSocios.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Menu Socios");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void crearSocioForm() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/crearSocioTipo.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Crear Socio");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    private void crearSocio(){
        String nombre = nombreField.getText();
        String tipoSocioStr = tipoSocio.getValue();
        int tipoSocio = 0;
        String nif = null, nombreFederacion = null;
        int idTutor = 0, opcionSeguro = 0;

        if (tipoSocioStr == null) {
            showAlert("Error", "Debe seleccionar un tipo de socio.");
            return;
        }
        switch (tipoSocioStr) {
            case "Estandar":
                tipoSocio = 1;
                nif = nifFieldEstandar.getText();
                String tipoSeguroStr = tipoSeguro.getValue();
                if (tipoSeguroStr != null) {
                    opcionSeguro = tipoSeguroStr.startsWith("Basico") ? 1 : 2;
                }
                break;
            case "Federado":
                tipoSocio = 2;
                nif = nifFieldFederado.getText();
                nombreFederacion = nombreFederacionField.getText();
                break;
            case "Infantil":
                tipoSocio = 3;
                if (idTutorField.getText().isEmpty()) {
                    showAlert("Error", "Debe ingresar el ID del tutor para Socio Infantil.");
                    return;
                }
                idTutor = Integer.parseInt(idTutorField.getText());
                break;
            default:
                showAlert("Error", "Tipo de socio no válido.");
                return;
        }
        // Llamar al método de negocio
        Socio socio = socioController.crear(nombre, tipoSocio, nif, opcionSeguro, nombreFederacion, idTutor);

        // Muestra un mensaje de éxito
        showAlert("Éxito", "Socio creado exitosamente.");
    }
    @FXML
    protected void cambiarSeguroSocioSelec() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/cambioSeguro.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cambio de Seguro");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    private void cambiarSeguroSocio(){
        int idSocio = Integer.parseInt(idSocioField.getText());
        int nuevoSeguroContratado = 0;
        String tipoSeguroStr = tipoSeguro.getValue();
        if (tipoSeguroStr != null) {
            nuevoSeguroContratado = tipoSeguroStr.startsWith("Basico") ? 1 : 2;
        }
        // Llamar al método de negocio
        Estandar socio = socioController.modificarSeguroSocio(idSocio,nuevoSeguroContratado);
        // Muestra un mensaje de éxito
        showAlert("Éxito", "Seguro modificado correctamente.");
    }
    @FXML
    protected void borrarSocioSelec() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/eliminarSocio.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Eliminar un Socio");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    private void borrarSocio(){
        int idSocio = 0;
        idSocio = Integer.parseInt(idSocioField.getText());
        if (socioController.porId(idSocio) != null) {
            socioController.borrar(idSocio);
            showAlert("Exito", "El socio ha sido eliminado.");
        } else {
            showAlert("Error", "Socio no encontrado.");
        }
    }
    @FXML
    protected void mostrarSociosSelec() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/mostrarSociosSelec.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mostrar Socios");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void mostrarTodosSocios() throws IOException {
        // Obtén todas las excursiones
        List<Socio> socios = socioController.mostrar();

        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/mostrarSocios.fxml"));
        AnchorPane root = loader.load();

        // Obtén el controlador y establece la lista de todas las excursiones
        ControladorFX controlador = loader.getController();
        controlador.setListaSocios(FXCollections.observableArrayList(socios));

        // Configura y muestra la ventana
        Stage stage = new Stage();
        stage.setTitle("Mostrar Todas las Excursiones");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    protected void mostrarSociosPorTipo() throws IOException {
        // Obtener el tipo de socio seleccionado del ChoiceBox
        String tipoSocioSeleccionado = choiceBoxTipoSocio.getValue();

        // Verificar si se ha seleccionado un tipo de socio
        if (tipoSocioSeleccionado != null) {
            // Obtener la lista de socios del tipo seleccionado
            List<Socio> sociosFiltrados = socioController.mostrarPorTipo(tipoSocioSeleccionado);

            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/mostrarSocios.fxml"));
            AnchorPane root = loader.load();

            // Obtener el controlador y establecer la lista de socios filtrados
            ControladorFX controlador = loader.getController();
            controlador.setListaSocios(FXCollections.observableArrayList(sociosFiltrados));

            // Configurar y mostrar la ventana
            Stage stage = new Stage();
            stage.setTitle("Mostrar Socios " + tipoSocioSeleccionado);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            showAlert("Error","Selecciona un Tipo de Socio");
        }

    }
    @FXML
    protected void mostrarSocioFederado() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/mostrarSocios.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mostrar Socios");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void mostrarSocioInfantil() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/mostrarSocios.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mostrar Socios");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void mostrarFacturaSelec() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/mostrarFacturaSelec.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mostrar Factura");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }



    @FXML
    protected void menuGestionInscripciones() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Menus/menuGestionInscripciones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Menu Inscripciones");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void crearInscripcionForm() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Inscripciones/crearInscripcionForm.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Crear Inscripcion");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    private void crearIncripcion(){
        int idSocio = Integer.parseInt(idSocioField.getText());
        int idExcursion = Integer.parseInt(idExcursionField.getText());
        LocalDate fechaInscripcion = LocalDate.now();
        // Llamar al método de negocio
        Inscripcion inscripcion = inscripcionController.crear(idSocio, idExcursion, fechaInscripcion);

        // Muestra un mensaje de éxito
        showAlert("Éxito", "Inscripción creada con éxito.");
    }
    @FXML
    protected void borrarInscripcionSelec() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Inscripciones/eliminarInscripcion.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Eliminar Inscripcion");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    private void borrarInscripcion(){
        int idInscripcion = 0;
        idInscripcion = Integer.parseInt(idInscripcionField.getText());
        if (inscripcionController.porId(idInscripcion) != null) {
            inscripcionController.borrar(idInscripcion);
            showAlert("Exito", "La inscripción ha sido borrada.");
        } else {
            showAlert("Error", "No se ha encontrado la inscripción.");
        }
    }
    @FXML
    protected void mostrarInscripcionSelec() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Inscripciones/mostrarInscripcionesSelec.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Lista de Inscripciones");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void mostrarInscripcionSinFiltro() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Inscripciones/mostrarInscripciones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Lista de Inscripciones sin Filtrar");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void mostrarInscripcionPorSocio() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Inscripciones/mostrarInscripciones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Lista de Inscripciones por Socio");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void mostrarInscripcionPorFecha() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Inscripciones/mostrarInscripciones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Lista de Inscripciones por Fecha");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void mostrarInscripcionPorSocioYFecha() throws IOException {        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Inscripciones/mostrarInscripciones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Lista de Inscripciones por Socio y Fecha");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }


}

