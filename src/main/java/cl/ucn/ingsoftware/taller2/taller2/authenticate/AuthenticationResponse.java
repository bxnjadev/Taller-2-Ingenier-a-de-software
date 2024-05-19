package cl.ucn.ingsoftware.taller2.taller2.authenticate;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

public class AuthenticationResponse {

    private final User user;
    private final StatusAuthenticationResponse response;

    private AuthenticationResponse(User user,
                                   StatusAuthenticationResponse response) {
        this.user = user;
        this.response = response;
    }

    public User getUser() {
        return user;
    }

    public StatusAuthenticationResponse getResponse() {
        return response;
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
