package cl.ucn.ingosoftware.taller2.test.model;

import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceTest {

    private Service service;

    @BeforeEach
    public void setUp() {
        service = new
                Service("service", 100);
    }

    @Test
    public void getNameTest() {
        Assertions.assertEquals("service", service.getName());
    }

    @Test
    public void getPriceTest() {
        Assertions.assertEquals(100, service.getPrice());
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals("[name = service, price = 100]", service.toString());
    }

}
