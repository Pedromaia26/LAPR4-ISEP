package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.visitor.Visitor;

public class ProductPrinter implements Visitor<Product> {

    @Override
    public void visit(final Product visitee) {
        System.out.printf("%-10s|%-10s|%-10s|%-4s€", visitee.InternalCode(), visitee.ShortDescription(),
                visitee.Brand(), visitee.Price());
    }
}
