package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

public interface UserService {

    User find(String name);

    void register(User user);

    default boolean exists(String name) {
        return find(name) != null;
    }

    default UserService getInstance() {
        return UserServiceImpl.getService();
    }

}
