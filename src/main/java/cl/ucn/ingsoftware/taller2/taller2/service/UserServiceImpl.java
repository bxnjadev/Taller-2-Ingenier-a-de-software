package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public User find(String name) {
        return users.get(name);
    }

    @Override
    public void register(User user) {
        users.put(user.getName(), user);
    }

}
