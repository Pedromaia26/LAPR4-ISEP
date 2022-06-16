package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.OrderLine;
import eapli.framework.domain.repositories.DomainRepository;

public interface OrderLineRepository extends DomainRepository<Long, OrderLine> {
    Double getAllCost(Long orderId);

    Iterable<OrderLine> findOrderLinesByOrderId(Long orderId);

    Iterable<OrderLine> findOrderLinesByOrderIdNotPickedUp(Long orderId);
}
