package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.Purchase;
import cl.ucn.ingsoftware.taller2.taller2.model.User;

/**
 * This class contains the recent purchased created
 */

public interface RecentPurchaseService {

    /**
     * Register a new recent purchase
     * @param user the object user
     * @param purchase the object purchase
     */

    void register(User user, Purchase purchase);

    /**
     * Find recent purchase by user
     * @param user the object user
     * @return a recent purchase
     */

    Purchase find(User user);

    /**
     * Delete a recent purchase
     * @param user the user associate with those purchase
     */

    void delete(User user);

    static RecentPurchaseService getInstance() {
        return RecentPurchaseServiceImpl.getInstance();
    }

}
