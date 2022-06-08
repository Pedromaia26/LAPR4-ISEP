package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.bootstrapers.CategoryBootstrapperBase;
import eapli.base.infrastructure.bootstrapers.ContextBootstrapperBase;
import eapli.framework.actions.Action;

public class ContextBootstrapper  extends ContextBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        addContext("When a client place an order.");
        addContext("When a client belongs to an age range.");
        addContext("When a client order a product.");
        return true;
    }
}
