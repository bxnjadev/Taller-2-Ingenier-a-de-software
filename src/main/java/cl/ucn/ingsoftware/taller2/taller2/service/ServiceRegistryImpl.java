package cl.ucn.ingsoftware.taller2.taller2.service;

import java.util.HashSet;
import java.util.Set;

public class ServiceRegistryImpl implements ServicesRegistry {

    private final Set<String> services = new HashSet<>();
    private static ServicesRegistry SERVICES_REGISTRY;

    private ServiceRegistryImpl() {

    }

    @Override
    public void add(String service) {
        services.add(service);
    }

    @Override
    public void delete(String service) {
        services.remove(service);
    }

    @Override
    public boolean exists(String service) {
        return services.contains(service);
    }

    public static ServicesRegistry getInstance() {
        if (SERVICES_REGISTRY == null) {
            SERVICES_REGISTRY = new ServiceRegistryImpl();
        }
        return SERVICES_REGISTRY;
    }

}
