package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.application.ListClientUsersController;
import eapli.base.infrastructure.bootstrapers.AGVBootsrapperBase;
import eapli.base.infrastructure.bootstrapers.ProductOrderBootstrapperBase;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.actions.Action;

import java.util.ArrayList;
import java.util.Set;

public class ProductOrderBootstrapper extends ProductOrderBootstrapperBase implements Action {


    @Override
    public boolean execute() {
        addProductOrder("123123124", "Green", 10L, "Apple Pay", 1, "nike.10100");
        addProductOrder("123123124", "Blue", 5L, "Paypal", 3, "nike.10100");
        addProductOrder("123123123", "Standard", 2L, "Apple Pay", 10, "nike.10100");
        addProductOrder("123451234", "Green", 10L, "Paypal", 15, "nike.10100");
        addProductOrder("123451234", "Green", 10L, "Paypal", 15, "nike.10100");
        addProductOrder("123451234", "Green", 10L, "Paypal", 15, "nike.10100");
        addProductOrder("123451234", "Green", 10L, "Paypal", 15, "nike.10100");
        addProductOrder("123451234", "Green", 10L, "Paypal", 15, "nike.10100");
        addProductOrder("123123123", "Green", 10L, "Paypal", 15, "nike.10100");
        addProductOrder("123451234", "Green", 10L, "Paypal", 15, "nike.10100");
        addProductOrder("123451234", "Green", 10L, "Paypal", 15, "nike.10100");
        addProductOrder("123451234", "Green", 10L, "Paypal", 15, "nike.10100");
        addProductOrder("123451234", "Green", 10L, "Paypal", 15, "nike.10100");

        return true;
    }
}
