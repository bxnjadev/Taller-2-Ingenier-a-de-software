package cl.ucn.ingsoftware.taller2.taller2.authenticate;

import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;

public class BasicAuthenticator implements Authenticator {

    private final UserService userService;

    public BasicAuthenticator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public AuthenticationResponse authenticate(Credentials credentials) {
        User userFound = userService.findByMail(credentials.getIdentifier());

        if (userFound == null || !userFound.getPassword().equals(credentials.getPassword())) {
            return AuthenticationResponse.failed();
        }

        return AuthenticationResponse.successful(userFound);
    }

}
