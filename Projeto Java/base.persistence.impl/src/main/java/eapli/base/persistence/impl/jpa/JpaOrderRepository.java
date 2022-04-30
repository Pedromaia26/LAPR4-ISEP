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

    @Override
    public ProductOrder findByOrderId(Long orderId) {
        final TypedQuery<ProductOrder> query = super.createQuery(
                "SELECT d FROM ProductOrder d WHERE id = '" + orderId + "'",
                ProductOrder.class);

        return query.getSingleResult();
    }
}

