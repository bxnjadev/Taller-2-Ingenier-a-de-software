package cl.ucn.ingsoftware.taller2.taller2.graphic;

public interface StageHandler {

    void register(
            String id,
            String nameFile,
            String title
    );

    void open(String id);

    void close(String id);


}
