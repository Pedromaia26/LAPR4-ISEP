package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.domain.repositories.DomainRepository;

public interface OrderRepository extends DomainRepository<Long, ProductOrder> {

    ProductOrder findByOrderId(Long id);

    ProductOrder findOrderByAGVId (String id);

    Iterable<ProductOrder> findProductOrdersPrepared();

    Iterable<ProductOrder> findProductOrdersDispatched();

    Iterable<ProductOrder> findProductOrdersToBePrepared();

    ProductOrder findPreparedOrderById(Long id);

    ProductOrder findRegisteredOrderById(Long id);

    ProductOrder findDispatchedOrderById(Long id);

    Iterable<ProductOrder> findOrderByClientVat(String clientVat);
}
