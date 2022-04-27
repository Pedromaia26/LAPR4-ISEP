package eapli.base.persistence.impl.inmemory;

import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.productmanagement.domain.Brand;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryProductRepository extends InMemoryDomainRepository<Product, InternalCode>
        implements ProductRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Product save(Product product) {
        return product;
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return null;
    }

    @Override
    public Iterable<Product> findByDescription(String description) {
        return null;
    }

    @Override
    public Product findByCode(String productCode) {
        return null;
    }
}
