package eapli.base.app.backoffice.console.presentation.forceOrder;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.visitor.Visitor;

public class ProductOrderForcePrinter implements Visitor<ProductOrder> {

    @Override
    public void visit(final ProductOrder visitee) {
        System.out.printf("%-5s|%-12s|%-12s|%-12s", visitee.identity(), visitee.clientUser().identity().vat(), visitee.CreatedOn().getTime(), visitee.PaymentMethod());
    }
}
