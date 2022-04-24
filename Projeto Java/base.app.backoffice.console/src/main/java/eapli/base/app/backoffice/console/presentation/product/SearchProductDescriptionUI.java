package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.productmanagement.application.SearchProductDescriptionController;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ShortDescription;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class SearchProductDescriptionUI extends AbstractListUI<Product>
{
    private final SearchProductDescriptionController theController = new SearchProductDescriptionController();

    @Override
    protected Iterable<Product> elements() {
        final String descriptionread = Console.readLine("Short description:");
        ShortDescription description = new ShortDescription(descriptionread);

        return this.theController.listarProductDescription(description);
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
        return "Search products by description";
    }
}