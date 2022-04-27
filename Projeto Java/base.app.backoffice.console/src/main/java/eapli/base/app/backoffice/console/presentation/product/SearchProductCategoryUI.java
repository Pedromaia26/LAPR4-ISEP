package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.productmanagement.application.SearchProductCategoryController;
import eapli.base.productmanagement.application.SearchProductDescriptionController;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ShortDescription;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class SearchProductCategoryUI extends AbstractListUI<Product>
{
    private final SearchProductCategoryController theController = new SearchProductCategoryController();

    @Override
    protected Iterable<Product> elements() {
        final String categoryread = Console.readLine("Category code:");
        CategoryCode code = new CategoryCode(categoryread);

        return this.theController.listarProductCategory(code);
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