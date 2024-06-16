package cl.ucn.ingosoftware.taller2.test.services;

import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.ServicesRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceRegistryTest {

    private ServicesRegistry servicesRegistry;

    @BeforeEach
    public void setUp() {
        servicesRegistry = ServicesRegistry.getServicesRegistry();

        servicesRegistry.add(
                new Service("servicio", 100)
        );

    }

    @Test
    public void testExists() {
        Service service = new Service("servicio", 100);
        Assertions.assertEquals(service, servicesRegistry.find(service.getName()));
    }

    @Test
    public void testDelete() {
        servicesRegistry.delete("servicio");

        Assertions.assertTrue(
                servicesRegistry.all().isEmpty()
        );
    }

    @Test
    public void testFind() {

        Service serviceOne = servicesRegistry.find("servicio");
        Service serviceTwo = new Service("servicio", 100);

        Assertions.assertEquals(
                serviceOne,
                serviceTwo
        );
    }

}
