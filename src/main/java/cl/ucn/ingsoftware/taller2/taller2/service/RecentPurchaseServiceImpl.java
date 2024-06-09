package cl.ucn.ingsoftware.taller2.taller2.service;

import cl.ucn.ingsoftware.taller2.taller2.model.Purchase;
import cl.ucn.ingsoftware.taller2.taller2.model.User;

import java.util.HashMap;
import java.util.Map;

public class RecentPurchaseServiceImpl implements RecentPurchaseService {

    private static RecentPurchaseService RECENT_PURCHASE_SERVICE;
    private final Map<String, Purchase> purchasesRecent = new HashMap<>();

    @Override
    public void register(User user, Purchase purchase) {
        purchasesRecent.put(user.getName(), purchase);
    }

    @Override
    public Purchase find(User user) {
        return purchasesRecent.get(user.getName());
    }

    @Override
    public void delete(User user) {
        purchasesRecent.remove(user.getName());
    }

    public static RecentPurchaseService getInstance() {
        if (RECENT_PURCHASE_SERVICE == null) {
            RECENT_PURCHASE_SERVICE = new RecentPurchaseServiceImpl();
        }

        return RECENT_PURCHASE_SERVICE;
    }

}
