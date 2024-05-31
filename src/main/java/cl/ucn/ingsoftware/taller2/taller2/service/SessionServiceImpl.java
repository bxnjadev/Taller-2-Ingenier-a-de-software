package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

public class SessionServiceImpl implements SessionService {

    private static SessionService SESSION_SERVICE;
    private User userLogged;

    @Override
    public void newSession(User user) {
        userLogged = user;
    }

    @Override
    public User getSession() {
        return userLogged;
    }

    @Override
    public void close() {
        userLogged = null;
    }

    public static SessionService getInstance() {
        if (SESSION_SERVICE == null) {
            SESSION_SERVICE = new SessionServiceImpl();
        }
        return SESSION_SERVICE;
    }

}
