package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.bootstrapers.AGVBootsrapperBase;
import eapli.base.infrastructure.bootstrapers.ProductOrderBootstrapperBase;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.actions.Action;

public class ProductOrderBootstrapper extends ProductOrderBootstrapperBase implements Action {
    @Override
    public boolean execute() {
        addProductOrder("123123124");
        addProductOrder("123123124");
        return true;
    }
}
