package cl.ucn.ingsoftware.taller2.taller2.authenticate;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

/**
 * This class perms managa the authentication system
 */

public interface Authenticator {

    /**
     * Authenticate with the system
     * @param credentials the access credentials
     * @return AuthenticationResponse
     */

    AuthenticationResponse authenticate(Credentials credentials);

}
