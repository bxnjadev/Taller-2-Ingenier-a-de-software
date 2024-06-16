package cl.ucn.ingosoftware.taller2.test.model;

import cl.ucn.ingsoftware.taller2.taller2.model.ObjectToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObjectTokenTest {

    private ObjectToken objectToken;

    @BeforeEach
    public void setUp() {
        objectToken = new ObjectToken("aaa3f");
    }

    @Test
    public void getTokenTest() {
        Assertions.assertEquals("aaa3f", objectToken.getToken());
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals("[ token = aaa3f ]", objectToken.toString());
    }

}
