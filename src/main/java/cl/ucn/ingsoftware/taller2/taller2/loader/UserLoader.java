package cl.ucn.ingsoftware.taller2.taller2.loader;

import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.util.Reader;
import cl.ucn.ingsoftware.taller2.taller2.util.StringReaderAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserLoader implements Loader {

    private static final String FILE_NAME = "users.json";
    private static final Gson GSON = new GsonBuilder()
            .create();

    private UserService userService;

    public UserLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void load() {

        Reader reader = new
                StringReaderAdapter(FILE_NAME);



    }

}
