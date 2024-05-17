package cl.ucn.ingsoftware.taller2.taller2.loader;

import cl.ucn.ingsoftware.taller2.taller2.service.UserService;

public class UserLoader implements Loader {

    private UserService userService;

    public UserLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void load() {



    }

}
