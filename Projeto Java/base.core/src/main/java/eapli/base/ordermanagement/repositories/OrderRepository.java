package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.domain.repositories.DomainRepository;

public interface OrderRepository extends DomainRepository<Long, ProductOrder> {

    ProductOrder findByOrderId(Long id);

    Iterable<ProductOrder> findProductOrdersPrepared();
}
