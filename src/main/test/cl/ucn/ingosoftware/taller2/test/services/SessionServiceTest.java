package cl.ucn.ingosoftware.taller2.test.services;

import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.SessionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SessionServiceTest {

    private SessionService session;

    @BeforeEach
    public void setUp() {
        session = SessionService.getInstance();

        User user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);

        session.newSession(user);
    }

    @Test
    public void testGetSession() {
        User user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);

        Assertions.assertEquals(user, session.getSession());
    }

    @Test
    public void testCloseSession() {
        session.close();

        Assertions.assertNull(session.getSession());
    }

}
