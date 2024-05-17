package Vista.FX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Carga el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FX/Menus/menuPrincipalAplicacion.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Vista FX");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
