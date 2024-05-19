package cl.ucn.ingsoftware.taller2.taller2.authenticate;

import cl.ucn.ingsoftware.taller2.taller2.service.UserService;

public class DefaultAuthenticatorFactory implements AuthenticatorFactory {

    private final UserService userService;

    public DefaultAuthenticatorFactory(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authenticator get(AuthenticatorType type) {

        if (type == AuthenticatorType.BASIC) {
            return new BasicAuthenticator(userService);
        }

        return null;
    }

}
