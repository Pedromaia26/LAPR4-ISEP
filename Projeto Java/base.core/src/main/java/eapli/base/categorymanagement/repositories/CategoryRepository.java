package eapli.base.categorymanagement.repositories;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.framework.domain.repositories.DomainRepository;

public interface CategoryRepository extends DomainRepository<CategoryCode, Category> {

    /* /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
   /* public Category save(Category entity);*/

    public Iterable<Category> findAll();

    public Category findByCode(String categoryCode);

}
