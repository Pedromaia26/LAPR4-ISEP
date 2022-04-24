package eapli.base.productmanagement.application;

import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ShortDescription;
import eapli.framework.general.domain.model.Description;

public class SearchProductDescriptionController {
    private final SearchProductDescriptionService svc = new SearchProductDescriptionService();

    public Iterable<Product> listarProductDescription(ShortDescription description) {
        return this.svc.listarProductDescription(description);
    }
}
