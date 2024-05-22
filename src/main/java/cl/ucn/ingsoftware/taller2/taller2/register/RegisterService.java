package cl.ucn.ingsoftware.taller2.taller2.register;

import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.service.UserService;

public interface RegisterService {

    /**
     *
     * @param name
     * @param age
     * @param mail
     * @param password
     * @param repeatPassword
     * @param rolType
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
