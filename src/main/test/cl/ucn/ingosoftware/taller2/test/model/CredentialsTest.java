package cl.ucn.ingosoftware.taller2.test.model;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CredentialsTest {

    private Credentials credentials;

    @BeforeEach
    public void setUp() {
        credentials = new Credentials("user@gmail.com",
                "password");
    }

    @Test
    public void tesGetIdentifier() {
        Assertions.assertEquals("user@gmail.com", credentials.getIdentifier());
    }

    @Test
    public void testGetPassword() {
        Assertions.assertEquals("password", credentials.getPassword());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("[identifier = user@gmail.com, password = password]",
                credentials.toString());
    }

}
