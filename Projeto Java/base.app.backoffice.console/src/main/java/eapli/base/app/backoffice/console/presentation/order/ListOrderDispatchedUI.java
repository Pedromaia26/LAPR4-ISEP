package eapli.base.app.backoffice.console.presentation.order;

import eapli.base.app.backoffice.console.presentation.product.ProductPrinter;
import eapli.base.ordermanagement.application.ListProductOrderController;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListOrderDispatchedUI  extends AbstractListUI<ProductOrder> {
    private final ListProductOrderController theController = new ListProductOrderController();

    @Override
    protected Iterable<ProductOrder> elements() {
        return this.theController.productOrdersDispatched();
    }

    @Override
    protected Visitor<ProductOrder> elementPrinter() {
        return new ProductOrderPrinter();
    }

    @Override
    protected String elementName() {
        return "Product Order";
    }

    @Override
    protected String listHeader() {
        return "PRODUCT ORDER ID | CLIENT";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    public String headline() {
        return "List product orders already prepared";
    }
}
