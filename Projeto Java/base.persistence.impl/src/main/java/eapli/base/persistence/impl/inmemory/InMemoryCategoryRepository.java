package eapli.base.persistence.impl.inmemory;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.repositories.CategoryRepository;
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
