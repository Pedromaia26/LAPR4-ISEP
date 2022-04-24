package eapli.base.persistence.impl.jpa;

import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.repositories.ProductRepository;

import javax.persistence.*;

public class JpaProductRepository extends BasepaRepositoryBase<Product, InternalCode, InternalCode>
        implements ProductRepository {

    JpaProductRepository() {
        super("name");
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("eapli.base");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    @Override
    public Product save(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(product);
        tx.commit();
        em.close();

        return product;
    }

    @Override
    public Iterable<Product> findAll() {
        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT d FROM Product d", Product.class);

        return query.getResultList();
    }

    public Iterable<Product> findByBrand(String brand) {
        final TypedQuery<Product> query = super.createQuery(
                "SELECT d FROM Product d WHERE brand = '" + brand + "'",
                Product.class);

        return query.getResultList();
    }

    public Iterable<Product> findByDescription(String description) {
        final TypedQuery<Product> query = super.createQuery(
                "SELECT d FROM Product d WHERE shortdescription = '" + description + "'",
                Product.class);

        return query.getResultList();
    }
}
