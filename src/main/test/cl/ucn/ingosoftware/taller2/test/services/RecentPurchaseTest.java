package cl.ucn.ingosoftware.taller2.test.services;

import cl.ucn.ingsoftware.taller2.taller2.model.Purchase;
import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.RecentPurchaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class RecentPurchaseTest {

    private RecentPurchaseService recentPurchaseService;

    @BeforeEach
    public void setUp() {
        recentPurchaseService = RecentPurchaseService.getInstance();
        Set<String> services = new HashSet<>();
        services.add("service");

        User user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);

        Purchase purchase = new Purchase(
                32171785, "15/06/2024 20:40",
                "15/12/2024 20:40",
                services
        );

        recentPurchaseService.register(
                user, purchase
        );
    }

    @Test
    public void findTest() {
        Set<String> services = new HashSet<>();
        services.add("service");

        User user = new User("Maria",
                20,
                "maria@ucn.cl",
                "password",
                RolType.ADMINISTRATOR,
                150);

        Purchase purchase = new Purchase(
                32171785, "15/06/2024 20:40",
                "15/12/2024 20:40",
                services
        );

        Assertions.assertEquals(
                purchase, recentPurchaseService.find(user)
        );

    }

}
