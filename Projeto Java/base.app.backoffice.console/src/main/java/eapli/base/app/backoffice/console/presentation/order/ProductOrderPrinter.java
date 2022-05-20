package eapli.base.app.backoffice.console.presentation.order;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.visitor.Visitor;

public class ProductOrderPrinter implements Visitor<ProductOrder> {

    @Override
    public void visit(final ProductOrder visitee) {
        System.out.printf("%-5s|%-12s|%-12s", visitee.identity(), visitee.clientUser().identity().vat(), visitee.Agv().identity().AgvIdentifier());
    }
}
