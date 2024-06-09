package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.Purchase;
import cl.ucn.ingsoftware.taller2.taller2.model.User;

public interface RecentPurchaseService {

    void register(User user, Purchase purchase);

    Purchase find(User user);

    void delete(User user);

    static RecentPurchaseService getInstance() {
        return RecentPurchaseServiceImpl.getInstance();
    }

}
