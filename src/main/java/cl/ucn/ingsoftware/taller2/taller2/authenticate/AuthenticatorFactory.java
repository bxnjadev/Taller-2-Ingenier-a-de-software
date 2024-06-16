package cl.ucn.ingsoftware.taller2.taller2.authenticate;

/**
 * The authenticator factory , this class focus the design pattern 'Factory', in this way, we can create vary
 * ways for manage authentications
 */

public interface AuthenticatorFactory {

    /**
     * This method authenticate to user
     * @param type the type authentication
     * @return the authentication response
     */

    Authenticator get(AuthenticatorType type);

}
