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
        super("id");
    }

    @Override
    public Double getAllCost(Long orderId) {
        final TypedQuery<Double> query = super.createQuery(
                "SELECT SUM(unitPrice*quantity) FROM OrderLine WHERE productorder_id = '" + orderId + "'",
                Double.class);

        return query.getSingleResult();
    }
}
