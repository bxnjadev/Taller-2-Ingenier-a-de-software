package cl.ucn.ingsoftware.taller2.taller2.shutdown;

import cl.ucn.ingsoftware.taller2.taller2.service.UserService;

public class ServiceShutdown implements Shutdown {

    private final UserService userService;

    public ServiceShutdown() {
        userService = UserService.getInstance();
    }

    @Override
    public void shutdown() {

    }

}
