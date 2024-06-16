package cl.ucn.ingsoftware.taller2.taller2.authenticate;

import cl.ucn.ingsoftware.taller2.taller2.service.UserService;

/**
 * The main implementation of authenticator factory
 */

public class DefaultAuthenticatorFactory implements AuthenticatorFactory {

    private final UserService userService;

    public DefaultAuthenticatorFactory(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get authenticat
     * @param type the type authentication
     * @return a authenticator
     */

    @Override
    public Authenticator get(AuthenticatorType type) {

        if (type == AuthenticatorType.BASIC) {
            return new BasicAuthenticator(userService);
        }

        return null;
    }

}
