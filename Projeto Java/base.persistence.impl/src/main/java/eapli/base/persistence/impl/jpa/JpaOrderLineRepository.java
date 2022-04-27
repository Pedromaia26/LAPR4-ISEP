package eapli.base.persistence.impl.jpa;

import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;

import javax.persistence.*;

public class JpaOrderLineRepository extends BasepaRepositoryBase<OrderLine, Long, Long>
        implements OrderLineRepository {

    JpaOrderLineRepository() {
        super("name");
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("eapli.base");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    @Override
    public OrderLine save(OrderLine orderLine) {
        if (orderLine == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(orderLine);
        tx.commit();
        em.close();

        return orderLine;
    }

    @Override
    public int getAllCost(Long orderId) {
        final TypedQuery<Integer> query = super.createQuery(
                "SELECT SUM(unitPrice) FROM OrderLine WHERE order_id = '" + orderId + "'",
                Integer.class);

        return query.getSingleResult();
    }
}
