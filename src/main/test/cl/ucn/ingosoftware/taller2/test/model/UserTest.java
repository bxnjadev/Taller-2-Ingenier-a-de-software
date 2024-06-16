package cl.ucn.ingosoftware.taller2.test.model;

import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);
    }

    @Test
    public void nameTest() {
        Assertions.assertEquals(user.getName(), "Maria");
    }

    @Test
    public void ageTest() {
        Assertions.assertEquals(user.getAge(), 20);
    }

    @Test
    public void mailTest() {
        Assertions.assertEquals(user.getMail(), "maria@ucn.cl");
    }

    @Test
    public void passwordTest() {
        Assertions.assertEquals(user.getPassword(), "password");
    }

    @Test
    public void rolTypeTest() {
        Assertions.assertEquals(user.getRolType(), RolType.ADMINISTRATOR);
    }

    @Test
    public void pointsTest() {
        Assertions.assertEquals(user.getPoints(), 150);
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals(
                user.toString(),
                "[name = Maria, age = 20, mail = maria@ucn.cl, password = password, rolType = ADMINISTRATOR, points = 150]"
        );
    }

}
