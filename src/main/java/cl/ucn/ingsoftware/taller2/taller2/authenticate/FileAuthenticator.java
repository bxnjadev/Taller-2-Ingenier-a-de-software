package cl.ucn.ingsoftware.taller2.taller2.authenticate;

import cl.ucn.ingsoftware.taller2.taller2.file.GsonArrayProvider;
import cl.ucn.ingsoftware.taller2.taller2.model.User;

import java.util.ArrayList;
import java.util.List;

public class FileAuthenticator implements Authenticator {

    private final List<User> users;

    public FileAuthenticator(GsonArrayProvider userGsonArrayProvider) {

        User[] usersArray = userGsonArrayProvider.provide(
                User.class,
                ""
        );

        users = new ArrayList<>(
                List.of(usersArray)
        );
    }

    @Override
    public User authenticate(Credentials credentials) {
        User userFound = findUser(credentials);

        if (userFound == null) {
            return null;
        }

        String password = userFound.getPassword();
        return password.equals(credentials.getPassword()) ? userFound : null;
    }

    private User findUser(Credentials credentials) {

        for (User user : users) {
            if (user.getName().equals(credentials.getUsername())) {
                return user;
            }
        }

        return null;
    }

}
