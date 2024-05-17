module CodeNexusP4 {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;

    opens Vista.FX to javafx.fxml;
    opens Vista.FX.Controlador to javafx.fxml;
    exports Vista.FX;
    exports com.po.main;
}