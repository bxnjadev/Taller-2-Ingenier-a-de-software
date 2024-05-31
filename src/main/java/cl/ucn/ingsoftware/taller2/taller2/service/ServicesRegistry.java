package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.Service;

import java.util.Set;

public interface ServicesRegistry {

    void add(Service service);

    void delete(String service);

    boolean exists(String service);

    Service find(String service);

    static ServicesRegistry getServicesRegistry() {
        return ServiceRegistryImpl.getInstance();
    }

}
