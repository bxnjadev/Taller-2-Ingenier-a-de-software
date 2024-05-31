package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

public interface SessionService {

    void newSession(User user);

    User getSession();

    void close();

    static SessionService getInstance(){
        return SessionServiceImpl.getInstance();
    }

}
