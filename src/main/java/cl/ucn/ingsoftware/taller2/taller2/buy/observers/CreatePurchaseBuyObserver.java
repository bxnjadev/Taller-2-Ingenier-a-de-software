package cl.ucn.ingsoftware.taller2.taller2.buy.observers;

import cl.ucn.ingsoftware.taller2.taller2.buy.MethodPay;
import cl.ucn.ingsoftware.taller2.taller2.buy.ServicesBuyObserver;
import cl.ucn.ingsoftware.taller2.taller2.buy.ShoppingBasket;
import cl.ucn.ingsoftware.taller2.taller2.model.Purchase;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.service.RecentPurchaseService;
import cl.ucn.ingsoftware.taller2.taller2.util.DateConversionApplier;
import cl.ucn.ingsoftware.taller2.taller2.util.DateProvider;
import cl.ucn.ingsoftware.taller2.taller2.util.Identifiers;

import java.util.*;

/**
 * A observer when is executed a user bough a service
 */

public class CreatePurchaseBuyObserver implements ServicesBuyObserver {

    private static final String FORMAT_TIME = "dd/MM/yyyy HH:mm";
    private static final String NEW_LINE = "\n";

    private final DateProvider dateProvider;
    private final RecentPurchaseService recentPurchaseService;

    public CreatePurchaseBuyObserver() {
        recentPurchaseService = RecentPurchaseService.getInstance();
        dateProvider = DateProvider.format(FORMAT_TIME);
    }

    /**
     * Provide a percentage in points
     * @param shoppingBasket the shoppingBasket object
     * @param methodPay the method pay object
     */

    @Override
    public void buy(ShoppingBasket shoppingBasket,
                    MethodPay methodPay) {

        int code = Identifiers.newId();
        String actualDateAsString = dateProvider.provide();
        String dateSixMonthAsString = dateProvider.provide(
                DateConversionApplier.mouthToMilliseconds(6)
        );

        Set<String> elementsAsString = convertServicesToListString(
                shoppingBasket.getServices()
        );

        Purchase purchase = new Purchase(
                code,
                actualDateAsString,
                dateSixMonthAsString,
                elementsAsString
        );

        recentPurchaseService.register(
                shoppingBasket.getUser(),
                purchase
        );

    }

    private Set<String> convertServicesToListString(Collection<Service> services) {
        Set<String> elements = new HashSet<>();

        for (Service service : services) {
            elements.add(
                    service.getName()
            );
        }

        return elements;
    }

}
