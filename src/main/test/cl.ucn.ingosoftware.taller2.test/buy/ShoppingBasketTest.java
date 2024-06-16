package cl.ucn.ingosoftware.taller2.test.buy;

import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;

    @BeforeEach
    public void setUp() {
        User user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.USER,
                150);

        shoppingBasket = new ShoppingBasket(
                user
        );

        shoppingBasket.addService(new Service(
                "Service1", 500
        ));
    }

    @Test
    public void clearTest() {
        shoppingBasket.clear();

        Assertions.assertTrue(shoppingBasket.getServices().isEmpty());
    }

    @Test
    public void testServices() {
        Set<Service> services = new HashSet<>();
        services.add(new Service(
                "Service1", 500));


        Assertions.assertEquals(services, shoppingBasket.getServices());
    }

    @Test
    public void getUserTest() {
        User user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.USER,
                150);

        Assertions.assertEquals(user, shoppingBasket.getUser());
    }

    @Test
    public void calculatePriceTest() {
        Assertions.assertEquals(500,
                shoppingBasket.calculatePrice());
    }

}

