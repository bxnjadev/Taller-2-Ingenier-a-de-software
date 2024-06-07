package cl.ucn.ingsoftware.taller2.taller2.screen;

import javafx.fxml.FXMLLoader;

public class ScreenModel {

    private final FXMLLoader loader;
    private final int v1;
    private final int v2;

    public ScreenModel(FXMLLoader loader,
                       int v1,
                       int v2) {
        this.loader = loader;
        this.v1 = v1;
        this.v2 = v2;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }

}
