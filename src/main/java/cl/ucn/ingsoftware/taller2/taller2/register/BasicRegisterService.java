package cl.ucn.ingsoftware.taller2.taller2.register;

import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;

public class BasicRegisterService implements RegisterService {

    private static RegisterService REGISTER_SERVICE;

    private final UserService userService;

    public BasicRegisterService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public StatusRegister register(String name,
                                   int age,
                                   String mail,
                                   String password,
                                   String repeatPassword, RolType rolType) {

        User user = new User(
                name, age, mail, password, rolType
        );

        userService.register(user);
        return StatusRegister.OK;
    }

    public static RegisterService getInstance(UserService userService) {

        if (REGISTER_SERVICE == null) {
            REGISTER_SERVICE = new BasicRegisterService(userService);
        }

        return REGISTER_SERVICE;
    }

}
