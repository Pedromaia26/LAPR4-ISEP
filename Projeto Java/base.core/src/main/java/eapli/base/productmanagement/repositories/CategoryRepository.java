package eapli.base.productmanagement.repositories;

import eapli.base.productmanagement.domain.Category;
import eapli.base.productmanagement.domain.CategoryCode;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

public interface CategoryRepository extends DomainRepository<CategoryCode, Category> {

    /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
    public Category save(Category entity);
}
