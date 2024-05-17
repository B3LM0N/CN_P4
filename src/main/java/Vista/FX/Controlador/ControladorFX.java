package Vista.FX.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorFX {
    @FXML
    private void cerrarVentana(ActionEvent event) {
        // Obtener el Stage actual
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cerrar el Stage
        stage.close();
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
        stage.setTitle("Menu Excursiones");
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

    /*
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
    protected void eliminarSocio() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Socios/eliminarSocio.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Eliminar un Socio");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
     */
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

    /*@FXML
    protected void mostrarFacturaSelec(){}
        @FXML
    protected void mostrarFactura(){
    }
     */
    @FXML
    protected void menuGestionInscripciones() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Menus/menuGestionInscripciones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Menu Excursiones");
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
