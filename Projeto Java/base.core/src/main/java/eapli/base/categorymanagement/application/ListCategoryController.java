package eapli.base.categorymanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class ListCategoryController {

    private final ListCategoryService svc = new ListCategoryService();

    public Iterable<Category> allCategories() {
        return svc.allCategories();
    }

    public Category findByCode(String categoryCode) {
        return svc.categoryByCode(categoryCode);
    }
}
