package eapli.base.productmanagement.application;

import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.Product;

public class SearchProductBrandController{
        private final SearchProductBrandService svc = new SearchProductBrandService();

        public Iterable<Product> listarProductBrand(Brand brand) {
            return this.svc.listarProductBrand(brand);
        }
}
