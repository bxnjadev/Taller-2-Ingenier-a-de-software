package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ServiceRegistryImpl implements ServicesRegistry {

    private final Map<String, Service> services = new HashMap<>();
    private static ServicesRegistry SERVICES_REGISTRY;

    private ServiceRegistryImpl() {

    }

    @Override
    public void add(Service service) {
        services.put(service.getName(), service);
    }

    @Override
    public void delete(String service) {
        services.remove(service);
    }

    @Override
    public boolean exists(String service) {
        return find(service) != null;
    }

    @Override
    public Service find(String service) {
        return services.get(service.toLowerCase(Locale.ROOT));
    }

    @Override
    public Collection<Service> all() {
        return services.values();
    }

    public static ServicesRegistry getInstance() {
        if (SERVICES_REGISTRY == null) {
            SERVICES_REGISTRY = new ServiceRegistryImpl();
        }
        return SERVICES_REGISTRY;
    }

}
