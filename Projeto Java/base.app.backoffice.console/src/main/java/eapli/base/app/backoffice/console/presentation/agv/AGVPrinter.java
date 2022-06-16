package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.visitor.Visitor;

public class AGVPrinter implements Visitor<AGV> {

    @Override
    public void visit(final AGV visitee) {
        System.out.printf("%-10s|%-10f|%-10f|%-10s",visitee.identity().AgvIdentifier(), visitee.MaximumWeight().maximumWeight(), visitee.Volume().volume(), visitee.Task().description().Description());
    }

}
