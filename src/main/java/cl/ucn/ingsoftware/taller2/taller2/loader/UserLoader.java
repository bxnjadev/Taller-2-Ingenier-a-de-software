package cl.ucn.ingsoftware.taller2.taller2.loader;

import cl.ucn.ingsoftware.taller2.taller2.adapter.UserDeserializer;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.util.Reader;
import cl.ucn.ingsoftware.taller2.taller2.util.ReaderUtil;
import cl.ucn.ingsoftware.taller2.taller2.util.StringReaderAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class UserLoader implements Loader {

    private static final String FILE_NAME = "users.json";
    private static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(User.class, new UserDeserializer())
            .create();

    private final UserService userService;

    public UserLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void load() {

        Reader reader = new
                StringReaderAdapter(FILE_NAME);

        String jsonBody = ReaderUtil.readAllAsString(reader);

        User[] users = GSON.fromJson(jsonBody, User[].class);
        addUsers(users, userService);

    }

    private void addUsers(User[] users, UserService service) {
        for (User user : users) {
            service.register(user);
        }
    }

}
