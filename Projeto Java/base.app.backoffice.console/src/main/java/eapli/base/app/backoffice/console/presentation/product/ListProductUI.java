package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListProductUI extends AbstractListUI<Product>
{
    private final ListProductController theController = new ListProductController();

    @Override
    protected Iterable<Product> elements() {
        return this.theController.allProducts();
    }

        @Override
        protected Visitor<Product> elementPrinter() {
        return new ProductPrinter();
    }

        @Override
        protected String elementName() {
        return "Product";
    }

        @Override
        protected String listHeader() {
        return "INTERNAL CODE | SHORT DESCRIPTION | BRAND | PRICE";
    }

        @Override
        protected String emptyMessage() {
        return "No data.";
    }

        @Override
        public String headline() {
        return "List products";
    }
}