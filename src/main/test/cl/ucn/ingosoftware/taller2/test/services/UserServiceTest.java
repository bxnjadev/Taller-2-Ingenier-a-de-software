package cl.ucn.ingosoftware.taller2.test.services;

import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = UserService.getInstance();

        User user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);

        userService.register(user);
    }

    @Test
    public void testExists() {
        User user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);

        Assertions.assertEquals(user, userService.find("Maria"));
    }

    @Test
    public void testExistsByMail() {
        User user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);

        Assertions.assertEquals(user, userService.findByMail("maria@ucn.cl"));
    }

    @Test
    public void testFindByName() {

        User userOne = userService.find("Maria");
        User userTwo = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);

        Assertions.assertEquals(
                userOne,
                userTwo
        );
    }

    @Test
    public void testFindByMail() {

        User userOne = userService.findByMail("maria@ucn.cl");
        User userTwo = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);

        Assertions.assertEquals(
                userOne,
                userTwo
        );
    }

}
