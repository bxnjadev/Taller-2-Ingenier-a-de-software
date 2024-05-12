module cl.ucn.ingsoftware.taller2.taller2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens cl.ucn.ingsoftware.taller2.taller2 to javafx.fxml;
    exports cl.ucn.ingsoftware.taller2.taller2;
}