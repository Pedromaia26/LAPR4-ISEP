package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.*;

public class JpaOrderRepository extends JpaAutoTxRepository<ProductOrder, Long, Long>
        implements OrderRepository {


    public JpaOrderRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    public JpaOrderRepository(TransactionalContext autoTx){
        super(autoTx, "id");
    }


    @Override
    public ProductOrder findByOrderId(Long orderId) {
                final TypedQuery<ProductOrder> query = super.createQuery(
                "SELECT d FROM ProductOrder d WHERE id = '" + orderId + "'",
                ProductOrder.class);

        return query.getSingleResult();
    }

    @Override
    public Iterable<ProductOrder> findProductOrdersPrepared() {
        final TypedQuery<ProductOrder> query = super.createQuery(
                "SELECT d FROM ProductOrder d WHERE status_id = 5",
                ProductOrder.class);

        return query.getResultList();
    }
}

