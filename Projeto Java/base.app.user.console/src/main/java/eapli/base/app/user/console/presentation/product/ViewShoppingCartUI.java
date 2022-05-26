package eapli.base.app.user.console.presentation.product;

import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.base.shoppingcartmanagement.application.ListShoppingCartController;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ViewShoppingCartUI extends AbstractListUI<ShoppingCartLine>
{
    private final ListShoppingCartController theController = new ListShoppingCartController();

    @Override
    protected Iterable<ShoppingCartLine> elements() {
        return this.theController.allLines();
    }

    @Override
    protected Visitor<ShoppingCartLine> elementPrinter() {
        return new ShoppingCartPrinter();
    }

    @Override
    protected String elementName() {
        return "Product";
    }

    @Override
    protected String listHeader() {
        return "REFERENCE | CATEGORY | BRAND | DESCRIPTION | QUANTITY | UNIT PRICE";
    }

    @Override
    protected String emptyMessage() {
        return "We didn't found any ";
    }

    @Override
    public String headline() {
        return "List products";
    }
}
