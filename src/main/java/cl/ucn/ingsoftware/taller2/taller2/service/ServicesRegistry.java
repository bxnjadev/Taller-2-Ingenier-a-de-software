package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.Service;

import java.util.Collection;
import java.util.Set;

/**
 * This class manage the services registry
 */

public interface ServicesRegistry {

    /**
     * This method allow adding new service
     * @param service the service data
     */

    void add(Service service);

    /**
     * This method allow deleting a service
     * @param service the service data
     */

    void delete(String service);

    /**
     * Check if a service exists
     * @param service the service name
     * @return true if the service exists
     */

    boolean exists(String service);

    /**
     * Find a service
     * @param service the service name
     * @return the service data
     */

    Service find(String service);

    /**
     * Get all services
     * @return a collection with service content
     */

    Collection<Service> all();

    static ServicesRegistry getServicesRegistry() {
        return ServiceRegistryImpl.getInstance();
    }

}
