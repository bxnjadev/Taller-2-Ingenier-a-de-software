package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

/**
 * Manage all users
 */

public interface UserService {

    /**
     * Find a user
     * @param name the user name
     * @return the user found
     */

    User find(String name);

    /**
     * Find a user by her mail
     * @param mail the mail
     * @return the user found
     */

    User findByMail(String mail);

    /**
     * Register a new user
     * @param user the user
     */

    void register(User user);

    /**
     * Check if user exists
     * @param name the user name
     * @return the user
     */

    default boolean exists(String name) {
        return find(name) != null;
    }

    static UserService getInstance() {
        return UserServiceImpl.getService();
    }

}
