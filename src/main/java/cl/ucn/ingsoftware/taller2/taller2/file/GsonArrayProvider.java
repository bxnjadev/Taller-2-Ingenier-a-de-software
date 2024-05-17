package cl.ucn.ingsoftware.taller2.taller2.file;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonArrayProvider {

    private Gson gson;

    public GsonArrayProvider() {
        this(new GsonBuilder()
                .setPrettyPrinting()
                .create());
    }

    public GsonArrayProvider(Gson gson) {
        this.gson = gson;
    }

    public <T> T[] provide(Class<T> clazz,
                     String fileName) {


    }

}
