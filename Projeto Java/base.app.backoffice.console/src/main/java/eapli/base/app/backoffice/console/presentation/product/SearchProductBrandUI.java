package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.application.SearchProductBrandController;
import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class SearchProductBrandUI extends AbstractListUI<Product>
{
    private final SearchProductBrandController theController = new SearchProductBrandController();

    @Override
    protected Iterable<Product> elements() {
        final String brandread = Console.readLine("Brand:");
        Brand brand = new Brand(brandread);

        return this.theController.listarProductBrand(brand);
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
        return "Search products by brand";
    }
}