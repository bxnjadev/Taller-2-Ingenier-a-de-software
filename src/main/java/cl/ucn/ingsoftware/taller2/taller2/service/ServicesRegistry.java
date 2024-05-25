package cl.ucn.ingsoftware.taller2.taller2.service;

public interface ServicesRegistry {

    void add(String service);

    void delete(String service);

    boolean exists(String service);

    static ServicesRegistry getServicesRegistry() {
        return ServiceRegistryImpl.getInstance();
    }

}
