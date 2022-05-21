package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agvmanagement.application.AGVListController;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListAGVUI extends AbstractListUI<AGV>
{
    private final AGVListController agvListController = new AGVListController();

    @Override
    protected Iterable<AGV> elements() {
        return this.agvListController.agv();
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
        return "MAXIMUM WEIGHT SUPPORTED | MAXIMUM VOLUME SUPPORTED";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    public String headline() {
        return "AGV list";
    }
}