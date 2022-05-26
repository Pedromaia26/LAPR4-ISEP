package eapli.base.productmanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class ListProductController {

    private final ListProductService svc = new ListProductService();

    public Iterable<Product> allProducts() {
        return svc.allProducts();
    }

    public Product findByCode(String productCode) {
        return svc.findByCode(productCode);
    }

    public Product findByReference(String productReference) {
        return svc.findByReference(productReference);
    }
}
