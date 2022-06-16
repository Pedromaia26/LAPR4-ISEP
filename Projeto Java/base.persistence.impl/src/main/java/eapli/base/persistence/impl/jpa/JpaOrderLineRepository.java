package eapli.base.persistence.impl.jpa;

import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.domain.ProductOrder;
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

    @Override
    public Iterable<OrderLine> findOrderLinesByOrderId(Long orderId){
        final TypedQuery<OrderLine> query = super.createQuery(
                "SELECT d FROM OrderLine d WHERE ProductOrder_Id = " + orderId,
                OrderLine.class);

        return query.getResultList();
    }

    @Override
    public Iterable<OrderLine> findOrderLinesByOrderIdNotPickedUp(Long orderId){
        final TypedQuery<OrderLine> query = super.createQuery(
                "SELECT d FROM OrderLine d WHERE ProductOrder_Id = " + orderId + "and ProductStatus = 1",
                OrderLine.class);

        return query.getResultList();
    }
}
