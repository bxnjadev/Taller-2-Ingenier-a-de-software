module cl.ucn.ingsoftware.taller2.taller2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens cl.ucn.ingsoftware.taller2.taller2 to javafx.fxml;
    opens cl.ucn.ingsoftware.taller2.taller2.model to javafx.fxml;
    exports cl.ucn.ingsoftware.taller2.taller2;
    exports cl.ucn.ingsoftware.taller2.taller2.controllers;
    opens cl.ucn.ingsoftware.taller2.taller2.controllers to javafx.fxml;
    exports cl.ucn.ingsoftware.taller2.taller2.model;
}