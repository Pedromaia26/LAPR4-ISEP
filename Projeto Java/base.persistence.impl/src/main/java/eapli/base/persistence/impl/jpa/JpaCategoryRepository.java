package eapli.base.persistence.impl.jpa;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.productmanagement.domain.Product;

import javax.persistence.*;

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
    public Iterable<Category> findAll() {
        final TypedQuery<Category> query = entityManager().createQuery(
                "SELECT d FROM Category d", Category.class);

        return query.getResultList();
    }

    @Override
    public Category findByCode(String categoryCode) {
        final TypedQuery<Category> query = super.createQuery(
                "SELECT d FROM Category d WHERE categoryCode = '" + categoryCode + "'",
                Category.class);


        return query.getSingleResult();
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
