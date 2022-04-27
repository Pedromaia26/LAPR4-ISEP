package eapli.base.persistence.impl.jpa;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;

import javax.persistence.*;

public class JpaOrderRepository extends BasepaRepositoryBase<ProductOrder, Long, Long>
        implements OrderRepository {

    JpaOrderRepository() {
        super("id");
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("eapli.base");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    @Override
    public ProductOrder save(ProductOrder order) {
        if (order == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(order);
        tx.commit();
        em.close();

        return order;
    }

    @Override
    public ProductOrder findByOrderId(Long orderId) {
        final TypedQuery<ProductOrder> query = super.createQuery(
                "SELECT d FROM ProductOrder d WHERE id = '" + orderId + "'",
                ProductOrder.class);

        return query.getSingleResult();
    }


}

