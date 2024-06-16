package cl.ucn.ingosoftware.taller2.test.model;

import cl.ucn.ingsoftware.taller2.taller2.model.Purchase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PurchaseTest {

    private Purchase purchase;

    @BeforeEach
    public void setUp() {
        Set<String> services = new HashSet<>();
        services.add("service");

        purchase = new Purchase(
                32171785, "15/06/2024 20:40",
                "15/12/2024 20:40",
                services
        );
    }

    @Test
    public void testGetCode() {
        Assertions.assertEquals(32171785, purchase.getCode());
    }

    @Test
    public void testGetDate() {
        Assertions.assertEquals("15/06/2024 20:40", purchase.getDate());
    }

    @Test
    public void testGetExpireDate() {
        Assertions.assertEquals("15/12/2024 20:40", purchase.getExpireDate());
    }

    @Test
    public void testGetServices() {
        Set<String> services = new HashSet<>();
        services.add("service");

        Assertions.assertEquals(services, purchase.servicesName());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("[code = 32171785, date = 15/06/2024 20:40, expire_date = 15/12/2024 20:40]",
                purchase.toString());
    }

}
