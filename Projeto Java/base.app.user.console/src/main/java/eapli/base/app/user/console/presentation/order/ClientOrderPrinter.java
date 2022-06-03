package eapli.base.app.user.console.presentation.order;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.visitor.Visitor;

public class ClientOrderPrinter implements Visitor<ProductOrder> {

    @Override
    public void visit(final ProductOrder visitee) {
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-4s€", visitee.identity(), visitee.CreatedOn().getTime().toString(), visitee.PaymentMethod(), visitee.ShipmentMethod(),
                visitee.Status().Description().description(), visitee.TotalAmountWithTaxes());
    }

}
