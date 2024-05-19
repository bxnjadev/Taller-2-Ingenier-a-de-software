package cl.ucn.ingsoftware.taller2.taller2.authenticate;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

public interface Authenticator {

    /**
     * Authenticate with the system
     * @param credentials the access credentials
     * @return User the user access
     */

    AuthenticationResponse authenticate(Credentials credentials);

}
