package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

public interface UserService {

    User find(String name);

    User findByMail(String mail);

    void register(User user);

    default boolean exists(String name) {
        return find(name) != null;
    }

    static UserService getInstance() {
        return UserServiceImpl.getService();
    }

}
