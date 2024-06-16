package cl.ucn.ingsoftware.taller2.taller2.register;

import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;

/**
 * This class manage the requets for register a new user in the service
 */

public interface RegisterService {

    /**
     * Register a new user
     * @param name the user name
     * @param age the age name
     * @param mail the mail name
     * @param password the password
     * @param repeatPassword the repeat passwordd name
     * @param rolType the user rol type
     * @return
     */

     StatusRegister register(
            String name,
            int age,
            String mail,
            String password,
            String repeatPassword,
            RolType rolType
    );

     static RegisterService getInstance(UserService userService) {
         return BasicRegisterService.getInstance(userService);
     }

}
