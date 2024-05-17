package Vista.FX.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    protected void crearExcursion() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Excursiones/crearExcursion.fxml"));
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
    protected void menuGestionInscripciones() throws IOException {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Menus/menuGestionInscripciones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Menu Excursiones");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
