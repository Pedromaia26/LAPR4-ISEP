package eapli.base.app.user.console.presentation.product;

import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.framework.visitor.Visitor;

public class ShoppingCartPrinter  implements Visitor<ShoppingCartLine> {

    @Override
    public void visit(final ShoppingCartLine visitee) {
        System.out.printf("%-10s | %-7s | %-7s | %-12s | %-5s | %-5s€", visitee.Product().Reference(), visitee.Product().Category().CategoryDescription(), visitee.Product().Brand(), visitee.Product().ShortDescription(), visitee.Quantity(),
                visitee.UnitPrice());
    }
}
