package eapli.base.persistence.impl.inmemory;

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
}
