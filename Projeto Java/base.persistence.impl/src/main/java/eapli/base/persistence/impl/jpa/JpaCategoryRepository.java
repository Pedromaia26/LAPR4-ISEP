package eapli.base.persistence.impl.jpa;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.repositories.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaCategoryRepository extends BasepaRepositoryBase<Category, CategoryCode, CategoryCode>
        implements CategoryRepository {

    JpaCategoryRepository() {
        super("name");
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("eapli.base");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    @Override
    public Category save(Category category) {
        if (category == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(category);
        tx.commit();
        em.close();

        return category;
    }
}
