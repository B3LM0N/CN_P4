package Vista.FX.Controlador;

import Controlador.ExcursionController;
import Controlador.InscripcionController;
import Util.Teclado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Modelo.Entidades.*;
import Controlador.SocioController;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

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
        showAlert("Éxito", "Socio creado exitosamente.");

    }
    @FXML
    protected void mostrarExcursionesPorFechas() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Excursiones/mostrarExcursion.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mostrar Excursiones");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
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
    protected void cambiarSeguroSocio() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/cambioSeguro.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cambio de Seguro");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
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
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/mostrarSocios.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mostrar Socios");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void mostrarSocioEstandar() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/mostrarSocios.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mostrar Socios");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
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
    protected void crearInscripcion() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Inscripciones/crearInscripcionForm.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Crear Inscripcion");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    @FXML
    protected void eliminarInscripcion() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Inscripciones/eliminarInscripcion.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Eliminar Inscripcion");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
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
