package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.visitor.Visitor;

public class AGVPrinter implements Visitor<AGV> {

    @Override
    public void visit(final AGV visitee) {
        System.out.printf("%-10d|%-10d", visitee.MaximumWeight(), visitee.Volume());
    }

}
