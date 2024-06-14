package cl.ucn.ingosoftware.taller2.test.authentication;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.AuthenticationResponse;
import cl.ucn.ingsoftware.taller2.taller2.authenticate.Authenticator;
import cl.ucn.ingsoftware.taller2.taller2.authenticate.BasicAuthenticator;
import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import cl.ucn.ingsoftware.taller2.taller2.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthenticationTest {

    private UserService userService;
    private Authenticator authenticator;

    @BeforeEach
    public void setUp() {
        userService = UserService.getInstance();
        authenticator = new BasicAuthenticator(userService);

        userService.register(
                new User("Maria",
                        20,
                        "maria@ucn.cl",
                        "password",
                        RolType.ADMINISTRATOR,
                        150)
        );
    }

    @Test
    public void testAuthentication() {
        Credentials credentials = new Credentials(
                "maria@ucn.cl",
                "password"
        );

        AuthenticationResponse response = authenticator.authenticate(
            credentials
        );

        Assertions.assertFalse(response.isFailed());
    }

}
