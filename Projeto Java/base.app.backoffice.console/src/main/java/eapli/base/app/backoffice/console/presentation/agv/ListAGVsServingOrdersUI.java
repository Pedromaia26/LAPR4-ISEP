package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agvmanagement.application.AGVListController;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListAGVsServingOrdersUI extends AbstractListUI<AGV>
{
    private final AGVListController agvListController = new AGVListController();

    @Override
    protected Iterable<AGV> elements() {
        return this.agvListController.agvsServingOrders();
    }

    @Override
    protected Visitor<AGV> elementPrinter() {
        return new AGVPrinter();
    }

    @Override
    protected String elementName() {
        return "AGV";
    }

    @Override
    protected String listHeader() {
        return "AGV ID | MAXIMUM WEIGHT SUPPORTED | MAXIMUM VOLUME SUPPORTED";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    public String headline() {
        return "AGVs serving orders list";
    }
}