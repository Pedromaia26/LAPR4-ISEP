package eapli.base.persistence.impl.inmemory;

import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.CategoryCode;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.CategoryRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCategoryRepository  extends InMemoryDomainRepository<Category, CategoryCode>
        implements CategoryRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Category save(Category category) {
        return category;
    }
}
