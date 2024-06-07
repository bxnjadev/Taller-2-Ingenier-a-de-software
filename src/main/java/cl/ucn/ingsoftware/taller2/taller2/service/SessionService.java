package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.User;

/**
 * Handle the session
 */

public interface SessionService {

    /**
     * Crea a new session
     * @param user the user session
     */

    void newSession(User user);

    /**
     * Provide the user in the session
     * @return the user
     */

    User getSession();

    /**
     * Finish session
     */

    void close();

    static SessionService getInstance(){
        return SessionServiceImpl.getInstance();
    }

}
