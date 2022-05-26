package eapli.base.app.user.console.presentation.product;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.visitor.Visitor;

public class ProductCartPrinter implements Visitor<Product> {

    @Override
    public void visit(final Product visitee) {
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-4s€", visitee.Reference(), visitee.Category().CategoryDescription(), visitee.ShortDescription(),
                visitee.Brand(), visitee.Price());
    }
}
