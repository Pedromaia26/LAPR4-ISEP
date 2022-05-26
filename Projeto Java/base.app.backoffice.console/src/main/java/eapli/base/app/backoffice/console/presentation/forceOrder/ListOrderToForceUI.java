package eapli.base.app.backoffice.console.presentation.forceOrder;

import eapli.base.app.backoffice.console.presentation.order.ProductOrderPrinter;
import eapli.base.ordermanagement.application.ListProductOrderController;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListOrderToForceUI extends AbstractListUI<ProductOrder> {
    private final ListProductOrderController theController = new ListProductOrderController();

    @Override
    protected Iterable<ProductOrder> elements() {
        return this.theController.productOrdersToBePrepared();
    }

    @Override
    protected Visitor<ProductOrder> elementPrinter() {
        return new ProductOrderForcePrinter();
    }

    @Override
    protected String elementName() {
        return "Product Order";
    }

    @Override
    protected String listHeader() {
        return "PRODUCT ORDER ID | CLIENT | CREATION DATA | PAYMENT METHOD";
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
