package cl.ucn.ingsoftware.taller2.taller2.authenticate;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

/**
 * This class represent a response as authentication
 */

public class AuthenticationResponse {

    private final User user;
    private final StatusAuthenticationResponse response;

    private AuthenticationResponse(User user,
                                   StatusAuthenticationResponse response) {
        this.user = user;
        this.response = response;
    }

    /**
     * Get the user authenticated
     * @return the user authenticated
     */

    public User getUser() {
        return user;
    }

    /**
     * Get response authentication
     * @return the response
     */

    public StatusAuthenticationResponse getResponse() {
        return response;
    }

    /**
     * Check if authentication response is failed
     * @return true if the authentication is successful
     */

    public boolean isFailed() {
        return response == StatusAuthenticationResponse.FAILED;
    }

    public static AuthenticationResponse failed() {
        return new AuthenticationResponse(
                null, StatusAuthenticationResponse.FAILED
        );
    }

    public static AuthenticationResponse successful(User user) {
        return new AuthenticationResponse(
                user, StatusAuthenticationResponse.SUCCESSFUL
        );
    }

}
