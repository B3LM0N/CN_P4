module CodeNexusP4 {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;

    opens Modelo.Entidades to org.hibernate.orm.core;
    opens Vista.FX to javafx.fxml;
    opens Vista.FX.Controlador to javafx.fxml;
    exports Vista.FX;
    exports com.po.main;
}