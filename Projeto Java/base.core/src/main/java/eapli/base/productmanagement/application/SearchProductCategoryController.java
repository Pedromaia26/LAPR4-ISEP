package eapli.base.productmanagement.application;

import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Product;

public class SearchProductCategoryController{
    private final SearchProductCategoryService svc = new SearchProductCategoryService();

    public Iterable<Product> listarProductCategory(CategoryCode code) {
        return this.svc.listarProductCategory(code);
    }
}
